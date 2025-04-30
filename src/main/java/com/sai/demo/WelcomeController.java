package com.sai.demo;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class WelcomeController {

    @GetMapping("/welcome")
    public String GetWelcome() {
        return "get welcome";
    }

    @GetMapping("/welcome/{name}")
    public String GetWelcome(@PathVariable("name") String name) {
        return "get welcome to " + name;
    }

    @PostMapping("/welcome")
    public String PostWelcome() {
        return "post welcome";
    }

    @PostMapping("/welcome/{name}")
    public String PostWelcome(@PathVariable("name") String name) {
        return "post welcome to " + name;
    }

    @PostMapping("/welcomeRequest")
    public String PostWelcomeRequest(@RequestBody String name) {
        return "post request welcome to " + name;
    }

    @RequestMapping(value = "/welcomemap", method = RequestMethod.GET)
    public String MapWelcome() {
        return "map welcome";
    }

    @RequestMapping(value = "/welcomemap/{name}", method = RequestMethod.POST)
    public String MapWelcome(@PathVariable("name") String name) {
        return "map welcome to " + name;
    }

    @RequestMapping(value = "/welcomemap", method = RequestMethod.POST)
    public String MapWelcomeRequest(@RequestBody String name) {
        return "post request welcome to " + name;
    }

    @GetMapping("/add/{first}/{second}")
    public Integer Add(@PathVariable("first") Integer first, @PathVariable("second") Integer second) {
        return first + second;
    }
}
