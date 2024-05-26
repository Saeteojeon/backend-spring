package com.project.introduceourtown.repository;

import com.project.introduceourtown.domain.RefreshEntity;
import org.springframework.data.repository.CrudRepository;

public interface RefreshRepository extends CrudRepository<RefreshEntity, String> {

    Boolean existsByRefresh(String refresh);


    void deleteByRefresh(String refresh);
}
