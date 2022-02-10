package br.com.spring.springapicalcularfrete;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@SpringBootApplication
@RestController
@RequestMapping("/")
public class SpringapicalcularfreteApplication {

	@GetMapping
	public ModelAndView swaggerUi() {

		return new ModelAndView("redirect:/swagger-ui/");
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringapicalcularfreteApplication.class, args);
	}

}




