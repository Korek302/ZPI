package com.zpi.server.dbObjects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Entity
@Table(name="students")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value={"createdAt","updateAt"}, allowGetters = true)
public class Student
{
    @Id
    @Column(name="student_id")
    private int _studentID;

    @Column(name="accounts_account_id")
    private int _accountID;

    @Column(name="groups_group_id")
    private int _groupID;

    @Column(name="forename")
    private String _forename;

    @Column(name="surname")
    private String _surname;

    @Column(name="index")
    private String _index;

    public int getStudentID()
    {
        return _studentID;
    }

    public void setStudentID(int studentID)
    {
        this._studentID = studentID;
    }

    public int getAccountID()
    {
        return _accountID;
    }

    public void setAccountID(int accountID)
    {
        this._accountID = accountID;
    }

    public int getGroupID()
    {
        return _groupID;
    }

    public void setGroupID(int groupID)
    {
        this._groupID = groupID;
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

    public String getIndex()
    {
        return _index;
    }

    public void setIndex(String index)
    {
        this._index = index;
    }
}
