package com.example.myapp.Dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TodoRespDto {
    private Long id;
    private String title;
    private String description;
    private boolean completed;
}
