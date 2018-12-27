package interfaz;

import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;

import controlador.Controlador;


public class InterfazApp extends JFrame {
	
	private PanelDividir pnlDividir;
	private PanelUnir pnlUnir;
	
	Controlador ctrlControlador;
	
	public InterfazApp(Controlador ctrl)
	{
		//Configuracion del Jframe
		setSize(400,500);
		setTitle("Divisor de archivos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		//Color JFrame
		this.getContentPane().setBackground(Color.GRAY.darker().darker().darker());
		
		//Icono JFrame
		Toolkit mipantalla=  Toolkit.getDefaultToolkit();
		Image MiIcono=mipantalla.getImage("src/img/1.png");//Icono
		setIconImage(MiIcono);//icono
		
		//Centar JFrame
		
		util.Util.centrarVentana(this);
		
		//Esquema de organizacion
		getContentPane( ).setLayout( null );  
		 
		//Integrar el controlador
		this.ctrlControlador = ctrl;
		  
		//Instaciar los paneles
		pnlDividir = new PanelDividir(ctrl);
		pnlUnir= new PanelUnir(ctrl);
		
		// Organizar el panel principal. 
		getContentPane( ).add( pnlDividir );
		pnlDividir.setBounds( 10, 10, 375, 235  );   //10,10,400,180 - left, top, widt, botton
	     
		getContentPane( ).add(pnlUnir);
		pnlUnir.setBounds(10,255,374,205);
		
		// Conecta objetos a controlar
		ctrlControlador.conectar(pnlDividir,pnlUnir);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InterfazApp frmMain = new InterfazApp(new Controlador());
		frmMain.setVisible(true);
	}

}
