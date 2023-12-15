package com.example.myapp.Dto;

import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TodoReqDto {
    private String title;
    private String description;
    private boolean completed;
}
