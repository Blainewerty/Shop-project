package ru.milov.shoptest.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.milov.shoptest.dto.UserDto;
import ru.milov.shoptest.entity.Roles;
import ru.milov.shoptest.entity.User;
import ru.milov.shoptest.mappers.UserMapper;
import ru.milov.shoptest.repository.UserRepository;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;

    private final UserMapper userMapper;

    private final PasswordEncoder passwordEncoder;

//    private final MailSender mailSender;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        return userRepository.findByLogin(login);
    }

    public User getUser(String login) {
        return userRepository.findByLogin(login);
    }

    public boolean addUser(User user) {
        User userFromDb = userRepository.findByLogin(user.getLogin());

        if (userFromDb != null) {
            return false;
        }

        user.setActive(true);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRoles(Collections.singleton(Roles.USER));
        user.setActivationCode(UUID.randomUUID().toString());

        userRepository.save(user);

//        if(!StringUtils.isEmpty(user.getEmail())) {
//            String message = String.format("Hello, %s!+ \n" +
//                    "Welcome to our Shop! \n" +
//                    "Please go to: http://localhost:8080/activate/%s", user.getLogin(), user.getActivationCode());
//            mailSender.send(user.getEmail(), "Activation code", message);
//        }

        return true;
    }

    public boolean activateUser(String code) {
        User user = userRepository.findByActivationCode(code);

        if (user == null) return false;

        user.setActivationCode(null);

        userRepository.save(user);

        return true;
    }

    @Transactional(readOnly = true)
    public List<UserDto> findAll() {
        return userRepository.findAll().stream()
                .map(userMapper::toDto)
                .collect(Collectors.toList());
    }

}
