package dong.security.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import dong.security.entity.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

	@Query(value = "select * from task", nativeQuery = true)
	List<Task> findAll();
}
