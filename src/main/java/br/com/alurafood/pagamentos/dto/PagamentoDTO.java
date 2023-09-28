package br.com.alurafood.pagamentos.dto;

import br.com.alurafood.pagamentos.model.Status;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class PagamentoDTO {
	
    private Long id;
    private BigDecimal valor;
    private String nome;
    private String numeroCartao;
    private String expiracaoCartao;
    private String codigoCartao;
    private Status status;
    private Long formaDePagamentoId;
    private Long pedidoId;
}
