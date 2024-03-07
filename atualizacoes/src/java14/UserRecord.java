package java14;

import java.util.Objects;

public record UserRecord(Long id, String nome, String senha) {
	
	//não permite criar campos de instância em um record
	//private String rua = "XV";
	
	// permite criar variáveis estáticas
	private static String ROLE = "USER";

	// construtor compacto
	public UserRecord {
		System.out.println("Chamou o construtor compacto");
		// java.util.Objects do java 7 e 8
		Objects.requireNonNull(id);
		Objects.requireNonNull(nome);
		Objects.requireNonNull(senha);
		
		if (id < 0) {
			throw new IllegalArgumentException("ID não pode ser negativo");
		}
	}
	
	// construtor com 2 argumentos
	public UserRecord(Long id, String nome) {
		//
		this(id, nome, "");
	}
	
	public void info() {
		System.out.println("id: " + id + "\tNome: " + nome );
	}
}
