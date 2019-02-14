package org.crash.reporting.api.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_role_id")
    @SequenceGenerator(name = "seq_role_id", sequenceName = "seq_role_id")
    private int id;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(length = 16)
    private RoleEnum name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public RoleEnum getName() {
        return name;
    }

    public void setName(RoleEnum name) {
        this.name = name;
    }
}
