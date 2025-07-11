package com.quiz.quizapp.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    public String questionTitle;
    public String option1;
    public String option2;
    public String option3;
    public String option4;
    public String rightAnswer;
    public String difficultyLevel;
    public String category;
}
