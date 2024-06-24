package com.cristobits0101.springboot_webapp.controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cristobits0101.springboot_webapp.models.dto.ParamDto;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api/params")
public class RequestParamsController {

    /**
     * URL parameters: http://localhost:8080/details?hello="hello"
     * URL parameters: http://localhost:8080/details?hello=hello
     */
    @GetMapping("/foo")
    public ParamDto foo(@RequestParam(required = false, defaultValue = "Hola que tal") String message) {
        ParamDto paramDto = new ParamDto();
        // paramDto.setMessage(message != null ? message : "Hola");
        return paramDto;
    }

    @GetMapping("/foo2")
    public ParamDto foo2(@RequestParam String message) {
        ParamDto paramDto = new ParamDto(message);
        return paramDto;
    }

    @GetMapping("/foo3")
    public ParamDto foo2(@RequestParam String message, @RequestParam Integer edad) {
        ParamDto paramDto = new ParamDto(message, edad);
        return paramDto;
    }

    @GetMapping("/foo4")
    public ParamDto foo4(HttpServletRequest request) {

        Integer edad = 0;
        ParamDto paramDto = new ParamDto();

        try {
            edad = Integer.parseInt(request.getParameter("edad"));
        } catch (NumberFormatException e) {

        }

        paramDto.setMessage(request.getParameter("message"));
        // paramDto.setEdad(Integer.parseInt(request.getParameter("edad")));
        paramDto.setEdad(edad);

        return paramDto;
    }

}
