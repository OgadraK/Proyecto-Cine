package Cine;

import java.awt.Color;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class Salas
{
//propiedades salas
	public static int 			vector_columnas_sala1	[] 	= 	{ 0, 25, 50, 75, 100, 125, 150, 175, 200, 225, 250, 275,300,325,350,375,400,425,450,475,500,525 };
	public static int 			vector_filas_sala1		[] 	= 	{ 5, 30, 55, 80, 105, 130, 155, 180, 205, 230, 255, 280, 305, 330, 355, 380, 405, 430, 455, 480 };
	
	public static int 			vector_columnas_sala2	[] 	= 	{ 0, 25, 50, 75, 100, 125, 150, 175, 200, 225, 250, 275,300,325,350,375,400,425,450,475,500,525,550,575,600,625 };
	public static int 			vector_filas_sala2		[] 	= 	{ 5, 30, 55, 80, 105, 130, 155, 180, 205, 230, 255, 280, 305, 330, 355, 380, 405, 430, 455, 480, 505,530,555,580,605};
	
	public static int 			vector_columnas_sala3	[] 	= 	{ 0, 25, 50, 75, 100, 125, 150, 175, 200, 225, 250, 275,300,325,350,375,400,425,450,475,500,525,550,575,600,625 };
	public static int 			vector_filas_sala3		[] 	= 	{ 5, 30, 55, 80, 105, 130, 155, 180, 205, 230, 255, 280, 305, 330, 355, 380, 405, 430, 455, 480, 505,530,555,580,605};

	public static JLabel 		guia_asientos,	etiqueta_personas,	etiqueta_mensajes,	etiqueta_ocupacion,	etiqueta_asientos,	fondo_sala1,	fondo_sala2, fondo_sala3,
									numeros_filas1,	numeros_filas2,	numeros_filas3,	numeros_columnas1,	numeros_columnas2,	numeros_columnas3;
	public static JLabel 		pelicula_sala1[]=new JLabel[6], 	pelicula_sala2[]=new JLabel[6], 	pelicula_sala3[]=new JLabel[6];
	
	public static JButton 		boton_asiento_sala1[]=new JButton[440],		boton_asiento_sala2[]=new JButton[650], 	boton_asiento_sala3[]=new JButton[650];
	public static JButton 		boton_confirmar,	boton_proponer,	boton_cancelar,	boton_imprimir;
	
	public static JPanel 		crear_sala,	marco_guia,	marco_asignar_asiento,	marco_ocupacion,	marco_cartel1,	marco_cartel2, marco_cartel3;
	
	public static JTextField 	introducir_personas;
	
	public static ImageIcon 	imagen_sala,	imagen_asiento,	pelicula1,	pelicula2,	pelicula3,	pelicula4,	pelicula5,	imagen_guia,	imagen_filas1,	imagen_filas2,
									imagen_filas3, imagen_columnas1,	imagen_columnas2,	imagen_columnas3;
	
	public static JComboBox 	filas,	ubicacion;
	static String[] 			num_fila					=	{"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20"};
	static String[] 			ubicacion_asiento			=	{"Izquierda","Centrado","Derecha"};

	public static JProgressBar BarradeOcupacion = new JProgressBar();

	public static double 		contador_asientos_sala1=420;
	public static double 		contador_asientos_sala2=620;
	public static double 		contador_asientos_sala3=620;
	
	public float 				operacion=0;
	
//calcular cartel aleatorio
	public static int 			cartel_sala1				=	(int)((Math.random()*5)+1);
	public static int 			cartel_sala2				=	(int)((Math.random()*5)+1);
	public static int 			cartel_sala3				=	(int)((Math.random()*5)+1);
	
	public static void Metodo_crear_sala1()
	{
	// marco creado con JPanel para recoger todos los componentes que forman los asientos
		fondo_sala1				=	new JLabel		(new ImageIcon	("Imagenes/fondo_sala.jpg"));
			fondo_sala1.setBounds					(270,30,580,615);
		
		crear_sala 				= 	new JPanel();
		crear_sala.setOpaque						(false);
	
	//crear_sala.setBorder(BorderFactory.createLineBorder(new Color(6,104,201), 5)); 
		crear_sala.setBounds						(15, 110, 550, 510);
		crear_sala.setLayout						(null);
		fondo_sala1.setLayout						(null);
		fondo_sala1.add								(crear_sala);	
	}
	
	public static void Metodo_crear_sala2()
	{
		fondo_sala2		=	new JLabel				(new ImageIcon	("Imagenes/fondo_sala2.jpg"));
		fondo_sala2.setBounds						(280,30,660,690);
		
		crear_sala 		= 	new JPanel();
		crear_sala.setOpaque(false);
	//crear_sala.setBorder(BorderFactory.createLineBorder(new Color(6,104,201), 5)); 
		crear_sala.setBounds						(5, 60, 650, 625);
		crear_sala.setLayout						(null);
		fondo_sala2.setLayout						(null);
		fondo_sala2.add								(crear_sala);
	}
	
	public static void Metodo_crear_sala3()
	{
		fondo_sala2		=	new JLabel				(new ImageIcon	("Imagenes/fondo_sala2.jpg"));
		fondo_sala2.setBounds						(280,30,660,690);
		
		crear_sala 		= 	new JPanel();
		crear_sala.setOpaque(false);
	//crear_sala.setBorder(BorderFactory.createLineBorder(new Color(6,104,201), 5)); 
		crear_sala.setBounds						(5, 60, 650, 625);
		crear_sala.setLayout						(null);
		fondo_sala2.setLayout						(null);
		fondo_sala2.add								(crear_sala);
	}
	
	public static void Metodo_guia()
	{
		marco_guia		=	new JPanel();
		marco_guia.setBounds						(10,30,260,85);
		marco_guia.setBackground					(new Color(224, 228, 231));
		marco_guia.setLayout						(null);
		
		imagen_guia		=	new ImageIcon			("Imagenes/guia_asientos.png");
		guia_asientos	=	new JLabel				(imagen_guia);
			guia_asientos.setBounds					(10,3,200,78);
		marco_guia.add								(guia_asientos);
	}
	
	public static void Metodo_asignar_asientos()
	{
		marco_asignar_asiento	=	new JPanel();
			marco_asignar_asiento.setBounds			(10,120,260,150);
			marco_asignar_asiento.setBackground		(new Color(224, 228, 231));
			marco_asignar_asiento.setLayout			(null);
		
		TitledBorder borde		=	new TitledBorder	("Proponer asientos");
		marco_asignar_asiento.setBorder					(borde);
		
		etiqueta_personas		=	new JLabel		("Introduzca el nº asientos:");
			etiqueta_personas.setBounds				(15,32,160,15);
		etiqueta_mensajes=new JLabel				("");
			etiqueta_mensajes.setBounds				(15,60,200,15);
		introducir_personas		=	new JTextField	("0");
			introducir_personas.setBounds			(180,30,35,20);
		boton_proponer			=	new JButton		("Proponer");
			boton_proponer.setBounds				(15,85,95,25);
		boton_confirmar			=	new JButton		("Confirmar");
			boton_confirmar.setBounds				(155,85,95,25);
		boton_cancelar			=	new JButton		("Cancelar");
			boton_cancelar.setBounds				(15,115,95,25);
		boton_imprimir			=	new JButton		("Imprimir");
			boton_imprimir.setBounds				(155,115,95,25);
		
		marco_asignar_asiento.add					(etiqueta_personas);
			marco_asignar_asiento.add				(introducir_personas);
			marco_asignar_asiento.add				(etiqueta_mensajes);
			marco_asignar_asiento.add				(boton_proponer);
			marco_asignar_asiento.add				(boton_confirmar);
			marco_asignar_asiento.add				(boton_cancelar);
			marco_asignar_asiento.add				(boton_imprimir);
	}	
	
	public static void Metodo_ocupacion()
	{
		marco_ocupacion				=	new JPanel();
			marco_ocupacion.setBounds					(10,275,260,35);
			marco_ocupacion.setBackground				(new Color(224, 228, 231));
			marco_ocupacion.setLayout					(null);

		etiqueta_ocupacion			=	new JLabel		("Asientos disponibles: 100.0%");
			etiqueta_ocupacion.setBounds				(15,10,205,15);
	}
	
	/*public static void Barra_Ocupacion()
	{
		int ocup=0;
		for (int e=1;e<421;e++)		{	if (Salas.boton_asiento_sala1[e].getName()=="asiento_ocupado")		{	ocup++;	}		}
		
		BarradeOcupacion.setBounds(10,314,260,35);
			BarradeOcupacion.setValue(ocup);
			BarradeOcupacion.setMinimum(0);
			BarradeOcupacion.setMaximum(420);
			BarradeOcupacion.setForeground(Color.RED);
			BarradeOcupacion.setBackground(Color.BLACK); 
			BarradeOcupacion.setOrientation(0);
	}*/
	
	public static void Metodo_carteles()
	{
		pelicula1					=	new ImageIcon	("Imagenes/carteles/Escuadron suicida.jpg"	);
		pelicula2					=	new ImageIcon	("Imagenes/carteles/FF8.jpg"				);
		pelicula3					=	new ImageIcon	("Imagenes/carteles/Logan.jpg"				);
		pelicula4					=	new ImageIcon	("Imagenes/carteles/Star wars.jpg"			);
		pelicula5					=	new ImageIcon	("Imagenes/carteles/Warcraft.jpg"			);
		
		marco_cartel1				=	new JPanel(	);
		marco_cartel2				=	new JPanel(	);
		marco_cartel3				=	new JPanel(	);
		
			marco_cartel1.setBounds						(10,355,260,330);
			marco_cartel2.setBounds						(10,355,260,330);
			marco_cartel3.setBounds						(10,355,260,330); 
		
		for (int contador=1;contador<6;contador++)
		{
			if (cartel_sala1==1)
				{	pelicula_sala1[contador]	=	new JLabel	(pelicula1);		pelicula_sala1[contador].setName		("proyectar_pelicula1");	Guardar.numproy=0;}
			else if(cartel_sala1==2)
				{	pelicula_sala1[contador]	=	new JLabel	(pelicula2);		pelicula_sala1[contador].setName		("proyectar_pelicula2");	Guardar.numproy=1;}
			else if(cartel_sala1==3)	
				{	pelicula_sala1[contador]	=	new JLabel	(pelicula3);		pelicula_sala1[contador].setName		("proyectar_pelicula3");	Guardar.numproy=2;}
			else if(cartel_sala1==4)
				{	pelicula_sala1[contador]	=	new JLabel	(pelicula4);		pelicula_sala1[contador].setName		("proyectar_pelicula4");	Guardar.numproy=3;}
			else if(cartel_sala1==5)
				{	pelicula_sala1[contador]	=	new JLabel	(pelicula5);		pelicula_sala1[contador].setName		("proyectar_pelicula5");	Guardar.numproy=4;}
				
				pelicula_sala1[contador].setBounds(0,0,260,330);
				marco_cartel1.add(pelicula_sala1[contador]);
				contador=6;
			}
		
		for (int contador=1;contador<6;contador++)
		{
			if (cartel_sala2==1)
				{	pelicula_sala2[contador]	=	new JLabel	(pelicula1);		pelicula_sala2[contador].setName		("proyectar_pelicula1");	Guardar.numproy=0;}
			else if(cartel_sala2==2)
				{	pelicula_sala2[contador]	=	new JLabel	(pelicula2);		pelicula_sala2[contador].setName		("proyectar_pelicula2");	Guardar.numproy=1;}
			else if(cartel_sala2==3)
				{	pelicula_sala2[contador]	=	new JLabel	(pelicula3);		pelicula_sala2[contador].setName		("proyectar_pelicula3");	Guardar.numproy=2;}
			else if(cartel_sala2==4)
				{	pelicula_sala2[contador]	=	new JLabel	(pelicula4);		pelicula_sala2[contador].setName		("proyectar_pelicula4");	Guardar.numproy=3;}
			else if(cartel_sala2==5)
				{	pelicula_sala2[contador]	=	new JLabel	(pelicula5);		pelicula_sala2[contador].setName		("proyectar_pelicula5");	Guardar.numproy=4;}
				
			pelicula_sala2[contador].setBounds				(0,0,260,330);
			marco_cartel2.add								(pelicula_sala2[contador]);
			contador=6;
			}
		
		for (int contador=1;contador<6;contador++)
		{
			if (cartel_sala3==1)
				{	pelicula_sala3[contador]	=	new JLabel	(pelicula1);		pelicula_sala3[contador].setName		("proyectar_pelicula1");	Guardar.numproy=0;}
			else if(cartel_sala3==2)
				{	pelicula_sala3[contador]	=	new JLabel	(pelicula2);		pelicula_sala3[contador].setName		("proyectar_pelicula2");	Guardar.numproy=1;}
			else if(cartel_sala3==3)
				{	pelicula_sala3[contador]	=	new JLabel	(pelicula3);		pelicula_sala3[contador].setName		("proyectar_pelicula3");	Guardar.numproy=2;}
			else if(cartel_sala3==4)
				{	pelicula_sala3[contador]	=	new JLabel	(pelicula4);		pelicula_sala3[contador].setName		("proyectar_pelicula4");	Guardar.numproy=3;}
			else if(cartel_sala3==5)
				{	pelicula_sala3[contador]	=	new JLabel	(pelicula5);		pelicula_sala3[contador].setName		("proyectar_pelicula5");	Guardar.numproy=4;}
			
			pelicula_sala3[contador].setBounds				(0,0,260,330);
			marco_cartel3.add								(pelicula_sala3[contador]);
			contador=6;
		}
		marco_cartel1.setLayout(null);	
		marco_cartel2.setLayout(null);
		marco_cartel3.setLayout(null);
	}
}