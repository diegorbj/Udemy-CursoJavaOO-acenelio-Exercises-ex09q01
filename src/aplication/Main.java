package aplication;

import entities.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.print("How many employees wil be registered? ");
        int n = sc.nextInt();

        List<Employee> payroll = new ArrayList<>();

        int i = 1;

        while (i <= n){
            System.out.println("Employee #" + i + ":");
            System.out.print("Id: ");
            int finalId = sc.nextInt();
            sc.nextLine();

            Employee employee = findEmployee(payroll, finalId);
            if (employee == null) {
                System.out.print("Name: ");
                String name = sc.nextLine();
                System.out.print("Salary: ");
                double salary = sc.nextDouble();
                payroll.add(new Employee(finalId, name, salary));
                i++;
            } else{
                System.out.println("The Id already exists! Please, try Again.");
            }
        }

        System.out.print("Enter the employee id that will have the salary increase: ");
        int finalId = sc.nextInt();

        Employee employee = findEmployee(payroll, finalId);

        if (employee != null) {
            System.out.print("Enter the percentage: ");
            double percentage = sc.nextDouble();
            employee.increaseSalary(percentage);
        }
        else {
            System.out.println("This Id does not exist!");
        }

        System.out.println("List of employees:");
        for (Employee e : payroll){
            System.out.println(e);
        }

        sc.close();
    }

    private static Employee findEmployee(List<Employee> payroll, int id){
        return payroll.stream().filter(e -> e.getId() == id).findFirst().orElse(null);
    }
}
