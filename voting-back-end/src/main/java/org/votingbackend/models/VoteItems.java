package org.votingbackend.models;

import jakarta.persistence.*;

@Entity
public class VoteItems {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int voteItemId;
    @Column
    private int appAppeal;
    @Column
    private int amazement;
    @Column
    private int theme;
    @Column
    private int performance;
    @ManyToOne
    @JoinColumn(name = "teamId")
    private Team team;

    public VoteItems() {
    }

    public int getVoteItemId() {
        return voteItemId;
    }

    public void setVoteItemId(int voteItemId) {
        this.voteItemId = voteItemId;
    }

    public int getAppAppeal() {
        return appAppeal;
    }

    public void setAppAppeal(int appAppeal) {
        this.appAppeal = appAppeal;
    }

    public int getAmazement() {
        return amazement;
    }

    public void setAmazement(int amazement) {
        this.amazement = amazement;
    }

    public int getTheme() {
        return theme;
    }

    public void setTheme(int theme) {
        this.theme = theme;
    }

    public int getPerformance() {
        return performance;
    }

    public void setPerformance(int performance) {
        this.performance = performance;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }
}
