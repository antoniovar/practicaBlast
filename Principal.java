package clasesPracticaEvaluable;



import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class Principal {
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				createAndShowGUI();
			}			
		});
	}
	private static void createAndShowGUI() {
		JFrame frame = new JFrame("BLAST");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Panel panel = new Panel();
		Accion acc = new Accion(panel);
		panel.getBRealizaConsulta().addActionListener(acc);
		frame.getContentPane().add(panel);
		frame.pack();
		frame.setVisible(true);	
	}
	
}



