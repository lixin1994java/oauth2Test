package com.oath2test.auth2server.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.oath2test.auth2server.mapper.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.AutoPopulatingList;

import java.util.List;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    UserDao userDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        QueryWrapper<com.oath2test.auth2server.entity.User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", username);
        com.oath2test.auth2server.entity.User user = userDao.selectOne(queryWrapper);//
        List<GrantedAuthority> role_user = AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_USER");
        return new User(user.getUsername(),user.getPassword() , role_user);
    }
}
