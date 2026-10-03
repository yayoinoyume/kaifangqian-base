<!--
  @description 资助审批电子签章系统
-->

<template>
  <div class="my_ip_address_input">
    <template v-for="index in indexes" :key="index">
      <Input  v-model:value="ipAddress[index]"
                @keyup="handleChange"
                oninput="value=value.replace(/[^\d]/g,'')&&value>255?255:value"/>
    </template>
  </div>
</template>

<script>
import {defineComponent, ref} from "vue";
import {  Input } from 'ant-design-vue';
const indexes=[0,1,2,3]
export default defineComponent({
  name: "MyIpAddressInput",
  components:{Input},
  props: {
    value: {
      type: String,
      default: ""
    }
  },
  setup(props,ctx) {
    const ipAddress = ref([])
    ipAddress.value = props.value.split(".")
    const handleChange = () => {
      console.log(ipAddress.value.join("."))
      ctx.emit("update:value",ipAddress.value.join("."))
    }
    return {
      ipAddress,
      handleChange,
      indexes
    }
  }
})
</script>
<style lang="less" scoped>
.my_ip_address_input {
  border-radius: 4px;
  width:100%;
  display: inline-block;
  border: 1px solid #DCDFE6;

  .el-input {
    width: 24%;

  }

  .el-input__inner {
    border: none !important;
    text-align: center;
  }
}

.my_ip_address_input:hover {
  border-color: #f9f9f9;
}

.my_ip_address_input:focus-within {
  border-color: #f9f9f9;

}
</style>
