package sk.lacike.example.springboot.domain2;

import java.util.List;

import javax.transaction.Transactional;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PurchaseOrderApiImpl implements PurchaseOrderApi {

	private final PurchaseOrderService service;
	private final PurchaseOrderBOMapper mapper;

	@Override
	@Transactional
	public PurchaseOrderBO save(PurchaseOrderBO entityBO) {
		PurchaseOrder saved = service.save(mapper.map(entityBO));

		return mapper.map(saved);
	}

	@Override
	public List<PurchaseOrderBO> findAll() {
		return mapper.map(service.findAll());
	}

	@Override
	public List<PurchaseOrderBO> findByOwnerId(Integer ownerId) {
		return mapper.map(service.findByOwnerId(ownerId));
	}

	@Override
	public PurchaseOrderBO findById(Integer id) {
		return mapper.map(service.findById(id));
	}

}
