package model;

/**
 * 
 * @author Jhusseth
 *
 */
public class Student extends Thread{
	/**
	 * identifidor del estudiante 
	 */
	 private int id;
	 
	 /**
	  * Relacion del estudiante con el monitor
	  */
	 private Monitor monitor;

	 /**
	  * Constructor del estudiante
	  * @param id
	  * @param monitor
	  */
	 public Student (int id, Monitor monitor) {
		 this.id = id;
	     this.monitor = monitor;
	 }

	 /**
	  * Metodo principal del hilo
	  */
	 @Override
	 public void run() {
		 while(true) {
			 monitor.enterStudent(id);
	 	 }
	 }
}
