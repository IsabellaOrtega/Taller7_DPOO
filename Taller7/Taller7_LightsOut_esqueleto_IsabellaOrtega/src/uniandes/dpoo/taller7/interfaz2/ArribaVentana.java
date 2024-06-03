package uniandes.dpoo.taller7.interfaz2;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class ArribaVentana extends JPanel{
	
	private JLabel lblTamano;
	private JComboBox boxTabla;
	private JLabel lblDificultad;
	private JRadioButton rbtnFacil;
	private JRadioButton rbtnMedio;
	private JRadioButton rbtnDificil;
	
	public ArribaVentana()
	{
		setLayout( new GridLayout(1, 6));
		
		lblTamano = new JLabel("Tamaño");
		add(lblTamano);
		
		String[] tamano = {"5x5", "4x4"};
		
		boxTabla = new JComboBox(tamano);
		add(boxTabla);
		
		lblDificultad = new JLabel("Dificultad");
		add(lblDificultad);
		
		rbtnFacil = new JRadioButton("Fácil");
		add(rbtnFacil);
		
		rbtnMedio = new JRadioButton("Medio");
		add(rbtnMedio);
		
		rbtnDificil = new JRadioButton("Dificil");
		add(rbtnDificil);
		
		
	}
	

}
