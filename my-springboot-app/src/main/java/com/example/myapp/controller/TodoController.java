package com.example.myapp.controller;

import com.example.myapp.Dto.TodoReqDto;
import com.example.myapp.Dto.TodoRespDto;
import com.example.myapp.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todo")
@RequiredArgsConstructor
public class TodoController {
    private final TodoService todoService;

//    @Autowired
//    public TodoController(TodoService todoService) {
//        this.todoService = todoService;
//    }

    // add todo
    @PostMapping("/add")
    public ResponseEntity<TodoRespDto> add(@RequestBody TodoReqDto todoReqDto){
        return ResponseEntity.ok(todoService.add(todoReqDto));
    }

    // get todo by id
    @GetMapping("/get/{id}")
    public ResponseEntity<TodoRespDto> get(@PathVariable Long id) throws ChangeSetPersister.NotFoundException {
        return ResponseEntity.ok(todoService.get(id));
    }

    // get all todos
    @GetMapping("/get")
    public ResponseEntity<List<TodoRespDto>> getAll(){
        return ResponseEntity.ok(todoService.getAll());
    }
}