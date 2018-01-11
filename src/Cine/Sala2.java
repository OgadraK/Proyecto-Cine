package Cine;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Sala2 extends Salas implements ActionListener
{
	public static boolean Ma�anaSala2;
	public Sala2()
	{
		Ventana.sala2Open=true;
		if (Ventana.ma�ana==true)	{Ma�anaSala2=true;}		else {Ma�anaSala2=false;}
		
		JFrame frame_sala2			=	new JFrame	("Programa de gesti�n de salas de cine - Sala 2");
		frame_sala2.setBounds			(250, 20, 995, 785);			frame_sala2.getContentPane().setBackground(Color.black);
		frame_sala2.setContentPane		(new JLabel		(new ImageIcon("Imagenes/fondo2.jpg")));
		frame_sala2.setContentPane		(new JLabel		(new ImageIcon("Imagenes/fondo2.jpg")));
		frame_sala2.setIconImage		(new ImageIcon("Imagenes/icono_sala2.png").getImage());
			
	// marco creado con JPanel para recoger todos los componentes que forman los asientos
		Salas.Metodo_crear_sala2();
		frame_sala2.add						(fondo_sala2);
		
	//marco guia
		Salas.Metodo_guia();
		frame_sala2.add						(marco_guia);
		
	//marco asignar asientos
		Salas.Metodo_asignar_asientos();
		boton_proponer.addActionListener	(this);
		boton_confirmar.addActionListener	(this);
		boton_cancelar.addActionListener	(this);
		boton_imprimir.addActionListener	(this);
		frame_sala2.add						(marco_asignar_asiento);
		
	//enumeracion asientos
		imagen_filas2			=	new ImageIcon	("Imagenes/enumeracion_filas2.png");
		numeros_filas2			=	new JLabel		(imagen_filas2);
			numeros_filas2.setBounds				(950,95,25,625);

		imagen_columnas2		=	new ImageIcon	("Imagenes/enumeracion_columnas2.png");
		numeros_columnas2		=	new JLabel		(imagen_columnas2);
			numeros_columnas2.setBounds				(285,720,650,25);
				
		frame_sala2.add								(numeros_filas2);
		frame_sala2.add								(numeros_columnas2);
		
	//marco ocupacion de la sala
		Salas.Metodo_ocupacion();
		marco_ocupacion.add							(etiqueta_ocupacion);
		frame_sala2.add								(marco_ocupacion);

/*	//Barra del progreso de la ocupaci�n
		Salas.Barra_Ocupacion();
		frame_sala2.add(BarradeOcupacion);
	*/	
				
	//marco carteles de peliculas
		Salas.Metodo_carteles();
		frame_sala2.add								(marco_cartel2);
		
	//crear asientos mediante JButton 
		int contador = 1;			
		for (int fila = 0; fila < vector_filas_sala2.length; fila++) 
		{
			for (int columna = 0; columna < vector_columnas_sala2.length; columna++) 
			{
			// cargar imagenes de asientos
				imagen_asiento 					=	new ImageIcon	("Imagenes/asiento_libre.png");
				boton_asiento_sala2[contador] 	=	new JButton		(new ImageIcon	("Imagenes/asiento_libre.png"));
				boton_asiento_sala2[contador].setBorder				(null);
				boton_asiento_sala2[contador].setBounds				(vector_columnas_sala2[columna],vector_filas_sala2[fila], 25, 25);	
				boton_asiento_sala2[contador].setOpaque				(false);
				boton_asiento_sala2[contador].setContentAreaFilled	(false);
				boton_asiento_sala2[contador].addActionListener		(this);
				boton_asiento_sala2[contador].setName				("asiento_libre");
						
				if ((vector_columnas_sala2[columna] != 0 && vector_filas_sala2[fila] <= 360) && (vector_columnas_sala2[columna] != 625 && vector_filas_sala2[fila] <= 360)) 
					{	crear_sala.add	(boton_asiento_sala2[contador]);		contador++;		}

				else if (vector_columnas_sala2[columna] >= 0 && vector_filas_sala2[fila] > 360) 
					{	crear_sala.add	(boton_asiento_sala2[contador]);		contador++;		}
			}
		}
		frame_sala2.setLayout		(null);
		frame_sala2.setVisible		(true);
	}	
	
	public void actionPerformed(ActionEvent e)
	{
	//ocupar asientos mediante clic
		for (int contador=1;contador<621;contador++)
		{
			if (e.getSource()==boton_asiento_sala2[contador])
			{
				if (boton_asiento_sala2[contador].getName()=="asiento_libre")
				{ 
					if (contador<620)
					{
						contador_asientos_sala2--;
						operacion	=	(int)((contador_asientos_sala2/620)*100);
						etiqueta_ocupacion.setText	("Asientos disponibles: "+operacion+"%");
					}
				//cambiar nombre de asiento a ocupado
					boton_asiento_sala2[contador].setName				("asiento_ocupado");
					boton_asiento_sala2[contador].setIcon(new ImageIcon	("Imagenes/asiento_ocupado.png"));
				}
				else if (boton_asiento_sala2[contador].getName()=="asiento_ocupado")
				{ 
					if (contador<621)
					{
						contador_asientos_sala2++;
						operacion	=	(int)((contador_asientos_sala1/620)*100);
						etiqueta_ocupacion.setText	("Asientos disponibles: "+operacion+"%");
					}
				//cambiar nombre de ocupado a libre
					boton_asiento_sala2[contador].setName				("asiento_libre");
					boton_asiento_sala2[contador].setIcon(new ImageIcon	("Imagenes/asiento_libre.png"));
				}
			}
		}
	//proponer asientos de manera aleatoria
		int numero_introducido = Integer.parseInt(introducir_personas.getText());	
		if (e.getSource()==boton_proponer)
		{
			if (numero_introducido>620 || numero_introducido<1)
				{	etiqueta_mensajes.setText("�Valor err�neo!");	}
			else if (numero_introducido>contador_asientos_sala2)
				{	etiqueta_mensajes.setText("�No hay suficientes asientos!");	}
			else
			{
				int contar_personas=1;
				int w=(int) (Math.random()*620);
				while (contar_personas<=numero_introducido)
				{
					if (boton_asiento_sala2[w].getName()=="asiento_libre")
					{
						boton_asiento_sala2[w].setName	("asiento_propuesto");
						boton_asiento_sala2[w].setIcon	(new ImageIcon("Imagenes/asiento_propuesto.png"));
						w++;
						contar_personas++;
					}
					else if (boton_asiento_sala2[contar_personas].getName()=="asiento_propuesto")
						{	w++;	numero_introducido++;	contar_personas++;	}
				}
			}	
		}
	//confirmar asientos
		if (e.getSource()==boton_confirmar)
		{	
			if (numero_introducido>620 || numero_introducido<1)
				{	etiqueta_mensajes.setText("�Valor err�neo!");	}
			else if (numero_introducido>contador_asientos_sala2)
				{	etiqueta_mensajes.setText("�No hay suficientes asientos!");	}
			else
			{
				for (int rec_filas=1;rec_filas<25;rec_filas++)
				{
					for (int contador=24;contador<=40;contador++)
					{
						if (boton_asiento_sala2[contador].getName()=="asiento_propuesto")
						{
							boton_asiento_sala2[contador].setName	("asiento_ocupado");
							boton_asiento_sala2[contador].setIcon	(new ImageIcon("Imagenes/asiento_ocupado.png"));
							etiqueta_mensajes.setText				("Se han guardado "+introducir_personas.getText()+" asientos");
							if (contador<20)
							{
								contador_asientos_sala2--;
								operacion=(int)((contador_asientos_sala2/620)*100);
								etiqueta_ocupacion.setText("Asientos disponibles: "+operacion+"%");
							}
						}
					}
				}
				for (int contador=1;contador<621;contador++)
				{
					if (boton_asiento_sala2[contador].getName()=="asiento_propuesto")
					{
						boton_asiento_sala2[contador].setName	("asiento_ocupado");
						boton_asiento_sala2[contador].setIcon	(new ImageIcon("Imagenes/asiento_ocupado.png"));
						etiqueta_mensajes.setText				("Se han guardado "+introducir_personas.getText()+" asientos");
						
						if (contador<620)
						{
							contador_asientos_sala2--;
							operacion	=	(int)((contador_asientos_sala2/620)*100);
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
			for (int contador=1;contador<621;contador++)
			{
				if (boton_asiento_sala2[contador].getName()=="asiento_propuesto")
				{ 	
				//cambiar nombre de asiento a libre
					boton_asiento_sala2[contador].setName	("asiento_libre");
					boton_asiento_sala2[contador].setIcon	(new ImageIcon("Imagenes/asiento_libre.png"));
				}
				introducir_personas.setText("0");
			}
		}
	//imprimir entradas
		if (e.getSource()==boton_imprimir)
			{	Guardar.imprimir();		}
	}
	public static void Metodo_abrir_sala2()
		{	new Sala2();	}
}