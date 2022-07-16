
package atividade.composite;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author danielkorban
 */
public class Diretorio extends Elemento{
    
    private List<Diretorio> diretorio;
    private List<Arquivo> arquivos;
    
    public Diretorio(String caminho) {
        super(caminho);
        this.diretorio = new ArrayList<>();
        this.arquivos = new ArrayList<>();
    }

    @Override
    public long tamanho() { 
         long tamanho = 0;
         File diretorio = new File(caminho);
         // obter Arquivos no diretorio
         File[] arquivos = diretorio.listFiles();
         // percorer diretorio e somar tamanhos dos arquivos
         for(int i = 0; i < arquivos.length; i++){
             Path path = Paths.get(arquivos[i].getPath());
             
             // verificar se é um diretorio
             if(Files.isDirectory(path)){
                 Elemento novDir = ElementoFactory.criarElemento(arquivos[i].getPath());
                 this.diretorio.add((Diretorio) novDir); 
                 tamanho += novDir.tamanho();
                 
             }else{
                try {
                    // contar tamanho de cada arquivo
                    Elemento novArq = ElementoFactory.criarElemento(arquivos[i].getPath());
                    this.arquivos.add((Arquivo) novArq); 
                    tamanho += Files.size(path);
                } catch (IOException ex) {
                    System.err.println("Erro ao ler arquivo: " + ex.getMessage());
                }
             }
         }
        return tamanho;
    }

}
