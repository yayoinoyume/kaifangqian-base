<!--
  @description 个人详情
-->
<template>
	<div class="personal">
		  <van-cell-group inset>
		    <van-field
		      v-model="formData.name"
		      name="name"
		      label="姓名"
			  readonly
		      placeholder="请输入姓名"
		    />
		    <van-field
		      v-model="formData.organizationNo"
		      type="text"
			  readonly
		      name="idCard"
		      label="身份证号"
		    />
			<van-field
			  v-model="formData.phone"
			  type="text"
			  readonly
			  name="phone"
			  label="手机号"
			/>
		  </van-cell-group>
		  <div style="height: 20px;"></div>
		  <van-button type="primary" block @click="gohome">返回首页</van-button>
	</div>
</template>

<script lang="ts" setup>
	import { ref ,reactive,onMounted,onBeforeUnmount} from "vue";
	import { useUserStore } from '@/store/modules/user';
	const router = useRouter();
	const userStore = useUserStore();
	const tenantInfo = userStore.getTenantInfo
	const formData = ref({
		name:"",
		idCardFace:"",
		idCardEmblem:"",
		organizationNo:"",
		phone:"",
		captcha:"",
		captchaKey:""
	});
	
	onMounted(()=>{
		formData.value.name = tenantInfo.name;
		formData.value.organizationNo = tenantInfo.organizationNo;
		formData.value.phone = tenantInfo.phone;
	})
	function gohome(){
		router.push("/home");
	}
	
	
  
</script>

<style lang="less" scoped>
	.personal{
		.van-cell-group--inset{
			margin: 0;
		}
	}
</style>