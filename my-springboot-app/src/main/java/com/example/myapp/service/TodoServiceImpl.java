package com.example.myapp.service;

import com.example.myapp.Dto.TodoReqDto;
import com.example.myapp.Dto.TodoRespDto;
import com.example.myapp.entity.Todo;
import com.example.myapp.repository.TodoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TodoServiceImpl implements TodoService{
    private final TodoRepository todoRepository;
    private final TodoMapper todoMapper;
    private final ObjectMapper objectMapper;

//    @Autowired
//    public TodoServiceImpl(TodoRepository todoRepository, TodoMapper todoMapper) {
//        this.todoRepository = todoRepository;
//        this.todoMapper = todoMapper;
//    }

    // add todo
    @Override
    public TodoRespDto add(TodoReqDto todoReqDto){
        // print todoDto as string
        try {
            System.out.println(objectMapper.writeValueAsString(todoReqDto));
        } catch (Exception e) {
            e.printStackTrace();
        }
        Todo todo = todoRepository.save(todoMapper.toEntity(todoReqDto));
        // print todo as string
        System.out.println(todo);
        return todoMapper.toDto(todo);
    }

    @Override
    public TodoRespDto get(Long id) throws ChangeSetPersister.NotFoundException {
        return todoMapper.toDto(todoRepository.findById(id).orElseThrow(ChangeSetPersister.NotFoundException::new));
    }

    @Override
    public List<TodoRespDto> getAll(){
        return todoMapper.toDtos(todoRepository.findAll());
    }

}