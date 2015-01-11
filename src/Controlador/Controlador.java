package Controlador;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import javax.swing.JOptionPane;
import Model.Llista;
import Model.Persona;
import Vista.Vista;

public class Controlador {
	private Llista model;
	private Vista vista;
	private Boolean control = false;

	public Controlador(Llista model, Vista vista) {
		this.model = model;

		this.vista = vista;
	}

	public void control() throws UnsupportedEncodingException,
			FileNotFoundException, IOException {

		File fitxer = new File("Dades.csv");
		if (fitxer.exists()) {
			model = LlegirFitxercsv("Dades.csv");
		} else {
			fitxer.createNewFile();
		}

		if (model.isEmpty()) {

			vista.getlblPanell().setText("0 registres");
			cambiarBoolean(false);
			vista.getBtnDesar().setEnabled(false);
			vista.getBtnCancelar().setEnabled(false);
			vista.getBtnNou().setEnabled(true);

		} else {

			vista.getlblPanell().setText(
					"Registre " + (model.getIndex() + 1) + " de "
							+ model.size());
			mostrarDades(0);
		}
		vista.getBtnNou().addActionListener(e -> btnNou_click());
		vista.getBtnCancelar().addActionListener(e -> btnCancelar_click());
		vista.getBtnEsborrar().addActionListener(e -> btnEsborrar_click());
		vista.getBtnSeguent().addActionListener(e -> btnSeguent_click());
		vista.getBtnAnterior().addActionListener(e -> btnAnterior_click());
		vista.getBtnDarrer().addActionListener(e -> btnDarrer_click());
		vista.getBtnPrimer().addActionListener(e -> btnPrimer_click());
		vista.getBtnDesa().addActionListener(e -> btnDesar_click());
		vista.getBtnEditar().addActionListener(e -> btnEditar_click());
		vista.addWindowListener(new WindowListener() {

			@Override
			public void windowOpened(WindowEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void windowIconified(WindowEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void windowDeiconified(WindowEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void windowDeactivated(WindowEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				EscriureFitxercsv();

			}

			@Override
			public void windowClosed(WindowEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void windowActivated(WindowEvent e) {
				// TODO Auto-generated method stub

			}
		});

	}

	public void mostrarDades(int index) {
		vista.getTextDni().setText(model.get(index).getDni());
		vista.getTextEdat().setText(model.get(index).getEdat() + "");
		vista.getTextNom().setText(model.get(index).getNom());
		vista.getTextPrimerCognom().setText(model.get(index).getPrimerCognom());
		vista.getTextSegonCognom().setText(model.get(index).getSegonCognom());

	}

	public void cambiarBoolean(Boolean valor) {
		vista.getBtnNou().setEnabled(valor);
		vista.getBtnEsborrar().setEnabled(valor);
		vista.getBtnEditar().setEnabled(valor);
		vista.getBtnPrimer().setEnabled(valor);
		vista.getBtnDarrer().setEnabled(valor);
		vista.getBtnAnterior().setEnabled(valor);
		vista.getBtnSeguent().setEnabled(valor);
		vista.getBtnDesar().setEnabled(!valor);
		vista.getBtnCancelar().setEnabled(!valor);
	}

	public void cambiarEditable(Boolean valor) {
		vista.getTextDni().setEditable(valor);
		vista.getTextNom().setEditable(valor);
		vista.getTextPrimerCognom().setEditable(valor);
		vista.getTextSegonCognom().setEditable(valor);
		vista.getTextEdat().setEditable(valor);
	}

	public void labelsbuits() {
		vista.getTextDni().setText(null);
		vista.getTextNom().setText(null);
		vista.getTextPrimerCognom().setText(null);
		vista.getTextSegonCognom().setText(null);
		vista.getTextEdat().setText(null);
	}

	public void btnNou_click() {
		cambiarBoolean(false);
		cambiarEditable(true);
		labelsbuits();
		vista.getlblPanell().setText(" Nou registre");

	}

	public void btnEsborrar_click() {

		int resposta = JOptionPane.showConfirmDialog(null,
				"Està segur que vol borrar el registre?", "Esborrar persona",
				JOptionPane.YES_NO_OPTION);
		if (resposta == JOptionPane.YES_OPTION) {
			if (model.size() - 1 == 0) {
				model.getLlista().remove(model.getIndex());
				vista.getlblPanell().setText("No hi ha registres");
				cambiarBoolean(false);
				vista.getBtnDesar().setEnabled(false);
				vista.getBtnCancelar().setEnabled(false);
				labelsbuits();
			} else {

				if (model.getIndex() != 0) {
					model.getLlista().remove(model.getIndex());
					model.setIndex(model.getIndex() - 1);
					vista.getlblPanell().setText(
							"Registre " + (model.getIndex() + 1) + " de "
									+ model.size());
					mostrarDades(model.getIndex());
				} else {
					model.getLlista().remove(model.getIndex());
					vista.getlblPanell().setText(
							"Registre " + (model.getIndex() + 1) + " de "
									+ model.size());
					mostrarDades(model.getIndex());
				}
			}

		}

	}

	public void btnPrimer_click() {
		mostrarDades(0);
		vista.getlblPanell().setText("Registre 1 de " + model.size());
	}

	public void btnDarrer_click() {
		mostrarDades(model.size() - 1);
		model.setIndex(model.size() - 1);
		vista.getlblPanell().setText(
				"Registre " + model.size() + " de " + model.size());
	}

	public void btnSeguent_click() {
		if (model.getIndex() < model.size() - 1) {
			mostrarDades(model.getIndex() + 1);
			model.setIndex(model.getIndex() + 1);
			vista.getlblPanell().setText(
					"Registre " + (model.getIndex() + 1) + " de "
							+ model.size());
		}
	}

	public void btnAnterior_click() {
		if (model.getIndex() > 0) {
			mostrarDades(model.getIndex() - 1);
			model.setIndex(model.getIndex() - 1);
			vista.getlblPanell().setText(
					"Registre " + (model.getIndex() + 1) + " de "
							+ model.size());
		}
	}

	public void btnCancelar_click() {
		cambiarBoolean(true);
		cambiarEditable(false);
		labelsbuits();
		control = false;
		if (model.isEmpty()) {
			vista.getlblPanell().setText("No hi ha registres");
			cambiarBoolean(false);
			vista.getBtnDesar().setEnabled(false);
			vista.getBtnCancelar().setEnabled(false);
			vista.getBtnNou().setEnabled(true);

		} else {
			vista.getlblPanell().setText(
					" Registre " + (model.getIndex() + 1) + " de "
							+ model.size());
			mostrarDades(model.getIndex());
		}
	}

	public void btnEditar_click() {
		cambiarBoolean(false);
		cambiarEditable(true);
		control = true;

	}

	public void EscriureFitxercsv() {
		try {
			OutputStream fout = new FileOutputStream("Dades.csv");

			OutputStreamWriter out = new OutputStreamWriter(fout, "UTF8");

			for (int i = 0; i < model.size(); i++) {

				out.write(model.getLlista().get(i).getDni() + ";");
				out.write(model.getLlista().get(i).getNom() + ";");
				out.write(model.getLlista().get(i).getPrimerCognom() + ";");
				out.write(model.getLlista().get(i).getSegonCognom() + ";");
				out.write(model.getLlista().get(i).getEdat() + ";");
				out.write("\n");
			}

			out.close();

			fout.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public Llista LlegirFitxercsv(String fitxer)
			throws UnsupportedEncodingException, FileNotFoundException,
			IOException {

		Llista llista = new Llista();

		FileInputStream fis = new FileInputStream(fitxer);

		InputStreamReader isr = new InputStreamReader(fis, "UTF8");

		BufferedReader br = new BufferedReader(isr);

		String linea;
		String[] parts = null;
		while ((linea = br.readLine()) != null) {
			parts = linea.split(";");
			llista.add(new Persona(parts[0], parts[1], parts[2], parts[3],
					Integer.parseInt(parts[4])));
			model.setIndex(model.getIndex() + 1);
		}
		br.close();
		isr.close();
		fis.close();
		return llista;

	}

	public void btnDesar_click() {

		String edat = vista.getTextEdat().getText();
		int e;
		try {
			Persona p = new Persona(vista.getTextDni().getText(), vista
					.getTextNom().getText(), vista.getTextPrimerCognom()
					.getText(), vista.getTextSegonCognom().getText(),
					Integer.parseInt(vista.getTextEdat().getText()));
			e = Integer.parseInt(edat);
			if ((e > 0) && (e < 1000)) {
				if (control) {
					model.remove(model.getIndex());
					model.add(model.getIndex(), p);

					mostrarDades(model.getIndex());
					control = false;
				} else {
					if (model.isEmpty()) {
						model.add(new Persona(vista.getTextDni().getText(),
								vista.getTextNom().getText(), vista
										.getTextPrimerCognom().getText(), vista
										.getTextSegonCognom().getText(),
								Integer.parseInt(vista.getTextEdat().getText())));
						model.setIndex(0);
						vista.getlblPanell().setText(
								" Registre " + (model.getIndex() + 1) + " de "
										+ model.size());
					} else {

						model.add(new Persona(vista.getTextDni().getText(),
								vista.getTextNom().getText(), vista
										.getTextPrimerCognom().getText(), vista
										.getTextSegonCognom().getText(),
								Integer.parseInt(vista.getTextEdat().getText())));

						model.setIndex(model.getIndex() + 1);
						vista.getlblPanell().setText(
								" Registre " + (model.getIndex() + 1) + " de "
										+ model.size());
						btnSeguent_click();
					}
				}
				cambiarBoolean(true);
				cambiarEditable(false);

			} else {
				JOptionPane.showMessageDialog(null, "Edat incorrecta",
						"Error en l'edat", JOptionPane.ERROR_MESSAGE);
			}

		} catch (NumberFormatException ex) {
			JOptionPane.showMessageDialog(null, "Edat incorrecta",
					"Error en l'edat", JOptionPane.ERROR_MESSAGE);
		}
	}
}
