import java.util.*;
public class conversorBases {

	public static void main (String args[]){
		String numEntrada;
		int baseNumEntrada, baseNumSalida;
		Scanner en = new Scanner (System.in);

		System.out.println ("Número a convertir");
		numEntrada = en.next();
		System.out.println ("Base del número a convertir");
		baseNumEntrada = en.nextInt();
		System.out.println ("Base a la que se quiere convertir");
		baseNumSalida = en.nextInt();
		
		System.out.println ("Resultado " + deNaN (numEntrada, baseNumEntrada, baseNumSalida));
	}
	
	public static String deNaN (String ne, int bne, int bns) {
		//recibe el numero en base 10 y se convierte a la base requerida con los metodos deNa10() y de10aN
		return de10aN (deNa10 (ne, bne)[0], deNa10 (ne, bne)[1], bns);
	}
	
	//convierte de base n a base 10
	public static String[] deNa10 (String ne, int bne) {
		int posicionPunto = ne.length ();
		double sumatoria = 0;
		long sumatoriaEnteros = 0;

		//Busca la posicion del punto
		for (int j = 0; j < ne.length(); j++) {
			if (ne.charAt (j) == '.') {
				posicionPunto = j;
			}
		}

		//Ciclo para sumar los enteros
		for (int j = posicionPunto - 1; j >= 0; j--) {
			if (Character.isDigit (ne.charAt (j)))
				sumatoriaEnteros += Integer.parseInt ("" + ne.charAt (j)) * Math.pow (bne, posicionPunto - 1 - j);
			else
				sumatoriaEnteros += Integer.parseInt ("" + letraAnumero (Character.toLowerCase (ne.charAt (j)))) * Math.pow (bne, posicionPunto - 1 - j);
		}

		//suma la parte decimal del número
		for (int j = posicionPunto + 1; j < ne.length(); j++) {
			if (Character.isDigit (ne.charAt (j)))
				sumatoria += Integer.parseInt ("" + ne.charAt (j)) * Math.pow (bne, posicionPunto - j);
			else
				sumatoria += Integer.parseInt ("" + letraAnumero (Character.toLowerCase (ne.charAt (j)))) * Math.pow (bne, posicionPunto - j);
		}
		String[] c = new String[2];
		c[0] = ""+sumatoriaEnteros;
		if (sumatoria != 0)
			c[1] = ""+sumatoria;
			
		return c;
	}
	
	public static String de10aN (String nee, String ned, int bns) {
		boolean comprobantePunto = false;//para saber si ya se paso por le punto
		boolean comprobanteDivision = false;//para saber cuando se debe dejar de dividir en la conversion
		String resultado = "";
		long parteEnteraL;
		int limite = 10, cont = 0;//trabajan juntas para establecer el numero de precision en decimales
		double parteDecimalD;
		Stack<String> digitos = new Stack<String> ();
	
		//parte entera
		parteEnteraL = Long.parseLong (nee);

		while (!comprobanteDivision) {
			long temp = parteEnteraL;
			if (parteEnteraL / bns < 1) {
				if (temp > 9)
					digitos.push ("" + numeroAletra (temp));
				else
					digitos.push ("" + temp);
				comprobanteDivision = true;
			} else {
				parteEnteraL = (long) parteEnteraL / bns;
				if (temp - (parteEnteraL * bns) > 9)
					digitos.push ("" + numeroAletra (temp - (parteEnteraL * bns)));
				else
					digitos.push ("" + (temp - (parteEnteraL * bns)));
			}
		}
		
		while (!digitos.empty ())
			resultado += digitos.pop ();

		if (ned != null) {
			//parte decimal
			parteDecimalD = Double.parseDouble (ned);
			resultado += ".";

			while (parteDecimalD != 0 && cont != limite) {
				cont++;
				parteDecimalD *= bns;

				if ((int) parteDecimalD > 9)
					resultado += "" + numeroAletra ((int) parteDecimalD);
				else
					resultado += "" + (int) parteDecimalD;

				parteDecimalD -= (int) parteDecimalD;
			}
		}
			
		return resultado;
	}
	
	public static int letraAnumero (char letra) {
		int retorno = 0;

		switch (letra) {
			case 'a':
				 retorno = 10;
			break;
			case 'b':
				 retorno = 11;
			break;
			case 'c':
				 retorno = 12;
			break;
			case 'd':
				 retorno = 13;
			break;
			case 'e':
				 retorno = 14;
			break;
			case 'f':
				 retorno = 15;
			break;
			case 'g':
				 retorno = 16;
			break;
			case 'h':
				 retorno = 17;
			break;
			case 'i':
				 retorno = 18;
			break;
			case 'j':
				 retorno = 19;
			break;
			case 'k':
				 retorno = 20;
			break;
			case 'l':
				 retorno = 21;
			break;
			case 'm':
				 retorno = 22;
			break;
			case 'n':
				 retorno = 23;
			break;
			case 'o':
				 retorno = 24;
			break;
			case 'p':
				 retorno = 25;
			break;
			case 'q':
				 retorno = 26;
			break;
			case 'r':
				 retorno = 27;
			break;
			case 's':
				 retorno = 28;
			break;
			case 't':
				 retorno = 29;
			break;
			case 'u':
				 retorno = 30;
			break;
			case 'v':
				 retorno = 31;
			break;
			case 'w':
				 retorno = 32;
			break;
			case 'x':
				 retorno = 33;
			break;
			case 'y':
				 retorno = 34;
			break;
			case 'z':
				 retorno = 35;
			break;
		}
		
		return retorno;
	}
	
	public static char numeroAletra (long numero) {
		char retorno = '0';

		switch ((int)numero) {
			case 10:
				 retorno = 'a';
			break;
			case 11:
				 retorno = 'b';
			break;
			case 12:
				 retorno = 'c';
			break;
			case 13:
				 retorno = 'd';
			break;
			case 14:
				 retorno = 'e';
			break;
			case 15:
				 retorno = 'f';
			break;
			case 16:
				 retorno = 'g';
			break;
			case 17:
				 retorno = 'h';
			break;
			case 18:
				 retorno = 'i';
			break;
			case 19:
				 retorno = 'j';
			break;
			case 20:
				 retorno = 'k';
			break;
			case 21:
				 retorno = 'l';
			break;
			case 22:
				 retorno = 'm';
			break;
			case 23:
				 retorno = 'n';
			break;
			case 24:
				 retorno = 'o';
			break;
			case 25:
				 retorno = 'p';
			break;
			case 26:
				 retorno = 'q';
			break;
			case 27:
				 retorno = 'r';
			break;
			case 28:
				 retorno = 's';
			break;
			case 29:
				 retorno = 't';
			break;
			case 30:
				 retorno = 'u';
			break;
			case 31:
				 retorno = 'v';
			break;
			case 32:
				 retorno = 'w';
			break;
			case 33:
				 retorno = 'x';
			break;
			case 34:
				 retorno = 'y';
			break;
			case 35:
				 retorno = 'z';
			break;
		}
		
		return retorno;
	}
}
