package com.todo.app.service;

import com.todo.app.dto.TodoDto;

import java.util.List;

public interface TodoService {

    TodoDto addTodo(TodoDto todoDto);

    TodoDto getTodoById(Long todoId);

    List<TodoDto> getAllTodos();

    TodoDto updateTodo(TodoDto todoDto, Long todoId);

    void deleteTodo(Long todoId);

    TodoDto completeTodo(Long todoId);

    TodoDto uncompleteTodo(Long todoId);
}
