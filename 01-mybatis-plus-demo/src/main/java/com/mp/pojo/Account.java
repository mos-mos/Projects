package com.mp.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;


@Data
@TableName("account")
public class Account {

    @TableId(value = "ID",type = IdType.ASSIGN_UUID) //主键策略  uuid
    private String id;
    private String username;
    private String address;
}
