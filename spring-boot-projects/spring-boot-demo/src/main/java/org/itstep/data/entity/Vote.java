package org.itstep.data.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

import static jakarta.persistence.GenerationType.IDENTITY;

@Data
@Entity
@Table(name = "vote")
public class Vote {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private int id;
    private boolean agree;
    private LocalDateTime created;
    @ManyToOne
    private Question question;

    public Vote() {
        this(false);
    }

    public Vote(boolean agree) {
        this.agree = agree;
        this.created = LocalDateTime.now();
    }
}
