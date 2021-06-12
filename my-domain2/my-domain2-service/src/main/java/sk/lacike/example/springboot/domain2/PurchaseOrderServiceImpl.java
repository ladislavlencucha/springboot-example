package sk.lacike.example.springboot.domain2;

import java.util.List;

import javax.transaction.Transactional;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PurchaseOrderServiceImpl implements PurchaseOrderService {

	private final PurchaseOrderRepository repository;

	@Override
	@Transactional
	public PurchaseOrder save(PurchaseOrder entityBO) {
		return repository.save(entityBO);
	}

	@Override
	public Iterable<PurchaseOrder> findAll() {
		return repository.findAll();
	}

	@Override
	public List<PurchaseOrder> findByOwnerId(Integer ownerId) {
		return repository.findByOwnerId(ownerId);
	}

	@Override
	public PurchaseOrder findById(Integer id) {
		return repository.findById(id)
			.orElseThrow(() -> new IllegalArgumentException("Purchase order not found by id=" + id));
	}

}
