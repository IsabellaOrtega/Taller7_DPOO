package uniandes.dpoo.taller7.interfaz4;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AbajoVentana extends JPanel{
	
	private JLabel jugadas;
	private JTextField numerojugadas;
	private JLabel jugador;
	private JTextField numerojugador;
	private int numeroJugadas = 0;
	
	
	public AbajoVentana ()
	{
		setLayout( new GridLayout(1, 4));
		
		jugadas = new JLabel("Jugadas: ");
		add(jugadas);
		
		numerojugadas = new JTextField(Integer.toString(numeroJugadas));
		numerojugadas.setEditable(false);
		add(numerojugadas);
		
		jugador = new JLabel("Jugador: ");
		add(jugador);
		
		numerojugador = new JTextField("Agrege nombre jugador");
		numerojugador.setEditable(false);
		add(numerojugador);
	}
	
	public void resetNumeroJugadas() 
	{
        numerojugadas.setText("0");
        setNumeroJugadas(0);
    }
	

    public void setNumeroJugadas(int numeroJugadas) {
		this.numeroJugadas = numeroJugadas;
	}

	public JTextField getNumeroJugadas() 
    {
        return numerojugadas;
    }
    public JTextField getNumeroJugador() 
    {
        return numerojugador;
    }
    public void resetJugador(String jugador)
    {
    	numerojugador.setText(jugador);
    }
    public void incrementarNumeroJugadas()
    {
    	numeroJugadas += 1;
    	numerojugadas.setText(Integer.toString(numeroJugadas));
    	
    }

}
