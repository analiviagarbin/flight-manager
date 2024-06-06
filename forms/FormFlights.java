package forms;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import app.Airports;
import app.Flights;
import app.ListaEncadeadaDesordenadaSemRepeticao;

public class FormFlights {

	private JFrame frmTodosOsVoos;
	private JTable tbAllFlights;
	private static DefaultTableModel model;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run(ListaEncadeadaDesordenadaSemRepeticao<Airports> airportsList) 
			{
				try 
				{
					FormFlights window = new FormFlights();
					window.frmTodosOsVoos.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

			@Override
			public void run() {
				// TODO Auto-generated method stub
				
			}
		});
	}
	
	public static void updateData(ListaEncadeadaDesordenadaSemRepeticao<Airports> airportsList)
	{
		try
		{
			Airports atual = airportsList.getPrimeiro();		
			ListaEncadeadaDesordenadaSemRepeticao<Flights> flightsAirport;
			Flights atualFlights;
			
			for(int i = 0; i < airportsList.getQtd(); i ++)
			{ 
				flightsAirport = atual.getFlights();
				if(flightsAirport.getQtd() > 0)
				{
					for(int e = 0; e < atual.getFlights().getQtd(); e++)
					{						
						atualFlights = flightsAirport.getPrimeiro();
						flightsAirport.removaDoInicio();
						flightsAirport.insiraNoFim(atualFlights);
						
						model.addRow(new Object[]{atualFlights.getCityName(), atualFlights.getCod(), atual.getCity(), atual.getAirportCod()});
					}
				}

				airportsList.removaDoInicio();
				airportsList.insiraNoFim(atual);
				atual = airportsList.getPrimeiro();
			}
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}
		
	}

	/**
	 * Create the application.
	 */
	public FormFlights() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmTodosOsVoos = new JFrame();
		frmTodosOsVoos.setTitle("Voos");
		frmTodosOsVoos.setBounds(100, 100, 600, 450);
		frmTodosOsVoos.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmTodosOsVoos.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		frmTodosOsVoos.getContentPane().add(panel, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("Todos os voos");
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		frmTodosOsVoos.getContentPane().add(panel_1, BorderLayout.CENTER);
		
		model = new DefaultTableModel();
		tbAllFlights = new JTable(model);
		panel_1.add(tbAllFlights);
		panel_1.add(tbAllFlights.getTableHeader(), BorderLayout.NORTH);
		panel_1.add(tbAllFlights, BorderLayout.CENTER);
		
		// model
		model.addColumn("Cidade Destino");
		model.addColumn("Número do voo");
		model.addColumn("Cidade natal");
		model.addColumn("Aeroporto natal");
		tbAllFlights.getColumnModel().getColumn(0).setMinWidth(200);
		tbAllFlights.getColumnModel().getColumn(1).setMinWidth(50);
		tbAllFlights.getColumnModel().getColumn(2).setMinWidth(200);
		tbAllFlights.getColumnModel().getColumn(3).setMinWidth(50);
	}

	public void setVisible(boolean b) {
		frmTodosOsVoos.setVisible(true);
		
	}

}
