package org.crash.reporting.api.web;

import org.crash.reporting.api.AbstractTest;
import org.crash.reporting.api.dao.*;
import org.crash.reporting.api.model.*;
import org.crash.reporting.api.payload.request.LoginRequest;
import org.crash.reporting.api.payload.request.TransactionReportRequest;
import org.crash.reporting.api.payload.request.TransactionRequest;
import org.crash.reporting.api.payload.response.CustomerInfoResponse;
import org.crash.reporting.api.payload.response.TokenResponse;
import org.crash.reporting.api.payload.response.TransactionInfo;
import org.crash.reporting.api.payload.response.TransactionReportResponse;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;

public class APIV3Test extends AbstractTest {

    @Autowired
    private FXRepository fxRepository;

    @Autowired
    private CardRepository cardRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AgentRepository agentRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private StatusRepository statusRepository;

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private MerchantRepository merchantRepository;

    @Autowired
    private AcquirerRepository acquirerRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private OperationRepository operationRepository;

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private PaymentMethodRepository paymentMethodRepository;

    private static final String transactionUUID = "2827-1443515082-3";

    private static final String transactionDate = "09-02-2019";

    private static final String referenceNo = "api_560a4a9314208";

    private static final String currency = "USD";

    private static final String merchantName = "Dev Merchant";

    private static final String userName = "Open Source";

    private static final String userUsername = "opensource";

    private static final String userEmail = "opensource@crash.org";

    private static final String password = "freeBSD";

    private static final String acquirerName = "Morgan Bank";

    private static final String acquirerCode = "MB";

    private static final String customerName = "Dev Customer";

    private static final String customerEmail = "dev@customer.org";

    private static final String customerBirthday = "21-08-1990";

    private static final StatusEnum status = StatusEnum.APPROVED;

    private static final PaymentMethodEnum paymentMethod = PaymentMethodEnum.CREDITCARD;

    private static final OperationEnum operation = OperationEnum.DIRECT;

    private static final int amount = 150;

    private static final String channel = "API";

    private static final String chainId = "5617ae666b4cb";

    private static final String code = "00";

    private static final String agentCustomerIp = "192.168.1.2";

    private static final CustomerUserAgentEnum agentCustomerUserAgent = CustomerUserAgentEnum.Agent;

    private static final String agentMerchantIp = "127.0.0.1";

    private static final String cardNumber = "448574XXXXXX3395";

    private static final byte cardExpiryMonth = 1;

    private static final short cardExpiryYear = 2020;

    private static final String addressTitle = "dev";

    private static final String addressFirstName = "dev";

    private static final String addressLastName = "customer";

    private static final String addressAddress1 = "dev address";

    private static final String addressCity = "Alabama";

    private static final String addressPostCode = "07070";

    private static final String addressCountry = "TR";

    private static final String fromDate = "2019-02-09";

    private static final String toDate = "2019-02-09";

    private LoginRequest loginRequest;

    private TransactionReportRequest transactionReportRequest;

