package trial;

public class Gradient_Descent_Example {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double[] function = {(double)1/3,(double)1/2,-2,0};
		gradient_descent(function, 6, 0.15, -3);
	}

	public static void gradient_descent(double[] function, int times, double alpha, double theta) {
		double result = 0.0;
		double[] gradient = new double[function.length-1];
		for(int i = 0 ; i <gradient.length;i++) {
			gradient[i] = (double)(function[i] * (double)(function.length-i-1));
		}
		
		for(int i = 0 ; i < times; i++) {
			double temp = 0;
			for(int j = 0; j < gradient.length;j++) {
				temp += gradient[j]* Math.pow(theta, gradient.length-j-1);
			}
			theta = theta - alpha * temp;
			System.out.println(theta);
		}
		
	}
}
