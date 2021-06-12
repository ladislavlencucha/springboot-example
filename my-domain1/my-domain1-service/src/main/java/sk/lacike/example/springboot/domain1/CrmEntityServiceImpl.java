package sk.lacike.example.springboot.domain1;

import javax.transaction.Transactional;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import sk.lacike.example.springboot.common.BasicEntityTranslationHolder;

@Service
@AllArgsConstructor
public class CrmEntityServiceImpl implements CrmEntityService {

	private final CrmEntityRepository repository;

	@Transactional
	@Override
	public BasicEntityTranslationHolder<CrmEntity, CrmEntityTranslation> save(BasicEntityTranslationHolder<CrmEntity, CrmEntityTranslation> holder) {
		return repository.saveHolder(holder);
	}

	@Override
	public Iterable<BasicEntityTranslationHolder<CrmEntity, CrmEntityTranslation>> findAll() {
		return repository.findHolderAll();
	}

	@Override
	public BasicEntityTranslationHolder<CrmEntity, CrmEntityTranslation> findById(Integer id) {
		return repository.findHolderById(id)
			.orElseThrow(() -> new IllegalArgumentException("MyEntity not found by id=" + id));
	}

}
