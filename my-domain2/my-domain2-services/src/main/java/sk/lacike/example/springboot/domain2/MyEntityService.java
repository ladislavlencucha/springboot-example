package sk.lacike.example.springboot.domain2;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyEntityService {

	private final PurchaseOrderRepository repository;

	@Autowired
	public MyEntityService(PurchaseOrderRepository repository) {
		this.repository = repository;
	}

	@Transactional
	public PurchaseOrderBO save(PurchaseOrderBO entityBO) {
		PurchaseOrder saved = repository.save(convert(entityBO));

		return convert(saved);
	}

	public List<PurchaseOrderBO> findAll() {
		return convert(repository.findAll());
	}

	public List<PurchaseOrderBO> findByOwnerId(Integer ownerId) {
		return convert(repository.findByOwnerId(ownerId));
	}

	public PurchaseOrderBO findById(Integer id) {
		return convert(repository.findById(id)
			.orElseThrow(() -> new IllegalArgumentException("MyEntity not found by id=" + id)));
	}

	private PurchaseOrder convert(PurchaseOrderBO entityBO) {
		return entityBO.unwrap();
	}

	private PurchaseOrderBO convert(PurchaseOrder entity) {
		return new PurchaseOrderBO(entity);
	}

	private List<PurchaseOrderBO> convert(Iterable<PurchaseOrder> entities) {
		return StreamSupport.stream(entities.spliterator(), false)
			.map(PurchaseOrderBO::new)
			.collect(Collectors.toList());
	}
}
