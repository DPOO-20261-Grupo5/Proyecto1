package Interface;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Ventana extends JFrame {
	
	public Ventana() {
		
		setTitle("Ventana Swing");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(400, 350);
		setVisible(true);
		
		setLayout(new BorderLayout());
		
		JLabel izquierda = new JLabel("izquierda");
		izquierda.setBackground(Color.lightGray);
		izquierda.setOpaque(true);
		
		//JLabel izquierd = new JLabel("izquierd");
		//izquierd.setBackground(Color.CYAN);
		//izquierd.setOpaque(true);
		
		
		add(izquierda, BorderLayout.WEST);
		//add(izquierd, BorderLayout.WEST);
		
		JDialog dialog = new JDialog(this, "Hello World");
		dialog.add(new JLabel("Hello world"));
		
		JButton button = new JButton("button");
		
		
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Button pressed");
				//dialog.setVisible(true);
				izquierda.setText("Otra cosa");
			}
		});
		
		add(button, BorderLayout.EAST);
	}
	
	
	
	public static void main (String[] args) {
		
		new Ventana();
	}

}
