package org.zerock.house.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true) // username은 유일해야 합니다.
    private String username;

    private String password;

    private String role; // 사용자의 권한 (예: "USER", "ADMIN")
}