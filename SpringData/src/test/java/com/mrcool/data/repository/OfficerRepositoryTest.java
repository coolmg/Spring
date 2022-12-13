package com.mrcool.data.repository;

import com.mrcool.data.entities.Officer;
import com.mrcool.data.entities.Rank;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class OfficerRepositoryTest {

    @Autowired
    private OfficerRepository dao;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    List<Integer> getIds() {
        return this.jdbcTemplate.query("select id from officers", (rs, num) -> rs.getInt("id"));
    }

    @Test
    @Transactional(readOnly = false)
    void save() {
        Officer officer = new Officer(Rank.ADMIRAL, "Wesley", "Crushher");
        officer = this.dao.save(officer);
        assertNotNull(officer.getId());
    }

    @Test
    @Transactional(readOnly = true)
    void findById() {
        getIds().forEach(id -> {
            Optional<Officer> officer = dao.findById(id);
            assertTrue(officer.isPresent());
            assertEquals(id, officer.get().getId().intValue());
        });
    }

    @Test
    public void findByIdThatDoesNotExist() {
        Optional<Officer> officer = dao.findById(999);
        assertFalse(officer.isPresent());
    }

    @Test
    void existsById() {
        getIds().forEach(id -> assertTrue(dao.existsById(id)));
    }

    @Test
    void findAll() {
        List<String> dbNames = dao.findAll().stream().map(Officer::getLastName).collect(Collectors.toList());
        assertThat(dbNames).contains("Kirk", "Picard", "Sisko", "Janeway", "Archer");
    }

    @Test
    void count() {
        assertEquals(5, dao.count());
    }

    @Test
    void delete() {
        getIds().forEach(id -> {
            Optional<Officer> officer = dao.findById(id);
            assertTrue(officer.isPresent());
            dao.delete(officer.get());
        });
        assertEquals(0, dao.count());
    }

    @Test
    void findAllByRank(){
        List<Officer> officers = this.dao.findAllByRank( Rank.CAPTAIN);
        officers.forEach(System.out::println);
        assertEquals(5, dao.count());
    }
    @Test
    void findByLastNameLikeAndRank(){
        List<Officer> officers = this.dao.findAllByRankAndLastNameContaining( Rank.CAPTAIN,"i");
        officers.forEach(System.out::println);
    }

}