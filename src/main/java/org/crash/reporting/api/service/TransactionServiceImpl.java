package org.crash.reporting.api.service;

import org.crash.reporting.api.dao.TransactionRepository;
import org.crash.reporting.api.payload.request.TransactionReportRequest;
import org.crash.reporting.api.payload.request.TransactionRequest;
import org.crash.reporting.api.payload.response.CustomerInfo;
import org.crash.reporting.api.payload.response.TransactionInfo;
import org.crash.reporting.api.payload.response.TransactionReport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Optional;

@Service
public class TransactionServiceImpl implements TransactionService {

    private static final Logger logger = LoggerFactory.getLogger(TransactionServiceImpl.class);

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private TransactionRepository transactionRepository;

    @Override
    @Transactional
    public Optional<List<TransactionReport>> transactionReport(TransactionReportRequest reportRequest) {
        String queryStr = "select\n" +
                "\tf.name currency,\n" +
                "\tcount(t.id) count,\n" +
                "\tsum(t.amount) total\n" +
                "from \n" +
                "\ttransaction t\n" +
                "\tjoin status s on s.id = t.status_id\n" +
                "\t\tand s.name = 'APPROVED'\n" +
                "\tleft outer join fx f on f.id = t.fx_id\n" +
                "where t.transaction_date between :fromDate and :toDate\n" +
                "\tand (t.merchant_id = :merchant or 0 = :merchant)\n" +
                "\tand (t.acquirer_id = :acquirer or 0 = :acquirer)\n" +
                "group by\n" +
                "\tf.name";

        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

            Query query = entityManager.createNativeQuery(queryStr, "TransactionReportMapping");
            query.setParameter("fromDate", new Date(simpleDateFormat.parse(reportRequest.getFromDate()).getTime()));
            query.setParameter("toDate", new Date(simpleDateFormat.parse(reportRequest.getToDate()).getTime()));
            query.setParameter("merchant", reportRequest.getMerchant());
            query.setParameter("acquirer", reportRequest.getAcquirer());

            return Optional.of((List<TransactionReport>) query.getResultList());
        } catch (Exception e) {
            logger.error(e.getMessage());
        }

