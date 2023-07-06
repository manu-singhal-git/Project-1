package com.springApi.QuizApi.repository;

import com.springApi.QuizApi.model.Quizzes;
import jakarta.persistence.*;
import org.springframework.stereotype.Repository;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Repository
public class QuizRepository {
    @PersistenceUnit(unitName = "quizkey")
    private EntityManagerFactory emf;
    public Quizzes createPost(Quizzes newQuiz) {

        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();

        try {

            transaction.begin();
            em.persist(newQuiz);
            transaction.commit();


        }catch(Exception e) {
            transaction.rollback();

        }

        return newQuiz;
    }
    public List<Quizzes> getAllQuizzes(){
        EntityManager em=emf.createEntityManager();
        TypedQuery<Quizzes> query=em.createQuery("SELECT p from Quizzes p",Quizzes.class);
        List<Quizzes> resultList=query.getResultList();
        return resultList;
    }
    public void statusCheck() throws ParseException {
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        TypedQuery<Quizzes> query=em.createQuery("SELECT p from Quizzes p",Quizzes.class);
        List<Quizzes> resultList=query.getResultList();
        SimpleDateFormat formatter1=new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

        for(int i=0;i<resultList.size();i++){
            if(new Date().after(formatter1.parse(resultList.get(i).getStartTime()))&&new Date().before(formatter1.parse(resultList.get(i).getEndTime()))){
                resultList.get(i).setStatus("active");
            }
            else
                resultList.get(i).setStatus("inactive");
            try {
                transaction.begin();
                em.merge(resultList.get(i));
                transaction.commit();
            }catch(Exception e) {
                transaction.rollback();
            }


        }


    }


}
