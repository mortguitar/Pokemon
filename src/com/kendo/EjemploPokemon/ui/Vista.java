package com.kendo.EjemploPokemon.ui;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.TitledBorder;

import com.kendo.EjemploPokemon.base.Pokemon;

public class Vista {

	JFrame ventana;
	public JTextField nombreText;
	public JTextField nivelText;
	public JTextField pesoText;
	public JButton añadirPokemon;
	public JComboBox<Pokemon.Tipo> tipoBox;
	public JScrollPane scrollP;
	public JList<Pokemon> listaPokemon;
	public DefaultListModel<Pokemon> listModelPokemon;
	public JLabel imagenL;

	public Vista() {
		ventana = new JFrame();
		ventana.setBounds(100, 100, 450, 300);
		ventana.getContentPane().setLayout(null);
		
		JLabel nombreL = new JLabel("Nombre*");
		nombreL.setFont(new Font("Tahoma", Font.BOLD, 11));
		nombreL.setBounds(10, 31, 57, 14);
		ventana.getContentPane().add(nombreL);
		
		JLabel tipoL = new JLabel("Tipo");
		tipoL.setBounds(10, 62, 46, 14);
		ventana.getContentPane().add(tipoL);
		
		JLabel nivelL = new JLabel("Nivel");
		nivelL.setBounds(10, 93, 46, 14);
		ventana.getContentPane().add(nivelL);
		
		JLabel pesoL = new JLabel("Peso");
		pesoL.setBounds(10, 124, 46, 14);
		ventana.getContentPane().add(pesoL);
		
		nombreText = new JTextField();
		nombreText.setBounds(66, 28, 86, 20);
		ventana.getContentPane().add(nombreText);
		nombreText.setColumns(10);
		
		nivelText = new JTextField();
		nivelText.setBounds(66, 90, 86, 20);
		ventana.getContentPane().add(nivelText);
		nivelText.setColumns(10);
		
		pesoText = new JTextField();
		pesoText.setBounds(66, 121, 86, 20);
		ventana.getContentPane().add(pesoText);
		pesoText.setColumns(10);
		
		añadirPokemon = new JButton("A\u00F1adir");
		añadirPokemon.setActionCommand("anadir");
		añadirPokemon.setBounds(63, 169, 89, 23);
		ventana.getContentPane().add(añadirPokemon);
		
		tipoBox = new JComboBox<>();
		tipoBox.setBounds(66, 59, 86, 20);
		ventana.getContentPane().add(tipoBox);
		
		scrollP = new JScrollPane();
		scrollP.setBounds(208, 31, 166, 180);
		ventana.getContentPane().add(scrollP);
		
		listaPokemon = new JList<>();
		scrollP.setViewportView(listaPokemon);
		ventana.setVisible(true);
		
		listModelPokemon = new DefaultListModel<>();
		listaPokemon.setModel(listModelPokemon);

		imagenL = new JLabel("");
		imagenL.setIcon(new ImageIcon(""));
		imagenL.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Imagen",
                TitledBorder.LEADING, TitledBorder.TOP, null, new Color(8, 4,0)));
		imagenL.setBounds(159,13,89,130);
		ventana.getContentPane().add(imagenL);
		
		ventana.setLocationRelativeTo(null);
		ventana.repaint();
	}
}
