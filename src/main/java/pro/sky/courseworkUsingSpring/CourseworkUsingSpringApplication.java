package pro.sky.courseworkUsingSpring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CourseworkUsingSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(CourseworkUsingSpringApplication.class, args);

//		public class Main {
//			public static void main(String[] args) {
//
//				EmployeeBook employeeBook = new EmployeeBook();
//
//				System.out.println(employeeBook.addEmployee(new Employee("Машков", "Владимир", "Львович", 3, 89)));
//				System.out.println(employeeBook.addEmployee(new Employee("Хабенский", "Константин", "Юрьевич", 3, 87)));
//				System.out.println(employeeBook.addEmployee(new Employee("Яковлева", "Елена", "Алексеевна", 4, 71)));
//				System.out.println(employeeBook.addEmployee(new Employee("Петренко", "Игорь", "Петрович", 2, 75)));
//				System.out.println(employeeBook.addEmployee(new Employee("Агуреева", "Полина", "Владимировна", 2, 66)));
//				System.out.println(employeeBook.addEmployee(new Employee("Безруков", "Сергей", "Витальевич", 3, 94)));
//				System.out.println(employeeBook.addEmployee(new Employee("Боярская", "Елизавета", "Михайловна", 4, 73)));
//				System.out.println(employeeBook.addEmployee(new Employee("Меньшиков", "Олег", "Евгеньевич", 5, 87)));
//				System.out.println(employeeBook.addEmployee(new Employee("Ходченкова", "Светлана", "Викторовна", 5, 75)));
//				System.out.println(employeeBook.addEmployee(new Employee("Пересильд", "Юлия", "Сергеевна", 2, 91)));
//
//				//удаляем сотрудника по id
//				int idForDelete = 3;
//				System.out.println(employeeBook.deleteEmployee(idForDelete) ? "Сотрудник удалён" : "Нет сотрудника с таким id");
//				System.out.println();
//
//				//получаем сотрудника по id
//				int idForGet = 10;
//				Employee employee = employeeBook.getEmployee(idForGet);
//				if (employee != null) {
//					System.out.println(employee.toString());
//				} else {
//					System.out.println("Нет сотрудника с таким id");
//				}
//				System.out.println();
//
//				//Получить список всех сотрудников
//				employeeBook.viewAll();
//
//				//Посчитать сумму затрат на ЗП в месяц
//				System.out.println("Сумма затрат на ЗП в месяц = " + employeeBook.monthSum());
//				System.out.println();
//
//				//Найти сотрудника с минимальной ЗП;
//				employee = employeeBook.minSalaryEmployee();
//
//				if (employee != null) {
//					System.out.println("Сотрудник с минимальной ЗП: " + employee.getIdAndName());
//				} else {
//					System.out.println("В книге нет сотрудников");
//				}
//				System.out.println();
//
//				//Найти сотрудника с максимальной ЗП;
//				employee = employeeBook.maxSalaryEmployee();
//
//				if (employee != null) {
//					System.out.println("Сотрудник с максимальной ЗП: " + employee.getIdAndName());
//				} else {
//					System.out.println("В книге нет сотрудников");
//				}
//				System.out.println();
//
//				//Среднее значение зарплат
//				System.out.println("Среднее значение зарплат = " + employeeBook.averageSalary());
//				System.out.println();
//
//				//Распечатать ФИО всех сотрудников
//				employeeBook.printFullName();
//				System.out.println();
//
//				//Проиндексировать зарплату
//				int indexingPercentage = 10;
//				employeeBook.indexTheSalary(indexingPercentage);
//
//				//Сотрудник с минимальной зп в отделе
//				int departmentNumber = 2;
//				employee = employeeBook.minSalaryDepartment(departmentNumber);
//
//				if (employee != null) {
//					System.out.println("Сотрудник с минимальной ЗП в отделе №" + departmentNumber + ": " + employee.getIdAndName());
//				} else {
//					System.out.println("В отделе нет сотрудников");
//				}
//				System.out.println();
//
//				//Сотрудник с максималоьной зп в отделе
//				employee = employeeBook.maxSalaryDepartment(departmentNumber);
//
//				if (employee != null) {
//					System.out.println("Сотрудник с максимальной ЗП в отделе №" + departmentNumber + ": " + employee.getIdAndName());
//				} else {
//					System.out.println("В отделе нет сотрудников");
//				}
//				System.out.println();
//
//				//Сумма затрат на ЗП по отделу
//				System.out.println("Сумма затрат на ЗП по отделу №" + departmentNumber +
//						": " + employeeBook.sumSalaryDepartment(departmentNumber));
//				System.out.println();
//
//				//Средняя ЗП по отделу
//				System.out.println("Средняя ЗП по отделу №" + departmentNumber +
//						": " + employeeBook.averageSalaryDepartment(departmentNumber));
//				System.out.println();
//
//				//Проиндексировать зарплату всех сотрудников отдела на процент
//				int indexingPercentageDepartment = 15;
//				employeeBook.indexTheSalaryDepartment(departmentNumber, indexingPercentageDepartment);
//
//				//Напечатать всех сотрудников отдела
//				employeeBook.printEmployeesDeportment(departmentNumber);
//
//				//Ввести: всех сотрудников с зп меньше числа; всех сотрудников с зп больше (или равно) числа
//				int parameter = 90;
//				employeeBook.printSalaryIsLess(parameter);
//				employeeBook.printSalaryIsMore(parameter);
//			}
//		}
	}

}
