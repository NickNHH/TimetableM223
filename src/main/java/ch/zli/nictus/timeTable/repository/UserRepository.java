package ch.zli.nictus.timeTable.repository;

import ch.zli.nictus.timeTable.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
