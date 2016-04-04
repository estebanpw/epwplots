package plot;

public class transformContinuous extends transform{
	
	public transformContinuous(double xToTransform[], double yToTransform[], String showLabels[]){
		super(xToTransform, yToTransform, showLabels);
	}

	public void recompute(int cx, int cy, int[]x, int[] y, String[] xaxis, String[] yaxis){
		
		int k=0;
		for(double i=minx;i<maxx - (dx/x.length); i += (dx/x.length)){
			xaxis[k] = ""+ i;
			k++;
		}
		k=0;
		for(double i=miny;i<maxy - (dy/y.length); i += (dy/y.length)){
			yaxis[k] = ""+ i;
			k++;
		}
	
		
		for(int i=0;i<xdouble.length;i++){
			x[i] = (int) (((xdouble[i] - minx)/(maxx - minx)) *cx);
			y[i] = cy - (int) (((ydouble[i] - miny)/(maxy - miny)) *cy);
		}
	}
	
	
}
