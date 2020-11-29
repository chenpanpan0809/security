package com.panpan.security.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("T_USER")
public class User {
    @TableId(value = "USERID",type = IdType.AUTO)
    private Integer userid;
    private String username;
    private String password;
    private String phone;
    private Boolean enable;
}
