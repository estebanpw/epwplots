package run;

import plot.basicpanel;
import plot.transform;
import plot.transformContinuous;
import plot.transformDiscreet;
import useful.plotmode;

public class runme {
	public static void main(String[] args){
		
		//x^2
		
				
		double [] x = new double[10];
		double [] y = new double[10];
		String [] l = new String[10];
		
		//Bars example
		
		l[0] = "Mycoplasma hyop";
		l[1] = "flocculare";
		l[2] = "bacteroidetes ovatus";
		l[3] = "firmicutes martiricus";
		for(int i=4;i<x.length;i++){
			l[i] = "another genome "+i;
		}
		
		for(int i=0;i<x.length;i++){
			x[i] = (double) i;
			y[i] = i;
		}
		
		//2d plot examples
		/*
		for(int i=-50;i<50;i++){
			x[i+50] = i;
			y[i+50] = i*i;
		}
		*/
		/*
		double k = -3.3;
		for(int i=0;i<100;i++){
			k += 0.066;
			x[i] = k;
			y[i] = Math.tan(k);
		}
			*/
		//transform tf = new transformContinuous(x,y,l);
		transform tf = new transformDiscreet(x,y,l);
		tf.activateLabels();
		basicpanel bp = new basicpanel(tf, 500, 300, "This is labelx", "This is label y", plotmode.plot2dLabels);
		bp.createFrame();
		
	}
}
