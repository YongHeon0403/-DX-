package kr.co.dxcom.leeyh0403.hosting.repository;

import kr.co.dxcom.leeyh0403.hosting.entity.Host;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface HostRepository extends JpaRepository<Host, Integer> { // JpaRepository<엔티티 타입, 기본 키 타입>

    // 필요한 경우 추가적인 쿼리 메서드 정의 가능
    Optional<Host> findByUserId(String userId);
}
