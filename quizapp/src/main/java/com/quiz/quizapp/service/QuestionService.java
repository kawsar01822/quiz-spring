package com.quiz.quizapp.service;

import com.quiz.quizapp.model.Question;
import com.quiz.quizapp.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuestionService {

    @Autowired
    QuestionRepository questionRepository;
    public List<Question> getAllQuestions() {
        return questionRepository.findAll();
    }

    public List<Question> getQuestionsByCategory(String category) {
        return questionRepository.findQuestionsByCategory(category);
    }

    public Question addQuestion(Question question) {
        return questionRepository.save(question);
    }

    public String updateQuestion(Question question) {
        Optional<Question> questionData = questionRepository.findById(question.id);
        if(!questionData.isEmpty()){
            questionRepository.save(question);
            return "Updated successfully";
        }
        return "Question not found";
    }

    public String deleteQuestion(Long id) {
        Optional<Question> question = questionRepository.findById(id);
        if(!question.isEmpty()){
            questionRepository.deleteById(id);
            return "Successfully deleted";
        }
        return "Question not found";
    }
}
