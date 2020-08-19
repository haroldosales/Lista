package sistema;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane.CloseAction;


import controle.Controle;

import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.Closeable;

public class gui {

	private JFrame frame;
	private JTextField txtNome;
	private JTextField txtTipo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					gui window = new gui();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public gui() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		txtNome = new JTextField();
		txtNome.setBounds(178, 12, 114, 19);
		frame.getContentPane().add(txtNome);
		txtNome.setColumns(10);
		
		txtTipo = new JTextField();
		txtTipo.setBounds(178, 64, 114, 19);
		frame.getContentPane().add(txtTipo);
		txtTipo.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Name:");
		lblNewLabel.setBounds(36, 14, 70, 15);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Tipo:");
		lblNewLabel_1.setBounds(36, 66, 70, 15);
		frame.getContentPane().add(lblNewLabel_1);
		
		JButton btnAdd = new JButton("Salvar");
		btnAdd.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Controle fun = new Controle();
				int numero = Integer.parseInt(txtTipo.getText());
			
				fun.insere(txtNome.getText(), numero);
			}
		});
		btnAdd.setBounds(39, 130, 117, 25);
		frame.getContentPane().add(btnAdd);
		
		JButton btnClose = new JButton("Fecha");
		btnClose.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		btnClose.setBounds(230, 130, 117, 25);
		frame.getContentPane().add(btnClose);
	}
}
