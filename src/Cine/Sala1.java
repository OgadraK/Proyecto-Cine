package Cine;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Sala1 extends Salas implements ActionListener 
{
	public static boolean MañanaSala1;
	
	public Sala1() 
	{
		Ventana.sala1Open=true;
		if (Ventana.mañana==true)	{MañanaSala1=true;}		else {MañanaSala1=false;}
		
		JFrame frame_sala1			= new JFrame ("Programa de gestión de salas de cine - Sala 1");
		frame_sala1.setBounds			(250, 20, 900, 715);
		frame_sala1.setIconImage		(new ImageIcon	("Imagenes/icono_sala1.png").getImage());
		frame_sala1.setContentPane		(new JLabel		(new ImageIcon("Imagenes/fondo1.jpg")));
		frame_sala1.setResizable		(false);

	// marco creado con JPanel para recoger todos los componentes que forman los asientos
		Salas.Metodo_crear_sala1();
		frame_sala1.add						(fondo_sala1);
		
	//marco guia
		Salas.Metodo_guia();
		frame_sala1.add						(marco_guia);
		
	//marco asignar asientos
		Salas.Metodo_asignar_asientos();
		boton_proponer.addActionListener	(this);
		boton_confirmar.addActionListener	(this);
		boton_cancelar.addActionListener	(this);
		boton_imprimir.addActionListener	(this);
		frame_sala1.add				(marco_asignar_asiento);
		
	//enumeracion asientos
		imagen_filas1			=	new ImageIcon	("Imagenes/enumeracion_filas1.png");
		numeros_filas1			=	new JLabel		(imagen_filas1);
			numeros_filas1.setBounds				(850,145,25,500);

		imagen_columnas1		=	new ImageIcon	("Imagenes/enumeracion_columnas1.png");
		numeros_columnas1		=	new JLabel		(imagen_columnas1);
			numeros_columnas1.setBounds				(285,650,550,25);
		
		frame_sala1.add								(numeros_filas1);
		frame_sala1.add								(numeros_columnas1);

	//marco ocupacion de la sala
		Salas.Metodo_ocupacion();
		marco_ocupacion.add							(etiqueta_ocupacion);
		frame_sala1.add								(marco_ocupacion);
	
/*	//Barra del progreso de la ocupación
		Salas.Barra_Ocupacion();
		frame_sala1.add(BarradeOcupacion);
	*/
	//marco carteles de peliculas
		Salas.Metodo_carteles();
		frame_sala1.add								(marco_cartel1);
		
	//crear asientos mediante JButton 
		int contador = 1;
		for (int fila = 0; fila < vector_filas_sala1.length; fila++) 
		{
			for (int columna = 0; columna < vector_columnas_sala1.length; columna++) 
			{
			// cargar imagenes de asientos
				imagen_asiento 					=	new ImageIcon	("Imagenes/asiento_libre.png");				
				boton_asiento_sala1[contador] 	= 	new JButton		(new ImageIcon	("Imagenes/asiento_libre.png"));
				boton_asiento_sala1[contador].setBorder				(null);
				boton_asiento_sala1[contador].setBounds				(vector_columnas_sala1[columna],vector_filas_sala1[fila], 25, 25);	
				boton_asiento_sala1[contador].setOpaque				(false);
				boton_asiento_sala1[contador].setContentAreaFilled	(false);
				boton_asiento_sala1[contador].addActionListener		(this);
				boton_asiento_sala1[contador].setName				("asiento_libre");
				
				if ((vector_columnas_sala1[columna] != 0 && vector_filas_sala1[fila] <= 230) && (vector_columnas_sala1[columna] != 525 && vector_filas_sala1[fila] <= 230)) 
					{	crear_sala.add	(boton_asiento_sala1[contador]);		contador++;		}
				
				else if (vector_columnas_sala1[columna] >= 0 && vector_filas_sala1[fila] > 230) 
					{	crear_sala.add	(boton_asiento_sala1[contador]);		contador++;		}
			}
		}
		frame_sala1.setLayout		(null);
		frame_sala1.setVisible		(true);
	}
	
	
	
	public void actionPerformed(ActionEvent e)
	{
	//ocupar asientos mediante clic
		for (int contador=1;contador<421;contador++)
		{
			if (e.getSource()==boton_asiento_sala1[contador])
			{
				if (boton_asiento_sala1[contador].getName()=="asiento_libre")
				{ 
					if (contador<421)
					{
						contador_asientos_sala1--;
						operacion	=	(int)((contador_asientos_sala1/420)*100);
						etiqueta_ocupacion.setText	("Asientos disponibles: "+operacion+"%");
					}
				//cambiar nombre de asiento a ocupado
					boton_asiento_sala1[contador].setName				("asiento_ocupado");
					boton_asiento_sala1[contador].setIcon(new ImageIcon	("Imagenes/asiento_ocupado.png"));
				}
				else if (boton_asiento_sala1[contador].getName()=="asiento_ocupado")
				{ 
					if (contador<420)
					{
						contador_asientos_sala1++;
						operacion	=	(int)((contador_asientos_sala1/420)*100);
						etiqueta_ocupacion.setText	("Asientos disponibles: "+operacion+"%");
					}
				//cambiar nombre de ocupado a libre
					boton_asiento_sala1[contador].setName				("asiento_libre");
					boton_asiento_sala1[contador].setIcon(new ImageIcon	("Imagenes/asiento_libre.png"));
				}
			}
		}
	//proponer asientos de manera aleatoria
		int numero_introducido = Integer.parseInt(introducir_personas.getText());		
		if (e.getSource()==boton_proponer)
		{
			if (numero_introducido>420 || numero_introducido<1)
				{	etiqueta_mensajes.setText("¡Valor erróneo!");	}
			else if (numero_introducido>contador_asientos_sala1)
				{	etiqueta_mensajes.setText("¡No hay suficientes asientos!");	}
			else
			{
				int contar_personas=1;
				int w=(int) (Math.random()*420);
				while (contar_personas<=numero_introducido)
				{
					if (boton_asiento_sala1[w].getName()=="asiento_libre")
					{
						boton_asiento_sala1[w].setName	("asiento_propuesto");
						boton_asiento_sala1[w].setIcon	(new ImageIcon("Imagenes/asiento_propuesto.png"));
						w++;
						contar_personas++;
					}
					else if (boton_asiento_sala1[contar_personas].getName()=="asiento_propuesto")
						{	w++; numero_introducido++;	contar_personas++;	}
				}
			}	
		}
	//confirmar asientos
		if (e.getSource()==boton_confirmar)
		{	
			if (numero_introducido>420 || numero_introducido<1)
				{	etiqueta_mensajes.setText("¡Valor erróneo!");	}
			else if (numero_introducido>contador_asientos_sala1)
				{	etiqueta_mensajes.setText("¡No hay suficientes asientos!");	}
			else
			{
				for (int rec_filas=1;rec_filas<20;rec_filas++)
				{
					for (int contador=21;contador<=40;contador++)
					{
						if (boton_asiento_sala1[contador].getName()=="asiento_propuesto")
						{
							boton_asiento_sala1[contador].setName	("asiento_ocupado");
							boton_asiento_sala1[contador].setIcon	(new ImageIcon("Imagenes/asiento_ocupado.png"));
							etiqueta_mensajes.setText				("Se han guardado "+introducir_personas.getText()+" asientos");
							if (contador<20)
							{
								contador_asientos_sala1--;
								operacion=(int)((contador_asientos_sala1/420)*100);
								etiqueta_ocupacion.setText("Asientos disponibles: "+operacion+"%");
							}
						}
					}
				}
				for (int contador=1;contador<421;contador++)
				{
					if (boton_asiento_sala1[contador].getName()=="asiento_propuesto")
					{
						boton_asiento_sala1[contador].setName	("asiento_ocupado");
						boton_asiento_sala1[contador].setIcon	(new ImageIcon("Imagenes/asiento_ocupado.png"));
						etiqueta_mensajes.setText				("Se han guardado "+introducir_personas.getText()+" asientos");
					
						if (contador<420)
						{
							contador_asientos_sala1--;
							operacion	=	(int)((contador_asientos_sala1/420)*100);
							etiqueta_ocupacion.setText("Asientos disponibles: "+operacion+"%");
						}
					}
				}
				introducir_personas.setText("0");
			}	
		}
	//cancelar seleccion
		if (e.getSource()==boton_cancelar)
		{
			for (int contador=1;contador<421;contador++)
			{
				if (boton_asiento_sala1[contador].getName()=="asiento_propuesto")
				{ 	
				//cambiar nombre de asiento a libre
					boton_asiento_sala1[contador].setName	("asiento_libre");
					boton_asiento_sala1[contador].setIcon	(new ImageIcon("Imagenes/asiento_libre.png"));
				}
				introducir_personas.setText("0");
			}
		}
	//imprimir entradas
		if (e.getSource()==boton_imprimir)
			{	Guardar.imprimir();		}
	}
	public static void Metodo_abrir_sala1()
		{	new Sala1();	}
}
