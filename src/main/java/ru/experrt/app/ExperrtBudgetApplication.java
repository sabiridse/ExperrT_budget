package ru.experrt.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@SpringBootApplication
public class ExperrtBudgetApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExperrtBudgetApplication.class, args);
	getStartPage();
	}
	@RequestMapping(value = "/")
    public static String getStartPage() {
        return "veiw/main";
    }
}
