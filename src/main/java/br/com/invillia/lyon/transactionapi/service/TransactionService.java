package br.com.invillia.lyon.transactionapi.service;

import br.com.invillia.lyon.transactionapi.domain.entity.TransactionEntity;
import br.com.invillia.lyon.transactionapi.domain.enumeration.TransactionStatus;
import br.com.invillia.lyon.transactionapi.domain.mapper.TransactionMapper;
import br.com.invillia.lyon.transactionapi.domain.request.TransactionRequest;
import br.com.invillia.lyon.transactionapi.domain.response.TransactionResponse;
import br.com.invillia.lyon.transactionapi.exception.ResourceNotFoundException;
import br.com.invillia.lyon.transactionapi.repository.TransactionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TransactionService{

    private final TransactionRepository transactionRepository;

    private final TransactionMapper transactionMapper;

    public TransactionService(TransactionRepository transactionRepository, TransactionMapper transactionMapper) {
        this.transactionRepository = transactionRepository;
        this.transactionMapper = transactionMapper;
    }

    public void create(final TransactionRequest transactionRequest) {
        final TransactionEntity transactionEntity = transactionMapper.fromTransactionRequestToTransactionEntity(transactionRequest);

        transactionRepository.save(transactionEntity);
    }

    public TransactionResponse findById(final Long transactionId) {
        final TransactionEntity transactionEntity = transactionRepository.findById(transactionId)
                .orElseThrow(() -> new ResourceNotFoundException("No record found for this ID"));

        return transactionMapper.fromTransactionEntityToTransactionResponse(transactionEntity);
    }

    public List<TransactionResponse> findAllStarWarsId(final Long starWarsId) {
       final List<TransactionEntity> transactionEntityList = transactionRepository.findByStarWarsId(starWarsId);

       return transactionEntityList.stream()
               .map(transactionMapper::fromTransactionEntityToTransactionResponse)
               .collect(Collectors.toList());
    }

    public void cancelById(final Long id) {
       final TransactionEntity transactionEntity = transactionRepository.findById(id)
               .orElseThrow(() -> new ResourceNotFoundException("No record found for this ID"));

        transactionEntity.setStatus(TransactionStatus.CANCELED);

        transactionRepository.save(transactionEntity);
    }
}
