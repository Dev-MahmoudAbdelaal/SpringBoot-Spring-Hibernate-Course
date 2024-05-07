package com.luv2code.springcoredemo.rest;

import com.luv2code.springcoredemo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class DemoController {
    // define a private field for the dependency
    private Coach mycoach;
    private Coach anotherCoach;


// define a constructor for dependency injection

@Autowired
public void DemoController(
        @Qualifier("cricketCoach") Coach thecoach,
        @Qualifier("cricketCoach")Coach theAnotherCoach ){
    anotherCoach=theAnotherCoach;
    mycoach=thecoach;
}

    @GetMapping("/dailyworkout")
    public String getDailyWorkout(){
        return mycoach.getDailyWorkout();
    }
    @GetMapping("Check")
    public String check(){
    return "Comparing beans: myCoach == anotherCoach "+(mycoach==anotherCoach);
    }

}
