package plot;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class basicpanel extends JPanel{
	private static JFrame jFrame;
	//Input vectors to plot already transformed
	private int[] x, y;
	
	//Label storage for the axis
	private String[] xaxis, yaxis;

	//Initial size of the whole plot
	private int lx, ly;
	//Plot panel size (area)
	private int cx, cy;
	
	//Object that will transform the frame
	private transform tf;
	
	//border for axis
	final int border = 15;
	
	private JPanel center, south, west, east, north;
	private JLabel labelx, labely;
	
	
	
	public basicpanel(transform tf, int lx, int ly, String labelx, String labely){
		x = new int[tf.getlenx()];
		y = new int[tf.getleny()];
		xaxis = new String[tf.getlenx()];
		yaxis = new String[tf.getleny()];
		
		this.lx = lx;
		this.ly = ly;
		this.tf = tf;
		this.labelx = new JLabel(labelx);
        this.labely = new JLabel(labely);

	}
	
    
    @Override
    public void paintComponent(Graphics g){
    	cx = (int) center.getSize().getWidth();
    	cy = (int) center.getSize().getHeight();
    	
    	tf.recompute(cx-border, cy-border, x, y, xaxis, yaxis);
    	center.repaint();
    }
    
	
    public void createFrame() {
        jFrame = new JFrame();
        jFrame.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e)
            {
                jFrame.repaint();
            }
        });
        jFrame.add(this);
        //Size of the display
        jFrame.setSize(lx, ly);
        //Disallow resizing the windows. This is necessary so we don't have to repaint the components again.
        jFrame.setResizable(true);
        jFrame.setVisible(true);
        //Prevents the app from freezing when closing
        jFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        JPanel panel = new JPanel();
        jFrame.add(panel);
        panel.setLayout(new BorderLayout());
        
        
        cx = 1; cy = 1;
        center = new JPanel() {
            @Override
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                
                //g.fillRect(1, 1, cx, cy);
                for(int i=1;i<tf.getlenx()-1;i++){
                	g.setColor(Color.BLUE);
                	g.drawLine(x[i-1]+border, y[i-1]-border, x[i]+border, y[i]-border);
                	g.setColor(Color.BLACK);
                	if(i%10==0)g.drawChars(xaxis[i].toCharArray(), 0, 5, i*cx/x.length, cy);
                	if(i%10==0)g.drawChars(yaxis[i].toCharArray(), 0, 5, 0, i*cy/y.length);
                	//g.drawOval(x[i], y[i], 20, 20);
                }
                
            }
        };
        south = new JPanel();
        west = new JPanel();
        east = new JPanel();
        north = new JPanel();
        
        
        center.setBackground(Color.WHITE);
        south.setBackground(Color.LIGHT_GRAY);
        north.setBackground(Color.LIGHT_GRAY);
        east.setBackground(Color.LIGHT_GRAY);
        west.setBackground(Color.LIGHT_GRAY);
        
        panel.add(center, BorderLayout.CENTER);
        panel.add(south, BorderLayout.SOUTH);
        panel.add(north, BorderLayout.NORTH);
        panel.add(west, BorderLayout.WEST);
        panel.add(east, BorderLayout.EAST);
        
        
        west.add(labely);
        south.add(labelx);
        
        
    }
}


