package run;

import plot.basicpanel;
import plot.transform;

public class runme {
	public static <T> void main(String[] args){
		
		//x^2
		
				
		double [] x = new double[100];
		double [] y = new double[100];
		
		for(int i=-50;i<50;i++){
			x[i+50] = i;
			y[i+50] = i*i;
		}
		/*
		double k = -3.3;
		for(int i=0;i<100;i++){
			k += 0.066;
			x[i] = k;
			y[i] = Math.tan(k);
		}
		*/	
		transform tf = new transform(x,y);
		basicpanel bp = new basicpanel(tf, 500, 300, "This is labelx", "This is label y");
		bp.createFrame();
		
	}
}
