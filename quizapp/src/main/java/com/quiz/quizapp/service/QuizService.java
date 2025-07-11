package com.quiz.quizapp.service;

import com.quiz.quizapp.model.Question;
import com.quiz.quizapp.model.Quiz;
import com.quiz.quizapp.repository.QuestionRepository;
import com.quiz.quizapp.repository.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class QuizService {

    @Autowired
    QuizRepository quizRepository;

    @Autowired
    QuestionRepository questionRepository;
    public ResponseEntity<String> createQuiz(String category, Integer numQ, String title) {

        List<Question> questions = questionRepository.findRandomQuestionByCategory(category, numQ);

        Quiz quiz = new Quiz();
        quiz.setTitle(title);
        quiz.setQuestions(questions);
        quizRepository.save(quiz);

        return new ResponseEntity<>("success", HttpStatus.CREATED);
    }

    public ResponseEntity<List<Question>> get(Long id) {
        Optional<Quiz> quiz = quizRepository.findById(id);
        List<Question> question = new ArrayList<>();
        if(!quiz.isEmpty()){
            question = quiz.get().getQuestions();
            return new ResponseEntity<>(question, HttpStatus.OK);
        }

        return new ResponseEntity<>(question, HttpStatus.BAD_REQUEST);
    }
}
