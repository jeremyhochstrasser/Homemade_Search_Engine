import java.sql.Date;

public class SQLMain {
	public static void main(String[] args) throws Exception {
		MySQLAccess test = new MySQLAccess();

		test.readDataBase();
		test.insertAbstract("This is a tester abstract");
		test.insertAuthor("Hello, I am an Author");
		String[] authors = new String[]{"a" , "b" , "c"};
//	test.insertAuthors(authors);

		Date dt = Date.valueOf("2020-11-01");
		test.insertDate(dt);
		test.insertContents("I'm a super interesting contents section for a paper.");
		test.insertTitle("I'm a super interesting paper title!");
		test.insertIndexVal(420.69);
	}
}

