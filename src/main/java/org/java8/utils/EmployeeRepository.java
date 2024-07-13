package org.java8.utils;


import java.util.List;
import java.util.Objects;

public class EmployeeRepository {
    private static List<Employee> empList;

    public EmployeeRepository(List<Employee> empList) {
        EmployeeRepository.empList = empList;

    }
    public static Employee findById(Integer id) {
        for (Employee emp : empList) {
            if (Objects.equals(emp.getId(), id)) {
                return emp;
            }
        }

        return null;
    }
}
