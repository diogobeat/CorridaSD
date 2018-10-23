import java.util.*;
import java.net.*;
import java.io.*;

public class RaceClient {
	
	static final int DEFAULT_PORT=8082;
	static final String DEFAULT_HOST="127.0.0.1"; 
	static String nomeCliente;

	public static void main(String[] args) {
		String servidor=DEFAULT_HOST;
		int porto=DEFAULT_PORT;
		
		if (args.length != 1) {
				System.out.println("Erro: use java RaceClient <Username>");
				System.exit(-1);
		}
		nomeCliente = args[0];
	
		//Cria um objecto da classe InetAddress com base no nome do servidor
		InetAddress endereco = null;
		try {
			endereco = InetAddress.getByName(servidor);
		} catch (UnknownHostException e) {
			System.out.println("Endereco desconhecido: "+e);
			System.exit(-1);
		}

		System.out.println("Vai ligar ao porto "+porto+" da maquina "+endereco.getHostName());

		Socket ligacao = null; 
		
		try {
			ligacao = new Socket(endereco, porto);
		} catch (Exception e) {
			System.err.println("erro ao criar socket...");
			e.printStackTrace();
			System.exit(-1);
		}

		System.out.println("Ligado ao porto " + porto + " no endereco " + endereco.getHostName());
		System.out.println("");

		try {
			BufferedReader in = new BufferedReader (new InputStreamReader(ligacao.getInputStream()));
 
			PrintWriter out = new PrintWriter(ligacao.getOutputStream());
			// Opcoes para User
			String request = "get" + " " + args[0];   // Cria a mensagem que vai enviar para o ServerHandler
			
			out.println(request);  // Envia a mensagem para o Handler
			out.flush();
			
			String msg;
			while ((msg = in.readLine())!= null)
				System.out.println("Resposta do servidor: " + msg);
			
			ligacao.close();
			System.out.println("Terminou a ligacao!");
		} catch (IOException e) {
			System.out.println("Erro ao comunicar com o servidor: "+e);
			System.exit(1);
		}
	
	}

	public static byte[] dadosArray(int ultrapassou, int ultrapassado, int numVolta, String cliente, int actualizacoes) throws java.io.IOException {
		int tamNome = cliente.length();
		int tamArray = 5 + tamNome;
		
		byte data[] = cliente.getBytes("US-ASCII");

		byte[] array = new byte[tamArray];
		try {
		array[0] = new Integer(ultrapassou).byteValue();
		array[1] = new Integer(ultrapassado).byteValue();
		array[2] = new Integer(numVolta).byteValue();
		array[3] = new Integer(tamNome).byteValue();

		for(int i = 0; i < data.length; i++){
			array[4+i] = data[i];
		}

		array[tamArray - 1] = new Integer(actualizacoes).byteValue();
		}catch(Exception e){
			System.out.println("Erro no metodo.");
			System.exit(1);
		}

		return array;
	}
}


