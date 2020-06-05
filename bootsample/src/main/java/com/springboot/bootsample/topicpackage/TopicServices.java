package com.springboot.bootsample.topicpackage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TopicServices {
    
    private List<Topic> topic = new ArrayList<>(Arrays.asList(
        new Topic(1,"SpringMVC","Spring MVC Tutorial"),
        new Topic(2,"Spring Core","Spring Core Tutorial"),
        new Topic(3,"Spring Boot","Spring Boot Tutorial" )
    ));

    public List<Topic> getAllTopic(){
        return topic;
    }

    public Topic getTopic(int id){
        return topic.stream().filter(t -> t.getId() == (id)).findFirst().get();
    }

	public void addTopic(Topic topic2) {
        topic.add(topic2);
	}

	public void updateTopic(Topic topic2, int id) {
        for (int i=0; i<=topic.size(); i++){
            Topic t = topic.get(i);
            if(t.getId() == id ){
                topic.set(i, topic2);
                return;
            }
        }
	}

	public void deleteTopic(int id) {
        for (int i=0; i<=topic.size(); i++){
            Topic t = topic.get(i);
            if(t.getId() == id ){
                topic.remove(i);
                return;
            }
        }
	}
}