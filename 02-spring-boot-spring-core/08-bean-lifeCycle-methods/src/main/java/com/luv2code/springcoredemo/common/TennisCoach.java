package com.luv2code.springcoredemo.common;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach{
    public TennisCoach() {
        System.out.println("In Constructor "+getClass().getSimpleName());

    }

    @Override
    public String getDailyWorkout(){
        return "practice your backhand volley";
    }
}
