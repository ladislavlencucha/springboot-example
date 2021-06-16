package sk.lacike.example.springboot.domain3;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import lombok.Data;
import sk.lacike.example.springboot.common.BasicEntity;

@Entity
@Data
public class PurchaseOrderSimulationResult implements BasicEntity<PurchaseOrderSimulationResultPk> {

	@EmbeddedId
	private PurchaseOrderSimulationResultPk id;

}
