/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.test.repositories;

import com.example.test.entities.Trainers;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Los_e
 */
@Repository
public interface TrainersRepo extends JpaRepository<Trainers, String> {

    @Transactional
    @Modifying
    @Query("DELETE  FROM Trainers t WHERE t.trainerid = ?1")
    void deleteTrainerById(int trainerid);

    @Query("SELECT t FROM Trainers t WHERE t.trainerid = ?1")
    Trainers findTrainerById(int trainerid);
}
