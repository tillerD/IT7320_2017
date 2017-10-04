package Assignment3.Part3;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class WordCounter extends JFrame {
	private JTextField textField;
	private JTextField textField_1;
	private JLabel lblWordCount;
	
	public WordCounter() {
		setTitle("Word Counter");
		getContentPane().setLayout(null);
		
		JLabel lblWordCounter = new JLabel("Word Counter: Please input your text...");
		lblWordCounter.setBounds(10, 11, 193, 22);
		getContentPane().add(lblWordCounter);
		
		textField = new JTextField();
		textField.setBounds(20, 44, 267, 156);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnCountWords = new JButton("Count Words");
		btnCountWords.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int count;
				String text = textField.getText().toString();
				count = count(text);
			}
		});
		btnCountWords.setBounds(30, 211, 95, 22);
		getContentPane().add(btnCountWords);
		
		lblWordCount = new JLabel("Word Count: 0");
		lblWordCount.setBounds(135, 215, 152, 14);
		getContentPane().add(lblWordCount);
		
		textField_1 = new JTextField();
		textField_1.setBounds(20, 244, 267, 156);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnRevearseText = new JButton("Reverse Text");
		btnRevearseText.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String text = textField.getText().toString();
				textField_1.setText(reverse(text));
			}
		});
		btnRevearseText.setBounds(30, 411, 103, 23);
		getContentPane().add(btnRevearseText);
	}

	public int count(String text) {
		String[] ls = text.split(" ");
		int i = 0;
		
		for(String temp : ls) {
			i++;
		}
		
		return i;
	}

	public boolean display(int count) {
		String text = "Word Count: " + count;
		lblWordCount.setText(text);
		if(lblWordCount.getText().toString().equals(text)) {
			return true;
		} else {
			return false;
		}
	}

	public String reverse(String text) {
		String reverse = new StringBuffer(text).reverse().toString();
		return reverse;
	}
	
	public static void main(String[] args) {
		WordCounter obj = new WordCounter();
	}
}
