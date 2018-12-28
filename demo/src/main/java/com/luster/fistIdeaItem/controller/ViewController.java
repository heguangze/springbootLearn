package com.luster.fistIdeaItem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by dell on 2017-9-1.
 */
@Controller
public class ViewController {
    @RequestMapping("/rtmp")
    public ModelAndView rtmp(){
        return new ModelAndView("rtmp");
    }

    @RequestMapping("/mqtt")
    public ModelAndView mqtt(){
        return new ModelAndView("mqtt");
    }

    @RequestMapping("/test")
    public ModelAndView test(){
        return new ModelAndView("test");
    }


}
