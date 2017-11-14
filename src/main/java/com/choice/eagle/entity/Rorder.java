package com.choice.eagle.entity;

import org.springframework.stereotype.Component;

/**
 * 订单和菜单联系表
 * @author S_eve
 *
 */
@Component
public class Rorder {
    private String rorderId;

    private String orderId;

    private String menuId;

    private String rorderType;

    public String getRorderId() {
        return rorderId;
    }

    public void setRorderId(String rorderId) {
        this.rorderId = rorderId == null ? null : rorderId.trim();
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId == null ? null : orderId.trim();
    }

    public String getMenuId() {
        return menuId;
    }

    public void setMenuId(String menuId) {
        this.menuId = menuId == null ? null : menuId.trim();
    }

    public String getRorderType() {
        return rorderType;
    }

    public void setRorderType(String rorderType) {
        this.rorderType = rorderType == null ? null : rorderType.trim();
    }
}