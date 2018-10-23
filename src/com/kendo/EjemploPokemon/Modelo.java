package com.kendo.EjemploPokemon;
import com.kendo.EjemploPokemon.base.Pokemon;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;

public class Modelo {

	private HashMap<String, Pokemon> hashMapPokemon;
	
	public Modelo() throws IOException, ClassNotFoundException {
		
		if (new File("pokemon.dat").exists())
			cargarDeDisco();
		else
			hashMapPokemon = new HashMap<String, Pokemon>();
	}
	
	public void guardar(Pokemon pokemon) throws IOException {
		
		hashMapPokemon.put(pokemon.getNombre(), pokemon);
		guardarADisco();
	}
	
	private void guardarADisco() throws IOException {
		
		ObjectOutputStream serializador = new ObjectOutputStream(
				new FileOutputStream("pokemon.dat"));
		serializador.writeObject(hashMapPokemon);
		serializador.close();
	}
	
	private void cargarDeDisco() 
			throws IOException, ClassNotFoundException {
		
		ObjectInputStream deserializador = new ObjectInputStream(
				new FileInputStream("pokemon.dat"));
		hashMapPokemon = (HashMap<String, Pokemon>) deserializador.readObject();
		deserializador.close();			
	}
	
	public void eliminar(Pokemon pokemon) {
		
	}
	
	public void eliminarTodo() {
		
	}
	
	public void modificarPokemon(String nombre, Pokemon pokemon) {
		
	}
	
	public Pokemon getPokemon(String nombre) {
		
		return null;
	}
	
	public ArrayList<Pokemon> getHashMapPokemon() {
		
		return new ArrayList<Pokemon>(hashMapPokemon.values());
	}
	
	public ArrayList<Pokemon> getPokemones(String busqueda) {
		
		return null;
	}
}
