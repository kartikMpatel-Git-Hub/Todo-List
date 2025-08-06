package com.todo.TodoList.todo;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.time.LocalDate;
import java.util.List;

//@Controller
@SessionAttributes("name")
public class TodoController {

    TodoService todoService;

    public TodoController(TodoService todoService) {
        super();
        this.todoService = todoService;
    }

    @RequestMapping(value = "getTodos",method = RequestMethod.GET)
    public String getTodos(ModelMap modelMap){
        List<Todo> todos =  todoService.getTodosByUserName(getLoggedInUserName());
        modelMap.put("todos",todos);
        return "listTodos";
    }

    @RequestMapping(value = "addTodo",method = RequestMethod.GET)
    public String addTodosPage(ModelMap modelMap){
        String userName = getLoggedInUserName();
        Todo todo = new Todo(0,userName,"",LocalDate.now(),false);
        modelMap.put("todo",todo);
        return "addTodo";
    }

    @RequestMapping(value = "addTodo",method = RequestMethod.POST)
    public String addTodo(ModelMap modelMap, @Valid Todo todo, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            System.out.println(bindingResult.getAllErrors());
            return "addTodo";
        }
        String userName = getLoggedInUserName();
        if (userName == null){
            return "login";
        }
        todoService.addTodo(userName,
                            todo.getDescription(),
                            todo.getTargetDate(),
                            false);
        return "redirect:getTodos";
    }

    @RequestMapping(value = "deleteTodo", method = RequestMethod.GET)
    public String deleteTodo(@RequestParam int id){
        todoService.deleteTodoById(id);
        return "redirect:getTodos";
    }

    @RequestMapping(value = "updateTodo",method = RequestMethod.GET)
    public String updateTodoPage(@RequestParam int id,ModelMap modelMap){
        Todo todo = todoService.findById(id);
        modelMap.addAttribute("todo",todo);
        return "addTodo";
    }
    @RequestMapping(value = "updateTodo",method = RequestMethod.POST)
    public String updateTodo(@RequestParam int id, ModelMap modelMap, @Valid Todo todo, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            System.out.println(bindingResult.getAllErrors());
            return "addTodo";
        }
        todoService.updateTodoById(todo);
        return "redirect:getTodos";
    }

    private String getLoggedInUserName(){
        return SecurityContextHolder.getContext().getAuthentication().getName();
    }
//    @RequestMapping(value = "addTodo",method = RequestMethod.POST)
//    public String addTodos(@RequestParam String description,ModelMap modelMap){
//        String userName = (String) modelMap.get("name");
//        if(userName.equals("") || description.equals("")){
//            modelMap.put("error","Enter Description First ! Or Login First !!");
//            return "addTodo";
//        }
//        todoService.addTodo(userName,
//                            description,
//                            LocalDate.now().plusMonths(6),
//                            false);
//        return "redirect:getTodos";
//    }
}
