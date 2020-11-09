import application.Employee;
import application.Employees;
import dataStructures.LinkedList;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class Tests {
    Employees employeeCollection;
    @Before
    public void SetupEmployees() {
        employeeCollection = new Employees();
        employeeCollection.employees = new LinkedList<>();
        Employee emp = new Employee("10000", "Darren", 3, null);
        employeeCollection.employees.add(emp);
        emp = new Employee("10002", "Darren2", 3, null);
        employeeCollection.employees.add(emp);
        emp = new Employee("10003", "Darren3", 6, "FOOD123");
        employeeCollection.employees.add(emp);
    }

    @Test
    public void countEmployees(){
        int count = employeeCollection.employees.size();

        Assert.assertEquals(3, count);
    }

    @Test
    public void getEmployee(){
        int index = 1;
        Employee emp = employeeCollection.employees.get(index);

        Assert.assertEquals("10000", emp.getEmployeeNumber());
        Assert.assertEquals("Darren", emp.getName());
        Assert.assertEquals(3, emp.getYearsWorking());

    }
    @Test
    public void addNewEmployeeAtPosition(){
        listEmployees();
        Employee emp = new Employee("10001", "Darren1", 3, null);
        employeeCollection.employees.add(emp, 2);
        Employee emp2 = employeeCollection.employees.get(2);

        listEmployees();

        returnNext();

        int count = employeeCollection.employees.size();
        //Assert.assertEquals("10001", employees.get(2).getEmployeeNumber());
        //Assert.assertEquals("10001", employees.get(3).getEmployeeNumber());
        Assert.assertEquals("10001", employeeCollection.employees.get(2).getEmployeeNumber());
        Assert.assertEquals(4, count);

    }

    @Test
    public void removeEmployeeByEmployeeObject(){
        Employee emp = employeeCollection.employees.get(2);
        employeeCollection.employees.remove(emp);
        Assert.assertEquals("10003", employeeCollection.employees.get(2).getEmployeeNumber());
    }

    @Test
    public void returnFirst(){
        Employee emp = employeeCollection.employees.getFirst();
        Assert.assertEquals("10000", emp.getEmployeeNumber());
    }
    @Test
    public void returnLast(){
        Employee emp = employeeCollection.employees.getLast();
        Assert.assertEquals("10003", emp.getEmployeeNumber());
    }

    @Test
    public void returnNext(){
        Employee current = employeeCollection.employees.get(2);//10001
        Employee next = employeeCollection.employees.getNext();//10002
        Assert.assertEquals("10001", current);
        Assert.assertEquals("10002", next);
    }

    private void listEmployees() {
        Employee emp = null;
        String str;
        for (int i = 1; i <= employeeCollection.employees.size(); i++) {
            emp = employeeCollection.employees.get(i);
            if (emp.getCourseName() == null) {
                str = "None";
            } else {
                str = emp.getCourseName();
            }
            System.out.println("Employee Number: " + emp.getEmployeeNumber());
            System.out.println("Employee Name: " + emp.getName());
            System.out.println("Years Worked: " + emp.getYearsWorking());
            System.out.println("Training Course: " + str + "\n");

        }
    }

    @Test
    public void findExistingEmployee(){

        Employee emp = new Employee("10000", "Darren", 3, null);
    }



}
