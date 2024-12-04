package org.voting.votingbackend.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Team {
    @Id
    private int TEAM_ID;
    private String TEAM_NAME;
    private Enum<Type> TYPE;

    public Team() {

    }

    public int getTEAM_ID() {
        return TEAM_ID;
    }

    public void setTEAM_ID(int TEAM_ID) {
        this.TEAM_ID = TEAM_ID;
    }

    public String getTEAM_NAME() {
        return TEAM_NAME;
    }

    public void setTEAM_NAME(String TEAM_NAME) {
        this.TEAM_NAME = TEAM_NAME;
    }

    public Enum<Type> getTYPE() {
        return TYPE;
    }

    public void setTYPE(Enum<Type> TYPE) {
        this.TYPE = TYPE;
    }
}
