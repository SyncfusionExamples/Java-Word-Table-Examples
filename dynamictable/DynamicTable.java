import java.io.*;
import com.syncfusion.docio.*;
import com.syncfusion.javahelper.system.*;
import com.syncfusion.javahelper.system.collections.generic.ListSupport;
import com.syncfusion.javahelper.system.io.*;
import com.syncfusion.javahelper.system.xml.*;

public class DynamicTable {
	public static void main(String[] args) throws Exception {
		// Loads the template document.
		WordDocument document = new WordDocument(getDataDir("DynamicTable_Template.docx"));
		// Creates a list of employee details.
		ListSupport<Employees> employeeDetails = getEmployeeDetails();
		// Iterates each item in the list.
		for (Employees employee : employeeDetails) 
		{
			// Accesses the table in the document.
			IWTable table = document.getSections().get(0).getTables().get(0);
			// Initializes the paragraph and add new row to the table.
			IWParagraph paragraph = null;
			WTableRow newRow = null;
			newRow = table.addRow();
			// Gets the employee photo and convert that base64 string to bytes.
			byte[] bytes = ConvertSupport.fromBase64String(employee.getPhoto());
			ByteArrayInputStream stream = new ByteArrayInputStream(bytes);
			int index = table.getRows().getCount();
			// Appends the picture to the first cell.
			table.getRows().get(index - 1).getCells().get(0).addParagraph().appendPicture(stream);
			// Appends the employee details in the second cell.
			paragraph = table.getRows().get(index - 1).getCells().get(1).addParagraph();
			paragraph.appendText(employee.getName() + "\n" + employee.getTitle() + "\n" + employee.getAddress() + "\n"
					+ employee.getHomePhone());
		}
		// Saves and closes the document.
		document.save("Result.docx");
		document.close();
	}

	/**
	 * 
	 * Gets the list of employee details.
	 * 
	 */
	private static ListSupport<Employees> getEmployeeDetails() throws Exception {
		// Gets list of employee details.
		ListSupport<Employees> employees = new ListSupport<Employees>(Employees.class);
		// Reads the xml document.
		FileStreamSupport fs = new FileStreamSupport(getDataDir("EmployeesList.xml"), FileMode.Open, FileAccess.Read);
		XmlReaderSupport reader = XmlReaderSupport.create(fs);
		if (reader == null)
			throw new Exception("reader");
		while (reader.getNodeType() != XmlNodeType.Element)
			reader.read();
		if (reader.getLocalName() != "Employees")
			throw new Exception(StringSupport.concat("Unexpected xml tag ", reader.getLocalName()));
		reader.read();
		while (reader.getNodeType() == XmlNodeType.Whitespace)
			reader.read();
		// Iterates to add the employee details in list.
		while (reader.getLocalName() != "Employees") 
		{
			if (reader.getNodeType() == XmlNodeType.Element) 
			{
				switch (reader.getLocalName()) 
				{
					case "Employee":
					employees.add(getEmployees(reader));
					break;
				}
			} 
			else 
			{
				reader.read();
				if ((reader.getLocalName() == "Employees") && reader.getNodeType() == XmlNodeType.EndElement)
					break;
			}
		}
		return employees;
	}

	/**
	 * 
	 * Gets the employees.
	 * 
	 * @param reader Syncfusion's XML reader to read the XML files..
	 */
	private static Employees getEmployees(XmlReaderSupport reader) throws Exception {
		if (reader == null)
			throw new Exception("reader");
		while (reader.getNodeType() != XmlNodeType.Element)
			reader.read();
		if (reader.getLocalName() != "Employee")
			throw new Exception(StringSupport.concat("Unexpected xml tag ", reader.getLocalName()));
		reader.read();
		while (reader.getNodeType() == XmlNodeType.Whitespace)
			reader.read();
		Employees employee = new Employees();
		while (reader.getLocalName() != "Employee") 
		{
			if (reader.getNodeType() == XmlNodeType.Element) 
			{
				switch (reader.getLocalName()) 
				{
					case "Name":
						employee.setName(reader.readContentAsString());
						break;
					case "Title":
						employee.setTitle(reader.readContentAsString());
						break;
					case "Address":
						employee.setAddress(reader.readContentAsString());
						break;
					case "HomePhone":
						employee.setHomePhone(reader.readContentAsString());
						break;
					case "Photo":
						employee.setPhoto(reader.readContentAsString());
						break;
					default:
						reader.skip();
						break;
				}
			} 
			else 
			{
				reader.read();
				if ((reader.getLocalName() == "Employee") && reader.getNodeType() == XmlNodeType.EndElement)
					break;
			}
		}
		return employee;
	}

	/**
	 * Get the file path
	 * 
	 * @param path specifies the file path
	 */
	private static String getDataDir(String path) {
		File dir = new File(System.getProperty("user.dir"));
		if (!(dir.toString().endsWith("Java-Word-Table-Examples")))
			dir = dir.getParentFile();
		dir = new File(dir, "resources");
		dir = new File(dir, path);
		if (dir.isDirectory() == false)
			dir.mkdir();
		return dir.toString();
	}
}
