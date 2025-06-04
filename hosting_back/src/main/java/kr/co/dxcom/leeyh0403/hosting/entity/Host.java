package kr.co.dxcom.leeyh0403.hosting.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "host")
public class Host {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "host_no")
    private Integer hostNo;

    @ManyToOne(fetch = FetchType.LAZY) // lecture Entity와 ManyToOne 관계설정
    @JoinColumn(name = "lecture_no") // 외래 키 컬럼명 지정
    private Lecture lectureNo;

    @Column(name = "user_name", nullable = false)
    private String userName;

    @Column(name = "user_phone", nullable = false)
    private String userPhone;

    @Column(name = "user_id", nullable = false, unique = true) // 테이블 내에서 유일해야 한다
    private String userId;

    @Column(name = "user_pw", nullable = false) // NULL 값을 허용하지 않는다
    private String userPw;

    @Column(name = "user_role", nullable = false)
    private String userRole;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

}
