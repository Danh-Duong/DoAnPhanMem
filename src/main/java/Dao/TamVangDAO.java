package Dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import Utils.HibernateUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import model.TamVang;

public class TamVangDAO implements DaoInterface<TamVang>{

	public List<TamVang> selectAll() {
		List<TamVang> list = new ArrayList<>();
		SessionFactory factory = null;
		EntityManager manager = null;
		try {
			factory = HibernateUtil.getSessionFactory();
			if (factory != null) {
				manager = factory.createEntityManager();
				manager.getTransaction().begin();
				Query query = manager.createQuery("from TamVang");
				list = query.getResultList();
				manager.getTransaction().commit();
				manager.close();
			}
		} catch (Exception e) {
			manager.getTransaction().rollback();
			e.printStackTrace();
		}
		return list;
	}

	public TamVang selectById(TamVang t) {
		TamVang TamVang = null;
		SessionFactory factory = null;
		EntityManager manager = null;
		try {
			factory = HibernateUtil.getSessionFactory();
			if (factory != null) {
				manager = factory.createEntityManager();
				manager.getTransaction().begin();
				Query query = manager.createQuery("from TamVang u where u.idTamVang = :id");
				query.setParameter("id", t.getMaTamVang());
				TamVang = (TamVang) query.getSingleResult();
				manager.getTransaction().commit();
				manager.close();
			}
		} catch (Exception e) {
			manager.getTransaction().rollback();
		}
		return TamVang;
	}

	public boolean insert(TamVang t) {
		SessionFactory factory = null;
		Session manager = null;
		try {
			factory = HibernateUtil.getSessionFactory();
			if (factory != null) {
				manager = factory.openSession();
				manager.getTransaction().begin();
				manager.persist(t);
				manager.getTransaction().commit();
				manager.close();
				return true;
			}
		} catch (Exception e) {
			manager.getTransaction().rollback();
			e.printStackTrace();
		}
		return false;
	}

	public boolean delete(TamVang t) {
		SessionFactory factory = null;
		EntityManager manager = null;
		try {
			factory = HibernateUtil.getSessionFactory();
			if (factory != null) {
				manager = factory.createEntityManager();
				manager.getTransaction().begin();
				manager.remove(t);
				manager.getTransaction().commit();
				manager.close();
				return true;
			}
		} catch (Exception e) {
			manager.getTransaction().rollback();
		}
		return false;
	}

	public boolean update(TamVang t) {
		SessionFactory factory = null;
		EntityManager manager = null;
		try {
			factory = HibernateUtil.getSessionFactory();
			if (factory != null) {
				manager = factory.createEntityManager();
				manager.getTransaction().begin();
				manager.merge(t);
				manager.getTransaction().commit();
				manager.close();
				return true;
			}
		} catch (Exception e) {
			manager.getTransaction().rollback();
		}
		return false;
	}
}
