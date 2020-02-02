package com.bmdb.db;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bmdb.business.Summary;

public interface SummaryRepository extends JpaRepository<Summary, Integer> {

}
