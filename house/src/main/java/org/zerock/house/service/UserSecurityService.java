package org.zerock.house.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.zerock.house.entity.User; // ▼▼▼ SiteUser를 User로 변경 ▼▼▼
import org.zerock.house.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserSecurityService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> _user = this.userRepository.findByUsername(username); // ▼▼▼ SiteUser를 User로 변경 ▼▼▼
        if (_user.isEmpty()) {
            throw new UsernameNotFoundException("사용자를 찾을수 없습니다.");
        }
        User user = _user.get(); // ▼▼▼ SiteUser를 User로 변경 ▼▼▼
        List<GrantedAuthority> authorities = new ArrayList<>();

        // "admin"이라는 username을 가진 사용자는 ADMIN 권한을, 그 외에는 USER 권한을 부여
        if ("admin".equals(username)) {
            authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
        } else {
            authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
        }
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), authorities);
    }
}