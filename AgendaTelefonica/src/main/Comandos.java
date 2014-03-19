package main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.Scanner;

import Estrutura.ListaOrdenada;
import Estrutura.Nodo;
import Estrutura.Pessoa;

public class Comandos {

    private BufferedReader br;
    public static Scanner sc;


    public void showMenu(){
	System.out.println("\n Menu: \n 1- Adicionar Contato \n 2 - Mostrar Lista\n 3 - Pesquisar Letra\n 4 - Navegar\n 5- Sair\n");

	
    }
    
    public void readAction(Integer cmd) throws IOException{
	if(cmd.equals(1)){
	    add();
	}
	
	if(cmd.equals(2)){
	    showList();
	}
	
	if(cmd.equals(3))
	{
		System.out.println("Entre com o caractere para pesquisar o contato:");
	    String Pesquisa= sc.next();
	    char teste = Pesquisa.charAt(0);
	    PesquisaChar(teste);
	}
	
	if(cmd.equals(4)){
	    surfIntoList();
	}
	
	if(cmd.equals(5)){
	    System.out.println("você saiu do sistema");
	    System.exit(0);
	}
	
	
	
     }
    
    public void add() throws IOException{
	
		 Reader fileReader = new FileReader("Lista_telefonica.txt");
		
		 br = new BufferedReader(fileReader);
		
		 String nome = null;
		 String telefone;
		
		
		 sc = new Scanner(System.in);
		
		 Writer fileWriter = new FileWriter("Lista_telefonica.txt", true);
	
		
		 System.out.println("Nome: ");

		 nome = sc.nextLine()+";".toLowerCase();
		
		
	    
	System.out.println("Telefone: ");
	telefone = sc.nextLine();
	
	boolean insertion = false;

	while (insertion!=true) {
	    
	    	fileWriter.write(nome+" "+telefone);
		fileWriter.append("\n");
		insertion = true;
	}
	
	fileWriter.close();
	
    }
    
  public void showList() throws IOException{
	
      Pessoa ps = new Pessoa();
	
 	 ListaOrdenada<String> lista = new ListaOrdenada<String>();
	
	 Reader fileReader = new FileReader("Lista_telefonica.txt");
	 br = new BufferedReader(fileReader);
	
      
      String line = null;

	
	 while ((line = br.readLine()) != null) {
		
	     String[] breakLine = line.split(";");
	     
	     System.out.println(line);
		
			 String nomePessoa = breakLine[0];//nome
			 String telefonePessoa = breakLine[1];//telefone
			 
			 ps.setNome(nomePessoa.toLowerCase());
			 ps.setTelefone(telefonePessoa);
			 
			 lista.insert(new Nodo<String>("Contato: "+ps.getNome().toUpperCase()+" "+"| Telefone: "+ps.getTelefone()));
		
			 
			
	 }
		System.out.println("\n ++++++++++++++++++++++++++++Forma ordenada:++++++++++++++++++++++++++++ \n");
		lista.print();
      
    }
   
  

  
  	public void PesquisaChar(char c) throws IOException{
  	  
  	  Pessoa ps = new Pessoa();
  	
  	 ListaOrdenada<String> lista = new ListaOrdenada<String>();
 	
 	 Reader fileReader = new FileReader("Lista_telefonica.txt");
 	 br = new BufferedReader(fileReader);
 	
       
       String line = null;

 	
 	 while ((line = br.readLine()) != null) {
 		
 	     String[] breakLine = line.split(";");
 	     
 
 			 String nomePessoa = breakLine[0];//nome
 			 String telefonePessoa = breakLine[1];//telefone
 			 nomePessoa.toLowerCase();
 			
 					 
 			 ps.setNome(nomePessoa.toLowerCase());
 			 ps.setTelefone(telefonePessoa);
 			 
 			lista.insert(new Nodo<String>(ps.getNome().toLowerCase()+" "+ps.getTelefone()));
 			
 			
 	 }
 		System.out.println("----------------");
 		lista.printUniqueChar(c);
  }
  
  	public void surfIntoList() throws IOException{

  	     Pessoa ps = new Pessoa();
  		
  	 	 ListaOrdenada<String> lista = new ListaOrdenada<String>();
  		
  		 Reader fileReader = new FileReader("Lista_telefonica.txt");
  		 br = new BufferedReader(fileReader);
  		
  	      
  	      String line = null;

  		
  		 while ((line = br.readLine()) != null) {
  			
  		     String[] breakLine = line.split(";");
  		     
  		     //	System.out.println(line);
  			
  				 String nomePessoa = breakLine[0];//nome
  				 String telefonePessoa = breakLine[1];//telefone
  				nomePessoa.toLowerCase();
  	 				 
  				 ps.setNome(nomePessoa.toLowerCase());
  				 ps.setTelefone(telefonePessoa);
  				 
  				lista.insert(new Nodo<String>("Contato: "+ps.getNome().toUpperCase()+" "+"| Telefone: "+ps.getTelefone()));
  			
  				
  		 }
  			
  		System.out.println("----------------------------------------------------------------");
		
  		
		do{
		    
		    try{
		    	
			String s = sc.nextLine();
		
		    s.toLowerCase();
		    
		    if(s.equals("a")){
		   lista.upDown++;
		    lista.printAgain();
		 
		}if(s.equals("v")){
		    lista.upDown--;
		    lista.printAgain();
		 
		}
		if(s.equals("s")){
		    break;
		 
		}
		
		System.out.println("\n Menu:(a) proximo contato (v) contato anterior (s) para voltar ao menu inicial  \n"); 
		
		    }catch(Exception e){
		    System.out.println("Entrada Inválida...");
		}
		}while(true);
  	}
  	
  	
}
