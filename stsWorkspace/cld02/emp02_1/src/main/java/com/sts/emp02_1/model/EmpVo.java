package com.sts.emp02_1.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
public class EmpVo {
    private int empno;
    
    private String ename;
    private String job;
    private int sal;

}
