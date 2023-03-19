package com.application.wallet;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.*;
@Entity
@PropertySource("classpath:application.properties")
public class WalletDto {



//    @NotNull(message = "Id cannot be null")
    @Id
    @GeneratedValue
    private Integer id;

    @NotBlank(message = "Name should not be blank")
    @Pattern(regexp = "[A-Za-z0-9]{3,16}",message = "Name should be between 3-16 characters and no special characters allowed")
    private String name;
    @Value("1000.0")
    private Double balance;

    @Email(message = "Enter valid email")
    private String email;

    @NotBlank(message = "Password should not be blank")
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&*()_+\\-={}\\[\\]|;:'\'<>,./?])(?=.*[a-zA-Z]).{8,}$",
            message = "Password should contain one lowercase, one uppercase character,atleast one digit and one special character, it must not contain whitespace and must be minimum 8 characters long.")
    private String password;



    public WalletDto(Integer id, String name, Double balance, String email, String password){
        this.id = id;
        this.email = email;
        this.name = name;
        this.balance = balance;
        this.password = password;
    }

    public WalletDto() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "WalletDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", balance=" + balance +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
