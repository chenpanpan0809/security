package com.panpan.security.common;

import lombok.Data;

@Data
public  class ResponseResult<T> {

    private Integer code;

    private String msg;

    private Object data;

    private Long count;

    public ResponseResult(Integer code, String msg, Object data, Long count) {
        this.code = code;
        this.msg = msg;
        this.data = data;
        this.count = count;
    }

    public ResponseResult() {

    }

    public static ResponseResult page(Integer code, String msg, Long count, Object data){
        return new ResponseResult(code,msg,data,count);
    }

}
