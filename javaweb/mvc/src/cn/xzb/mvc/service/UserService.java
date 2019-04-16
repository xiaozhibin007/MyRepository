package cn.xzb.mvc.service;

import java.util.List;

import cn.xzb.mvc.model.User;

public interface UserService {
	
	/**
	 * 插入一条数据
	 * @param user
	 * @return
	 */
	public int insert(User user);

	/**
	 * 根据id删除一条记录
	 * @param id
	 * @return
	 */
	public int deleteById(int id);

	/**
	 * 更新记录
	 * @param user
	 * @return
	 */
	public int update(User user);

	/**
	 * 查询所有记录
	 * @return
	 */
	public List<User> queryAll();
	
	/**
	 * 根据 username phoneNo address进行模糊查询
	 * @param username
	 * @param phoneNo
	 * @param address
	 * @return
	 */
	public List<User> queryByFiled(String username, String phoneNo, String address);
	
	/**
	 * 根据id查询
	 * @param id
	 * @return
	 */
	public User queryById(int id);
	
}
