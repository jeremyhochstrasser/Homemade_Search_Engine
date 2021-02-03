
import java.util.ArrayList;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.lucene.document.Document;
import org.apache.lucene.index.IndexableField;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.search.TopDocs;

public class SearchTest {

	
	public static void main(String[] args)
	{
		try {
			System.out.println("Test 1:");
			Searcher test = new Searcher("C:\\\\Lucene\\\\Index");
			
			TopDocs results1 = test.search("FOMO");
			
			Document doc1 = test.getDocument(results1.scoreDocs[0]);
			System.out.println("Search string: 'FOMO' ");
			System.out.println("Result: " + doc1);		
			
			System.out.println("Test 2:");

			TopDocs results2 = test.search("Research");
			
			Document doc2 = test.getDocument(results2.scoreDocs[0]);
			System.out.println("Search string: 'Research' ");
			System.out.println("Result: " + doc2);
			
			System.out.println("Test 3:");

			TopDocs results3 = test.search("Machine");
			
			Document doc3 = test.getDocument(results3.scoreDocs[0]);
			System.out.println("Search string: 'Machine' ");
			System.out.println("Result: " + doc3);
			
			System.out.println("Test 4:");

			TopDocs results4 = test.search("Evidence");
			
			Document doc4 = test.getDocument(results4.scoreDocs[0]);
			System.out.println("Search string: 'Evidence' ");
			System.out.println("Result: " + doc4);
			
//			TopDocs results5 = test.search("author:'Megan'");
//			
//			Document doc5 = test.getDocument(results5.scoreDocs[0]);
//			System.out.println("Search string: 'author:Megan'");
//			System.out.println("Result: " + doc5);
		
			MySQLAccess authorInsert = new MySQLAccess();
			try {
//				authorInsert.readDataBase("msandbox", "learn123", 3306);
//
//				System.out.println("\nEvidence_for_self-organized_criticality_in_Internet authors:");
//				ArrayList<String> EvidenceSelfOrganized = findAuthor("Evidence_for_self-organized_criticality_in_Interne.txt");
//				authorInsert.insertAuthors(EvidenceSelfOrganized);
//
//				System.out.println("\nFOMO_JSPR authors:");
//				ArrayList<String> FOMO_JSPR = findAuthor("FOMO_JSPR.txt");
//				authorInsert.insertAuthors(FOMO_JSPR);
//
//				System.out.println("\n2009.08775 authors");
//				ArrayList<String> authors2009_08775 = findAuthor("2009.08775.txt");
//				authorInsert.insertAuthors(authors2009_08775);
//
//				System.out.println("\nTheories-Methods-and-Current-Research-on-Emotions authors");
//				ArrayList<String> TheoriesMethodsCurrentResearch = findAuthor("Theories-Methods-and-Current-Research-on-Emotions.txt");
//				authorInsert.insertAuthors(TheoriesMethodsCurrentResearch);
				
				System.out.println("\nTheories-Methods-and-Current-Research-on-Emotions.txt Dates:");
				ArrayList<String> EvidenceDates = findDates("Theories-Methods-and-Current-Research-on-Emotions.txt");	
			      for (int i = 0; i < EvidenceDates.size();i++) 
			      { 		      
			          System.out.println(EvidenceDates.get(i)); 		
			      }  
				
				System.out.println("\n2009.08775.txt Dates:");
				ArrayList<String> dates2009 = findDates("2009.08775.txt");	
				  for (int i = 0; i < dates2009.size();i++) 
				  { 		      
				      System.out.println(dates2009.get(i)); 		
				  }  
					

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		} catch (IOException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		} catch (ParseException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}

	public static ArrayList<String> findAuthor(String fileName) {
		String docsPath = "C:\\Lucene\\Data\\";
		File file = new File(docsPath + fileName);
	    Scanner scanner;
		try {
			scanner = new Scanner(file);
		    //now read the file line by line...
//		    int lineNum = 0;
			System.out.println("Testing on : " + fileName);
		   	ArrayList<String> paperDetails = new ArrayList<String>();
			
		    while (scanner.hasNextLine()) {
		        String line = scanner.nextLine();
		        if(line.contains("Abstract")) 
		        {
		        	return paperDetails;
		        }
		        if(lineContainsAuthor(line)) 
		        { 
		        	String authors[] = line.split(",");
		        	
		        	for(int i = 0; i < authors.length; i++) 
		        	{
		        		if(!basicFilter(authors[i]))
		        		{
		        			String authorValue = trimAuthor(authors[i]).trim();
		        			paperDetails.add(authorValue);
		        			System.out.println(authorValue);
		        		}
		        	}
		        	System.out.println("Found it!");
		            System.out.println(line);
		           
//		            break;
		        }
		    }
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public static ArrayList<String> findDates(String fileName) {

		String docsPath = "C:\\Lucene\\Data\\";
		File file = new File(docsPath + fileName);
	    Scanner scanner;
	    ArrayList<String> dateDetails = new ArrayList<String>();
		
		try {
			scanner = new Scanner(file);
		    //now read the file line by line...
//		    int lineNum = 0;
			System.out.println("Testing on : " + fileName);
			
		    while (scanner.hasNextLine()) {
		        String line = scanner.nextLine();
//		        if(line.contains("Abstract")) 
//		        {
//		        	return dateDetails;
//		        }
		        Scanner token = new Scanner(line);
		        while(token.hasNext()) {
		        	String tok = token.next();
			        if(lineContainsDate(tok)) 
			        { 
//			        	System.out.println("Found it!");
//			            System.out.println(tok);
			            dateDetails.add(tok);
			           
	//		            break;
			        }
		        }
		    }
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dateDetails;
	}
      
	public static boolean basicFilter(String author) {
		String pattern0 = "[1-9]+.*";
		String pattern1 = ".*[.txt]+";
		if(author.matches(pattern0) || author.matches(pattern1)) {
			return true;
		}
		else {
			return false;
		}
	}
	public static String trimAuthor(String author) {

		char characters[] = author.toCharArray();

		StringBuilder sb = new StringBuilder();

		for(char c : characters) {
			if(Character.isLetter(c) || Character.isWhitespace(c) || c == '.') {
				sb.append(c);
			}
		}

		return sb.toString();

	}

	public static boolean lineContainsAuthor(String line) {
        String pattern0 = ".+[,][?]$"; // finds ",?" at end of author line in Theories-Methods-and-Current-Research-on-Emotions.txt
        String pattern1 = ".+[?][,].+"; // finds "?," in middle of author line in 2009.08775.txt
        String pattern2 = "[A-Z][a-z]+ [A-Z][.] [A-Z][a-z]+ .+"; //finds "First M. Last ?" in Evidence_for_self-organized_criticality_in_Interne.txt AND FOMO_JSPR
        String pattern3 = "[A-Z][a-z]+(?: [A-Z]\\\\.)? [A-Z][a-z]+(?:.*)?";
        String pattern4 = "[A-Z][a-z]+(?: [A-Z]\\.)? [A-Z][a-z]+.*";
        
        if (line.matches(pattern1) || line.matches(pattern2)||line.matches(pattern3) || line.matches(pattern4) || line.matches(pattern0)) {
//            System.out.println(line + " matches \"" + pattern + "\"");
            return true;
        } else {
//            System.out.println("NO MATCH");
            return false;
        }
	}

	
	public static boolean lineContainsDate(String line) {
		String pattern = "(19|20)[0-9][0-9]";
        if (line.matches(pattern)) {
          return true;
      } else {
          return false;
      }
		
	}
}
