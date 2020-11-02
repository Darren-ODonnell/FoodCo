package application;

import GUI.Input;

public class Employees {
    Input input = new Input();

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

    public Employee enterEmployee() {
        Employee emp = new Employee();
        String prompt, errMessage;
        int min, max;

        // enter name
        prompt = "Input the name of this employee";
        emp.setName(input.string(prompt));

        // enter employeeNumber
        prompt = "Input the number of this employee";
        emp.setEmployeeNumber(input.string(prompt));
        
        // enter yearsWorking
        prompt = "Input the number of this employee";
        errMessage = "Number out of range, please re-enter between " + min + " and " + max);
        emp.setYearsWorking(input.number(prompt,min,max,errMessage));

    }





}
