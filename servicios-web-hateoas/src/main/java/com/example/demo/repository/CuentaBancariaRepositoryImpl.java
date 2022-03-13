package com.example.demo.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.example.demo.repository.modelo.CuentaBancaria;

@Repository
@Transactional
public class CuentaBancariaRepositoryImpl implements ICuentaBancariaRepository {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public void insertar(CuentaBancaria cuenta) {
		em.persist(cuenta);
	}

	@Override
	public void actualizar(CuentaBancaria cuenta) {
		em.merge(cuenta);
	}

	@Override
	public CuentaBancaria buscar(Integer id) {
		return em.find(CuentaBancaria.class, id);
	}

	@Override
	public void borrar(Integer id) {
		CuentaBancaria cuenta = buscar(id);
		em.remove(cuenta);
	}

	@Override
	public List<CuentaBancaria> buscarCuentas(Integer userid) {
		// SELECT d FROM CuentaBancaria d WHERE owner.id = :userid
		TypedQuery<CuentaBancaria> mq = em.createQuery("SELECT d FROM CuentaBancaria d WHERE owner.id = :userid", CuentaBancaria.class);
		mq.setParameter("userid", userid);
		return mq.getResultList();
	}
	

}
