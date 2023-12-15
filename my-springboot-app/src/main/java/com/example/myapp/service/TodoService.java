package com.example.myapp.service;

import com.example.myapp.Dto.TodoReqDto;
import com.example.myapp.Dto.TodoRespDto;
import org.springframework.data.crossstore.ChangeSetPersister;

import java.util.List;

public interface TodoService {
    // add todo
    TodoRespDto add(TodoReqDto todoReqDto);

    TodoRespDto get(Long id) throws ChangeSetPersister.NotFoundException;

    List<TodoRespDto> getAll();
    // update todo
}
