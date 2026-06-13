package eu.leadconsult.scholars.module.scholar.controller;

import eu.leadconsult.scholars.exception.ScholarException;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;

@Controller
@AllArgsConstructor
public class ScholarMvcController {

    @GetMapping("/scholar")
    public String getScholarLandingPage() {
        return "scholar-landing-page";
    }

    @GetMapping("/")
    public void getScholarIndex(HttpServletResponse response) {
        try {
            response.sendRedirect("/scholar");
        } catch (IOException e) {
            throw new ScholarException("Error redirecting to scholar landing page", null);
        }
    }
}