        return Optional.empty();
    }

    @Override
    @Transactional
    public Optional<TransactionInfo> transaction(TransactionRequest transactionRequest) {
        String queryStr = "select\n" +
                "\tf.id fx_id,\n" +
                "\tt.amount original_amount,\n" +
                "\tf.name original_currency,\n" +
                "\tc.id customer_id,\n" +
                "\tc.created_at,\n" +
                "\tc.updated_at,\n" +
                "\tcr.number,\n" +
                "\tcr.expiry_month,\n" +
                "\tcr.expiry_year,\n" +
                "\tcr.start_month,\n" +
                "\tcr.start_year,\n" +
                "\tc.email,\n" +
                "\tc.birthday,\n" +
                "\tc.gender,\n" +
                "\ta1.title billing_title,\n" +
                "\ta1.first_name billing_first_name,\n" +
                "\ta1.last_name billing_last_name,\n" +
                "\ta1.company billing_company,\n" +
                "\ta1.address1 billing_address1,\n" +
                "\ta1.address2 billing_address2,\n" +
                "\ta1.city billing_city,\n" +
                "\ta1.post_code billing_post_code,\n" +
                "\ta1.state billing_state,\n" +
                "\ta1.country billing_country,\n" +
                "\ta1.phone billing_phone,\n" +
                "\ta1.fax billing_fax,\n" +
                "\ta2.title shipping_title,\n" +
                "\ta2.first_name shipping_first_name,\n" +
                "\ta2.last_name shipping_last_name,\n" +
                "\ta2.company shipping_company,\n" +
                "\ta2.address1 shipping_address1,\n" +
                "\ta2.address2 shipping_address2,\n" +
                "\ta2.city shipping_city,\n" +
                "\ta2.post_code shipping_post_code,\n" +
                "\ta2.state shipping_state,\n" +
                "\ta2.country shipping_country,\n" +
                "\ta2.phone shipping_phone,\n" +
                "\ta2.fax shipping_fax,\n" +
                "\tm.id merchant_id,\n" +
                "\tm.name merchant_name,\n" +
                "\tt.id transaction_id,\n" +
                "\tt.transactionUUID,\n" +
                "\tt.reference_no,\n" +
                "\ts.name transaction_status,\n" +
                "\tt.channel,\n" +
                "\tt.custom_data,\n" +
                "\tt.chain_id,\n" +
                "\to.name operation_name,\n" +
                "\tt.code transaction_code,\n" +
                "\tt.message,\n" +
                "\tt.created_at transaction_created_at,\n" +
                "\tt.updated_at transaction_updated_at,\n" +
                "\ta.id agent_id,\n" +
                "\ta.customer_ip,\n" +
                "\ta.customer_user_agent,\n" +
                "\ta.merchant_ip\n" +
                "from \n" +
                "\ttransaction t\n" +
                "\tleft outer join fx f on f.id = fx_id\n" +
                "\tleft outer join customer c on c.id = t.customer_id\n" +
                "\tleft outer join card cr on cr.id = t.card_id\n" +
                "\tleft outer join address a1 on a1.id = t.billing_address_id\n" +
                "\tleft outer join address a2 on a2.id = t.shipping_address_id\n" +
                "\tleft outer join merchant m on m.id = t.merchant_id\n" +
                "\tleft outer join status s on s.id = t.status_id\n" +
                "\tleft outer join operation o on o.id = t.operation_id\n" +
                "\tleft outer join agent a on a.id = t.agent_id\n" +
                "where t.transactionUUID = :uuid";

        try {
            Query query = entityManager.createNativeQuery(queryStr, "TransactionInfoMapping");
            query.setParameter("uuid", transactionRequest.getTransactionUUID());

            return Optional.of((TransactionInfo) query.getSingleResult());
        } catch (Exception e) {
            logger.error(e.getMessage());
        }

        return Optional.empty();
    }

    @Override
    @Transactional
    public Optional<CustomerInfo> client(TransactionRequest transactionRequest) {
        String queryStr = "select\n" +
                "\tc.id,\n" +
                "\tc.created_at,\n" +
                "\tc.updated_at,\n" +
                "\tcr.number,\n" +
                "\tcr.expiry_month,\n" +
                "\tcr.expiry_year,\n" +
                "\tcr.start_month,\n" +
                "\tcr.start_year,\n" +
                "\tc.email,\n" +
                "\tc.birthday,\n" +
                "\tc.gender,\n" +
                "\ta1.title billing_title,\n" +
                "\ta1.first_name billing_first_name,\n" +
                "\ta1.last_name billing_last_name,\n" +
                "\ta1.company billing_company,\n" +
                "\ta1.address1 billing_address1,\n" +
                "\ta1.address2 billing_address2,\n" +
                "\ta1.city billing_city,\n" +
                "\ta1.post_code billing_post_code,\n" +
                "\ta1.state billing_state,\n" +
                "\ta1.country billing_country,\n" +
                "\ta1.phone billing_phone,\n" +
                "\ta1.fax billing_fax,\n" +
                "\ta2.title shipping_title,\n" +
                "\ta2.first_name shipping_first_name,\n" +
                "\ta2.last_name shipping_last_name,\n" +
                "\ta2.company shipping_company,\n" +
                "\ta2.address1 shipping_address1,\n" +
                "\ta2.address2 shipping_address2,\n" +
                "\ta2.city shipping_city,\n" +
                "\ta2.post_code shipping_post_code,\n" +
                "\ta2.state shipping_state,\n" +
                "\ta2.country shipping_country,\n" +
                "\ta2.phone shipping_phone,\n" +
                "\ta2.fax shipping_fax\n" +
                "from \n" +
                "\ttransaction t\n" +
                "\tleft outer join customer c on c.id = t.customer_id\n" +
                "\tleft outer join card cr on cr.id = t.card_id\n" +
                "\tleft outer join address a1 on a1.id = t.billing_address_id\n" +
                "\tleft outer join address a2 on a2.id = t.shipping_address_id\n" +
                "where t.transactionUUID = :uuid";

        try {
            Query query = entityManager.createNativeQuery(queryStr, "CustomerInfoMapping");
            query.setParameter("uuid", transactionRequest.getTransactionUUID());

            return Optional.of((CustomerInfo) query.getSingleResult());
        } catch (Exception e) {
            logger.error(e.getMessage());
        }

        return Optional.empty();
    }

}
