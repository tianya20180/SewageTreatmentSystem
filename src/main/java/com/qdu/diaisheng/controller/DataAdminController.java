package com.qdu.diaisheng.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/dataadmin")
public class DataAdminController {
    @RequestMapping(value = "/index",method = RequestMethod.GET)
    private String index(){
        return "admin/index";
    }
    @RequestMapping(value = "/test",method = RequestMethod.GET)
    private String test(){
        return "admin/test";
    }
}
