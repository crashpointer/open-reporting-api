package org.crash.reporting.api.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class FX {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_fx_id")
    @SequenceGenerator(name = "seq_fx_id", sequenceName = "seq_fx_id", allocationSize = 1)
    private int id;

    @NotNull
    @Size(max = 4)
    @Column(length = 4, nullable = false)
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
