package com.example.demo.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.example.demo.repository.modelo.CuentaHabiente;


@Repository
@Transactional
public class CuentaHabienteRepositoryImpl implements ICuentaHabienteRepository {

	@PersistenceContext
	private EntityManager em;
	
	
	@Override
	public void insertar(CuentaHabiente usuario) {
		em.persist(usuario);
	}

	@Override
	public void actualizar(CuentaHabiente usuario) {
		em.merge(usuario);
	}

	@Override
	public CuentaHabiente buscar(Integer id) {
		return em.find(CuentaHabiente.class, id);
	}

	@Override
	public void borrar(Integer id) {
		CuentaHabiente cb = buscar(id);
		em.remove(cb);
	}

	@Override
	public List<CuentaHabiente> buscarTodos() {
		// SELECT d FROM CuentaHabiente d
		TypedQuery<CuentaHabiente> mq = em.createQuery("SELECT d FROM CuentaHabiente d", CuentaHabiente.class);
		return mq.getResultList();
	}
	
	

}
