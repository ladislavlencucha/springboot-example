package sk.lacike.example.springboot.domain1;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/domain1/entities")
public class MyDomain1Controller {

	private final MyEntityService service;
	private final MyEntityMapper mapper;

	@Autowired
	public MyDomain1Controller(MyEntityService service, MyEntityMapper mapper) {
		this.service = service;
		this.mapper = mapper;
	}

	@GetMapping
	public ResultListJson<MyEntityJson> findAll() {
		List<MyEntityBO> result = service.findAll();

		return ResultListJson.<MyEntityJson>builder()
			.items(mapper.map(result))
			.build();
	}

	@GetMapping("/{id}")
	public MyEntityJson findById(@PathVariable Integer id) {
		MyEntityBO result = service.findById(id);

		return mapper.map(result);
	}

	@PostMapping
	public MyEntityJson saveEntity(MyEntityJson myEntityJson) {
		MyEntityBO entityBO = mapper.map(myEntityJson);
		MyEntityBO saved = service.save(entityBO);

		return mapper.map(saved);
	}
}
