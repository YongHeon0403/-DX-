package kr.co.dxcom.leeyh0403.hosting.controller;

import kr.co.dxcom.leeyh0403.hosting.entity.Host;
import kr.co.dxcom.leeyh0403.hosting.service.HostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * HostController - JWT 로그인 엔드포인트 추가
 * SpringBoot 3.5와 Spring Security 6 호환
 */
@RestController //Spring Bean으로 등록,REST Controller임을 명시
@RequestMapping("/hosts") //기본 url경로설정
public class HostController {

    @Autowired
    private HostService hostService; //HostService 주입

    @GetMapping //Get요청처리, 모든 Host 정보조회
    public ResponseEntity<List<Host>> getAllHosts() {
        List<Host> hosts = hostService.getAllHosts();
        return new ResponseEntity<>(hosts, HttpStatus.OK); // 조회된 Host 정보와 HTTP 상태 코드 200 반환
    }

    @GetMapping("/{hostNo}")
    public ResponseEntity<Host> getHost(@PathVariable Integer hostNo) {
        Host host = hostService.getHostById(hostNo);
        if (host != null) {
            return new ResponseEntity<>(host, HttpStatus.OK);  // 조회된 Host 정보와 HTTP 상태 코드 200 반환
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); // Host 정보가 없을 경우 HTTP 상태 코드 404 반환
        }
    }

    @PostMapping // POST 요청 처리, Host 정보 생성
    public ResponseEntity<Host> createHost(@RequestBody Host host) {
        Host createHost = hostService.createHost(host);
        return new ResponseEntity<>(createHost, HttpStatus.CREATED); // 생성된 Host 정보와 HTTP 상태 코드 201 반환
    }

    @PutMapping("/{hostNo}") // PUT 요청 처리, 특정 hostNo의 Host 정보 수정
    public ResponseEntity<Host> updateHost(@PathVariable Integer hostNo, @RequestBody Host host) {
        Host updatedHost = hostService.updateHost(hostNo,host);
        if (updatedHost != null) {
            return new ResponseEntity<>(updatedHost, HttpStatus.OK); // 수정된 Host 정보와 HTTP 상태 코드 200 반환
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); // Host 정보가 없을 경우 HTTP 상태 코드 404 반환
        }
    }

    @DeleteMapping("/{hostNo}") // DELETE 요청 처리, 특정 hostNo의 Host 정보 삭제
    public ResponseEntity<Host> deleteHost(@PathVariable Integer hostNo) {
        hostService.deleteHost(hostNo);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT); // HTTP 상태 코드 204 반환
    }

    @GetMapping("/user/{userId}") // GET 요청 처리, 특정 userId의 Host 정보 조회
    public ResponseEntity<Host> getHostByUserId(@PathVariable String userId) {
        Host host = hostService.getHostByUserId(userId);
        if (host != null) {
            return new ResponseEntity<>(host, HttpStatus.OK); // 조회된 Host 정보와 HTTP 상태 코드 200 반환
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); // Host 정보가 없을 경우 HTTP 상태 코드 404 반환
        }
    }

}
