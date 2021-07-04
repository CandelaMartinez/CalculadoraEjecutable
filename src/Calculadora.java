

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class Calculadora {

	public static void main(String[] args) {
		MarcoCalculadora mimarco= new MarcoCalculadora();
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mimarco.setVisible(true);

	}

}

//1-clase construir la interface
class MarcoCalculadora extends JFrame{
	public MarcoCalculadora() {
		
		setTitle("Calculadora");
		
		
		
		LaminaCalculadora milamina= new LaminaCalculadora();
		add(milamina);
		
		pack();
		
	}
	
}


class LaminaCalculadora extends JPanel{
	
	
	private JPanel milamina2;
	
	
	JButton pantalla;
	
	
	private boolean principio;
	
	
	
	private double resultado;
	
		private String ultimaOperacion;
	
	
	
	public LaminaCalculadora() {
	
		principio=true;
		setLayout(new BorderLayout());
		pantalla=new JButton("0");
		add (pantalla,BorderLayout.NORTH);
		pantalla.setEnabled(false);
		
		
		milamina2= new JPanel();
		
		milamina2.setLayout(new GridLayout(4,4));
		
		ActionListener insertar= new InsertaNumero();
		
		ActionListener orden =new AccionOrden();
		
	
		
		ponerBoton("7", insertar);
		ponerBoton("8", insertar);
		ponerBoton("9", insertar);
		ponerBoton("/",orden);
		
		ponerBoton("4", insertar);
		ponerBoton("5", insertar);
		ponerBoton("6", insertar);
		ponerBoton("*",orden);
		
		ponerBoton("1", insertar);
		ponerBoton("2", insertar);
		ponerBoton("3", insertar);
		ponerBoton("-",orden);
		
		ponerBoton("0", insertar);
		ponerBoton(".",orden);
		ponerBoton("=",orden);
		ponerBoton("+",orden);
		
		
		
		
		
		add(milamina2,BorderLayout.CENTER);
		
		ultimaOperacion="";
		
		
	}
	
	
	private void ponerBoton (String rotulo,ActionListener oyente) {
		JButton boton=new JButton(rotulo);
		boton.addActionListener(oyente);
		milamina2.add(boton);
	}
	
	private class InsertaNumero implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			String entrada=e.getActionCommand();
		
			if(principio) {
				pantalla.setText("");
				principio=false;
			}
			pantalla.setText(pantalla.getText()+ entrada);
			
		}
		
	}
	
	
	private class AccionOrden implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
			String operacion=e.getActionCommand();
			
			calcular(Double.parseDouble(pantalla.getText()));
			
			ultimaOperacion=operacion;
			
			
			 principio=true;
			 
			
		}
		
		public void calcular(double x) {
			if(ultimaOperacion.equals("+")) {
				resultado+=x;
			}
			
			else if (ultimaOperacion.equals("-")) {
				resultado-=x;
			}
			
			else if (ultimaOperacion.equals("*")) {
				resultado*=x;
			}
			
			else if (ultimaOperacion.equals("/")) {
				resultado/=x;
			}
			
			else if (ultimaOperacion.equals("=")) {
				resultado=x;
			}
			
			pantalla.setText(""+resultado);
			
		}
		
		
		
	}
	
	
	
}