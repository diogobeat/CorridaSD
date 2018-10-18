package Sockets;


import java.net.*;

import Corrida.Corrida;

import java.io.*;

public class Server_Corrida {
	static int DEFAULT_PORT=8081;
	public static Corrida corrida;
	
	public void atulizarConteudo(int volta) {
		this.corrida.setVolta(volta);
		this.corrida.update();
	}
	
	public static void main(String[] args) {
		int port=DEFAULT_PORT;
		
		// Cria um ServerSocket e associa-o a porta especificada na variavel port
		ServerSocket servidor = null; 
	
		try	{ 
			servidor = new ServerSocket(port);
		} catch (Exception e) { 
			System.err.println("erro ao criar socket servidor...");
			e.printStackTrace();
			System.exit(-1);
		}
					
		while(true) {
			try {
				// Aguarda que seja estabelecida alguma ligacao e quando isso acontecer cria um socket
				// chamado ligacao para atender essa ligação
				Socket ligacao = servidor.accept();		
				ServerHandler t = new ServerHandler(ligacao);
				t.start();
				
			} catch (IOException e) {
				System.out.println("Erro na execucao do servidor: "+e);
				System.exit(1);
			}
		}
	}
}

