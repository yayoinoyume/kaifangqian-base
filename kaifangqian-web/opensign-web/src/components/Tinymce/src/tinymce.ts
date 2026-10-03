/*
 * @description 资助审批电子签章系统
 */

// Any plugins you want to setting has to be imported
// Detail plugins list see https://www.tinymce.com/docs/plugins/
// Custom builds see https://www.tinymce.com/download/custom-builds/
// colorpicker/contextmenu/textcolor plugin is now built in to the core editor, please remove it from your editor configuration
// preview 

// preview 存在时 image插件不生效 不能直接复制图片到编辑框


export const plugins = [
  'advlist image anchor autolink autosave code codesample '
   +'directionality  fullscreen hr insertdatetime link lists '
   +'media nonbreaking noneditable pagebreak paste'
   +'print save searchreplace  tabfocus  template  textpattern visualblocks visualchars wordcount',
];


export const toolbar = [
  'fontsizeselect lineheight  image searchreplace bold italic underline strikethrough alignleft aligncenter alignright outdent indent  blockquote undo redo removeformat subscript superscript code codesample',
  'hr bullist numlist link  preview anchor pagebreak insertdatetime media  forecolor backcolor fullscreen',
];
