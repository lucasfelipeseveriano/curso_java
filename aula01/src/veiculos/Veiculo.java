package veiculos;

public class Veiculo {
	
	
	
	 String marca;
	 String modelo;
	 Cor cor;
	 String placa;
	 int ano;
	 
	 
	 void ligar() {
		 System.out.println("Carro ligado");
	 }
	 
	 void desligar() {
		 System.out.println("Carro desligado");
	 }
	 
	 void rodar() {
		 System.out.println("Carro rodando");
	 }
	 
	 void acelerar() {
		 System.out.println("Carro acelerando");
	 }
	 
	 void freiar() {
		 System.out.println("Carro freiando");
	 }
	 
	 @Override
	public String toString() {
		 return String.format("\nMarca: %-4s Modelo: %-10s Ano: %-6d placa: %-10s cor: %s", marca, modelo, ano, placa, cor);
	}
	 
	 /*
	 public String toString() {
		 return String.format("\nMarca: %-4s Modelo: %-10s Ano: %-6d placa: %-10s cor: %s", marca, modelo, ano, placa, cor);
	 }
	 */
}
