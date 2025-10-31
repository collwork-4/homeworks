package ru.javastudy.homework3.second;

public class Employee {

    private final String fullName;
    private final String job;
    private final String email;
    private final String phoneNumber;
    private final int salary;
    private final int age;

    public Employee(String fullName, String job, String email, String phoneNumber, int salary, int age) {
        this.fullName = fullName;
        this.job = job;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.salary = salary;
        this.age = age;
    }

    public void getEmployeeInfo() {
        System.out.printf("\nИнформация о сотруднике:\n \nФИО: %s \nДолжность: %s \nEmail: %s \nТелефон: %s \nЗарплата: %d \nВозраст: %d\n\n",
                fullName,
                job,
                email,
                phoneNumber,
                salary,
                age
        );
    }

    public int getAge() {
        return age;
    }

}
