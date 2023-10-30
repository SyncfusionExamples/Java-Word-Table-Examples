import javax.xml.bind.annotation.*;
public class Employee 
{
	private String Name;
	private String Title;
	private String Address;
	private String HomePhone;
	private String Photo;
	@XmlElement(name = "Name")
	/**
	 * Gets the employee name.
	 */
	public String getName() 
	{
		return Name;
	}
	/**
	 * Sets the employee name.
	 * 
	 * @param name Name of the employee.
	 */
	public void setName(String name) 
	{
		this.Name = name;
	}
	@XmlElement(name = "Title")
	/**
	 * Gets the designation of the employee.
	 */
	public String getTitle() 
	{
		return Title;
	}
	/**
	 * Sets the designation of the employee.
	 * 
	 * @param title Designation of the employee.
	 */
	public void setTitle(String title) 
	{
		this.Title = title;
	}
	@XmlElement(name = "Address")
	/**
	 * Gets the address of the employee.
	 */
	public String getAddress() 
	{
		return Address;
	}
	/**
	 * Sets the address of the employee.
	 * 
	 * @param address Address of the employee.
	 */
	public void setAddress(String address) 
	{
		this.Address = address;
	}
	@XmlElement(name = "HomePhone")
	/**
	 * Gets the contact number of the employee.
	 */
	public String getHomePhone() 
	{
		return HomePhone;
	}
	/**
	 * Sets the contact number of the employee.
	 * 
	 * @param homePhone Contact number of the employee.
	 */
	public void setHomePhone(String homePhone) 
	{
		this.HomePhone = homePhone;
	}
	@XmlElement(name = "Photo")
	/**
	 * Gets the photo of the employee.
	 */
	public String getPhoto() 
	{
		return Photo;
	}
	/**
	 * Sets the photo of the employee.
	 * 
	 * @param photo Photo of the employee.
	 */
	public void setPhoto(String photo)
	{
		this.Photo = photo;
	}
	/**
	 * Initializes a new instance of the Employee class with the specified name,
	 * title, address, contact number and photo.
	 * 
	 * @param name      Name of the employee.
	 * @param title     Designation of the employee.
	 * @param address   Address of the employee.
	 * @param homePhone Contact number of the employee.
	 * @param photo     Photo of the employee.
	 * 
	 */
	public Employee(String name, String title, String address, String homePhone, String photo) 
	{
		this.Name = name;
		this.Title = title;
		this.Address = address;
		this.HomePhone = homePhone;
		this.Photo = photo;
	}
	/**
	 * Initializes a new instance of the Employee class.
	 */
	public Employee() 
	{
	}
}
