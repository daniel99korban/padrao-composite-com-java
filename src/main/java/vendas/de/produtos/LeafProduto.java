
package vendas.de.produtos;

import lombok.*;
/**
 *
 * @author danielkorban
 */
@Builder
public class LeafProduto extends Componente{
    
    private String nome;
    private double valor;

    @Override
    public double calcularValor() {
        return this.valor;
    }
    
}
