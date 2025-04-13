package com.alberto.springcoredemo.rest;

import com.alberto.springcoredemo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    //define a private field for the dependency
    private Coach myCoach;

 /*   private  Coach anotherCoach;*/
    //define a constructor for dependency injection
/*    @Autowired
    public DemoController(Coach theCoach) {
        myCoach = theCoach;
    }*/
   /* @Autowired
   public DemoController(
            @Qualifier("baseballCoach") Coach theCoach,
             @Qualifier("trackCoach") Coach theAnotherCoach) {
        System.out.println("In constructor: " + getClass().getSimpleName());

        myCoach = theCoach;
        anotherCoach = theAnotherCoach;
    }*/

    //define a setter method for dependency injection
    @Autowired
    public void DemoController(@Qualifier("acuatic") Coach theCoach) {
        System.out.println("In constructor: " + getClass().getSimpleName());
        myCoach = theCoach;
    }
/*    @GetMapping("/check")
    public String check() {
        return "Compairing the two coaches: " + (myCoach == anotherCoach);
    }*/

    //expose a "/dailyworkout" endpoint
    @GetMapping("/dailyworkout")
    public String getDailyWorkout() {
        return myCoach.getDailyWorkout();
    }
}
