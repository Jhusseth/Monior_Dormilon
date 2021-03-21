package model;

import java.util.concurrent.Semaphore;

/**
 * 
 * @author Jhusseth
 *
 */
public class Monitor extends Thread{

	   /**
		* Semaforo que corresponde a si la disponibilidad en atencion del monitor esta ocupada
	    */
	   private Semaphore monitor;
	   
	   /**
	    * Semaforo que corresponde a si el monitor de encuentra ocupado
	    */
	   private Semaphore attention;
	   
	   /**
	    * Constructor del monitor
	    * @param chairs : numero de sillas disponible para la espera
	    */
	   public Monitor( int chairs ) {
	      attention = new Semaphore(1);
	      monitor = new Semaphore(chairs);
	   }
	
	   /**
	    * Metodo para ingresar al estudiante a la atención del monitor  
	    * @param id
	    */
	   public void enterStudent(int id) {
//		  while(true) {
		      if(monitor.availablePermits() > 0){
		    	  try{
		    		  monitor.acquire();
			      	  System.out.println("Estudiante " + id + " está esperando turno");
			          ThreadSleep.nap();
		    	  } 
		    	  catch(InterruptedException e) { 
		        	  e.printStackTrace();
		    	  }
		   
				  try {
					  attention.acquire(); 
				  } 
				  catch (InterruptedException e) {
					  e.printStackTrace();
				  }
				  
				  finally {
					  monitor.release();
					  leaveStudent(id);
					  attention.release();
				  }  
			  }
			  else{
				  System.out.println("Estudiante " + id + " se fue de la oficina");
				  ThreadSleep.nap();
			  }  
//		  }
	
	   }
	
	   /**
	    * Metodo para terminar la atención del estudiante con el monitor
	    * @param id
	    */
	   private void leaveStudent(int id) {
	      System.out.println ("Estudiante " + id + " está siendo antendido");
	      ThreadSleep.nap();
		  System.out.println ("Estudiante " + id + " ya fue atendido");
	   }
}
