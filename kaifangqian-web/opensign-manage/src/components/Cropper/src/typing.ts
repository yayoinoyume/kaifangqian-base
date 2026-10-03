/*
 * @description 资助审批电子签章系统
 */

import type Cropper from 'cropperjs';

export interface CropendResult {
  imgBase64: string;
  imgInfo: Cropper.Data;
}

export type { Cropper };
