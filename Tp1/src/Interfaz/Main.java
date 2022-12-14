package Interfaz;

import java.awt.Dimension;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

import bin.Equipo;
import bin.Partido;

public class Main {

	public static int Numero_de_partido = 0;
	public static boolean Efuse[] = { false, false, false, false, false, false, false };
	public static final int vatiables[] = { 0, 8, 16, 24 };
	public static String Menu[] = {};
	public static final int Fecha1[][] = { { 1, 5, 3, 7 }, { 2, 6, 4, 8 } };
	public static final int Fecha2[][] = { { 6, 1, 2, 5 }, { 8, 3, 4, 7 } };
	public static final int Fecha3[][] = { { 2, 6, 4, 8 }, { 3, 7, 1, 5 } };
	public static int eliminatoriaspos[] = { 0, 5, 8, 13, 16, 21, 24, 29, 4, 1, 12, 9, 20, 17, 28, 25 };
	public static int eliminatorias8[] = new int[16];
	public static int eliminatorias4[] = new int[8];
	public static int eliminatorias2[] = new int[4];
	public static int eliminatorias1[] = new int[2];
	public static int eliminatorias[] = new int[2];
	public static int top4[] = new int[4];
	public static LinkedList<Equipo> pociciones = new LinkedList<Equipo>();

	public static void main(String[] args) {

		LinkedList<Equipo> fixture = new LinkedList<Equipo>();
		carga(fixture);
		// pociciones = fixture;

		/*
		 * for (int i = 0; i < fixture.size(); i++) {
		 * System.out.println(fixture.get(i).getNombre()); }
		 */
		// System.out.println(fixture.get(0).getGrupos()[1]);
		// apuesta(fixture);
		menu_inicio(fixture);
		System.out.println(Numero_de_partido);
	}

	private static LinkedList<Equipo> carga(LinkedList<Equipo> fixture) {
		// hacer personal

		String[] equipos = { "qatar", "ecuador", "senegal", "paises bajos", "Inglaterra", "iran", "Estados unidos",
				"Gales", "Argentina", "Arabia Saudita", "Mexico", "Polonia", "francia", "Australia", "Dinamarca",
				"tunez", "Espa�a", "costa rica", "Alemania", "Japon", "Belgica", "Canada", "Marruecos", "Croacia",
				"Brasil", "serbia", "Suiza", "Camerun", "Portugal", "Ghana", "Uruguay", "Corea del sur" };
		int data[] = { 0, 0, 0 };
		// int data2[] = { 0, 0, 0, 0, 0, 0, 0 };
		for (int i = 0; i < equipos.length; i++) {
			Equipo equipo = new Equipo(equipos[i], 0, data, true, null, i);
			fixture.add(equipo);
			fixture.get(i).setGrupo(i);
		}
		return fixture;
	}

	private static String partido(int dato) {
		String datoi = null;
		switch (dato) {
		case 0:
			datoi = "no jugado";
			break;
		case 1:
			datoi = "gana";
			break;
		case 2:
			datoi = "pierde";
			break;
		case 3:
			datoi = "empata";
			break;
		}
		System.out.println(datoi);
		return datoi;
	}

	public static LinkedList<Equipo> mostrar_grupo(LinkedList<Equipo> fixture) {
		String grupos[] = { "grupo A", "grupo B", "grupo C", "grupo D", "grupo E", "grupo F", "grupo G", "grupo H",
				"salir" };
		String Teams[] = new String[4];
		String seleccion = grupos[0];
		boolean comprobar = true;
		int contador;
		String mensaje;
		int min = 0;
		int max = 0;
		do {
			mensaje = "";
			contador = 0;
			seleccion = (String) JOptionPane.showInputDialog(null, "seleccione 1 grupo", "seleccion de grupo",
					JOptionPane.QUESTION_MESSAGE, null, grupos, seleccion);
			switch (seleccion) {
			case "grupo A":
				min = 0;
				max = 3;
				break;
			case "grupo B":
				min = 4;
				max = 7;
				break;
			case "grupo C":
				min = 8;
				max = 11;
				break;
			case "grupo D":
				min = 12;
				max = 15;
				break;
			case "grupo E":
				min = 16;
				max = 19;
				break;
			case "grupo F":
				min = 20;
				max = 23;
				break;
			case "grupo G":
				min = 24;
				max = 27;
				break;
			case "grupo H":
				min = 28;
				max = 31;
				break;
			default:
				comprobar = false;
				break;
			}

			if (comprobar) {
				for (int i = min; i <= max; i++) {
					mensaje += fixture.get(i).getNombre();
					if (contador <= 3) {
						mensaje += "\n";

					}

					Teams[contador] = fixture.get(i).getNombre();

					contador++;
				}

				JOptionPane.showMessageDialog(null, mensaje);
				/*
				 * String opciones[] = { "siguiente", "salir" }; String datos = (String)
				 * JOptionPane.showInputDialog(null, mensaje, "seleccion equipo",
				 * JOptionPane.QUESTION_MESSAGE, null, opciones, "Seleccione"); if
				 * (datos.equalsIgnoreCase("siguiente")) { String fixture_equipo = (String)
				 * JOptionPane.showInputDialog(null, "seleccionar equipo", "seleccion equipo",
				 * JOptionPane.QUESTION_MESSAGE, null, Teams, "Seleccione"); }
				 */

			}

		} while (!seleccion.equalsIgnoreCase("salir"));
		return fixture;
	}

	public static LinkedList<Equipo> fecha1(LinkedList<Equipo> fixture) {
		for (int j = 0; j < vatiables.length; j++) {

			for (int i = 0; i < Fecha1[1].length; i++) {

				Partido partido = new Partido(fixture.get(Fecha1[0][i] - 1).getNombre(),
						fixture.get(Fecha1[1][i] - 1).getNombre(), 0, 0, 0, 0);
				int aux1[] = { (int) (Math.random() * 11), (int) (Math.random() * 11) };
				int aux2[] = { 0, 0 };
				if (aux1[0] == aux1[1]) {
					aux2[0] = 3;
					aux2[1] = 3;
				}
				if (aux1[0] > aux1[1]) {
					aux2[0] = 1;
					aux2[1] = 2;
				} else {
					aux2[0] = 2;
					aux2[1] = 1;
				}
				
				partido.setGoles_1(aux1[0]);
				partido.setGoles_2(aux1[1]);
				// System.err.println(aux1[0] + " " + aux1[1]);
				for (int k = 0; k < 2; k++) {
					// arrayauxiliar = ;
					int arrayauxiliar[] = fixture.get((vatiables[j] + Fecha1[k][i]) - 1).getGrupos();
					arrayauxiliar[0] = aux2[k];
					fixture.get(vatiables[j] + Fecha1[k][i] - 1).setGrupos(arrayauxiliar);
					fixture.get(vatiables[j] + Fecha1[k][i] - 1)
							.setGoles(fixture.get(vatiables[j] + Fecha1[k][i] - 1).getGoles() + aux1[k]);
					// LinkedList<Partido> aux4 = fixture.get(vatiables[j] + Fecha1[k][i] -
					// 1).getFutbol();
					fixture.get(vatiables[j] + Fecha1[k][i] - 1).resultado(aux2[k]);
					LinkedList<Partido> aux4 = new LinkedList<Partido>();
					partido.setEstado(aux2[k]);
					System.err.println(partido(aux2[k]) + " " + aux1[k]);
					aux4.add(partido);
					fixture.get(vatiables[j] + Fecha1[k][i] - 1).setFutbol(aux4);
					// System.out.println(arrayauxiliar[0]);
					// test(arrayauxiliar[0]);
				}

				// System.out.println(fixture.get((vatiables[j] + Fecha1[0][i]) - 1).getNombre()
				// + " "
				// + fixture.get((vatiables[j] + Fecha1[1][i]) - 1).getNombre());

				Numero_de_partido++;
			}

		}
		Efuse[0] = true;
		return fixture;
	}

