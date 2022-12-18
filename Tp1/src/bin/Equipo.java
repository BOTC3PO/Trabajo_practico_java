package bin;

import java.util.Arrays;
import java.util.LinkedList;

public class Equipo {
	private String Nombre;
	private int goles,puntos,grupo,id;
	// 0 - no jugado 1- ganado - 2 perdido 3- empate
	private int grupos[] = new int [3];
	private int apuesta,apuesta1,apuesta2,apuesta3,apuesta4,apuesta5,apuesta6;
	private boolean clasificado;
	private LinkedList<Partido> futbol = new LinkedList<Partido>();

	public Equipo(String nombre, int goles, int[] grupos, boolean clasificado,
			LinkedList<Partido> futbol,int id) {
		Nombre = nombre;
		this.goles = goles;
		this.puntos = 0;
		this.grupos = grupos;
		this.grupo=0;
		this.apuesta=0;
		this.apuesta1=0;
		this.apuesta2=0;
		this.apuesta3=0;
		this.apuesta4=0;
		this.apuesta5=0;
		this.apuesta6=0;
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

	
	
	public int getApuesta() {
		return apuesta;
	}

	public void setApuesta(int apuesta) {
		this.apuesta = apuesta;
	}

	public int getApuesta1() {
		return apuesta1;
	}

	public void setApuesta1(int apuesta1) {
		this.apuesta1 = apuesta1;
	}

	public int getApuesta2() {
		return apuesta2;
	}

	public void setApuesta2(int apuesta2) {
		this.apuesta2 = apuesta2;
	}

	public int getApuesta3() {
		return apuesta3;
	}

	public void setApuesta3(int apuesta3) {
		this.apuesta3 = apuesta3;
	}

	public int getApuesta4() {
		return apuesta4;
	}

	public void setApuesta4(int apuesta4) {
		this.apuesta4 = apuesta4;
	}

	public int getApuesta5() {
		return apuesta5;
	}

	public void setApuesta5(int apuesta5) {
		this.apuesta5 = apuesta5;
	}

	public int getApuesta6() {
		return apuesta6;
	}

	public void setApuesta6(int apuesta6) {
		this.apuesta6 = apuesta6;
	}

	
	@Override
	public String toString() {
		return "Equipo [Nombre=" + Nombre + ", Goles=" + goles + ", grupos=" + Arrays.toString(grupos)
				+ ", Clasificado=" + clasificado + ", futbol=" + futbol + "]";
	}

}
