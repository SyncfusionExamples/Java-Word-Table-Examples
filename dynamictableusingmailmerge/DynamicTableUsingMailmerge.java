import java.io.File;
import java.util.List;
import com.syncfusion.docio.*;
import com.syncfusion.javahelper.system.collections.generic.ListSupport;
import javax.xml.bind.*;

public class DynamicTableUsingMailmerge 
{
	public static void main(String[] args) throws Exception 
	{
		// Loads the XML file.
		File file = new File(getDataDir("StockDetails.xml"));
		// Create a new instance for the JAXBContext.
		JAXBContext jaxbContext = JAXBContext.newInstance(StockMarket.class);
		// Reads the XML file.
		Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
		StockMarket stockMarket = (StockMarket) jaxbUnmarshaller.unmarshal(file);
		// Gets the list of stock details.
		List<StockDetails> list =  stockMarket.getStockDetails();
		ListSupport<StockDetails> stockDetails =  new ListSupport<StockDetails>(StockDetails.class);		
		for(StockDetails stock : list) 
		{
			//Add all items in the list to ListSupport to perform mail merge. 
			stockDetails.add(stock);
		}
		// Loads the template document.
		WordDocument document = new WordDocument(getDataDir("Template.docx"), FormatType.Docx);
		MailMergeDataTable dataTable = new MailMergeDataTable("StockDetails", stockDetails);
		// Executes Mail Merge with group.
		document.getMailMerge().executeGroup(dataTable);
		// Saves and closes the document.
		document.save("Result.docx", FormatType.Docx);
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
