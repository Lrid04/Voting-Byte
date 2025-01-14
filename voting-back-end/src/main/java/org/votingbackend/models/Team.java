package org.votingbackend.models;
import jakarta.persistence.*;
import org.votingbackend.enums.Category;

@Entity
public class Team {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer teamId;
    @Column
    private String teamName;
    @Column
    private String school;
    @Column
    @Enumerated(EnumType.STRING)
    private Category category;

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

    public Category getType() {
        return category;
    }

    public void setType(Category category) {
        this.category = category;
    }
}