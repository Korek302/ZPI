package com.zpi.server.dbObjects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Entity
@Table(name="lecturers")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value={"createdAt","updateAt"}, allowGetters = true)
public class Lecturer
{
    @Id
    @Column(name="lecturer_id")
    private int _lecturerID;

    @Column(name="accounts_account_id")
    private int _accountID;

    @Column(name="forename")
    private String _forename;

    @Column(name="surname")
    private String _surname;

    @Column(name="title")
    private String _title;

    public int getLecturerID()
    {
        return _lecturerID;
    }

    public void setLecturerID(int lecturerID)
    {
        this._lecturerID = lecturerID;
    }

    public int getAccountID()
    {
        return _accountID;
    }

    public void setAccountID(int accountID)
    {
        this._accountID = accountID;
    }

    public String getForename()
    {
        return _forename;
    }

    public void setForename(String forename)
    {
        this._forename = forename;
    }

    public String getSurname()
    {
        return _surname;
    }

    public void setSurname(String surname)
    {
        this._surname = surname;
    }

    public String getTitle()
    {
        return _title;
    }

    public void setTitle(String title)
    {
        this._title = title;
    }
}
