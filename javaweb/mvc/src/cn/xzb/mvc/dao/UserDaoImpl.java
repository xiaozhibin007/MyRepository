package cn.xzb.mvc.dao;

import java.util.List;

import cn.xzb.mvc.model.User;

public class UserDaoImpl extends BaseDao implements UserDao {
	
	@Override
	public int insert(User user) {
		String sql = "INSERT INTO `users` (`username`, `password`, `phone_no`, `address`, `reg_date`) VALUES(?,?,?,?,?)";
		return super.update(sql, user.getUsername(), user.getPassword(), user.getPhoneNo(), user.getAddress(), user.getRegDate());
	}
	
	@Override
	public int deleteById(int id) {
		String sql = "DELETE FROM `users` WHERE `id`=?";
		return super.update(sql, id);
	}
	
	@Override
	public int update(User user) {
		String sql = "UPDATE `users` SET `username`=?,`pasword`=?,`phone_no`=?,`address`=? WHERE `id`=?";
		return super.update(sql, user.getUsername(), user.getPassword(), user.getPhoneNo(), user.getAddress(), user.getId());
	}

	@Override
	public List<User> queryAll() {
		String sql = "SELECT * FROM users";
		return super.getList(sql);
	}
	
	
	@Override
	public List<User> queryByFiled(String username, String phoneNo, String address) {
		String sql = "SELECT * FROM users WHERE 1=1";
		if(username!=null && !"".equals(username)) {
			sql = sql + " AND username like '%"+username+"%'";
		}
		if(phoneNo!=null && !"".equals(phoneNo)) {
			sql = sql + " AND phone_no like '%"+phoneNo+"%'";
		}
		if(address!=null && !"".equals(address)) {
			sql = sql + " AND address like '%"+address+"%'";
		}
		return super.getList(sql);
	}

	@Override
	public User queryById(int id) {
		String sql = "SELECT * FROM users WHERE id=?";
		return (User)super.get(sql, id);
	}

}
