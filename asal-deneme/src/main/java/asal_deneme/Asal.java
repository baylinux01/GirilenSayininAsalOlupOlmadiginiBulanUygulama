package asal_deneme;

import java.awt.*;
import java.awt.event.*;
import java.util.regex.Pattern;

import javax.swing.*;
import javax.swing.border.*;
import javax.swing.event.*;

public class Asal extends JFrame{

	private JPanel contentPane;
	long deger;
	int count=0;
	public JLabel lb1;
	public JLabel lb2;
	public JTextField tf1;
	public JTextField tf2;
	public JButton btn;
	public String s;
	public String str;
	public Robot robot;

	
	public static boolean isSpacedEnded(String s)
	{
		return s!=null && Character.isWhitespace(s.charAt(s.length()-1));
	}
	
	public boolean isFractional(String s) {  
	    return s != null && (s.matches("[-+]?\\d+\\.+") || s.matches("[-+]?\\d+[^0-9.]") || s.matches("[-+]?\\d+\\.+0*[1-9]*+[^0-9]+"));  
	}  
	
	public boolean isFractionalNumeric(String s) {  
	    return s != null && (s.matches("[-+]?\\d+\\.+0*[1-9]+"));  
	}  
	
	public boolean isExactNumeric(String s) {  
	    return s != null && s.matches("[-+]?\\d*\\.?0*");  
	}  
	
	public boolean isNumeric(String s) {  
	    return s != null && s.matches("[-+]?\\d*\\.?\\d+");  
	}  
	
	public void asalBul()
	{
		try {
			s=tf1.getText();
			 while(isSpacedEnded(s)) s=s.substring(0,s.length()-1);
			 str=s;
			 if(s.contains(".")) s=s.split("[.]")[0];
			 
			 
			 
		
			 deger= Long.valueOf(s);
			 
			 
		} catch (NumberFormatException f) {
			if      (tf1.getText().equals(""))                  tf2.setText("");
			else                                                tf2.setText("Hatalı Değer");
		}
		
		
		
		
		
		
		
		
		
		if      (tf1.getText().equals(""))                
		{ 
			tf2.setText("");
			
	    }
		else if(isFractional(str)) {tf2.setText("Girdiğiniz değer bir sayı değildir. Hatalı değer");}
		else if(deger<0 && isFractionalNumeric(str))
		{
			tf2.setText("Girdiğiniz sayı hem negatiftir hem de küsuratlıdır ve asal değildir");
		}
		else if (isFractionalNumeric(str)) 
		{
			tf2.setText("Girdiğiniz sayı küsuratlıdır ve asal değildir");
		}
		else if ( !isExactNumeric(str) || isFractional(str))                                  
		{
			tf2.setText("Hatalı Değer");
			
		}
		else if(deger<0)
		{
			tf2.setText("Girdiğiniz sayı negatiftir ve asal değildir");
		}
		
		else if (deger<2 && deger>=0)  
		{
			tf2.setText("Girdiğiniz sayı asal değildir");
			
		}
		else if (deger==2)
		{
			tf2.setText("Girdiğiniz sayı asaldır");
			
		}
		else if (deger>2) 
		{
			count=0;
			for (int i=2; i<deger;i++) 
			{
				if(deger%i==0) {tf2.setText("Girdiğiniz sayı asal değildir"); count++; break;} 
				
			}
			if(count==0)   tf2.setText("Girdiğiniz sayı asaldır");
			else   tf2.setText("Girdiğiniz sayı asal değildir");
			
		}
		
	}
	
	


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Asal frame = new Asal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public Asal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(800,400);
		setLocationRelativeTo(null);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);

		setContentPane(contentPane);
		
		lb1=new JLabel();
		lb1.setSize(400,20);
		lb1.setText("Asal olup olmadığını öğrenmek istediğiniz sayıyı giriniz");
		lb1.setLocation(10,100);
		contentPane.add(lb1);
		tf1=new JTextField();
		tf1.setSize(360,20);
		tf1.setLocation(340,100);
		
		contentPane.add(tf1);
		lb2=new JLabel();
		lb2.setSize(150,20);
		lb2.setLocation(275,150);
		lb2.setText("Sonuç");
		contentPane.add(lb2);
		tf2=new JTextField();
		tf2.setSize(360,20);
		tf2.setLocation(340,150);
		
		contentPane.add(tf2);
		tf1.getDocument().addDocumentListener(new DocumentListener() 
		{

			public void insertUpdate(DocumentEvent e) {
				if(Pattern.matches("[^1-9]+",tf1.getText())) 
				{
		
					tf1.requestFocus();
					tf1.setCaretPosition(1); 
					try {
						robot=new Robot();
					} catch (AWTException e1) {
						// TODO Auto-generated catch block
						
					}
					robot.keyPress(KeyEvent.VK_BACK_SPACE);
					robot.keyRelease(KeyEvent.VK_BACK_SPACE);
					
				}
				
				if(tf1.getText().equals(" ")) tf1.setText("");
				if(tf1.getText().equals("")) tf2.setText("");
				if(!tf1.getText().equals("")) 
				{   
					
					asalBul();
				}
			}

			public void removeUpdate(DocumentEvent e) {
				if(Pattern.matches("[^1-9]+",tf1.getText())) 
				{
		
					tf1.requestFocus();
					tf1.setCaretPosition(1); 
					try {
						robot=new Robot();
					} catch (AWTException e1) {
						// TODO Auto-generated catch block
						
					}
					robot.keyPress(KeyEvent.VK_BACK_SPACE);
					robot.keyRelease(KeyEvent.VK_BACK_SPACE);
					
				}
				
				if(tf1.getText().equals(" ")) tf1.setText("");
				if(tf1.getText().equals("")) tf2.setText("");
				if(!tf1.getText().equals("")) 
				{   
					
					asalBul();
				}
			}

			public void changedUpdate(DocumentEvent e) {
				
				if(Pattern.matches("[^1-9]+",tf1.getText())) 
				{
		
					tf1.requestFocus();
					tf1.setCaretPosition(1); 
					try {
						robot=new Robot();
					} catch (AWTException e1) {
						// TODO Auto-generated catch block
						
					}
					robot.keyPress(KeyEvent.VK_BACK_SPACE);
					robot.keyRelease(KeyEvent.VK_BACK_SPACE);
					
				}
				
				if(tf1.getText().equals(" ")) tf1.setText("");
				if(tf1.getText().equals("")) tf2.setText("");
				if(!tf1.getText().equals("")) 
				{   
					
					asalBul();
				}
				
			}
			
		});
		
		
		
		
				
		
		
		
		
	}
		
		
		
		
		
		
		
	}


