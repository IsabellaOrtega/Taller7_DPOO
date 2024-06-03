package uniandes.dpoo.taller7.interfaz3;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class TableroVentana extends JPanel
{
	@Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        // Establecer el tamaño de cada celda en la cuadrícula
        int cellWidth = 120; // Ancho de cada celda
        int cellHeight = 80; // Alto de cada celda


        // Establecer el color de los cuadrados
        g2d.setColor(Color.YELLOW);

        // Dibujar la cuadrícula 5x5 con cuadrados rellenos
        for (int row = 0; row < 5; row++) {
            for (int col = 0; col < 5; col++) {
                int x = col * cellWidth;
                int y = row * cellHeight;
                g2d.fillRect(x, y, cellWidth, cellHeight);
            }
        }

        // Establecer el color de las líneas divisorias
        g2d.setColor(Color.BLACK);
        g2d.setStroke(new BasicStroke(2)); // Establece el grosor de las líneas

        // Dibujar las líneas horizontales
        for (int row = 0; row <= 5; row++) {
            int y = row * cellHeight;
            g2d.drawLine(0, y, 5 * cellWidth, y);
        }

        // Dibujar las líneas verticales
        for (int col = 0; col <= 5; col++) {
            int x = col * cellWidth;
            g2d.drawLine(x, 0, x, 5 * cellHeight);
        }
        
    }

}

	
