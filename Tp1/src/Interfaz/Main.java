package Interfaz;

import java.util.LinkedList;

import bin.Equipo;
import bin.Partido;

public class Main {

	public static void main(String[] args) {

		LinkedList<Equipo> fixture = new LinkedList<Equipo>();
		carga(fixture);

		/*for (int i = 0; i < fixture.size(); i++) {
			System.out.println(fixture.get(i).getNombre());
		}
*/
		int juegos[][] = { { 1, 1, 1, 2, 2, 3 }, { 2, 3, 4, 3, 4, 4 } };
		int grupo[] = { -1, 3, 7, 11, 15, 19, 23, 27 };
		for (int j = 0; j < grupo.length; j++) {

			for (int i = 0; i < juegos[1].length; i++) {
				/*
				 * Partido partido = new Partido(fixture.get(juegos[0][i]).getNombre(),
				 * fixture.get(juegos[1][i]).getNombre(), null, 0, 0, 0);
				 */
				  System.out.println(fixture.get((grupo[j] + juegos[0][i])).getNombre() + "  "
							+ fixture.get((grupo[j] + juegos[1][i])).getNombre());
			}

		}

	}

	private static LinkedList<Equipo> carga(LinkedList<Equipo> fixture) {
		// hacer personal

		String[] equipos = { "qatar", "ecuador", "senegal", "paises bajos", "Inglaterra", "iran", "Estados unidos",
				"Gales", "Argentina", "Arabia Saudita", "Mexico", "Polonia", "francia", "Australia", "Dinamarca",
				"tunez", "España", "costa rica", "Alemania", "Japon", "Belgica", "Canada", "Marruecos", "Croacia",
				"Brasil", "serbia", "Suiza", "Camerun", "Portugal", "Ghana", "Uruguay", "Corea del sur" };

		for (int i = 0; i < equipos.length; i++) {
			Equipo equipo = new Equipo(equipos[i], 0, true, null);
			fixture.add(equipo);
		}

		return fixture;
	}

}
