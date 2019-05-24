package com.pgssoftware.springmvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Application {

    @GetMapping()
    public String hello(Model model) {
        return "hello";
    }
}
