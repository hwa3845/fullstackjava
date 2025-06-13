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
public class Auths {
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int num;

//	@Column(name="id")
	String name;
	
	String auth;
}
