import java.io.IOException;
import java.nio.file.Paths;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.custom.CustomAnalyzer;
import org.apache.lucene.analysis.custom.CustomAnalyzer.Builder;
import org.apache.lucene.analysis.standard.StandardTokenizer;

public class GoodEnoughAnalyzer{

	Analyzer custom;
	
	public GoodEnoughAnalyzer() {
		try {
			custom = CustomAnalyzer.builder().withTokenizer("Standard").addTokenFilter("lowercase").build();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
