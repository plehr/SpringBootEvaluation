package de.plehr;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends PagingAndSortingRepository<User, Long> {
	
	List<User> findByName(@Param("name") String name);
    List<User> findById(@Param("id") long id);

}
