package com.iwms.server.entity;

import lombok.Data;

@Data
public class SystemReq {
    private String userId;
    private String factoryId;
    private String userTypeId;
    private String deptId;
    private String empTypeId;
    private String roleUserId;
    private String sysUserId;
}
