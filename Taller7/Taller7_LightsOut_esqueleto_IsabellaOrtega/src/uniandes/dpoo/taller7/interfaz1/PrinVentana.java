package uniandes.dpoo.taller7.interfaz1;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class PrinVentana extends JFrame {
	

	public PrinVentana()
	{
		setSize(800,500);
		setResizable(false);
		setTitle("Juego de LightsOut");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
	}
	
	public static void main(String[] args)
	{
		PrinVentana princip = new PrinVentana();
		princip.setLocationRelativeTo(null);
		princip.setVisible(true);
	}
}

