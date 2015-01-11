package Main;

import java.awt.EventQueue;

import Controlador.Controlador;
import Model.Llista;
import Vista.Vista;

public class program {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Vista v =new Vista();
					Llista m = new Llista();
					m.setIndex(0);
					Controlador c = new Controlador(m,v);
					
				c.control();
				v.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
