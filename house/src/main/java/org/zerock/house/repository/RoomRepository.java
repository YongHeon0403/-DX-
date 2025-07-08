package org.zerock.house.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.zerock.house.entity.Room;

import java.util.List;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {

    // type 필드로 Room 리스트를 찾는 메서드
    List<Room> findByType(String type);
}