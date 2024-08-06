package com.org.practice.repository;

import java.util.List;

import com.org.practice.model.AccountTransaction;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AccountTransactionsRepository extends CrudRepository<AccountTransaction, String> {

    List<AccountTransaction> findByCustomerIdOrderByTransactionDtDesc(long customerId);

}