package sk.lacike.example.springboot.domain3;

public interface SimulationResultBO {
	Integer getId();

	String getName();

	String getDescription();

	sk.lacike.example.springboot.domain1.CrmEntity getRequestor();

	void setId(Integer id);

	void setName(String name);

	void setDescription(String description);

	void setRequestor(sk.lacike.example.springboot.domain1.CrmEntity requestor);
}
