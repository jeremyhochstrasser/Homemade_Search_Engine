
import java.io.IOException;
import java.io.OutputStream;
import javax.swing.JTextArea;

public class CustomStream extends OutputStream{
	private JTextArea textArea;
    
	
    public CustomStream(JTextArea textArea) {
        this.textArea = textArea;
    }
	
	@Override
	public void write(int b) throws IOException {

        textArea.append(String.valueOf((char)b)); //redirect output
        textArea.setCaretPosition(textArea.getDocument().getLength()); //scroll to end
	}
}
