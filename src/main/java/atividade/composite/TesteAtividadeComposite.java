
package atividade.composite;

import java.util.Scanner;

/**
 *
 * @author danielkorban
 */
public class TesteAtividadeComposite {
    public static void main(String[] args){
        String caminho;
        Scanner entrada = new Scanner(System.in);
        
        System.out.println("Entre com o nome do arquivo ou diretório:");
        caminho = entrada.nextLine();
        
        Elemento sistemaDeArquivos = ElementoFactory.criarElemento(caminho);
        
        System.out.println("Tamanho total de arquivo(s) em diretorio(s): " + sistemaDeArquivos.tamanho() +" Bytes");
        
    }
}