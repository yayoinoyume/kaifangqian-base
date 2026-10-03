/*
 * @description 资助审批电子签章系统
 */

function registerGolbSensitive(){
  window.addEventListener(
    'click',
    function (event) {
      console.log(event.target,'点击对象')
    },
    true,
  );
}


/**
 * Configure global error handling
 * @param app
 */
 export function setupSensitiveHandle() {


  // Static resource exception
  registerGolbSensitive();
}
