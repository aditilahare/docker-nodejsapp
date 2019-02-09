package com.example.todoApp.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TodoController {

    @RequestMapping(value = "/todos", method = RequestMethod.GET)
    public String getTodos(){
        return "{Title:Buy Milk, Description:Today evening}";
    }

}
