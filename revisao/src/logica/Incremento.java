package logica;

public class Incremento {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i=0;
		i++;
		++i;
		System.out.println(i);
		i = i++;
		System.out.println(i);
		i = i+1;
		System.out.println(i);
		i = i-1;
		System.out.println(i);
		i += 1;
		System.out.println(i);
		i -= 1;
		System.out.println(i);
		i += ++i;
		System.out.println(i);
		i += i++;
		System.out.println(i);
		i += i--;
		System.out.println(i);
		i += --i;
		System.out.println(i);
		

	}

}
