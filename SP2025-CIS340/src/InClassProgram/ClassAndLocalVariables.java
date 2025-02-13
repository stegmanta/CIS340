package InClassProgram;

import java.util.*;

public class ClassAndLocalVariables {
	
	//class variables
	//number default 0
	static double num;
	//String default null
	static String name;
	//boolean default false
	static boolean h;
	static double[] grades;
	static Date currentDate = new Date();

	
	public static void main(String[] args) {
		name = "abdunabi";
		double n = ClassAndLocalVariables.num;
		
		grades = new double[4];
		for(int i = 0; i < grades.length; i++) {
			grades[i] = Math.random() * 101;
		}
		sum();
		
		//local variables
		int x =0, y = 0;
		double sum = 0;
		int num = 0;

	}//end main
	
	static void sum() {
		double sum = 0;
		for (int i =0; i < grades.length; i++)
			sum += grades[i];
		System.out.println("Name: " + name + " " + sum);
	}//end

}
