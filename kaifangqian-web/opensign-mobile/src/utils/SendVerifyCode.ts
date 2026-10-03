/**
 * @description : 发送手机验证码
 */
async function sendPhoneCode() {
	    try {
	        await authForm.value.validate("phone");
	        if (duration.value === initDuration) {
	            duration.value = initDuration;
	            const params = {
	                phone: formData.value.phone,
	                type: "login1",
	            }
	            const response = await Api.sendCode(params)
	            if (response.code == 200) {
	                formData.value.captchaKey = response.result;
	                console.log("send res:", response);
	                Notify({ type: 'success', message: '短信发送成功', duration: 1000 });
	                delayCountDown();
	            } else {
	                Notify({ type: 'warning', message: '获取短信验证码失败', duration: 1000 });
	            }
	        } else {
	            return;
	        }
	    } catch (e) {
	        console.error("form field error:", e);
	    }
	}
	const initDuration = 3;
	const duration = ref(3)
	const countdownText = ref("获取验证码");
	const interval = ref<any>(null);
	function delayCountDown() {
	    if (duration.value == 0) {
	        clearTimeout(interval.value);
	        duration.value = 3;
	        countdownText.value = "获取验证码"
	    } else if (duration.value > 0) {
	        clearTimeout(interval.value);
	        countdownText.value = duration.value + "秒后重新获取"
	        duration.value--;
	        interval.value = setTimeout(function () {
	            delayCountDown()
	        }, 1000)
	    }
	}