package com.isaac.conversationplatform.web.controller;

/**
 * Created by isaac on 2016/10/27.
 */

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/user")
public class UserController {

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView helloWorld() {

        ModelAndView model = new ModelAndView("welcome");
        model.addObject("msg", "hello world");

        return model;
    }
}