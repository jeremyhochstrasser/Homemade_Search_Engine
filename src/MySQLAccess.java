import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.Date;

public class MySQLAccess {

	private Connection c = null;
	private Statement s = null;
	private PreparedStatement pS = null;
	private ResultSet rS = null;
	private String author = null;
	private String paperTitle = null;
	private String pAbstract = null;
	private String contents = null;
	private double indexVal = 0.00;
	private Date paperDate = null;
	
	
	
	public void readDataBase() 
		throws Exception {
		try {
			System.out.println("Starting...");
			connectionSetup();
			s = c.createStatement();
			rS = s.executeQuery("SELECT * FROM heroku_c62394d4736ae72.Contents");
			writeResultSet(rS);
			
//			pS = c.prepareStatement("INSERT IGNORE INTO heroku_c62394d4736ae72.Contents values (default, ?, ?, ?, ?, ?, ?)");
//			pS.setDouble(1, 10.2);
//			pS.setString(2, "TestAuthor");
//			pS.setString(3, "TestPaperTitle");
//			pS.setString(4, "TestAbstract");
//			pS.setString(5, "TestContents");
//			Date paperDate = Date.valueOf("2020-10-21");
//			pS.setDate(6, paperDate);
//			pS.executeUpdate();
//			
//			pS = c.prepareStatement("SELECT IndexVal, Author, PaperTitle, Abstract, Contents, Datum FROM heroku_c62394d4736ae72.Contents");
//			rS = pS.executeQuery();
//			writeResultSet(rS);
			rS = s.executeQuery("SELECT * FROM heroku_c62394d4736ae72.Contents");
			writeMetaData(rS);
		} catch (Exception e) {
			throw e;
		} finally {
			System.out.println("Reached close.\n");
			close();
		}
	}
	
	public void insertAuthor(String auth) 
		throws Exception {
		try {
				connectionSetup();
//				s = c.createStatement();
//				rS = s.executeQuery("SELECT * FROM heroku_c62394d4736ae72.Contents");
//				pS = c.prepareStatement("INSERT IGNORE INTO heroku_c62394d4736ae72.Contents values (default, ?, ?, ?, ?, ?, ?)");
//				pS.setDouble(1, 10);
//				pS.setString(2, author);
//				pS.setString(3, "TestPaperTitle");
//				pS.setString(4, "TestAbstract");
//				pS.setString(5, "TestContents");
//				Date paperDate = Date.valueOf("2020-10-21");
//				pS.setDate(6, paperDate);
//				pS.executeUpdate();
//				pS = c.prepareStatement("SELECT IndexVal, Author, PaperTitle, Abstract, Contents, Datum FROM heroku_c62394d4736ae72.Contents "
//						+ "WHERE Author = ? ;");
//				pS.setString(1, author);
//				
//				rS = pS.executeQuery();
//				writeResultSet(rS);
				author = auth;
		} catch (Exception e) {
			throw e;
		} finally {
			System.out.println("Inserted Author.\n");
			close();
		}
	}
	

	public void insertAuthors(ArrayList<String> auths) 
		throws Exception {
		try {
				String authorTemp = "";
				connectionSetup();
				for (String x: auths)
				{
					authorTemp += x + " ";
				}
				author = authorTemp;
//				s = c.createStatement();
//				rS = s.executeQuery("SELECT * FROM heroku_c62394d4736ae72.Contents");
//				pS = c.prepareStatement("INSERT IGNORE INTO heroku_c62394d4736ae72.Contents values (default, ?, ?, ?, ?, ?, ?)");
//				pS.setDouble(1, 10);

//				pS.setString(2, authorTemp);
//				pS.setString(3, "TestPaperTitle");
//				pS.setString(4, "TestAbstract");
//				pS.setString(5, "TestContents");
//				Date paperDate = Date.valueOf("2020-10-21");
//				pS.setDate(6, paperDate);
//				pS.executeUpdate();
//				pS = c.prepareStatement("SELECT IndexVal, Author, PaperTitle, Abstract, Contents, Datum FROM heroku_c62394d4736ae72.Contents "
//						+ "WHERE Author = ? ;");
//				pS.setString(1, author);
//				
//				rS = pS.executeQuery();
//				writeResultSet(rS);
		} catch (Exception e) {
			throw e;
		} finally {
			System.out.println("Inserted Author.\n");
			close();
		}
	}
	
	
	/*
	 * Needs the use of the SQL.Date package
	 * i.e. YYYY-MM-DD
	 */
	public void insertDate(Date d) 
		throws Exception {
		try {
				connectionSetup(); 
//				s = c.createStatement();
//				rS = s.executeQuery("SELECT * FROM heroku_c62394d4736ae72.Contents");
//				pS = c.prepareStatement("INSERT IGNORE INTO heroku_c62394d4736ae72.Contents values (default, ?, ?, ?, ?, ?, ?)");
//				pS.setDouble(1, 10.1);
//				pS.setString(2, "TestAuthor");
//				pS.setString(3, "TestPaperTitle");
//				pS.setString(4, "TestAbstract");
//				pS.setString(5, "TestContents");
//				pS.setDate(6, d);
//				pS.executeUpdate();
//				pS = c.prepareStatement("SELECT IndexVal, Author, PaperTitle, Abstract, Contents, Datum FROM heroku_c62394d4736ae72.Contents "
//						+ "WHERE Datum = ? ;");
//				pS.setDate(1, d);
//				rS = pS.executeQuery();
//				writeResultSet(rS);
				paperDate = d;
		} catch (Exception e) {
			throw e;
		} finally {
			System.out.println("Inserted Date.\n");
			close();
		}
	}
	
