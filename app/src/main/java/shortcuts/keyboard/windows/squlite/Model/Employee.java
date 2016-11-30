package shortcuts.keyboard.windows.squlite.Model;

/**
 * Created by acer on 11/26/2016.
 */

public class Employee {
    private int id;
    private String employeeName;
    private  String employeePhoneNo;

    public Employee(String employeeName, String employeePhoneNo, int id) {
        this.employeeName = employeeName;
        this.employeePhoneNo = employeePhoneNo;
        this.id = id;
    }

    public Employee(String employeeName, String employeePhoneNo) {
        this.employeeName = employeeName;
        this.employeePhoneNo = employeePhoneNo;
    }

    public Employee() {
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public String getEmployeePhoneNo() {
        return employeePhoneNo;
    }

    public int getId() {
        return id;
    }
}
