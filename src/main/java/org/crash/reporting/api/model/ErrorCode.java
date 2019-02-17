package org.crash.reporting.api.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class ErrorCode {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_error_code_id")
    @SequenceGenerator(name = "seq_error_code_id", sequenceName = "seq_error_code_id", allocationSize = 1)
    private int id;

    @NotNull
    @Size(max = 64)
    @Column(length = 64, nullable = false)
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
