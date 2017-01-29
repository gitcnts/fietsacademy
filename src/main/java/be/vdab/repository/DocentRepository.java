package be.vdab.repository;

import java.util.Optional;

import javax.persistence.EntityManager;

import be.vdab.entities.Docent;

public class DocentRepository {

//	public Optional<Docent> read(long id) {
	public Optional<Docent> read(long id, EntityManager entityManager) {
//		EntityManager entityManager = JPAFilter.getEntityManager();
//		try {
			return Optional.ofNullable(entityManager.find(Docent.class, id));
//		} finally {
//			entityManager.close();
//		}
	}
	
	public void create(Docent docent, EntityManager entityManager) {
		entityManager.persist(docent);
	}

}
