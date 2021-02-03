import java.util.HashMap;

public class FileAuthorDictionary {
	
	private HashMap<String, String> paperToAuthor;
	
	public FileAuthorDictionary() {
		String[] authors = new String[] {
				"Megan", "Megan", "Conrad", "Mario"
		};
		String[] files = new String[] {
				"2009.08775.pdf" , "FOMO_JSPR.pdf" , 
				"Evidence_for_self-organized_criticality_in_Interne.pdf",
				"Theories-Methods-and-Current-Research-on-Emotions.pdf"
			};
		PDFToTXT test = new PDFToTXT(files);
		String[] results = test.getTXTfiles();
		paperToAuthor = new HashMap<String,String>();
		int i = 0;
		for(String name: results) {
			paperToAuthor.put(name, authors[i]);
			i++;
		}
	}
	
	public String getAuthor(String paper) {
		String author = paperToAuthor.get(paper);
		return author;
	}
}
