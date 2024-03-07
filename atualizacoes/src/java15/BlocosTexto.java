package java15;

public class BlocosTexto {
	
	public static void main(String[] args) {
		String textoAntigo = "Este é um texto" + 
							 "composto de váias" +
							 "linha de código";
		
		System.out.println(textoAntigo);
		
		String textoBloco = """
								"Este é um texto \
								"com o novo" \
								recurso do Java 15 \
								chamando Text Block
							""";
		
		System.out.println(textoBloco);
	}

}
