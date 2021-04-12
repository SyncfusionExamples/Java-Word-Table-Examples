import java.io.File;
import com.syncfusion.docio.*;
import com.syncfusion.javahelper.system.drawing.ColorSupport;

public class ApplyCustomTableStyles {

	public static void main(String[] args) throws Exception {
		// Creates new Word document instance and open the word document
		WordDocument document = new WordDocument(getDataDir("Table.docx"));
		// Adds a new custom table style.
		WTableStyle tableStyle = (WTableStyle) document.addTableStyle("CustomStyle");
		// Applies formatting for whole table.
		tableStyle.getTableProperties().setRowStripe(1);
		tableStyle.getTableProperties().setColumnStripe(1);
		tableStyle.getTableProperties().getPaddings().setTop(0);
		tableStyle.getTableProperties().getPaddings().setBottom(0);
		tableStyle.getTableProperties().getPaddings().setLeft(5.4f);
		tableStyle.getTableProperties().getPaddings().setRight(5.4f);
		// Applies conditional formatting for first row.
		ConditionalFormattingStyle firstRowStyle = tableStyle.getConditionalFormattingStyles()
				.add(ConditionalFormattingType.FirstRow);
		firstRowStyle.getCharacterFormat().setBold(true);
		firstRowStyle.getCharacterFormat().setTextColor(ColorSupport.fromArgb(255, 255, 255, 255));
		firstRowStyle.getCellProperties().setBackColor(ColorSupport.getBlue());
		// Applies conditional formatting for first column.
		ConditionalFormattingStyle firstColumnStyle = tableStyle.getConditionalFormattingStyles()
				.add(ConditionalFormattingType.FirstColumn);
		firstColumnStyle.getCharacterFormat().setBold(true);
		// Applies conditional formatting for odd row.
		ConditionalFormattingStyle oddRowBandingStyle = tableStyle.getConditionalFormattingStyles()
				.add(ConditionalFormattingType.OddRowBanding);
		oddRowBandingStyle.getCellProperties().setBackColor(ColorSupport.getWhiteSmoke());
		// Gets table to apply style.
		WSection section = document.getSections().get(0);
		WTable table = section.getTables().get(0);
		// Applies the custom table style to the table.
		table.applyStyle("CustomStyle");
		// Saves and closes the document instance
		document.save("Result.docx", FormatType.Docx);
		document.close();
		System.out.println("Word document generated successfully.");
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
}
