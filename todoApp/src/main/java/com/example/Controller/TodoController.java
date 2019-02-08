package com.example.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TodoController {

    @RequestMapping(value = "/foo", method = RequestMethod.GET)
    public String sayHello(){
        return "<p> Hello </p> </p><form action='/todos' method='post'> <input name='name' type='text'>" +
                "<button> Save </button></form>";
    }

    @RequestMapping(value = "/todos", method = RequestMethod.GET)
    public String getTodos(){
        return "{Buy : Milk , Visit : Doctor}";
    }
}
