import java.util.List;
import javax.xml.bind.annotation.*;

@XmlRootElement(name = "Employees")
public class Employees {
	private List<Employee> Employee;

	/**
	 * Gets the list of employees.
	 */
	@XmlElement(name = "Employee")
	public List<Employee> getEmployees() {
		return Employee;
	}

	/**
	 * Sets the list of employees.
	 * 
	 * @param employee List of employee.
	 */
	public void setEmployees(List<Employee> employee) {
		this.Employee = employee;
	}

	/**
	 * Initializes a new instance of the Employees class.
	 */
	public Employees() {
	}

	/**
	 * Initializes a new instance of the Employees class with the specified list of
	 * employee.
	 * 
	 * @param employees List of employee.
	 */
	public Employees(List<Employee> employees) {
		this.Employee = employees;
	}
}
