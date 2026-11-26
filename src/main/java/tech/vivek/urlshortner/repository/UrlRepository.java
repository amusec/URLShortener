package tech.vivek.urlshortner.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.vivek.urlshortner.entity.UrlRegisterEntity;

import java.util.Optional;
import java.util.UUID;

public interface UrlRepository extends JpaRepository<UrlRegisterEntity, UUID> {
    Optional<UrlRegisterEntity> findByShortCode(String short_code);

}
