package com.qdu.diaisheng.controller;


import com.qdu.diaisheng.DataValueEnum;
import com.qdu.diaisheng.dto.DataValueExecution;
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
        DataValueExecution dve=dataValueService.getDateValueListAtPointIdBetweenDate(dataPointId,startDate,endDate);
        if(dve.getState()== DataValueEnum.SUCCESS.getState()){
            modelMap.put("success",true);
            modelMap.put("dataValue",dve.getDataValueList());
        }else{
            modelMap.put("success",false);
            modelMap.put("errMsg",dve.getStateInfo());
        }
        return modelMap;
    }




}
