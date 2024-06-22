package com.cristobits0101.springboot_webapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
// import java.util.Map;

@Controller
public class UserController {

    /**
     * @return details template
     */
    // @GetMapping("/details")
    // public String details() {
    // return "details";
    // }

    /**
     * @param model
     * @return details template
     */
    // @GetMapping("/details")
    // public String details(Map<String, Object> model) {
    //     model.put("name", "Cristo");
    //     model.put("lastname", "Suárez");
    //     return "details";
    // }

    /**
     * @param model
     * @return details template
     */
    @GetMapping("/details")
    public String details(Model model) {
        model.addAttribute("name", "Cristo");
        model.addAttribute("lastname", "Suárez");
        return "details";
    }

}
