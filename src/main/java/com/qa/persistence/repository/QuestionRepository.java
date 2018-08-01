package com.qa.persistence.repository;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.qa.persistence.domain.Question;

public interface QuestionRepository extends ElasticsearchRepository<Question,Long>{

}
