package com.zpi.server.dbObjects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Entity
@Table(name="groups")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value={"createdAt","updateAt"}, allowGetters = true)
public class Group
{
    @Id
    @Column(name="group_id")
    private int _groupID;

    @Column(name="lecturers_lecturer_id")
    private int _lecturerID;

    @Column(name="topic")
    private String _topic;

    @Column(name="members_number")
    private int _membersNumber;

    @Column(name="invitations_number")
    private  int _invitationNumber;

    public int getGroupID()
    {
        return _groupID;
    }

    public void setGroupID(int groupID)
    {
        this._groupID = groupID;
    }

    public int getLecturerID()
    {
        return _lecturerID;
    }

    public void setLecturerID(int lecturerID)
    {
        this._lecturerID = lecturerID;
    }

    public String getTopic()
    {
        return _topic;
    }

    public void setTopic(String topic)
    {
        this._topic = topic;
    }

    public int getMembersNumber()
    {
        return _membersNumber;
    }

    public void setMembersNumber(int membersNumber)
    {
        this._membersNumber = membersNumber;
    }

    public int getInvitationNumber()
    {
        return _invitationNumber;
    }

    public void setInvitationNumber(int invitationNumber)
    {
        this._invitationNumber = invitationNumber;
    }

}
