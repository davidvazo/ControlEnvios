package mx.trillas.ControlEnvio.persistence.impl;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import mx.trillas.ControlEnvio.persistence.HibernateUtil;
import mx.trillas.ControlEnvio.persistence.dao.OrigenesDAO;
import mx.trillas.ControlEnvio.persistence.pojos.Mensajeria;
import mx.trillas.ControlEnvio.persistence.pojos.Origen;

public class OrigenesDAODBImpl implements OrigenesDAO {

	@Override
	public void altaOrigen(Origen origen) throws Exception {
		// TODO Auto-generated method stub
		Session session = null;
		Transaction transaction = null;
		
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			session.save(origen);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null)
				transaction.rollback();
			throw e;
		} finally {
			if (session != null)
				session.close();
		}
	}

	@Override
	public Origen getOrigen(String nombre) throws Exception {
		// TODO Auto-generated method stub
		Session session = null;
		Origen origen = null;

		try {
			session = HibernateUtil.getSessionFactory().openSession();
			Criteria criteria = session.createCriteria(Origen.class);
			criteria.add(Restrictions.and(Restrictions.eq("nombre", nombre)));
			Object origenObj = criteria.uniqueResult();
			if (origenObj != null && origenObj instanceof Origen) {
				origen = (Origen) origenObj;
			}
		} catch (Exception e) {
			throw e;
		} finally {
			if (session != null)
				session.close();
		}
		return origen;
	}
}