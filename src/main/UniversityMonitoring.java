package main;

import model.Monitor;
import model.Student;
import model.ThreadSleep;
/**
 * 
 * @author Jhusseth
 *
 */
public class UniversityMonitoring {
	
	/**
	 * Número de sillas disponibles en la sala d espera de la oficina del monitor
	 */
	public static final int NUM_OF_CHAIRS = 3;
	/**
	 * Número de estudiantes 
	 */
	public static final int NUM_OF_STUDENTS = 10;

	/**
	 * Metodo principal para la ejcución del programa
	 * @param args
	 */
	public static void main(String[] args) {
	
		Monitor monitor = new Monitor(NUM_OF_CHAIRS);
		monitor.start();
		
		Student[] students = new Student[NUM_OF_STUDENTS];
			   
		for (int i = 0; i < NUM_OF_STUDENTS; i++) {
			students[i] = new Student(i, monitor);
			students[i].start();
			ThreadSleep.nap();
		}
	}

}
