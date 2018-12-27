package controlador;

import java.util.ArrayList;

import interfaz.PanelDividir;
import interfaz.PanelUnir;
import mundo.Mundo;

public class Controlador {
	
	private  Mundo mundo;
	private PanelDividir pnlDividir;
	private PanelUnir pnlUnir;
	
	public Controlador()
	{
		mundo= new Mundo();
	}

	public void conectar(PanelDividir pnlDividir, PanelUnir pnlUnir) 
	{
		this.pnlDividir=pnlDividir;
		this.pnlUnir=pnlUnir;
	}
	
	public void setDividir(String ruta)
	{
		
		mundo.setDividir(ruta);
	}
	
	public void setUnir(ArrayList a,int b)
	{
		mundo.setUnir(a,b);
	}
	
	
	

}
