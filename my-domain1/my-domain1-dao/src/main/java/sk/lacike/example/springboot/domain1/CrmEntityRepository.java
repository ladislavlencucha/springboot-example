package sk.lacike.example.springboot.domain1;

import org.springframework.data.repository.CrudRepository;

public interface CrmEntityRepository extends CrudRepository<CrmEntity, Integer>, CrmEntityRepositoryCustomizer {
	// Spring data generated implementation
}
