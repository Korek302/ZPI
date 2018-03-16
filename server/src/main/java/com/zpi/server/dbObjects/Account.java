package com.zpi.server.dbObjects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Entity
@Table(name="accounts")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value={"createdAt","updateAt"}, allowGetters = true)
public class Account
{
    @Id
    @Column(name="account_id")
    private int _accountID;

    @Column(name="login")
    private String _login;

    @Column(name="password")
    private String _password;

    @Column(name="user_type")
    private String _userType;

    public int getAccountID() {
        return _accountID;
    }

    public void setAccountID(int accountID)
    {
        this._accountID = accountID;
    }

    public String getLogin()
    {
        return _login;
    }

    public void setLogin(String login)
    {
        this._login = login;
    }

    public String getPassword()
    {
        return _password;
    }

    public void setPassword(String password)
    {
        this._password = password;
    }

    public String getUserType()
    {
        return _userType;
    }

    public void setUserType(String userType)
    {
        this._userType = userType;
    }
}