	public static LinkedList<Equipo> fecha2(LinkedList<Equipo> fixture) {
		for (int j = 0; j < vatiables.length; j++) {

			for (int i = 0; i < Fecha2[1].length; i++) {
				Partido partido1 = new Partido(fixture.get(Fecha2[0][i] - 1).getNombre(),
						fixture.get(Fecha2[1][i] - 1).getNombre(), 0, 0, 0, 0);
				int aux1[] = { (int) (Math.random() * 11), (int) (Math.random() * 11) };
				int aux2[] = { 0, 0 };
				if (aux1[0] == aux1[1]) {
					aux2[0] = 3;
					aux2[1] = 3;
				}
				if (aux1[0] > aux1[1]) {
					aux2[0] = 1;
					aux2[1] = 2;
				} else {
					aux2[0] = 2;
					aux2[1] = 1;
				}
				partido1.setGoles_1(aux1[0]);
				partido1.setGoles_2(aux1[1]);
				for (int k = 0; k < 2; k++) {
					// arrayauxiliar = ;
					int arrayauxiliar[] = fixture.get((vatiables[j] + Fecha2[k][i]) - 1).getGrupos();
					arrayauxiliar[1] = aux2[k];
					fixture.get(vatiables[j] + Fecha2[k][i] - 1).setGrupos(arrayauxiliar);
					fixture.get(vatiables[j] + Fecha2[k][i] - 1).resultado(aux2[k]);
					LinkedList<Partido> aux4 = fixture.get(vatiables[j] + Fecha2[k][i] - 1).getFutbol();
					partido1.setEstado(aux2[k]);
					aux4.add(partido1);
					fixture.get(vatiables[j] + Fecha2[k][i] - 1).setFutbol(aux4);
					// System.out.println(arrayauxiliar[0]);
					// ;
					// test(arrayauxiliar[0]);
				}

				/*
				 * System.out.println(fixture.get((vatiables[j] + Fecha2[0][i]) - 1).getNombre()
				 * + "  " + fixture.get((vatiables[j] + Fecha2[1][i]) - 1).getNombre());
				 */
				Numero_de_partido++;
			}

		}
		Efuse[1] = true;
		return fixture;
	}

	public static LinkedList<Equipo> fecha3(LinkedList<Equipo> fixture) {
		for (int j = 0; j < vatiables.length; j++) {

			for (int i = 0; i < Fecha3[1].length; i++) {
				Partido partido2 = new Partido(fixture.get(Fecha3[0][i] - 1).getNombre(),
						fixture.get(Fecha3[1][i] - 1).getNombre(), 0, 0, 0, 0);

				int aux1[] = { (int) (Math.random() * 11), (int) (Math.random() * 11) };
				int aux2[] = { 0, 0 };
				if (aux1[0] == aux1[1]) {
					aux2[0] = 3;
					aux2[1] = 3;
				}
				if (aux1[0] > aux1[1]) {
					aux2[0] = 1;
					aux2[1] = 2;
				} else {
					aux2[0] = 2;
					aux2[1] = 1;
				}
				partido2.setGoles_1(aux1[0]);
				partido2.setGoles_2(aux1[1]);
				for (int k = 0; k < 2; k++) {
					// arrayauxiliar = ;
					int arrayauxiliar[] = fixture.get((vatiables[j] + Fecha3[k][i]) - 1).getGrupos();
					arrayauxiliar[2] = aux2[k];
					fixture.get(vatiables[j] + Fecha3[k][i] - 1).setGrupos(arrayauxiliar);
					fixture.get(vatiables[j] + Fecha3[k][i] - 1).resultado(aux2[k]);
					LinkedList<Partido> aux4 = fixture.get(vatiables[j] + Fecha2[k][i] - 1).getFutbol();
					partido2.setEstado(aux2[k]);
					aux4.add(partido2);
					fixture.get(vatiables[j] + Fecha3[k][i] - 1).setFutbol(aux4);
					// System.out.println(arrayauxiliar[0]);
					// ;
					// test(arrayauxiliar[0]);
				}

				/*
				 * System.out.println(fixture.get((vatiables[j] + Fecha3[0][i]) - 1).getNombre()
				 * + "  " + fixture.get((vatiables[j] + Fecha3[1][i]) - 1).getNombre());
				 */
				Numero_de_partido++;
			}

		}
		Efuse[2] = true;
		return fixture;
	}

	public static String[] crear_menu() {
		String mensaje_gen[] = { "", "", "", "" };
		String mensaje_gen2[] = { "", "", "", "", "" };
		if (Efuse[0] == false) {
			mensaje_gen[0] = "ver grupos";
			mensaje_gen[1] = "jugar fecha 1";
			mensaje_gen[2] = "apuesta";
			mensaje_gen[3] = "salir";
		} else if (Efuse[1] == false) {
			mensaje_gen[0] = "ver grupos";
			mensaje_gen[1] = "jugar fecha 2";
			mensaje_gen[2] = "apuesta";
			mensaje_gen[3] = "salir";
		} else if (Efuse[2] == false) {
			mensaje_gen[0] = "ver grupos";
			mensaje_gen[1] = "jugar fecha 3";
			mensaje_gen[2] = "apuesta";
			mensaje_gen[3] = "salir";
		} else if (Efuse[3] == false) {
			mensaje_gen2[0] = "ver grupos";
			mensaje_gen2[1] = "ver eliminarorias";
			mensaje_gen2[2] = "octavos de final";
			mensaje_gen2[3] = "apuesta";
			mensaje_gen2[4] = "salir";
		} else if (Efuse[4] == false) {
			mensaje_gen2[0] = "ver grupos";
			mensaje_gen2[1] = "ver eliminarorias";
			mensaje_gen2[2] = "cartos de final";
			mensaje_gen2[3] = "apuesta";
			mensaje_gen2[4] = "salir";
		} else if (Efuse[5] == false) {
			mensaje_gen2[0] = "ver grupos";
			mensaje_gen2[1] = "ver eliminarorias";
			mensaje_gen2[2] = "semifinal";
			mensaje_gen2[3] = "apuesta";
			mensaje_gen2[4] = "salir";
		} else if (Efuse[6] == false) {
			mensaje_gen2[0] = "ver grupos";
			mensaje_gen2[1] = "ver eliminarorias";
			mensaje_gen2[2] = "final y por el 3er puesto";
			mensaje_gen2[3] = "apuesta";
			mensaje_gen2[4] = "salir";
		} else {
			mensaje_gen[0] = "ver grupos";
			mensaje_gen[1] = "ver eliminarorias";
			mensaje_gen[2] = "apuesta";
			mensaje_gen[3] = "salir";
		}

		if (Efuse[6]) {
			return mensaje_gen;
		}

		if (Efuse[2] || Efuse[3] || Efuse[4] || Efuse[5]) {
			return mensaje_gen2;
		} else {
			return mensaje_gen;
		}

	}

