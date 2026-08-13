package com.siddh.InterviewPracticeApplication3;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@Controller
@ResponseBody  //if we give this, it will bypass view resolver
public class ControllerCheck {

    @GetMapping("/check")
    public String getName(){
        return "Siddharth"; //will give not found, consider it as a view name, if Siddharth.html is not present, otherwise use @ResponseBody to consider this as data
    }

    @GetMapping("/check2")
    public ModelAndView getName2(){
        Map<String,Object>mp=new HashMap<>();
        mp.put("Name","Rahul");
        return new ModelAndView("JsonViewTemplate",mp);
    }
}
