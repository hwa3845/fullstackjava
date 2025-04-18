package com.web08.model;

import java.sql.Date;

public class Bbs07Bean {
	//javabean -> set필드명 첫 글자를 대문자로 만들기 때문에 소문자로 시작한다는 명명규칙 지켜야 함
	private int num,lvl;
	private String sub, content,id;
	private Date nalja;
	public int getLvl() {
		return lvl;
	}
	public void setLvl(int lvl) {
		this.lvl = lvl;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getSub() {
		return sub;
	}
	public void setSub(String sub) {
		this.sub = sub;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getNalja() {
		return nalja;
	}
	public void setNalja(Date nalja) {
		this.nalja = nalja;
	}
}
