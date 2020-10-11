package com.DigitalBank.endpoint;

import com.DigitalBank.models.Account;
import com.DigitalBank.models.User;
import com.DigitalBank.repository.AccountRepository;
import com.DigitalBank.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;


@RestController
@RequestMapping("users")
@SessionAttributes("user")
public class UserEndPoint {

    private final UserRepository userDAO;
    private final AccountRepository accountDAO;


    @Autowired
    public UserEndPoint(UserRepository userDAO, AccountRepository accountDAO) {
        this.userDAO = userDAO;
        this.accountDAO = accountDAO;
    }

    @RequestMapping(value = "stepOne", method = RequestMethod.POST)
    public ResponseEntity<?> stepOne(@Validated(User.StepOne.class) @RequestBody User user) {
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    @RequestMapping(value = "stepTwo", method = RequestMethod.POST)
    public ResponseEntity<?> stepTwo(@Validated(User.StepTwo.class) @RequestBody User user) {
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    @RequestMapping(value = "confirm")
    public ResponseEntity<?> confirm(@Validated({User.StepOne.class, User.StepTwo.class}) @RequestBody User user, Account account, SessionStatus status) {
        status.setComplete();
        user.setAccount(account);
        userDAO.save(user);
        return new ResponseEntity<>(user, HttpStatus.CREATED);

}








}
