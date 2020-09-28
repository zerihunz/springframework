package nguru.springframework.spring5webapp2.repositories;

import nguru.springframework.spring5webapp2.domain.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
