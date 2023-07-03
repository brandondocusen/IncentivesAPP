package spring_initializer_workbrain;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

    @PostMapping("/submitForm")
    public String handleFormSubmission(@RequestParam(name = "message") String message) {
        System.out.println("Received message: " + message);
        return "Received message: " + message;
    }
}