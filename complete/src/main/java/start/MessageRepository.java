package start;

import org.springframework.data.repository.CrudRepository;

public interface MessageRepository extends CrudRepository<Greeting, Integer> {
}
