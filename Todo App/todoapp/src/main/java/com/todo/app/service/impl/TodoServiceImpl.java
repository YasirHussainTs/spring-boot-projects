package com.todo.app.service.impl;

import com.todo.app.dto.TodoDto;
import com.todo.app.entity.Todo;
import com.todo.app.repository.TodoRepository;
import com.todo.app.service.TodoService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class TodoServiceImpl implements TodoService {

    private TodoRepository todoRepository;

    @Override
    public TodoDto addTodo(TodoDto todoDto) {
        Todo todo = new Todo();
        todo.setTitle(todoDto.getTitle());
        todo.setDescription(todoDto.getDescription());
        todo.setCompleted(todoDto.isCompleted());

        Todo savedTodo = todoRepository.save(todo);

        TodoDto savedTodoDto = new TodoDto();
        savedTodoDto.setId(savedTodo.getId());
        savedTodoDto.setTitle(savedTodo.getTitle());
        savedTodoDto.setDescription(savedTodo.getDescription());
        savedTodoDto.setCompleted(savedTodo.isCompleted());

        return savedTodoDto;
    }

    @Override
    public TodoDto getTodoById(Long todoId) {

        Todo todo = todoRepository.findById(todoId)
                .orElseThrow(() -> new RuntimeException("Todo not Found with id: " + todoId));

        return null;

    }

    @Override
    public List<TodoDto> getAllTodos() {
        return List.of();
    }

    @Override
    public TodoDto updateTodo(TodoDto todoDto, Long todoId) {
        return null;
    }

    @Override
    public void deleteTodo(Long todoId) {

    }

    @Override
    public TodoDto completeTodo(Long todoId) {
        return null;
    }

    @Override
    public TodoDto uncompleteTodo(Long todoId) {
        return null;
    }


}
