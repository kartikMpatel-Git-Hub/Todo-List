package com.todo.TodoList.login;

import org.springframework.stereotype.Service;


// Since It Handle Business Logic We Specify Service
@Service
public class AuthenticationService {
    public boolean authenticate(String name,String password){
        return name.equalsIgnoreCase("kartik") && password.equalsIgnoreCase("123");
    }
}
