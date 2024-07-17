package com.example.jdbc_connectivity_demo.com_codenza.model;

public class Student {
    private int studentId;

    private String name;

    private Address address;

    private float percentage;

    private  String  grade;





    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public float getPercentage() {
        return percentage;
    }

    public void setPercentage(float percentage) {
        this.percentage = percentage;
    }

    public String getGrade(){
        return  grade;
    }
    public void setGrade(String grade){
        this.grade=grade;
    }
    public Student(){

    }

    public Student(int studentId, String name, Address address, float percentage, String grade) {
        this.studentId = studentId;
        this.name = name;
        this.address = address;
        this.percentage = percentage;
        this.grade=grade;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", name='" + name + '\'' +
                ", address=" + address +
                ", percentage=" + percentage +
                ", grade='" + grade + '\'' +
                '}';
    }
}