	public static void menu_inicio(LinkedList<Equipo> fixture) {
		String menu_select;
		do {
			System.out.println(fixture.get(0).getApuesta());
			Menu = crear_menu();
			menu_select = Menu[JOptionPane.showOptionDialog(null, "Seleccione una opcion", "Menu principal",
					JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, Menu, Menu[0])];
			System.out.println(menu_select);

			switch (menu_select) {
			case "ver grupos":
				/* mostrar equipos */
				if (!Efuse[0]) {
					mostrar_grupo(fixture);
				} else {
					/* posiciones */
					pocicionamiento(fixture);
					mostrar_grupopos(fixture);
				}

				break;
			case "jugar fecha 1":
				/* fecha 1 */
				fecha1(fixture);
				break;
			case "jugar fecha 2":
				/* fecha 2 */
				fecha2(fixture);
				break;
			case "jugar fecha 3":
				/* fecha 3 */
				fecha3(fixture);
				break;
			case "ver eliminarorias":
				pocicionamiento(fixture);
				submenu(fixture);
				// System.out.println("boton funciona");
				// verpartido8eliminatorias(fixture);
				break;
			case "octavos de final":
				pocicionamiento(fixture);
				pocicionamiento_eliminatorias8(fixture);
				fecha4(fixture);
				break;
			case "cartos de final":
				fecha5(fixture);
				break;
			case "semifinal":
				fecha7(fixture);
				break;
			case "final y por el 3er puesto":
				fecha8(fixture);
				break;
			case "apuesta":
				if (Efuse[2]) {
					pocicionamiento(fixture);
					pocicionamiento_eliminatorias8(fixture);
				}
				apuesta(fixture);
				break;
			default:
				/* salir */
				break;
			}
		} while (!menu_select.equalsIgnoreCase("salir"));
	}

	public static LinkedList<Equipo> pocicionamiento(LinkedList<Equipo> fixture) {
		pociciones.clear();
		pociciones = (LinkedList<Equipo>) fixture.clone();
		// pociciones = (LinkedList<Equipo>) fixture.clone();
		int main_contador = 0;
		int min = 0, max = 0, contador = 0, subcontador = 0;
		int aux[][] = { { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 } };
		int listaequipos[] = new int[32];
		boolean[][] igual = new boolean[4][4];
		int puntos[] = { 0, 0, 0, 0 };
		int pocicion[] = { 0, 0, 0, 0 };
		do {
			subcontador = 0;
			switch (contador) {
			case 0:
				min = 0;
				max = 3;
				break;
			case 1:
				min = 4;
				max = 7;
				break;
			case 2:
				min = 8;
				max = 11;
				break;
			case 3:
				min = 12;
				max = 15;
				break;
			case 4:
				min = 16;
				max = 19;
				break;
			case 5:
				min = 20;
				max = 23;
				break;
			case 6:
				min = 24;
				max = 27;
				break;
			case 7:
				min = 28;
				max = 31;
				break;
			default:

				break;
			}
			// System.out.println(min +" " + max);
			if (contador != 8) {
				// System.out.println(fixture.get(min).getGrupos());
				for (int i = 0; i < puntos.length; i++) {
					puntos[i] = 0;
				}
				/*
				 * int aux1[] = fixture.get(min).getGrupos(); int aux2[] = fixture.get(min +
				 * 1).getGrupos(); int aux3[] = fixture.get(min + 2).getGrupos(); int aux4[] =
				 * fixture.get(max).getGrupos(); aux[0] = aux1; aux[1] = aux2; aux[2] = aux3;
				 * aux[3] = aux4;
				 * 
				 * for (int j = 0; j < aux.length; j++) { for (int i = 0; i < aux[j].length;
				 * i++) { //System.out.println("dato" + aux[j][i]); switch (aux[j][i]) { case 1:
				 * puntos[j] = puntos[j] + 3; break; case 0: puntos[j] = puntos[j] + 0; break;
				 * case 2: puntos[j] = puntos[j] + 0; break; case 3: puntos[j] = puntos[j] + 1;
				 * break; } }
				 * 
				 * } for (int i = 0; i < puntos.length; i++) { //System.err.println(puntos[i]);
				 * fixture.get(i).setPuntos(puntos[i]); }
				 */

				System.err.println(pocicion[2]);
				for (int z = 0; z < pocicion.length; z++) {
					listaequipos[main_contador] = pocicion[z];
					main_contador++;
					/* System.err.println(pocicion[z]); */

				}

			}

			subcontador = 0;
			contador++;

		} while (contador != 8);
		/*
		 * Collections.sort(fixture, new Comparator<Equipo>() {
		 * 
		 * @Override public int compare(Equipo a, Equipo b) { int resultado =
		 * (a.getGrupo() + "").compareTo(b.getGrupo() + ""); return resultado; } });
		 */
		Collections.sort(pociciones, new Comparator<Equipo>() {
			@Override
			public int compare(Equipo a, Equipo b) {
				int resultado;
				if (a.getGrupo() == b.getGrupo()) {
					if (a.getPuntos() > b.getPuntos()) {
						resultado = -1;
					} else if (a.getPuntos() == b.getPuntos()) {
						if (a.getGoles() > b.getGoles()) {
							resultado = -1;
						} else {
							resultado = 0;
						}
					} else {
						resultado = 0;
					}
				} else {
					resultado = 0;
				}
				return resultado;
			}
		});

		for (int i = 0; i < fixture.size(); i++) {
			System.out.println(pociciones.get(i).getNombre() + " " + pociciones.get(i).getPuntos());
		}

		// JOptionPane.showMessageDialog(null, "salida correcta" + contador);
		for (int i = 0; i <= 31; i++) {
			// System.out.println(pociciones.get(i));
			// pociciones.add(i, fixture.get(listaequipos[i]));
		}

		for (int i = 0; i < 32; i++) {
			// System.out.println(i + pociciones.get(i).getNombre());
			// System.out.println(i+ fixture.get(i).getNombre());
			// System.out.println(listaequipos[i]);
		}

		return fixture;

	}

	public static LinkedList<Equipo> mostrar_grupopos(LinkedList<Equipo> fixture) {
		String grupos[] = { "grupo A", "grupo B", "grupo C", "grupo D", "grupo E", "grupo F", "grupo G", "grupo H",
				"salir" };
		String Teams[] = new String[4];
		String seleccion = grupos[0];
		boolean comprobar = true;
		int contador;
		String mensaje;
		int min = 0;
		int max = 0;
		do {
			mensaje = "";
			contador = 0;
			seleccion = (String) JOptionPane.showInputDialog(null, "seleccione 1 grupo", "seleccion de grupo",
					JOptionPane.QUESTION_MESSAGE, null, grupos, seleccion);
			switch (seleccion) {
			case "grupo A":
				min = 0;
				max = 3;
				break;
			case "grupo B":
				min = 4;
				max = 7;
				break;
			case "grupo C":
				min = 8;
				max = 11;
				break;
			case "grupo D":
				min = 12;
				max = 15;
				break;
			case "grupo E":
				min = 16;
				max = 19;
				break;
			case "grupo F":
				min = 20;
				max = 23;
				break;
			case "grupo G":
				min = 24;
				max = 27;
				break;
			case "grupo H":
				min = 28;
				max = 31;
				break;
			default:
				comprobar = false;
				break;
			}

			if (comprobar) {
				mensaje += "Pais     Puntos     Goles\n";
				for (int i = min; i <= max; i++) {
					mensaje += pociciones.get(i).getNombre();
					mensaje += "      ";
					mensaje += pociciones.get(i).getPuntos();
					mensaje += "      ";
					mensaje += pociciones.get(i).getGoles();
					if (contador <= 3) {
						mensaje += "\n";

					}

					Teams[contador] = pociciones.get(i).getNombre();

					contador++;
				}
				// String opciones[] = { "salir" };
				JOptionPane.showMessageDialog(null, mensaje, seleccion, 1);

			}

		} while (!seleccion.equalsIgnoreCase("salir"));
		return fixture;
	}

