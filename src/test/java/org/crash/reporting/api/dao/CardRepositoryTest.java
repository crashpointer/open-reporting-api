package org.crash.reporting.api.dao;

import org.crash.reporting.api.model.Card;
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

public class CardRepositoryTest extends AbstractDAOTest {

    @Autowired
    CardRepository cardRepository;

    @Autowired
    CustomerRepository customerRepository;

    private static final String customerName = "Dev Customer";

    private static final String customerEmail = "dev@customer.org";

    private static final String customerBirthday = "21-08-1990";

    private static final String number = "448574XXXXXX3395";

    private static final byte expiryMonth = 1;

    private static final short expiryYear = 2020;

    @Before
    public void setUp() throws ParseException {
        Optional<Card> card = cardRepository.findByNumber(number);

        if (!card.isPresent()) {
            Card newCard = new Card();
            newCard.setNumber(number);
            newCard.setExpiryMonth(expiryMonth);
            newCard.setExpiryYear(expiryYear);

            Optional<Customer> customer = customerRepository.findByEmail(customerEmail);

            if (!customer.isPresent()) {
                Customer newCustomer = new Customer();
                newCustomer.setName(customerName);
                newCustomer.setEmail(customerEmail);

                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
                newCustomer.setBirthday(new Date(simpleDateFormat.parse(customerBirthday).getTime()));
                newCard.setCustomer(customerRepository.save(newCustomer));
            } else {
                newCard.setCustomer(customer.get());
            }

            cardRepository.save(newCard);
        }
    }

    @Test
    public void findByNumber() {
        Optional<Card> card = cardRepository.findByNumber(number);

        assertTrue(card.isPresent());
        assertTrue(card.get().getId() > 0);
        assertEquals(number, card.get().getNumber());
    }

    @Test
    public void findByCustomer() {
        Optional<Customer> customer = customerRepository.findByEmail(customerEmail);
        assertTrue(customer.isPresent());

        Optional<List<Card>> cardList = cardRepository.findByCustomer(customer.get());
        assertTrue(cardList.isPresent());
        cardList.get().forEach(card -> {
            assertTrue(card.getId() > 0);
            assertEquals(customerEmail, card.getCustomer().getEmail());
            assertEquals(customer.get().getId(), card.getCustomer().getId());
        });
    }

    @Test
    public void existsByNumber() {
        assertTrue(cardRepository.existsByNumber(number));
    }

}
