package in.ashokit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.data.rest.core.mapping.ExposureConfiguration;

import in.ashokit.entity.BookEntity;


@RepositoryRestResource(path="book")
public interface BookRepository extends JpaRepository<BookEntity,Integer>{
	
//	 @RestResource(exported = false)
//	void deleteById(Integer id);
	
	
	}
