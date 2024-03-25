package com.lab.DiaryAppBE.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lab.DiaryAppBE.entity.Diary;

@Repository
public interface DiaryRepository extends JpaRepository<Diary, Integer> {

}
