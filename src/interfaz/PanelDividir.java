package interfaz;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import controlador.Controlador;

public class PanelDividir extends JPanel implements ActionListener{
	
	private JLabel dic,rut,tam,tam_A;
	private JButton bus,div;
	private JFileChooser fc;
	private String ruta;
	Controlador ctrl;
	public PanelDividir(Controlador ctrl)
	{
		setBorder(BorderFactory.createLineBorder(Color.GREEN.darker().darker().darker()));
		setBackground(new Color(198,226,255));
		setLayout( null );
		//Integar controlador
		this.ctrl=ctrl;
		
		dic = new JLabel("Dividir Archivo");
		Font auxFont=dic.getFont();
		dic.setFont(new Font(auxFont.getFontName(), auxFont.getStyle(), 15));
		dic.setForeground(Color.GREEN.darker().darker().darker().darker());
		dic.setBounds(10, 5, 105, 25);
		add(dic);
		
		rut = new JLabel("");
		Font auxFont1=rut.getFont();
		rut.setFont(new Font(auxFont.getFontName(), auxFont.getStyle(), 15));
		rut.setForeground(Color.GREEN.darker().darker().darker().darker());
		rut.setBounds(20, 110, 300, 25);
		add(rut);
		
		//Boton Generar
		bus = new JButton("Buscar Archivo");
		bus.addActionListener(this);
		add(bus);
		bus.setBounds(115, 40, 150, 25);
		 
		//Boton Generar
		div = new JButton("Dividir");
		div.addActionListener(this);
		add(div);
		div.setBounds(150, 190, 80, 30);
		
		fc= new JFileChooser();
	}

	
	public void actionPerformed(ActionEvent e) 
	{
		Object btnpuch = e.getSource();
		
		if(btnpuch == bus)
		{
			fc.setCurrentDirectory(new java.io.File("C:/Users/Usuario/Desktop"));
			fc.setDialogTitle("Busca el archivo");
			//fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
			fc.showOpenDialog(bus);
			try
			{
				ruta=fc.getSelectedFile().getAbsolutePath();
			}
			catch(Exception t)
			{
				JOptionPane.showMessageDialog(null,"No seleciono un archivo","Atención",0);
			}
			setPinRuta(ruta);
		}
		else if(btnpuch == div)
		{
			ctrl.setDividir(ruta);
		}
		
	}
	public void setPinRuta(String ruta){rut.setText(ruta);}

}
