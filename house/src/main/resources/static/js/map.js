// map.js 전체 코드
const mapContainer = document.getElementById('map');
const mapOption = {
    center: new kakao.maps.LatLng(37.566826, 126.9786567),
    level: 7
};
const map = new kakao.maps.Map(mapContainer, mapOption);

const sidebarMenus = document.querySelectorAll('.sidebar-menu li');
const listingItemsContainer = document.querySelector('.listing-items');
let markers = [];

function loadData(type) {
    removeMarkers();
    listingItemsContainer.innerHTML = '';

    const params = new URLSearchParams({ type: type });
    const url = `/api/rooms?${params.toString()}`;

    fetch(url)
        .then(response => {
            if (!response.ok) {
                throw new Error('네트워크 오류 발생');
            }
            return response.json();
        })
        .then(rooms => {
                    rooms.forEach(room => {
                        const listItem = document.createElement('article');
                        listItem.className = 'listing-card';

                        const imageUrl = room.imageUrl;

                        // ▼▼▼ [수정] HTML 생성 부분을 div 배경 방식에서 img 태그 방식으로 변경 ▼▼▼
                        listItem.innerHTML = `
                            <a href="/room/${room.id}" class="card-link">
                                <div class="image">
                                    <img src="${imageUrl}" alt="매물 사진">
                                </div>
                                <div class="info">
                                    <h3>${room.title}</h3>
                                    <p>${room.type}, ${room.address}</p>
                                </div>
                            </a>
                        `;
                        listingItemsContainer.appendChild(listItem);

                const marker = new kakao.maps.Marker({
                    map: map,
                    position: new kakao.maps.LatLng(room.latitude, room.longitude),
                    title: room.title
                });
                markers.push(marker);

                const infowindow = new kakao.maps.InfoWindow({
                    content: `<div style="padding:5px;font-size:12px;width:200px;">
                                <strong style="font-size:14px;">${room.title}</strong><br>
                                <span style="color:gray;">${room.type}</span><br>
                                <span>${room.address}</span>
                             </div>`,
                    removable: true
                });

                kakao.maps.event.addListener(marker, 'mouseover', function () { infowindow.open(map, marker); });
                kakao.maps.event.addListener(marker, 'mouseout', function () { infowow.close(); });
                kakao.maps.event.addListener(marker, 'click', function () {
                    document.querySelectorAll('.listing-card').forEach(item => { item.classList.remove('active'); });
                    listItem.classList.add('active');
                    listItem.scrollIntoView({ behavior: 'smooth' });
                });
            });
        })
        .catch(error => {
            console.error('Fetch 에러:', error);
            alert('데이터를 불러오는 중 오류가 발생했습니다.');
        });
}

function removeMarkers() {
    for (let i = 0; i < markers.length; i++) {
        markers[i].setMap(null);
    }
    markers = [];
}

sidebarMenus.forEach(menu => {
    menu.addEventListener('click', (e) => {
        const type = e.currentTarget.dataset.type;
        updateActiveMenu(type);
        loadData(type);
    });
});

function updateActiveMenu(activeType) {
    sidebarMenus.forEach(menu => {
        if (menu.dataset.type === activeType) {
            menu.classList.add('active');
        } else {
            menu.classList.remove('active');
        }
    });
}

document.addEventListener('DOMContentLoaded', function () {
    const urlParams = new URLSearchParams(window.location.search);
    const typeFromUrl = urlParams.get('type');
    const initialType = typeFromUrl || '원룸/투룸';

    updateActiveMenu(initialType);
    loadData(initialType);
});