	public void insertTitle(String title) 
	    throws Exception {
		try {
				connectionSetup();
//				s = c.createStatement();
//				rS = s.executeQuery("SELECT * FROM heroku_c62394d4736ae72.Contents");
//				pS = c.prepareStatement("INSERT IGNORE INTO heroku_c62394d4736ae72.Contents values (default, ?, ?, ?, ?, ?, ?)");
//				pS.setDouble(1, 10.3);
//				pS.setString(2, "TestAuthor");
//				pS.setString(3, title);
//				pS.setString(4, "TestAbstract");
//				pS.setString(5, "TestContents");
//				Date paperDate = Date.valueOf("2020-10-21");
//				pS.setDate(6, paperDate);
//				pS.executeUpdate();
//				pS = c.prepareStatement("SELECT IndexVal, Author, PaperTitle, Abstract, Contents, Datum FROM heroku_c62394d4736ae72.Contents "
//						+ "WHERE PaperTitle = ? ;");
//				pS.setString(1, title);
//				rS = pS.executeQuery();
//				writeResultSet(rS);
				paperTitle = title;
		} catch (Exception e) {
			throw e;
		} finally {
			System.out.println("Inserted Title.\n");
			close();
		}
	}
	
	public void insertAbstract(String ab) 
		throws Exception {
		try {
				connectionSetup();
//				s = c.createStatement();
//				rS = s.executeQuery("SELECT * FROM heroku_c62394d4736ae72.Contents");
//				pS = c.prepareStatement("INSERT IGNORE INTO heroku_c62394d4736ae72.Contents values (default, ?, ?, ?, ?, ?, ?)");
//				pS.setDouble(1, 10.4);
//				pS.setString(2, "TestAuthor");
//				pS.setString(3, "TestTitle");
//				pS.setString(4, ab);
//				pS.setString(5, "TestContents");
//				Date paperDate = Date.valueOf("2020-10-21");
//				pS.setDate(6, paperDate);
//				pS.executeUpdate();
//				pS = c.prepareStatement("SELECT IndexVal, Author, PaperTitle, Abstract, Contents, Datum FROM heroku_c62394d4736ae72.Contents "
//						+ "WHERE Abstract = ? ;");
//				pS.setString(1, ab);
//				rS = pS.executeQuery();
//				writeResultSet(rS);
				pAbstract = ab;
		} catch (Exception e) {
			throw e;
		} finally {
			System.out.println("Inserted Abstract.\n");
			close();
		}
	}
	
	public void insertContents(String cont) 
		throws Exception {
		try {
				connectionSetup();
//				s = c.createStatement();
//				rS = s.executeQuery("SELECT * FROM heroku_c62394d4736ae72.Contents");
//				pS = c.prepareStatement("INSERT IGNORE INTO heroku_c62394d4736ae72.Contents values (default, ?, ?, ?, ?, ?, ?)");
//				pS.setDouble(1, 10.5);
//				pS.setString(2, "TestAuthor");
//				pS.setString(3, "TestTitle");
//				pS.setString(4, "TestAbstract");
//				pS.setString(5, cont);
//				Date paperDate = Date.valueOf("2020-10-21");
//				pS.setDate(6, paperDate);
//				pS.executeUpdate();
//				pS = c.prepareStatement("SELECT IndexVal, Author, PaperTitle, Abstract, Contents, Datum FROM heroku_c62394d4736ae72.Contents "
//						+ "WHERE Contents = ? ;");
//				pS.setString(1, cont);
//				rS = pS.executeQuery();
//				writeResultSet(rS);
				contents = cont;
		} catch (Exception e) {
			throw e;
		} finally {
			System.out.println("Inserted Contents.\n");
			close();
		}
	}
	
