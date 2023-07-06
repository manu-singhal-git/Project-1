package com.springApi.QuizApi.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Setter
@Getter
@ToString
@Entity
@Table(name="Quizzes")
public class Quizzes {
    @Id
@GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private Long id;
    @Column(name="title")
    private String title;
    @Column(name="question")
    private String question;
    @Column(name="answers")
    private String[] answers;
    @Column(name="status")
    private String status;
    @Column(name="rightIndex")
    private Long rightIndex;
    @Column(name="startTime")
    private String startTime;
    @Column(name = "endTime")
    private String endTime;
}
