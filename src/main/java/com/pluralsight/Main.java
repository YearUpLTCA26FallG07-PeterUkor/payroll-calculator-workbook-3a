package com.pluralsight;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.printf("Enter the name of the file to process: ");
        String inputFileName = input.nextLine();

        System.out.printf("Enter the name of the payroll file to create: ");
        String outputFileName = input.nextLine();



        try{
            // initialize FileReader and BufferedReader Objects

            FileReader fileReader = new FileReader(inputFileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            // initialize FileWriter and BufferedWriter Objects

            FileWriter fileWriter = new FileWriter(outputFileName);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write("id|name|gross pay\n");

            // read lines form input file
            String inputLine;
            while ((inputLine = bufferedReader.readLine()) != null){
                String[] parts = inputLine.split("\\|");

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

                // handle header or text inputs

                try{
                    employeeId = Integer.parseInt(parts[0]);
                    name = parts[1].trim();
                    hoursWorked = Double.parseDouble(parts[2]);
                    payRate = Double.parseDouble(parts[3]);
                } catch (Exception num){
                    System.out.println("Invalid Employee Record");
                    continue;
                }

                // create Employee object

                Employee employee = new Employee(employeeId, name, hoursWorked, payRate);

                // build string for writing

                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(employee.getEmployeeId()).append("|");
                stringBuilder.append(employee.getName()).append("|");
                stringBuilder.append(employee.getGrossPay()).append("\n");

                String outputLine = stringBuilder.toString();
                bufferedWriter.write(outputLine);


            }

            bufferedReader.close();
            bufferedWriter.close();
        } catch (FileNotFoundException e){
            System.out.println("File does not exist.");
            return;
        } catch (IOException e) {
            System.out.println("Issues Reading");
        }

    }


}