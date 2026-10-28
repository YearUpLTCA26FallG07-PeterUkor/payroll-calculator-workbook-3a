package com.pluralsight;

import java.io.*;
import java.util.Arrays;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        try{
            FileReader fileReader = new FileReader("employees.csv");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null){
                String[] parts = line.split("\\|");

                // make sure parts is 4 parts
                if (parts.length != 4){
                    System.out.println("Invalid Employee Record");
                    continue;
                }
                // convert the digits and create a new object
                int employeeId;
                String name;
                double hoursWorked;
                double payRate;
                // to handle header or text inputs
                try{
                    employeeId = Integer.parseInt(parts[0]);
                    name = parts[1].trim();
                    hoursWorked = Double.parseDouble(parts[2]);
                    payRate = Double.parseDouble(parts[3]);
                } catch (Exception num){
                    System.out.println("Invalid Employee Record");
                    continue;
                }

                Employee employee = new Employee(employeeId, name, hoursWorked, payRate);
                System.out.println("\nEmployeeID: " + employee.getEmployeeId());
                System.out.println("Employee Name: " + employee.getName());
                System.out.println("Gross Pay: " + employee.getGrossPay());
            }

            bufferedReader.close();
        } catch (FileNotFoundException e){
            System.out.println("File does not exist.");
            return;
        } catch (IOException e) {
            System.out.println("Issues Reading");
        }

    }


}