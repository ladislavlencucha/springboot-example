package sk.lacike.example.springboot.common;

import java.io.Serializable;

import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TranslationPk<P extends Serializable> implements Serializable {

	private P parentId;
	private String languageCode;

}
