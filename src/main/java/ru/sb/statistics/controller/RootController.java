package ru.sb.statistics.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RootController {
    @GetMapping(value = "/")
    public String root() {
        return "redirect:login";
    }

    @GetMapping(value = "/after_login")
    public String afterLogin() {
        return "redirect:payments";
    }

    @GetMapping(value = "/login")
    public String login() {
        return "login";
    }

    @GetMapping(value = "/contracts")
    public String contracts() {
        return "contracts";
    }

    @GetMapping(value = "/users")
    public String users() {
        return "users";
    }

    @GetMapping(value = "/roles")
    public String roles() {
        return "roles";
    }

    @GetMapping(value = "/queue")
    public String queue() {
        return "queue";
    }

    @GetMapping(value = "/payments")
    public String payments() {
        return "payments";
    }
}
