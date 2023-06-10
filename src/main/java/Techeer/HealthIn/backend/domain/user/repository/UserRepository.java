package Techeer.HealthIn.backend.domain.user.repository;

import Techeer.HealthIn.backend.domain.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.Valid;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Query(value = "select u from User u where u.uuid = :uuid and u.isActivated = true")
    User findUserByUuid(@Param("uuid") UUID uuid);

    @Modifying
    @Transactional
    @Query(value = "update User u set u.isActivated = false where u.uuid = :uuid")
    void deleteByUuid(@Param("uuid") UUID uuid);
}
