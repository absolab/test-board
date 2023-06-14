package kr.co.dtaas.test.board;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class TestBoardApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestBoardApplication.class, args);
	}

}
