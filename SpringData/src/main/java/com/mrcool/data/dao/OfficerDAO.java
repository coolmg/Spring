package com.mrcool.data.dao;

import com.mrcool.data.entities.Officer;

import java.util.List;
import java.util.Optional;

public interface OfficerDAO {

	Officer save(Officer officer);

	Optional<Officer> findById(Integer id);

	List<Officer> findAll();

	long count();

	void delete(Officer officer);

	boolean existsById(Integer id);

}
