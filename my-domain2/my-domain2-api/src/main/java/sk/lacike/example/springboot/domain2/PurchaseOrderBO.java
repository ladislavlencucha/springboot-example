package sk.lacike.example.springboot.domain2;

import sk.lacike.example.springboot.domain1.CrmEntityBO;

public interface PurchaseOrderBO {

	Integer getId();
	String getDescription();
	CrmEntityBO getOwner();

	void setId(Integer id);
	void setDescription(String description);
	void setOwner(CrmEntityBO owner);

}
