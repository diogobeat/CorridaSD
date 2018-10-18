package Sockets;

/* Cria uma ligação com o servidor byteServer e envia:								*/
/*	-  um byte que indica o tamanho	de uma mensagem em decimal, N;					*/
/*	-  os N bytes que correspondem aos carateres ASCII que constituem a mensagem	*/ 											
import java.util.*;
import java.net.*;
import java.io.*;
import java.lang.*;

public class byteClient {

	public static void main(String[] args) {
		String servidor="127.0.0.1";
		int porto=8081;
		
		//Cria um objecto da classe InetAddress com base no nome do servidor
		InetAddress endereco = null;
		try {
			endereco = InetAddress.getByName(servidor);
		} catch (UnknownHostException e) {
			System.out.println("Endereco desconhecido: "+e);
			System.exit(-1);
		}

		//Cria um socket chamada ligacao e estabelece a ligacao indicada	
		Socket ligacao = null; 
		
		try {
			ligacao = new Socket(endereco, porto);
		} catch (Exception e) {
			System.err.println("erro ao criar socket...");
			e.printStackTrace();
			System.exit(-1);
		}

		try {
			//cria uma InputStream para ler os dados que chegam do socket
			//ßInputStream in = ligacao.getInputStream();
 
			//cria uma OutputStream para escrever para o socket
			OutputStream out = ligacao.getOutputStream();
			
			// vai enviar uma mensagem de lenght caracteres
			String msg = "ola mundo";
			int length = msg.length();
			
			// converte o tamanho da mensagem em byte
			byte b = new Integer(length).byteValue();	
			
			// converte a string num array de bytes US-ASCII
			byte data[] = msg.getBytes("US-ASCII");
			
			// imprime o tamanho da mensagem em binario e decimal
			System.out.println(Integer.toBinaryString(new Byte(b).intValue()) + "	" + new Byte(b).intValue() + " \n");
			
			//imprime em System.out os bytes do array "data" em binario e decimal (0-127)
 			for(int i=0; i<data.length; i++)
 				System.out.println(Integer.toBinaryString(new Byte(data[i]).intValue()) + "	" + new Byte(data[i]).intValue());
						
			//escreve o byte b - tamanho da mensagem - no socket
			out.write(b);
			
			//escreve o array de bytes "data" - mensagem codificada em carateres ASCII - no socket
			out.write(data);
			out.flush();	
			
			//termina a ligacao
			ligacao.close();
		} catch (IOException e) {
			System.out.println("Erro ao comunicar com o servidor: "+e);
			System.exit(1);
		}
	
	}
}


