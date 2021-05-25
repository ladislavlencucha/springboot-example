package sk.lacike.example.springboot.domain1;

import org.springframework.data.repository.CrudRepository;

public interface MyEntityRepository extends CrudRepository<MyEntity, Integer> {

	MyEntity findByName(String name);
}
