package com.mrcool.data.dao;

import com.mrcool.data.entities.Officer;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

@Repository
public class JpaOfficerDAOImpl implements OfficerDAO {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Officer save(Officer officer) {
		this.entityManager.persist(officer);
		return officer;
	}

	@Override
	public Optional<Officer> findById(Integer id) {
		return Optional.ofNullable(this.entityManager.find(Officer.class, id));
	}

	@Override
	public List<Officer> findAll() {
		return this.entityManager.createQuery("select o from Officer o", Officer.class).getResultList();
	}

	@Override
	public long count() {
		return this.entityManager.createQuery("select count(o.id) from Officer o", Long.class).getSingleResult();
	}

	@Override
	public void delete(Officer officer) {
		this.entityManager.remove(officer);
	}

	@Override
	public boolean existsById(Integer id) {
		return this.entityManager.createQuery("select 1 from Officer o where o.id=:id").setParameter("id", id)
				.getSingleResult() != null;
	}

}
