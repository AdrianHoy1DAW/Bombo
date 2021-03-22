package es.ieslavereda.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;



import es.ieslavereda.modelo.Bombo;
import es.ieslavereda.vistasimulacion.VistaBombo;

public class Controlador implements ActionListener{

	private VistaBombo vista;
	private Bombo bombo;
	private ArrayList<Integer> temas;
	
	public Controlador(VistaBombo vista) {
		
		this.vista = vista;
		this.bombo = new Bombo();
		temas = new ArrayList<>();
		
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
		
		if(comprobacionesPrevias() == false) {
			
		} else {
			DefaultTableModel dtm = new DefaultTableModel();
			
			vista.getTable().setModel(dtm);
			
		
			
			dtm.addColumn("Simulacion nº");
			
			for(int bola = 0; bola < (Integer)vista.getSpinner().getValue(); bola ++) {
				dtm.addColumn("Bola" + (bola +1));
			}
			
			dtm.addColumn("Exito");
			dtm.addColumn("Nº aciertos");
			
			for(int i =0; i < (Integer)vista.getSlider().getValue();i++) {
				
				
				dtm.addRow(rellenar(i));
				
			}
		}
		
		rellenarBajo();

		
		
	}
	
	private Object[] rellenar(int simulacion) {
		
		boolean comprueba = false;
		int aciertos = 0;
		
		bombo.rellenar((Integer)vista.getComboBox().getSelectedItem());
		
		Object[] obj = new Object[(Integer)vista.getSpinner().getValue() +3];
		
		obj[0] = simulacion  + 1;
		
		for(int i = 0; i < (Integer)vista.getSpinner().getValue(); i++ ) {
			
			obj[i +1] = bombo.sacarBola((Integer)vista.getComboBox().getSelectedItem());
			if(temas.contains(obj[i +1])) {
				comprueba = true;
				aciertos ++;
			}
			
		}
		
		obj[obj.length -2] = comprueba;
		obj[obj.length -1] = aciertos;
		
		
		
		return obj;
		
	}
	
	private boolean comprobacionesPrevias() {
		
		temas.removeAll(temas);
		String[] temas = vista.getTextField().getText().replaceAll(" ", "").split(",");
		boolean comprobador = true;
		
		if((Integer)vista.getComboBox().getSelectedItem() < (Integer)vista.getSpinner().getValue()) {
			
			comprobador = false;
			JOptionPane.showMessageDialog(vista, "No puedes sacar más bolas que temas disponibles", "Error", JOptionPane.ERROR_MESSAGE);	
		} else if(temas.length > (Integer)vista.getComboBox().getSelectedItem()) {
			JOptionPane.showMessageDialog(vista,"Hay estudiado demasiado", "Error", JOptionPane.ERROR_MESSAGE);
			comprobador = false;
		} else {
			try {
				for(int i = 0; i < temas.length; i++) {
					
					this.temas.add(Integer.parseInt(temas[i]));
			
				
				
				}
			} catch(Exception e) {
				
				JOptionPane.showMessageDialog(vista, "Pon los temas como número", "Error", JOptionPane.ERROR_MESSAGE);
				comprobador = false;
			}
		}
		
		return comprobador;
			
	}
	
	private void rellenarBajo() {
		
		vista.getTxtFinal().setText("Iteraciones: " + vista.getSlider().getValue() + " Numero de Temas: " + vista.getComboBox().getSelectedItem() + 
				" Temas estudiados: " + temas.size());
		
	}

	

	
	
	
	
}
