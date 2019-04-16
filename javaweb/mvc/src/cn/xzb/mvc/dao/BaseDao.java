package cn.xzb.mvc.dao;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import cn.xzb.mvc.utils.JdbcUtils;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.Connection;
import java.util.List;

/**
 * 这个是dao层里的基本类,在于被具体的dao类去继承它来用的,不能new BaseDao()来直接用
 * @author xiaozhibin
 *
 * @param <T>
 */
public class BaseDao<T> {

	QueryRunner queryRunner = new QueryRunner();
	
	private Class<T> clazz;
	
	public BaseDao(){
		//用BaseDao的构造方法初始化clazz属性  User.class
		Type superType = this.getClass().getGenericSuperclass(); // getGenericSuperclass作用是拿到调用者的父类的类型
		if(superType instanceof ParameterizedType) {
			ParameterizedType pt = (ParameterizedType) superType;
			Type[] tarry = pt.getActualTypeArguments(); // 返回一个类型数组,第一个元素就是我们要的 User.class
			if(tarry[0] instanceof Class) {
				clazz = (Class<T>) tarry[0];
			}
		}
	}
	
	public T get(String sql, Object... args) {
		Connection conn = null;
		T entity = null;
		try {
			// 拿conn
			conn = JdbcUtils.getConnection();
			entity = queryRunner.query(conn, sql, new BeanHandler<T>(clazz), args);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.closeConn(conn);
		}
		return entity;
	}
	
	public List<T> getList(String sql,Object... args){
		Connection conn = null;
		List<T> list = null;
		try {
			// 拿conn
			conn = JdbcUtils.getConnection();
			list = queryRunner.query(conn, sql, new BeanListHandler<>(clazz), args);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.closeConn(conn);
		}
		return list;
	}
	
	/**
	 * 实现insert , update , delete通用的更新方法
	 * @param sql
	 * @param args
	 * @return
	 */
	public int update(String sql,Object... args) {
		Connection conn = null;
		int rows = 0;
		try {
			// 拿conn
			conn = JdbcUtils.getConnection();
			rows = queryRunner.update(conn, sql, args);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.closeConn(conn);
		}
		return rows;
	}
	
	
	
}
