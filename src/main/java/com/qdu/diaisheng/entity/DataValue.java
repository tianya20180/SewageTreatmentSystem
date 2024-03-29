package com.qdu.diaisheng.entity;

import java.sql.Date;
import java.sql.Timestamp;

/**
 * @Autor wangxi
 * @Description 数据值实体类 对应数据库data_value表
 * @Date 2019/7/22
 *
 */


public class DataValue{
    private int dataValueId;//数据id
    private DataPoint dataPoint;//数据点
    private String createTime;
    private Float value;

    @Override
    public String toString() {
        return "DataValue{" +
                "dataValueId='" + dataValueId + '\'' +
                ", dataPoint=" + dataPoint +
                ", createTime=" + createTime +
                ", value=" + value +
                '}';
    }

    public int getDataValueId() {
        return dataValueId;
    }

    public void setDataValueId(int dataValueId) {
        this.dataValueId = dataValueId;
    }

    public DataPoint getDataPoint() {
        return dataPoint;
    }

    public void setDataPoint(DataPoint dataPoint) {
        this.dataPoint = dataPoint;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public Float getValue() {
        return value;
    }

    public void setValue(Float value) {
        this.value = value;
    }
}
