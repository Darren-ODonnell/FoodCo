/**file name: TrainingCourse
 * Author: Darren O'Donnell
 * Student number: C19313413
 * Description of class: Main class of the project, responsible for the running of it
 */
import GUI.Display;
import GUI.Input;
import application.Employee;
import application.Employees;

public class TrainingCourse {
    Input input = new Input();
    Display win = new Display();
    boolean debug = true;

    public TrainingCourse(){
        Employees employeesCollection = new Employees();
        //1. Input up to 10 employees, error checking
        int employeeCount =0;

        if (debug) {
            Employee emp;
            emp = new Employee("10001", "Darren1", 1, null);
            employeesCollection.employees.add(emp,1);
            emp = new Employee("10002", "Darren2", 2, null);
            employeesCollection.employees.add(emp,2);
            emp = new Employee("10003", "Darren3", 3, null);
            employeesCollection.employees.add(emp,2);
        }
        else {
            employeeCount = input.number("How many employees would you like to input", 1, 10, "Number out of range 1-10");
            for (int i = 0; i < employeeCount; i++) {
                Employee emp = employeesCollection.enterEmployee();
                employeesCollection.add(emp);
            }
        }




        //2. Display all employees

        String list = employeesCollection.allToString();

        win.showMessage(list);

        //3. Remove employee from training courses(by number)
        String prompt = "Input the employee number of the employee you want to remove";
        String errMessage = "No employee found with that Employee Number";
        if(employeesCollection.size() > 0) {
            String[] empNos = employeesCollection.getEmployeeNumbers();
            String empNo = input.stringExists(empNos, prompt, errMessage);
            employeesCollection.remove(empNo);
        }else{
            win.showMessage("Error, nothing in list to delete");
        }

        //4. Display all details of employees on training courses
            employeesCollection.displayAllOnCourses();
        //5. Delete all employees from course

        //6. Display remaining employees

        //7. Personal Function(Doesnt need to be last
    }

    public static void main(String[] args) {
        new TrainingCourse();

    }
}
