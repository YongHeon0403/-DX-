package kr.co.dxcom.leeyh0403.hosting.repository;

import kr.co.dxcom.leeyh0403.hosting.entity.Lecture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository // spring Bean으로 등록, 데이터 접근 계층임을 명시
public interface LectureRepository extends JpaRepository<Lecture, Integer> { // JpaRepository<엔티티 타입, 기본 키 타입>

//    /* 수업에서 사용하진 않지만 알아두면 좋음 */
//    //
//    Optional<Object> findByLecture(Integer lectureNo); // Optional<리턴타입> findBy[엔티티의 필드명](필드값)
//
//    // Lecture 엔티티의 title 필드가 일치하는 모든 강의 조회
//    List<Lecture> findByLectureName(String lectureName);
//
//    // 등록일이 특정 날짜 이후인 강의 조회
//    List<Lecture> findByLectureEndAfter(LocalDate lectureEnd);

}
