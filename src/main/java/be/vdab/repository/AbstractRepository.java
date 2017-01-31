package be.vdab.repository;

import javax.persistence.EntityManager;

import be.vdab.filters.JPAFilter;

public class AbstractRepository {

	EntityManager getEntityManager() {
		return JPAFilter.getEntityManager();
	}
	
}
