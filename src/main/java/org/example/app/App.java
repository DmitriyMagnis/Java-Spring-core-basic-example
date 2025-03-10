package org.example.app;

import org.example.app.config.AppConfig;
import org.example.app.controller.EmployeeController;
import org.example.app.entity.Message;
import org.example.app.entity.Employee;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;



import java.util.Scanner;

public class App {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        var context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        onEmployeeUtil(context);
        onMessageUtil(context);
        context.close();
    }
    public static void onEmployeeUtil(AnnotationConfigApplicationContext context) {
        var employeeController =
                context.getBean("EmployeeController", EmployeeController.class);

        // Створення данних
        String employeeCreated1 =
                employeeController.create(new Employee("Alice", "Seller", "+380982222222"));
        getOutput("\n>> employee 1 created: " + employeeCreated1);
        String employeeCreated2 =
                employeeController.create(new Employee("Tom", "Broker", "+380982222222"));
        getOutput(">> employee 2 created: " + employeeCreated2);
        String employeeCreated3 =
                employeeController.create(new Employee("Lucy", "Seller", "+380982222222"));
        getOutput(">> employee 3 created: " + employeeCreated3);

        // Отримання всіх данних
        String employeeDataList = employeeController.getAll();
        getOutput("\n>> employee data list:\n" + employeeDataList);

        // Отримання данних за id
        System.out.print("\n>> Input employee id to find employee by id: ");
        Long employeeId = scanner.nextLong();
        String employeeById = employeeController.getById(employeeId);
        getOutput("\n>> employee by id: " + employeeById);

        // Оновлення данних за id
        System.out.print("\n>> Input employee id to update employee by id: ");
        Long employeeToUpdateId = scanner.nextLong();
        Employee employeeToUpdate = new Employee();
        employeeToUpdate.setId(employeeToUpdateId);
        employeeToUpdate.setFirstName("Lucy");
        employeeToUpdate.setPosition("Seller");
        employeeToUpdate.setPhone("+380982222222");
        String employeeUpdated = employeeController.update(employeeToUpdate);
        getOutput("\n>> employee updated: " + employeeUpdated);
        // Отримання всіх данних
        String employeeDataList2 = employeeController.getAll();
        getOutput("\n>> employee data list 2:\n" + employeeDataList2);

        // Видалення данних за id
        System.out.print("\n>> Input employee id to delete employee by id: ");
        Long employeeToDeleteId = scanner.nextLong();
        String employeeDeleteResult = employeeController.deleteById(employeeToDeleteId);
        getOutput("\n>> Delete employee by id result: " + employeeDeleteResult);
        // Отримання всіх данних
        String employeeDataList3 = employeeController.getAll();
        getOutput("\n>> employee data list 3:\n" + employeeDataList3);
    }

    public static void onMessageUtil(AnnotationConfigApplicationContext context) {
        // Отримання bean з Spring IOC контейнеру
        Message message = (Message) context.getBean("doMessage");
        // Виклик bean метода
        String messageResult = message.getMessage();
        // Виведення результату
        getOutput("\n>> Message: " + messageResult);
    }

    public static void getOutput(String output) {
        System.out.println(output);
    }
}
