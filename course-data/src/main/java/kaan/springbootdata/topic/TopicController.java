package kaan.springbootdata.topic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class TopicController {
	
	@Autowired
	private TopicService topicService;
	
	/*
	@RequestMapping("/topics")
	public List<Topic> getAllTopics() {
		return topicService.getAllTopics();
	} */
	
	@RequestMapping("/topics")
	public String getAllTopics(Model model) {
		List<Topic> topics = topicService.getAllTopics();
		model.addAttribute("list", topics);
		model.addAttribute("topic", new Topic());
		return "topics";
	}
	
	@RequestMapping("/topics/{id}")
	public Topic getTopic(@PathVariable String id) {
		return topicService.getTopic(id);
	}
	
	/*
	@RequestMapping(method=RequestMethod.POST, value="/topics")
	public void addTopic(@RequestBody Topic topic) {
		topicService.addTopic(topic);
	} */
	
	@RequestMapping(method=RequestMethod.POST, value="/topics")
	public String addTopic(@ModelAttribute(value="topic") Topic topic, Model model) {
		topicService.addTopic(topic);
		List<Topic> topics = topicService.getAllTopics();
		model.addAttribute("list", topics);
		model.addAttribute("topic", new Topic()); //For post method.
		return "topics";
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/topics/{id}")
	public void updateTopic(@RequestBody Topic topic, @PathVariable String id) {
		topicService.updateTopic(id, topic);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/topics/{id}")
	public void deleteTopic(@PathVariable String id) {
		topicService.deleteTopic(id);
	}
}
