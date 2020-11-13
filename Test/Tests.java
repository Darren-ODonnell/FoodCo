import application.Employee;
import application.Employees;
import dataStructures.LinkedList;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class Tests {

    Employees employeeCollection;
    @Before
    public void SetupEmployees() {
        employeeCollection = new Employees();
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
        Employee emp = new Employee("10001", "Darren1", 3, null);
        employeeCollection.employees.add(emp, 2);
        Employee emp2 = employeeCollection.employees.get(2);

        int count = employeeCollection.employees.size();
        //Assert.assertEquals("10001", employees.get(2).getEmployeeNumber());
        //Assert.assertEquals("10001", employees.get(3).getEmployeeNumber());
        assertEquals("10001", employeeCollection.employees.get(2).getEmployeeNumber());
        assertEquals(4, count);

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
        assertEquals("10003", emp.getEmployeeNumber());
    }

    @Test
    public void returnNext(){
        Employee current = employeeCollection.employees.get(2);//10001
        Employee next = employeeCollection.employees.getNext();//10002
        assertEquals("10002", current.getEmployeeNumber());
        assertEquals("10003", next.getEmployeeNumber());
    }
    @Test
    public void returnSecond(){
        Employee emp = employeeCollection.employees.get(2);
        assertEquals("10002", emp.getEmployeeNumber());
    }

    @Test
    public void ListContainsFirstElement(){
        boolean contains = employeeCollection.employees.contains(employeeCollection.employees.get(1));
        assertTrue(contains);
    }
    @Test
    public void ListContainsLastElement(){
        boolean contains = employeeCollection.employees.contains(employeeCollection.employees.get(3));
        assertTrue(contains);
    }
    @Test
    public void ListContainsElement(){
        boolean contains = employeeCollection.employees.contains(employeeCollection.employees.get(2));
        assertTrue(contains);
    }

    @Test
    public void ListDoesNotContainElement(){
        Employee emp = new Employee("10004", "Darren3", 6, "FOOD123");
        boolean contains = employeeCollection.employees.contains(emp);
        assertFalse(contains);
    }
    @Test
    public void findExistingEmployee(){

        Employee emp = new Employee("10000", "Darren", 3, null);
    }

    @Test
    public void removeNodeAtPosition(){
        employeeCollection.remove("10002");
        assertEquals("10003",employeeCollection.employees.get(2).getEmployeeNumber());
    }

    @Test
    public void getNodeAtPosition(){
        //assertEquals();
    }

    @Test
    public void display(){
        listEmployees();
        employeeCollection.displayAllOnCourses();
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

}
