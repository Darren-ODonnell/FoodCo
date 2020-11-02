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

}
