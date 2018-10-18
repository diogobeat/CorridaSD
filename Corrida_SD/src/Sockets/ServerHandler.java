package Sockets;

/* recebe atraves da ligação estabelecida:											*/
/*	- um byte que indica o tamanho de uma mensagem em decimal, N;					*/
/*	- os N bytes que correspondem aos carateres ASCII que constituem a mensagem.		*/

import java.net.*;
import java.io.*;
import java.util.*;
import java.lang.*;

public class ServerHandler extends Thread {
	Socket ligacao;
	InputStream in;

	public ServerHandler(Socket ligacao) {
		this.ligacao = ligacao;
		
		
		
		
		
				
		try
		{	// cria uma InputStream para ler os dados que chegam do socket
			this.in = ligacao.getInputStream();
			
		} catch (IOException e) {
			System.out.println("Erro na execucao do servidor: " + e);
			System.exit(1);
		}
	}
	
	public void run() {                
		try {
			
			byte data[] = new byte[100];
			
			//le o tamanho da mensagem (valor decimal do primeiro byte)
			byte b = (byte) in.read();
			
			// converte o tamanho (byte) em integer
			int length = new Byte(b).intValue();
			
			// imprime o tamanho da mensagem em binario e decimal em System.out
			System.out.println(Integer.toBinaryString(length) + "	" + length + "\n");
			
			// le length bytes da stream para o array de bytes "data"				
			length = in.read(data,0,length);

 			//imprime em System.out os bytes do array "data" em binario e decimal (0-127)
 			for(int i=0; i<length; i++)
 				System.out.println(Integer.toBinaryString(new Byte(data[i]).intValue()) + "	" + new Byte(data[i]).intValue());

			// transforma o array de bytes "data" numa string e imprime em System.out
 			String msg = new String(data);
 			System.out.println("\n" + msg);
			
			in.close();
			ligacao.close();	
			
		} catch (IOException e) {
			System.out.println("Erro na execucao do servidor: " + e);
			System.exit(1);
		}
	}
}