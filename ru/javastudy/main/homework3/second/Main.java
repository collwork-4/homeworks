package ru.javastudy.homework3.second;

public class Main {

    public static void main(String[] args) {
        Employee[] employees = {
                new Employee("Иванов Иван Иванович", "Директор",
                        "ivanov@company.com", "+7-999-123-45-67",
                        150000, 45),

                new Employee("Петрова Анна Сергеевна", "Менеджер",
                        "petrova@company.com", "+7-999-123-45-68",
                        80000, 35),

                new Employee("Сидоров Алексей Петрович", "Программист",
                        "sidorov@company.com", "+7-999-123-45-69",
                        120000, 42),

                new Employee("Козлова Мария Владимировна", "Бухгалтер",
                        "kozlova@company.com", "+7-999-123-45-70",
                        90000, 38),

                new Employee("Федоров Дмитрий Николаевич", "Аналитик",
                        "fedorov@company.com", "+7-999-123-45-71",
                        110000, 47)
        };

        for (Employee e : employees) if (e.getAge() > 40) e.getEmployeeInfo();
    }

}