	public void insertIndexVal(double index) 
		throws Exception {
		try {
				connectionSetup();
//				s = c.createStatement();
//				rS = s.executeQuery("SELECT * FROM heroku_c62394d4736ae72.Contents");
//				pS = c.prepareStatement("INSERT IGNORE INTO heroku_c62394d4736ae72.Contents values (default, ?, ?, ?, ?, ?, ?)");
//				pS.setDouble(1, index);
//				pS.setString(2, "TestAuthor");
//				pS.setString(3, "TestTitle");
//				pS.setString(4, "TestAbstract");
//				pS.setString(5, "TestContents");
//				Date paperDate = Date.valueOf("2020-10-21");
//				pS.setDate(6, paperDate);
//				pS.executeUpdate();
//				pS = c.prepareStatement("SELECT IndexVal, Author, PaperTitle, Abstract, Contents, Datum FROM heroku_c62394d4736ae72.Contents "
//						+ "WHERE IndexVal = ? ;");
//				pS.setDouble(1, index);
//				rS = pS.executeQuery();
//				writeResultSet(rS);
				indexVal = index;
		} catch (Exception e) {
			throw e;
		} finally {
			System.out.println("Inserted IndexVal.\n");
			close();
		}
	}
	
	public void searchIndex(double index) 
		throws Exception{
		try {
			connectionSetup();
			s = c.createStatement();
			rS = s.executeQuery("SELECT * FROM heroku_c62394d4736ae72.Contents");
			pS = c.prepareStatement("SELECT IndexVal, Author, PaperTitle, Abstract, Contents, Datum FROM heroku_c62394d4736ae72.Contents" 
											+ "WHERE IndexVal = ? ;");
			pS.setDouble(1, index);
			rS = pS.executeQuery();
			writeResultSet(rS);
		} catch (Exception e) {
			throw e;
		} finally {
			System.out.println("Searched.");
			close();
		}
	}
	
	public void searchAuthor(String auth) 
		throws Exception{
		try {
			connectionSetup();
			s = c.createStatement();
			rS = s.executeQuery("SELECT * FROM heroku_c62394d4736ae72.Contents");
			pS = c.prepareStatement("SELECT IndexVal, Author, PaperTitle, Abstract, Contents, Datum FROM heroku_c62394d4736ae72.Contents" 
											+ "WHERE Author = ? ;");
			pS.setString(1, "'%" + auth + "%'");
			rS = pS.executeQuery();
			writeResultSet(rS);
		} catch (Exception e) {
			throw e;
		} finally {
			System.out.println("Searched.");
			close();
		}
	}
	
	public void searchPaperTitle(String pTitle) 
		throws Exception{
		try {
			connectionSetup();
			s = c.createStatement();
			rS = s.executeQuery("SELECT * FROM heroku_c62394d4736ae72.Contents");
			pS = c.prepareStatement("SELECT IndexVal, Author, PaperTitle, Abstract, Contents, Datum FROM heroku_c62394d4736ae72.Contents" 
											+ "WHERE PaperTitle = ? ;");
			pS.setString(1, "'%" + pTitle + "%'");
			rS = pS.executeQuery();
			writeResultSet(rS);
		} catch (Exception e) {
			throw e;
		} finally {
			System.out.println("Searched.");
			close();
		}
	}
	
	/*
	 * Needs the use of the SQL.Date package
	 * i.e. YYYY-MM-DD
	 */
	public void searchDate(Date datum) 
		throws Exception{
		try {
			connectionSetup();
			s = c.createStatement();
			rS = s.executeQuery("SELECT * FROM heroku_c62394d4736ae72.Contents");
			pS = c.prepareStatement("SELECT IndexVal, Author, PaperTitle, Abstract, Contents, Datum FROM heroku_c62394d4736ae72.Contents" 
											+ "WHERE Datum = ? ;");
			pS.setDate(1, datum);
			rS = pS.executeQuery();
			writeResultSet(rS);
		} catch (Exception e) {
			throw e;
		} finally {
			System.out.println("Searched.");
			close();
		}
	}
	