	public static LinkedList<Equipo> pocicionamiento_eliminatorias8(LinkedList<Equipo> fixture) {
		if (!Efuse[3]) {
			for (int i = 0; i < eliminatoriaspos.length; i++) {
				eliminatorias8[i] = pociciones.get(eliminatoriaspos[i]).getId();
				System.out.println(eliminatorias8[i]);
			}
		}

		return fixture;
	}

	public static LinkedList<Equipo> submenu(LinkedList<Equipo> fixture) {
		int auxiliar = 0;
		System.out.println("eliminatorias funciona");
		String respuestas_elim[] = { "octavos de final", "cuartos de final", "semifinal", "final" };
		if (Efuse[2]) {
			auxiliar = 1;
		}
		if (Efuse[3]) {
			auxiliar = 2;
		}
		if (Efuse[4]) {
			auxiliar = 3;
		}
		if (Efuse[5]) {
			auxiliar = 4;
		}

		String submenu[] = new String[auxiliar];
		for (int i = 0; i < auxiliar; i++) {
			submenu[i] = respuestas_elim[i];
		}

		String partidoelim = null;
		partidoelim = (String) JOptionPane.showInputDialog(null, "seleccione un equipo", "seleccion equipo",
				JOptionPane.QUESTION_MESSAGE, null, submenu, "Seleccione");

		switch (partidoelim) {
		case "octavos de final":
			pocicionamiento_eliminatorias8(fixture);
			pocicionamiento_eliminatorias8p(fixture);
			break;
		case "cuartos de final":
			pocicionamiento_eliminatorias4(fixture);
			break;
		case "semifinal":
			pocicionamiento_eliminatorias2(fixture);
			break;
		case "final":
			pocicionamiento_eliminatorias(fixture);
			break;
		}
		return fixture;
	}

	public static LinkedList<Equipo> pocicionamiento_eliminatorias8p(LinkedList<Equipo> fixture) {

		String mensajes = "";
		if (!Efuse[3]) {
			for (int i = 7; i >= 0; i--) {
				mensajes += fixture.get(eliminatorias8[i * 2]).getNombre() + " vs "
						+ fixture.get(eliminatorias8[(i * 2) + 1]).getNombre();
				mensajes += "\n";
			}
		} else {
			for (int i = 7; i >= 0; i--) {
				mensajes += fixture.get(eliminatorias8[i * 2]).getNombre() + " "
						+ fixture.get(eliminatorias8[i * 2]).getFutbol().get(3).getGoles_1() + " vs " + " "
						+ fixture.get(eliminatorias8[i * 2]).getFutbol().get(3).getGoles_2() + " "
						+ fixture.get(eliminatorias8[(i * 2) + 1]).getNombre();
				mensajes += "\n";
			}
		}

		JOptionPane.showMessageDialog(null, mensajes);

		return fixture;
	}

	public static LinkedList<Equipo> pocicionamiento_eliminatorias4(LinkedList<Equipo> fixture) {
		String mensajes = "";
		if (!Efuse[4]) {
			for (int i = 3; i >= 0; i--) {
				mensajes += fixture.get(eliminatorias4[i * 2]).getNombre() + " vs "
						+ fixture.get(eliminatorias4[(i * 2) + 1]).getNombre();
				mensajes += "\n";
			}
		} else {
			for (int i = 3; i >= 0; i--) {
				mensajes += fixture.get(eliminatorias4[i * 2]).getNombre() + " "
						+ fixture.get(eliminatorias4[i * 2]).getFutbol().get(3).getGoles_1() + " vs " + " "
						+ fixture.get(eliminatorias4[i * 2]).getFutbol().get(3).getGoles_2() + " "
						+ fixture.get(eliminatorias4[(i * 2) + 1]).getNombre();
				mensajes += "\n";
			}
		}

		JOptionPane.showMessageDialog(null, mensajes);
		return fixture;
	}

	public static LinkedList<Equipo> pocicionamiento_eliminatorias2(LinkedList<Equipo> fixture) {
		String mensajes = "";
		if (!Efuse[5]) {
			for (int i = 1; i >= 0; i--) {
				mensajes += fixture.get(eliminatorias2[i * 2]).getNombre() + " vs "
						+ fixture.get(eliminatorias2[(i * 2) + 1]).getNombre();
				mensajes += "\n";
			}
		} else {
			for (int i = 1; i >= 0; i--) {
				mensajes += fixture.get(eliminatorias2[i * 2]).getNombre() + " "
						+ fixture.get(eliminatorias2[i * 2]).getFutbol().get(3).getGoles_1() + " vs " + " "
						+ fixture.get(eliminatorias2[i * 2]).getFutbol().get(3).getGoles_2() + " "
						+ fixture.get(eliminatorias2[(i * 2) + 1]).getNombre();
				mensajes += "\n";
			}
		}

		JOptionPane.showMessageDialog(null, mensajes);
		return fixture;
	}

	public static LinkedList<Equipo> pocicionamiento_eliminatorias(LinkedList<Equipo> fixture) {
		String mensajes = "";

		if (!Efuse[6]) {
			mensajes += "final\n";
			mensajes += fixture.get(eliminatorias1[0]).getNombre() + " vs "
					+ fixture.get(eliminatorias1[1]).getNombre();
			mensajes += "\ntercer puesto\n";
			mensajes += fixture.get(eliminatorias[0]).getNombre() + " vs " + fixture.get(eliminatorias[1]).getNombre();
			mensajes += "\n";

		} else {
			mensajes += "final\n";
			mensajes += fixture.get(eliminatorias1[0]).getNombre() + " "
					+ fixture.get(eliminatorias1[0]).getFutbol().get(3).getGoles_1() + " vs " + " "
					+ fixture.get(eliminatorias1[1]).getFutbol().get(3).getGoles_2()
					+ fixture.get(eliminatorias1[1]).getNombre();
			mensajes += "\ntercer puesto \n";
			mensajes += fixture.get(eliminatorias[0]).getNombre() + " "
					+ fixture.get(eliminatorias[0]).getFutbol().get(3).getGoles_1() + " vs " + " "
					+ fixture.get(eliminatorias[1]).getFutbol().get(3).getGoles_2()
					+ fixture.get(eliminatorias[1]).getNombre();
			mensajes += "\n";

		}

		JOptionPane.showMessageDialog(null, mensajes);
		return fixture;
	}

