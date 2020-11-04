package application;

import GUI.Input;
import dataStructures.LinearNode;
import dataStructures.LinkedList;

public class Employees {
    LinkedList<Employee> employees = new LinkedList<>();
    Input input = new Input();


    final int START_EMPLOYEE_NUMBER = 1000;
    int lastEmployeeNumber = START_EMPLOYEE_NUMBER;

    public Employees() {

    }
    //Displays all employees
    public void displayAll() {

    }
    //Display all employees currently on a course
    public void displayAllOnCourses() {

    }
    //Removes employee with matching employee number
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

        // Only allowed do courses if they have over 5 years experience
        if (emp.getYearsWorking() > 5) {
            // enter courseName
            prompt = "Input the course name of this employee";
            String pattern = "^(?i)FOOD.*"; //Allows anything to be input but the first 4 letter must be FOOD upper/lowercase
            String courseName = input.string(prompt);

            if (courseName.matches(pattern) )
                emp.setCourseName(input.string(prompt));
            else
                emp.setCourseName("ERROR");
        }

        // set employeeNumber

        do {
            lastEmployeeNumber += 1;
            emp.setEmployeeNumber(String.valueOf(lastEmployeeNumber));

        } while(findEmployee(emp));

        if(!employees.exists(emp))
            employees.add(emp);
    }

    //Scans list to find matching employee
    private boolean findEmployee(Employee emp) {
//
        boolean found = false;
//
//        LinearNode<Employee> current = employees.getFirst();
//
//        while (current != null && !found ) {
//            found = current.getElement().compare(emp);
//            current = current.getNext();
//        }
//
//        return found;

        while(employees.hasNext() && !found) {
            Employee employee = employees.getNext();
            if (employee.compare(emp)) {
                found = true;
            }
        }


    }

}
