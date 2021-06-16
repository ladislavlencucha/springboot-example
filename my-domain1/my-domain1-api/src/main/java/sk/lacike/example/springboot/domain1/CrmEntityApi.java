package sk.lacike.example.springboot.domain1;

import java.util.List;

public interface CrmEntityApi {

	CrmEntityBO newCrmEntityBO();
	CrmEntityBO.CrmEntityTranslationBO newCrmEntityTranslationBO();

	CrmEntityBO save(CrmEntityBO entityBO);
	List<CrmEntityBO> findAll();
	CrmEntityBO findById(Integer id);

}
