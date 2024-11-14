package com.example.exercisecrud.Model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Tracker {
    private int id;
    private String title;
    private String description;
    private String status;
}
