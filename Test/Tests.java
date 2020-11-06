import application.Employee;
import dataStructures.LinkedList;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class Tests {
    LinkedList<Employee> employees;

    @Before
    public void SetupEmployees() {
        employees = new LinkedList<>();
        Employee emp = new Employee("10000", "Darren", 3, null);
        employees.add(emp);
        emp = new Employee("10002", "Darren2", 3, null);
        employees.add(emp);
    }

    @Test
    public void countEmployees(){
        int count = employees.size();

        Assert.assertEquals(2, count);
    }

    @Test
    public void getEmployee(){
        int index = 1;
        Employee emp = employees.get(index);

        Assert.assertEquals("10000", emp.getEmployeeNumber());
        Assert.assertEquals("Darren", emp.getName());
        Assert.assertEquals(3, emp.getYearsWorking());

    }
    @Test
    public void addNewEmployeeAtPosition(){
        listEmployees();
        Employee emp = new Employee("10001", "Darren1", 3, null);
        employees.add(emp, 2);
        Employee emp2 = employees.get(2);

        listEmployees();

        //Assert.assertEquals("10001", employees.get(2).getEmployeeNumber());
        //Assert.assertEquals("10001", employees.get(3).getEmployeeNumber());
        Assert.assertEquals("10001", employees.get(2).getEmployeeNumber());


    }
    private void listEmployees() {
        for (int i = 1; i <= employees.size(); i++)
            System.out.println(employees.get(i));

        System.out.println();
    }



}
