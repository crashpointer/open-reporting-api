package org.crash.reporting.api.service;

import org.crash.reporting.api.dao.UserRepository;
import org.crash.reporting.api.model.User;
import org.crash.reporting.api.security.UserDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class UserDetailService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email).orElseThrow(
                () -> new UsernameNotFoundException(
                        String.format("User not found with email : %s", email)
                )
        );

        return new UserDetail(user);
    }

    public UserDetails loadUserById(int id){
        User user = userRepository.findById(id).orElseThrow(
                () -> new UsernameNotFoundException(
                        String.format("User not found with id : %d", id)
                )
        );

        return new UserDetail(user);
    }

}
