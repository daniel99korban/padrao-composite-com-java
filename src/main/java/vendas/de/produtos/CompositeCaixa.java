package vendas.de.produtos;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author danielkorban
 */
public class CompositeCaixa extends Componente{

    private List<LeafProduto> produtos;
    private List<CompositeCaixa> caixa;
    
    public CompositeCaixa(){
        this.produtos = new ArrayList<>();
        this.caixa = new ArrayList<>();
    }
    
    public void adicionarProduto(LeafProduto produto){
        this.produtos.add(produto);
    }
    
    public void removerProduto(LeafProduto produto){
        this.produtos.remove(produto);
    }
    /**
     * Metodo para adicionar uma caix contendo produtos ou não
     * @param caixa 
     */
    public void adicionarCaixa(CompositeCaixa caixa){
        this.caixa.add(caixa);
    }

    @Override
    public double calcularValor() {
        double valorTotal = 0.0;
        
        for(LeafProduto produto : this.produtos){
            valorTotal += produto.calcularValor();
        }
        
       if(this.caixa!=null){
            
            System.out.println("foi cobrada uma taxa de 2 R$ pela embalagem");
            valorTotal += 2;
            
            for(CompositeCaixa c : this.caixa){
                valorTotal += c.calcularValor();
            }
            
        }
        
        return valorTotal;
    }
    
    
    
}
