package br.com.invillia.lyon.transactionapi.domain.request;

import br.com.invillia.lyon.transactionapi.domain.enumeration.TransactionType;
import lombok.Data;

@Data
public class TransactionRequest {

    private Long starWarsId;

    private Double value;

    private TransactionType type;
}
