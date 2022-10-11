package com.isquibly.model;

import lombok.*;

import java.time.LocalDate;

@Data
@EqualsAndHashCode(of="id")
public class Todo {
    private int id;
    @NonNull
    private String title, details;
    @NonNull
    private LocalDate deadline;
}
