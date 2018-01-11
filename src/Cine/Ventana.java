package Cine;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Date;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.WindowConstants;

public class Ventana extends Salas implements ActionListener
{
	public static String [] sesion = {"Mañana",	"Tarde"};
	public static boolean 			mañana=true, sala1Open=false, sala2Open=false, sala3Open=false;
	private 		int 			con_izquierda=0;
	
	private final 	JFrame 			frame_ventana;
	private final 	JButton 		sala1,	sala2, sala3, 	atras,	siguiente,	boton_ayuda;
	private final 	ImageIcon 		pelicula1,	pelicula2,	pelicula3,	pelicula4,	pelicula5,	imagen_deshabilitado,	imagen_barra,	imagen_logo,	imagen_ayuda;
	private final 	JPanel 			marco_carteles, 	marco_botones_navegacion,	fondo_carteles;
	private final 	JLabel 			pelicula	[]	= new JLabel[6], capa_izquierda,		capa_derecha,	etiqueta_opciones,	etiqueta_deshabilitado,
									marco_elegir_pelicula,	logo_cine,marco_superior,	FechaLabel;
	private final 	JRadioButton 	manual,	automatico;
	public static JComboBox cb = new JComboBox(sesion);
	Date fecha = new Date();
	
	private Ventana()
	{
		frame_ventana	=	new JFrame				("Programa de gestión de las salas");
			frame_ventana.setBounds					(250, 80, 880, 610);
			frame_ventana.getContentPane().setBackground(Color.black);
			frame_ventana.setResizable	(false);
			frame_ventana.setIconImage	(new ImageIcon("Imagenes/icono.png").getImage());	
		// para finalizar la ejecucion al cerrar
			frame_ventana.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
	//JLabel para deshabilitar seleccion manual de pelicula
		imagen_deshabilitado	=	new ImageIcon	("Imagenes/deshabilitado.png");
		etiqueta_deshabilitado	=	new JLabel		(imagen_deshabilitado);
			etiqueta_deshabilitado.setBounds		(45,180,780,340);
		
		frame_ventana.add							(etiqueta_deshabilitado);
		
	//marco superior
		marco_superior			=	new JLabel();
			marco_superior.setBounds				(0,0,880,130);
			marco_superior.setBackground			(Color.white);
			marco_superior.setOpaque				(true);
			marco_superior.setLayout				(null);
		
		sala1					=	new JButton		("Sala 1");
			sala1.setBounds							(470,50,80,30);
			sala1.addActionListener					(this);
		sala2					=	new JButton		("Sala 2");
			sala2.setBounds							(585,50,80,30);
			sala2.addActionListener					(this);
		sala3					=	new JButton		("Sala 3");
			sala3.setBounds							(700,50,80,30);
			sala3.addActionListener					(this);
		
		cb 						= 	new JComboBox	(sesion);
			cb.setSelectedIndex						(0);
			cb.setBounds							(470,90,80,30);
			cb.addActionListener					(this);
		
		imagen_logo				=	new ImageIcon	("Imagenes/logo_cine.png");
		logo_cine				=	new JLabel		(imagen_logo);
			logo_cine.setBounds						(210,10,230,115);
		
		FechaLabel				=	new JLabel		("Fecha: "+fecha);
			FechaLabel.setBounds						(560,47,230,115);
		
		marco_superior.add							(sala1);
		marco_superior.add							(sala2);
		marco_superior.add							(sala3);
		marco_superior.add							(cb);
		marco_superior.add							(logo_cine);
		marco_superior.add							(FechaLabel);
		
	//marco elegir pelicula
		imagen_barra			=	new ImageIcon	("Imagenes/barra.jpg");
		marco_elegir_pelicula	=	new JLabel		(imagen_barra);
			marco_elegir_pelicula.setBounds			(0,135,880,30);
		etiqueta_opciones		=	new JLabel		("Indicar modo para sala 1: ");
			etiqueta_opciones.setBounds				(240,0,200,30);
		
		ButtonGroup manual_automatico	=	new ButtonGroup();
		automatico=new JRadioButton					("Automáticamente");
			automatico.setBounds					(390,0,140,30);
			automatico.setOpaque					(false);
			automatico.setSelected					(true);
			automatico.addActionListener			(this);
		manual					=	new JRadioButton("Manualmente");
			manual.setBounds						(520,0,150,30);
			manual.addActionListener				(this);
			manual.setOpaque						(false);
		
		manual_automatico.add						(manual);
		manual_automatico.add						(automatico);
		marco_elegir_pelicula.add					(etiqueta_opciones);
			marco_elegir_pelicula.add				(automatico);
			marco_elegir_pelicula.add				(manual);
			marco_elegir_pelicula.setLayout			(null);
		frame_ventana.add							(marco_elegir_pelicula);
		
	//marco carteles
		marco_carteles			=	new JPanel();
			marco_carteles.setBounds				(45,180,780,350);
			marco_carteles.setOpaque				(false);
			marco_carteles.setLayout				(null);
	
		fondo_carteles			=	new JPanel();
			fondo_carteles.setBounds				(0,10,1600,330);
			fondo_carteles.setOpaque				(false);
			fondo_carteles.setLayout				(null);
		
		pelicula1				=	new ImageIcon	("Imagenes/carteles/Escuadron suicida.jpg"	);
		pelicula2				=	new ImageIcon	("Imagenes/carteles/FF8.jpg"				);
		pelicula3				=	new ImageIcon	("Imagenes/carteles/Logan.jpg"				);
		pelicula4				=	new ImageIcon	("Imagenes/carteles/Star wars.jpg"			);
		pelicula5				=	new ImageIcon	("Imagenes/carteles/Warcraft.jpg"			);
		
		pelicula[1]				=	new JLabel		(pelicula1);
			pelicula[1].setBounds					(0,0,260,330);
		marco_carteles.add							(pelicula[1]);

		pelicula[2]				=	new JLabel		(pelicula2);
			pelicula[2].setBounds					(270,0,260,330);
		marco_carteles.add							(pelicula[2]);
		
		pelicula[3]				=	new JLabel		(pelicula3);
			pelicula[3].setBounds					(540,0,260,330);
		marco_carteles.add							(pelicula[3]);

		pelicula[4]				=	new JLabel		(pelicula4);
			pelicula[4].setBounds					(810,0,260,330);
		marco_carteles.add							(pelicula[4]);
		
		pelicula[5]				=	new JLabel		(pelicula5);
			pelicula[5].setBounds					(1080,0,260,330);
		marco_carteles.add							(pelicula[5]);

		ImageIcon izquierda		=	new ImageIcon	("Imagenes/izquierda.png");
		capa_izquierda			=	new JLabel		(izquierda);
			capa_izquierda.setBounds				(0,0,260,350);
		
		ImageIcon derecha		=	new ImageIcon	("Imagenes/derecha.png");
		capa_derecha			=	new JLabel		(derecha);
			capa_derecha.setBounds					(540,0,260,350);
				
		fondo_carteles.setLayout					(null);
			fondo_carteles.add						(pelicula[1]);
			fondo_carteles.add						(pelicula[2]);
			fondo_carteles.add						(pelicula[3]);
			fondo_carteles.add						(pelicula[4]);
			fondo_carteles.add						(pelicula[5]);
		
		marco_carteles.add							(capa_izquierda);
		marco_carteles.add							(capa_derecha);
		marco_carteles.add							(fondo_carteles);
		
	//panel de navegacion
		marco_botones_navegacion	=	new JPanel();
			marco_botones_navegacion.setBounds		(385,520,120,40);
			marco_botones_navegacion.setOpaque		(false);
			marco_botones_navegacion.setVisible		(false);
		
		ImageIcon boton_atras	=	new ImageIcon	("Imagenes/botones/boton_atras.png");
			atras=new JButton						(boton_atras);
			atras.setBounds							(5,5,30,30);
			atras.addActionListener					(this);
		ImageIcon boton_siguiente=	new ImageIcon	("Imagenes/botones/boton_siguiente.png");
			siguiente			=	new JButton		(boton_siguiente);
			siguiente.setBounds						(85,5,30,30);
			siguiente.addActionListener				(this);
		
		marco_botones_navegacion.add				(atras);
		marco_botones_navegacion.add				(siguiente);
		marco_botones_navegacion.setLayout			(null);
		
	//boton de ayuda
		imagen_ayuda			=	new ImageIcon	("Imagenes/icono_ayuda.png");
		boton_ayuda				=	new JButton		(imagen_ayuda);
		
	//boton_ayuda.setBorder(null);
		boton_ayuda.setContentAreaFilled			(false);
			boton_ayuda.setBounds					(840,550,30,30);
			boton_ayuda.addActionListener			(this);
		frame_ventana.add							(boton_ayuda);
		
	//añadir marcos
		frame_ventana.add							(marco_botones_navegacion);
		frame_ventana.add							(marco_superior);
		frame_ventana.add							(marco_carteles);
		
		frame_ventana.setLayout						(null);
		frame_ventana.setVisible					(true);
	}	
	
