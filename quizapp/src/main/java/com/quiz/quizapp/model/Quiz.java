package com.quiz.quizapp.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@Entity
public class Quiz {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    public String title;

    @ManyToMany
    public List<Question> questions;
}
