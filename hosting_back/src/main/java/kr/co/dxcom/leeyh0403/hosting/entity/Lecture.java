package kr.co.dxcom.leeyh0403.hosting.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter @Setter // Lombok을 사용하여 Getter, Setter 자동 생성
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "lecture") // 테이블 이름 명시
public class Lecture {

    @Id // PRIMARY KEY 지정
    @GeneratedValue(strategy = GenerationType.IDENTITY) // AUTO_INCREMENT 설정
    @Column(name = "lecture_no")
    private Integer lectureNo;
    // @Id @GeneratedValue를 사용할 경우에는 int보다 Integer를 사용하는 것이 더 안전하고 권장됩니다.

    @Column(name = "lecture_name", nullable = false) // 컬럼이름 명시, NOT NULL 설정
    private String lectureName;

    @Column(name = "lecture_start")
    private LocalDate lectureStart;

    @Column(name = "lecture_end")
    private LocalDate lectureEnd;

}
