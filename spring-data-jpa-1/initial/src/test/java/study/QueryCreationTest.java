package study;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class QueryCreationTest {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private CustomerRepository customerRepository;

    @Test
    void findByLastName() {
        entityManager.persist(new Customer("황", "백호"));
        entityManager.persist(new Customer("민", "호동"));
        entityManager.persist(new Customer("강", "순님"));

        List<Customer> customers = customerRepository.findByLastName("백호");
        assertThat(customers).extracting(Customer::getLastName).containsOnly("백호");
    }

    @Test
    void findByFirstName() {
        entityManager.persist(new Customer("황", "백호"));
        entityManager.persist(new Customer("민", "호동"));
        entityManager.persist(new Customer("강", "순님"));

        List<Customer> customers = customerRepository.findByFirstName("강");
        assertThat(customers).extracting(Customer::getFirstName).containsOnly("강");
    }
}
