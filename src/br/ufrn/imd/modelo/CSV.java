package br.ufrn.imd.modelo;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/*
 * CSV 
 * 
 * Esta classe implementa os métodos necessários
 * à abertura e leitura de um arquivo CSV
 * 
 */

public class CSV {
		
	// Abre, lê e formata um arquivo CSV
	public static ArrayList<String[]> ler(String caminho, String separador){
		
		ArrayList<String[]> conteudo = new ArrayList<String[]>();
		String[] tokens = null;
		BufferedReader csv = null;
		
		try { // Tenta abrir, ler e formatar o arquivo CSV
			
			csv = new BufferedReader(new FileReader(caminho)); // Instancia o objeto de leitura de arquivos
			String linha = csv.readLine(); // Lê o cabeçalho
			
			while((linha = csv.readLine()) != null) { // Lê o resto do conteúdo
				linha = linha.toLowerCase(); // Deixa tudo em minúsculo
				// TODO: remover caracteres especiais
				tokens = linha.split(separador);
				conteudo.add(tokens);
			}
			
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
			
		} catch (IOException e) {
			
	        e.printStackTrace();
	        
	    } finally { // Encerra o objeto BufferdReader
	    	
	        if (csv != null) {
	            try {
	                csv.close();
	            } catch (IOException e) {
	                e.printStackTrace();
	            }
	            
	        }
	    }
		
		return conteudo;
		
	}
	
	// Testando a classe	
	public static void main(String args[]) {
		ArrayList<String[]> dataSet = CSV.ler("data/boatos.csv", ",");
		
		for(String[] linha : dataSet) {
//			for(String subString : linha) {
//				System.out.print(subString + " ");
//			}
			System.out.print(linha[0] + linha[1] + "\n");
		}
	}

}
