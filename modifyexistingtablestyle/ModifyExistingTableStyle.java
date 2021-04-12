import java.io.File;
import com.syncfusion.docio.*;
import com.syncfusion.javahelper.system.drawing.ColorSupport;

public class ModifyExistingTableStyle {

	public static void main(String[] args) throws Exception {
		// Creates new Word document instance and open the word document
		WordDocument document = new WordDocument(getDataDir("TableModify.docx"));
		// Gets the table style (Medium Shading 1 Accent 1) from the styles collection.
		WTableStyle tableStyle = (WTableStyle) document.getStyles().findByName("Medium Shading 1 Accent 1",
				StyleType.TableStyle);
		// Gets the conditional formatting style of the first row (table headers) from
		// the table style.
		ConditionalFormattingStyle firstRowStyle = tableStyle.getConditionalFormattingStyles()
				.get(ConditionalFormattingType.FirstRow);
		if (firstRowStyle != null) {
			// Modifies the background color for first row (table headers).
			firstRowStyle.getCellProperties().setBackColor(ColorSupport.fromArgb(255, 31, 56, 100));
		}
		// Saves the file
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
