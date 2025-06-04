package kr.co.dxcom.leeyh0403.hosting.service;


import kr.co.dxcom.leeyh0403.hosting.entity.Lecture;
import kr.co.dxcom.leeyh0403.hosting.repository.LectureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LectureService {

    @Autowired
    private LectureRepository lectureRepository; // LectureRepository 주입

    public List<Lecture> getAllLectures() {
        return lectureRepository.findAll(); // 모든 Lecture 정보 조회
    }

    public Lecture getLectureByLectureNo(Integer lectureNo) {
        return lectureRepository.findById(lectureNo).orElse(null);
    }

    public Lecture createLecture(Lecture lecture) {
        return lectureRepository.save(lecture);
    }

    public Lecture updateLecture(Integer lectureNo, Lecture lecture) { // lectureNo : 수정할 대상, lecture : 수정할 내용을 담은 객체
        Lecture oldLecture = lectureRepository.findById(lectureNo).orElse(null);
        if (oldLecture != null) {
            lecture.setLectureNo(lectureNo);
            return lectureRepository.save(lecture);
            // save(): ID가 없으면 insert (삽입), ID가 있으면 update (수정)
        }
        return null;
    }

    public void deleteLecture(Integer lectureNo) {
        lectureRepository.deleteById(lectureNo);
    }

}
