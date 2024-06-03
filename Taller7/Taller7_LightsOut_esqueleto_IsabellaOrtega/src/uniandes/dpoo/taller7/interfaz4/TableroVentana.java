package uniandes.dpoo.taller7.interfaz4;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

import uniandes.dpoo.taller7.modelo.Tablero;
import uniandes.dpoo.taller7.modelo.Top10;

public class TableroVentana extends JPanel implements MouseMotionListener
{
	
	private Tablero tablero;
	private Tablero tableroOriginal;
	private int mouseRow= -1;
	private int mouseCol= -1;
	private AbajoVentana abajoVentana;
	private Top10 tope10;
	
	
	public TableroVentana(AbajoVentana abajoventana,Top10 top10)
	
	{   this.tope10=top10;
		this.abajoVentana = abajoventana;
		addMouseMotionListener(this);
		addMouseListener(new MouseAdapter(){
			
			 @Override
	            public void mouseExited(MouseEvent e) {
	                mouseRow = -1;
	                mouseCol = -1;
	                repaint();
	            }
			 @Override
			 public void mouseClicked(MouseEvent e)
			 {
				 handleClick(e);
			 }
				});
	}
	
	
	public void setTablero(Tablero tablero)
	{
		this.tablero = tablero;
		this.tableroOriginal = copiarTablero(tablero); //estado inical
		
		repaint(); //volver a crear tablero
	}
	
	public void reiniciarTablero()
	{
		if (tableroOriginal != null)
		{
			tablero = copiarTablero(tableroOriginal);
			tablero.setJugadas0();
			
			repaint();
		}
	}
	
	private Tablero copiarTablero(Tablero original)
	{
        int tamano = original.darTablero().length;
        Tablero copia = new Tablero(tamano);
        boolean[][] estadoOriginal = original.darTablero();
        boolean[][] estadoCopia = copia.darTablero();
        
        for (int i = 0; i < tamano; i++) {
            for (int j = 0; j < tamano; j++) {
                estadoCopia[i][j] = estadoOriginal[i][j];
            }
        }
        return copia;
    }
	
	
	@Override
    protected void paintComponent(Graphics g) 
	{
        super.paintComponent(g);
        if (tablero != null ) {
            Graphics2D g2d = (Graphics2D) g;
            boolean[][] estadoTablero = tablero.darTablero();

            int rows = estadoTablero.length;
            int cols = estadoTablero[0].length;
            int cellWidth = getWidth() / cols;
            int cellHeight = getHeight() / rows;

            
            for (int row = 0; row < rows; row++) {
                for (int col = 0; col < cols; col++) {
                    if (row == mouseRow && col == mouseCol) {
                        g2d.setColor(new Color(173, 216, 230));
                        g2d.fillRect(col * cellWidth, row * cellHeight, cellWidth, cellHeight);
                    } else if (estadoTablero[row][col]) {
                        g2d.setColor(Color.PINK);
                        g2d.fillRect(col * cellWidth, row * cellHeight, cellWidth, cellHeight);
                    } else {
                        g2d.setColor(Color.WHITE);
                        g2d.fillRect(col * cellWidth, row * cellHeight, cellWidth, cellHeight);
                        drawBombillaIcon(g2d, col * cellWidth, row * cellHeight, cellWidth, cellHeight);
                    }
                   
                    
                }
            }

            // Dibujar las líneas 
            g2d.setColor(Color.BLACK);
            g2d.setStroke(new BasicStroke(2));
            for (int row = 0; row <= rows; row++) {
                int y = row * cellHeight;
                g2d.drawLine(0, y, getWidth(), y);
            }
            for (int col = 0; col <= cols; col++) {
                int x = col * cellWidth;
                g2d.drawLine(x, 0, x, getHeight());
            }
           if ( tablero.tableroIluminado()==false) {
        	   
        	   winner();
           }
        }
        //tablero.tableroIluminado();
    }

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	private int[] convertirCoordenadasACasilla(int x, int y)
	{
	int ladoTablero = tablero.darTablero().length;
	int altoPanelTablero = getHeight();
	int anchoPanelTablero = getWidth();
	int altoCasilla = altoPanelTablero / ladoTablero;
	int anchoCasilla = anchoPanelTablero / ladoTablero;
	int fila = (int) (y / altoCasilla);
	int columna = (int) (x / anchoCasilla);
	return new int[] { fila, columna };
	}

	
		
