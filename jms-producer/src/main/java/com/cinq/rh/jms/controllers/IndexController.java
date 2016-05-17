package com.cinq.rh.jms.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class IndexController {

    @RequestMapping("/index")
	@ResponseBody
    public String index() {
		System.out.println("IndexController");
        return "index";
    }

}