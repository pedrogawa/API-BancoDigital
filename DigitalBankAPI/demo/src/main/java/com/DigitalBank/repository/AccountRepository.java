package com.DigitalBank.repository;

import com.DigitalBank.models.Account;
import org.springframework.data.repository.CrudRepository;

public interface AccountRepository extends CrudRepository<Account, Long> {
}
