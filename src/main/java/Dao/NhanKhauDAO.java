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
import model.NhanKhau;

public class NhanKhauDAO implements DaoInterface<NhanKhau> {

	public List<NhanKhau> selectAll() {
		List<NhanKhau> list = new ArrayList();
		SessionFactory factory = null;
		EntityManager manager = null;
		try {
			factory = HibernateUtil.getSessionFactory();
			if (factory != null) {
				manager = factory.createEntityManager();
				manager.getTransaction().begin();
				Query query = manager.createQuery("from NhanKhau");
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

	public NhanKhau selectById(NhanKhau t) {
		NhanKhau nhanKhau = null;
		SessionFactory factory = null;
		EntityManager manager = null;
		try {
			factory = HibernateUtil.getSessionFactory();
			if (factory != null) {
				manager = factory.createEntityManager();
				manager.getTransaction().begin();
				Query query = manager.createQuery("from NhanKhau u where u.idNhanKhau = :id");
				query.setParameter("id", t.getIdNhanKhau());
				nhanKhau = (NhanKhau) query.getSingleResult();
				manager.getTransaction().commit();
				manager.close();
			}
		} catch (Exception e) {
			manager.getTransaction().rollback();
		}
		return nhanKhau;
	}

	public boolean insert(NhanKhau t) {
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

	public boolean delete(NhanKhau t) {
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

	public boolean update(NhanKhau t) {
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
