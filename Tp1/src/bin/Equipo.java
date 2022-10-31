package bin;

import java.util.LinkedList;

public class Equipo {
	private String Nombre;
	private int Goles;
	private boolean Clasificado;
	private LinkedList<Partido> futbol = new LinkedList<Partido>();
	
	public Equipo(String nombre, int goles, boolean clasificado, LinkedList<Partido> futbol) {
		Nombre = nombre;
		Goles = goles;
		Clasificado = clasificado;
		this.futbol = futbol;
	}
	
	
	
	
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	public int getGoles() {
		return Goles;
	}
	public void setGoles(int goles) {
		Goles = goles;
	}
	public boolean isClasificado() {
		return Clasificado;
	}
	public void setClasificado(boolean clasificado) {
		Clasificado = clasificado;
	}
	public LinkedList<Partido> getFutbol() {
		return futbol;
	}
	public void setFutbol(LinkedList<Partido> futbol) {
		this.futbol = futbol;
	}
	
}
