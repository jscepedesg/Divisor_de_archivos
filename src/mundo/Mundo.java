package mundo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JOptionPane;


public class Mundo {

	public static int  datos[];
	private static long tam;
	private static ArrayList <Integer> tama = new ArrayList <Integer>();
	private static String extencion;
	public Mundo()
	{
		
	}
	
	public void setDividir1(String ruta)
	{
		setTipodearchivo(ruta);
		int con=0,con1=0;
			try
			{
				FileInputStream archivolectura = new FileInputStream(ruta);
				boolean final_fal = false;
				
				File fichero = new File(ruta);
				System.out.println(fichero.length()+1);
				tam= fichero.length();
				//datos = new int[ tam];
				
				for(long i=0;i<tam;i++)
				{
					int byte_entrada =archivolectura.read();
					
					
					
				}
				/*while(!final_fal)
				{
					int byte_entrada =archivolectura.read();
					
					if(byte_entrada!=-1)
					{
						datos[con]=byte_entrada;
					}
					else
					{
						final_fal=true;
					}
					con++;
					
				}*/
				
				archivolectura.close();
			}
			catch(IOException e)
			{
				System.out.println("Error al acceder al archivo");
			}
			
			System.out.println("Numero de byte "+con);
			int part = Integer.parseInt(JOptionPane.showInputDialog("Particiones"));
			if(part<=15&&part>0)
			{
				setParticion(part,ruta);
			}
			else
			{
				JOptionPane.showMessageDialog(null,"No es permitido","Atención",0);
			}
			
	}
	
	public void setDividir(String ruta)
	{
		setTipodearchivo(ruta);
		int con=0,con1=0;
			try
			{
				FileInputStream archivolectura = new FileInputStream(ruta);
				boolean final_fal = false;
				
				File fichero = new File(ruta);
				System.out.println(fichero.length()+1);
				tam= fichero.length();
				//datos = new int[ tam];
				
				for(long i=0;i<tam;i++)
				{
					int byte_entrada =archivolectura.read();
					
					if(byte_entrada!=-1)
					{
						setParticion(byte_entrada,ruta);
					}
					
					
				}
				/*while(!final_fal)
				{
					int byte_entrada =archivolectura.read();
					
					if(byte_entrada!=-1)
					{
						datos[con]=byte_entrada;
					}
					else
					{
						final_fal=true;
					}
					con++;
					
				}*/
				
				archivolectura.close();
			}
			catch(IOException e)
			{
				System.out.println("Error al acceder al archivo");
			}
			
			System.out.println("Numero de byte "+con);
			int part = Integer.parseInt(JOptionPane.showInputDialog("Particiones"));
			if(part<=15&&part>0)
			{
				setParticion(part,ruta);
			}
			else
			{
				JOptionPane.showMessageDialog(null,"No es permitido","Atención",0);
			}
			
	}

	public static void setParticion(int part,String ru)
	{
		int con1=0,con2=0;
		int particion=(int) ((tam)/part);
		particion++;
		for(int j=0;j<part;j++)
		{
			String ruta="C:/Users/Usuario/Desktop/copia"+(j+1)+"."+extencion;
			try
			{
				FileOutputStream nuevo = new FileOutputStream(ruta);
				
				for(int i=con1;i<particion+con2;i++)
				{	
					if(i<datos.length)
					{
						nuevo.write(datos[i]);
						con1++;
					}
					
				}
				con2=particion+con2;
				nuevo.close();
				System.out.println(con1);
				
			}
			catch(IOException d)
			{
				System.out.println("Error al crear el archivo");
			}
		}
		JOptionPane.showMessageDialog(null,"Se completo el procedimiento con exito","Atención",1);
		
	}
	
	public void setUnir(ArrayList a,int b)
	{
		//Iterador
		Iterator <String> mi_iterador= a.iterator();
		//Recore la array list
		for(int i =0;i<b;i++)
		{
			try
			{
				while(mi_iterador.hasNext())
				{
					FileInputStream archivolectura = new FileInputStream(mi_iterador.next());
					
					boolean final_fal = false;
					
					while(!final_fal)
					{
						int byte_entrada =archivolectura.read();
						
						if(byte_entrada!=-1)
						{
							tama.add(byte_entrada);
						}
						else
						{
							final_fal=true;
						}
						//System.out.println(datos[con]);
						//con++;
						
					}
					
					archivolectura.close();
				}
				
			}
			catch(IOException e)
			{
				System.out.println("Error al acceder a la imagen");
			}
			
			
		}
		
		setCrearFichero(tama);
	}
	
	public void setCrearFichero(ArrayList a)
	{
		try
		{
			FileOutputStream nuevo = new FileOutputStream("C:/Users/Usuario/Desktop/archivo."+extencion);
			
			for (Object object : a) 
			{
				nuevo.write((int) object);
			}
			nuevo.close();
			JOptionPane.showMessageDialog(null,"Se completo el procedimiento con exito","Atención",1);
		}
		catch(IOException d)
		{
			System.out.println("Error al crear el archivo");
		}
		
	}
	
	public void setTipodearchivo(String ruta)
	{
		File file=null;
		try
		{
			file = new File(ruta);
			System.out.println("File extension is: "+getFileExtension(file));
	        extencion=getFileExtension(file);
	        //file name without extension
	        file = new File("/Users/pankaj/temp");
	        System.out.println("File extension is: "+getFileExtension(file));
	        //file name with dot
	        file = new File("/Users/pankaj/java.util.txt");
	        System.out.println("File extension is: "+getFileExtension(file));
	        //hidden files without extension
	        file = new File("/Users/pankaj/.htaccess");
	        System.out.println("File extension is: "+getFileExtension(file));
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null,"No seleciono un archivo","Atención",0);
		}
	
        
	}
	private static String getFileExtension(File file) {
        String fileName = file.getName();
        if(fileName.lastIndexOf(".") != -1 && fileName.lastIndexOf(".") != 0)
        return fileName.substring(fileName.lastIndexOf(".")+1);
        else return "";
    }
}
