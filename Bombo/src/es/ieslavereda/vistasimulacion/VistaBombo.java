package es.ieslavereda.vistasimulacion;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SpinnerNumberModel;

import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JTable;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.JSlider;
import javax.swing.JScrollPane;
import javax.swing.event.ChangeEvent;

public class VistaBombo extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JComboBox<Integer> comboBox;
	private JSpinner spinner;
	private JSlider slider;
	private JButton btnSimular;
	private JTable table;
	private DefaultTableModel dtm;
	private JLabel cambio;
	private DefaultComboBoxModel<Integer> dim;



	/**
	 * Create the frame.
	 */
	public VistaBombo() {
		
		Integer[] numeros = new Integer[100];
		
		for(int i = 0; i < 100; i++) {
			numeros[i] = i +1;
		}
		
		dim = new DefaultComboBoxModel<Integer>(numeros);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 894, 617);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		
		JPanel panel_1 = new JPanel();
		
		JPanel panel_2 = new JPanel();
		
		JPanel panel_3 = new JPanel();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(panel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 416, Short.MAX_VALUE)
						.addComponent(panel_3, GroupLayout.DEFAULT_SIZE, 416, Short.MAX_VALUE)
						.addComponent(panel_2, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 416, Short.MAX_VALUE)
						.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 416, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE)
					.addGap(18)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 261, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(panel_3, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		panel.setLayout(new MigLayout("", "[][51.00][][][][grow]", "[][][][][][]"));
		
		JLabel lblNumeroDeBolas = new JLabel("Numero de bolas");
		panel.add(lblNumeroDeBolas, "cell 0 0,alignx trailing");
		
		comboBox = new JComboBox<Integer>();
		comboBox.setModel(dim);
		panel.add(comboBox, "cell 1 0,growx");
		
		JLabel lblTemasEstudiados = new JLabel("Temas Estudiados");
		panel.add(lblTemasEstudiados, "cell 2 0,alignx trailing");
		
		textField = new JTextField();
		panel.add(textField, "cell 5 0,growx");
		textField.setColumns(10);
		
		JLabel lblBolasAExtraer = new JLabel("Bolas a Extraer");
		panel.add(lblBolasAExtraer, "cell 0 2");
		
		spinner = new JSpinner();
		spinner.setModel(new SpinnerNumberModel(1,1,10,1));
		panel.add(spinner, "cell 1 2");
		
		JLabel lblSimulaciones = new JLabel("Simulaciones");
		panel.add(lblSimulaciones, "cell 2 2");
		
		slider = new JSlider();
		slider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				cambio.setText(String.valueOf(slider.getValue()));
			}
		});
		
		cambio = new JLabel("0");
		panel.add(cambio, "cell 4 2");
		slider.setPaintTicks(true);
		slider.setPaintLabels(true);
		slider.setMajorTickSpacing(25);
		slider.setMinorTickSpacing(5);
		
		panel.add(slider, "cell 5 2,growx");
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		panel_1.add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		dtm = new DefaultTableModel();
		table.setModel(dtm);
		scrollPane.setViewportView(table);
		panel_3.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));
		
		btnSimular = new JButton("Simular");
		panel_3.add(btnSimular);
		contentPane.setLayout(gl_contentPane);
		
		
	}

	public JTextField getTextField() {
		return textField;
	}

	public JComboBox<Integer> getComboBox() {
		return comboBox;
	}

	public JSpinner getSpinner() {
		return spinner;
	}

	public JSlider getSlider() {
		return slider;
	}

	public JButton getBtnSimular() {
		return btnSimular;
	}

	public JTable getTable() {
		return table;
	}

	public DefaultTableModel getDtm() {
		return dtm;
	}

	public DefaultComboBoxModel<Integer> getDim() {
		return dim;
	}
}
