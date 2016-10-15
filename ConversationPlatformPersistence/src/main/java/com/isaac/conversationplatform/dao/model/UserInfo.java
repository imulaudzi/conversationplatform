package com.isaac.conversationplatform.dao.model;

import com.isaac.conversationplatform.dao.model.enums.AccountStatus;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * Created by isaac on 2016/09/06.
 */
@Entity
@Table(name = "USER_DETAILS")
public class UserInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "USER_ID")
    private Long userId;
    @Column(name = "NAME")
    private String name;
    @Column(name = "SURNAME")
    private String surname;
    @Column(name = "DISPLAY_NAME")
    private String displayName;
    @Column(name = "DATE_OF_BIRTH")
    private LocalDateTime dateOfBirth;
    @Column(name = "EMAIL_ADDRESS")
    private String emailAddress;
    @Column(name = "ID_NUMBER")
    private String IDnumber;
    @Column(name = "ACCOUNT_STATUS")
    @Enumerated(EnumType.STRING)
    private AccountStatus accountStatus;
    @Column(name = "REGISTERED_ON")
    private LocalDateTime registeredOn;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public LocalDateTime getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDateTime dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getIDnumber() {
        return IDnumber;
    }

    public void setIDnumber(String IDnumber) {
        this.IDnumber = IDnumber;
    }

    public AccountStatus getAccountStatus() {
        return accountStatus;
    }

    public void setAccountStatus(AccountStatus accountStatus) {
        this.accountStatus = accountStatus;
    }

    public LocalDateTime getRegisteredOn() {
        return registeredOn;
    }

    public void setRegisteredOn(LocalDateTime registeredOn) {
        this.registeredOn = registeredOn;
    }
}
