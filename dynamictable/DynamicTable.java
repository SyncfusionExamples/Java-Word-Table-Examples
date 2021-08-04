import com.syncfusion.docio.*;

public class DynamicTable {

	public static void main(String[] args) throws Exception {
		// Creates an instance of WordDocument class.
		WordDocument document = new WordDocument();
		// Adds a section to the Word document.
		IWSection section = document.addSection();
		// Adds new text to the paragraph.
		section.addParagraph().appendText("Price Details");
		section.addParagraph();
		// Adds a new table into Word document.
		IWTable table = section.addTable();
		// Adds the first row into table.
		WTableRow row = table.addRow();
		// Adds the first cell into first row .
		WTableCell cell = row.addCell();
		cell.addParagraph().appendText("Item");
		// Adds the second cell into first row.
		cell = row.addCell();
		cell.addParagraph().appendText("Price($)");
		// Adds the second row into table.
		row = table.addRow(true, false);
		// Adds the first cell into second row.
		cell = row.addCell();
		cell.addParagraph().appendText("Apple");
		// Adds the second cell into second row.
		cell = row.addCell();
		cell.addParagraph().appendText("50");
		// Adds the third row into table.
		row = table.addRow(true, false);
		// Adds the first cell into third row.
		cell = row.addCell();
		cell.addParagraph().appendText("Orange");
		// Adds the second cell into third row.
		cell = row.addCell();
		cell.addParagraph().appendText("30");
		// Adds the fourth row into table.
		row = table.addRow(true, false);
		// Adds the first cell into fourth row.
		cell = row.addCell();
		cell.addParagraph().appendText("Banana");
		// Adds the second cell into fourth row.
		cell = row.addCell();
		cell.addParagraph().appendText("20");
		// Adds the fifth row to table.
		row = table.addRow(true, false);
		// Adds the first cell into fifth row.
		cell = row.addCell();
		cell.addParagraph().appendText("Grapes");
		// Adds the second cell into fifth row.
		cell = row.addCell();
		cell.addParagraph().appendText("70");
		// Saves and closes the document instance.
		document.save("Result.docx", FormatType.Docx);
		document.close();
	}
}
