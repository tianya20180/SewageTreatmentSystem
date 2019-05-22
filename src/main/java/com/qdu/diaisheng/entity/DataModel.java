package com.qdu.diaisheng.entity;

import java.util.Date;
//数据模型实体类
public class DataModel {
    private Integer dataModelId;//数据模型Id
    private String dataModelName;//数据模型名
    private Device device;//关联设备
    private Date createTime;//创建时间

    public Integer getDataModelId() {
        return dataModelId;
    }

    public void setDataModelId(Integer dataModelId) {
        this.dataModelId = dataModelId;
    }

    public String getDataModelName() {
        return dataModelName;
    }

    public void setDataModelName(String dataModelName) {
        this.dataModelName = dataModelName;
    }

    public Device getDevice() {
        return device;
    }

    public void setDevice(Device device) {
        this.device = device;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
