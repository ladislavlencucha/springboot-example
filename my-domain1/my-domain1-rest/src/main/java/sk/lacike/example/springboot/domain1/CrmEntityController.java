package sk.lacike.example.springboot.domain1;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sk.lacike.example.springboot.common.ResultListJson;

@RestController
@RequestMapping("/api/v1/crm-entities")
public class CrmEntityController {

	private final CrmEntityService service;
	private final CrmEntityMapper mapper;

	@Autowired
	public CrmEntityController(CrmEntityServiceImpl service, CrmEntityMapper mapper) {
		this.service = service;
		this.mapper = mapper;
	}

	@GetMapping
	public ResultListJson<CrmEntityJson> findAll() {
		List<CrmEntityBO> result = service.findAll();

		return ResultListJson.<CrmEntityJson>builder()
			.items(mapper.map(result))
			.build();
	}

	@GetMapping("/{id}")
	public CrmEntityJson findById(@PathVariable Integer id) {
		CrmEntityBO result = service.findById(id);

		return mapper.map(result);
	}

	@PostMapping
	public CrmEntityJson saveEntity(@RequestBody CrmEntityJson crmEntityJson) {
		CrmEntityBO entityBO = mapper.map(crmEntityJson);
		CrmEntityBO saved = service.save(entityBO);

		return mapper.map(saved);
	}
}
