package org.softwaretechnologies.employee;

public class Manager extends Employee {

    public Manager(String name, int baseSalary) {
        super(name, baseSalary);
    }

    @Override
    public int getMonthSalary(int month) {
        if (month % 2 == 0) {
            return baseSalary; // четный месяц
        } else {
            return baseSalary / 2; // нечетный месяц
        }
    }
}
