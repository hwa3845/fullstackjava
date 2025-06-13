package com.my.sts.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Emp {

	@Id
	private int empno;
	private String ename;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="deptno")
	private Dept dept;
}
