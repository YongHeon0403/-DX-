package org.zerock.house.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // --- 기본 정보 ---
    private String title;
    private String address;
    private Double latitude;
    private Double longitude;

    // --- 매물 정보 ---
    private String type;
    private Double contractArea;
    private Double exclusiveArea;
    private Double usageRatio;
    private String buildingScale;
    private String moveInDate;
    private Integer numberOfRooms;
    private Integer numberOfBathrooms;
    private String direction;
    private String internalStructure;
    private String veranda;
    private String heatingType;
    private String elevator;
    private String parking;

    // --- 가격 정보 ---
    private Long price;
    private Long loan;

    // --- 매물 설명 ---
    @Column(columnDefinition = "TEXT")
    private String description;

    // 여러 이미지를 저장하기 위한 관계 설정
    @OneToMany(mappedBy = "room", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference // [추가] 순환 참조의 부모임을 명시
    private List<RoomImage> images = new ArrayList<>();
}