    @Override
    @Before
    public void setUp() throws ParseException {
        super.setUp();

        loginRequest = new LoginRequest();
        loginRequest.setEmail(userEmail);
        loginRequest.setPassword(password);

        if (!transactionRepository.existsByTransactionUUID(transactionUUID)) {
            Transaction transaction = new Transaction();
            transaction.setTransactionUUID(transactionUUID);
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
            transaction.setTransactionDate(new Date(simpleDateFormat.parse(transactionDate).getTime()));
            transaction.setReferenceNo(referenceNo);

            if (!fxRepository.existsByName(currency)) {
                FX fx = new FX();
                fx.setName(currency);
                transaction.setFx(fxRepository.save(fx));
            } else {
                fxRepository.findByName(currency).ifPresent(transaction::setFx);
            }

            if (!merchantRepository.existsByName(merchantName)) {
                Merchant merchant = new Merchant();
                merchant.setName(merchantName);

                if (!userRepository.existsByEmail(userEmail)) {
                    User user = new User();
                    user.setName(userName);
                    user.setUsername(userUsername);
                    user.setEmail(userEmail);
                    user.setPassword(passwordEncoder.encode(password));
                    merchant.setUser(userRepository.save(user));
                } else {
                    Optional<User> user = userRepository.findByEmail(userEmail);
                    user.ifPresent(merchant::setUser);
                }

                transaction.setMerchant(merchantRepository.save(merchant));
            } else {
                merchantRepository.findByName(merchantName).ifPresent(transaction::setMerchant);
            }

            if (!acquirerRepository.existsByCode(acquirerCode)) {
                Acquirer acquirer = new Acquirer();
                acquirer.setName(acquirerName);
                acquirer.setCode(acquirerCode);

                transaction.setAcquirer(acquirerRepository.save(acquirer));
            } else {
                acquirerRepository.findByCode(acquirerCode).ifPresent(transaction::setAcquirer);
            }

            Optional<Customer> customer = customerRepository.findByEmail(customerEmail);
            if (!customer.isPresent()) {
                Customer newCustomer = new Customer();
                newCustomer.setName(customerName);
                newCustomer.setEmail(customerEmail);
                newCustomer.setBirthday(new Date(simpleDateFormat.parse(customerBirthday).getTime()));
                transaction.setCustomer(customerRepository.save(newCustomer));
            } else {
                customer.ifPresent(transaction::setCustomer);
            }

            if (!statusRepository.existsByName(status)) {
                Status newStatus = new Status();
                newStatus.setName(status);
                transaction.setStatus(statusRepository.save(newStatus));
            } else {
                statusRepository.findByName(status).ifPresent(transaction::setStatus);
            }

            if (!paymentMethodRepository.existsByName(paymentMethod)) {
                PaymentMethod newPaymentMethod = new PaymentMethod();
                newPaymentMethod.setName(paymentMethod);
                transaction.setPaymentMethod(paymentMethodRepository.save(newPaymentMethod));
            } else {
                paymentMethodRepository.findByName(paymentMethod).ifPresent(transaction::setPaymentMethod);
            }

            if (!operationRepository.existsByName(operation.toString())) {
                Operation newOperation = new Operation();
                newOperation.setName(operation.toString());
                transaction.setOperation(operationRepository.save(newOperation));
            } else {
                operationRepository.findByName(operation.toString()).ifPresent(transaction::setOperation);
            }

            transaction.setAmount(amount);
            transaction.setChannel(channel);
            transaction.setChainId(chainId);
            transaction.setCode(code);

            Optional<List<Agent>> agent = agentRepository.findByCustomerIp(agentCustomerIp);
            if (!agent.isPresent()) {
                Agent newAgent = new Agent();
                newAgent.setCustomerIp(agentCustomerIp);
                newAgent.setCustomerUserAgent(agentCustomerUserAgent);
                newAgent.setMerchantIp(agentMerchantIp);
                transaction.setAgent(agentRepository.save(newAgent));
            } else {
                agent.get().stream().findFirst().ifPresent(transaction::setAgent);
            }

            customer = customerRepository.findByEmail(customerEmail);

            assert customer.isPresent();
            Optional<List<Card>> card = cardRepository.findByCustomer(customer.get());
            if (!card.isPresent()) {
                Card newCard = new Card();
                newCard.setNumber(cardNumber);
                newCard.setCustomer(customer.get());
                newCard.setExpiryMonth(cardExpiryMonth);
                newCard.setExpiryYear(cardExpiryYear);
                transaction.setCard(cardRepository.save(newCard));
            } else {
                card.get().stream().findFirst().ifPresent(transaction::setCard);
            }

            Optional<List<Address>> address = addressRepository.findByCustomer(customer.get());
            if (!address.isPresent()) {
                Address newAddress = new Address();
                newAddress.setCustomer(customer.get());
                newAddress.setTitle(addressTitle);
                newAddress.setFirstName(addressFirstName);
                newAddress.setLastName(addressLastName);
                newAddress.setAddress1(addressAddress1);
                newAddress.setCity(addressCity);
                newAddress.setPostCode(addressPostCode);
                newAddress.setCountry(addressCountry);

                newAddress = addressRepository.save(newAddress);
                transaction.setBillingAddress(newAddress);
                transaction.setShippingAddress(newAddress);
            } else {
                address.get().stream().findFirst().ifPresent(a -> {
                    transaction.setShippingAddress(a);
                    transaction.setBillingAddress(a);
                });
            }

            transactionRepository.save(transaction);
        }
    }

    public void login() throws Exception {
        String uri = "/api/v3/merchant/user/login";

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders
                .get(uri)
                .accept(MediaType.APPLICATION_JSON_UTF8_VALUE)
        ).andReturn();

        assertEquals(405, mvcResult.getResponse().getStatus());

        mvcResult = mockMvc.perform(
                MockMvcRequestBuilders.post(uri)
                        .accept(MediaType.APPLICATION_JSON_UTF8_VALUE)
        ).andReturn();

        assertEquals(400, mvcResult.getResponse().getStatus());

        mvcResult = mockMvc.perform(
                MockMvcRequestBuilders.post(uri)
                        .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
                        .content(mapToJSON(loginRequest))
        ).andReturn();

