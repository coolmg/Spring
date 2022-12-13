package com.mrcool.data.repository;

import com.mrcool.data.entities.Officer;
import com.mrcool.data.entities.Rank;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OfficerRepository extends JpaRepository<Officer, Integer> {
    List<Officer> findAllByRank(Rank rank);

    List<Officer> findAllByRankAndLastNameContaining(Rank rank, String string);
}
