package org.softwaretechnologies;

import org.softwaretechnologies.employee.Employee;
import org.softwaretechnologies.employee.EmployeeType;
import org.softwaretechnologies.employee.Manager;
import org.softwaretechnologies.employee.Programmer;
import org.softwaretechnologies.employee.Tester;

import java.util.ArrayList;
import java.util.List;

public class Company {
    private final String name;
    private final List<Employee> employeeList;

    public Company(String name) {
        this.name = name;
        this.employeeList = new ArrayList<>();
    }

    /**
     * Создает и добавляет сотрудника в коллекцию employeeList.
     * @param name имя работника
     * @param baseSalary базовая зарплата сотрудника
     * @param type тип работника
     */
    public void addEmployee(String name, int baseSalary, EmployeeType type) {
        Employee employee;

        switch (type) {
            case Manager:
                employee = new Manager(name, baseSalary);
                break;
            case Programmer:
                employee = new Programmer(name, baseSalary);
                break;
            case Tester:
                employee = new Tester(name, baseSalary);
                break;
            default:
                throw new IllegalArgumentException("Неизвестный тип сотрудника: " + type);
        }

        employeeList.add(employee);
    }

    /**
     * Возвращает сумму зарплат всех сотрудников за указанный месяц.
     * @param month номер месяца
     * @return сумма зарплат всех сотрудников за указанный месяц
     */
    public int getMonthSalary(int month) {
        int totalSalary = 0;

        for (Employee employee : employeeList) {
            totalSalary += employee.getMonthSalary(month);
        }

        return totalSalary;
    }

    public String getName() {
        return name;
    }
}
