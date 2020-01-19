package com.iwms.server.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

/**
 * 用户
 */
@Document(collection = "role_user")
@Data
@AllArgsConstructor //全参构造
@NoArgsConstructor //无参构造函数
@ToString
public class RoleUser {
    @Id
    private String id;
    private String directorId;//部门主管id
    private String mobile;//手机号
    private String openId;//微信openid 需关注公众号
    private String username;
    private String password;
//    private List<String> subordinateEmpId;//下属员工id
    private String empType;//职位
    private List<FactoryUserTypeMap> factoryUserTypeMapList;//工厂与用户类型的集合
}
