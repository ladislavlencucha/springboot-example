package sk.lacike.example.springboot.domain2;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PurchaseOrderJson {

	private Integer id;
	private String description;

	private Integer ownerId;

}
