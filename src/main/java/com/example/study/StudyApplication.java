package com.example.study;

import ch.qos.logback.core.net.SyslogOutputStream;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class StudyApplication {

	public static void main(String[] args) {

		SpringApplication.run(StudyApplication.class, args);

		List<Integer> list = Arrays.asList(2,52,3,76,9,4);
		Integer max = list
				.stream()
				.mapToInt(x -> x)
				.max()
				.getAsInt();
			System.out.println(max);

			list
					.stream()
					.findAny()
					.ifPresent(System.out::println);

	}

}
