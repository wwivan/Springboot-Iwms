package com.iwms.server.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.Date;

/**
 * 工厂
 */
@Data
public class Factory {
    @Id
    private String id;//
//    private String fid;//工厂id
    private String logo;// logo
    private String factoryName;//工厂名
    private String administrators;//管理员
    private String address;//地址
    private String tel;// 电话
    private String descn;// 简介
    private String inProcess;// 入库流程  1 入库单-入库验收-上架   2 入库单-上架  3直接入库
    private String outProcess;//出库流程  1 出库单-拣货单-拣货下架-核对-包装   2 出库单-核对-包装  3直接出库
    private String contacts;// 联系人
    private String contactsPhone;// 联系人电话
    private String contactsEmail;// 联系人邮箱
    private String status;// 状态 0关闭 1正常
    private Date createTime;// 创建时间
    private Date lastTime;// 更新时间

}
