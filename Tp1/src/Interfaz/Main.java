package Interfaz;

import java.util.LinkedList;

import javax.swing.JOptionPane;

import bin.Equipo;
import bin.Partido;

public class Main {

	public static int Numero_de_partido = 0;
	public static boolean Efuse[] = { false, false, false, false, false, false, false };
	public static int vatiables[] = { 0, 8, 16, 24 };
	public static String Menu[] = {};
	public static int Fecha1[][] = { { 1, 5, 3, 7 }, { 2, 6, 4, 8 } };
	public static int Fecha2[][] = { { 6, 1, 2, 5 }, { 8, 3, 4, 7 } };
	public static int Fecha3[][] = { { 2, 6, 4, 8 }, { 3, 7, 1, 5 } };
	public static int eliminatorias8[] = new int[16];
	public static int eliminatorias4[] = new int[8];
	public static int eliminatorias2[] = new int[4];
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
		menu_inicio(fixture);

		System.out.println(Numero_de_partido);
	}

	private static LinkedList<Equipo> carga(LinkedList<Equipo> fixture) {
		// hacer personal

		String[] equipos = { "qatar", "ecuador", "senegal", "paises bajos", "Inglaterra", "iran", "Estados unidos",
				"Gales", "Argentina", "Arabia Saudita", "Mexico", "Polonia", "francia", "Australia", "Dinamarca",
				"tunez", "España", "costa rica", "Alemania", "Japon", "Belgica", "Canada", "Marruecos", "Croacia",
				"Brasil", "serbia", "Suiza", "Camerun", "Portugal", "Ghana", "Uruguay", "Corea del sur" };
		int data[] = { 0, 0, 0 };
		for (int i = 0; i < equipos.length; i++) {
			Equipo equipo = new Equipo(equipos[i], 0, data, true, null);
			fixture.add(equipo);
		}

		return fixture;
	}

	private static void test(int dato) {
		switch (dato) {
		case 0:
			System.err.println("no jugado");
			break;
		case 1:
			System.err.println("ganado");
			break;
		case 2:
			System.err.println("perdido");
			break;
		case 3:
			System.err.println("empatado");
			break;
		}
	}

	public static LinkedList<Equipo> mostrar_grupo(LinkedList<Equipo> fixture) {
		String grupos[] = { "grupo A", "grupo B", "grupo C", "grupo D", "grupo E", "grupo F", "grupo G", "grupo H",
				"salir" };
		String Teams[] = new String[4];
		String seleccion;
		boolean comprobar = true;
		int contador;
		String mensaje;
		int min = 0;
		int max = 0;
		do {
			mensaje = "";
			contador = 0;

			seleccion = (String) JOptionPane.showInputDialog(null, "seleccione 1 grupo", "seleccion de grupo",
					JOptionPane.QUESTION_MESSAGE, null, grupos, "seleccione");
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
				String opciones[] = { "siguiente", "salir" };
				String datos = (String) JOptionPane.showInputDialog(null, mensaje, "seleccion equipo",
						JOptionPane.QUESTION_MESSAGE, null, opciones, "Seleccione");
				if (datos.equalsIgnoreCase("siguiente")) {
					String fixture_equipo = (String) JOptionPane.showInputDialog(null, "seleccionar equipo",
							"seleccion equipo", JOptionPane.QUESTION_MESSAGE, null, Teams, "Seleccione");
				}

			}

		} while (!seleccion.equalsIgnoreCase("salir"));
		return fixture;
	}

	public static LinkedList<Equipo> fecha1(LinkedList<Equipo> fixture) {
		for (int j = 0; j < vatiables.length; j++) {

			for (int i = 0; i < Fecha1[1].length; i++) {

				Partido partido = new Partido(fixture.get(Fecha1[0][i] - 1).getNombre(),
						fixture.get(Fecha1[1][i] - 1).getNombre(), null, 0, 0, 0);
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

				// System.err.println(aux1[0] + " " + aux1[1]);
				for (int k = 0; k < 2; k++) {
					// arrayauxiliar = ;
					int arrayauxiliar[] = fixture.get((vatiables[j] + Fecha1[k][i]) - 1).getGrupos();
					arrayauxiliar[0] = aux2[k];
					fixture.get(vatiables[j] + Fecha1[k][i] - 1).setGrupos(arrayauxiliar);
					// System.out.println(arrayauxiliar[0]);
					// ;
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
						fixture.get(Fecha2[1][i] - 1).getNombre(), null, 0, 0, 0);
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
				System.out.println(fixture.get((vatiables[j] + Fecha2[0][i]) - 1).getNombre() + "  "
						+ fixture.get((vatiables[j] + Fecha2[1][i]) - 1).getNombre());
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
						fixture.get(Fecha3[1][i] - 1).getNombre(), null, 0, 0, 0);

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
				System.out.println(fixture.get((vatiables[j] + Fecha3[0][i]) - 1).getNombre() + "  "
						+ fixture.get((vatiables[j] + Fecha3[1][i]) - 1).getNombre());
				Numero_de_partido++;
			}

		}
		Efuse[2] = true;
		return fixture;
	}

	public static String[] crear_menu() {
		String mensaje_gen[] = { "", "", "" };
		String mensaje_gen2[] = { "", "", "", "" };
		if (Efuse[0] == false) {
			mensaje_gen[0] = "ver grupos";
			mensaje_gen[1] = "jugar fecha 1";
			mensaje_gen[2] = "salir";
		} else if (Efuse[1] == false) {
			mensaje_gen[0] = "ver grupos";
			mensaje_gen[1] = "jugar fecha 2";
			mensaje_gen[2] = "salir";
		} else if (Efuse[2] == false) {
			mensaje_gen[0] = "ver grupos";
			mensaje_gen[1] = "jugar fecha 3";
			mensaje_gen[2] = "salir";
		} else if (Efuse[3] == false) {
			mensaje_gen2[0] = "ver grupos";
			mensaje_gen2[1] = "ver eliminarorias";
			mensaje_gen2[2] = "octavos de final";
			mensaje_gen2[3] = "salir";
		} else if (Efuse[4] == false) {
			mensaje_gen2[0] = "ver grupos";
			mensaje_gen2[1] = "ver eliminarorias";
			mensaje_gen2[2] = "cartos de final";
			mensaje_gen2[3] = "salir";
		} else if (Efuse[5] == false) {
			mensaje_gen2[0] = "ver grupos";
			mensaje_gen2[1] = "ver eliminarorias";
			mensaje_gen2[2] = "semifinal";
			mensaje_gen2[3] = "salir";
		} else if (Efuse[6] == false) {
			mensaje_gen2[0] = "ver grupos";
			mensaje_gen2[1] = "ver eliminarorias";
			mensaje_gen2[2] = "final y por el 3º puesto";
			mensaje_gen2[3] = "salir";
		} else {
			mensaje_gen[0] = "ver grupos";
			mensaje_gen[1] = "ver eliminatirias";
			mensaje_gen[2] = "salir";
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

			Menu = crear_menu();

			menu_select = (String) JOptionPane.showInputDialog(null, "Seleccione una opcion", "Menu principal",
					JOptionPane.QUESTION_MESSAGE, null, Menu, "Seleccione");

			switch (menu_select) {
			case "ver grupos":
				/* mostrar equipos */
				if (!Efuse[0]) {
					mostrar_grupo(fixture);
				} else {
					/* posiciones */
					pocicionamiento(fixture);
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

				break;
			case "octavos de final":

				break;
			case "cartos de final":

				break;
			case "semifinal":

				break;
			case "final y por el 3º puesto":

				break;
			default:
				/* salir */
				break;
			}
		} while (!menu_select.equalsIgnoreCase("salir"));
	}

	public static LinkedList<Equipo> pocicionamiento(LinkedList<Equipo> fixture) {
		pociciones.clear();
		// pociciones = (LinkedList<Equipo>) fixture.clone();
		int main_contador = 0;
		int min = 0, max = 0, contador = 0, subcontador = 0;
		int aux[][] = { { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 } };
		int listaequipos[] = new int[32];
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
				int aux1[] = fixture.get(min).getGrupos();
				int aux2[] = fixture.get(min + 1).getGrupos();
				int aux3[] = fixture.get(min + 2).getGrupos();
				int aux4[] = fixture.get(max).getGrupos();
				aux[0] = aux1;
				aux[1] = aux2;
				aux[2] = aux3;
				aux[3] = aux4;

				for (int j = 0; j < aux.length; j++) {
					for (int i = 0; i < aux[j].length; i++) {
						// System.out.println(aux[j][i]);
						switch (aux[j][i]) {
						case 1:
							puntos[j] += 3;
							break;
						case 0:
							puntos[j] += 0;
							break;
						case 2:
							puntos[j] += 0;
							break;
						case 3:
							puntos[j] += 1;
							break;
						}
					}
				}

				// int subcontador_fixture = 0;

				/*
				 * 
				 * 
				 * for (int i = min; i <= max; i++) {
				 * System.out.println(fixture.get(pocicion[subcontador_fixture]).getNombre());
				 * pociciones.add(fixture.get(pocicion[subcontador_fixture]));
				 * subcontador_fixture++; }
				 */
				if (puntos[0] != puntos[1] && puntos[1] != puntos[2] && puntos[2] != puntos[3]) {
					// min

					if (puntos[0] > puntos[1] && puntos[0] > puntos[2] && puntos[0] > puntos[3]) {
						pocicion[0] = min;
					} else if (puntos[0] < puntos[1] && puntos[0] > puntos[2] && puntos[0] > puntos[3]) {
						pocicion[0] = (min + 1);
					} else if (puntos[0] < puntos[1] && puntos[0] < puntos[2] && puntos[0] > puntos[3]) {
						pocicion[0] = (min + 2);
					} else if (puntos[0] < puntos[1] && puntos[0] < puntos[2] && puntos[0] < puntos[3]) {
						pocicion[0] = (max);
					}

					// min+1

					if (puntos[1] > puntos[0] && puntos[1] > puntos[2] && puntos[1] > puntos[3]) {
						pocicion[1] = min;
					} else if (puntos[1] < puntos[0] && puntos[1] > puntos[2] && puntos[1] > puntos[3]) {
						pocicion[1] = min + 1;
					} else if (puntos[1] < puntos[0] && puntos[1] < puntos[2] && puntos[1] > puntos[3]) {
						pocicion[1] = min + 2;
					} else if (puntos[1] < puntos[0] && puntos[1] < puntos[2] && puntos[1] < puntos[3]) {
						pocicion[1] = max;
					}

					// max-1
					if (puntos[2] > puntos[0] && puntos[2] > puntos[1] && puntos[2] > puntos[3]) {
						pocicion[2] = min;
					} else if (puntos[2] < puntos[0] && puntos[2] > puntos[1] && puntos[2] > puntos[3]) {
						pocicion[2] = min + 1;
					} else if (puntos[2] < puntos[0] && puntos[2] < puntos[1] && puntos[2] > puntos[3]) {
						pocicion[2] = min + 2;
					} else if (puntos[2] < puntos[0] && puntos[2] < puntos[1] && puntos[2] < puntos[3]) {
						pocicion[2] = max;
					}

					// max

					if (puntos[3] > puntos[0] && puntos[3] > puntos[1] && puntos[3] > puntos[2]) {
						pocicion[3] = min;
					} else if (puntos[3] < puntos[0] && puntos[3] > puntos[1] && puntos[3] > puntos[2]) {
						pocicion[3] = min + 1;
					} else if (puntos[3] < puntos[0] && puntos[3] < puntos[1] && puntos[3] > puntos[2]) {
						pocicion[3] = min + 2;
					} else if (puntos[3] < puntos[0] && puntos[3] < puntos[1] && puntos[3] < puntos[2]) {
						pocicion[3] = max;
					}

				} else {
					if (puntos[0] == puntos[1] && puntos[0] != puntos[2] && puntos[0] != puntos[3]) {
						if (puntos[2] == puntos[3] && puntos[0] != puntos[2] && puntos[0] != puntos[3]) {
							if (fixture.get(min).getGoles() > fixture.get(min + 1).getGoles()) {
								pocicion[0] = min;
								pocicion[1] = min+1;
							} else {
								pocicion[0] = min+1;
								pocicion[1] = min;
							}
							
							if (fixture.get(min+2).getGoles() > fixture.get(max).getGoles()) {
								pocicion[2] = min;
								pocicion[3] = min+2;
							} else {
								pocicion[2] = min+2;
								pocicion[3] = min;
							}
							
							
						} else {
							if (puntos[0] > puntos[1]) {
								pocicion[0] = min;
								pocicion[1] = min+1;
							}else {
								pocicion[0] = min+1;
								pocicion[1] = min;
							}
							if (puntos[2] > puntos[3]) {
								pocicion[2] = min;
								pocicion[3] = min+2;
							} else {
								pocicion[2] = min+2;
								pocicion[3] = min;
							}
						}
					}
					if (puntos[0] == puntos[2] && puntos[0] != puntos[1] && puntos[0] != puntos[3]) {
						if (puntos[1] == puntos[3] && puntos[0] != puntos[1] && puntos[0] != puntos[3]) {
							
							if (fixture.get(min).getGoles() > fixture.get(min + 2).getGoles()) {
								pocicion[0] = min;
								pocicion[2] = min+1;
							} else {
								pocicion[0] = min+1;
								pocicion[2] = min;
							}
						
							if (fixture.get(min+1).getGoles() > fixture.get(max).getGoles()) {
								pocicion[1] = min;
								pocicion[3] = min+2;
							} else {
								pocicion[1] = min+2;
								pocicion[3] = min;
							}
						
						} else {
							if (puntos[0] > puntos[1]) {
								pocicion[0] = min;
								pocicion[1] = min+1;
							}else {
								pocicion[0] = min+1;
								pocicion[1] = min;
							}
							if (puntos[2] > puntos[3]) {
								pocicion[2] = min;
								pocicion[3] = min+2;
							} else {
								pocicion[2] = min+2;
								pocicion[3] = min;
							}
					}}
					if (puntos[0] == puntos[3] && puntos[0] != puntos[1] && puntos[0] != puntos[2]) {

					}

				}

			}
			for (int z = 0; z < pocicion.length; z++) {
				listaequipos[main_contador] = pocicion[z];
				main_contador++;
				// System.err.println(main_contador);
			}

			subcontador = 0;
			contador++;

		} while (contador != 8);

		// JOptionPane.showMessageDialog(null, "salida correcta" + contador);
		for (int i = 0; i <= 31; i++) {
			// System.out.println(pociciones.get(i));
			// pociciones.add(i, fixture.get(listaequipos[i]));
		}

		for (int i = 0; i < 32; i++) {
			// System.out.println(i + pociciones.get(i).getNombre());
			// System.out.println(i+ fixture.get(i).getNombre());
			System.out.println(listaequipos[i]);
		}

		return fixture;
	}

}