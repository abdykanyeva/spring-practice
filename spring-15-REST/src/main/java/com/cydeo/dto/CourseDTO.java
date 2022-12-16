package com.cydeo.dto;


import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
public class CourseDTO {

    private Long id;
    private String name;
    private String category;
    private int rating;
    private String description;

}
