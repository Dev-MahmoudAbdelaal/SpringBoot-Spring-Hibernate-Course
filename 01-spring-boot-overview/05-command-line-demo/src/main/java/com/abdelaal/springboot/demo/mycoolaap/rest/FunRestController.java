package com.abdelaal.springboot.demo.mycoolaap.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {
    // inject properities for:coach.name and team.name
    @Value("${coach.name}")
    private  String coachName;
    @Value("${team.name}")
    private  String teamName;

    //expose new endpoint for "teaminfo"
    @GetMapping("/teamInfo")
    public String getTeameInfo() {
        return "Coach"+coachName+", Team name: "+teamName;
    }

    // expose "/" that return "Hello World"
    @GetMapping("/")
    public String sayHello(){
        return "Hello World !";
    }

    //  expose a  new endpoint for "workout"

    @GetMapping("/workout")
    public String getDailyworkout(){
        return "Run a hard sk!";
    }
    //  expose a  new endpoint for "fortune"

    @GetMapping("/fortune")
    public String getDailyFortune(){
        return "Today is your lucky day";

    }

}

