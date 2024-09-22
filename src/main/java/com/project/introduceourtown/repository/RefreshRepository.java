package com.project.introduceourtown.repository;

import com.project.introduceourtown.domain.RefreshEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RefreshRepository extends JpaRepository<RefreshEntity, String> {

    Boolean existsByRefresh(String refresh);


    void deleteByRefresh(String refresh);
}
