package sk.lacike.example.springboot.domain2;

import lombok.experimental.Delegate;

public class PurchaseOrderBO {

	@Delegate
	private final PurchaseOrder entity;

	public PurchaseOrderBO(PurchaseOrder entity) {
		this.entity = entity;
	}

	public PurchaseOrderBO() {
		this.entity = new PurchaseOrder();
	}

	public PurchaseOrder unwrap() {
		return entity;
	}

}
