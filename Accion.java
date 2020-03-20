package clasesPracticaEvaluable;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.JLabel;

import blast.BlastController;

public class Accion implements ActionListener {
	private Panel pan;
	
	public Accion(Panel pan) {
		this.pan=pan;
	}

	
	public void actionPerformed(ActionEvent e) {
		String sec = "";
		try {
			sec=pan.getCbSecuenciaConsulta().getSelectedItem().toString().toUpperCase();	
		}
		catch(NullPointerException ex) {
			errorProducido("Error en secuencia");
		}
		if(sec.equals("")) {
			errorProducido("Error en secuencia");
		}
		else if(!buscada(sec)) {
			pan.getCbSecuenciaConsulta().addItem(sec);
		}
		
		String p = null;
		float porcentaje = -1;
		try {
			p=pan.getTfPorcentaje().getText();
			porcentaje = Float.parseFloat(p);			
		}
		catch(NumberFormatException exc) {
			if(p.contentEquals("")){
				errorProducido("Error en casilla porcentaje");
			}
			else {
				errorProducido("Error en formato porcentaje");
			}
		}
		if(porcentaje !=-1 & (porcentaje<0 || porcentaje>1)) {
			errorProducido("Error en rango porcentaje");
		}
		
		BlastController bCnt = new BlastController();
		String resul="";
		if(pan.getRbProteinas().isSelected()) {
			try {
				resul = bCnt.blastQuery('p', pan.getcbBaseDatos().getSelectedItem().toString(), pan.getcbindices().getSelectedItem().toString(), porcentaje, sec);
			}
			catch(Exception ex) {
				errorProducido("Error"+ ex.toString());
			}
		}
		else if(pan.getRbSecuenciaNucleotidos().isSelected()) {
			resul = "Actualmente no se puede buscar nucleótidos";
		}
		pan.getTaResultado().setText(resul);
		
	}
	private void errorProducido(String string) {
		JDialog jd = new JDialog();
		jd.add(new JLabel(string));
		jd.setSize(250,100);
		jd.setVisible(true);
	}
	private boolean buscada(String string) {
		boolean resultado = false;
		for(int i=0;i<pan.getCbSecuenciaConsulta().getItemCount();i++) {
			if(pan.getCbSecuenciaConsulta().getItemAt(i).equals(string)) {
				resultado = true;
			}
		}
		return resultado;
	}
}
