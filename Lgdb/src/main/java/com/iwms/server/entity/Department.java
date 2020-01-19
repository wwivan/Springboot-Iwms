package com.iwms.server.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;

/**
 * 部门
 */
@Data
public class Department {
    @Id
    private String id;
    private String deptName;
}
