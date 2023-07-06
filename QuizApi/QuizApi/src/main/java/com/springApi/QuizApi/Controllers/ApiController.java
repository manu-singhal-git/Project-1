package com.springApi.QuizApi.Controllers;

import com.springApi.QuizApi.model.Quizzes;
import com.springApi.QuizApi.repository.QuizRepository;
import com.springApi.QuizApi.service.ApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Array;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class ApiController {
    @Autowired
    private ApiService apiService;
    @Autowired
    private QuizRepository repository;



    @PostMapping("/quizzes")
    public List<Quizzes> AddQuiz(@RequestBody Quizzes quiz){

        apiService.AddQuiz(quiz);
        return apiService.AllQuizzes();


    }
    @GetMapping("/quizzes/active")
    public List<Quizzes> ActiveQuiz(){
        List<Quizzes> arr=new ArrayList<>();
        arr=apiService.ActiveQuizzes();
        return arr;


    }
    @GetMapping("/quizzes/{id}/result")
    public Quizzes result(@PathVariable("id") Long id){
        return apiService.IdQuiz(id);

           }
    @GetMapping("/quizzes/all")
    public List<Quizzes> Allquizzes()
    {
        List<Quizzes> arr=new ArrayList<>();
        arr=apiService.AllQuizzes();
        return arr;
    }
    @Scheduled(fixedDelay = 15000)
    public void check() throws ParseException {
        repository.statusCheck();
    }
}
