package Techeer.HealthIn.backend.domain.user.repository;

import Techeer.HealthIn.backend.domain.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Query(value = "select u from User u where u.uuid = :uuid and u.isActivated = true")
    User findUserByUuid(@Param("uuid")UUID uuid);
}
