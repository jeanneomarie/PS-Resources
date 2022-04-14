package utcn.ps.backend.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import utcn.ps.backend.entity.Teacher;
import utcn.ps.backend.persistance.TeacherRepository;

import java.util.Collections;

@Service
@RequiredArgsConstructor
public class TeacherUserDetailsService implements UserDetailsService {
    private final TeacherRepository teacherRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Teacher teacher = teacherRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Unknown Teacher!"));
        return new User(teacher.getUsername(), teacher.getPassword(),
                Collections.singletonList(new SimpleGrantedAuthority("ROLE_TEACHER")));
        // noia vem aici un singur rol, dar voi in aplicatie daca faceti si partea cu moderatori,
        // puteti aici sa adaugati rolurile si apoi daca mergeti in SecurityConfiguration
    }
}
