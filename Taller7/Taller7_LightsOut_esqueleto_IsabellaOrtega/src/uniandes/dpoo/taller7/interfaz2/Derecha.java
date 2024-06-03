package uniandes.dpoo.taller7.interfaz2;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

public class Derecha extends JPanel
{
	private JButton btnNuevo;
	private JButton btnReiniciar;
	private JButton btnTop10;
	private JButton btnCambiarjugador;
	
	public Derecha()
	{
		setLayout( new GridLayout(4, 1));
		
		btnNuevo = new JButton("NUEVO");
		add(btnNuevo);
		
		btnReiniciar = new JButton("REINICIAR");
		add(btnReiniciar);
		
		btnTop10 = new JButton("TOP 10");
		add(btnTop10);
		
		btnCambiarjugador = new JButton("CAMBIAR JUGADOR");
		add(btnCambiarjugador);
		
	}
	
	

}
