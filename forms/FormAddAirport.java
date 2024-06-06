package forms;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;

import app.Airports;
import app.ListaEncadeadaDesordenadaSemRepeticao;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FormAddAirport {

	private JFrame frmAdicionarAeroporto;
	private JTextField txtCityAirport;
	private JTextField txtCod;
	private static ListaEncadeadaDesordenadaSemRepeticao<Airports> airports;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormAddAirport window = new FormAddAirport();
					window.frmAdicionarAeroporto.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public FormAddAirport() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAdicionarAeroporto = new JFrame();
		frmAdicionarAeroporto.setTitle("Adicionar Aeroporto");
		frmAdicionarAeroporto.setBounds(100, 100, 450, 300);
		frmAdicionarAeroporto.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		JPanel panel_3 = new JPanel();
		frmAdicionarAeroporto.getContentPane().add(panel_3, BorderLayout.CENTER);
		panel_3.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblCityAirport = new JLabel("Cidade do aeroporto");
		panel_3.add(lblCityAirport);
		
		txtCityAirport = new JTextField();
		txtCityAirport.setColumns(10);
		panel_3.add(txtCityAirport);
		
		JLabel lbCodAirport = new JLabel("Código aeroporto");
		panel_3.add(lbCodAirport);
		
		txtCod = new JTextField();
		txtCod.setColumns(10);
		panel_3.add(txtCod);
		
		JPanel panel_1 = new JPanel();
		panel_3.add(panel_1);
		
		JPanel panel_4 = new JPanel();
		panel_3.add(panel_4);
		
		JPanel panel_5 = new JPanel();
		panel_3.add(panel_5);
		
		JLabel lbError = new JLabel("");
		panel_5.add(lbError);
		
		JPanel panel_6 = new JPanel();
		panel_3.add(panel_6);
		
		JPanel panel = new JPanel();
		frmAdicionarAeroporto.getContentPane().add(panel, BorderLayout.NORTH);
		
		JLabel lblAdicionarAeroportoEm = new JLabel("Adicionar aeroporto");
		panel.add(lblAdicionarAeroportoEm);
		
		JPanel panel_2 = new JPanel();
		frmAdicionarAeroporto.getContentPane().add(panel_2, BorderLayout.SOUTH);
		panel_2.setLayout(new GridLayout(0, 2, 0, 0));
		
		JButton btnClear = new JButton("Limpar Campos");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtCityAirport.setText("");
				txtCod.setText("");
			}
		});
		panel_2.add(btnClear);
		
		JButton btnSave = new JButton("Salvar");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txtCityAirport.getText().isEmpty() || txtCod.getText().isEmpty())
				{
					lbError.setText("Algum campo nulo");
					return;
				}
				try {
					airports.insiraNoFim(new Airports(txtCityAirport.getText(), txtCod.getText()));
				}
				catch(Exception ex)
				{}
				
				frmAdicionarAeroporto.dispose();
			}
		});
		panel_2.add(btnSave);
	}

	public void setVisible(boolean b) {
		frmAdicionarAeroporto.setVisible(true);
	}

	public void setData(ListaEncadeadaDesordenadaSemRepeticao<Airports> listaAirports) {
			this.airports = listaAirports;		
	}

}
