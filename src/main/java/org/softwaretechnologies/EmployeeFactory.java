package org.softwaretechnologies;

import org.softwaretechnologies.employee.*;

public class EmployeeFactory {

    /**
     * Функция должна создавать и возвращать Employee нужного типа.
     * Тип зависит от значения параметра type.
     * @param name имя сотрудника
     * @param baseSalary базовая зарплата сотрудника
     * @param type тип сотрудника
     * @return созданного сотрудника нужного типа. Тип зависит от параметра type.
     */
    public static Employee createEmployee(String name, int baseSalary, EmployeeType type) {
        switch (type) {
            case Manager:
                return new Manager(name, baseSalary);
            case Programmer:
                return new Programmer(name, baseSalary);
            case Tester:
                return new Tester(name, baseSalary);
            default:
                throw new IllegalArgumentException("Неизвестный тип сотрудника: " + type);
        }
    }
}
