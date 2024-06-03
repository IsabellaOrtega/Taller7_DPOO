package uniandes.dpoo.taller7.interfaz3;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class PrinVentana extends JFrame {
	
	private Derecha panelOpc;
	private ArribaVentana panelArriba;
	private AbajoVentana panelAbajo;
	private TableroVentana paneltablero;
	
	public PrinVentana()
	{
		setSize(800,500);
		setResizable(false);
		setTitle("Juego de LightsOut");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		setLayout(new BorderLayout());
		panelOpc = new Derecha();
		add(panelOpc, BorderLayout.EAST);
		
		panelArriba = new ArribaVentana();
		add(panelArriba, BorderLayout.NORTH);
		
		panelAbajo = new AbajoVentana();
		add(panelAbajo, BorderLayout.SOUTH);
		
		paneltablero = new TableroVentana();
		add(paneltablero, BorderLayout.CENTER);
		
	}
	
	public static void main(String[] args)
	{
		PrinVentana princip = new PrinVentana();
		princip.setLocationRelativeTo(null);
		princip.setVisible(true);
	}
}

