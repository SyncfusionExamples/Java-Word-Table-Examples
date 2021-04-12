import java.io.File;
import com.syncfusion.docio.*;

public class CopyTableStyles {

	public static void main(String[] args) throws Exception {
		// Creates new Word document instance and open the word document
		WordDocument document = new WordDocument(getDataDir("Table.docx"));
		// Creates new Word srcdocument instance and Opens the source Word document
		// containing table style definition.
		WordDocument srcdocument = new WordDocument(getDataDir("TableStyles.docx"));
		// Gets the table style (CustomStyle) from the styles collection.
		WTableStyle tableStyle = (WTableStyle) srcdocument.getStyles().findByName("CustomStyle", StyleType.TableStyle);
		// Creates a cloned copy of table style.
		WTableStyle clonedTableStyle = (WTableStyle) tableStyle.clone();
		// Adds the cloned copy of source table style to the destination document.
		document.getStyles().add(clonedTableStyle);
		srcdocument.close();
		// Gets table to apply style.
		WSection section = document.getSections().get(0);
		WTable table = section.getTables().get(0);
		// Adds a new custom table style.
		table.applyStyle("CustomStyle");
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
