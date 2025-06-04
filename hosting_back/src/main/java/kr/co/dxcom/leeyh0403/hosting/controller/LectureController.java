package kr.co.dxcom.leeyh0403.hosting.controller;

import kr.co.dxcom.leeyh0403.hosting.entity.Lecture;
import kr.co.dxcom.leeyh0403.hosting.service.LectureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lectures")
public class LectureController {

    @Autowired
    private LectureService lectureService;

    @GetMapping // GET 요청처리, 모든 lecture 정보 조회
    public ResponseEntity<List<Lecture>> getAllLecture() {
        List<Lecture> lectures = lectureService.getAllLectures();

        return new ResponseEntity<>(lectures, HttpStatus.OK);
    }

    @GetMapping("/{lectureNo}") // GET 요청처리, 특정 lectureNo의 Lecture 정보 조회
    public ResponseEntity<Lecture> getLectureByLectureNo(@PathVariable Integer lectureNo) {
        Lecture lecture = lectureService.getLectureByLectureNo(lectureNo);
        if (lecture != null) {
            return new ResponseEntity<>(lecture, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping //Post 요청처리, lecture정보생성
    public ResponseEntity<Lecture> createLecture(@RequestBody Lecture lecture) {
        Lecture createLecture = lectureService.createLecture(lecture);
        return new ResponseEntity<>(createLecture, HttpStatus.CREATED); // 생성된 lecture 정보와 http 상태코드 201 반환
    }

    @PutMapping("/{lectureNo}") //PUT 요청처리, 특정 LectureNo의 Lecture 정보수정
    public ResponseEntity<Lecture> updateLecture(@PathVariable Integer lectureNo, @RequestBody Lecture lecture) {
        Lecture updatedLecture = lectureService.updateLecture(lectureNo, lecture);
        if (updatedLecture != null) {
            return new ResponseEntity<>(updatedLecture, HttpStatus.OK); //수정된 Lecture 정보와 HTTP 상태 코드 200 반환
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); // Lecture 정보가 없을 경우 HTTP 상태 코드 404 반환
        }
    }

    @DeleteMapping("/{lectureNo}") // DELETE 요청 처리, 특정 lectureNo의 Lecture 정보 삭제
    public ResponseEntity<Void> deleteLecture(@PathVariable Integer lectureNo) {
        lectureService.deleteLecture(lectureNo);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);// HTTP 상태 코드 204 반환
    }

}
