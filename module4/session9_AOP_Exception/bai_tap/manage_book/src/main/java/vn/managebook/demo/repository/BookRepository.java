package vn.managebook.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.managebook.demo.model.Book;
@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
}
