package uniandes.dpoo.taller7.interfaz2;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AbajoVentana extends JPanel{
	
	private JLabel jugadas;
	private JTextField numerojugadas;
	private JLabel jugador;
	private JTextField numerojugador;
	
	public AbajoVentana ()
	{
		setLayout( new GridLayout(1, 4));
		
		jugadas = new JLabel("Jugadas: ");
		add(jugadas);
		
		numerojugadas = new JTextField("0");
		add(numerojugadas);
		
		jugador = new JLabel("Jugador: ");
		add(jugador);
		
		numerojugador = new JTextField();
		add(numerojugador);
	}
	

}
