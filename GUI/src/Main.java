import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JOptionPane;


public class Main extends JFrame{
	private JTextField text1;
	private JTextField text2;
	private JTextField text3;
	private JPasswordField passField;
	
	public Main(){
		setTitle("Software");
		setLayout(new FlowLayout());
		setSize(720, 480);
		
		text1 = new JTextField(10);
		add(text1);
		
		text2 = new JTextField("Enter text here");
		add(text2);
		
		text3 = new JTextField("uneditable", 20);
		text3.setEditable(false);
		add(text3);
		
		passField = new JPasswordField("Password");
		add(passField);
		
		TheHandler handler = new TheHandler();
		text1.addActionListener(handler);
		text2.addActionListener(handler);
		text3.addActionListener(handler);
		passField.addActionListener(handler);
		
	}
	
	public static void main(String[] args) {
		Main window = new Main();
		window.setVisible(true);
		window.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	private class TheHandler implements ActionListener{
		
		public void actionPerformed(ActionEvent event){
			
			String string = "";
			
			if(event.getSource() == text1){
				string = String.format("field 1: %s", event.getActionCommand());
			}else if(event.getSource() == text2){
				
				string = String.format("field 2: %s", event.getActionCommand());
				
			}else if(event.getSource() == text3){
				
				string = String.format("field 3: %s", event.getActionCommand());
				
			}else if(event.getSource() == passField){
				
				string = String.format("password field: %s", event.getActionCommand());
				
			}
			
			JOptionPane.showMessageDialog(null, string);
			
		}
		
		
	}

}
