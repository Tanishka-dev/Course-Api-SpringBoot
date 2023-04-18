package com.course.api.topic;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
@Service
public class TopicService {
    private List<Topic> topics=new ArrayList<>(Arrays.asList(
                new Topic("spring","Spring Framework","Spring Framework Learning"),
                new Topic("javascript","Javascript Framework","Javascript Framework Learning"),
                new Topic("java","Java J2SE","Java J2SE Learning")
        ));


    public List<Topic> getAllTopics() {
        return topics;
    }

    public Topic getTopic(String id) {
        return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
    }

    public void addTopic(Topic topic) {
        topics.add(topic);
    }

    public void updateTopic(Topic topic, String id){
        for(int i = 0; i < topics.size(); i++){
            Topic t= topics.get(i);
            if(t.getId().equals(id)){
                topics.set(i,topic);
                return;
            }
        }
    }
    public void removeTopic(String id){
        topics.removeIf(t-> t.getId().equals(id));
    }
}
