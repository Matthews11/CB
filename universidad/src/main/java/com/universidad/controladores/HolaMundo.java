package com.universidad.controladores;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest")
public class HolaMundo {

    @GetMapping("/")
    public String hola(){
        return "hola mundo";
    }
}
