package org.itstep.data.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NonNull;

import java.util.ArrayList;
import java.util.List;

import static jakarta.persistence.GenerationType.IDENTITY;

@Data
@Entity
@Table(name = "query")
public class Question {
    @Id @GeneratedValue(strategy = IDENTITY)
    private int id;
    @Column(nullable = false, unique = true)
    private String title;
    @Column(length = 500)
    private String description;
    @OneToMany(mappedBy = "question", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<Vote> votes = new ArrayList<>();

    public Question() {
    }

    public Question(@NonNull String title) {
        this.title = title;
    }

    public Question(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public void addVote(Vote vote) {
        vote.setQuestion(this);
        votes.add(vote);
    }
}
