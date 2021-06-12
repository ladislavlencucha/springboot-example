package sk.lacike.example.springboot.domain2;

import java.util.List;

public interface PurchaseOrderApi {

	PurchaseOrderBO save(PurchaseOrderBO entityBO);
	List<PurchaseOrderBO> findAll();
	List<PurchaseOrderBO> findByOwnerId(Integer ownerId);
	PurchaseOrderBO findById(Integer id);

}
