package com.sts.userapi.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserVo {
    int num;
    String name, email;

    //responseVo와 requestVo 구분해서 만들면 ignore로 보이지 않게
    // @JsonIgnore(o) - UserResponseVo
    // @JsonIgnore(x) - UserRequestVo
    String pw;
}
