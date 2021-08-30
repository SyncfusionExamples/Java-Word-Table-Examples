public class Employees 
{
	private String m_name;
	private String m_title;
	private String m_address;
	private String m_homePhone;
	private String m_photo;
	// Gets the employee name.
	public String getName() throws Exception {
		return m_name;
	}
	// Sets the employee name.
	public String setName(String value) throws Exception {
		m_name = value;
		return value;
	}
	// Gets the designation of the employee.
	public String getTitle() throws Exception {
		return m_title;
	}
	// Sets the designation of the employee.
	public String setTitle(String value) throws Exception {
		m_title = value;
		return value;
	}
	// Gets the address of the employee.
	public String getAddress() throws Exception {
		return m_address;
	}
	// Sets the address of the employee.
	public String setAddress(String value) throws Exception {
		m_address = value;
		return value;
	}
	// Gets the contact number of the employee.
	public String getHomePhone() throws Exception {
		return m_homePhone;
	}
	// Sets the contact number of the employee.
	public String setHomePhone(String value) throws Exception {
		m_homePhone = value;
		return value;
	}
	// Gets the photo of the employee.
	public String getPhoto() throws Exception {
		return m_photo;
	}
	// Sets the photo of the employee.
	public String setPhoto(String value) throws Exception {
		m_photo = value;
		return value;
	}
	/**
	 * Initializes a new instance of the Employees class with the specified name,
	 * title, address, contact number and photo.
	 * 
	 * @param name      Name of the employee.
	 * @param title     Designation of the employee.
	 * @param address   Address of the employee.
	 * @param homePhone Contact number of the employee.
	 * @param photo     Photo of the employee.
	 * @throws Exception
	 */
	public Employees(String name, String title, String address, String homePhone, String photo) throws Exception {
		m_name = name;
		m_title = title;
		m_address = address;
		m_homePhone = homePhone;
		m_photo = photo;
	}
	/**
	 * Initializes a new instance of the Employees class.
	 */
	public Employees() throws Exception {
	}
}
