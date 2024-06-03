package Dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.MutationQuery;

import Utils.HibernateUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import model.HoKhau;

public class HoKhauDAO implements DaoInterface<HoKhau> {

	public List<HoKhau> selectAll() {
		List<HoKhau> list = new ArrayList();
		SessionFactory factory = null;
		EntityManager manager = null;
		try {
			factory = HibernateUtil.getSessionFactory();
			if (factory != null) {
				manager = factory.createEntityManager();
				manager.getTransaction().begin();
				Query query = manager.createQuery("from HoKhau");
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

	public HoKhau selectById(HoKhau t) {
		HoKhau HoKhau = null;
		SessionFactory factory = null;
		EntityManager manager = null;
		try {
			factory = HibernateUtil.getSessionFactory();
			if (factory != null) {
				manager = factory.createEntityManager();
				manager.getTransaction().begin();
				Query query = manager.createQuery("from HoKhau u where u.idHoKhau = :id");
				query.setParameter("id", t.getIdHoKhau());
				HoKhau = (HoKhau) query.getSingleResult();
				manager.getTransaction().commit();
				manager.close();
			}
		} catch (Exception e) {
			manager.getTransaction().rollback();
		}
		return HoKhau;
	}

	public boolean insert(HoKhau t) {
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

	public boolean delete(HoKhau t) {
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

	public boolean update(HoKhau t) {
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
