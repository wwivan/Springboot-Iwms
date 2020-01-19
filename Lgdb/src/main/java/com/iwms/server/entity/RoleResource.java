package com.iwms.server.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.List;

/**
 * 角色资源
 */
@Data
public class RoleResource {
    @Id
    private String id;
    private RoleResource parent;
    private String resourceName;
    private List<RoleResource> children;
}