	public static LinkedList<Equipo> fecha4(LinkedList<Equipo> fixture) {
		for (int j = 0; j < vatiables.length; j++) {

			for (int i = 0; i < 8; i++) {
				Partido partido3 = new Partido(fixture.get(eliminatorias8[i * 2]).getNombre(),
						fixture.get(eliminatorias8[(i * 2) + 1]).getNombre(), 0, 0, 0, 0);
				int aux1[] = { (int) (Math.random() * 11), (int) (Math.random() * 11) };
				int aux2[] = { 0, 0 };
				if (aux1[0] == aux1[1]) {
					aux2[0] = 3;
					aux2[1] = 3;
				}
				if (aux1[0] > aux1[1]) {
					aux2[0] = 1;
					eliminatorias4[i] = fixture.get(eliminatorias8[i * 2]).getId();
					aux2[1] = 2;
				} else {
					aux2[0] = 2;
					eliminatorias4[i] = fixture.get(eliminatorias8[(i * 2) + 1]).getId();
					aux2[1] = 1;
				}
				partido3.setGoles_1(aux1[0]);
				partido3.setGoles_2(aux1[1]);

				// arrayauxiliar = ;
				LinkedList<Partido> aux4 = fixture.get(eliminatorias8[i * 2]).getFutbol();
				LinkedList<Partido> aux5 = fixture.get(eliminatorias8[(i * 2) + 1]).getFutbol();
				partido3.setEstado(aux2[0]);
				aux4.add(partido3);
				partido3.setEstado(aux2[1]);
				aux5.add(partido3);
				fixture.get(eliminatorias8[i * 2]).setFutbol(aux4);
				fixture.get(eliminatorias8[(i * 2) + 1]).setFutbol(aux5);
				// System.out.println(arrayauxiliar[0]);
				// ;
				// test(arrayauxiliar[0]);

				/*
				 * System.out.println(fixture.get((vatiables[j] + Fecha3[0][i]) - 1).getNombre()
				 * + "  " + fixture.get((vatiables[j] + Fecha3[1][i]) - 1).getNombre());
				 */
				Numero_de_partido++;
			}

		}
		Efuse[3] = true;
		return fixture;
	}

	public static LinkedList<Equipo> fecha5(LinkedList<Equipo> fixture) {
		for (int j = 0; j < vatiables.length; j++) {

			for (int i = 0; i < 4; i++) {
				Partido partido4 = new Partido(fixture.get(eliminatorias4[i * 2]).getNombre(),
						fixture.get(eliminatorias4[i * 2] + 1).getNombre(), 0, 0, 0, 0);
				int aux1[] = { (int) (Math.random() * 11), (int) (Math.random() * 11) };
				int aux2[] = { 0, 0 };
				if (aux1[0] == aux1[1]) {
					aux2[0] = 3;
					aux2[1] = 3;
				}
				if (aux1[0] > aux1[1]) {
					aux2[0] = 1;
					eliminatorias2[i] = fixture.get(eliminatorias4[i * 2]).getId();
					aux2[1] = 2;
				} else {
					aux2[0] = 2;
					eliminatorias2[i] = fixture.get(eliminatorias4[(i * 2) + 1]).getId();
					aux2[1] = 1;
				}
				partido4.setGoles_1(aux1[0]);
				partido4.setGoles_2(aux1[1]);

				// arrayauxiliar = ;
				LinkedList<Partido> aux4 = fixture.get(eliminatorias4[i * 2]).getFutbol();
				LinkedList<Partido> aux5 = fixture.get(eliminatorias4[(i * 2) + 1]).getFutbol();
				partido4.setEstado(aux2[0]);
				aux4.add(partido4);
				partido4.setEstado(aux2[1]);
				aux5.add(partido4);
				fixture.get(eliminatorias4[i * 2]).setFutbol(aux4);
				fixture.get(eliminatorias4[(i * 2) + 1]).setFutbol(aux5);
				// System.out.println(arrayauxiliar[0]);
				// ;
				// test(arrayauxiliar[0]);

				/*
				 * System.out.println(fixture.get((vatiables[j] + Fecha3[0][i]) - 1).getNombre()
				 * + "  " + fixture.get((vatiables[j] + Fecha3[1][i]) - 1).getNombre());
				 */
				Numero_de_partido++;
			}

		}
		Efuse[4] = true;
		return fixture;
	}

	/*
	 * public static LinkedList<Equipo> fecha6(LinkedList<Equipo> fixture) { for
	 * (int j = 0; j < vatiables.length; j++) {
	 * 
	 * for (int i = 0; i < 2; i++) { Partido partido4 = new
	 * Partido(fixture.get(eliminatorias4[i * 2]).getNombre(),
	 * fixture.get(eliminatorias4[(i * 2)+ 1] ).getNombre(), null, 0, 0, 0); int
	 * aux1[] = { (int) (Math.random() * 11), (int) (Math.random() * 11) }; int
	 * aux2[] = { 0, 0 }; if (aux1[0] == aux1[1]) { aux2[0] = 3; aux2[1] = 3; } if
	 * (aux1[0] > aux1[1]) { aux2[0] = 1; eliminatorias2[i] =
	 * fixture.get(eliminatorias4[i * 2]).getId(); aux2[1] = 2; } else { aux2[0] =
	 * 2; eliminatorias2[i] = fixture.get(eliminatorias4[(i * 2) + 1]).getId();
	 * aux2[1] = 1; } partido4.setGoles_1(aux1[0]); partido4.setGoles_2(aux1[1]);
	 * 
	 * // arrayauxiliar = ; LinkedList<Partido> aux4 = fixture.get(eliminatorias4[i
	 * * 2]).getFutbol(); LinkedList<Partido> aux5 = fixture.get(eliminatorias4[(i *
	 * 2) + 1]).getFutbol(); aux4.add(partido4); aux5.add(partido4);
	 * fixture.get(eliminatorias4[i * 2]).setFutbol(aux4);
	 * fixture.get(eliminatorias4[(i * 2)+ 1] ).setFutbol(aux5); //
	 * System.out.println(arrayauxiliar[0]); // ; // test(arrayauxiliar[0]);
	 * 
	 * /* System.out.println(fixture.get((vatiables[j] + Fecha3[0][i]) -
	 * 1).getNombre() + "  " + fixture.get((vatiables[j] + Fecha3[1][i]) -
	 * 1).getNombre());
	 */
	/*
	 * Numero_de_partido++; }
	 * 
	 * } Efuse[5] = true; return fixture; }
	 */
	public static LinkedList<Equipo> fecha7(LinkedList<Equipo> fixture) {

		for (int i = 0; i <= 1; i++) {
			Partido partido4 = new Partido(fixture.get(eliminatorias2[i * 2]).getNombre(),
					fixture.get(eliminatorias2[i * 2] + 1).getNombre(), 0, 0, 0, 0);
			int aux1[] = { (int) (Math.random() * 11), (int) (Math.random() * 11) };
			int aux2[] = { 0, 0 };
			if (aux1[0] == aux1[1]) {
				aux2[0] = 3;
				aux2[1] = 3;
			}
			if (aux1[0] > aux1[1]) {
				aux2[0] = 1;
				aux2[1] = 2;
				if (i == 0) {
					eliminatorias1[0] = fixture.get(eliminatorias2[i * 2]).getId();
					eliminatorias[0] = fixture.get(eliminatorias2[(i * 2) + 1]).getId();
				} else {
					eliminatorias1[1] = fixture.get(eliminatorias2[i * 2]).getId();
					eliminatorias[1] = fixture.get(eliminatorias2[(i * 2) + 1]).getId();
				}

			} else {
				aux2[0] = 2;
				aux2[1] = 1;

				if (i == 0) {
					eliminatorias1[0] = fixture.get(eliminatorias2[(i * 2) + 1]).getId();
					eliminatorias[0] = fixture.get(eliminatorias2[i * 2]).getId();
				} else {
					eliminatorias1[1] = fixture.get(eliminatorias2[(i * 2) + 1]).getId();
					eliminatorias[1] = fixture.get(eliminatorias2[i * 2]).getId();
				}

			}
			System.out.println(eliminatorias1[1]);
			partido4.setGoles_1(aux1[0]);
			partido4.setGoles_2(aux1[1]);

			// arrayauxiliar = ;
			LinkedList<Partido> aux4 = fixture.get(eliminatorias2[i * 2]).getFutbol();
			LinkedList<Partido> aux5 = fixture.get(eliminatorias2[(i * 2) + 1]).getFutbol();
			partido4.setEstado(aux2[0]);
			aux4.add(partido4);
			partido4.setEstado(aux2[1]);
			aux5.add(partido4);
			fixture.get(eliminatorias2[i * 2]).setFutbol(aux4);
			fixture.get(eliminatorias2[(i * 2) + 1]).setFutbol(aux5);
			// System.out.println(arrayauxiliar[0]);
			// ;
			// test(arrayauxiliar[0]);

			/*
			 * System.out.println(fixture.get((vatiables[j] + Fecha3[0][i]) - 1).getNombre()
			 * + "  " + fixture.get((vatiables[j] + Fecha3[1][i]) - 1).getNombre());
			 */
			Numero_de_partido++;
		}

		Efuse[5] = true;
		return fixture;
	}

