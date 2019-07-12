/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.test.dao;

import com.example.test.entities.Trainers;
import com.example.test.repositories.TrainersRepo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Los_e
 */
@Service
public class TrainersDAO {

    @Autowired
    private TrainersRepo trainersRepo;

    public List<Trainers> getAll() {
        return trainersRepo.findAll();
    }

    public void addTrainer(Trainers trainer) {
        trainersRepo.save(trainer);
    }

    public void deleteTrainer(int trainerid) {
        trainersRepo.deleteTrainerById(trainerid);
    }

    public Trainers getTrainerById(int trainerid) {
        return trainersRepo.findTrainerById(trainerid);
    }

}
