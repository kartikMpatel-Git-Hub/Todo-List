package com.todo.TodoList.todo;

import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class TodoService {
    static int size = 4;
    private static List<Todo> todos = new ArrayList<>();
    static {
        todos.add(new Todo(1,"Kartik","Spring Boot",
                LocalDate.now().plusYears(1),false));
        todos.add(new Todo(2,"keval","Node js",
                LocalDate.now().plusMonths(6),true));
        todos.add(new Todo(3,"manav",".Net",
                LocalDate.now().plusMonths(6),false));
        todos.add(new Todo(4,"Ronak","PHP",
                LocalDate.now().plusMonths(6),false));
    }

    public List<Todo> getTodos() {
        return todos;
    }

    public List<Todo> findByUserName(String userName){
        return todos.stream().filter(todo ->todo.getUserName().equalsIgnoreCase(userName)).toList();
    }

    public void addTodo(String userName, String description, LocalDate targetDate,boolean status){
        todos.add(new Todo(++size,userName,description,targetDate,status));
    }

    public void deleteTodoById(int id){
        todos.removeIf(todo -> todo.getId() == id);
    }

    public Todo findById(int id) {
        return todos.stream().filter(todo -> todo.getId() == id).findFirst().get();
    }

    public void updateTodoById(@Valid Todo todo) {
        todos.stream().forEach(todo1 -> {
            if(todo1.getId() == todo.getId()){
                todo1.setDescription(todo.getDescription());
                todo1.setTargetDate(todo.getTargetDate());
                todo1.setDone(todo.isDone());
            }
        });
    }

    public List<Todo> getTodosByUserName(String name) {
        return todos.stream()
                .filter(todo -> todo.getUserName().equalsIgnoreCase(name))
                .toList();
    }


}
