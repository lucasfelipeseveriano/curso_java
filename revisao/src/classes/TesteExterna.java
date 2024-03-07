package classes;

import classes.Externa.Interna;

public class TesteExterna {
	public static void main(String[] args) {
		Externa obj = new Externa();
		Interna i = obj.new Interna();
		i.mensagem();
		
	}

}
