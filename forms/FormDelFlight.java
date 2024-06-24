package forms;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import app.Airports;
import app.Flights;
import app.ListaEncadeadaDesordenadaSemRepeticao;

public class FormDelFlight {

	private JFrame frmExcluirVoo;
	private JTextField txtCod;
	private JTextField txtCity;
	private JTextField txtCodFlight;
	private JTextField txtDest;
	private JTextField txtDepartureTime;
	private JTextField txtArrivalTime;
	private JTextField txtPassengerCount;
	private static Airports atual;
	private static Flights flightToDel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormDelFlight window = new FormDelFlight();
					window.frmExcluirVoo.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public FormDelFlight() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmExcluirVoo = new JFrame();
		frmExcluirVoo.setTitle("Excluir voo");
		frmExcluirVoo.setBounds(100, 100, 356, 300);
		frmExcluirVoo.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmExcluirVoo.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		frmExcluirVoo.getContentPane().add(panel, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("Excluir voo em");
		panel.add(lblNewLabel);
		
		txtCod = new JTextField();
		txtCod.setEditable(false);
		txtCod.setText("");
		panel.add(txtCod);
		txtCod.setColumns(10);
		
		txtCity = new JTextField();
		txtCity.setEditable(false);
		panel.add(txtCity);
		txtCity.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		frmExcluirVoo.getContentPane().add(panel_1, BorderLayout.SOUTH);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JLabel label = new JLabel("");
		panel_1.add(label);

		JButton btnDelete = new JButton("Excluir");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try 
				{
					atual.removeFlight(flightToDel);
					frmExcluirVoo.dispose();
					main.updateAirports();
				} 
				catch (Exception e1) {}
			}
		});
		btnDelete.setEnabled(false);
		panel_1.add(btnDelete);
		
		JPanel panel_2 = new JPanel();
		frmExcluirVoo.getContentPane().add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_3 = new JPanel();
		panel_2.add(panel_3, BorderLayout.WEST);
		panel_3.setLayout(new GridLayout(0, 2, 0, 0));

		JLabel lbCodFlight = new JLabel("Número do voo");
		panel_3.add(lbCodFlight);
		txtCodFlight = new JTextField();
		panel_3.add(txtCodFlight, "cell 2 2,growx");
		txtCodFlight.setColumns(10);

		JButton btnSearch = new JButton("Procurar");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListaEncadeadaDesordenadaSemRepeticao<Flights> listaAirports;
				
				try {
					listaAirports = atual.getFlights();
					Flights atualFlights = listaAirports.getPrimeiro();
					
					for(int i = 0; i < listaAirports.getQtd(); i++)
					{						
						if(atualFlights.getCod() == Integer.parseInt(txtCodFlight.getText()))
						{
							txtDest.setText(atualFlights.getCityName());
							txtDepartureTime.setText(atualFlights.getDepartureTime());
							txtArrivalTime.setText(atualFlights.getArrivalTime());
							txtPassengerCount.setText(Integer.toString(atualFlights.getPassengerCount()));
							btnDelete.setEnabled(true);
							flightToDel = atualFlights;
						}
						
						listaAirports.removaDoInicio();
						listaAirports.insiraNoFim(atualFlights);
						atualFlights = listaAirports.getPrimeiro();
						
					}
				}
				catch(Exception ex)
				{
					ErrorForm errorForm = new ErrorForm("Voo não encontrado");
					errorForm.display();
				}

			}
		});

		JLabel lbDepartureTime = new JLabel("Horário de saída");
		panel_3.add(lbDepartureTime);

		txtDepartureTime = new JTextField();
		txtDepartureTime.setColumns(10);
		panel_3.add(txtDepartureTime);

		JLabel lbArrivalTime = new JLabel("Horário de chegada");
		panel_3.add(lbArrivalTime);

		txtArrivalTime = new JTextField();
		txtArrivalTime.setColumns(10);
		panel_3.add(txtArrivalTime);

		JLabel lbPassengerCount = new JLabel("Quantidade de passageiros");
		panel_3.add(lbPassengerCount);

		txtPassengerCount = new JTextField();
		txtPassengerCount.setColumns(10);
		panel_3.add(txtPassengerCount);
		
		JLabel lblNewLabel_2 = new JLabel("Destino");
		panel_3.add(lblNewLabel_2, "cell 0 3");

		txtDest = new JTextField();
		txtDest.setEditable(false);
		panel_3.add(txtDest, "cell 2 3,growx");
		txtDest.setColumns(10);
		panel_3.add(btnSearch, "cell 5 2");
	}

	public void setVisible(boolean b) {
		frmExcluirVoo.setVisible(true);		
	}
	
	public void setAirport(Airports atual) {
		this.atual = atual;
		txtCod.setText(this.atual.getAirportCod());
		txtCity.setText(this.atual.getCity());
	}
}
