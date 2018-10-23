import java.util.*;

public class Race {

	private static ArrayList<Integer> Grelha = new ArrayList<Integer>();
	private static int volta = 1;
    private static int atualizacoes = 1;

	    
	public static void main(String[] args) throws InterruptedException{
	    Scanner teclado = new Scanner(System.in);
        boolean fim = true;
	        
        System.out.println(" *-----------------------------* ");
	    System.out.println(" |   Configuracao da Corrida   | ");
	    System.out.println(" *-----------------------------* ");
	    int quantcarros;
	    do{
	            
	        System.out.print("  Quatidade de participantes: ");
	        quantcarros = teclado.nextInt();
	            
	        if(quantcarros >= 2 && quantcarros <= 20){
	            fim = false;
	        }else{
	            System.err.println("A quantidade de participantes tem como maximo 20 e como minimo 2!");
            }
                
        }while(fim);
			
	        System.out.println("");
	        System.out.println("Por favor insira os carros pela ordem da grelha de partida");
	        
	        for(int i =0;i< quantcarros;i++){  // Vai adicionar os Numeros dos Carros a Grelha de partida
                boolean val = true;
                do{  // Não permite a repetição dos numeros dos carros
	                System.out.print(" Numero do carro na "+ (i + 1) +" posicao: ");
                    int num = teclado.nextInt();
                    if(Grelha.contains(num)){
                        System.err.println("O numero de carro inserido ja esta declarado!");
                    }else{
                        addGrelha(num);
                        val = false;
                    }
                }while(val);
	        }
	        
            imprimir();
          //teste  actualizacaoCliente(10, 15, 10);
	    }

	    public static void ultrapassar(int ultrapassou, int ultrapassado){
            int indexUltrapassou = Grelha.indexOf(ultrapassou);
            int indexUltrapassado = Grelha.indexOf(ultrapassado);
            
            Grelha.set(indexUltrapassado, ultrapassou);
            Grelha.set(indexUltrapassou, ultrapassado);
        }
	    
	    public static void addGrelha(int carro){   
            Grelha.add(carro);
        }
		
	    public static void setVolta(int numvolta) {
	    	if(volta > numvolta){
	    		
	    	}else {
	    	    volta = numvolta;
	    	}
	    	
	    }
	    
	    public static void updateActualizacoes() {
	    	atualizacoes +=1;
	    }	    
        
        public static void actualizacaoCliente(int ultrapassou, int ultrapassado, int volta){
            ultrapassar(ultrapassou,ultrapassado);
            setVolta(volta);
            updateActualizacoes();
            imprimir();
        }

        //  Metodo na Classe Errada  //
        public static void imprimir(){  // Imprime a Grelha atual da Corrida
            String espVolta;
            if(volta < 10){
                espVolta = "          | ";
            }else{
                espVolta = "         | ";
            }
            
            System.out.println("");
	        System.out.println(" *---------------------------* ");
	        System.out.println(" |      GP de Portugal       | ");
	        System.out.println(" |         Volta: " + volta + espVolta);
	        System.out.println(" *---------------------------* ");
	        for(int i = 0; i<Grelha.size();i++){
	        	int car = Grelha.get(i);

	            
	            int posicao = i + 1;
	            String espaco2 = "";
	            
	            String espaco;
	            if(posicao < 10){
	                espaco = "   ";
	            }else{
	                espaco = "  ";
	            }
	            
	            String espaco3;
	            if(String.valueOf(car).length() < 2){
	                espaco3 = "  ";
	            }else{
	                espaco3 = " ";
	            }
	                
	            for(int j = 0; j<(24 - String.valueOf(posicao).length() - espaco.length()- espaco3.length()- String.valueOf(car).length());j++){
	                espaco2 += " ";
	            }
	            System.out.println(" | " + posicao + " -" + espaco + car + espaco3 + espaco2 +"| ");
	        }
	        
            System.out.println(" *---------------------------* ");
	        System.out.println(" |      Atualizacoes: " + atualizacoes + "      | ");
	        System.out.println(" *---------------------------* ");
	    }
}