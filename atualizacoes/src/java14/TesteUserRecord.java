package java14;

public class TesteUserRecord {

	public static void main(String[] args) {
		UserRecord user = new UserRecord(1L, "João da Silva", "senha123");
		System.out.println(user);
		
		System.out.println(user.id());
		System.out.println(user.nome());
		System.out.println(user.senha());
	}
}
