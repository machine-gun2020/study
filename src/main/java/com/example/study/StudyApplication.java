package com.example.study;

import com.example.study.model.Person;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

@SpringBootApplication
public class StudyApplication {

	public static void main(String[] args) {

		SpringApplication.run(StudyApplication.class, args);
		List<String> secondList = Arrays.asList("Adrian","Marco", "Elsa");
		List<Integer> list = Arrays.asList(8,52,3,76,9,4,1,5,7,9,2);
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

			list
					.stream()
					.max(Comparator.naturalOrder())
					.ifPresent(System.out::println);

			secondList
					.stream()
					.map(str->str.toUpperCase())
					.forEach(System.out::println);

			list
					.stream()
					.filter(x -> x%2 == 0)
					.forEach(System.out::println);

			list
					.stream()
					.sorted(Comparator.reverseOrder())
					.forEach(System.out::println);

			List<Person> people = Arrays.asList(
					new Person("Charly", 72, 'M'),
					new Person("George", 54, 'M'),
					new Person("Jenny", 25, 'F')
			);

			people
					.stream()
					.map (p -> p.getAge())
					.max(Comparator.naturalOrder())
					.ifPresent(System.out::println);

			people
					.stream()
					.filter(x -> Objects.equals(x.getName(), "George"))
					.forEach(System.out::println);
	}

}
