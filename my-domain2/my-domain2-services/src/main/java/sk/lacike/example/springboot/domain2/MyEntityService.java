package sk.lacike.example.springboot.domain2;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyEntityService {

	private final MyEntityRepository repository;

	@Autowired
	public MyEntityService(MyEntityRepository repository) {
		this.repository = repository;
	}

	@Transactional
	public MyEntityBO save(MyEntityBO entityBO) {
		MyEntity saved = repository.save(convert(entityBO));

		return convert(saved);
	}

	public List<MyEntityBO> findAll() {
		return convert(repository.findAll());

	}

	public MyEntityBO findById(Integer id) {
		return convert(repository.findById(id)
			.orElseThrow(() -> new IllegalArgumentException("MyEntity not found by id=" + id)));
	}

	private MyEntity convert(MyEntityBO entityBO) {
		return entityBO.unwrap();
	}

	private MyEntityBO convert(MyEntity entity) {
		return new MyEntityBO(entity);
	}

	private List<MyEntityBO> convert(Iterable<MyEntity> entities) {
		return StreamSupport.stream(entities.spliterator(), false)
			.map(MyEntityBO::new)
			.collect(Collectors.toList());
	}
}
