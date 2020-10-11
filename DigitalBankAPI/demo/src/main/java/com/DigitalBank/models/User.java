package com.DigitalBank.models;

import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

@Entity
public class User extends AbstractEntity {

    public interface StepOne {    }
    public interface StepTwo {    }

    @NotEmpty (groups = {StepOne.class})
    private String firstName;
    @NotEmpty (groups = {StepOne.class})
    private String lastName;
    @NotEmpty (groups = {StepOne.class})
    @Email (groups = {StepOne.class})
    @Column(name = "email", nullable = false, unique = true)
    private String email;
    @NotEmpty (groups = {StepOne.class})
    @CPF (groups = {StepOne.class})
    @Column(unique = true)
    private String cpf;
    @NotEmpty (groups = {StepOne.class})
    @Pattern (regexp = "^(?:(?:31(\\/|-|\\.)(?:0?[13578]|1[02]))\\1|(?:(?:29|30)(\\/|-|\\.)(?:0?[13-9]|1[0-2])\\2))(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$|^(?:29(\\/|-|\\.)0?2\\3(?:(?:(?:1[6-9]|[2-9]\\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]|1\\d|2[0-8])(\\/|-|\\.)(?:(?:0?[1-9])|(?:1[0-2]))\\4(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$")
    private String birthDate;
    @NotEmpty (groups = {StepTwo.class})
    @Pattern (regexp = "\\d{5}-\\d{3}", groups = {StepTwo.class})
    private String cep;
    @NotEmpty (groups = {StepTwo.class})
    private String street;
    @NotEmpty (groups = {StepTwo.class})
    private String neighborhood;
    @NotEmpty (groups = {StepTwo.class})
    private String complement;
    @NotEmpty (groups = {StepTwo.class})
    private String city;
    @NotEmpty (groups = {StepTwo.class})
    private String state;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "account_id", referencedColumnName = "id")
    private Account account;


    public User() {
    }

    public User(String firstName, String lastName, String email, String cpf, String birthDate, String street, String cep,
                String neighborhood, String complement, String city, String state, Account account) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.cpf = cpf;
        this.birthDate = birthDate;
        this.street = street;
        this.cep = cep;
        this.neighborhood = neighborhood;
        this.complement = complement;
        this.city = city;
        this.state = state;
        this.account = account;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }

    public String getComplement() {
        return complement;
    }

    public void setComplement(String complement) {
        this.complement = complement;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
