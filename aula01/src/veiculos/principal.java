package veiculos;

public class principal {
	
	public static void main(String[] args) {
		Veiculo veiculo = new Veiculo();
		veiculo.ligar();
		veiculo.acelerar();
		veiculo.freiar();
		veiculo.desligar();
		
		veiculo.marca = "VW";
		veiculo.modelo = "Gol";
		veiculo.ano = 2020;
		veiculo.cor = Cor.VERMELHO;
		veiculo.placa = "FR2K-2020";
		
		System.out.println(veiculo.info());
		
		
	}
}
