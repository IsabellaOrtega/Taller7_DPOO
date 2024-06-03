package uniandes.dpoo.taller7.interfaz4;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.HeadlessException;
import java.util.ArrayList;
import java.util.Collection;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import uniandes.dpoo.taller7.modelo.RegistroTop10;
import uniandes.dpoo.taller7.modelo.Top10;

public class ScrollPanelTop10 extends JFrame{
	private JList listota;
	private DefaultListModel<RegistroTop10> listita;
	private JPanel arriba;
	private Top10 top10;
	private JScrollPane paneTop10;
	public ScrollPanelTop10(Top10 top01) throws HeadlessException {
		
		    setTitle("TOP 10");
	        setSize(300, 300);
	        setLayout(new BorderLayout());

	        arriba = new JPanel();
	        JLabel numero = new JLabel("#");
	        JLabel jugador = new JLabel("Jugador");
	        JLabel puntuacion = new JLabel("Puntuacion");

	        arriba.add(numero);
	        arriba.add(jugador);
	        arriba.add(puntuacion);
	        add(arriba, BorderLayout.NORTH);

		
		
		this.top10=top01;
		listita = new DefaultListModel<RegistroTop10>();
		recorrerTop10yagregarListita();
		paneTop10=new JScrollPane();
		paneTop10.setBounds(20, 10, 200, 200);
		listota = new JList<RegistroTop10>(listita);
		listota.setFont(new Font("sans serif", Font.ITALIC, 25));
		paneTop10.setViewportView(listota);
		add(paneTop10,BorderLayout.CENTER);
		
		
	}
	//JScrollPane
	public void agregaralTop10() {
		
		
	}
	public void recorrerTop10yagregarListita() {
		Collection<RegistroTop10> b = top10.darRegistros();
		ArrayList<RegistroTop10> listaRegistros = new ArrayList<>(b);
		for(int i=0; i<listaRegistros.size();i++) {
			listita.add(i, listaRegistros.get(i));
			
		}
	
	
		
	}
public void restartlistita() {
	listita.removeAllElements();
		
	}
	public void agregarElemento(RegistroTop10 x) {
		listita.addElement(x);
		listota.repaint();
		
	}
	
	

}
