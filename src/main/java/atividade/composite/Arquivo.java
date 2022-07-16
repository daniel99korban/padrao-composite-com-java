
package atividade.composite;

import java.io.IOException;
import java.nio.file.*;

/**
 *
 * @author danielkorban
 */
public class Arquivo extends Elemento{
    
    private String nome;

    public String getNome() {
        return nome;
    }

    public Arquivo(String caminho) {
        super(caminho);
    }
    
    @Override
    public long tamanho() {
        try {
            // Criar objeto Path com a entrada fornecida pelo usuário
            Path path = Paths.get(caminho);
            this.nome = path.getFileName() + "";
            return Files.size(path);
        } catch (IOException ex) {
            System.err.println("Erro ao ler arquivo: " + ex.getMessage());
        }
        return 0;
    }
    
}
