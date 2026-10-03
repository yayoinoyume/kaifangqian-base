<!--
  @description 资助审批电子签章系统
-->

<script lang="tsx">
  import { defineComponent, CSSProperties, watch, nextTick } from 'vue';
  import { fileListProps } from './props';
  import { loadFileType } from './helper';
  import { SvgIcon } from '/@/components/Icon';
  import { Icon } from '/@/components/Icon';
  import ThumbUrl from './ThumbUrl.vue';
  import { handleDownload } from '/@/utils';
  import { FileItem } from './typing';
  import { useModalContext } from '/@/components/Modal/src/hooks/useModalContext';

  export default defineComponent({
    name: 'FileList',
    props: fileListProps,
    setup(props,{emit}) {
      const modalFn = useModalContext();
      watch(
        () => props.dataSource,
        () => {
          nextTick(() => {
            modalFn?.redoModalHeight?.();
          });
        },
      );
      return () => {
        const { dataSource } = props;
        const  handleRemove = (e,record) => {
          e.stopPropagation();
          emit('remove',record);
        }
        return (
          <div class="upload-file-list">
            {
              dataSource.map((record = {}) => {
                const { thumbUrl } = (record as FileItem) || {};
                {/* console.log( loadFileType(record.type), (loadFileType(record.type)=='image' && thumbUrl)?1:2,'文件类型') */}
                console.log(record,'=====')
                //回显时没有type类型从文件名截取
                if(!record.type){
                  record.type = record.name?record.name.split('.')[1]:record.realName&&record.realName.split('.')[1]
                }
                if(record?.responseData&&record?.responseData.result){
                  record.id = record?.responseData.result;
                }
                return(
                  <div class="file-item">
                    <div class="file-item-type-name">
                      {
                        (loadFileType(record.type)=='image' && thumbUrl)?
                          <ThumbUrl fileUrl={thumbUrl} />
                       :<SvgIcon name={loadFileType(record.type)} size="38"></SvgIcon>
                      }
                       <span class="file-name">{record.name || record.realName}</span>
                    </div>
                    <div class="file-item-action">
                      <Icon icon="ant-design:download-outlined" size="20" color="#999" onClick={(e)=>handleDownload({id:record.annexId?record.annexId:record.id,realName:record.name || record.realName})}></Icon>
                      <Icon icon="ant-design:delete-outlined"  size="20" color="#999" onClick={(e)=>handleRemove(e,record)}></Icon>
                    </div>
                  </div>
                )
              })
            }
          </div>
        );
      };
    },
  });
</script>
<style lang="less">
  .file-table {
    width: 100%;
    border-collapse: collapse;

    .center {
      text-align: center;
    }

    .left {
      text-align: left;
    }

    .right {
      text-align: right;
    }

    &-th,
    &-td {
      padding: 12px 8px;
    }
    &-th{
      border-left:none;
      border-right:none;
    }

    thead {
      background-color: @background-color-light;
    }
    .file-table-tr{
      font-size: 12px;
    }

    table,
    td,
    th {
      border: 1px solid @border-color-base;
    }
  }
  .upload-file-list{
    display:flex;
    margin-top:10px;
    flex-wrap: wrap;

    .file-item{
      display: flex;
      align-items: center;
      border: 1px solid #d9d9d9;
      padding: 6px 15px;
      width: 550px;
      justify-content: space-between;
      margin-right: 20px;
      border-radius: 4px;
      margin-bottom:10px;
      .file-item-type-name{
        display:flex;
        align-items:center;
      }
      .file-item-action{
        visibility: hidden;
        cursor: pointer;
      }
      &:hover .file-item-action{
        visibility: visible;
      }

    }
    .file-name{
      margin-left:15px;
      max-width: 300px;
      white-space: nowrap;
      overflow: hidden;
      text-overflow: ellipsis
    }
  }
</style>
