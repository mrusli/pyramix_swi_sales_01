package com.pyramix.persistence.common.dao.hibernate;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.pyramix.persistence.common.dao.Dao;

public class DaoHibernate implements Dao {
	private SessionFactory sessionFactory;

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public Object findById(Class target, Long id) throws Exception {
		Session session = getSessionFactory().openSession();
		
		CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
		CriteriaQuery<Class> criteriaQuery = criteriaBuilder.createQuery(target);
		Root<Class> root = criteriaQuery.from(target);
		criteriaQuery.select(root).where(criteriaBuilder.equal(root.get("id"), id));
		
		try {
			
			return session.createQuery(criteriaQuery).getSingleResult();
			
		} catch (Exception e) {
			throw e;
			
		} finally {
			session.close();
		}
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public List findAll(Class target) throws Exception {
		Session session = getSessionFactory().openSession();
		
		CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
		CriteriaQuery<Class> criteriaQuery = criteriaBuilder.createQuery(target);
		Root<Class> root = criteriaQuery.from(target);
		criteriaQuery.select(root);

		try {

			return session.createQuery(criteriaQuery).getResultList();
			
		} catch (Exception e) {
			throw e;
			
		} finally {
			session.close();

		}
	}

	@Override
	public Long save(Object object) throws Exception {
		Long id = -1L;
		
		Session session = getSessionFactory().openSession();
		
		Transaction transaction = session.beginTransaction();
		
		try {
			id = (Long) session.save(object);
			
			transaction.commit();
			
			return id;
		} catch (Exception e) {
			throw e;
			
		} finally {
			session.close();
			
		}
	}

	@Override
	public void update(Object object) throws Exception {
		Session session = getSessionFactory().openSession();
		
		Transaction transaction = session.beginTransaction();

		try {
			session.update(object);
			
			transaction.commit();
			
		} catch (Exception e) {
			throw e;
			
		} finally {
			session.close();
			
		}
	}

	@Override
	public void delete(Object object) throws Exception {
		Session session = getSessionFactory().openSession();
		
		Transaction transaction = session.beginTransaction();

		try {
			session.delete(object);
			
			transaction.commit();
			
		} catch (Exception e) {
			throw e;
			
		} finally {
			session.close();
			
		}
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}
