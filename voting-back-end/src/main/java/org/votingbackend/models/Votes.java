package org.votingbackend.models;

import jakarta.persistence.*;

@Entity
public class Votes {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int voteId;
    @ManyToOne
    @JoinColumn(name="sessionId")
    private Session session;
    @ManyToOne
    @JoinColumn(name="voteItemId")
    private VoteItems voteItems;

    public int getVoteId() {
        return voteId;
    }

    public void setVoteId(int voteId) {
        this.voteId = voteId;
    }

    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }

    public VoteItems getVoteItems() {
        return voteItems;
    }

    public void setVoteItems(VoteItems voteItems) {
        this.voteItems = voteItems;
    }
}
