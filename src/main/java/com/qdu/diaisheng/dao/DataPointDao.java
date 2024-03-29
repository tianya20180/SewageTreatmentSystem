package com.qdu.diaisheng.dao;

import com.qdu.diaisheng.entity.DataPoint;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DataPointDao {
    int insertDataPoint(DataPoint dataPoint);
    List<DataPoint> queryDataPointListByDataModel(Integer dataModelId);//通过数据模板获取数据点 暂时用不到
    String getPointNameByPointId(String pointId);
    int deleteDataPoint(String dataPonitId);
    int updateDataPoint(@Param("dataPoint")DataPoint dataPoint,
                        @Param("dataPointId")String dataPointId);
    List<DataPoint> getDataPointbyDevice(String deviceId);//通过设备获取数据模板

}
