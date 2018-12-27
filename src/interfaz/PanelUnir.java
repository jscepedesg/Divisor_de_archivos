package interfaz;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import controlador.Controlador;

public class PanelUnir extends JPanel implements ActionListener{

	private JLabel dic,rut;
	private JButton bus,div;
	private JFileChooser fc;
	private String ruta;
	private ArrayList <String>rutas;
	private int part;
	Controlador ctrl;
	
	public PanelUnir(Controlador ctrl)
	{
		setBorder(BorderFactory.createLineBorder(Color.GREEN.darker().darker().darker()));
		setBackground(new Color(198,226,255));
		setLayout( null );
		
		//Integar controlador
		this.ctrl=ctrl;
		
		dic = new JLabel("Unir Archivos");
		Font auxFont=dic.getFont();
		dic.setFont(new Font(auxFont.getFontName(), auxFont.getStyle(), 15));
		dic.setForeground(Color.GREEN.darker().darker().darker().darker());
		dic.setBounds(10, 5, 105, 25);
		add(dic);
				
		rut = new JLabel("");
		Font auxFont1=rut.getFont();
		rut.setFont(new Font(auxFont.getFontName(), auxFont.getStyle(), 15));
		rut.setForeground(Color.GREEN.darker().darker().darker().darker());
		rut.setBounds(20, 99, 300, 25);
		add(rut);
				
		//Boton Generar
		bus = new JButton("Buscar Archivos");
		bus.addActionListener(this);
		add(bus);
		bus.setBounds(115, 40, 150, 25);
		
		//Boton Generar
		div = new JButton("Unir");
		div.addActionListener(this);
		add(div);
		div.setBounds(150, 160, 80, 30);
		
		fc= new JFileChooser();
	    
		rutas = new ArrayList<String>();
		
	}

	public void actionPerformed(ActionEvent e) 
	{
		Object btnpuch = e.getSource();
		
		if(btnpuch == bus)
		{
			part = Integer.parseInt(JOptionPane.showInputDialog("¿Cuantos Archivos son?"));
			for(int i=0;i<part;i++)
			{
				fc.setCurrentDirectory(new java.io.File("C:/Users/Usuario/Desktop"));
				fc.setDialogTitle("Busca el archivo "+(i+1));
				fc.showOpenDialog(bus); 
				rutas.add(fc.getSelectedFile().getAbsolutePath());
			}
			setPinRuta("Agrego: "+part+" Archivos");
		}
		else if(btnpuch == div)
		{
			ctrl.setUnir(rutas,part);
		}
	}
	public void setPinRuta(String ruta){rut.setText(ruta);}
	
}
