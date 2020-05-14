package com.cts.service;

import java.util.List;
import com.cts.model.Story;

public interface IStoryService {
	
	public List<Story> getAllStory();
	//public void saveStory(Story story);
	public String updateStory(Long id,Story story,Long updateid);
	public String deleteStory(Long id,Long deleteid);
	public Story getStoryById(Long id);
	public String addStory(Long id, Story story);
	public List<Story> getStoryByUserId(Long userid);
	public static List<Story> listAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
