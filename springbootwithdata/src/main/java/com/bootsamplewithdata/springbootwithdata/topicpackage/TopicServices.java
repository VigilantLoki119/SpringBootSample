package com.bootsamplewithdata.springbootwithdata.topicpackage;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicServices {

    @Autowired
    private TopicRepository topicRepository;

    public List<Topic> getAllTopic() {

        List<Topic> topics = new ArrayList<>();
        topicRepository.findAll().forEach(topics::add);
        return topics;
    }

    public Optional<Topic> getTopic(String id) {
       
        return topicRepository.findById(id);
    }

	public void addTopic(Topic topic2) {
        
        topicRepository.save(topic2);
	}

	public void updateTopic(Topic topic2, String id) {
        
        topicRepository.save(topic2);
	}

	public void deleteTopic(String id) {
       
        topicRepository.deleteById(id);
	}
}