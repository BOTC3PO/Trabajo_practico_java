package bin;

public class Partido {
	private String equipo_1,equipo_2;
	private int goles_1,goles_2,ID,p1,p2,estado;
	
	public Partido(String equipo_1, String equipo_2, int estado, int goles_1, int goles_2, int iD) {
		this.equipo_1 = equipo_1;
		this.equipo_2 = equipo_2;
		this.estado = estado;
		this.goles_1 = goles_1;
		this.goles_2 = goles_2;
		ID = iD;
	}
	public String getEquipo_1() {
		return equipo_1;
	}
	public void setEquipo_1(String equipo_1) {
		this.equipo_1 = equipo_1;
	}
	public String getEquipo_2() {
		return equipo_2;
	}
	public void setEquipo_2(String equipo_2) {
		this.equipo_2 = equipo_2;
	}
	public int getEstado() {
		return estado;
	}
	public void setEstado(int aux2) {
		this.estado = aux2;
	}
	public int getGoles_1() {
		return goles_1;
	}
	public void setGoles_1(int goles_1) {
		this.goles_1 = goles_1;
	}
	public int getGoles_2() {
		return goles_2;
	}
	public void setGoles_2(int goles_2) {
		this.goles_2 = goles_2;
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	@Override
	public String toString() {
		return "Partido [equipo_1=" + equipo_1 + ", equipo_2=" + equipo_2 + ", estado=" + estado + ", goles_1="
				+ goles_1 + ", goles_2=" + goles_2 + ", ID=" + ID + "]";
	}
	
	
	
}