	public static void fecha8(LinkedList<Equipo> fixture) {

		for (int i = 0; i < 1; i++) {
			Partido partido4 = new Partido(fixture.get(eliminatorias1[i * 2]).getNombre(),
					fixture.get(eliminatorias1[i * 2] + 1).getNombre(), 0, 0, 0, 0);
			int aux1[] = { (int) (Math.random() * 11), (int) (Math.random() * 11) };
			int aux2[] = { 0, 0 };
			if (aux1[0] == aux1[1]) {
				aux2[0] = 3;
				aux2[1] = 3;
				if (Math.random() * 2 == 1) {
					top4[0] = fixture.get(eliminatorias1[i * 2]).getId();
					top4[1] = fixture.get(eliminatorias1[(i * 2) + 1]).getId();
				} else {
					top4[1] = fixture.get(eliminatorias1[i * 2]).getId();
					top4[0] = fixture.get(eliminatorias1[(i * 2) + 1]).getId();
				}
			}
			if (aux1[0] > aux1[1]) {
				aux2[0] = 1;
				top4[i] = fixture.get(eliminatorias1[i * 2]).getId();
				aux2[1] = 2;
				top4[i] = fixture.get(eliminatorias1[(i * 2) + 1]).getId();
			} else {
				aux2[0] = 2;
				top4[i] = fixture.get(eliminatorias1[(i * 2) + 1]).getId();
				aux2[1] = 1;
				top4[i] = fixture.get(eliminatorias1[i * 2]).getId();
			}
			partido4.setGoles_1(aux1[0]);
			partido4.setGoles_2(aux1[1]);

			// arrayauxiliar = ;
			LinkedList<Partido> aux4 = fixture.get(eliminatorias1[i * 2]).getFutbol();
			LinkedList<Partido> aux5 = fixture.get(eliminatorias1[(i * 2) + 1]).getFutbol();
			partido4.setEstado(aux2[0]);
			aux4.add(partido4);
			partido4.setEstado(aux2[1]);
			aux5.add(partido4);
			fixture.get(eliminatorias1[i * 2]).setFutbol(aux4);
			fixture.get(eliminatorias1[(i * 2) + 1]).setFutbol(aux5);

			// System.out.println(arrayauxiliar[0]);
			// ;
			// test(arrayauxiliar[0]);

			/*
			 * System.out.println(fixture.get((vatiables[j] + Fecha3[0][i]) - 1).getNombre()
			 * + "  " + fixture.get((vatiables[j] + Fecha3[1][i]) - 1).getNombre());
			 */
			Numero_de_partido++;
		}

		fecha9(fixture);
	}

	public static LinkedList<Equipo> fecha9(LinkedList<Equipo> fixture) {

		Partido partido4 = new Partido(fixture.get(eliminatorias[0]).getNombre(),
				fixture.get(eliminatorias[1]).getNombre(), 0, 0, 0, 0);
		int aux1[] = { (int) (Math.random() * 11), (int) (Math.random() * 11) };
		int aux2[] = { 0, 0 };
		if (aux1[0] == aux1[1]) {
			aux2[0] = 3;
			aux2[1] = 3;
			if (Math.random() * 2 == 1) {
				top4[0] = fixture.get(eliminatorias[0]).getId();
				top4[1] = fixture.get(eliminatorias[1]).getId();
			} else {
				top4[1] = fixture.get(eliminatorias[0]).getId();
				top4[0] = fixture.get(eliminatorias[1]).getId();
			}
		}
		if (aux1[0] > aux1[1]) {
			aux2[0] = 1;
			top4[0] = fixture.get(eliminatorias[0]).getId();
			aux2[1] = 2;
			top4[1] = fixture.get(eliminatorias[1]).getId();
		} else {
			aux2[0] = 2;
			top4[0] = fixture.get(eliminatorias[1]).getId();
			aux2[1] = 1;
			top4[1] = fixture.get(eliminatorias[0]).getId();
		}
		partido4.setGoles_1(aux1[0]);
		partido4.setGoles_2(aux1[1]);

		// arrayauxiliar = ;
		LinkedList<Partido> aux4 = fixture.get(eliminatorias[0]).getFutbol();
		LinkedList<Partido> aux5 = fixture.get(eliminatorias[1]).getFutbol();
		partido4.setEstado(aux2[0]);
		aux4.add(partido4);
		partido4.setEstado(aux2[1]);
		aux5.add(partido4);
		fixture.get(eliminatorias[0]).setFutbol(aux4);
		fixture.get(eliminatorias[1]).setFutbol(aux5);

		// System.out.println(arrayauxiliar[0]);
		// ;
		// test(arrayauxiliar[0]);

		/*
		 * System.out.println(fixture.get((vatiables[j] + Fecha3[0][i]) - 1).getNombre()
		 * + "  " + fixture.get((vatiables[j] + Fecha3[1][i]) - 1).getNombre());
		 */
		Numero_de_partido++;

		Efuse[6] = true;
		return fixture;
	}

