package org.crash.reporting.api.model;

import org.crash.reporting.api.payload.response.CustomerInfo;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;

@SqlResultSetMapping(
        name = "CustomerInfoMapping",
        classes = @ConstructorResult(
                targetClass = CustomerInfo.class,
                columns = {
                        @ColumnResult(name = "id", type = Integer.class),
                        @ColumnResult(name = "created_at", type = LocalDateTime.class),
                        @ColumnResult(name = "updated_at", type = LocalDateTime.class),
                        @ColumnResult(name = "number", type = String.class),
                        @ColumnResult(name = "expiry_month", type = Byte.class),
                        @ColumnResult(name = "expiry_year", type = Short.class),
                        @ColumnResult(name = "start_month", type = Byte.class),
                        @ColumnResult(name = "start_year", type = Short.class),
                        @ColumnResult(name = "email", type = String.class),
                        @ColumnResult(name = "birthday", type = LocalDate.class),
                        @ColumnResult(name = "gender", type = Boolean.class),
                        @ColumnResult(name = "billing_title", type = String.class),
                        @ColumnResult(name = "billing_first_name", type = String.class),
                        @ColumnResult(name = "billing_last_name", type = String.class),
                        @ColumnResult(name = "billing_company", type = String.class),
                        @ColumnResult(name = "billing_address1", type = String.class),
                        @ColumnResult(name = "billing_address2", type = String.class),
                        @ColumnResult(name = "billing_city", type = String.class),
                        @ColumnResult(name = "billing_post_code", type = String.class),
                        @ColumnResult(name = "billing_state", type = String.class),
                        @ColumnResult(name = "billing_country", type = String.class),
                        @ColumnResult(name = "billing_phone", type = String.class),
                        @ColumnResult(name = "billing_fax", type = String.class),
                        @ColumnResult(name = "shipping_title", type = String.class),
                        @ColumnResult(name = "shipping_first_name", type = String.class),
                        @ColumnResult(name = "shipping_last_name", type = String.class),
                        @ColumnResult(name = "shipping_company", type = String.class),
                        @ColumnResult(name = "shipping_address1", type = String.class),
                        @ColumnResult(name = "shipping_address2", type = String.class),
                        @ColumnResult(name = "shipping_city", type = String.class),
                        @ColumnResult(name = "shipping_post_code", type = String.class),
                        @ColumnResult(name = "shipping_state", type = String.class),
                        @ColumnResult(name = "shipping_country", type = String.class),
                        @ColumnResult(name = "shipping_phone", type = String.class),
                        @ColumnResult(name = "shipping_fax", type = String.class)
                }
        )
)
@Entity
public class Customer extends DateAudit {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_customer_id")
    @SequenceGenerator(name = "seq_customer_id", sequenceName = "seq_customer_id", allocationSize = 1)
    private int id;

    @NotNull
    @Size(max = 64)
    @Column(length = 64)
    private String name;

    @NotNull
    @Column(nullable = false)
    private boolean gender = false;

    @NotNull
    @Email(message = "Email should be valid")
    @Size(max = 128)
    @Column(length = 128, unique = true, nullable = false)
    private String email;

    @NotNull
    @Column(nullable = false)
    private Date birthday;

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

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

}
