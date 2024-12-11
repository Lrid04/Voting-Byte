package org.votingbackend.models;
import jakarta.persistence.*;
import org.votingbackend.enums.Type;

@Entity
@Table
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer teamId;
    @Column
    private String teamName;
    @Column
    private String school;
    @Column
    @Enumerated(EnumType.STRING)
    private Type type;

    public Team() {

    }

    public Integer getTeamId() {
        return teamId;
    }

    public void setTeamId(Integer teamId) {
        this.teamId = teamId;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }
}