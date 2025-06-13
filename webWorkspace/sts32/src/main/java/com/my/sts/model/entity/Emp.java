package com.my.sts.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
//@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Emp {

//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int num;
//	@Column(name="id")
	private String name;
	private String email;
	private String pw;
}
