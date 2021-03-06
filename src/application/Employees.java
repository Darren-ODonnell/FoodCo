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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Employees {
    public LinkedList<Employee> employees = new LinkedList<>();
    Input input = new Input();
    Display win = new Display();
    boolean debug = true;

    final int START_EMPLOYEE_NUMBER = 1000;
    int lastEmployeeNumber = START_EMPLOYEE_NUMBER;

    public Employees() {

    }

    //Displays all employees
    public String allToString() {
        String str = "";
        int size =employees.size();
        for(int i =1; i <= size; i++){

            str += employees.get(i).toString();
            System.out.println(i + " - " +str);
        }
        return str;
    }

    //Display all employees currently on a course
    public String displayAllOnCourses() {
        String str = "";
        for(int i = 1; i <= employees.size(); i++){
            Employee emp = employees.get(i);
            if(emp.getCourseName() != null){
                str += emp.toString();
            }
        }
        return str;
    }

    //Removes employee with matching employee number
    public void remove(String empNumber) {
        for(int i = 1; i <= employees.size(); i++){
            Employee emp  = employees.get(i);
            if(emp.getEmployeeNumber().equals(empNumber)){
                employees.remove(i);
            }

        }
    }
    //Input details for new employee to be added
    public Employee enterEmployee() {
        Employee emp;
        if (debug) {
            emp = new Employee("10000", "Darren", 3, null);

        } else {

            emp = new Employee();
            String prompt, errMessage;
            int min, max;
            boolean found = true;
            String regexEmpNo = "^[0-9]{5}$"; // any sequence of exactly 5 digits only
            prompt = "Enter Employee Number - 5 digits";
            String empNo;
            // Enter Employee Number
            do {
                // enter employee number

                empNo = input.string(prompt, regexEmpNo);
                emp.setEmployeeNumber(empNo);

                if (found = findEmployee(emp))
                    win.showMessage("Error: Employee Number already exists - Please re-enter");

            } while (found);

            // enter name
            prompt = "Input the name of this employee";
            emp.setName(input.string(prompt));

            // enter yearsWorking
            min = 0;
            max = 100;
            prompt = "Input the years worked by this employee";
            errMessage = "Number out of range, please re-enter between " + min + " and " + max;
            emp.setYearsWorking(input.number(prompt, min, max, errMessage));


            // Only allowed do courses if they have over 5 years experience
            if (emp.getYearsWorking() > 5) {
                // enter courseName
                prompt = "Input the course name for this employee";
                String pattern = "^(?i)FOOD.*"; //Allows anything to be input but the first 4 letters must be FOOD upper/lowercase
                String courseName = input.string(prompt);

                if (courseName.matches(pattern))
                    emp.setCourseName(input.string(prompt));
                else {
                    emp.setCourseName("ERROR");
                }
            }
        }
        return emp;
        //employees.add(emp);
    }

    //Add in chronological order of employeeNumber
    public void add(Employee emp){
        // case 1. no elements in list => insert at 1.
        // case 2. somewhere in list in numerical order
        // case 3. no elements greater => insert at end or at employees.size()
        int position=1;

        // run through list looking for position to insert new employee
        while (position < employees.size() && emp.isGreaterThan(employees.get(position))) {
            position++;
        }
        employees.add(emp,position);
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

    //Removes all employees from a training course if the courseName matches the course they are on
    public void removeFromCourse(String courseName){
        for(int i = 1; i <= employees.size(); i ++) {
            Employee emp = employees.get(i);

            if(emp.getCourseName() != null)
                if(emp.getCourseName().equalsIgnoreCase(courseName)) {
                    employees.remove(emp);
            }
        }
    }
    //Get all employee numbers as an array of strings, used for searching
    public String[] getEmployeeNumbers() {
        String[] list = new String[employees.size()];

        for(int i = 1; i <= employees.size(); i++) {
            list[i-1] = employees.get(i).getEmployeeNumber();
        }
        return list;
    }

    // create list of course names
    public String[] getCourseNames() {
        List<String> list = new ArrayList<>();
        String courseName;
        for(int i = 1; i <= employees.size(); i++) {
            courseName = employees.get(i).getCourseName();
            if (courseName != null && !courseName.equals("ERROR") && !list.contains(courseName))
                if (!list.contains(courseName))
                    list.add(courseName);
        }

        String[] listArray;

        // If true ? set listArray to this : else set listArray to that
        listArray =  list.size()>0 ?  list.toArray(new String[0])  :  null;

        return listArray;
    }
    //return size of list
    public int size() {
        return employees.size();
    }
    //Displays all employees in list
    public void displayAll() {
        String str = "";
        for(int i =1; i <= employees.size(); i++){
            str += employees.get(i).toString();
        }
        win.showMessage(!str.isEmpty() ? str : "No Employees in List to Display");

    }
    //Displays al employees which are eligible for training course
    public String displayEmployeesEligibleForTrainingCourse(){
        String str = "";
        Employee emp;
        for(int i = 1; i <= employees.size(); i++) {
            emp = employees.get(i);
            if(emp.getYearsWorking() >= 5){
                str += emp.toString();
            }

        }
        return str;
    }

}
