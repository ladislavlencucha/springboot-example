package sk.lacike.example.springboot.domain1;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import javax.transaction.Transactional;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import sk.lacike.example.springboot.common.BasicEntityTranslationHolder;

@Service
@AllArgsConstructor
public class CrmEntityApiImpl implements CrmEntityApi {

	private final CrmEntityService service;
	private final CrmEntityBOMapper mapper;

	@Override
	public CrmEntityBO newCrmEntityBO() {
		return new CrmEntityBOImpl();
	}

	@Override
	public CrmEntityBO.CrmEntityTranslationBO newCrmEntityTranslationBO() {
		return new CrmEntityBOImpl.CrmEntityTranslationBOImpl();
	}

	@Transactional
	@Override
	public CrmEntityBO save(CrmEntityBO entityBO) {
		BasicEntityTranslationHolder<CrmEntity, CrmEntityTranslation> saved = service.save(mapper.map(entityBO));

		return mapper.map(saved);
	}

	@Override
	public List<CrmEntityBO> findAll() {
		return convert(service.findAll());

	}

	@Override
	public CrmEntityBO findById(Integer id) {
		return mapper.map(service.findById(id));
	}

	private List<CrmEntityBO> convert(Iterable<BasicEntityTranslationHolder<CrmEntity, CrmEntityTranslation>> entities) {
		return StreamSupport.stream(entities.spliterator(), false)
			.map(mapper::map)
			.collect(Collectors.toList());
	}
}
