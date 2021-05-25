package sk.lacike.example.springboot.domain1;

import java.util.List;

import lombok.Builder;
import lombok.Data;
import lombok.Singular;

@Data
@Builder
public class ResultListJson<T> {
	@Singular
	private List<T> items;
}
