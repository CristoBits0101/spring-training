package com.cristobits0101.springboot_webapp.models.dto;

public class ParamDto {

    private String message;
    private Integer edad;

    public ParamDto() {
    }

    public ParamDto(String message) {
        this.message = message;
    }

    public ParamDto(String message, Integer edad) {
        this.message = message;
        this.edad = edad;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

}
