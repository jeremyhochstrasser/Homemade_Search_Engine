

//Author JEREMY HOCHSTRASSER 
//WORKS CITED
//REFERANCE AND MAIN TEMPLATE
//https://www.guru99.com/java-swing-gui.html

//


import javax.swing.*;

import org.apache.lucene.analysis.core.WhitespaceAnalyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.Term;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.BooleanClause;
import org.apache.lucene.search.BooleanQuery;
import org.apache.lucene.search.BoostQuery;
import org.apache.lucene.search.MatchAllDocsQuery;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.RegexpQuery;
import org.apache.lucene.search.TopDocs;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.PrintStream;
import java.sql.Date;


//A Simple java class to impliment the search function and return results of a simple GUI


public class mainGUI {
	static //create a text feild to store the name of the paper in.

	JTextField containsQueryText = new JTextField(10); // accepts upto 10 characters
	static JTextField authorQueryText = new JTextField(10); // accepts upto 10 characters
	private static JScrollPane scroll;
	
	private static String location = " ";
	static JTextArea ta = new JTextArea();

	
	public static void main(String args[]) {
		
		

        //Creating the Frame
        JFrame frame = new JFrame("good enough ~Search Engine~");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 600);
        //center it
        frame.setLocationRelativeTo(null);

        //Creating the MenuBar and adding components
        JMenuBar mb = new JMenuBar();
        JMenu m1 = new JMenu("FILE");
        JMenu m2 = new JMenu("Help");
        mb.add(m1);
        mb.add(m2);
        JMenuItem m11 = new JMenuItem("Open");
        JMenuItem m12 = new JMenuItem("Save all");
        JMenuItem login = new JMenuItem("Connect to Online Database");
        m1.add(m11);
        m1.add(m12);
        m1.add(login);
        JMenuItem m21 = new JMenuItem("im stuck too");
        m2.add(m21);

        //Creating the panel at bottom and adding components
        JPanel panel = new JPanel(); // the panel is not visible in output
        JPanel panel2 = new JPanel();

        JLabel authorLabel = new JLabel("Author");
        JLabel containsLabel = new JLabel("Contains");

        
        JButton send = new JButton("Search");
        JButton reset = new JButton("Clear");
        JButton view = new JButton("View");

        panel.add(authorLabel); // Components Added using Flow Layout
        panel.add(authorQueryText);
        panel.add(containsLabel); // Components Added using Flow Layout
        panel.add(containsQueryText);

        panel.add(send);
        panel.add(reset);
        //panel.add(login);
        panel.add(view);

        // Text Area at the Center
        
        ta.setEditable(false); // set textArea non-editable
        //add scrollbar
        scroll = new JScrollPane(ta);
        scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        
        panel.add(scroll);
        
        PrintStream ps = new PrintStream(new CustomStream(ta));
        System.setOut(ps);
        System.setErr(ps);

        //Adding Components to the frame.
        frame.getContentPane().add(BorderLayout.SOUTH, panel);
        frame.getContentPane().add(BorderLayout.NORTH, mb);
        frame.getContentPane().add(BorderLayout.CENTER, scroll);
        //frame.getContentPane().add(BorderLayout., panel2);
        frame.setVisible(true);

        
        //create and action for clicking the send button
        send.addActionListener(new ActionListener() {
        	@Override
            public void actionPerformed(ActionEvent e) {

        		String query = " ";
        		String authorQuery;
        		String contentQuery;
				
				float authorBoost = 10.0f;
				float contentBoost = 10.0f;
				RegexpQuery regularExpAuth, regularExpCont;
                
				if (authorQueryText.getText().isBlank())
				{
					regularExpAuth = new RegexpQuery(new Term("author", "[a-z]*"));
				}
				else 
				{
					regularExpAuth = new RegexpQuery(new Term("author", authorQueryText.getText()));
				}
				
				if (containsQueryText.getText().isBlank())
				{
					regularExpCont = new RegexpQuery(new Term("contents", "[a-z]*"));
				}
				else 
				{
					regularExpCont = new RegexpQuery(new Term("contents", containsQueryText.getText()));
				}

                try {

                	QueryParser qp = new QueryParser(LuceneConstants.CONTENTS,
                	         new StandardAnalyzer());
                	

                	
                

           
                	Searcher S = new Searcher("C:\\\\Lucene\\\\Index");

                	
					Query fullQuery2 = new BooleanQuery.Builder().add(new BoostQuery(regularExpAuth , 1.0f), BooleanClause.Occur.MUST).add(new BoostQuery(regularExpCont, 1.0f), BooleanClause.Occur.MUST).build();
                	TopDocs docs = (S.search(fullQuery2));

					
					
					long i = docs.totalHits.value;
					for (long x = 0; x < i; x++) {
					Document doc5 = S.getDocument(docs.scoreDocs[(int) x]);
					System.out.println("Search string: " + query);
					System.out.println("Result: " + doc5);
					}
                	
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
            }
        });
        
        
        //create an action for clicking the reset button
        reset.addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        			try {
        				ta.setText(null);

        				

        			} catch (Exception e1) {
        				e1.printStackTrace();
        			}
        	}
        });
        
        view.addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		mouseReleased();
        		String path = location;
        		File fp = new File(path);
        		System.out.println(path);
        		AppPDF pdfViewer = new AppPDF();
        		try {
        			pdfViewer.view(fp);
        		} catch (Exception e1) {
        			e1.printStackTrace();
        		}
        	}
        });

        
        login.addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		MySQLAccess connectOBJ = new MySQLAccess();
        		try {
					connectOBJ.readDataBase();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
        		



        	}
        });
        


    }
	
    public static void mouseReleased() {
        if (ta.getSelectedText() != null) { // See if they selected something 
            location = ta.getSelectedText();
            // Do work with String s
        }
    }
	
}

