package sk.lacike.example.springboot.domain3;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SimulationResultJson {

	private Integer id;
	private String name;
	private String description;

	private Integer requestorId;

}
