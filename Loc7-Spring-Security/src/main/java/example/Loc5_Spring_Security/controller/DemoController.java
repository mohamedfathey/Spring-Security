package example.Loc5_Spring_Security.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/demo")
public class DemoController {

    @GetMapping("/demo1")
    @PreAuthorize("hasAuthority('read')") // Access allowed for users with "read" authority
    public String test1() {
        return "demo1";
    }

    @GetMapping("/demo2")
    @PreAuthorize("hasAuthority('play')") // Access allowed for users with "play" authority
    public String test2() {
        return "demo2";
    }

    @GetMapping("/demo3")
    @PreAuthorize("hasAuthority('manager')") // Access allowed for users with "manager" authority
    public String test3() {
        return "demo3";
    }
}
