package com.example.study;
import com.example.study.controller.WordController;
import com.example.study.model.Person;
import com.example.study.service.ExampleService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class StudyApplicationTest {

	private List<String> secondList;
	private List<Integer> list;
	private List<Person> people;

	@BeforeEach
	public void setup() {

	}



	@BeforeEach
	void setUp() {
		secondList = Arrays.asList("Adrian", "Marco", "Elsa");
		list = Arrays.asList(8, 52, 3, 76, 9, 4, 1, 5, 7, 9, 2);
		people = Arrays.asList(
				new Person("Charly", 32, 'M'),
				new Person("George", 55, 'M'),
				new Person("Jenny", 25, 'F')
		);
	}

	@Test
	void testMaxValueInList() {
		Integer max = list.stream().mapToInt(x -> x).max().getAsInt();
		assertEquals(76, max);
	}

	@Test
	void testFindAnyInList() {
		Optional<Integer> any = list.stream().findAny();
		assertTrue(any.isPresent());
	}

	@Test
	void testMaxUsingComparator() {
		Optional<Integer> max = list.stream().max(Comparator.naturalOrder());
		assertTrue(max.isPresent());
		assertEquals(76, max.get());
	}

	@Test
	void testNamesToUpperCase() {
		List<String> upperCaseNames = new ArrayList<>();
		secondList.stream().map(String::toUpperCase).forEach(upperCaseNames::add);
		assertEquals(Arrays.asList("ADRIAN", "MARCO", "ELSA"), upperCaseNames);
	}

	@Test
	void testEvenNumbersInList() {
		List<Integer> evens = new ArrayList<>();
		list.stream().filter(x -> x % 2 == 0).forEach(evens::add);
		assertEquals(Arrays.asList(8, 52, 76, 4, 2), evens);
	}

	@Test
	void testSortedListInReverseOrder() {
		List<Integer> sorted = new ArrayList<>(list);
		sorted.sort(Comparator.reverseOrder());
		assertEquals(Arrays.asList(76, 52, 9, 9, 8, 7, 5, 4, 3, 2, 1), sorted);
	}

	@Test
	void testMaxAgeInPeople() {
		Optional<Integer> maxAge = people.stream().map(Person::getAge).max(Comparator.naturalOrder());
		assertTrue(maxAge.isPresent());
		assertEquals(55, maxAge.get());
	}

	@Test
	void testFindPersonNamedGeorge() {
		List<Person> found = new ArrayList<>();
		people.stream().filter(x -> Objects.equals(x.getName(), "George")).forEach(found::add);
		assertEquals(1, found.size());
		assertEquals("George", found.get(0).getName());
	}
}

