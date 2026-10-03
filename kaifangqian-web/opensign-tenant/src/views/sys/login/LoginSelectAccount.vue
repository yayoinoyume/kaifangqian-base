<!--
  @description 资助审批电子签章系统
-->

/*
 * @Author: ningw 
 * @Date: 2022-06-28 18:22:10 
 * @Last Modified by: ningw
 * @Last Modified time: 2022-12-26 11:42:00
 */
<template>
  <div>
    <BasicModal v-bind="$attrs" @register="registerModal" title="请选择部门" @ok="handleSubmit" :footer="null">
        <template #title>
          <div  @click="handleBack">
            <a-button type="text" ><Icon icon="ant-design:left-outlined"/>返回</a-button>
          </div>
        </template>
        <p class="login-title">选择您的身份登录</p>
        <div class="account-list">
          <div v-for="(item,index) in accountList.list">
              <div class="account-item" @click="handleSubmit(item)">
                <p :key="index" class="company-header">{{item.departName}}</p>
                <div class="account-depart" v-for="(deptItem,deptIndex) in item.depts" :key="deptIndex">
                  <span >{{ deptItem.deptName }}</span>
                 <Icon icon="ant-design:arrow-right-outlined"/>

                </div>
              </div>
          </div>
        </div>
    </BasicModal>
  </div>
</template>
<script lang='ts'>
import { defineComponent,ref,unref, reactive } from 'vue'
import { BasicModal,useModalInner } from '/@/components/Modal';
import { FormSchema } from '/@/components/Table';
// import { BasicForm, useForm } from '/@/components/Form';
// import { getAccountList } from '/@/api/sys/user'
import { Icon } from '/@/components/Icon';
import { useUserStore } from '/@/store/modules/user';
import { useMessage } from '/@/hooks/web/useMessage';


const selectSchema:FormSchema[] = [
  {
    field: 'orgCode',
    label: '组织',
    component: 'Select',
    colProps: { span: 24 },
    required:false,
    componentProps: {
      options: [],
      // params:{
      //   token:'dfd'
      // },
      // api: getAccountList,
      fieldNames:{
        label:'departName',
        value: 'orgCode'
      },
      immediate:false
    },
  },
]
interface Dept {
  [propName: string]: string | number
}
interface Company {
  departName:string,
  depts:Dept[]
}
export default defineComponent({
  name: 'LoginSelectAccount',
  components:{
    BasicModal,
    // BasicForm,
    Icon
  },
  setup(_,{emit}){
      const userStore = useUserStore();
      const { notification } = useMessage();
      const isUpdate = ref(true);
      const token = ref();
      const accountList = reactive({list:Array<Company>});
      const [registerModal, { setModalProps, closeModal }] = useModalInner(async (data) => {
          // resetFields();
          setModalProps({ confirmLoading: false,width:500,canFullscreen:false, closable:false,maskClosable:false,centered:true });
          isUpdate.value = !!data?.isUpdate;
          const tokenValue = unref(data).record.token;
          token.value = tokenValue;
          unref(data).record.departs.map(item => {
            item.depts= [
              {deptName:'产品研发部'},
              {deptName:'信息科技部'},
              {deptName:'总裁办'},
            ]
          })
          console.log(unref(data).record.departs,'--部门--')
          accountList.list = unref(data).record.departs;

          // updateSchema({field:'orgCode',componentProps:{
          //   options: unref(data).record.departs,
          //   // params:{
          //   //   token:tokenValue  
          //   // },
          //   // api: getAccountList,
          //   fieldNames:{
          //     label:'departName',
          //     value: 'orgCode'
          //   },
          // }})
      });
      // const [registerForm, {resetFields,updateSchema, validate }] = useForm({
      //   labelWidth: 50,
      //   schemas: selectSchema,
      //   showActionButtonGroup: false,
      //   actionColOptions: {
      //     span: 23,
      //   },
      // });
      async function handleSubmit(item){
        // 获取表单信息
        // const formData = await validate()
        const formData = {
          orgCode:item.orgCode
        }
        const userInfo = await userStore.selectTenant(formData);
        if(userInfo){
            notification.success({
              message: '登录成功',
              description: `${'登录成功'}: ${userInfo.username}`,
              duration: 3,
            });
            closeModal()
        }
      }
      function handleBack(){
        emit('success')
      }
    return {
      registerModal,
      // registerForm,
      handleSubmit,
      accountList,
      handleBack
    }
  },
})
</script>
<style lang="less" scoped>
.login-title{
  font-size: 18px;
}
.account-list{
  overflow: auto;
    max-height: 250px;
    .account-item{
      font-size: 14px;
      border: 1px solid #f9f9f9;
      border-radius: 8px;
      cursor: pointer;
      align-items: center;
      justify-content: space-between;
      margin-right: 10px;
      .company-header{
        background: #f9f9f9;
        padding: 15px 10px;
      }
      .account-depart{
        display: flex;
        margin-bottom: 10px;
        justify-content: space-between;
        padding: 0 20px;
        &:hover{
          color: #094aee ;
        }
      }
      &:active{
        box-shadow: inset -7px -6px 12px rgb(255 255 255 / 90%), inset 0px -1px 10px rgb(0 0 0 / 40%) 
      }
    }
}
 
</style>
