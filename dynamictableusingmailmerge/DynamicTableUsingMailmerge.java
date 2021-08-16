import java.io.File;
import com.syncfusion.docio.*;
import com.syncfusion.javahelper.system.collections.generic.ListSupport;
import com.syncfusion.javahelper.system.io.*;
import com.syncfusion.javahelper.system.xml.*;

public class DynamicTableUsingMailmerge {

	public static void main(String[] args) throws Exception {
		// Loads the template document.
		WordDocument document = new WordDocument(getDataDir("Template.docx"), FormatType.Docx);
		// Creates MailMergeDataTable.
		MailMergeDataTable mailMergeDataTableStock = getMailMergeDataTableStock();
		// Executes Mail Merge with groups.
		document.getMailMerge().executeGroup(mailMergeDataTableStock);
		// Saves and closes the document.
		document.save("Result.docx", FormatType.Docx);
		document.close();
	}

	/**
	 * 
	 * Gets the mail merge data table.
	 * 
	 */
	private static MailMergeDataTable getMailMergeDataTableStock() throws Exception {
		// Gets list of stock details.
		ListSupport<StockDetails> stockDetails = new ListSupport<StockDetails>(StockDetails.class);
		FileStreamSupport fs = new FileStreamSupport(getDataDir("StockDetails.xml"), FileMode.Open, FileAccess.Read);
		// Reads the xml document.
		XmlReaderSupport reader = XmlReaderSupport.create(fs);
		if (reader == null)
			throw new Exception("reader");
		while (reader.getNodeType().getEnumValue() != XmlNodeType.Element.getEnumValue())
			reader.read();
		if (!(reader.getLocalName() == "StockMarket"))
			throw new Exception("Unexpected xml tag " + reader.getLocalName());
		reader.read();
		while (reader.getNodeType().getEnumValue() == XmlNodeType.Whitespace.getEnumValue())
			reader.read();
		// Iterates to add the stock details in list.
		while (!(reader.getLocalName() == "StockMarket")) 
		{
			if (reader.getNodeType().getEnumValue() == XmlNodeType.Element.getEnumValue()) 
			{
				switch ((reader.getLocalName()) == null ? "string_null_value" : (reader.getLocalName())) 
				{
					case "StockDetails":
						stockDetails.add(getStockDetails(reader));
						break;
				}
			} 
			else 
			{
				reader.read();
				if ((reader.getLocalName() == "StockMarket")
						&& reader.getNodeType().getEnumValue() == XmlNodeType.EndElement.getEnumValue())
					break;
			}
		}
		// Creates an instance of MailMergeDataTable by specifying mail merge group name and IEnumerable collection.
		MailMergeDataTable dataTable = new MailMergeDataTable("StockDetails", stockDetails);
		reader.close();
		fs.close();
		return dataTable;
	}

	/**
	 * 
	 * Gets the StockDetails.
	 * 
	 * @param reader The reader.
	 */
	private static StockDetails getStockDetails(XmlReaderSupport reader) throws Exception {
		if (reader == null)
			throw new Exception("reader");
		while (reader.getNodeType().getEnumValue() != XmlNodeType.Element.getEnumValue())
			reader.read();
		if (!(reader.getLocalName() == "StockDetails"))
			throw new Exception("Unexpected xml tag " + reader.getLocalName());
		reader.read();
		while (reader.getNodeType().getEnumValue() == XmlNodeType.Whitespace.getEnumValue())
			reader.read();
		StockDetails stockDetails = new StockDetails();
		while (!(reader.getLocalName() == "StockDetails")) 
		{
			if (reader.getNodeType().getEnumValue() == XmlNodeType.Element.getEnumValue()) 
			{
				switch ((reader.getLocalName()) == null ? "string_null_value" : (reader.getLocalName())) 
				{
					case "TradeNo":
						stockDetails.setTradeNo(reader.readContentAsString());
						break;
					case "CompanyName":
						stockDetails.setCompanyName(reader.readContentAsString());
						break;
					case "CostPrice":
						stockDetails.setCostPrice(reader.readContentAsString());
						break;
					case "SharesCount":
						stockDetails.setSharesCount(reader.readContentAsString());
						break;
					case "SalesPrice":
						stockDetails.setSalesPrice(reader.readContentAsString());
						break;
					default:
						reader.skip();
						break;
				}
			} 
			else 
			{
				reader.read();
				if ((reader.getLocalName() == "StockDetails")
						&& reader.getNodeType().getEnumValue() == XmlNodeType.EndElement.getEnumValue())
					break;
			}
		}
		return stockDetails;
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
