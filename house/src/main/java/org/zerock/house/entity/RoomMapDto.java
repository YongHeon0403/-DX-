package org.zerock.house.entity;

// Lombok @Getter를 그대로 두거나, 아래처럼 수동으로 getter를 추가합니다.
// 수동 getter가 있으면 Lombok 설정과 무관하게 항상 동작합니다.
public class RoomMapDto {
    private Long id;
    private String title;
    private String type;
    private String address;
    private Double latitude;
    private Double longitude;
    private String imageUrl;

    // 생성자는 그대로 유지합니다.
    public RoomMapDto(Room room) {
        this.id = room.getId();
        this.title = room.getTitle();
        this.type = room.getType();
        this.address = room.getAddress();
        this.latitude = room.getLatitude();
        this.longitude = room.getLongitude();

        if (room.getImages() != null && !room.getImages().isEmpty()) {
            this.imageUrl = "/uploads/" + room.getImages().get(0).getImageName();
        } else {
            this.imageUrl = "/images/default-placeholder.png";
        }
    }

    // ▼▼▼ [수정] 모든 필드에 대한 getter 메소드를 직접 추가 ▼▼▼
    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getType() {
        return type;
    }

    public String getAddress() {
        return address;
    }

    public Double getLatitude() {
        return latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public String getImageUrl() {
        return imageUrl;
    }
}