	public void actionPerformed(ActionEvent e)
	{
		if (manual.isSelected())
		{
			etiqueta_deshabilitado.setVisible		(false);
			marco_botones_navegacion.setVisible		(true);
		}
		else
		{
			etiqueta_deshabilitado.setVisible		(true);
			marco_botones_navegacion.setVisible		(false);
			cartel_sala1		=					(int)((Math.random()*5)+1);
		}
		
		if (e.getSource()==sala1)
		{
			if (manual.isSelected()==true)
			{
				if 		(con_izquierda==270)		{	cartel_sala1=1;	}
				else if (con_izquierda==0)			{	cartel_sala1=2;	}
				else if (con_izquierda==-270)		{	cartel_sala1=3;	}
				else if (con_izquierda==-540)		{	cartel_sala1=4;	}
				else if (con_izquierda==-810)		{	cartel_sala1=5;	}
			}
			Sala1.Metodo_abrir_sala1();													sala1Open=true;
		}
		
		if (e.getSource()==sala2)					{	Sala2.Metodo_abrir_sala2();		sala2Open=true;}
		
		if (e.getSource()==sala3)					{	Sala3.Metodo_abrir_sala3();		sala3Open=true;}

		if (e.getSource()==cb)						{	if (cb.getSelectedIndex()==0)	{mañana=true;}		else	{	mañana=false;	}	}

	//menu navegacion
		if (e.getSource()==atras)
		{
			if (con_izquierda<270)
				{	con_izquierda=con_izquierda+270;			fondo_carteles.setLocation(con_izquierda,10);	}
		}
		if (e.getSource()==siguiente)
		{
			if (con_izquierda>-810)
				{	con_izquierda=con_izquierda-270;			fondo_carteles.setLocation(con_izquierda,10);	}
		}
		
		
	//abrir ayuda
		if (e.getSource()==boton_ayuda)
		{
			if (Desktop.isDesktopSupported()) 
			{
			    try 						{ File myFile 	= 	new File	("Manual/manual.pdf");     		Desktop.getDesktop().open(myFile);	} 
			    catch (IOException ex)   	{	System.out.println			("Error al cargar archivo PDF");	}				
			}
		}
	}
	
	
	public static void main (String[]args)
		{	new Ventana();	}
}