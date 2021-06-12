package sk.lacike.example.springboot.domain3;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;
import sk.lacike.example.springboot.common.BasicEntity;
import sk.lacike.example.springboot.domain1.CrmEntity;

@Entity
@Data
public class SimulationResult implements BasicEntity<Integer> {

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Integer id;

	private String name;
	private String description;

	@JoinColumn(name = "requestor_id")
	@ManyToOne
	private CrmEntity  requestor;

}
