package org.zerock.jdbcex.domain;

import lombok.*;

import java.time.LocalDate;

@Getter    // VO는 주로 읽기 전용으로 사용하는 경우가 많으므로 @Getter 사용
@Builder   // 객체 생성 시 빌더 패턴을 이용하기 위해서 @Builder 사용
@ToString
@AllArgsConstructor    // 모든 매개변수를 가지는 생성자
@NoArgsConstructor     // 기본 생성자
public class TodoVO {
    private Long tno;
    private String tittle;
    private LocalDate dueDate;
    private boolean finished;
}
