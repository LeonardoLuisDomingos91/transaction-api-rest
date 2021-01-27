package br.com.invillia.lyon.transactionapi.controller;

import br.com.invillia.lyon.transactionapi.domain.request.TransactionRequest;
import br.com.invillia.lyon.transactionapi.domain.response.TransactionResponse;
import br.com.invillia.lyon.transactionapi.service.TransactionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transactions")
public class TransactionController {

    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody final TransactionRequest transactionRequest) {
        transactionService.create(transactionRequest);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<TransactionResponse> findById(@PathVariable("id") final Long id) {
        TransactionResponse transactionResponse = transactionService.findById(id);
        return ResponseEntity.ok(transactionResponse);
    }

    @GetMapping
    public List<TransactionResponse> findAllById(@RequestParam("starWarsId") final Long starWarsId) {
         return  transactionService.findAllStarWarsId(starWarsId);
    }

    @PatchMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void cancel(@PathVariable("id") Long id) {
        transactionService.cancelById(id);
    }
}
