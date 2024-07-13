package org.java8.utils;


import java.util.List;

public class EmployeeRepository {
    private static List<Employee> empList;

    public EmployeeRepository(List<Employee> empList) {
        this.empList = empList;

    }
    public static Employee findById(Integer id) {
        for (Employee emp : empList) {
            if (emp.getId() == id) {
                return emp;
            }
        }

        return null;
    }
}
