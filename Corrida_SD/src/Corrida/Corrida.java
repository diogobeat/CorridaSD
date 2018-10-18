package Corrida;
import java.util.Scanner;

public class Corrida {
	
	/** 
	 * @author Tiago
	 * 
	 * {@link #imprimir()}
	 *
	 */
	
	    private static int[] Grelha;
	    private static int contador = 0;
	    private static int quantcarros;
	    private int volta;
	    private int atualizacoes;

	    
	    public static void main(String[] args) throws InterruptedException{
	        Scanner teclado = new Scanner(System.in);
	        boolean bool = true;
	        
	        System.out.println(" *-----------------------------* ");
	        System.out.println(" |   Configura��o da Corrida   | ");
	        System.out.println(" *-----------------------------* ");
	        
	        do{
	            
	            System.out.print("  Quatidade de participantes: ");
	            int quant = teclado.nextInt();
	            quantcarros = quant;
	            
	            if(quant >= 2 && quant <= 20){
	                bool = false;
	            }else{
	                System.err.println("A quantidade de participantes tem como maximo 20 e como minimo 2!!!");
	            }
	            
	        }while(bool);
	            
	        Grelha = new int[quantcarros];
	        
	        System.out.println("Por favor insira os carros pela ordem da grelha de partida");
	        
	        for(int i =0;i< quantcarros;i++){
	            System.out.print(" Numero do carro na "+ (i + 1) +" posi�ao: ");
	            int num = teclado.nextInt();
	            addGrelha(num);
	        }
	        
	        imprimir();
	    } // Main
	    
	    

	    public static void ultrapassar(int pos2, int pos1){ // a pos2 ultrapassa a pos1
	       int ult = Grelha[pos1 - 1];
	       Grelha[pos1 - 1] = Grelha[pos2 - 1];
	       Grelha[pos2 - 1] = ult;
	    }
	    
	    public static void addGrelha(int carro){
	        Grelha[contador] = carro;
	        contador++;
	    }
	    
	    public void setVolta(int volta) {
	    	if(this.volta > volta){
	    		
	    	}else {
	    	this.volta = volta;
	    	}
	    	
	    }
	    
	    public void update() {
	    	this.atualizacoes +=1;
	    }
	    
	    public static void atualizar(){
	        imprimir();
	    }
	    
	    
	    
	    public static void imprimir(){  // Imprime a Grelha atual da Corrida
	        String lim = " | ";
	        System.out.println(" *-----------------------------* ");
	        System.out.println(" |       GP de Portugal        | ");
	        System.out.println(" |          Volta: 1           | ");
	        System.out.println(" *-----------------------------* ");
	        for(int i = 0; i<quantcarros;i++){
	        	int car = Grelha[i];

	            
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
	                
	            for(int j = 0; j<(26 - String.valueOf(posicao).length() - espaco.length()- espaco3.length()- String.valueOf(car).length());j++){
	                espaco2 += " ";
	            }
	            System.out.println(lim + posicao + "�" + espaco + car + espaco3 + espaco2 +lim);
	        }
	        
	        System.out.println(" *-----------------------------* ");
	    }
}