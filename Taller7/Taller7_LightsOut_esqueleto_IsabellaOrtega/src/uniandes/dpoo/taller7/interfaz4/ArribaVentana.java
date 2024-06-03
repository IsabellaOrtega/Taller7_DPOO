package uniandes.dpoo.taller7.interfaz4;

import java.awt.GridLayout;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class ArribaVentana extends JPanel
{
	
	private JLabel lblTamano;
	private JComboBox boxTabla;
	private JLabel lblDificultad;
	private JRadioButton rbtnFacil;
	private JRadioButton rbtnMedio;
	private JRadioButton rbtnDificil;
	private ButtonGroup dificultadGroup; // se asegura que solo una sea seleccionado
	
	public ArribaVentana()
	{
		setLayout( new GridLayout(1, 6));
		
		lblTamano = new JLabel("Tamaño");
		add(lblTamano);
		
		String[] tamano = {"5x5", "4x4", "3x3"};
		
		
		boxTabla = new JComboBox(tamano);
		add(boxTabla);
		
		lblDificultad = new JLabel("Dificultad");
		add(lblDificultad);
		
		rbtnFacil = new JRadioButton("Facil");
		add(rbtnFacil);
		
		rbtnMedio = new JRadioButton("Medio");
		add(rbtnMedio);
		
		rbtnDificil = new JRadioButton("Dificil");
		add(rbtnDificil);
		
		dificultadGroup= new ButtonGroup();
		dificultadGroup.add(rbtnFacil);
		dificultadGroup.add(rbtnMedio);
		dificultadGroup.add(rbtnDificil);
		add(rbtnFacil);
		add(rbtnMedio);
		add(rbtnDificil);
		
		
	}
	
	public int getTamano()
	{
		String size = (String) boxTabla.getSelectedItem();
		switch (size)
		{
		case "4x4":return 4;
		case "3x3":return 3;
		default: return 5; //5x5
		
		}
	}
	
	public int getDificultad()
	{
		if (rbtnFacil.isSelected())
		{
			return 10;
		}
		else if (rbtnMedio.isSelected())
		{
			return 20;
		}
		else if (rbtnDificil.isSelected())
		{
			return 30;
		}
		return 10; //Default
	}
	

}
