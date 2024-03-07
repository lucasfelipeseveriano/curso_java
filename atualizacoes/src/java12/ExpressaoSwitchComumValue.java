package java12;

public class ExpressaoSwitchComumValue {

	enum DIA {
		SEGUNDA, TERÇA, QUARTA, QUINTA, SEXTA, SABADO, DOMINGO
	}

	public static void main(String[] args) {

		DIA dia = DIA.SEGUNDA;

		String resultado = switch (dia) {
		case SEGUNDA, TERÇA, QUARTA, QUINTA, SEXTA -> "Meio da semana";

		case SABADO, DOMINGO -> "Finl de semana";

		default -> "Dia inválido";

		};

		System.out.println(resultado);
		
		novosMetodoString();
	}

	private static void novosMetodoString() {
		String texto = "Novo método para identação\ndo java12".indent(7);
		System.out.println(texto);

		String texto2 = " João ".transform(s -> s + "da Silva")
								.transform(String::toUpperCase);
		
		System.out.println(texto2);

	}

}
