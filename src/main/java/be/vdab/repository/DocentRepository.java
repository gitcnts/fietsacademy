package be.vdab.repository;

import java.util.Optional;

import be.vdab.entities.Docent;

public class DocentRepository extends AbstractRepository {

//	public Optional<Docent> read(long id) {
	public Optional<Docent> read(long id) {
//		EntityManager entityManager = JPAFilter.getEntityManager();
//		try {
			return Optional.ofNullable(getEntityManager().find(Docent.class, id));
//		} finally {
//			entityManager.close();
//		}
	}
	
	public void create(Docent docent) {
		getEntityManager().persist(docent);
	}
	
	public void delete(long id) {
		read(id).ifPresent(docent -> getEntityManager().remove(docent));
	}


}
