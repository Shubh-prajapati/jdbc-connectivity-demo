package com.example.jdbc_connectivity_demo.com_codenza.services;
import com.example.jdbc_connectivity_demo.com_codenza.model.Address;
import com.example.jdbc_connectivity_demo.com_codenza.model.Student;
import java.sql.SQLException;
import  java.util.Scanner;

import com.example.jdbc_connectivity_demo.com_codenza.repository.StudentRepository;
import java.util.List;

public class StudentService {
    private  static final StudentRepository STUDENT_REPO= new StudentRepository();

    public List<Address> retrieveAddress(){

        return STUDENT_REPO.retrieveAddress();
    }

    public void insertStudent(){

        Scanner scanner=new Scanner(System.in);
        System.out.println("Pls enter the student id:");
        int studentId =Integer.parseInt(scanner.nextLine());

        System.out.println("Pls enter the student name: ");
        String name=scanner.nextLine();

        System.out.println("Pls enter student Address Id: ");
        int addressId =Integer.parseInt(scanner.nextLine());

        System.out.println("Pls enter student percentage:");
        float percentage= Float.parseFloat(scanner.nextLine());

        System.out.println("Pls enter student grade:");
        String grade=scanner.nextLine();


        Address address =STUDENT_REPO.retrieveAddress(addressId);
        Student student = new Student(studentId, name, address, percentage, grade);

        try{
            if(STUDENT_REPO.insertStudent(student)){
                System.out.println("Employee inserted successfully!");
            }else {
                System.out.println("Failed to insert employee.");
            }
        }catch (SQLException e){
            throw  new RuntimeException(e);
        }
    }





}
