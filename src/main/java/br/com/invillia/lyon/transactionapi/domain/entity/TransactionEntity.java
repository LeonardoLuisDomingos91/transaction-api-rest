package br.com.invillia.lyon.transactionapi.domain.entity;

import br.com.invillia.lyon.transactionapi.domain.enumeration.TransactionStatus;
import br.com.invillia.lyon.transactionapi.domain.enumeration.TransactionType;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name="TRANSACTION_ENTITY")
public class TransactionEntity {

    public TransactionEntity() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="STAR_WARS_ID", nullable = false)
    private Long starWarsId;

    @Column(name="TRANSACTION_VALUE", nullable = false)
    private Double value;

    @Enumerated(EnumType.STRING)
    @Column(name="TYPE", nullable = false)
    private TransactionType type;

    @Enumerated(EnumType.STRING)
    @Column(name="STATUS", nullable = false)
    private TransactionStatus status;

    @CreationTimestamp
    @Column(name = "DATE_CREATION", columnDefinition = "DATE", updatable = false)
    private LocalDateTime creationDate;

    @UpdateTimestamp
    @Column(name = "DATE_UPDATE", columnDefinition = "DATE")
    private LocalDateTime updateDate;
}
