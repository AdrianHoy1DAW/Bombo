package es.ieslavereda.app;

import java.awt.EventQueue;

import es.ieslavereda.controlador.Controlador;
import es.ieslavereda.vistasimulacion.VistaBombo;

public class APP {
	
		/**
		 * Launch the application.
		 */
		public static void main(String[] args) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						VistaBombo frame = new VistaBombo();
						Controlador c = new Controlador(frame);
						c.go();
						
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		}

	}

