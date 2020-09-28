package nguru.springframework.spring5webapp2.repositories;

import nguru.springframework.spring5webapp2.domain.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {

}
