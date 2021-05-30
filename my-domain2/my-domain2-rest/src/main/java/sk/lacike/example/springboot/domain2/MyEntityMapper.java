package sk.lacike.example.springboot.domain2;

import java.util.List;

import org.mapstruct.Mapper;

@Mapper(componentModel="spring")
public interface MyEntityMapper {

	MyEntityJson map(MyEntityBO entity);
	List<MyEntityJson> map(List<MyEntityBO> entityBOs);

	MyEntityBO map(MyEntityJson json);
}
