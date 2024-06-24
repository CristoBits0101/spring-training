package com.cristobits0101.springboot_webapp.controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.cristobits0101.springboot_webapp.models.Book;
import com.cristobits0101.springboot_webapp.models.dto.ParamDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/book")
public class RequestPathController {

    /**
     * URL path: http://localhost:8080/api/book/values
     */
    @GetMapping("/values")
    public Map<String, Object> values() {
        Map<String, Object> json = new HashMap<>();
        json.put("name", name);
        json.put("password", password);
        json.put("listOfValue", listOfValue);

        // With autowired
        json.put("name2", environment.getProperty("config.name"));

        // Los 2 devuelven un numerico son formas distintas.
        json.put("password2", Integer.valueOf(environment.getProperty("config.password")));
        json.put("password3", environment.getProperty("config.password", Long.class));
        return json;
    }

    /**
     * URL path: http://localhost:8080/api/book/mensaje
     */
    @GetMapping("/foo5/{message}")
    public ParamDto foo5(@PathVariable() String message) {
        ParamDto paramDto = new ParamDto();
        paramDto.setMessage(message);
        paramDto.setEdad(1);
        return paramDto;
    }

    /**
     * URL path: http://localhost:8080/api/book/mensaje/edad
     */
    @GetMapping("/foo6/{message}/{edad}")
    public Map<String, Object> foo6(@PathVariable String message, @PathVariable("edad") Long id) {
        Map<String, Object> json = new HashMap<>();
        json.put("message", message);
        json.put("edad", id);
        return json;
    }

    /**
     * URL path: http://localhost:8080/api/book/create
     */
    @PostMapping("/create")
    public Book saveBook(@RequestBody Book book) {
        return book;
    }

    /**
     * OBTENER VALORES Y DEVOLVERLOS
     */
    @Value("${config.name}")
    private String name;

    @Value("${config.password}")
    private Integer password;

    @Value("${config.listOfValue}")
    private String[] listOfValue;

    /**
     * #{} -> Lenguaje de expresión
     * ${} -> Variable
     * Las comillas simples parsean la lista a String.
     */
    @Value("#{'${config.listOfValue}'.split(',')}")
    private List<String> valueList;

    @Value("${config.listOfValue}")
    private String valueString;

    @Value("#{'${config.valuesMap}}")
    private Map<String, Object> valueMap;

    @Value("#{'${config.valuesMap}.price}")
    private Long valueMapPrice;

    // Inyecta componentes del contenedor Spring (dependencias).
    @Autowired
    private Environment environment;

}
