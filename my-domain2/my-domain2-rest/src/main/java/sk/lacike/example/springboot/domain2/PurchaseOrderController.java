package sk.lacike.example.springboot.domain2;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sk.lacike.example.springboot.common.ResultListJson;

@RestController
@RequestMapping("/api/v1")
public class PurchaseOrderController {

	private final MyEntityService service;
	private final PurchaseOrderMapper mapper;

	@Autowired
	public PurchaseOrderController(MyEntityService service, PurchaseOrderMapper mapper) {
		this.service = service;
		this.mapper = mapper;
	}

	@GetMapping("/purchase-orders")
	public ResultListJson<PurchaseOrderJson> findAll() {
		List<PurchaseOrderBO> result = service.findAll();

		return ResultListJson.<PurchaseOrderJson>builder()
			.items(mapper.map(result))
			.build();
	}

	@GetMapping("/purchase-orders/{id}")
	public PurchaseOrderJson findById(@PathVariable Integer id) {
		PurchaseOrderBO result = service.findById(id);

		return mapper.map(result);
	}

	@GetMapping("/crm-entities/{ownerId}/purchase-orders")
	public ResultListJson<PurchaseOrderJson> findByOwnerId(@PathVariable Integer ownerId) {
		List<PurchaseOrderBO> result = service.findByOwnerId(ownerId);

		return ResultListJson.<PurchaseOrderJson>builder()
			.items(mapper.map(result))
			.build();
	}

	@PostMapping("/purchase-orders")
	public PurchaseOrderJson saveEntity(@RequestBody PurchaseOrderJson purchaseOrderJson) {
		PurchaseOrderBO entityBO = mapper.map(purchaseOrderJson);
		PurchaseOrderBO saved = service.save(entityBO);

		return mapper.map(saved);
	}

}
