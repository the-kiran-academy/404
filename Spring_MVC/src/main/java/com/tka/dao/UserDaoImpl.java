package com.tka.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tka.entity.User;

@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public User loginUser(String username, String password) {
		User user = null;

		try (Session session = sessionFactory.openSession()) {

			String hql = "FROM User WHERE username= :un and password= :pass";

			Query<User> query = session.createQuery(hql);
			query.setParameter("un", username);
			query.setParameter("pass", password);

			user = query.uniqueResult();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return user;
	}

	@Override
	public int registerUser(User user) {
		int status = 0;
		try (Session session = sessionFactory.openSession()) {
			Transaction transaction = session.beginTransaction();
			session.persist(user);
			transaction.commit();
			status = 1;

		} catch (Exception e) {
			e.printStackTrace();
			status = 0;
		}
		return status;
	}

	@Override
	public List<User> allUser() {
		List<User> list = null;
		try (Session session = sessionFactory.openSession()) {
			String hql = "FROM User";
			Query<User> query = session.createQuery(hql);
			list = query.list();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public boolean deleteUser(int id) {
		boolean isDeleted = false;
		try (Session session = sessionFactory.openSession()) {
			Transaction transaction = session.beginTransaction();
			User user = session.get(User.class, id);
			session.delete(user);
			transaction.commit();
			isDeleted = true;

		} catch (Exception e) {
			e.printStackTrace();

		}
		return isDeleted;
	}

	@Override
	public User getUser(int id) {
		User user = null;
		try (Session session = sessionFactory.openSession()) {

			user = session.get(User.class, id);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public boolean updateProfile(User user) {
		boolean isUpdated=false;
		try (Session session = sessionFactory.openSession()) {
			Transaction transaction = session.beginTransaction();
			session.update(user);
			transaction.commit();
			isUpdated=true;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return isUpdated;
	}

}
