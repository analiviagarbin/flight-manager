package forms;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import app.Airports;
import app.Flights;
import app.ListaEncadeadaDesordenadaSemRepeticao;

import javax.swing.JSplitPane;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import java.awt.Insets;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class main extends JFrame {

	private JPanel contentPane;
	private static JTextField txtCidade;
	private static JTextField txtCod;
	private static JPanel panel_1;
	private static Airports atual;
	private static ListaEncadeadaDesordenadaSemRepeticao<Airports> listaAirports;
	private static JTable tbFlights;
	private static DefaultTableModel model;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					main frame = new main();
					frame.setVisible(true);
					
					listaAirports = new ListaEncadeadaDesordenadaSemRepeticao<Airports>();
					
					listaAirports.insiraNoFim(new Airports("Brasília", "BSB"));
					listaAirports.insiraNoFim(new Airports("Belo Horizonte", "CNF"));
					listaAirports.insiraNoFim(new Airports("Rio de Janeiro", "GIG"));
					listaAirports.insiraNoFim(new Airports("Salvador", "SSA"));
					listaAirports.insiraNoFim(new Airports("São Paulo", "GRU"));
														
					atual = listaAirports.getPrimeiro();			
					
					updateAirports();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public static void updateAirports()
	{
		model.setRowCount(0);
		txtCidade.setText(atual.getCity());
		txtCod.setText(atual.getAirportCod());	
		try {
			ListaEncadeadaDesordenadaSemRepeticao<Flights> flights = atual.getFlights();	
			Flights atualFlights = flights.getPrimeiro();
			
			if (model.getRowCount() > 0) {
			    for (int i = model.getRowCount() - 1; i > -1; i--) {
			    	model.removeRow(i);
			    }
			}
			
			for(int i = 0; i < flights.getQtd(); i++)
			{
					model.addRow(new Object[]{atualFlights.getCityName(), atualFlights.getCod(), atual.getCity(), atual.getAirportCod()});
				
					flights.removaDoInicio();
					flights.insiraNoFim(atualFlights);
					atualFlights = flights.getPrimeiro();
			}
			
			
			panel_1.add(tbFlights);
		}
		catch(Exception ex)
		{}
	}
	

	/**
	 * Create the frame.
	 */
	public main() {
		setTitle("Airports");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 840, 630);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		panel.setLayout(new GridLayout(1, 0, 0, 0));
		
		JButton btnNewAirports = new JButton("Adicionar Aeroporto");
		btnNewAirports.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FormAddAirport addAirport = new FormAddAirport();
				addAirport.setVisible(true);
				addAirport.setData(listaAirports);
			}
		});
		panel.add(btnNewAirports);
		
		JLabel lbCidade = new JLabel("Cidade");
		panel.add(lbCidade);
		
		txtCidade = new JTextField();
		txtCidade.setEditable(false);
		panel.add(txtCidade);
		txtCidade.setColumns(10);
		
		JLabel lbCod = new JLabel("Código");
		panel.add(lbCod);
		
		txtCod = new JTextField();
		txtCod.setEditable(false);
		panel.add(txtCod);
		txtCod.setColumns(10);
		
		JButton btnPrevious = new JButton("Anterior");
		btnPrevious.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					atual = listaAirports.getUltimo();
					listaAirports.removaDoFim();
					listaAirports.insiraNoInicio(atual);
				}
				catch(Exception e1) {
					e1.printStackTrace();
				}
				updateAirports();
			}
		});
		panel.add(btnPrevious);
		
		JButton btnNext = new JButton("Próximo");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				try {
					listaAirports.removaDoInicio();
					listaAirports.insiraNoFim(atual);
					atual = listaAirports.getPrimeiro();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				updateAirports();
			}			
		});
		panel.add(btnNext);
		
		panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		
		model = new DefaultTableModel();
		tbFlights = new JTable(model);
		panel_1.add(tbFlights);
		panel_1.add(new JScrollPane(tbFlights));
		panel_1.add(tbFlights.getTableHeader(), BorderLayout.NORTH);
		panel_1.add(tbFlights, BorderLayout.CENTER);
		
		// Columns 
		model.addColumn("Cidade Destino");
		model.addColumn("Número do voo");
		model.addColumn("Cidade natal");
		model.addColumn("Aeroporto natal");
		tbFlights.getColumnModel().getColumn(0).setMinWidth(250);
		tbFlights.getColumnModel().getColumn(1).setMinWidth(100);
		tbFlights.getColumnModel().getColumn(2).setMinWidth(250);
		tbFlights.getColumnModel().getColumn(3).setMinWidth(100);
		
		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2, BorderLayout.SOUTH);
		panel_2.setLayout(new GridLayout(1, 0, 0, 0));
		
		JLabel lbFlights = new JLabel("Gerenciar voos");
		panel_2.add(lbFlights);
		
		JButton btnAddFlight = new JButton("Adicionar");
		btnAddFlight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FormAddFlight addFlight = new FormAddFlight();
				addFlight.setVisible(true);
				addFlight.setAirport(atual);
			}
		});
		panel_2.add(btnAddFlight);
		
		JButton btnExcuir = new JButton("Excluir");
		btnExcuir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FormDelFlight delFlight = new FormDelFlight();
				delFlight.setVisible(true);
				delFlight.setAirport(atual);
			}
		});
		panel_2.add(btnExcuir);
		
		JButton btnAllFlights = new JButton("Mostrar todos");
		btnAllFlights.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FormFlights allFlights = new FormFlights();
				allFlights.setVisible(true);
				allFlights.updateData(listaAirports);
			}
		});
		panel_2.add(btnAllFlights);
		
	}

}
