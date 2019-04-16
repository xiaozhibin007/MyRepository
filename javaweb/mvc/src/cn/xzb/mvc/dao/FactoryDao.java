package cn.xzb.mvc.dao;

public class FactoryDao {
	
	public static UserDao getUserDao() {
		return new UserDaoImpl();
	}
	
}
