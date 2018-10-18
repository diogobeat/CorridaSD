package Sockets;

import java.util.Scanner;

public class Cliente_Sockets {
	public static void main(String[] args) {
		boolean fim = true;
		String cliente;
		
		Scanner teclado = new Scanner(System.in);

		
		System.out.println("Seja bem vindo");
		do {
		System.out.println("  1 - Atualizar a Corrida");
		System.out.println("  2 - Visualizar a Grelha");
		System.out.println("  0 - Sair");
		System.out.print("Pretende: ");
		
		String opc = teclado.next();
		
		switch (opc) {
		case "1":
			System.out.println("1");
			break;
		case "2":
			System.out.println("2");
			break;
		case "0":
			fim = false;
			break;
		default:
			System.out.println("Opcão inexistente!");
			break;
		}
		}while(fim);
	}
	
	public void actualizarCorrida(int ultrapassou, int ultrapassado, int volta, String cliente, int atualizacoes) {
		
	}
	
	public void imprimirGrelha(){
		
	}
}