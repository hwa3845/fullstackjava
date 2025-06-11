package com.my.sts.model.entity;

import com.my.sts.model.DeptVo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Dept{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //auto_increment
//	@GeneratedValue(strategy = GenerationType.SEQUENCE) //oracle:sequence
	//sequence 없을 때 sequence에 해당하는 별도의 테이블을 만듦
//	@GeneratedValue(strategy = GenerationType.TABLE) 
//	@GeneratedValue(strategy = GenerationType.AUTO) //방언 적용에 따라 자동 적용 
	private int deptno;

	@Column(length = 10, nullable = false)
	private String dname;
	
	@Column(length = 10, nullable = true)
	private String loc;
	
//	@Transient
//	@Column(columnDefinition = "TEXT")
//	private String memo;
	
	public DeptVo voBuild() {
		return DeptVo.builder()
				.deptno(deptno)
				.dname(dname)
				.loc(loc)
				.build();
	}
}
