<!--
  @description 企业详情
-->
<template>
	<div class="auth-step form-auth-container" >
		 
	<div class="step-2">
		<div>
			  <van-cell-group inset>
			    <van-field
			      v-model="formData.name"
			      name="name"
			      label="组织机构名称"
				  readonly
			    />
			    <van-field
			      v-model="formData.organizationNo"
			      type="text"
			      name="idCard"
			      label="组织机构代码"
				  readonly
			    />
				<van-field
				  v-model="formData.corporation"
				  name="corporation"
				  label="法人姓名"
				  readonly
				/>
				<van-field
				  v-model="formData.corporationNo"
				  name="corporationNo"
				  label="法人证件号"
				  readonly
				/>
				<van-field
				  v-model="formData.phone"
				  type="text"
				  name="phone"
				  label="法人手机号"
				  readonly
				/>
			  </van-cell-group>
			  <div style="margin: 16px;">
			   <van-button type="primary" block @click="gohome">返回首页</van-button>
			  </div>
		</div>
	</div>
	</div>
</template>

<script lang="ts" setup>
	import { ref ,reactive,onMounted,onBeforeUnmount} from "vue";
	import { useUserStore } from '@/store/modules/user';
	
	const router = useRouter();
	
	const userStore = useUserStore();
	const tenantInfo = userStore.getTenantInfo
	
	 function gohome(){
		router.push("/home");
	 }
	 onMounted(()=>{
	 	formData.value.name = tenantInfo.name;
	 	formData.value.organizationNo = tenantInfo.organizationNo;
	 	formData.value.phone = tenantInfo.phone;
		formData.value.corporation = tenantInfo.corporation;
		formData.value.corporationNo = tenantInfo.corporationNo;
	 })
	 
		
	const formData = ref({
		name:"",
		idCardFace:"",
		idCardEmblem:"",
		organizationNo:"",
		corporation:"",
		corporationNo:"",
		phone:"",
		captcha:"",
		captchaKey:"",
		authType:1,
		realItem:1,
	});
 
	 
	
</script>

<style lang="less" scoped>
	
	.step-1{
	  width: 8rem;
	  margin: 0 auto;
	  .auth-tip-container{
	    display: flex;
	    flex-direction: column;
	  }
	  .tip-title{
	    font-weight: 600;
		text-align: left;
		align-items: left;
		padding: 0;
		margin: 0;
	  }
	  .tip-info{
	    background: #f4f9ff;
	    padding:10px 15px;
	    border-radius: 2px;
	  }
	  .protocol-info{
	    margin:15px 0;
	  }
	}
	.step-2{
		.van-cell-group--inset{
			margin: 0;
		}
	}
</style>