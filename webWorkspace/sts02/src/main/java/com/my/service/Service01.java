package com.my.service;

import com.my.module.Module01;
import com.my.module.Module02;
import com.my.module.MyModule;

public class Service01 {
	MyModule module;
	private void servi() {
	}
	
	//DI(������ ����, (������ ����))
	public Service01(MyModule module) {
		super();
		this.module = module;
	}

	//DI(������ ����, (setter ����))
	public void setModule(MyModule module) {
		this.module = module;
	}
	
	public void serv01() {
		module.func01();	
	}
	
	//IoC ������ ����
	public void serv01(MyModule my) {
		MyModule module=my;
		module.func01();	
	}
}
