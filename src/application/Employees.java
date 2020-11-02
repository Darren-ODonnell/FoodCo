package application;

import GUI.Input;
import dataStructures.LinkedList;

public class Employees {
    LinkedList<Employee>employees = new LinkedList<>();
    Input input = new Input();


    final int START_EMPLOYEE_NUMBER = 1000;
    int lastEmployeeNumber = START_EMPLOYEE_NUMBER;
    final int  MAX_EMPLOYEES = 10;

    public void displayAll() {

    }

    public void displayAllOnCourses() {

    }

    public void remove(int empNumber) {

    }
//    String employeeNumber;
//    String name;
//    int yearsWorking;
//    String courseName;

    public void enterEmployee() {
        Employee emp = new Employee();
        String prompt, errMessage;
        int min, max;

        // enter name
        prompt = "Input the name of this employee";
        emp.setName(input.string(prompt));

        // enter yearsWorking
        min = 0;
        max = 100;
        prompt = "Input the number of this employee";
        errMessage = "Number out of range, please re-enter between " + min + " and " + max;
        emp.setYearsWorking(input.number(prompt,min,max,errMessage));

        // enter courseName
        prompt = "Input the course name of this employee";
        String pattern = "^(?i)FOOD.*"; //Allows anything to be input but the first 4 letter must be FOOD upper/lowercase
        String courseName = input.string(prompt);
        if(courseName.matches(pattern))
            emp.setCourseName(input.string(prompt));
        else
            emp.setCourseName("ERROR");
        
        // set employeeNumber
        lastEmployeeNumber += 1;
        emp.setEmployeeNumber(String.valueOf(lastEmployeeNumber));

        employees.add(emp);
    }

}
