package com.example.study;

import com.example.study.model.Person;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.*;

@SpringBootApplication
public class StudyApplication {

	public static void main(String[] args) {
		int li = 0;
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
					.map(String::toUpperCase)
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
					new Person("Charly", 32, 'M'),
					new Person("George", 54, 'M'),
					new Person("Jenny", 25, 'F')
			);

			people
					.stream()
					.map (Person::getAge)
					.max(Comparator.naturalOrder())
					.ifPresent(System.out::println);

			people
					.stream()
					.filter(x -> Objects.equals(x.getName(), "George"))
					.forEach(System.out::println);

		PaymentType paymentType = new PaymentType();
		paymentType.type();
		paymentType.obtaintPayment();
		String Name = paymentType.returnMayment();


		Optional<String> name1 = Optional.ofNullable(paymentType.returnMayment());
		name1.ifPresentOrElse(
				name -> System.out.println("Person2's name is: " + name),
				() -> System.out.println("Person2 has no name")
		);



		EjemploExtendsAbstract ejemploExtendsAbstract = new EjemploExtendsAbstract();
		ejemploExtendsAbstract.salidaEjemplo();
		System.out.println(ejemploExtendsAbstract.cuenta(2));
		System.out.println(paymentType.salidasasd(2));

	}

}