	static Boolean apostar = false;
	static String  posibilidades[] = { "gana", "pierde", "empata" };
	public static void apuesta(LinkedList<Equipo> fixture) {
		
		int equipos_cant = 0;
		if (!Efuse[0] || !Efuse[1] || !Efuse[2]) {
			equipos_cant = fixture.size();
		} else if (!Efuse[3] && Efuse[2]) {
			equipos_cant = eliminatorias8.length;
		} else if (!Efuse[4] && Efuse[3]) {
			equipos_cant = eliminatorias4.length;
		} else if (!Efuse[5] && Efuse[4]) {
			equipos_cant = eliminatorias2.length;
		} else {
			equipos_cant = eliminatorias2.length;
		}

		String equipos[] = new String[equipos_cant];
		apostar = false;
		if (!Efuse[0] || !Efuse[1] || !Efuse[2]) {
			for (int i = 0; i < equipos.length; i++) {
				equipos[i] = fixture.get(i).getNombre();
			}
		}

		if (!Efuse[3] && Efuse[2]) {
			for (int j = 0; j < eliminatorias8.length; j++) {
				equipos[j] = fixture.get(eliminatorias8[j]).getNombre();
				System.err.println(eliminatorias8[j]);
			}
		}
		if (!Efuse[4] && Efuse[3]) {
			for (int j = 0; j < eliminatorias4.length; j++) {
				equipos[j] = fixture.get(eliminatorias4[j]).getNombre();
			}
		}

		if (!Efuse[5] && Efuse[4]) {
			for (int j = 0; j < eliminatorias2.length; j++) {
				equipos[j] = fixture.get(eliminatorias2[j]).getNombre();
			}
			for (int j = 0; j < eliminatorias.length; j++) {
				if (Efuse[5]) {
					equipos[j + 2] = fixture.get(eliminatorias[j]).getNombre();
				}
			}
		}

		JOptionPane.showMessageDialog(null, "elige 1 seleccion y predice el resultado");
		JFrame frame = new JFrame();
		String opcion_elegida = (String) JOptionPane.showInputDialog(frame, "elije 1 seleccion",
				" predice el resultado", JOptionPane.QUESTION_MESSAGE, null, equipos, 2);
		System.err.println(opcion_elegida);
		// JOptionPane.showInputDialog();
		// JOptionPane.showMessageDialog(null, "elije el resultado");
		int id_equipo = 0;
		for (int i = 0; i < equipos.length; i++) {
			if (opcion_elegida.equals(fixture.get(i).getNombre())) {
				id_equipo = fixture.get(i).getId();
			}
		}

		// fecha 1
		int valor = 0;
		if (!Efuse[0]) {
			valor = 4;
		} else if (!Efuse[1]) {
			valor = 3;
		} else {
			valor = 2;
		}

		String opciones_equipo[] = new String[valor];

		opciones_equipo = opciones_apuesta(fixture, equipos, opcion_elegida, valor);

		String Menuop = opciones_equipo[JOptionPane.showOptionDialog(null, "Seleccione una opcion", "Menu principal",
				JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opciones_equipo, opciones_equipo[0])];

		System.err.println(Menuop);
		int resultado_prediccion;
		int auxiliar_equipos[] = { 0, 0, 0, 0, 0, 0, 0 };
		auxiliar_equipos[0] = fixture.get(id_equipo).getApuesta();
		auxiliar_equipos[1] = fixture.get(id_equipo).getApuesta1();
		auxiliar_equipos[2] = fixture.get(id_equipo).getApuesta2();
		auxiliar_equipos[3] = fixture.get(id_equipo).getApuesta3();
		auxiliar_equipos[4] = fixture.get(id_equipo).getApuesta4();
		auxiliar_equipos[5] = fixture.get(id_equipo).getApuesta5();
		auxiliar_equipos[6] = fixture.get(id_equipo).getApuesta6();
		System.out.println("equipo" + " " + auxiliar_equipos[0]);

		if (apostar) {

			switch (Menuop) {
			case "octavos":
				// JOptionPane.showMessageDialog(null, "octavos", "octavos",
				// JOptionPane.DEFAULT_OPTION);
				resultado_prediccion = prediccion(posibilidades[JOptionPane.showOptionDialog(null,
						"Seleccione una opcion", "Prediccion", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE,
						null, posibilidades, posibilidades[0])]);
				// auxiliar_equipos = fixture.get(id_equipo).getApuesta();
				if (auxiliar_equipos[3] != 0) {
					JOptionPane.showMessageDialog(null, "prediccion cambiada");
				}
				auxiliar_equipos[3] = resultado_prediccion;
				System.err.println(resultado_prediccion);

				break;
			case "cuartos":
				// JOptionPane.showMessageDialog(null, "cuartos", "cuartos",
				// JOptionPane.DEFAULT_OPTION);
				resultado_prediccion = prediccion(posibilidades[JOptionPane.showOptionDialog(null,
						"Seleccione una opcion", "Prediccion", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE,
						null, posibilidades, posibilidades[0])]);
				// auxiliar_equipos = fixture.get(id_equipo).getApuesta();
				if (auxiliar_equipos[4] != 0) {
					JOptionPane.showMessageDialog(null, "prediccion cambiada");
				}
				auxiliar_equipos[4] = resultado_prediccion;
				System.err.println(resultado_prediccion);
				break;
			case "semi":
				// JOptionPane.showMessageDialog(null, "semi", "semi",
				// JOptionPane.DEFAULT_OPTION);
				resultado_prediccion = prediccion(posibilidades[JOptionPane.showOptionDialog(null,
						"Seleccione una opcion", "Prediccion", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE,
						null, posibilidades, posibilidades[0])]);
				// auxiliar_equipos = fixture.get(id_equipo).getApuesta();
				if (auxiliar_equipos[5] != 0) {
					JOptionPane.showMessageDialog(null, "prediccion cambiada");
				}
				auxiliar_equipos[5] = resultado_prediccion;
				System.err.println(resultado_prediccion);
				break;
			case "final":
				// JOptionPane.showMessageDialog(null, "final", "final",
				// JOptionPane.DEFAULT_OPTION);
				resultado_prediccion = prediccion(posibilidades[JOptionPane.showOptionDialog(null,
						"Seleccione una opcion", "Prediccion", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE,
						null, posibilidades, posibilidades[0])]);
				// auxiliar_equipos = fixture.get(id_equipo).getApuesta();
				if (auxiliar_equipos[6] != 0) {
					JOptionPane.showMessageDialog(null, "prediccion cambiada");
				}
				auxiliar_equipos[6] = resultado_prediccion;
				System.err.println(resultado_prediccion);
				break;
			}
		} else {
			switch (Menuop) {
			case "fecha 1":
				// JOptionPane.showMessageDialog(null, "fecha 1", "fecha 1",
				// JOptionPane.DEFAULT_OPTION);
				resultado_prediccion = JOptionPane.showOptionDialog(null, "Seleccione una opcion", "Prediccion",
						JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, posibilidades,
						posibilidades[0]);
				resultado_prediccion = prediccion(posibilidades[resultado_prediccion]);
				if (auxiliar_equipos[0] != 0) {
					JOptionPane.showMessageDialog(null, "prediccion cambiada");
				}
				auxiliar_equipos[0] = resultado_prediccion;
				// System.err.println(resultado_prediccion);
				// fixture.get(id_equipo).setApuesta(auxiliar_equipos);

				break;
			case "fecha 2":
				// JOptionPane.showMessageDialog(null, "fecha 2", "fecha 2",
				// JOptionPane.DEFAULT_OPTION);
				resultado_prediccion = prediccion(posibilidades[JOptionPane.showOptionDialog(null,
						"Seleccione una opcion", "Prediccion", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE,
						null, posibilidades, posibilidades[0])]);
				// auxiliar_equipos = fixture.get(id_equipo).getApuesta();
				if (auxiliar_equipos[1] != 0) {
					JOptionPane.showMessageDialog(null, "prediccion cambiada");
				}
				auxiliar_equipos[1] = resultado_prediccion;
				// System.err.println(resultado_prediccion);
				// fixture.get(id_equipo).setApuesta(auxiliar_equipos);
				// System.out.println(fixture.get(id_equipo).getApuesta()[1]);
				break;
			case "fecha 3":
				// JOptionPane.showMessageDialog(null, "fecha 3", "fecha 3",
				// JOptionPane.DEFAULT_OPTION);
				resultado_prediccion = prediccion(posibilidades[JOptionPane.showOptionDialog(null,
						"Seleccione una opcion", "Prediccion", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE,
						null, posibilidades, posibilidades[0])]);
				// auxiliar_equipos = fixture.get(id_equipo).getApuesta();
				if (auxiliar_equipos[2] != 0) {
					JOptionPane.showMessageDialog(null, "prediccion cambiada");
				}
				auxiliar_equipos[2] = resultado_prediccion;
				// System.err.println(resultado_prediccion);
				// fixture.get(id_equipo).setApuesta(auxiliar_equipos);
				break;
			}

			fixture.get(id_equipo).setApuesta(auxiliar_equipos[0]);
			fixture.get(id_equipo).setApuesta1(auxiliar_equipos[1]);
			fixture.get(id_equipo).setApuesta2(auxiliar_equipos[2]);
			fixture.get(id_equipo).setApuesta3(auxiliar_equipos[3]);
			fixture.get(id_equipo).setApuesta4(auxiliar_equipos[4]);
			fixture.get(id_equipo).setApuesta5(auxiliar_equipos[5]);
			fixture.get(id_equipo).setApuesta6(auxiliar_equipos[6]);

		}
		for (int i = 0; i < auxiliar_equipos.length; i++) {
			auxiliar_equipos[i] = 0;
		}
		if (Menuop.equals("puntos")) {
			JOptionPane.showMessageDialog(null, "la cantidad de puntos es: " + puntos(fixture));
		}

		// menu_inicio(fixture);
	}

