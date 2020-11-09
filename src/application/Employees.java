/**file name: Employees
 * Author: Darren O'Donnell
 * Student number: C19313413
 * Description of class: Handles the actions associated with the list of employees
 */
package application;

import GUI.Display;
import GUI.Input;
import dataStructures.LinearNode;
import dataStructures.LinkedList;

import java.util.List;

public class Employees {
    public LinkedList<Employee> employees = new LinkedList<>();
    Input input = new Input();
    Display win = new Display();

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

    public void enterEmployee() {
        Employee emp = new Employee();
        String prompt, errMessage;
        int min, max;
        boolean found = true;
        String regexEmpNo = "^[0-9]{5}$";
        prompt = "Enter Employee Number - 5 digits";
        String empNo;
        // Enter Employee Number
        do {
            // enter employee number

            empNo = input.string(prompt, regexEmpNo);
            emp.setEmployeeNumber(empNo);

            if (found = findEmployee(emp))
                win.showMessage("Error: Employee Number already exists - Please re-enter");

        } while(found);

        // enter name
        prompt = "Input the name of this employee";
        emp.setName(input.string(prompt));

        // enter yearsWorking
        min = 0;
        max = 100;
        prompt = "Input the years worked by this employee";
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

        employees.add(emp);
    }

    //Add in chronological order of employeeNumber
    private void add(Employee emp){
        // case 1. no elements in list => insert at 1.
        // case 2. somewhere in list in numerical order
        // case 3. no elements greater => insert at end or at employees.size()
        int position=1;

        // case 1 - emplty employee list
        if (employees.size() == 0)
            employees.add(emp,position);
        else {
            // case 3
            position = 2;
            // run through list looking for position to insert new employee
            while (position < employees.size() && emp.isLessThan(employees.get(position))) {
                position++;
            }
            employees.add(emp,position);
        }
    }

    //Scans list to find matching employee
    public boolean findEmployee(Employee emp) {

        boolean found = false;
        if(employees.size() > 0) {
            while (employees.hasNext() && !found) {
                Employee employee = employees.getNext();
                found = employee.compare(emp);
            }
        }

    return found;
    }

}
