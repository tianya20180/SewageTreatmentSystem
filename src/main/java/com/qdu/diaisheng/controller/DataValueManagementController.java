package com.qdu.diaisheng.controller;


import com.qdu.diaisheng.DataValueEnum;
import com.qdu.diaisheng.dto.DataValueExecution;
import com.qdu.diaisheng.entity.DataModel;
import com.qdu.diaisheng.entity.DataPoint;
import com.qdu.diaisheng.entity.DataValue;
import com.qdu.diaisheng.entity.Device;
import com.qdu.diaisheng.service.DataModelService;
import com.qdu.diaisheng.service.DataPointService;
import com.qdu.diaisheng.service.DataValueService;
import com.qdu.diaisheng.service.DeviceService;
import com.qdu.diaisheng.util.HttpServletUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class DataValueManagementController {
    @Autowired
    private DataValueService dataValueService;
    @Autowired
    private DataModelService dataModelService;
    @Autowired
    private DataPointService dataPointService;
    @Autowired
    private DeviceService device;

    @RequestMapping(value = "/getvaluebetweendate",method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> getDataValueBetweenDate(HttpServletRequest request){
        Map<String,Object> modelMap=new HashMap<String, Object>();
        String dataPointId= HttpServletUtil.getString(request,"dataPointId");
        String startDate=HttpServletUtil.getString(request,"startDate");
        String endDate=HttpServletUtil.getString(request,"endDate");
        DataValueExecution dve=dataValueService.getDateValueListAtPointIdBetweenDate(startDate,endDate,dataPointId);
        if(dve.getState()== DataValueEnum.SUCCESS.getState()){
            modelMap.put("success",true);
            modelMap.put("dataValue",dve.getDataValueList());
        }else{
            modelMap.put("success",false);
            modelMap.put("errMsg",dve.getStateInfo());
        }
        return modelMap;
    }


    @RequestMapping(value = "/getnowdatavalue",method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> getDataValue(HttpServletRequest request){

        String date=HttpServletUtil.getString(request,"date");
        String deviceId=HttpServletUtil.getString(request,"deviceId");
        Map<String,Object> modelMap=new HashMap<String, Object>();
        DataValueExecution dve= dataValueService.getDataValueByDeviceAndDate(date,deviceId);
        if(dve.getState()== DataValueEnum.SUCCESS.getState()){
            modelMap.put("success",true);
            modelMap.put("dataValue",dve.getDataValueList());
        }else{
            modelMap.put("success",false);
            modelMap.put("errMsg",dve.getStateInfo());
        }
        return modelMap;

    }

    @RequestMapping(value = "/getdatamodel",method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object>getDataModel(HttpServletRequest request){
        Map<String,Object>modelMap=new HashMap<String,Object>();
        String deviceId=HttpServletUtil.getString(request,"deviceId");
        if(deviceId!=null){
           List<DataModel>dataModelList=dataModelService.getDataModelByDeviceId(deviceId);
           if(dataModelList!=null&&dataModelList.size()>0){
               modelMap.put("success",true);
               modelMap.put("dataModelList",dataModelList);
           }else{
               modelMap.put("success",false);
               modelMap.put("errMsg", "数据模板为空");
           }

        }else{
            modelMap.put("success",false);
            modelMap.put("errMsg","设备为空");
        }
         return modelMap;
    }

    @RequestMapping(value = "/getdatapoint",method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> getDataPoint(HttpServletRequest request){
        Map<String,Object>modelMap=new HashMap<String,Object>();
        int dataModelId=HttpServletUtil.getInt(request,"dataModelId");
        if(dataModelId>0){
             List<DataPoint>dataPointList=dataPointService.getDataPointListByDataModelId(dataModelId);
             if(dataPointList!=null&&dataPointList.size()>0){
                 modelMap.put("success",true);
                 modelMap.put("dataPointList",dataPointList);
             }else{
                 modelMap.put("success",false);
                 modelMap.put("errMsg","数据点为空");
             }


        }else{
            modelMap.put("success",false);
            modelMap.put("errMsg","数据模型id错误");
        }

        return modelMap;

    }


}
