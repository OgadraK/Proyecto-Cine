package Cine;

import java.io.FileOutputStream;

public class Guardar 
{
	static int 		numproy;
	static int 		Asientos_ocupados	[] 	=	{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
	static float 	Recaudacion_mensual	[] 	=	{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
	static String 	s, titulo_pelicula="";
	static byte 	ns;

	public static void Finimprimir1m(int num)
	{
		if (Ventana.sala1Open==true)
		{
			if (Ventana.mañana==true)
			{
				if(num==numproy)
				{
					for (int e=1;e<421;e++)
					{		
						if (Salas.boton_asiento_sala1[e].getName()=="asiento_ocupado")
						{	Asientos_ocupados[ns]++;	Recaudacion_mensual[ns]	=	(float) (Recaudacion_mensual[ns]	+	4.20);	}	
					}	
						s=s+Asientos_ocupados[ns]+"\t"+Recaudacion_mensual[ns];
				}
				else	{	s=s+0+"\t"+0;	}
			}
			else	{	s=s+0+"\t"+0;	}
		}
		else	{	s=s+0+"\t"+0;	}
	}
	public static void Finimprimir1t(int num)
	{
		if (Ventana.sala1Open==true)
		{
			if (Ventana.mañana==false)
			{
				if(num==numproy)
				{
					for (int e=1;e<421;e++)
					{		
						if (Salas.boton_asiento_sala1[e].getName()=="asiento_ocupado")
						{	Asientos_ocupados[ns]++;	Recaudacion_mensual[ns]	=	(float) (Recaudacion_mensual[ns]	+	5.80);	}	
					}	
						s=s+Asientos_ocupados[ns]+"\t"+Recaudacion_mensual[ns];
				}
				else	{	s=s+0+"\t"+0;	}
			}
		}
		else	{	s=s+0+"\t"+0;	}
	}

	public static void Finimprimir2m(int num)
	{
		if (Ventana.sala2Open==true)
		{
			if (Ventana.mañana==false)
			{
				if(num==numproy)
				{
					for (int e=1;e<621;e++)
					{		
						if (Salas.boton_asiento_sala2[e].getName()=="asiento_ocupado")
						{	Asientos_ocupados[ns]++;	Recaudacion_mensual[ns]	=	(float) (Recaudacion_mensual[ns]	+	5.80);	}	
					}	
						s=s+Asientos_ocupados[ns]+"\t"+Recaudacion_mensual[ns];
				}
				else	{	s=s+0+"\t"+0;	}
			}
			else	{	s=s+0+"\t"+0;	}
		}
		else	{	s=s+0+"\t"+0;	}
	}
	public static void Finimprimir2t(int num)
	{
		if (Ventana.sala2Open==true)
		{	
			if (Ventana.mañana==false)
			{
				if(num==numproy)
				{
					for (int e=1;e<621;e++)
					{		
						if (Salas.boton_asiento_sala2[e].getName()=="asiento_ocupado")
						{	Asientos_ocupados[ns]++;	Recaudacion_mensual[ns]	=	(float) (Recaudacion_mensual[ns]	+	5.80);	}	
					}	
						s=s+Asientos_ocupados[ns]+"\t"+Recaudacion_mensual[ns];
				}
				else	{	s=s+0+"\t"+0;	}
			}
			else	{	s=s+0+"\t"+0;	}
		}
		else	{	s=s+0+"\t"+0;	}
	}

	
	public static void Finimprimir3m(int num)
	{
		if (Ventana.sala3Open==true)
		{
			if (Ventana.mañana==true)
			{
				if(num==numproy)
				{
					for (int e=1;e<621;e++)
					{		
						if (Salas.boton_asiento_sala3[e].getName()=="asiento_ocupado")
						{	Asientos_ocupados[ns]++;	Recaudacion_mensual[ns]	=	(float) (Recaudacion_mensual[ns]	+	4.20);	}	
					}	
						s=s+Asientos_ocupados[ns]+"\t"+Recaudacion_mensual[ns];
				}
				else	{	s=s+0+"\t"+0;	}
			}
			else	{	s=s+0+"\t"+0;	}
		}
		else	{	s=s+0+"\t"+0;	}
	}
	public static void Finimprimir3t(int num)
	{
		if (Ventana.sala3Open==true)
		{
			if (Ventana.mañana==false)
			{
				if(num==numproy)
				{
					for (int e=1;e<621;e++)
					{		
						if (Salas.boton_asiento_sala3[e].getName()=="asiento_ocupado")
						{	Asientos_ocupados[ns]++;	Recaudacion_mensual[ns]	=	(float) (Recaudacion_mensual[ns]	+	5.80);	}	
					}	
						s=s+Asientos_ocupados[ns]+"\t"+Recaudacion_mensual[ns];
				}
				else	{	s=s+0+"\t"+0;	}
			}
			else	{	s=s+0+"\t"+0;	}
		}
		else	{	s=s+0+"\t"+0;	}
	}
	
	public static void imprimir()
	{
		FileOutputStream salida = null;
		try
		{
			salida = new FileOutputStream("Prueba.xls");
			char c='a';
			s =	"Numeros de Sala\t"+"Sesión\t"+"Título de la película\t"+"Asientos ocupados\t"+"Recaudación\n\n"	;
			
			for (byte ns=0; ns<30; ns++)
			{	
	/*SALA 1*/		if 	(ns>=0 && ns<5)		
					{	s=s+"1"+"\t"+"Mañana"+"\t";	
						if (ns%5==0)	{titulo_pelicula="Escuadrón Suicida			";	s=s+titulo_pelicula+"\t";	Finimprimir1m(0);	s=s+"\n";}
						if (ns%5==1)	{titulo_pelicula="Fast & Furious 8			";	s=s+titulo_pelicula+"\t";	Finimprimir1m(1);	s=s+"\n";}
						if (ns%5==2)	{titulo_pelicula="Logan						";	s=s+titulo_pelicula+"\t";	Finimprimir1m(2);	s=s+"\n";}			
						if (ns%5==3)	{titulo_pelicula="Star Wars: El despertar de.";	s=s+titulo_pelicula+"\t";	Finimprimir1m(3);	s=s+"\n";}
						if (ns%5==4)	{titulo_pelicula="Warcraft: La Película		";	s=s+titulo_pelicula+"\t";	Finimprimir1m(4);	s=s+"\n";}
					System.out.println(ns+" Sala 1 Mañana"); 
					s=s+"\n";	}
				if 	(ns>=5 && ns<10)		
					{	s=s+		"1"+"\t"+"Tarde "+	"\t";		
						if (ns%5==0)	{titulo_pelicula="Escuadrón Suicida			";	s=s+titulo_pelicula+"\t";	Finimprimir1t(0);	s=s+"\n";}
						if (ns%5==1)	{titulo_pelicula="Fast & Furious 8			";	s=s+titulo_pelicula+"\t";	Finimprimir1t(1);	s=s+"\n";}
						if (ns%5==2)	{titulo_pelicula="Logan						";	s=s+titulo_pelicula+"\t";	Finimprimir1t(2);	s=s+"\n";}			
						if (ns%5==3)	{titulo_pelicula="Star Wars: El despertar de.";	s=s+titulo_pelicula+"\t";	Finimprimir1t(3);	s=s+"\n";}
						if (ns%5==4)	{titulo_pelicula="Warcraft: La Película		";	s=s+titulo_pelicula+"\t";	Finimprimir1t(4);	s=s+"\n";}
					System.out.println(ns+" Sala 1 Tarde");
					s=s+"\n";}
				
				
	/*SALA 2*/		if 	(ns>=10 && ns<15)		
					{	s=s+"\n"+	"2"+"\t"+"Mañana"+	"\t";		
						if (ns%5==0)	{titulo_pelicula="Escuadrón Suicida			";	s=s+titulo_pelicula+"\t";	Finimprimir2m(0);	s=s+"\n";}
						if (ns%5==1)	{titulo_pelicula="Fast & Furious 8			";	s=s+titulo_pelicula+"\t";	Finimprimir2m(1);	s=s+"\n";}
						if (ns%5==2)	{titulo_pelicula="Logan						";	s=s+titulo_pelicula+"\t";	Finimprimir2m(2);	s=s+"\n";}			
						if (ns%5==3)	{titulo_pelicula="Star Wars: El despertar de.";	s=s+titulo_pelicula+"\t";	Finimprimir2m(3);	s=s+"\n";}
						if (ns%5==4)	{titulo_pelicula="Warcraft: La Película		";	s=s+titulo_pelicula+"\t";	Finimprimir2m(4);	s=s+"\n";}
					System.out.println(ns+" Sala 2 Mañana");
					s=s+"\n";}
				if 	(ns>=15 && ns<20)		
					{	s=s+		"2"+"\t"+"Tarde "+	"\t";		
						if (ns%5==0)	{titulo_pelicula="Escuadrón Suicida			";	s=s+titulo_pelicula+"\t";	Finimprimir2t(0);	s=s+"\n";}
						if (ns%5==1)	{titulo_pelicula="Fast & Furious 8			";	s=s+titulo_pelicula+"\t";	Finimprimir2t(1);	s=s+"\n";}
						if (ns%5==2)	{titulo_pelicula="Logan						";	s=s+titulo_pelicula+"\t";	Finimprimir2t(2);	s=s+"\n";}			
						if (ns%5==3)	{titulo_pelicula="Star Wars: El despertar de.";	s=s+titulo_pelicula+"\t";	Finimprimir2t(3);	s=s+"\n";}
						if (ns%5==4)	{titulo_pelicula="Warcraft: La Película		";	s=s+titulo_pelicula+"\t";	Finimprimir2t(4);	s=s+"\n";}
						System.out.println(ns+" Sala 2 Tarde");
						s=s+"\n";}
					
				
	/*SALA 3*/		if 	(ns>=20 && ns<25)		
					{	s=s+"\n"+	"3"+"\t"+"Mañana"+	"\t";		
						if (ns%5==0)	{titulo_pelicula="Escuadrón Suicida			";	s=s+titulo_pelicula+"\t";	Finimprimir3m(0);	s=s+"\n";}
						if (ns%5==1)	{titulo_pelicula="Fast & Furious 8			";	s=s+titulo_pelicula+"\t";	Finimprimir3m(1);	s=s+"\n";}
						if (ns%5==2)	{titulo_pelicula="Logan						";	s=s+titulo_pelicula+"\t";	Finimprimir3m(2);	s=s+"\n";}			
						if (ns%5==3)	{titulo_pelicula="Star Wars: El despertar de.";	s=s+titulo_pelicula+"\t";	Finimprimir3m(3);	s=s+"\n";}
						if (ns%5==4)	{titulo_pelicula="Warcraft: La Película		";	s=s+titulo_pelicula+"\t";	Finimprimir3m(4);	s=s+"\n";}
					System.out.println(ns+" Sala 3 Mañana");
					s=s+"\n";}
				if 	(ns>=25 && ns<30)		
					{	s=s+"3"+"\t"+"Tarde "+	"\t";		
						if (ns%5==0)	{titulo_pelicula="Escuadrón Suicida			";	s=s+titulo_pelicula+"\t";	Finimprimir3t(0);	s=s+"\n";}
						if (ns%5==1)	{titulo_pelicula="Fast & Furious 8			";	s=s+titulo_pelicula+"\t";	Finimprimir3t(1);	s=s+"\n";}
						if (ns%5==2)	{titulo_pelicula="Logan						";	s=s+titulo_pelicula+"\t";	Finimprimir3t(2);	s=s+"\n";}			
						if (ns%5==3)	{titulo_pelicula="Star Wars: El despertar de.";	s=s+titulo_pelicula+"\t";	Finimprimir3t(3);	s=s+"\n";}
						if (ns%5==4)	{titulo_pelicula="Warcraft: La Película		";	s=s+titulo_pelicula+"\t";	Finimprimir3t(4);	s=s+"\n";}
					System.out.println(ns+" Sala 3 Tarde");
					s=s+"\n";}
			}
			
		//Escribir en el xls
			for (int numchar=0;numchar<s.length();numchar++)
			{
				c=s.charAt(numchar);
				salida.write((byte) c);
			}
		}	catch (Exception e) {	System.out.println("Error en el archivo");}
	}	
}