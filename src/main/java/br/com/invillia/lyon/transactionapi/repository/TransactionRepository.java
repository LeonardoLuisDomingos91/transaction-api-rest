package br.com.invillia.lyon.transactionapi.repository;

import br.com.invillia.lyon.transactionapi.domain.entity.TransactionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<TransactionEntity, Long> {

    List<TransactionEntity> findByStarWarsId(Long id);

}
