package com.qdu.diaisheng.entity;

import java.util.Date;

public class Device {
    private String deviceId;//设备ID
    private String deviceName;//设备名
    private Date createTime;//设备创建时间

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
