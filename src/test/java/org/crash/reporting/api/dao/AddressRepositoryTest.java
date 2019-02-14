package org.crash.reporting.api.dao;

import org.crash.reporting.api.model.Address;
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

public class AddressRepositoryTest extends AbstractDAOTest {

    @Autowired
    AddressRepository addressRepository;

    @Autowired
    CustomerRepository customerRepository;

    private static final String customerName = "Dev Customer";

    private static final String customerEmail = "dev@customer.org";

    private static final String customerBirthday = "21-08-1990";

    private static final String title = "dev";

    private static final String firstName = "dev";

    private static final String lastName = "customer";

    private static final String address1 = "dev address";

    private static final String city = "Alabama";

    private static final String postCode = "07070";

    private static final String country = "TR";

    @Before
    public void setUp() throws ParseException {
        Optional<List<Address>> addressList = addressRepository.findByTitle(title);

        if (!addressList.isPresent()) {
            Address address = new Address();
            address.setTitle(title);
            address.setFirstName(firstName);
            address.setLastName(lastName);
            address.setAddress1(address1);
            address.setCity(city);
            address.setPostCode(postCode);
            address.setCountry(country);

            Optional<Customer> customer = customerRepository.findByEmail(customerEmail);

            if (!customer.isPresent()) {
                Customer newCustomer = new Customer();
                newCustomer.setName(customerName);
                newCustomer.setEmail(customerEmail);

                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
                newCustomer.setBirthday(new Date(simpleDateFormat.parse(customerBirthday).getTime()));
                address.setCustomer(customerRepository.save(newCustomer));
            } else {
                address.setCustomer(customer.get());
            }

            addressRepository.save(address);
        }
    }

    @Test
    public void findByCustomer() {
        Optional<Customer> customer = customerRepository.findByEmail(customerEmail);
        assertTrue(customer.isPresent());

        Optional<List<Address>> address = addressRepository.findByCustomer(customer.get());
        assertTrue(address.isPresent());
        assertTrue(address.get().size() >= 1);
        address.get().forEach(item -> {
            assertEquals(customerEmail, item.getCustomer().getEmail());
            assertEquals(customer.get().getEmail(), item.getCustomer().getEmail());
        });
    }

}
