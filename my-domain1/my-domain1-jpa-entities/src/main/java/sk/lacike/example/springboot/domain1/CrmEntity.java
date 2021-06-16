package sk.lacike.example.springboot.domain1;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import sk.lacike.example.springboot.common.BasicEntity;

@Entity
@Data
public class CrmEntity implements BasicEntity<Integer> {

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Integer id;

	private String name;
	private String description;

}
