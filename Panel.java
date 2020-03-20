package clasesPracticaEvaluable;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Panel extends JPanel {

	private static final long serialVersionUID = 1L;
	//Definimos todos los componentes que vamos a necesitar.
	private JRadioButton rbProteinas;
	private JRadioButton rbSecuenciaNucleotidos;
	private JComboBox <String> cbBaseDatos;
	private JComboBox <String> cbindices;
	private JComboBox <String> cbSecuenciaConsulta;
	private JTextField tfPorcentaje;
	private JButton bRealizaConsulta;
	private JLabel LtipoConsulta;
	private JLabel LbaseDeDatos;
	private JLabel Lindices;
	private JLabel LsecuenciaConsulta;
	private JLabel Lporcentaje;
	private JTextArea taResultado;
	private JScrollPane sp;
	
	
	// Para que quede mejor estéticamente nuestra interfaz vamos a diseñarla por paneles.
	//Definimos los paneles:
	private JPanel panelPrincipal; // Contendrá todos los paneles excepto el resultado de la búsqueda
	private JPanel panelTipoConsulta; //Contendrá tipo de consulta 
	private JPanel panelBasesDatos; // Contendrá la base de datos e indices
	private JPanel panelSyP; // Contendrá la secuencia y el porcentaje
	
	public Panel() {
		//Empezamos con el primer panel
		panelTipoConsulta = new JPanel();
		panelTipoConsulta.setLayout(new GridLayout(3,1));
		LtipoConsulta = new JLabel("Tipo de Consulta:");
		rbProteinas = new JRadioButton("Proteinas");
		rbProteinas.setSelected(true);
		rbSecuenciaNucleotidos = new JRadioButton("Secuencias de nucelótidos");
		ButtonGroup bgConsulta = new ButtonGroup(); //Se crea para que no puedan ser marcados ambos a la vez
		bgConsulta.add(rbProteinas);
		bgConsulta.add(rbSecuenciaNucleotidos);
		panelTipoConsulta.add(LtipoConsulta);
		panelTipoConsulta.add(rbProteinas);
		panelTipoConsulta.add(rbSecuenciaNucleotidos);

		
		//Segundo Panel
		panelBasesDatos = new JPanel();
		panelBasesDatos.setLayout(new GridLayout(2,2));
		LbaseDeDatos = new JLabel("Base de datos: ");
		Lindices = new JLabel("Indices: ");
		cbindices = new JComboBox <String> ();
		cbBaseDatos = new JComboBox <String> ();
		cbindices.addItem("yeast.aa.indexs");
		cbBaseDatos.addItem("yeast.aa");
		panelBasesDatos.add(LbaseDeDatos);
		panelBasesDatos.add(cbBaseDatos);
		panelBasesDatos.add(Lindices);
		panelBasesDatos.add(cbindices);
		
		//Tercer Panel
		panelSyP = new JPanel();
		panelSyP.setLayout(new GridLayout(2,2));
		LsecuenciaConsulta = new JLabel("Secuencia de consulta: ");
		Lporcentaje = new JLabel("Porcentaje: ");
		cbSecuenciaConsulta = new JComboBox <String> ();
		cbSecuenciaConsulta.setEditable(true);
		tfPorcentaje = new JTextField();
		panelSyP.add(LsecuenciaConsulta);
		panelSyP.add(cbSecuenciaConsulta);
		panelSyP.add(Lporcentaje);
		panelSyP.add(tfPorcentaje);
		
		//Ahora definimos el cuarto panel que contendrá todos los paneles anteriores además del botón de búsqueda.
		panelPrincipal = new JPanel();
		panelPrincipal.setLayout(new GridLayout(4,1));
		bRealizaConsulta = new JButton("REALIZAR BÚSQUEDA");
		panelPrincipal.add(panelTipoConsulta);
		panelPrincipal.add(panelBasesDatos);
		panelPrincipal.add(panelSyP);
		panelPrincipal.add(bRealizaConsulta);		
		
		//Ya con todos los paneles definimos ahora el cuadro en el que saldrá el resultado con su barra de scroll.
		taResultado = new JTextArea(30,60);
		taResultado.setEditable(false);
		taResultado.setBackground(Color.LIGHT_GRAY); // Lo pondremos en gris para diferenciarlo un poco del resto
		sp = new JScrollPane(taResultado);
		//Lo añadimos a la ventana propiamente dicha
		this.add(panelPrincipal);
		this.add(sp);
	}
		
		public JRadioButton getRbProteinas() {
			return rbProteinas;
		}

		public JRadioButton getRbSecuenciaNucleotidos() {
			return rbSecuenciaNucleotidos;
		}

		public JComboBox<String> getCbSecuenciaConsulta() {
			return cbSecuenciaConsulta;
		}

		public JTextField getTfPorcentaje() {
			return tfPorcentaje;
		}

		public JButton getBRealizaConsulta() {
			return bRealizaConsulta;
		}

		public JTextArea getTaResultado() {
			return taResultado;
		}
		
		public JComboBox<String> getcbBaseDatos(){
			return cbBaseDatos;
		}
		
		public JComboBox<String> getcbindices(){
			return cbindices;
		}
}
	
	
	

