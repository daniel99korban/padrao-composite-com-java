
package atividade.composite;

import java.io.File;

/**
 *
 * @author danielkorban
 */
public class ElementoFactory {
    
    public static Elemento criarElemento(String caminho){
        
        File file = new File(caminho);
        
        if(file.isFile()){
            return new Arquivo(caminho);
        }else if(file.isDirectory()){
            return new Diretorio(caminho);
        }else{    
            System.out.println("caminho invalido!");
        }
        return null;
    }
}
