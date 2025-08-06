package com.todo.TodoList.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @RequestMapping("sayHello")
    @ResponseBody
    public String sayHello(){
        return "Hello How Are You!!";
    }

    @RequestMapping("helloHTML")
    @ResponseBody
    public String helloHTML(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("""
                <html>
                    <head>
                        <title>Hello Html</title>
                    </head>
                    <body>
                        <h1>Hello World From Spring Boot</h1>
                    </body>
                </html>
                """);
        return stringBuilder.toString();
    }

    @RequestMapping("helloHTML-jsp")
    public String helloHTMLJsp(){
        return "sayHello";
    }
}