		public void handleClick(MouseEvent e)
		{
			if (tablero != null)
			{
				int cellWidth = getWidth() / tablero.darTablero()[0].length;
	            int cellHeight = getHeight() / tablero.darTablero().length;
	            int row = e.getY() / cellHeight;
	            int col = e.getX() / cellWidth;
	            int[] casillas= convertirCoordenadasACasilla(e.getX(),e.getY());
	            boolean[][] estadoTablero = tablero.darTablero();
	            int x= casillas[0];
	            int y = casillas[1];
	            
	            tablero.jugar(x, y);
	            repaint();
	            
	            if (abajoVentana != null)
                {
                	abajoVentana.incrementarNumeroJugadas();	                }
		}
	}
	            

	            
		
	
		private void drawBombillaIcon(Graphics2D g2d, int x, int y, int cellWidth, int cellHeight) {
	        int width = (int) (cellWidth * 0.8);
	        int height = (int) (cellHeight * 0.8);
	        int iconX = x + (cellWidth - width) / 2;
	        int iconY = y + (cellHeight - height) / 2;

	        // Dibujar el cuerpo de la bombilla
	        g2d.setColor(Color.YELLOW);
	        g2d.fillOval(iconX, iconY, width, height - 30);

	        // Dibujar la parte inferior de la bombilla
	        g2d.setColor(Color.GRAY);
	        g2d.fillRect(iconX + width / 4, iconY + height - 30, width / 2, 20);

	        // Dibujar los detalles de la parte inferior
	        g2d.setColor(Color.DARK_GRAY);
	        int baseX = iconX + width / 4;
	        int baseY = iconY + height - 30;
	        int baseWidth = width / 2;
	        int baseHeight = 20;
	        g2d.drawLine(baseX, baseY, baseX + baseWidth, baseY);
	        g2d.drawLine(baseX, baseY + baseHeight / 3, baseX + baseWidth, baseY + baseHeight / 3);
	        g2d.drawLine(baseX, baseY + 2 * baseHeight / 3, baseX + baseWidth, baseY + 2 * baseHeight / 3);
	        g2d.drawLine(baseX, baseY + baseHeight, baseX + baseWidth, baseY + baseHeight);

	        // Dibujar el filamento
	        g2d.setColor(Color.ORANGE);
	        int filamentY = iconY + (height - 30) / 2;
	        g2d.drawLine(iconX + width / 2, filamentY, iconX + width / 2 - 10, filamentY + 15);
	        g2d.drawLine(iconX + width / 2, filamentY, iconX + width / 2 + 10, filamentY + 15);

	        // Dibujar contorno de la bombilla
	        g2d.setColor(Color.BLACK);
	        g2d.drawOval(iconX, iconY, width, height - 30);
	        
	    }
		public void winner() {
			 int puntaje=tablero.calcularPuntaje();
			 this.tope10.agregarRegistro(abajoVentana.getNumeroJugador().getText(), puntaje);
			 
		}
		
		

		@Override
		public void mouseMoved(MouseEvent e) {
			if (tablero != null)
			{
				int cellWidth = getWidth()/tablero.darTablero()[0].length;
				int cellHeight = getHeight() / tablero.darTablero().length;
	            int row = e.getY() / cellHeight;
	            int col = e.getX() / cellWidth;
	            
	            if (row != mouseRow || col != mouseCol)
	            {
	                mouseRow = row;
	                mouseCol = col;
	                repaint();
	                
	            }
			}}
		

}

	
