package br.com.invillia.lyon.transactionapi.domain.mapper;

import br.com.invillia.lyon.transactionapi.domain.entity.TransactionEntity;
import br.com.invillia.lyon.transactionapi.domain.enumeration.TransactionStatus;
import br.com.invillia.lyon.transactionapi.domain.request.TransactionRequest;
import br.com.invillia.lyon.transactionapi.domain.response.TransactionResponse;
import org.springframework.stereotype.Component;

@Component
public class TransactionMapper {

    public TransactionEntity fromTransactionRequestToTransactionEntity(final TransactionRequest transactionRequest) {
        TransactionEntity transactionEntity = new TransactionEntity();

        transactionEntity.setStarWarsId(transactionRequest.getStarWarsId());
        transactionEntity.setValue(transactionRequest.getValue());
        transactionEntity.setType(transactionRequest.getType());
        transactionEntity.setStatus(TransactionStatus.PENDING);

        return transactionEntity;
    }

    public TransactionResponse fromTransactionEntityToTransactionResponse(final TransactionEntity transactionEntity) {
        TransactionResponse transactionResponse = new TransactionResponse();

        transactionResponse.setStarWarsId(transactionEntity.getStarWarsId());
        transactionResponse.setValue(transactionEntity.getValue());
        transactionResponse.setType(transactionEntity.getType());
        transactionResponse.setStatus(transactionEntity.getStatus());

        return transactionResponse;
    }

}
