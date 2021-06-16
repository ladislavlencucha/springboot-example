package sk.lacike.example.springboot.domain2;

import lombok.Data;
import sk.lacike.example.springboot.domain1.CrmEntityBO;

@Data
public class PurchaseOrderBOImpl implements PurchaseOrderBO {

	private Integer id;
	private String description;
	private CrmEntityBO owner;
	
}
