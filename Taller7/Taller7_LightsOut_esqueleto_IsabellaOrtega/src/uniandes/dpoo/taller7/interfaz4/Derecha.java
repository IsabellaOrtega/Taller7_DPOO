package uniandes.dpoo.taller7.interfaz4;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import uniandes.dpoo.taller7.modelo.RegistroTop10;
import uniandes.dpoo.taller7.modelo.Tablero;
import uniandes.dpoo.taller7.modelo.Top10;

public class Derecha extends JPanel implements ActionListener
{
	private JButton btnNuevo;
	private JButton btnReiniciar;
	private JButton btnTop10;
	private JButton btnCambiarjugador;
	private AbajoVentana abajoVentana;
	private ArribaVentana arribaVentana;
	private TableroVentana tableroVentana;
	private Top10 top10;
	private ScrollPanelTop10 Panel0;
	private String nombreJugador = "Agrege nombre jugador";
	private RegistroTop10 registroTop10;
	private final static String nuevo = "new";
	private final static String Reiniciar="restart";
	private final static String cambiarJogador="Change";
	
	public Derecha(AbajoVentana abajoVentana, ArribaVentana arribaVentana, TableroVentana tableroVentana,Top10 top101)
	{
		this.abajoVentana = abajoVentana;
		this.arribaVentana = arribaVentana;
		this.tableroVentana = tableroVentana;
		this.top10=top101;
		
		setLayout( new GridLayout(4, 1));
		
		btnNuevo = new JButton("NUEVO");
		add(btnNuevo);
		btnNuevo.addActionListener( this );
		btnNuevo.setActionCommand( nuevo );
		
		btnReiniciar = new JButton("REINICIAR");
		add(btnReiniciar);
		btnReiniciar.addActionListener( this );
		btnReiniciar.setActionCommand( Reiniciar );
		
		
		btnTop10 = new JButton("TOP 10");
		add(btnTop10);
		btnTop10.addActionListener( this );
		btnTop10.setActionCommand( "TOP10" );
		
		btnCambiarjugador = new JButton("CAMBIAR JUGADOR");
		add(btnCambiarjugador);
		btnCambiarjugador.addActionListener( this );
		btnCambiarjugador.setActionCommand( cambiarJogador );
		
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getActionCommand( ).equals( Reiniciar ))
        {	
			abajoVentana.resetNumeroJugadas();
			tableroVentana.reiniciarTablero();
			
        }
		else if (e.getActionCommand().equals(nuevo))
		{
			int tamano= arribaVentana.getTamano();
			int dificultad = arribaVentana.getDificultad();
			Tablero nuevoTablero = new Tablero(tamano);
			nuevoTablero.desordenar(dificultad);
			tableroVentana.setTablero(nuevoTablero);
		}
		else if (e.getActionCommand().equals(cambiarJogador))
		{
			String usuario= JOptionPane.showInputDialog( this, "ingrese el nombre (3 caracteres y en mayuscula) : " );
			if ( usuario.matches("[A-Z]+")) {
                nombreJugador = usuario;
                abajoVentana.resetJugador(nombreJugador); // Actualizar nombre en AbajoVentana
            } else {
                JOptionPane.showMessageDialog(this, "El nombre debe tener 3 caracteres y estar en mayúsculas.", "Error", JOptionPane.ERROR_MESSAGE);
            }
			
		}
		else if (e.getActionCommand().equals("TOP10"))
		{ ScrollPanelTop10 Pane10 = new ScrollPanelTop10( top10);
		Pane10.setVisible(true);
			//JOptionPane.showMessageDialog(null,"mensaje","A plain message",JOptionPane.PLAIN_MESSAGE);
		}
		
		
	}
	
	

}
