

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;


public class PDFToTXT {
	
	private String fileNames[];
	private String txtNames[];
	
	public PDFToTXT(String fileNames[]){
		this.fileNames = fileNames;
		this.txtNames = new String[fileNames.length];
	}
	
	private void convertPDFs(){
		int i = 0;
		File path = new File("C:\\Lucene\\Data");
		path.mkdir();
		for (String fname : this.fileNames)
		{
			try {
			File pdffile = new File(fname);
			
			PDDocument doc 	= PDDocument.load(pdffile);
			
			PDFTextStripper pdfStripper = new PDFTextStripper();
			
			String text = pdfStripper.getText(doc);
			String txtName = fname.substring(0, fname.length()- 4) + ".txt";
			File txtFile = new File("C:\\Lucene\\Data\\"+txtName);
			PrintWriter out = new PrintWriter(txtFile);
			
			out.println(text);
			this.txtNames[i] = txtFile.getAbsolutePath();
			
			doc.close();
			out.close();
			i++;
			}catch(IOException e)
			{
				System.out.println("File Not Found");
			}
		}
	}
	/**
	 * 
	 * @return Array of file names to txt version of pdfs. 
	 */
	public String[] getTXTfiles()
	{
		convertPDFs();
		return txtNames;
		
	}
}
