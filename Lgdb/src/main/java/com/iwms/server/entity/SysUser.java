package com.iwms.server.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class SysUser {
    @Id
    private String id;
    private String userName;
    private String password;
    private String fid;
}
