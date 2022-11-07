package Interfaz;

import java.util.Iterator;
import java.util.LinkedList;

import javax.swing.JOptionPane;

import bin.Equipo;
import bin.Partido;

public class Main {

	public static int Numero_de_partido = 0;

	public static void main(String[] args) {

		LinkedList<Equipo> fixture = new LinkedList<Equipo>();
		carga(fixture);
		mostrar_grupo(fixture);
		/*
		 * for (int i = 0; i < fixture.size(); i++) {
		 * System.out.println(fixture.get(i).getNombre()); }
		 */
		int vatiables[] = { 0, 8, 16, 24 };
		int Fecha1[][] = { { 1, 5, 3, 7 }, { 2, 6, 4, 8 } };
		int Fecha2[][] = { { 6, 1, 2, 5 }, { 8, 3, 4, 7 } };
		int Fecha3[][] = { { 2, 6, 4, 8 }, { 3, 7, 1, 5 } };

		/* fecha 1 */
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
				System.err.println(aux1[0] + "  " + aux1[1]);
				for (int k = 0; k < 2; k++) {
					// arrayauxiliar = ;
					int arrayauxiliar[] = fixture.get((vatiables[j] + Fecha1[k][i]) - 1).getGrupos();
					arrayauxiliar[0] = aux2[k];
					fixture.get(vatiables[j] + Fecha1[k][i] - 1).setGrupos(arrayauxiliar);
					// System.out.println(arrayauxiliar[0]);
					// ;
					test(arrayauxiliar[0]);
				}

				System.out.println(fixture.get((vatiables[j] + Fecha1[0][i]) - 1).getNombre() + "  "
						+ fixture.get((vatiables[j] + Fecha1[1][i]) - 1).getNombre());

				Numero_de_partido++;
			}

		}
		/* fecha 2 */
		for (int j = 0; j < vatiables.length; j++) {

			for (int i = 0; i < Fecha2[1].length; i++) {
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
				System.out.println(fixture.get((vatiables[j] + Fecha2[0][i]) - 1).getNombre() + "  "
						+ fixture.get((vatiables[j] + Fecha2[1][i]) - 1).getNombre());
				Numero_de_partido++;
			}

		}
		/* fecha 3 */
		for (int j = 0; j < vatiables.length; j++) {

			for (int i = 0; i < Fecha1[1].length; i++) {
				/*
				 * Partido partido = new Partido(fixture.get(Fecha1[0][i]-1).getNombre(),
				 * fixture.get(Fecha1[1][i]-1).getNombre(), null, 0, 0, 0);
				 */
				System.out.println(fixture.get((vatiables[j] + Fecha3[0][i]) - 1).getNombre() + "  "
						+ fixture.get((vatiables[j] + Fecha3[1][i]) - 1).getNombre());
				Numero_de_partido++;
			}

		}
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
		String Teams[]= new String[4];
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
				min = 5;
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
					mensaje+=fixture.get(i).getNombre();
					if (contador<=3) {
						mensaje+="\n";
				
					}
					
					Teams[contador]=fixture.get(i).getNombre();
					
					contador++;
				}
				String opciones[]={"siguiente","salir"};
				String datos = (String) JOptionPane.showInputDialog(null, mensaje,"seleccion equipo",JOptionPane.QUESTION_MESSAGE,null,opciones,"Seleccione");
				
				String fixture_equipo= (String) JOptionPane.showInputDialog(null,"seleccionar equipo","seleccion equipo",JOptionPane.QUESTION_MESSAGE,null,Teams,"Seleccione");
			}

		} while (!seleccion.equalsIgnoreCase("salir"));
		return fixture;
	}

}
