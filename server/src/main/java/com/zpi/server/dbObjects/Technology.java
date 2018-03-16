package com.zpi.server.dbObjects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Entity
@Table(name="students")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value={"createdAt","updateAt"}, allowGetters = true)
public class Technology
{
    @Id
    @Column(name="technology_id")
    private int _technologyID;

    @Column(name="technology_name")
    private String _technologyName;

    public int getTechnologyID()
    {
        return _technologyID;
    }

    public void setTechnologyID(int technologyID)
    {
        this._technologyID = technologyID;
    }

    public String getTechnologyName()
    {
        return _technologyName;
    }

    public void setTechnologyName(String technologyName)
    {
        this._technologyName = technologyName;
    }
}
