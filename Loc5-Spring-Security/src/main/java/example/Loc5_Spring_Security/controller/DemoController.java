package example.Loc5_Spring_Security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    @GetMapping("/demo")
    public String demo(){
        return "Demo Done" ;
    }

    @GetMapping("/null")
    public String nulll(){
        return "nullll Done" ;
    }
}
