/**file name: TrainingCourse
 * Author: Darren O'Donnell
 * Student number: C19313413
 * Description of class: Main class of the project, responsible for the running of it
 */
import GUI.Input;
import application.Employee;
import application.Employees;

public class TrainingCourse {
    Input input = new Input();

    public TrainingCourse(){
        Employees employeesCollection = new Employees();

        int employeeCount =0;
        employeeCount = input.number("How many employees would you like to input",1,10,"Number out of range 1-10");
        for(int i = 0; i< employeeCount; i++){
            employeesCollection.enterEmployee();
        }
    }

    public static void main(String[] args) {
        new TrainingCourse();

    }
}
