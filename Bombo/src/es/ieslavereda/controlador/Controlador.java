package es.ieslavereda.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import es.ieslavereda.modelo.Bombo;
import es.ieslavereda.vistasimulacion.VistaBombo;

public class Controlador implements ActionListener{

	private VistaBombo vista;
	private Bombo bombo;
	
	public Controlador(VistaBombo vista) {
		
		this.vista = vista;
		this.bombo = new Bombo();
		
		inicializar();
		
	}
	
	private void inicializar() {
		
		vista.getBtnSimular().addActionListener(this);
		
		vista.getBtnSimular().setActionCommand("Simular");
		
	}
	
	public void go() {
		
		vista.setVisible(true);
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		String comando = arg0.getActionCommand();
		if(comando.equals("Simular")) {
			simular();
		}
		
	}

	private void simular() {
		
		for(int i = 0; i < (Integer)vista.getSpinner().getValue();i++) {
			
	
			
			System.out.println(bombo.sacarBola((Integer)vista.getComboBox().getSelectedItem()));
			
		}
		
		
	}
	
	
	
	
}
