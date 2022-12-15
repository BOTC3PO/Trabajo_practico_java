package bin;

import java.util.Arrays;
import java.util.LinkedList;

public class Equipo {
	private String Nombre;
	private int goles,puntos,grupo,id;
	// 0 - no jugado 1- ganado - 2 perdido 3- empate
	private int grupos[] = new int [3];
	private int apuesta[]= new int [7];
	private boolean clasificado;
	private LinkedList<Partido> futbol = new LinkedList<Partido>();

	public Equipo(String nombre, int goles, int[] grupos,int[] apuesta, boolean clasificado,
			LinkedList<Partido> futbol,int id) {
		Nombre = nombre;
		this.goles = goles;
		this.puntos = 0;
		this.grupos = grupos;
		this.grupo=0;
		this.apuesta=apuesta;
		this.clasificado = clasificado;
		this.futbol = futbol;
		this.id=id;
	}
	
	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getGoles() {
		return goles;
	}

	public void setGoles(int goles) {
		this.goles = goles;
	}

	public int getPuntos() {
		return puntos;
	}

	public void setPuntos(int puntos) {
		this.puntos = puntos;
	}

	public void resultado(int puntos) {
	switch (puntos) {
	case 1:
		puntos =   3;
		break;
	case 0:
		puntos = + 0;
		break;
	case 2:
		puntos =  0;
		break;
	case 3:
		puntos=  1;
		break;
	
	}	
	this.puntos=this.puntos + puntos;
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
	
	public int getGrupo() {
		return grupo;
	}

	public void setGrupo(int grupo) {
		if (grupo>=0&&grupo<=3) {
			grupo=	0;
		}
		if (grupo>=4&&grupo<=7) {
			grupo=	1;
		}
		if (grupo>=8&&grupo<=11) {
			grupo=	2;
		}
		if (grupo>=12&&grupo<=15) {
			grupo=	3;
		}
		if (grupo>=16&&grupo<=19) {
			grupo=	4;
		}
		if (grupo>=20&&grupo<=23) {
			grupo=	5;
		}
		if (grupo>=24&&grupo<=27) {
			grupo=	6;
		}
		if (grupo>=28&&grupo<=31) {
			grupo=	7;
		}
		this.grupo = grupo;
	}

	public int[] getApuesta() {
		return apuesta;
	}

	public void setApuesta(int apuesta[]) {
		this.apuesta = apuesta;
	}
	
	@Override
	public String toString() {
		return "Equipo [Nombre=" + Nombre + ", Goles=" + goles + ", grupos=" + Arrays.toString(grupos)
				+ ", Clasificado=" + clasificado + ", futbol=" + futbol + "]";
	}

}
