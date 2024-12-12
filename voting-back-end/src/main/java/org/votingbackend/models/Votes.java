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
}
