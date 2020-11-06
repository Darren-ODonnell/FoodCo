/**file name: Employee
 * Author: Darren O'Donnell
 * Student number: C19313413
 * Description of class: Datatype of each singular employee
 */
package application;

public class Employee {
    String employeeNumber;
    String name;
    int yearsWorking;
    String courseName;

    public Employee() {
        String employeeNumber = "";
        String name = "";
        int yearsWorking = 0;
        String courseName = "";
    }

    public Employee(String employeeNumber, String name, int yearsWorking, String courseName) {
        this.employeeNumber = employeeNumber;
        this.name = name;
        this.yearsWorking = yearsWorking;
        this.courseName = courseName;
    }

    public String getEmployeeNumber() {
        return employeeNumber;
    }

    public void setEmployeeNumber(String employeeNumber) {
        this.employeeNumber = employeeNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYearsWorking() {
        return yearsWorking;
    }

    public void setYearsWorking(int yearsWorking) {
        this.yearsWorking = yearsWorking;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    @Override
    public String toString() {
        return "Employees{" +
                "employeeNumber='" + employeeNumber + '\'' +
                ", name='" + name + '\'' +
                ", yearsWorking=" + yearsWorking +
                ", courseName='" + courseName + '\'' +
                '}';
    }
    //Compares employee numbers of 2 employees and returns true or false accordingly
    public boolean compare(Employee emp) {
        return this.getEmployeeNumber().equals(emp.getEmployeeNumber());
    }

    public boolean isLessThan(Employee emp) {
        // -1 = this < that
        // 0 = this = that
        // 1 = this > that



        return (this.getEmployeeNumber().compareTo(emp.getEmployeeNumber())<0);
    }
}
