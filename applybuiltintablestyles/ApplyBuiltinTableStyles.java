import java.io.File;
import com.syncfusion.docio.*;
import com.syncfusion.javahelper.system.drawing.ColorSupport;
import com.syncfusion.javahelper.system.io.*;
import com.syncfusion.javahelper.system.xml.*;

public class ApplyBuiltinTableStyles {

	public static void main(String[] args) throws Exception {
		// Creates new Word document instance and open the word document
		WordDocument document = new WordDocument();
		// Adds a section to the Word document.
		IWSection section = document.addSection();
		// Sets the page margin
		section.getPageSetup().getMargins().setAll(72);
		// Adds a paragraph to the section.
		IWParagraph paragraph = section.addParagraph();
		paragraph.getParagraphFormat().setHorizontalAlignment(HorizontalAlignment.Center);
		paragraph.getParagraphFormat().setAfterSpacing(20);
		IWTextRange textRange = paragraph.appendText("Suppliers");
		textRange.getCharacterFormat().setFontSize(14);
		textRange.getCharacterFormat().setBold(true);
		textRange.getCharacterFormat().setTextColor(ColorSupport.fromArgb(255, 50, 62, 79));
		// Modifies the font size to 10 for default paragraph style.
		WParagraphStyle style = (WParagraphStyle) document.getStyles().findByName("Normal");
		style.getCharacterFormat().setFontSize(10);
		// Adds a table to the section.
		WTable table = (WTable) section.addTable();
		table.resetCells(1, 6);
		table.get(0, 0).setWidth(52f);
		table.get(0, 0).addParagraph().appendText("Supplier ID");
		table.get(0, 1).setWidth(128f);
		table.get(0, 1).addParagraph().appendText("Company Name");
		table.get(0, 2).setWidth(70f);
		table.get(0, 2).addParagraph().appendText("Contact Name");
		table.get(0, 3).setWidth(92f);
		table.get(0, 3).addParagraph().appendText("Address");
		table.get(0, 4).setWidth(66.5f);
		table.get(0, 4).addParagraph().appendText("City");
		table.get(0, 5).setWidth(56f);
		table.get(0, 5).addParagraph().appendText("Country");
		// Imports data to the table.
		ImportDataToTable(table);
		// Applies the built-in table style (Medium Shading 1 Accent 1) to the table.
		table.applyStyle(BuiltinTableStyle.MediumShading1Accent1);
		// Saves the file
		document.save("Result.docx", FormatType.Docx);
		document.close();
		System.out.println("Word document generated successfully.");
	}

	private static void ImportDataToTable(WTable table) throws Exception {
		FileStreamSupport fs = new FileStreamSupport(getDataDir("Suppliers.xml"), FileMode.Open, FileAccess.Read);
		XmlReaderSupport reader = XmlReaderSupport.create(fs);
		if (reader == null)
			throw new Exception("reader");
		while (reader.getNodeType().getEnumValue() != XmlNodeType.Element.getEnumValue())
			reader.read();
		if (!(reader.getLocalName() == "SuppliersList"))
			throw new Exception("Unexpected xml tag " + reader.getLocalName());
		reader.read();
		while (reader.getNodeType().getEnumValue() == XmlNodeType.Whitespace.getEnumValue())
			reader.read();
		while (!(reader.getLocalName() == "SuppliersList")) {
			if (reader.getNodeType().getEnumValue() == XmlNodeType.Element.getEnumValue()) {
				switch (reader.getLocalName()) {
				case "Suppliers":
					WTableRow tableRow = table.addRow(true);
					ImportDataToRow(reader, tableRow);
					break;
				}
			} else {
				reader.read();
				if ((reader.getLocalName() == "Suppliers")
						&& reader.getNodeType().getEnumValue() == XmlNodeType.EndElement.getEnumValue())
					break;
			}
		}
		reader.close();
		fs.close();
	}

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

	private static void ImportDataToRow(XmlReaderSupport reader, WTableRow tableRow) throws Exception {
		if (reader == null)
			throw new Exception("reader");
		while (reader.getNodeType().getEnumValue() != XmlNodeType.Element.getEnumValue())
			reader.read();
		if (!(reader.getLocalName() == "Suppliers"))
			throw new Exception("Unexpected xml tag " + reader.getLocalName());
		reader.read();
		while (reader.getNodeType().getEnumValue() == XmlNodeType.Whitespace.getEnumValue())
			reader.read();
		while (!(reader.getLocalName() == "Suppliers")) {
			if (reader.getNodeType().getEnumValue() == XmlNodeType.Element.getEnumValue()) {
				switch (reader.getLocalName()) {
				case "SupplierID":
					tableRow.getCells().get(0).addParagraph().appendText(reader.readContentAsString());
					break;
				case "CompanyName":
					tableRow.getCells().get(1).addParagraph().appendText(reader.readContentAsString());
					break;
				case "ContactName":
					tableRow.getCells().get(2).addParagraph().appendText(reader.readContentAsString());
					break;
				case "Address":
					tableRow.getCells().get(3).addParagraph().appendText(reader.readContentAsString());
					break;
				case "City":
					tableRow.getCells().get(4).addParagraph().appendText(reader.readContentAsString());
					break;
				case "Country":
					tableRow.getCells().get(5).addParagraph().appendText(reader.readContentAsString());
					break;
				default:
					reader.skip();
					break;
				}
			} else {
				reader.read();
				if ((reader.getLocalName() == "Suppliers")
						&& reader.getNodeType().getEnumValue() == XmlNodeType.EndElement.getEnumValue())
					break;
			}
		}
	}
}
