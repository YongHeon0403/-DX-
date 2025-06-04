package kr.co.dxcom.leeyh0403.hosting.service;

import kr.co.dxcom.leeyh0403.hosting.entity.Host;
import kr.co.dxcom.leeyh0403.hosting.repository.HostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HostService {

    @Autowired
    private HostRepository hostRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

//        public LoginResponseDto login(LoginRequestDto loginRequestDto) {
//            // 1. 사용자 ID로 데이터베이스에서 회원 정보 조회
//            Host host = hostRepository.findByUserId(loginRequestDto.getUserId())
//                    .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 사용자입니다."));
//
//            // 2. 비밀번호 검증
//            if (!bCryptPasswordEncoder.matches(loginRequestDto.getUserPw(), host.getUserPw())) {
//                throw new IllegalArgumentException("비밀번호가 일치하지 않습니다.");
//            }
//
//            // 3. JWT 토큰 생성 (기본 권한: ROLE_USER)
//            String authorities = "ROLE_USER";
//            String accessToken = jwtTokenProvider.createToken(host.getUserId(), authorities);
//
//            // 4. 로그인 응답 DTO 생성 및 반환
//            return LoginResponseDto.builder()
//                    .accessToken(accessToken)
//                    .tokenType("Bearer")
//                    .expiresIn(jwtTokenProvider.getExpiration())
//                    .userId(host.getUserId())
//                    .userName(host.getUserId()) // 또는 실제 사용자 이름 필드가 있다면 사용
//                    .build();
//        }

    public List<Host> getAllHosts() {
        return hostRepository.findAll(); //모든 Host정보 조회
    }

    public Host getHostById(Integer hostNo) {
        return hostRepository.findById(hostNo).orElse(null); //hostNo로 Host정보조회
    }

    public Host createHost(Host host) {
        // 비밀번호 암호화
        String encodedPassword = bCryptPasswordEncoder.encode(host.getUserPw());
        host.setUserPw(encodedPassword);

        return hostRepository.save(host);
    }

    public Host updateHost(Integer hostNo, Host host) {
        Host updateHost = hostRepository.findById(hostNo).orElse(null);
        if (updateHost != null) {
            host.setHostNo(hostNo);
            // 비밀번호 암호화(수정시에도 암호화)
            String encodedPassword = bCryptPasswordEncoder.encode(host.getUserPw());
            host.setUserPw(encodedPassword);

            return hostRepository.save(host);
        }
        return null;
    }

    public void deleteHost(Integer hostNo) {
        hostRepository.deleteById(hostNo);
    }

    public Host getHostByUserId(String userId) {
        return hostRepository.findByUserId(userId).orElse(null); // userId로 Host 정보 조회
    }

}
