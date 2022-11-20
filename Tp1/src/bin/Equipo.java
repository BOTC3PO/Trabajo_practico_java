package bin;

import java.util.Arrays;
import java.util.LinkedList;

public class Equipo {
	private String Nombre;
	private int goles,pocision;
	// 0 - no jugado 1- ganado - 2 perdido 3- empate
	private int grupos[] = new int [3];
	private boolean clasificado;
	private LinkedList<Partido> futbol = new LinkedList<Partido>();


	public Equipo(String nombre, int goles, int[] grupos, boolean clasificado,
			LinkedList<Partido> futbol) {
		Nombre = nombre;
		this.goles = goles;
		this.pocision = 1;
		this.grupos = grupos;
		this.clasificado = clasificado;
		this.futbol = futbol;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}


	public int getGoles() {
		return goles;
	}

	public void setGoles(int goles) {
		this.goles = goles;
	}

	public int getPocision() {
		return pocision;
	}

	public void setPocision(int pocision) {
		this.pocision = pocision;
	}

	public boolean isClasificado() {
		return clasificado;
	}

	public void setClasificado(boolean clasificado) {
		this.clasificado = clasificado;
	}

	public LinkedList<Partido> getFutbol() {
		return futbol;
	}

	public void setFutbol(LinkedList<Partido> futbol) {
		this.futbol = futbol;
	}

	public int[] getGrupos() {
		return grupos;
	}

	public void setGrupos(int[] grupos) {
		this.grupos = grupos;
	}

	@Override
	public String toString() {
		return "Equipo [Nombre=" + Nombre + ", Goles=" + goles + ", grupos=" + Arrays.toString(grupos)
				+ ", Clasificado=" + clasificado + ", futbol=" + futbol + "]";
	}

}
