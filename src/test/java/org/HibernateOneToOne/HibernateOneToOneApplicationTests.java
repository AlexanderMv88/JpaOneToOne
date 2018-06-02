package org.HibernateOneToOne;

import org.HibernateOneToOne.entity.Card;
import org.HibernateOneToOne.entity.Employee;
import org.HibernateOneToOne.repository.EmployeeRepository;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class HibernateOneToOneApplicationTests {

	@Autowired
	EmployeeRepository employeeRepository;


	@Test
	public void test1JpaCreate() {
		//Insert
		Stream.of(new Employee("Вася",new Card("Карточка Василия")),
				new Employee("Саша",new Card("Карточка Александра")),
				new Employee("Дима",new Card("Карточка Дмитрия")))
				.forEach(obj -> {
					employeeRepository.save(obj);
				});
		List<Employee> employees = employeeRepository.findAll();
		assertThat(employees != null).isTrue();
		assertThat(employees.size() == 3).isTrue();






	}

	@Test
	public void test2JpaFind() {
		//Select
		Employee employee = employeeRepository.findOneByName("Саша");
		assertThat(employee.getName()).isEqualTo("Саша");
		assertThat(employee.getCard().getName()).isEqualTo("Карточка Александра");





	}


	@Test
	public void test3JpaChange() {
		//Update
		Employee employee = employeeRepository.findOneByName("Саша");
		employee.setName("Александр");
		Card card = employee.getCard();
		card.setName("Карточка Александра (проверена)");

		employeeRepository.save(employee);



		Employee changedEmployee = employeeRepository.findOneByName("Александр");
		assertThat(changedEmployee).isEqualTo(employee);
	}

	@Test
	public void test4JpaDelete() {
		List<Employee> employeesForDelete = employeeRepository.findAll();
		employeeRepository.deleteAll(employeesForDelete);
		assertThat(employeeRepository.findAll().size() == 0).isTrue();


	}

}
