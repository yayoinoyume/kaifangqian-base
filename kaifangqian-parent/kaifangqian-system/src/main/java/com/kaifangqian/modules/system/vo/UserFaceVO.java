package com.kaifangqian.modules.system.vo;

import lombok.Data;

@Data
public class UserFaceVO {

    private String url;
    private String orderNo;

    public UserFaceVO(String url, String orderNo) {
        this.url = url;
        this.orderNo = orderNo;
    }
    public UserFaceVO() {
    }

}
