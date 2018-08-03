package com.qa.business.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.qa.constants.QuestionConstants;
import com.qa.persistence.domain.Question;
import com.qa.persistence.repository.QuestionRepository;
import com.qa.sender.Sender;

@Component
public class QuestionService {
	public QuestionRepository getQuestionRepository() {
		return questionRepository;
	}

	public void setQuestionRepository(QuestionRepository questionRepository) {
		this.questionRepository = questionRepository;
	}

	@Autowired
	private QuestionRepository questionRepository;

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private Sender sender;

	public List<Question> getAll() {
		Page<Question> questions = (Page<Question>) questionRepository.findAll();
		List<Question> questionList = questions.getContent();
		if (questionList.isEmpty()) {
			Question[] questionArray = restTemplate.getForObject(QuestionConstants.API_GET_ALL_ADDRESS,
					Question[].class);

			questionList = Arrays.asList(questionArray);

			questionRepository.saveAll(questionList);
		}
		sender.send(QuestionConstants.REQUEST_MSG);

		return questionList;
	}

}
