package com.qa.persistence.repository;

import java.util.List;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.qa.persistence.domain.Book;


public interface BookRepository extends ElasticsearchRepository<Book, Integer> {

}
