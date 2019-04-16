package cn.xzb.mvc.service;

public class FactoryService {
	
	public static UserService getUserService() {
		return new UserServiceImpl();
	}
	
}
