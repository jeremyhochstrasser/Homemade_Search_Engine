import java.awt.Desktop;
import java.io.File;


public class AppPDF {
	public void view(File fileLocation) {
		try {
			File pdfFile = fileLocation;
		if(pdfFile.exists()) {
			if(Desktop.isDesktopSupported()) 
				Desktop.getDesktop().open(pdfFile);
			else
				System.out.println("\nDesktop view unsupported.\n");
		} else
			System.out.println("\nFile does not exist.\n");
		System.out.println("\nDone.\n");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
