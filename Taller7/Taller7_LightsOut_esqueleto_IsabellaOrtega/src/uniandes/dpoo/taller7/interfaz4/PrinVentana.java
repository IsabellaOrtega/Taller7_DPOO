package uniandes.dpoo.taller7.interfaz4;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import uniandes.dpoo.taller7.modelo.RegistroTop10;
import uniandes.dpoo.taller7.modelo.Top10;

public class PrinVentana extends JFrame {
	
	private Derecha panelOpc;
	private ArribaVentana panelArriba;
	private AbajoVentana panelAbajo;
	private TableroVentana paneltablero;
	private Top10 top10= new Top10();
	
	
	public PrinVentana()
	{
		setSize(800,500);
		setResizable(false);
		setTitle("Juego de LightsOut");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		setLayout(new BorderLayout());
		//panelOpc = new Derecha();
		//add(panelOpc, BorderLayout.EAST);
		
		panelArriba = new ArribaVentana();
        add(panelArriba, BorderLayout.NORTH);

        panelAbajo = new AbajoVentana();
        add(panelAbajo, BorderLayout.SOUTH);

        paneltablero = new TableroVentana(panelAbajo,top10);
        add(paneltablero, BorderLayout.CENTER);

        panelOpc = new Derecha(panelAbajo, panelArriba, paneltablero,top10);
        add(panelOpc, BorderLayout.EAST);
        
        top10.agregarRegistro("AAA", 127);
		
	}
	
	public static void main(String[] args)
	{
		SwingUtilities.invokeLater(() -> 
		{
			PrinVentana princip = new PrinVentana();
            princip.setLocationRelativeTo(null);
            princip.setVisible(true);
        });
		
		
		
		}
			
}



