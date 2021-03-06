package ru.experrt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@SpringBootApplication
@EnableJpaAuditing
public class ExperrtBudgetApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(ExperrtBudgetApplication.class, args);
		//System.out.println("test");
	getStartPage();
	}
	
	@RequestMapping(value = "/")
    public static String getStartPage() {
        return "veiw/main";
    }
	
	
}
