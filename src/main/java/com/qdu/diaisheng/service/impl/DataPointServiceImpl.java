package com.qdu.diaisheng.service.impl;

import com.qdu.diaisheng.dao.DataPointDao;
import com.qdu.diaisheng.entity.DataPoint;
import com.qdu.diaisheng.service.DataPointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DataPointServiceImpl implements DataPointService {
    @Autowired
    DataPointDao dataPointDao;

    @Override
    public List<DataPoint> getDataPointListByDataModelId(int dataModelId) {
        return dataPointDao.queryDataPointListByDataModel(dataModelId);
    }

    @Override
    public String getDataPointName(String pointId) {
        return dataPointDao.getPointNameByPointId(pointId);
    }

    @Override
    public int deleteDataPoint(String dataPointId) {
        return dataPointDao.deleteDataPoint(dataPointId);
    }

    @Override
    public int editdataPoint(String dataPonitId, DataPoint dataPoint) {
        return dataPointDao.updateDataPoint(dataPoint,dataPonitId);
    }

    @Override
    public List<DataPoint> getDataPointByDevice(String deviceId) {
        return dataPointDao.getDataPointbyDevice(deviceId);
    }

}
