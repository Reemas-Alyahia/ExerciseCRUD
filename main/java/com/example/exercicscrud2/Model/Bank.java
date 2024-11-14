package com.example.exercicscrud2.Model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Bank {
    private int id;
    private String name;
    private int balance;
}
