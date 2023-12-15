package com.example.myapp.service;

import com.example.myapp.Dto.TodoReqDto;
import com.example.myapp.Dto.TodoRespDto;
import com.example.myapp.entity.Todo;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TodoMapper {
//    @Mapping(source = "todo.id", target = "id")
//    @Mapping(source = "todo.title", target = "title")
//    @Mapping(source = "todo.description", target = "description")
//    @Mapping(source = "todo.completed", target = "completed")
    TodoRespDto toDto(Todo todo);

//    @Mapping(source = "todoDto.title", target = "title")
//    @Mapping(source = "todoDto.description", target = "description")
//    @Mapping(source = "todoDto.completed", target = "completed")
    Todo toEntity(TodoReqDto todoReqDto);

    List<TodoRespDto> toDtos(List<Todo> all);
}
