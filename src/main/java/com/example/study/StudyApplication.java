package com.example.study;

import com.example.study.model.Person;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.*;
import java.util.function.*;

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
					new Person("George", 55, 'M'),
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



		Optional<String> name1 = Optional.ofNullable(paymentType.returnMayment());
		name1.ifPresentOrElse(
				name -> System.out.println("Person2's name is: " + name),
				() -> System.out.println("Person2 has no name")
		);



		EjemploExtendsAbstract ejemploExtendsAbstract = new EjemploExtendsAbstract();
		ejemploExtendsAbstract.salidaEjemplo();
		System.out.println(ejemploExtendsAbstract.cuenta(2));
		System.out.println(paymentType.salidasasd(2));


		Optional<Integer> myNumber = Optional.of(ejemploExtendsAbstract.cuenta(2));
		myNumber.ifPresentOrElse(
				number -> System.out.println("the winner number is: " + myNumber),
				() -> System.out.println("myNumber has no value")
		);

		int[] numbers = {1, 3, 4, 5, 2, 7, 6, 5, 4, 3, 2};
		Map<Integer, Integer> frequencyMap = new HashMap<>();

		for (int number : numbers) {
			if (frequencyMap.containsKey(number)) {
				frequencyMap.put(number, frequencyMap.get(number) + 1);
			} else {
				frequencyMap.put(number, 1);
			}
		}

		for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
			System.out.println("Number " + entry.getKey() + " appears " + entry.getValue() + " times.");
		}

		List<String> list2 = Arrays.asList("a", "b", "c");
		System.out.println("List: " + list2);

		// Set.of() equivalent
		Set<String> set = new HashSet<>(Arrays.asList("a", "b", "c","b"));
		System.out.println("Set: " + set);

		// Map.of() equivalent
		Map<String, Integer> map = new HashMap<>();
		map.put("a", 1);
		map.put("b", 2);
		map.put("c", 3);
		map.put("a", 4);
		Map<String, Integer> unmodifiableMap = Collections.unmodifiableMap(map);
		System.out.println("Map: " + unmodifiableMap);

		HiloEjemplo hiloEjemplo = new HiloEjemplo();


		EjemploEjecutable ejemploEjecutable = new EjemploEjecutable();
		Thread thread = new Thread(ejemploEjecutable);
		hiloEjemplo.start();
		thread.start();

		// Predicate<T>
		Predicate<Integer> isEven = n -> n % 2 == 0;
		System.out.println("Is 4 even? " + isEven.test(4));
		System.out.println("Is 7 even? " + isEven.test(7));

		// Function<T, R>
		Function<String, Integer> stringLength = s -> s.length();
		System.out.println("Length of 'hello': " + stringLength.apply("hello"));

		// Consumer<T>
		Consumer<String> print = s -> System.out.println(s);
		print.accept("Hello, World!");

		// Supplier<T>
		Supplier<String> stringSupplier = () -> "Supplied String";
		System.out.println(stringSupplier.get());

		// UnaryOperator<T>
		UnaryOperator<Integer> square = n -> n * n;
		System.out.println("Square of 5: " + square.apply(5));

		// BinaryOperator<T>
		BinaryOperator<Integer> sum = (a, b) -> a + b;
		System.out.println("Sum of 3 and 5: " + sum.apply(3, 5));

		Map<Integer, Integer> frecuency = new HashMap<>();
		for(int num : numbers) {
			if(frecuency.containsKey(num)) {
				frecuency.put(num, frecuency.get(num) + 1);
			} else {
				frecuency.put(num, 1);
			}
		}
		for(Map.Entry<Integer, Integer> ent : frecuency.entrySet()){
			//System.out.println( ent.getKey() + ", " + ent.getValue() + " times");
			System.out.println("Numerous " + ent.getKey() + " appears " + ent.getValue() + " times ");
		}
	}
}
