import java.io.*;
import java.util.List;
import javax.xml.bind.*;
import com.syncfusion.docio.*;
import com.syncfusion.javahelper.system.*;

public class WordTable
{
	public static void main(String[] args) throws Exception 
	{
		// Loads the XML file.
		File file = new File(getDataDir("EmployeesList.xml"));
		// Create a new instance for the JAXBContext.
		JAXBContext jaxbContext = JAXBContext.newInstance(Employees.class);
		// Reads the XML file.
		Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
		Employees employees = (Employees) jaxbUnmarshaller.unmarshal(file);
		// Gets the list of employee details.
		List<Employee> employeeList = employees.getEmployees();
		// Loads the template document.
		WordDocument document = new WordDocument(getDataDir("WordTable_Template.docx"));
		// Iterates each item in the list.
		for (Employee employee : employeeList) 
		{
			// Accesses the table in the document.
			IWTable table = document.getSections().get(0).getTables().get(0);
			// Initializes the paragraph and add new row to the table.
			IWParagraph paragraph = null;
			table.addRow();
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
