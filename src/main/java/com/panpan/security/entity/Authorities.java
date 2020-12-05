package com.panpan.security.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("AUTHORITIES")
public class Authorities {
  @TableId(value = "USERNAME")
  private String username;
  private String authority;


}
