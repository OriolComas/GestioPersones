package Vista;



import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTextField;

import javax.swing.JButton;
import javax.swing.JToolBar;


import java.awt.SystemColor;


public class Vista extends JFrame {


	private JPanel contentPane;
	private JTextField textPrimerCognom;
	private JButton btnNou;
	private JButton btnEsborrar;
	private JButton btnEditar;
	private JButton btnPrimer;
	private JButton btnDarrer;
	private JButton btnAnterior;
	private JButton btnSeguent;
	private JButton btnDesa;
	private JButton btnCancelar;
	private JTextField textDni;
	private JTextField textEdat;
	private JTextField textSegonCognom;
	private JTextField textNom;
	private JLabel lblPanell;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	public Vista() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 583, 323);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JToolBar toolBar = new JToolBar();
		
		JLabel lblNewLabel = new JLabel("DNI:");
		
		textPrimerCognom = new JTextField();
		textPrimerCognom.setEditable(false);
		textPrimerCognom.setColumns(10);
		
		JLabel lblNom = new JLabel("Nom:");
		
		JLabel lblPrimer = new JLabel("Primer cognom:");
		
		JLabel lblSegonCognom = new JLabel("Segon cognom:");
		
		JLabel lblEdat = new JLabel("Edat:");
		
		textDni = new JTextField();
		textDni.setEditable(false);
		textDni.setColumns(10);
		
		textEdat = new JTextField();
		textEdat.setEditable(false);
		textEdat.setColumns(10);
		
		textSegonCognom = new JTextField();
		textSegonCognom.setEditable(false);
		textSegonCognom.setColumns(10);
		
		textNom = new JTextField();
		textNom.setEditable(false);
		textNom.setColumns(10);
		
		btnNou = new JButton("Nou");
		btnNou.setBackground(SystemColor.menu);
		toolBar.add(btnNou);
		
		 btnEsborrar = new JButton("Esborra");
		toolBar.add(btnEsborrar);
		
		 btnEditar = new JButton("Edita");
		toolBar.add(btnEditar);
		
		 btnPrimer = new JButton("Primer");
		toolBar.add(btnPrimer);
		
		 btnDarrer = new JButton("Darrer");
		toolBar.add(btnDarrer);
		
		 btnAnterior = new JButton("Anterior");
		toolBar.add(btnAnterior);
		
		btnSeguent = new JButton("Seg\u00FCent");
		toolBar.add(btnSeguent);
		
		 btnDesa = new JButton("Desa");
		btnDesa.setEnabled(false);
		toolBar.add(btnDesa);
		
		 btnCancelar = new JButton("Cancela");
		btnCancelar.setEnabled(false);
		toolBar.add(btnCancelar);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNom)
						.addComponent(lblPrimer)
						.addComponent(lblNewLabel)
						.addComponent(lblSegonCognom)
						.addComponent(lblEdat, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE))
					.addGap(10)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(textSegonCognom, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 427, Short.MAX_VALUE)
						.addComponent(textPrimerCognom, GroupLayout.DEFAULT_SIZE, 427, Short.MAX_VALUE)
						.addComponent(textNom, GroupLayout.DEFAULT_SIZE, 427, Short.MAX_VALUE)
						.addComponent(textEdat, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 427, Short.MAX_VALUE)
						.addComponent(textDni, GroupLayout.DEFAULT_SIZE, 427, Short.MAX_VALUE))
					.addGap(46))
				.addComponent(toolBar, GroupLayout.DEFAULT_SIZE, 567, Short.MAX_VALUE)
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(toolBar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(26)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(textDni, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNom)
						.addComponent(textNom, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPrimer)
						.addComponent(textPrimerCognom, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(textSegonCognom, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblSegonCognom))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(textEdat, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblEdat))
					.addGap(64))
		);
		
		 lblPanell = new JLabel("New label");
		toolBar.add(lblPanell);
		contentPane.setLayout(gl_contentPane);
	}

	public JLabel getlblPanell(){
		return lblPanell;
	}
	public JButton getBtnEsborrar(){
		return btnEsborrar;
	}
	public JButton getBtnNou(){
		return btnNou;
	}
	public JButton getBtnEditar(){
		return btnEditar;
	}
	public JButton getBtnPrimer(){
		return btnPrimer;
	}
	public JButton getBtnDarrer(){
		return btnDarrer;
	}
	public JButton getBtnAnterior(){
		return btnAnterior;
	}
	public JButton getBtnSeguent(){
		return btnSeguent;
	}
	public JButton getBtnDesar(){
		return btnDesa;
	}
	public JButton getBtnCancelar(){
		return btnCancelar;
	}
	
	public JTextField getTextPrimerCognom() {
		return textPrimerCognom;
	}

	public JButton getBtnDesa() {
		return btnDesa;
	}

	public JTextField getTextDni() {
		return textDni;
	}

	public JTextField getTextEdat() {
		return textEdat;
	}

	public JTextField getTextSegonCognom() {
		return textSegonCognom;
	}

	public JTextField getTextNom() {
		return textNom;
	}

	public JLabel getLblPanell() {
		return lblPanell;
	}

	
}
	

