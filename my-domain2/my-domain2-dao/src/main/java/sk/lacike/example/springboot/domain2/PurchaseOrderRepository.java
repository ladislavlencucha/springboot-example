package sk.lacike.example.springboot.domain2;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PurchaseOrderRepository extends CrudRepository<PurchaseOrder, Integer> {

	List<PurchaseOrder> findByOwnerId(Integer ownerId);

}
