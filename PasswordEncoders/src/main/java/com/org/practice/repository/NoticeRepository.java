package com.org.practice.repository;

import java.util.List;

import com.org.practice.model.Notices;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface NoticeRepository extends CrudRepository<Notices, Long> {

    @Query(value = "from Notices n where CURDATE() BETWEEN noticBegDt AND noticEndDt")
    List<Notices> findAllActiveNotices();

}