	public static String[] opciones_apuesta(LinkedList<Equipo> fixture, String[] equipos, String opcion_elegida,
			int valor) {

		int equipo_seleccionado = 0;
		String opciones_equipo[] = new String[valor + 1];
		// String[] opciones_equipos = null;

		for (int i = 0; i < fixture.size(); i++) {
			if (fixture.get(i).getNombre().equals(opcion_elegida)) {
				equipo_seleccionado = fixture.get(i).getId();
			}
		}

		// fecha 1
		if (!Efuse[0]) {
			opciones_equipo[0] = "fecha 1";
			opciones_equipo[1] = "fecha 2";
			opciones_equipo[2] = "fecha 3";
			opciones_equipo[3] = "puntos";
			opciones_equipo[4] = "salir";
		}
		// fecha 2
		if (!Efuse[1] && Efuse[0]) {
			opciones_equipo[0] = "fecha 2";
			opciones_equipo[1] = "fecha 3";
			opciones_equipo[2] = "puntos";
			opciones_equipo[3] = "salir";
		}
		// fecha 3
		if (!Efuse[2] && Efuse[1]) {
			opciones_equipo[0] = "fecha 3";
			opciones_equipo[2] = "salir";
			opciones_equipo[1] = "puntos";
		}
		// octavos
		if (!Efuse[3] && Efuse[2]) {
			for (int j = 0; j < eliminatorias8.length; j++) {
				if (fixture.get(equipo_seleccionado).getId() == eliminatorias8[j]) {
					apostar = true;
				}
			}
			if (apostar) {
				opciones_equipo[0] = "octavos";
				opciones_equipo[2] = "salir";
				opciones_equipo[1] = "puntos";
			} else {
				JOptionPane.showMessageDialog(null, "este equipo no esta en octavos de final");
				opciones_equipo[1] = "puntos";
				opciones_equipo[2] = "salir";
			}

		}
		// cuartos
		if (!Efuse[4] && Efuse[3]) {
			for (int j = 0; j < eliminatorias4.length; j++) {
				if (fixture.get(equipo_seleccionado).getId() == eliminatorias4[j]) {
					apostar = true;
				}
			}

			if (apostar) {
				opciones_equipo[0] = "cuartos";
				opciones_equipo[1] = "puntos";
				opciones_equipo[2] = "salir";
			} else {
				JOptionPane.showMessageDialog(null, "este equipo no esta en cuartos de final");
				opciones_equipo[1] = "puntos";
				opciones_equipo[2] = "salir";
			}

		}
		// semi
		if (!Efuse[5] && Efuse[4]) {
			for (int j = 0; j < eliminatorias2.length; j++) {
				if (fixture.get(equipo_seleccionado).getId() == eliminatorias2[j]) {
					apostar = true;
				}
			}

			if (apostar) {
				opciones_equipo[0] = "semi";
				opciones_equipo[1] = "puntos";
				opciones_equipo[2] = "salir";
			} else {
				JOptionPane.showMessageDialog(null, "este equipo no esta en semifinal");
				opciones_equipo[1] = "puntos";
				opciones_equipo[2] = "salir";
			}

		}
		// final
		if (!Efuse[6] && Efuse[5]) {
			for (int j = 0; j < eliminatorias1.length; j++) {
				if (fixture.get(equipo_seleccionado).getId() == eliminatorias1[j]) {
					apostar = true;
				}

				if (fixture.get(equipo_seleccionado).getId() == eliminatorias[j]) {
					apostar = true;
				}
			}

			if (apostar) {
				opciones_equipo[0] = "final";
				opciones_equipo[1] = "puntos";
				opciones_equipo[2] = "salir";
			} else {
				JOptionPane.showMessageDialog(null, "este equipo no esta en la final o el tercer puesto");
				opciones_equipo[1] = "puntos";
				opciones_equipo[2] = "salir";
			}

		}

		return opciones_equipo;
	}

	public static int prediccion(String x) {
		System.out.println("x" + x);
		int z = 0;
		switch (x) {
		case "gana":
			z = 1;
			break;
		case "pierde":
			z = 2;
			break;
		case "empata":
			z = 3;
			break;
		}
		System.out.println("z" + z);
		return z;
	}

	public static int desbug(int j, int i,LinkedList<Equipo> fixture) {
		int e =fixture.get(i).getFutbol().get(j).getEstado();
		switch (e) {
		case 1:
			e=2;
			break;
		case 2:
			e=1;
			break;

		}
		
		
		
		return e;
			
	}
	
	
	public static int puntos(LinkedList<Equipo> fixture) {
		int puntos = 0;
		int aux12[] = new int[7];
		int respuesta;
		int lineas;
		if (Efuse[0]) {

			for (int i = 0; i < fixture.size(); i++) {
				aux12[0] = fixture.get(i).getApuesta();
				aux12[1] = fixture.get(i).getApuesta1();
				aux12[2] = fixture.get(i).getApuesta2();
				aux12[3] = fixture.get(i).getApuesta3();
				aux12[4] = fixture.get(i).getApuesta4();
				aux12[5] = fixture.get(i).getApuesta5();
				aux12[6] = fixture.get(i).getApuesta6();
				if (!Efuse[0]) {
					lineas = 0;
				} else {
					lineas = fixture.get(i).getFutbol().size();
				}
				for (int j = 0; j < lineas; j++) {
					System.err.println(fixture.get(i).getNombre());
					int eqipo=desbug(j,i,fixture);
					System.out.println(eqipo);
					respuesta = prediccion(posibilidades[eqipo-1]);
					System.out.println("puntos" + aux12[j] + "  " + respuesta);
					if (aux12[j] != 0) {
						System.err.println(respuesta == aux12[j] && aux12[j] != 0);
						if (respuesta == aux12[j]) {
							if (j >= 3) {
								puntos = puntos + 3;
							} else {
								puntos=puntos + 1;
							}
						}
					}
				}
			}
		}
		System.out.println(puntos);
		return puntos;
	}

}