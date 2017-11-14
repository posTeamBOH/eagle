package com.choice.eagle.entity;

import org.springframework.stereotype.Component;

/**
 * 桌子
 * @author S_eve
 *
 */
@Component
public class Table {
    private String tablesId;

    private String tablesType;
    
    public String getTablesId() {
        return tablesId;
    }

    public void setTablesId(String tablesId) {
        this.tablesId = tablesId;
    }

    public String getTablesType() {
        return tablesType;
    }

    public void setTablesType(String tablesType) {
        this.tablesType = tablesType == null ? null : tablesType.trim();
    }
}