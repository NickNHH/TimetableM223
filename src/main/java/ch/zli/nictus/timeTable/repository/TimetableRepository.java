package ch.zli.nictus.timeTable.repository;

import ch.zli.nictus.timeTable.model.Timetable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TimetableRepository extends JpaRepository<Timetable, Long> {
}
