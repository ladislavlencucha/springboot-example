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
public class CrmEntityServiceImpl implements CrmEntityService {

	private final CrmEntityRepository repository;

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
		BasicEntityTranslationHolder<CrmEntity, CrmEntityTranslation> saved = repository.saveHolder(convert(entityBO));

		return convert(saved);
	}

	@Override
	public List<CrmEntityBO> findAll() {
		return convert(repository.findHolderAll());

	}

	@Override
	public CrmEntityBO findById(Integer id) {
		return convert(repository.findHolderById(id)
			.orElseThrow(() -> new IllegalArgumentException("MyEntity not found by id=" + id)));
	}

	private BasicEntityTranslationHolder<CrmEntity, CrmEntityTranslation> convert(CrmEntityBO entityBO) {
		return ((CrmEntityBOImpl) entityBO).unwrap();
	}

	private CrmEntityBO convert(BasicEntityTranslationHolder<CrmEntity, CrmEntityTranslation> holder) {
		return new CrmEntityBOImpl(holder);
	}

	private List<CrmEntityBO> convert(Iterable<BasicEntityTranslationHolder<CrmEntity, CrmEntityTranslation>> entities) {
		return StreamSupport.stream(entities.spliterator(), false)
			.map(CrmEntityBOImpl::new)
			.collect(Collectors.toList());
	}
}
