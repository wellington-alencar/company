import entities.Employee;
import entities.OutsourcedEmployee;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;


public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        List<Employee> employees = new ArrayList<>();

        System.out.println("Enter with the quantity of employees for the list:  ");
        var quantity = sc.nextInt();
        for (int i = 1; i <= quantity ; i++){
            System.out.println("Enter with the " + "#"+i +" Employee");
            System.out.println("Outsourced?  (Y/N) ");
            var outsourced = sc.next();

            System.out.print("Name: ");
            var name = sc.next();
            System.out.print("\n Hours: ");
            var hours = sc.nextInt();
            System.out.print("\nValue per hour: ");
            var valuePerHour = sc.nextDouble();

            if (outsourced.equalsIgnoreCase("y")){
                System.out.println("\nAdditional charge: ");
                var additionalCharge = sc.nextDouble();

                employees.add(new OutsourcedEmployee(name, hours, valuePerHour, additionalCharge));

            }else {
                employees.add(new Employee(name, hours, valuePerHour));
            };

        }
        System.out.println("Payments: ");
        for (Employee employee: employees) {
            System.out.println(employee.getName() +"  -  $"+ String.format("%.2f", employee.payment()));

            sc.close();
        }
    }
}