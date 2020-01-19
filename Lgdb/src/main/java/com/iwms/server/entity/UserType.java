package com.iwms.server.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class UserType {
    @Id
    private String id;
    private String type;
}
