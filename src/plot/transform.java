package plot;

public class transform {
	private double maxx, maxy, minx, miny;
	private double[] xdouble, ydouble;
	private double dx, dy;
	private double ratiox, ratioy;
	
	
	public transform(double xToTransform[], double yToTransform[]){
		
		xdouble = xToTransform;
		ydouble = yToTransform;
		computeStatic();
	}
	
	public int getlenx(){
		return xdouble.length;
	}
	
	public int getleny(){
		return ydouble.length;
	}
	
	private void computeStatic(){
		//Find max and min for axis
		maxx = xdouble[0];
		minx = xdouble[0];
		for(int i=0;i<xdouble.length;i++){
			if(xdouble[i] > maxx) maxx = xdouble[i];
			if(xdouble[i] < minx) minx = xdouble[i];
		}
		
		maxy = ydouble[0];
		miny = ydouble[0];
		for(int i=0;i<ydouble.length;i++){
			if(ydouble[i] > maxy) maxy = ydouble[i];
			if(ydouble[i] < miny) miny = ydouble[i];
		}
		//Compute differences
		dx = Math.abs(maxx - minx);
		dy = Math.abs(maxy - miny);
		
		
		
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
