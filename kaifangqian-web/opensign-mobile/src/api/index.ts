/**
 * @description header
 */

import session from "@/utils/cache/session"
import { APP_AUTHORIZED_TOKEN, APP_TOKEN, APP_REALNAME_TOKEN } from "@/utils/cache/constant"
import http, { Response } from '@/utils/http';

export const appHeader = () => {
    return {
        headers: {
            "Resrun-App-Code": "opensign_0001",
            "X-Access-Token": session.getItem(APP_TOKEN)
        }
    }
}
export const uploadHeader = () => {
    return {
        headers: {
            "Resrun-App-Code": "opensign_0001",
            "X-Access-Token": session.getItem(APP_TOKEN),
            "Content-Type": "multipart/form-data"
        }
    }
}
export const authHeader = () => {
    return {
        headers: {
            "Resrun-App-Code": "opensign_0001",
            "X-Access-Token": session.getItem(APP_AUTHORIZED_TOKEN)
        }
    }
}
export const realNameHeader = () => {
    return {
        headers: {
            "Resrun-App-Code": "opensign_0001",
            "X-Access-Token": session.getItem(APP_REALNAME_TOKEN)
        }
    }
}

export const getImgCode = async (params: any) => {
    return await http.get<Response>('/sys/randomImage/' + params, {});
}



export const download = (record: any, byId = true) => {
    const token = session.getItem(APP_TOKEN);
    const req = new XMLHttpRequest();
    let url = byId ? import.meta.env.VITE_PROXY_ADDRESS + '/file/downloadFileStream/' + record.id : import.meta.env.VITE_PROXY_ADDRESS + '/file/downloadFileStream2/' + record.realName;
    req.open('GET', url, true);
    req.responseType = 'blob';
    req.setRequestHeader('X-Access-Token', token);
    req.setRequestHeader('Resrun-App-Code', 'opensign_0001');
    req.onload = function () {
        const data = req.response;
        const blob = new Blob([data], { type: 'application/octet-stream' });
        let fileName = decodeURI(
            req?.getResponseHeader('filename') || "",
        );
        let dom = document.createElement('a')
        let url = window.URL.createObjectURL(blob)
        dom.href = url
        dom.download = decodeURI(record.realName || fileName)
        dom.style.display = 'none'
        document.body.appendChild(dom)
        dom.click()
        dom && dom?.parentNode?.removeChild(dom)
        window.URL.revokeObjectURL(url)
    };
    req.send();
}

export async function uploadFile(file: any, params?: any) {
    const formData = new FormData(); // 创建FormData对象
    formData.append('file', file); // 将文件添加到FormData对象中
    if (params) {
        Object.keys(params).forEach((key) => {
            const value = params![key];
            formData.append(key, value);
        });
    }
    return await http.upload("/file", formData, uploadHeader())
}