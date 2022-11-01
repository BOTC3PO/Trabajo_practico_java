package Interfaz;

import java.util.Iterator;
import java.util.LinkedList;

import bin.Equipo;
import bin.Partido;

public class Main {

	public static int Numero_de_partido = 0;

	public static void main(String[] args) {

		LinkedList<Equipo> fixture = new LinkedList<Equipo>();
		carga(fixture);

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
				System.err.println(aux1[0]+"  " +aux1[1]);
				for (int k = 0; k < 2; k++) {
					// arrayauxiliar = ;
					int arrayauxiliar[] = fixture.get((vatiables[j] + Fecha1[k][i]) - 1).getGrupos();
					arrayauxiliar[0] = aux2[k];
					System.out.println(arrayauxiliar[0]);
					;
				}

				System.out.println(fixture.get((vatiables[j] + Fecha1[0][i]) - 1).getNombre() + "  "
						+ fixture.get((vatiables[j] + Fecha1[1][i]) - 1).getNombre());
				Numero_de_partido++;
			}

		}
		/* fecha 2 */
		for (int j = 0; j < vatiables.length; j++) {

			for (int i = 0; i < Fecha2[1].length; i++) {
				/*
				 * Partido partido = new Partido(fixture.get(Fecha1[0][i]-1).getNombre(),
				 * fixture.get(Fecha1[1][i]-1).getNombre(), null, 0, 0, 0);
				 */
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

}
