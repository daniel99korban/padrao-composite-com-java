
package atividade.composite;

/**
 *
 * @author danielkorban
 */
public abstract class Elemento {
    
    String caminho;

    public void setCaminho(String caminho) {
        this.caminho = caminho;
    }
    
    public Elemento(String caminho){
        this.caminho = caminho;
    }
    /**
     * @return tamanho em bytes do arquivo
     * ou diretório correspondente. No caso de um diretório, o tamanho é dado pela soma dos tamanhos de
     * todos os arquivos contidos no diretório e eventuais subdiretórios.
     */
    public abstract long tamanho();
}
