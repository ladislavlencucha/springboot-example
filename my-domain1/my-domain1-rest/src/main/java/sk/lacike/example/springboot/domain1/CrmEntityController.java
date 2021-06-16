package sk.lacike.example.springboot.domain1;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sk.lacike.example.springboot.common.BasicEntityTranslationHolder;
import sk.lacike.example.springboot.common.ResultListJson;

@RestController
@RequestMapping("/api/v1/crm-entities")
@AllArgsConstructor
public class CrmEntityController {

	private final CrmEntityService service;
	private final CrmEntityJsonMapper mapper;

	@GetMapping
	public ResultListJson<CrmEntityJson> findAll() {
		Iterable<BasicEntityTranslationHolder<CrmEntity, CrmEntityTranslation>> result = service.findAll();

		return ResultListJson.<CrmEntityJson>builder()
			.items(mapper.map(result))
			.build();
	}

	@GetMapping("/{id}")
	public CrmEntityJson findById(@PathVariable Integer id) {
		BasicEntityTranslationHolder<CrmEntity, CrmEntityTranslation> result = service.findById(id);

		return mapper.map(result);
	}

	@PostMapping
	public CrmEntityJson saveEntity(@RequestBody CrmEntityJson crmEntityJson) {
		BasicEntityTranslationHolder<CrmEntity, CrmEntityTranslation> entityBO = mapper.map(crmEntityJson);
		BasicEntityTranslationHolder<CrmEntity, CrmEntityTranslation> saved = service.save(entityBO);

		return mapper.map(saved);
	}
}
