package org.java8;

import org.java8.utils.Employee;
import org.java8.utils.EmployeeRepository;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    //



    public static void main(String[] args) {

        whenIncrementSalaryForEachEmployee_thenApplyNewSalary();
    }

    private static void whenIncrementSalaryForEachEmployee_thenApplyNewSalary(){
        List<Employee> emplst = Arrays.asList(arrayOfEmps);
        emplst.forEach(e->e.salaryIncrement(10.0));
        System.out.println(emplst);
    }

    private static void whenMapIdToEmployees_thenGetEmployeeStream(){
        Integer[] empIds = { 1, 2, 3 };
        List<Employee> emp = Stream.of(empIds).map(EmployeeRepository::findById)
                .toList();
    }

    private static void whenFilterEmployees_thenGetFilteredStream(){
        Integer[] empIds = { 1, 2, 3, 4 };
        List<Employee> emp = Stream.of(empIds).map(EmployeeRepository::findById)
                .filter(Objects::nonNull).filter(e->e.getSalary()>200000).toList();
    }

    private static void whenFindFirst_thenGetFirstEmployeeInStream(){
        Integer[] empIds = { 1, 2, 3, 4 };
        Employee emp = Stream.of(empIds).map(EmployeeRepository::findById)
                .filter(Objects::nonNull).filter(e->e.getSalary()>100000)
                .findFirst().orElse(null);
    }

    private static  void whenStreamToArray_thenGetArray(){
        Integer[] empIds = { 1, 2, 3, 4 };
        List<Employee> emp = Stream.of(empIds).map(EmployeeRepository::findById)
                .filter(Objects::nonNull).filter(e->e.getSalary()>200000).toList();
        Employee[] emp_ar = emp.toArray(Employee[]::new);
    }

    private static void whenFlatMapEmployeeNames_thenGetNameStream(){
        List<List<String>> name = Arrays.
                asList(Arrays.asList("n1","n2"),Arrays.asList("n3","n4"));
        List<String> names = name.stream().flatMap(Collection::stream)
                .toList();
    }

    private static Employee[] arrayOfEmps = {
            new Employee(1, "Jeff Bezos", 100000.0),
            new Employee(2, "Bill Gates", 200000.0),
            new Employee(3, "Mark Zuckerberg", 300000.0)
    };
}