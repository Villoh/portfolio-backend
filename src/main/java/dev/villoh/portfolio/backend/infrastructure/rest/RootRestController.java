package dev.villoh.portfolio.backend.infrastructure.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RootRestController {

    @GetMapping("/")
    public String index() {
        return "API Portfolio Backend is running 👨💻";
    }
}