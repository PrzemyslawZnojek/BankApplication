package main.com.java.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AccessController {

    @GetMapping("/access-denied")
    public String showAccessDeniedPage(){
        return "access-denied-form";
    }
}