	public void searchAbst(String abst) 
		throws Exception{
		try {
			connectionSetup();
			s = c.createStatement();
			rS = s.executeQuery("SELECT * FROM heroku_c62394d4736ae72.Contents");
			pS = c.prepareStatement("SELECT IndexVal, Author, PaperTitle, Abstract, Contents, Datum FROM heroku_c62394d4736ae72.Contents" 
											+ "WHERE Abstract = ? ;");
			pS.setString(1, "%" + abst + "%");
			rS = pS.executeQuery();
			writeResultSet(rS);
		} catch (Exception e) {
			throw e;
		} finally {
			System.out.println("Searched.");
			close();
		}
	}
	
	public void searchCont(String cont) 
		throws Exception{
		try {
			connectionSetup();
			s = c.createStatement();
			rS = s.executeQuery("SELECT * FROM heroku_c62394d4736ae72.Contents");
			pS = c.prepareStatement("SELECT IndexVal, Author, PaperTitle, Abstract, Contents, Datum FROM heroku_c62394d4736ae72.Contents" 
											+ "WHERE Contents = ? ;");
			pS.setString(1, "%" + cont + "%");
			rS = pS.executeQuery();
			writeResultSet(rS);
		} catch (Exception e) {
			throw e;
		} finally {
			System.out.println("Searched.");
			close();
		}
	}

	public void insertAll() 
		throws Exception {
		try {
				connectionSetup();
				s = c.createStatement();
				rS = s.executeQuery("SELECT * FROM heroku_c62394d4736ae72.Contents");
				pS = c.prepareStatement("INSERT IGNORE INTO heroku_c62394d4736ae72.Contents values (default, ?, ?, ?, ?, ?, ?)");
				pS.setDouble(1, indexVal);
				pS.setString(2, author);
				pS.setString(3, paperTitle);
				pS.setString(4, pAbstract);
				pS.setString(5, contents);
				pS.setDate(6, paperDate);
				pS.executeUpdate();
				pS = c.prepareStatement("SELECT IndexVal, Author, PaperTitle, Abstract, Contents, Datum FROM heroku_c62394d4736ae72.Contents "
						+ "WHERE IndexVal = ? ;");
				pS.setDouble(1, indexVal);
				rS = pS.executeQuery();
				writeResultSet(rS);
		} catch (Exception e) {
			throw e;
		} finally {
			System.out.println("Inserted full paper.\n");
			close();
		}
	}
	
	public void clear(double index) 
		throws Exception {
		try {
			connectionSetup();
			s = c.createStatement();
			rS = s.executeQuery("SELECT * FROM heroku_c62394d4736ae72.Contents");
			pS = c.prepareStatement("DELETE FROM heroku_c62394d4736ae72.Contents WHERE IndexVal = ? ;");
			pS.setDouble(1, index);
			pS.execute();
			rS = s.executeQuery("SELECT * FROM heroku_c62394d4736ae72.Contents");
			writeResultSet(rS);
		} catch (Exception e) {
			throw e;
		} finally {
			System.out.println("Deleted contents from DB!");
			close();
		}
	}
	
	public void newPaper() {
		indexVal = 0.00;
		author = null;
		paperTitle = null;
		pAbstract = null;
		contents = null;
		paperDate = null;
	}

	private void writeMetaData(ResultSet resultSet) 
		throws SQLException {
		System.out.println("Columns in the table: ");
		System.out.println("Table: " + resultSet.getMetaData().getTableName(1));
		for(int i = 1; i <= resultSet.getMetaData().getColumnCount(); i++) {
			System.out.println("Column " + i + ": " + resultSet.getMetaData().getColumnName(i));
		}
		System.out.println("\n");
	}
	
	private void writeResultSet(ResultSet resultSet) 
		throws SQLException {
		while(resultSet.next()) {
			double IndexVal = resultSet.getDouble("IndexVal");
			String Author = resultSet.getString("Author");
			String pTitle = resultSet.getString("PaperTitle");
			String abst = resultSet.getString("Abstract");
			String cont = resultSet.getString("Contents");
			Date date = resultSet.getDate("Datum");
			System.out.println("IndexVal value: " + IndexVal);
			System.out.println("Author(s): " + Author);
			System.out.println("Title of Paper: " + pTitle);
			System.out.println("Abstract of Paper: " + abst);
			System.out.println("Contents of Paper: " + cont);
			System.out.println("Date paper was published: " + date + "\n");
		}
	}
	
	private void connectionSetup() 
		throws Exception {
		c = DriverManager.getConnection("jdbc:mysql://us-cdbr-east-02.cleardb.com/heroku_c62394d4736ae72", 
				"bb593c0841b9f7", "59f8650c");
	}
	
	private void close() {
		try {
			if(rS != null) 
				rS.close();
			if(pS != null)
				pS.close();
			if(s != null)
				s.close();
			if(c != null)
				c.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
