package sk.lacike.example.springboot.domain3;

import static sk.lacike.example.springboot.domain2.QPurchaseOrder.purchaseOrder;
import static sk.lacike.example.springboot.domain3.QPurchaseOrderSimulationResult.purchaseOrderSimulationResult;
import static sk.lacike.example.springboot.domain3.QSimulationResult.simulationResult;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.mysema.query.jpa.impl.JPAQuery;

public class PurchaseOrderSimulationResultCustomizerImpl implements PurchaseOrderSimulationResultCustomizer {

	@PersistenceContext
	private EntityManager em;

	@Override
	public List<PurchaseOrderSimulationResultDto> findByEntityId(Integer entityId) {
		return basicQuery()
			.where(simulationResult.requestor.id.eq(entityId)
				.or(purchaseOrder.owner.id.eq(entityId)))
			.list(new QPurchaseOrderSimulationResultDto(purchaseOrder, simulationResult));
	}

	@Override
	public Optional<PurchaseOrderSimulationResultDto> findDto(PurchaseOrderSimulationResultPk id) {
		return Optional.ofNullable(basicQuery()
			.where(purchaseOrderSimulationResult.id.eq(id))
			.singleResult(new QPurchaseOrderSimulationResultDto(purchaseOrder, simulationResult)));
	}

	private JPAQuery basicQuery() {
		return new JPAQuery(em)
			.from(simulationResult)
			.join(purchaseOrderSimulationResult).on(simulationResult.id.eq(purchaseOrderSimulationResult.id.simulationResultId))
			.join(purchaseOrder).on(purchaseOrder.id.eq(purchaseOrderSimulationResult.id.purchaseOrderId));
	}

}
