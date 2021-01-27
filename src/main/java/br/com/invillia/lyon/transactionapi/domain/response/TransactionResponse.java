package br.com.invillia.lyon.transactionapi.domain.response;

import br.com.invillia.lyon.transactionapi.domain.enumeration.TransactionStatus;
import br.com.invillia.lyon.transactionapi.domain.enumeration.TransactionType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class TransactionResponse {

    private Long starWarsId;

    private Double value;

    private TransactionType type;

    private TransactionStatus status;

}
