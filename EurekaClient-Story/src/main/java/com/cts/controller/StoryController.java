package com.cts.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cts.feign.StoryFeignClient;
import com.cts.model.Story;
import com.cts.model.User;
import com.cts.service.IStoryService;

@RestController
@RequestMapping("/access")
public class StoryController {
	

	Logger log = LoggerFactory.getLogger(StoryController.class);

	
	@Autowired
	IStoryService iStoryService;
	
//..........................Feign...................................
	
	@Autowired
	StoryFeignClient storyFeignClient;
	
	
	@RequestMapping("/users")
	 public List<User> getAllUser()
	{
		return storyFeignClient.getAllUser();
	}
	
	@GetMapping("/user/{id}")
	public User getUserById(@PathVariable Long id) {
		User user1 = storyFeignClient.getUserById(id) ;	
			return user1;
		
	}
	
//.......................................................................
	
	@PostMapping("/insertstory/{id}")
	public List<Story> addStory(@PathVariable Long id ,@RequestBody Story story) {
		log.info("story list is going to display");
		List<Story>listStories=IStoryService.listAll();
		log.info("story list displayed");
		log.debug("missing story");
		return listStories;

		
			
		
	}
	
	@GetMapping("/stories")
	public List<Story> getAllStory(){
		return iStoryService.getAllStory();
	}
	

	@PutMapping(value = "/story/{id}")
	public String updateStory(@PathVariable Long id,@RequestBody Story story,@RequestParam Long updateid) {
		return iStoryService.updateStory(id,story,updateid);
	}
	
	
	@RequestMapping(value = "/story/{id}", method = RequestMethod.DELETE)
	public String deleteStory(@PathVariable Long id,@RequestParam Long deleteid) {
		return iStoryService.deleteStory(id,deleteid);
		
	}

	@GetMapping("/assignedstory")
	public List<Story> getStoryByUserId(@RequestParam Long userid) {
	    return iStoryService.getStoryByUserId(userid) ;
	}
	
	@GetMapping("/story/{id}")
	public Story getStoryById(@PathVariable Long id) {
	    return iStoryService.getStoryById(id) ;
	}
	
	
	
//	@PostMapping("/story")
//	public void saveStory(@RequestBody Story story) {
//		iStoryService.saveStory(story);
//	}
	
	
}