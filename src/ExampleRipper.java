

public class ExampleRipper {
	
	public static void main(String[] args)
	{
		String[] files = new String[] {
				"2009.08775.pdf" , "FOMO_JSPR.pdf" , 
				"Evidence_for_self-organized_criticality_in_Interne.pdf",
				"Theories-Methods-and-Current-Research-on-Emotions.pdf"
			};
		PDFToTXT test = new PDFToTXT(files);
		String[] results = test.getTXTfiles();
		FileAuthorDictionary list = new FileAuthorDictionary();
		for (String fname :results)
		{
			System.out.println((fname));
		}
		
	}
}
