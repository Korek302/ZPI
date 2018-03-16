package com.zpi.server.dbObjects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Entity
@Table(name="applications")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value={"createdAt","updateAt"}, allowGetters = true)
public class Application
{
    @Id
    @Column(name="application_id")
    private int _applicationID;

    @Column(name="students_student_id")
    private int _studentID;

    @Column(name="groups_group_id")
    private int _groupID;

    @Column(name="is_viewed")
    private int _isViewed;

    @Column(name="is_confirmed")
    private int _isConfirmed;

    public int getApplicationID() {
        return _applicationID;
    }

    public void setApplicationID(int applicationID)
    {
        this._applicationID = applicationID;
    }

    public int getStudentID()
    {
        return _studentID;
    }

    public void setStudentID(int studentID)
    {
        this._studentID = studentID;
    }

    public int getGroupID()
    {
        return _groupID;
    }

    public void setGroupID(int groupID)
    {
        this._groupID = groupID;
    }

    public int getIsViewed()
    {
        return _isViewed;
    }

    public void setIsViewed(int isViewed)
    {
        this._isViewed = isViewed;
    }

    public int getIsConfirmed()
    {
        return _isConfirmed;
    }

    public void setIsConfirmed(int isConfirmed)
    {
        this._isConfirmed = isConfirmed;
    }
}
