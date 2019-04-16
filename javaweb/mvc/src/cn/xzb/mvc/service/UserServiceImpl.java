package cn.xzb.mvc.service;

import java.util.List;

import cn.xzb.mvc.dao.FactoryDao;
import cn.xzb.mvc.dao.UserDao;
import cn.xzb.mvc.model.User;

public class UserServiceImpl implements UserService {
	
	UserDao userDao = FactoryDao.getUserDao();
	
	@Override
	public int insert(User user) {
		return userDao.insert(user);
	}

	@Override
	public int deleteById(int id) {
		return userDao.deleteById(id);
	}

	@Override
	public int update(User user) {
		return userDao.update(user);
	}

	@Override
	public List<User> queryAll() {
		return userDao.queryAll();
	}

	@Override
	public List<User> queryByFiled(String username, String phoneNo, String address) {
		return userDao.queryByFiled(username, phoneNo, address);
	}

	@Override
	public User queryById(int id) {
		return userDao.queryById(id);
	}

}
