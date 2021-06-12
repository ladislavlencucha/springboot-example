package sk.lacike.example.springboot.domain2;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sk.lacike.example.springboot.common.ResultListJson;

@RestController
@RequestMapping("/api/v1")
@AllArgsConstructor
public class PurchaseOrderController {

	private final PurchaseOrderService service;
	private final PurchaseOrderJsonMapper mapper;

	@GetMapping("/purchase-orders")
	public ResultListJson<PurchaseOrderJson> findAll() {
		Iterable<PurchaseOrder> result = service.findAll();

		return ResultListJson.<PurchaseOrderJson>builder()
			.items(mapper.map(result))
			.build();
	}

	@GetMapping("/purchase-orders/{id}")
	public PurchaseOrderJson findById(@PathVariable Integer id) {
		PurchaseOrder result = service.findById(id);

		return mapper.map(result);
	}

	@GetMapping("/crm-entities/{ownerId}/purchase-orders")
	public ResultListJson<PurchaseOrderJson> findByOwnerId(@PathVariable Integer ownerId) {
		Iterable<PurchaseOrder> result = service.findByOwnerId(ownerId);

		return ResultListJson.<PurchaseOrderJson>builder()
			.items(mapper.map(result))
			.build();
	}

	@PostMapping("/purchase-orders")
	public PurchaseOrderJson saveEntity(@RequestBody PurchaseOrderJson purchaseOrderJson) {
		PurchaseOrder entityBO = mapper.map(purchaseOrderJson);
		PurchaseOrder saved = service.save(entityBO);

		return mapper.map(saved);
	}

}
