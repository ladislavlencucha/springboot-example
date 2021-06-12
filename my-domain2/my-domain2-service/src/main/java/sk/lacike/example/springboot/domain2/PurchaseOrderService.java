package sk.lacike.example.springboot.domain2;

public interface PurchaseOrderService {

	PurchaseOrder save(PurchaseOrder entity);
	Iterable<PurchaseOrder> findAll();
	Iterable<PurchaseOrder> findByOwnerId(Integer ownerId);
	PurchaseOrder findById(Integer id);

}
