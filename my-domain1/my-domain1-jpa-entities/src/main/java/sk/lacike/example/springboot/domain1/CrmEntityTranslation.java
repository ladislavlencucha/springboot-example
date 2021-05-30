package sk.lacike.example.springboot.domain1;

import javax.persistence.Entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import sk.lacike.example.springboot.common.AbstractTranslation;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
public class CrmEntityTranslation extends AbstractTranslation<Integer> {

	private String instructions;

}


