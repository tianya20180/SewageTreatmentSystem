package com.qdu.diaisheng.service;

import com.qdu.diaisheng.entity.DataModel;
import org.springframework.stereotype.Service;

import java.util.List;

public interface DataModelService {
    List<DataModel> getDataModelByDeviceId(String deviceId);
    int addDataModel(DataModel dataModel);
    int deleteDataModel(int dataModelId);
    int updateDataModel(String dataModelName,int dataModelId);
}
