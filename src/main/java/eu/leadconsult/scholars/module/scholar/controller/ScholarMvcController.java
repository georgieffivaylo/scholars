package eu.leadconsult.scholars.module.scholar.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@AllArgsConstructor
public class ScholarMvcController {

    @GetMapping("/scholar")
    public String getScholarLandingPage() {
        return "scholar-landing-page";
    }
}
