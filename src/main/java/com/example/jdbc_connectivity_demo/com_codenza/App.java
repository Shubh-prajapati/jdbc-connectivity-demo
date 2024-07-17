package com.example.jdbc_connectivity_demo.com_codenza;
import com.example.jdbc_connectivity_demo.com_codenza.services.ConnectionService;
import com.example.jdbc_connectivity_demo.com_codenza.services.StudentService;

import java.io.IOException;
import java.util.Scanner;

public class App {
    private static final ConnectionService connectionService = new ConnectionService();

    public static void main(String[] args) throws IOException {
        StudentService studentService = new StudentService();
        Scanner scanner = new Scanner(System.in);
        int choice = 0;
        do {
            System.out.println("*** STUDENT MANAGEMENT SYSTEM ***");
            System.out.println("_______________________________");
            System.out.println("Select operation:");
            System.out.println("1. Create Employee");
            System.out.println("2. Retrieve Employee");
            System.out.println("3. Update Employee");
            System.out.println("4. Delete Employee");
            System.out.println("5. Retrieve Address");
            System.out.println("0. Exit");

            System.out.print("Enter your choice: ");
            choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    System.out.println("Performing CREATE operation on Employee");
                    studentService.insertStudent();
                    break;
                case 2:
                    System.out.println("Performing READ operation on Employee");
                    // Add your read logic here
                    break;
                case 3:
                    System.out.println("Performing UPDATE operation on Employee");
                    // Add your update logic here
                    break;
                case 4:
                    System.out.println("Performing DELETE operation on Employee");
                    // Add your delete logic here
                    break;
                case 5:
                    System.out.println("Performing RETRIEVE operation on Address..");
                    studentService.retrieveAddress().forEach(address -> {
                        System.out.println("Address ID: " + address.getAddressId() + ", City: " + address.getCity());
                    });
                    break;
                case 0:
                    System.out.println("Exiting program");
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        } while (choice != 0);
        scanner.close();
    }

}
