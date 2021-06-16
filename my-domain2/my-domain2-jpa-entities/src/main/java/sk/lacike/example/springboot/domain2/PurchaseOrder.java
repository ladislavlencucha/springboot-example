package sk.lacike.example.springboot.domain2;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;
import sk.lacike.example.springboot.domain1.CrmEntity;

@Entity
@Data
public class PurchaseOrder {

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Integer id;
	private String description;

	@JoinColumn(name = "entity_id")
	@ManyToOne
	private CrmEntity owner;

}
