<!--
  @description 资助审批电子签章系统
-->

<style scoped>
.page-view {
  height: 100%;
}
</style>

<script lang="tsx">
import BasicKeepAlive from "./BasicKeepAlive.vue";
import {   defineComponent, } from 'vue';

export default defineComponent({
  name: "PageView",
  functional: true,
  props: {
    include: {
      type: Array,
      default: () => [],
    },
  },
  setup(props){
    return  () => {
      return (
      <BasicKeepAlive include={props.include}>
        <transition mode="out-in">
          <router-view />
        </transition>
      </BasicKeepAlive>
    );
    }
  },
});
</script>