/**
 * @description session存储封装
 */
import axios, { AxiosResponse, AxiosRequestConfig, AxiosError } from 'axios';
import type { Response } from './types';
// import { auth } from '@/utils';
import { Toast, Notify } from 'vant';
import router from '@/router';
import session from "@/utils/cache/session"
import { APP_TOKEN } from '@/utils/cache/constant';
axios.defaults.timeout = 1000 * 60;
axios.defaults.headers.post['Content-Type'] = 'application/x-www-form-urlencoded;charset=UTF-8';


// 创建axios实例
const service = axios.create({
    // 根据不同env设置不同的baseURL
    baseURL: import.meta.env.VITE_APP_API_BASE_URL,
});

// axios实例拦截请求
service.interceptors.request.use(
    (config: AxiosRequestConfig) => {
        // const appToken = session.getItem(APP_TOKEN)
        const signTaskId = session.getItem('sign_task_id')
        // const appCode = import.meta.env.VITE_GLOB_APP_CODE;
        // console.log(signTaskId, 'signTaskId---------------')

        config.headers = {
            ...config.headers,
            // "X-Access-Token": appToken,
            // "Resrun-App-Code": appCode,
            "Sign-Task-Id": signTaskId,
            // ...auth.headers(), // 你的自定义headers，如token等
        };
        if (config.method === 'get') {
            config.params = {
                _t: new Date().getTime(), // 时间戳
                ...config.params
            }
        }
        return config;
    },
    (error: AxiosError) => {
        return Promise.reject(error);
    }
);

// axios实例拦截响应
service.interceptors.response.use(
    // 2xx时触发
    (response: AxiosResponse<Response>) => {
        // response.data就是后端返回的数据，结构根据你们的约定来定义
        const { code, message } = response.data;
        let errMessage = '';
        switch (code) {
            case 200:
                break;
            case 401: // token过期
                errMessage = '登录状态失效，请重新登录';
                // session.clear()
                router.push('/login');
                break;
            case 402: // 无权限
                errMessage = 'No permission';
                break;
            default:
                errMessage = message;
                break;
        }
        if (errMessage) {
            Notify({ type: 'danger', message: errMessage });
        }
        return response;
    },
    // 非2xx时触发
    (error: AxiosError) => {
        console.log(error, '错误数据')
        Notify({ type: 'danger', message: 'Network Error...' });
        if (error.response && error.response.status === 401) {
            // 处理 HTTP 状态码为 401 的情况
            // 可以在这里进行跳转登录页面、刷新 token 等操作
            Notify({ type: 'danger', message: '登录状态失效，请重新登录' });
            localStorage.clear()
            router.push('/login');
            setTimeout(() => {
                location.reload()
            }, 1000)
        }

        return Promise.reject(error);
    }
);

export type { AxiosResponse, AxiosRequestConfig };

export default service;
