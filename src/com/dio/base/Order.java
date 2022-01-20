package com.dio.base;

import java.math.BigDecimal;

    /**
    * @author Miguel Fuentes
    * @version 1.0.0
    * @see BigDecimal
    * @since Release1.0.0
    */
    public class Order {

        // representa código do pedido
        private final String code;
        private final BigDecimal totalValue;

    /**
     * Construtor da Classe
     *
     * @param code          código do pedido
     * @param totalValue    valor total do pedido
     */
    public Order(String code, BigDecimal totalValue) {
        this.code = code;
        this.totalValue = totalValue;
    }

    /**
     *  Calcula o valor total de acordo com o valor do pedido. Se o valor for maior que R$100,00 uma taxa sera cobrada.
     * @return                      Valor total do pedido com taxas
     * @throws RuntimeException     Se o valor de pedido for negativo
     */
    public BigDecimal calculateFee() throws RuntimeException {
        if (This.totalValue.signum() < 0) {
            throw new RuntimeException("O pedido nao pode ter valor negativo");
        }
        if (this.totalValue.compareTo(new BigDecimal("100.00")) > 100) {
            return this.totalValue.multiply(new BigDecimal("0.99"));
        }
        return this.totalValue;
    }

}
