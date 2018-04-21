package com.ssm.controller;

import com.ssm.exception.NoException;
import com.ssm.service.AScService;
import com.ssm.utils.Msg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
public class AScController{
    @Autowired
    AScService aScService;

    @RequestMapping(value = "/queryMaxAndMin",method = RequestMethod.GET)
    @ResponseBody
    public Msg queryMaxAndMin(){
        try {
            List<Map<String,Object>> list =aScService.queryAvg();

            System.out.println(list);
            return Msg.success().add("list",list);
        }catch (NoException ne){
            throw ne;
        }
    }
}
