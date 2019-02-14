package org.crash.reporting.api.dao;

import org.crash.reporting.api.model.Customer;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CustomerRepositoryTest extends AbstractDAOTest {

    @Autowired
    CustomerRepository customerRepository;

    private static final String name = "Dev Customer";

    private static final String email = "dev@customer.org";

    private static final String date = "21-08-1990";

    @Before
    public void setUp() throws ParseException {
        Optional<Customer> customer = customerRepository.findByEmail(email);

        if (!customer.isPresent()) {
            Customer newCustomer = new Customer();
            newCustomer.setName(name);
            newCustomer.setEmail(email);

            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
            newCustomer.setBirthday(new Date(simpleDateFormat.parse(date).getTime()));

            customerRepository.save(newCustomer);
        }
    }

    @Test
    public void findByName() {
        Optional<List<Customer>> customer = customerRepository.findByName(name);

        customer.ifPresent(c -> {
            assertTrue(c.size() > 0);

            c.forEach(item -> {
                assertTrue(item.getId() > 0);
            });
        });
    }

    @Test
    public void findByEmail() {
        Optional<Customer> customer = customerRepository.findByEmail(email);

        customer.ifPresent(c -> {
            assertTrue(c.getId() > 0);
            assertEquals(name, c.getName());
        });
    }

}
