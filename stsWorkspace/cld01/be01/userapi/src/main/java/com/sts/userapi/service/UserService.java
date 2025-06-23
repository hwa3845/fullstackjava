package com.sts.userapi.service;

import org.springframework.stereotype.Service;

import com.sts.userapi.model.UserRepo;
import com.sts.userapi.model.UserVo;
import com.sts.userapi.model.entity.User;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Optional;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepo userRepo;
    //@Value
    String alg="SHA-256";
    //key -> 보안 강화
    String key="mykey";

    public UserVo add(UserVo bean){
        //getName-> 같은 pw 중복 방지
        String pw=bean.getName()+key+bean.getPw();
        try {
            MessageDigest md=MessageDigest.getInstance(alg);
            md.update(pw.getBytes());
            pw=Base64.getUrlEncoder().encodeToString(md.digest());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        User user=User.builder()
                    .num(bean.getNum())
                    .name(bean.getName())
                    .pw(pw)
                    .email(bean.getEmail())
                    .build();
        return userRepo.save(user).voBuild();
    }

    public Optional<UserVo> sign(UserVo bean){
        String pw=bean.getName()+key+bean.getPw();
        try {
            MessageDigest md=MessageDigest.getInstance(alg);
            md.update(pw.getBytes());
            pw=Base64.getUrlEncoder().encodeToString(md.digest());
            Optional<User> opt=userRepo.findByNameAndPw(bean.getName(),pw);
            return Optional.of(opt.get().voBuild());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return Optional.empty();
        }
    }

    public void deleteOne(String name){
        userRepo.delete(userRepo.findByName(name));
    }
}
