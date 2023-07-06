package com.springApi.QuizApi.service;

import com.springApi.QuizApi.model.Quizzes;
import com.springApi.QuizApi.repository.QuizRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ApiService {
    @Autowired
    private QuizRepository repository;
   //ArrayList<Quizzes> arr=new ArrayList<>();

    public List<Quizzes> AllQuizzes(){
       /* Quizzes quiz=new Quizzes();
        quiz.setTitle("quiz1");
        quiz.setQuestion("Who is prime minister of India");
        quiz.setAnswers(new String[]{"Narendra Modi","Rahul Gandhi","Indira Gandhi","Jawaharlal Nehru"});
        quiz.setRightIndex(0L);
        quiz.setStatus("active");
        quiz.setId(1L);
        arr.add(quiz);
        Quizzes quiz1=new Quizzes();
        quiz1.setTitle("quiz2");
        quiz1.setQuestion("Who is minister of India");
        quiz1.setAnswers(new String[]{"Narendra Modi","Rahul Gandhi","Indira Gandhi","Jawaharlal Nehru"});
        quiz1.setRightIndex(0L);
        quiz1.setStatus("inactive");
        quiz1.setId(2L);
        arr.add(quiz1);
        return arr;*/
    return repository.getAllQuizzes();

    }
    public List<Quizzes> ActiveQuizzes(){
        List<Quizzes> actives=repository.getAllQuizzes();
        List<Quizzes> arr=new ArrayList<>();
        for(int i=0;i<actives.size();i++){
            if(actives.get(i).getStatus().equals("active")){
                arr.add(actives.get(i));
            }
        }
        return arr;


    }
   public Quizzes IdQuiz(Long id){
       List<Quizzes> arr=repository.getAllQuizzes();
       for(int i=0;i<arr.size();i++){
           if(arr.get(i).getId()==id)
               return arr.get(i);
       }
       return null;
    }
    public void AddQuiz(Quizzes quiz){
        repository.createPost(quiz);
    }

}
