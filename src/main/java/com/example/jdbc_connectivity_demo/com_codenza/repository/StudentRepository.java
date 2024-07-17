package com.example.jdbc_connectivity_demo.com_codenza.repository;
import com.example.jdbc_connectivity_demo.com_codenza.model.Address;
import com.example.jdbc_connectivity_demo.com_codenza.services.ConnectionService;
import com.example.jdbc_connectivity_demo.com_codenza.model.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class StudentRepository {
    private  static Connection connection=null;

    private  void initConnection() throws SQLException{
        if(connection==null || connection.isClosed()){
            connection=new ConnectionService().getConnection();
        }
    }

    public  List<Address> retrieveAddress(){
        List<Address> addresses=new ArrayList<>();
        // Use the Connection to execute SQL quires and Interact with the database
        try{
            this.initConnection();
            // Your database operation here
            Statement statement=connection.createStatement();
            ResultSet resultSet=statement.executeQuery("SELECT * FROM address");

            //Iterate over the result set
            while(resultSet.next()){
                int id=resultSet.getInt("address_id"); // Replace "id" with your actual column name
                String city=resultSet.getString("city"); // Replace "city" with your actual column city

                // Do something with the data, e.g, print it
                Address address =new Address(id,city);
                addresses.add(address);
            }
        } catch (SQLException e) {
            System.err.println("SQL error: "+e.getMessage());
        }finally {
            // Close the connection when done
            if(connection !=null){
                try {
                    connection.close();
                }catch(SQLException e){
                    System.err.println("Error closing connection: "+ e.getMessage());
                }
            }
        }
        return  addresses;
    }

    public Address retrieveAddress(int addressId){
        Address address = null;
        // Use the connection to execute SQL quires and interact
        try{
            this.initConnection();
            //Your database operation here
            Statement statement=connection.createStatement();
            ResultSet resultSet=statement.executeQuery("SELECT * FROM address where address_id = "+addressId);

            //Iterate over the result set
            while (resultSet.next()){
                int id=resultSet.getInt("address_id");// Replace "id" with your actual column name
                String city=resultSet.getString("city"); // Replace "city" with your actual column name

                // Do something with the data e.g. print it
                address =new Address(id, city);
            }
        } catch (SQLException e) {
            System.err.println("SQL error:" +e.getMessage());
        }finally {
            //close the connection when done
            if(connection!=null){
                try{
                    connection.close();

                }catch (SQLException e){
                    System.err.println("Error closing connection: "+e.getMessage());
                }
            }
        }
        return  address;
    }


    public boolean insertStudent(Student student) throws  SQLException {
        this.initConnection();
        String query ="INSERT INTO student VALUE(?,?,?,?,?)";

        try(PreparedStatement preparedStatement=connection.prepareStatement(query)){
            preparedStatement.setInt(1,student.getStudentId());
            preparedStatement.setString(2,student.getName());
            preparedStatement.setInt(3,student.getAddress().getAddressId());
            preparedStatement.setFloat(4,student.getPercentage());
            preparedStatement.setString(5, student.getGrade());
            System.out.println("inserting student data to table: "+ student);

            int rowInserted =preparedStatement.executeUpdate();
            return  rowInserted>0;

        }catch (SQLException e){
            e.printStackTrace();
        }
        return  false;
    }


}
