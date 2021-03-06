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
    Employees employeeCollection = new Employees();

    public TrainingCourse(){

        if (debug) {
            Employee emp;
            emp = new Employee("10001", "Darren1", 1, null);
            employeeCollection.employees.add(emp,1);
            emp = new Employee("10002", "Darren2", 2, null);
            employeeCollection.employees.add(emp,2);
//            emp = new Employee("10003", "Darren3", 6, "FOOD123");
//            employeeCollection.employees.add(emp,3);
           emp = new Employee("10004", "Darren4", 8, "FOOD234");
            employeeCollection.employees.add(emp,4);
            //emp = new Employee("10005", "Darren5", 5, "FOOD123");
            //employeeCollection.employees.add(emp,5);
        }
        else {
            // 1. Input up to 10 employees, error checking
            inputNames();
        }

        // 2. Display all employees
        displayAllEmployees();

        //3. Remove employee from training courses(by number)
        removeEmployeeFromTrainingCourse();

        // 4. Display all details of employees on training courses
        win.showMessage("All Employees on Training Courses: \n" +
                        employeeCollection.displayAllOnCourses());

        // 5. Delete all employees from course specified
        deleteAllEmployeesOnCourse();

        // 6. Display remaining employees
        employeeCollection.displayAll();

        // 7. Personal Function(Doesnt need to be last
        displayEligibility();
    }

    // Input names with error checking inside Employees
    public void inputNames() {
        int employeeCount = input.number("How many employees would you like to input", 1, 10, "Number out of range 1-10");

        for (int i = 0; i < employeeCount; i++) {
            Employee emp = employeeCollection.enterEmployee();
            employeeCollection.add(emp);
        }
    }

    // Display all currently in list
    public void displayAllEmployees() {
        String list = employeeCollection.allToString();
        win.showMessage(list);
    }

    //Remove employee from the training course provided
    public void removeEmployeeFromTrainingCourse() {
        String prompt = "Input the employee number of the employee you want to remove";
        String errMessage = "No employee found with that Employee Number";
        if(employeeCollection.size() > 0) {
            String[] empNos = employeeCollection.getEmployeeNumbers();
            String empNo = input.stringExists(empNos, prompt, errMessage);
            employeeCollection.remove(empNo);
        } else {
            win.showMessage("Error, nothing in list to delete");
        }
    }

    // Remove all employees from the training course given
    public void deleteAllEmployeesOnCourse() {
        String prompt = "Input the Code for the training course you wish to delete all members from";
        String errMessage = "Course does not exist - please re-enter";

        String[] list = employeeCollection.getCourseNames();

        String courseCode = input.string(list,prompt,errMessage);
        employeeCollection.removeFromCourse(courseCode);
    }

    // Display if employee is eligible to be assigned to a training course
    public void displayEligibility(){
        String str = employeeCollection.displayEmployeesEligibleForTrainingCourse();

        win.showMessage(str.isEmpty() ? "No employees eligible for training courses": str );
    }


    public static void main(String[] args) {
        new TrainingCourse();

    }
}
