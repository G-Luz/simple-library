package gluz;

import gluz.author.controller.AuthorController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class LibraryApplication {

	public static void main(String[] args) {
		SpringApplication.run(LibraryApplication.class, args);
	}

}
