package com.kendo.EjemploPokemon;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import javax.swing.*;

import com.kendo.EjemploPokemon.base.Pokemon;
import com.kendo.EjemploPokemon.base.Pokemon.Tipo;
import com.kendo.EjemploPokemon.ui.Vista;
import com.kendo.EjemploPokemon.util.Util;

public class Controlador implements ActionListener, MouseListener {

	private Vista vista;
	private Modelo modelo;
	private String nombreImagen;

	public File ficheroSeleccionado;
	
	public Controlador(Vista vista, Modelo modelo) {
		this.vista = vista;
		this.modelo = modelo;
		
		addListeners();
		poblarTiposPokemon();
		refrescarLista();
	}
	
	private void refrescarLista() {
		
		vista.listModelPokemon.removeAllElements();
		for (Pokemon pokemon : modelo.getHashMapPokemon()) {
			vista.listModelPokemon.addElement(pokemon);
		}
	}
	
	private void poblarTiposPokemon() {
		for (Tipo tipo : Tipo.values())
			vista.tipoBox.addItem(tipo);
	}
	
	private void addListeners() {
		
		vista.añadirPokemon.addActionListener(this);
		vista.imagenL.addMouseListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		switch (e.getActionCommand()) {
			case "anadir":
				if (vista.nombreText.getText().equals("")) {
					JOptionPane.showMessageDialog(null, 
							"El campo nombre es obligatorio", 
						 	"Error",
							JOptionPane.ERROR_MESSAGE);
					return;
				}
				
				if (vista.nivelText.getText().equals(""))
					vista.nivelText.setText("0");
				if (vista.pesoText.getText().equals(""))
					vista.pesoText.setText("0");
				
				if (!vista.nivelText.getText().matches("[0-9]*")) {
					JOptionPane.showMessageDialog(null, 
							"El nivel tiene que ser un n�mero",
							"Error", JOptionPane.ERROR_MESSAGE);
					vista.nivelText.selectAll();
					vista.nivelText.requestFocus();
					return;
				}
					
				String nombre = vista.nombreText.getText();
				Tipo tipo = (Tipo) vista.tipoBox.getSelectedItem();
				int nivel = Integer.parseInt(vista.nivelText.getText());
				float peso = Float.parseFloat(vista.pesoText.getText());

				String nombreImagen = null;
				if (ficheroSeleccionado != null)
					nombreImagen = ficheroSeleccionado.getName();
				else
					nombreImagen = "nopicture.png";
				
				Pokemon pokemon = new Pokemon();
				pokemon.setNombre(nombre);
				pokemon.setTipo(tipo);
				pokemon.setNivel(nivel);
				pokemon.setPeso(peso);
				pokemon.setImagen(nombreImagen);

				try {
					modelo.guardar(pokemon);

					try {
						Util.copiarImagen(ficheroSeleccionado.getAbsolutePath(), nombreImagen);
					} catch (IOException io) { io.printStackTrace(); }


					vista.listModelPokemon.addElement(pokemon);
				} catch (IOException ioe) {
					ioe.printStackTrace();
					JOptionPane.showMessageDialog(null, 
							"Error al guardar a disco", 
							"Error", JOptionPane.ERROR_MESSAGE);
				}
				break;
			default:
				break;
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		JFileChooser fileChooser = new JFileChooser();
		if (fileChooser.showOpenDialog(null) == JFileChooser.CANCEL_OPTION)
			return;

		ficheroSeleccionado = fileChooser.getSelectedFile();
		vista.imagenL.setIcon(
				new ImageIcon(ficheroSeleccionado.getAbsolutePath())
		);
	}

	@Override
	public void mousePressed(MouseEvent e) {

	}

	@Override
	public void mouseReleased(MouseEvent e) {

	}

	@Override
	public void mouseEntered(MouseEvent e) {

	}

	@Override
	public void mouseExited(MouseEvent e) {

	}
}
