package com.qdu.diaisheng.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/data")
public class DataAdminController {
    @RequestMapping(value = "/index",method = RequestMethod.GET)
    private String index(){
        return "admin/login";
    }
    @RequestMapping(value = "/test",method = RequestMethod.GET)
    private String test(){
        return "admin/test";
    }
    @RequestMapping(value = "/dataexport",method = RequestMethod.GET)
    private String dataExport(){
        return "admin/table-export";
    }
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    private String dataList(){
        return "admin/List";
    }
}
