
package vendas.de.produtos;

/**
 *
 * @author danielkorban
 */
public class TesteComposite {
    public static void main(String[] args) {
        
        Componente celular = LeafProduto.builder().nome("Celular").valor(700).build();
        Componente carregador = LeafProduto.builder().nome("Carregador").valor(20).build();
        Componente fones = LeafProduto.builder().nome("Fones de ouvido").valor(10).build();
        Componente caixinhaDeSom = LeafProduto.builder().nome("caixinha de som").valor(30).build();
        
        // Embalagens dos produtos
        var caixaDoCelular = new CompositeCaixa();
        var caixaComCarregadorEFones = new CompositeCaixa();
        var caixaComCaixinhaECarregador = new CompositeCaixa();
        
        // Embalagens principal contedo os produtos e caixas com produtos
        var caixaContainner = new CompositeCaixa();
       
        // embalando os produtos
        caixaDoCelular.adicionarProduto((LeafProduto) celular);
        caixaComCarregadorEFones.adicionarProduto((LeafProduto) carregador);
        caixaComCarregadorEFones.adicionarProduto((LeafProduto) fones);
        caixaComCaixinhaECarregador.adicionarProduto((LeafProduto) caixinhaDeSom);
        caixaComCaixinhaECarregador.adicionarProduto((LeafProduto) carregador);
        
        // adicionar no containner
        caixaContainner.adicionarCaixa(caixaComCarregadorEFones);
        caixaContainner.adicionarCaixa(caixaDoCelular);
        caixaContainner.adicionarCaixa(caixaComCaixinhaECarregador);
        
        // calcular e exibir preço total dos produtos
        System.out.println("O valor total de produtos é : " + caixaContainner.calcularValor());
        
    }
}
