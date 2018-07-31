package com.qa.persistence.repository;

import java.util.Optional;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.qa.persistence.domain.GlossaryEntry;

public interface GlossaryRepository extends ElasticsearchRepository<GlossaryEntry, Integer>{
Optional<GlossaryEntry> findByKeyword(String keyword);
}