        assertEquals(200, mvcResult.getResponse().getStatus());

        TokenResponse tokenResponse = mapFromJSON(mvcResult.getResponse().getContentAsString(), TokenResponse.class);
        assertEquals(StatusEnum.APPROVED.toString(), tokenResponse.getStatus());
    }

    public void transactionReport() throws Exception {
        String uri = "/api/v3/transactions/report";

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders
                .get(uri)
                .accept(MediaType.APPLICATION_JSON_UTF8_VALUE)
        ).andReturn();
        assertEquals(405, mvcResult.getResponse().getStatus());

        mvcResult = mockMvc.perform(
                MockMvcRequestBuilders.post(uri)
                        .accept(MediaType.APPLICATION_JSON_UTF8_VALUE)
        ).andReturn();
        assertEquals(400, mvcResult.getResponse().getStatus());

        TransactionReportRequest transactionReportRequest = new TransactionReportRequest();
        mvcResult = mockMvc.perform(
                MockMvcRequestBuilders.post(uri)
                        .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
                        .content(mapToJSON(transactionReportRequest))
        ).andReturn();
        assertEquals(400, mvcResult.getResponse().getStatus());

        transactionReportRequest.setFromDate(fromDate);
        transactionReportRequest.setToDate(toDate);
        mvcResult = mockMvc.perform(
                MockMvcRequestBuilders.post(uri)
                        .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
                        .content(mapToJSON(transactionReportRequest))
        ).andReturn();
        assertEquals(200, mvcResult.getResponse().getStatus());

        TransactionReportResponse transactionReportResponse =
                mapFromJSON(mvcResult.getResponse().getContentAsString(), TransactionReportResponse.class);
        assertEquals(StatusEnum.APPROVED.toString(), transactionReportResponse.getStatus());
    }

    @Test
    public void transaction() throws Exception {
        String uri = "/api/v3/transaction";

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders
                .get(uri)
                .accept(MediaType.APPLICATION_JSON_UTF8_VALUE)
        ).andReturn();
        assertEquals(405, mvcResult.getResponse().getStatus());

        mvcResult = mockMvc.perform(
                MockMvcRequestBuilders.post(uri)
                        .accept(MediaType.APPLICATION_JSON_UTF8_VALUE)
        ).andReturn();
        assertEquals(400, mvcResult.getResponse().getStatus());

        TransactionRequest transactionRequest = new TransactionRequest();
        mvcResult = mockMvc.perform(
                MockMvcRequestBuilders.post(uri)
                        .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
                        .content(mapToJSON(transactionRequest))
        ).andReturn();
        assertEquals(400, mvcResult.getResponse().getStatus());

        transactionRequest.setTransactionUUID(transactionUUID);
        mvcResult = mockMvc.perform(
                MockMvcRequestBuilders.post(uri)
                        .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
                        .content(mapToJSON(transactionRequest))
        ).andReturn();
        assertEquals(200, mvcResult.getResponse().getStatus());

        TransactionInfo transactionInfo =
                mapFromJSON(mvcResult.getResponse().getContentAsString(), TransactionInfo.class);
        assertEquals(transactionUUID, transactionInfo.getTransaction().getTransactionUUID());
    }

    public void client() throws Exception {
        String uri = "/api/v3/client";

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders
                .get(uri)
                .accept(MediaType.APPLICATION_JSON_UTF8_VALUE)
        ).andReturn();
        assertEquals(405, mvcResult.getResponse().getStatus());

        mvcResult = mockMvc.perform(
                MockMvcRequestBuilders.post(uri)
                        .accept(MediaType.APPLICATION_JSON_UTF8_VALUE)
        ).andReturn();
        assertEquals(400, mvcResult.getResponse().getStatus());

        TransactionRequest transactionRequest = new TransactionRequest();
        mvcResult = mockMvc.perform(
                MockMvcRequestBuilders.post(uri)
                        .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
                        .content(mapToJSON(transactionRequest))
        ).andReturn();
        assertEquals(400, mvcResult.getResponse().getStatus());

        transactionRequest.setTransactionUUID(transactionUUID);
        mvcResult = mockMvc.perform(
                MockMvcRequestBuilders.post(uri)
                        .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
                        .content(mapToJSON(transactionRequest))
        ).andReturn();
        assertEquals(200, mvcResult.getResponse().getStatus());

        CustomerInfoResponse customerInfoResponse =
                mapFromJSON(mvcResult.getResponse().getContentAsString(), CustomerInfoResponse.class);
        assertEquals(StatusEnum.APPROVED.toString(), customerInfoResponse.getStatus());
    }

}
