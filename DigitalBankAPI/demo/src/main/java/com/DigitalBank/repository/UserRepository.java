package com.DigitalBank.repository;

import com.DigitalBank.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
    User findByCpf(String cpf);
}
