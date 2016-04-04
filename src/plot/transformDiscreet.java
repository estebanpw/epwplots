package plot;

public class transformDiscreet extends transform{
	protected String[] showLabels;
	
	public transformDiscreet(double xToTransform[], double yToTransform[], String showLabels[]){
		super(xToTransform, yToTransform);
		this.showLabels = showLabels;
	}
	
	public String[] getLabels(){
		return showLabels;
	}
	
	public void recompute(int cx, int cy, int[]x, int[] y, String[] xaxis, String[] yaxis){
		int k;
		for(k=0;k<x.length;k++){
			xaxis[k] = ""+k;
		}
		k=0;
		for(double i=miny;i<maxy - (dy/y.length); i += (dy/y.length)){
			yaxis[k] = ""+ i;
			k++;
		}
	
		
		for(int i=0;i<xdouble.length;i++){
			x[i] = (int) (((xdouble[i] - minx)/(maxx - minx)) *cx);
			
			y[i] = cy - (int) (((ydouble[i] - miny)/(maxy - miny)) *cy);
			System.out.println(ydouble[i] +"---->"+y[i]+" and is :: "+yaxis[i]);
		}
	}
	
	
}
