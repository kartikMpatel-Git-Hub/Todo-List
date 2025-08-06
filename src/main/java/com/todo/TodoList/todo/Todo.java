package com.todo.TodoList.todo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;


@Entity(name = "tblTodo")
public class Todo {

    @Id
    @GeneratedValue
    @Column(name = "todoId")
    private int id;

    @Column(name = "userName")
    private String userName;

    @Size(min = 10,message = "Enter At least 10 Character")
    @Column(name = "description")
    private String description;

    @FutureOrPresent(message = "Date Must Be In Present Or Future !")
    @Column(name = "localDate")
    private LocalDate targetDate;
    
    @Column(name = "isDone")
    @NotNull(message = "Must Be True Or False")
    private boolean done;

    public Todo(){}

    public Todo(int id, String userName, String description, LocalDate targetDate, boolean done) {
        this.id = id;
        this.userName = userName;
        this.description = description;
        this.targetDate = targetDate;
        this.done = done;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getTargetDate() {
        return targetDate;
    }

    public void setTargetDate(LocalDate targetDate) {
        this.targetDate = targetDate;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    @Override
    public String toString() {
        return "Todo{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", description='" + description + '\'' +
                ", targetDate=" + targetDate +
                ", isDone=" + done +
                '}';
    }

}
