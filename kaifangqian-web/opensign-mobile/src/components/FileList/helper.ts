/**
 * @description helper
 */
export function checkFileType(file: File, accepts: string[]) {
    const newTypes = accepts.join('|');
    // const reg = /\.(jpg|jpeg|png|gif|txt|doc|docx|xls|xlsx|xml)$/i;
    const reg = new RegExp('\\.(' + newTypes + ')$', 'i');

    return reg.test(file.name);
}

export function checkImgType(file: File) {
    return isImgTypeByName(file.name);
}

export function isImgTypeByName(name: string) {
    return /\.(jpg|jpeg|png|gif)$/i.test(name);
}

export function getBase64WithFile(file: File) {
    return new Promise<{
        result: string;
        file: File;
    }>((resolve, reject) => {
        const reader = new FileReader();
        reader.readAsDataURL(file);
        reader.onload = () => resolve({ result: reader.result as string, file });
        reader.onerror = (error) => reject(error);
    });
}

export function loadFileType(type: string) {
    let fileIcon: string = 'otherfile';
    if (['png', 'jpg', 'png', 'gif', 'bmp', 'psd', 'tif', 'jfif', 'webp'].includes(type)) {
        fileIcon = 'image'
    }
    if (['mp3', 'flac', 'ape', 'wma', 'wav', 'aac', 'm4a', 'au', 'ram', 'mmf', 'aif', 'alac', 'wavpack', 'ogg', 'vorbis', 'opus'].includes(type)) {
        fileIcon = 'mp'
    }
    if (['mkv', 'mp4', 'avi', 'swf', 'wmv', 'rmvb', 'mov', 'mpg', 'flv', 'f4v'].includes(type)) {
        fileIcon = 'video'
    }
    if (['doc', 'docx', 'ppt', 'pptx', 'wps'].includes(type)) {
        fileIcon = 'word'
    }
    if (['xls', 'xlsx'].includes(type)) {
        fileIcon = 'excel'
    }
    if (['pdf'].includes(type)) {
        fileIcon = 'pdf'
    }
    if (['rar', 'zip'].includes(type)) {
        fileIcon = 'zip'
    }
    return fileIcon
}