package com.tka.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tka.entity.BankAccount;

@Repository
public class BankAccountDaoImpl implements BankAccountDao {

	@Autowired
	private SessionFactory sf;

	private Session getSession() {
		return sf.openSession();
	}

	@Override
	public boolean createAccount(BankAccount account) {

		try {
			Session session = sf.openSession();
			session.save(account);
			session.beginTransaction().commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	@Override
	public BankAccount getAccountById(long id) {
		try {
			Session session = sf.openSession();
			BankAccount bankAccount = session.get(BankAccount.class, id);
			return bankAccount;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public String deleteAccount(long id) {
		try {
			Session session = sf.openSession();
			BankAccount bankAccount = session.get(BankAccount.class, id);

			if (bankAccount != null) {
				session.delete(null);
				session.beginTransaction().commit();
				return "Deleted !!";
			} else {
				return " Account Not Exists !!";
			}

		} catch (Exception e) {
			e.printStackTrace();
			return "Something went wrong";
		}
	}

	@Override
	public String updateAccount(BankAccount account) {
		try {

			Session session = sf.openSession();

			BankAccount bankAccount = getAccountById(account.getAccountId());
			if (bankAccount != null) {
				session.update(account);
				session.beginTransaction().commit();
				return "Updated";
			} else {
				return "Account Not Exists with id = " + account.getAccountId();
			}

		} catch (Exception e) {
			e.printStackTrace();
			return "Something went wrong";
		}
	}

	@Override
	public List<BankAccount> findAll() {
		return getSession().createQuery("from BankAccount", BankAccount.class).list();
	}

	@Override
	public List<BankAccount> findByType(String type) {
		return getSession().createQuery("from BankAccount where accountType = :type", BankAccount.class)
				.setParameter("type", type).list();
	}

	@Override
	public List<BankAccount> findByBalanceRange(Double min, Double max) {
		return getSession().createQuery("from BankAccount where balance between :min and :max", BankAccount.class)
				.setParameter("min", min).setParameter("max", max).list();
	}

}
