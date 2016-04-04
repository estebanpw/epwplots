package plot;

public abstract class transform {
	protected double maxx, maxy, minx, miny;
	protected double[] xdouble, ydouble;
	protected double dx, dy;
	protected String[] showLabels;
	protected boolean showLeftLabels;
	
	public transform(double xToTransform[], double yToTransform[], String showLabels[]){
		showLeftLabels = false;
		xdouble = xToTransform;
		ydouble = yToTransform;
		this.showLabels = showLabels;
		computeStatic();
	}
	
	public boolean doShowLabels(){
		return showLeftLabels;
	}
	
	public void activateLabels(){
		showLeftLabels = true;
	}
	
	public void deactivateLabels(){
		showLeftLabels = false;
	}
	
	public String[] getLabels(){
		return showLabels;
	}
	
	public int getLabelsSize(){
		return showLabels.length;
	}
	
	public int getlenx(){
		return xdouble.length;
	}
	
	public int getleny(){
		return ydouble.length;
	}
	
	protected void computeStatic(){
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
	public abstract void recompute(int cx, int cy, int[]x, int[] y, String[] xaxis, String[] yaxis);
}
