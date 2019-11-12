package com.techelevator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.techelevator.model.Song;
import com.techelevator.model.SongDAO;

@Controller
public class SongController {

	@Autowired
	private SongDAO songDao;
	
	@RequestMapping("/songs_we_know")
	public String displayKnownSongs(ModelMap m) {
		m.put("songs", songDao.getAllKnownSongs());
		
		return "known_songs";
	}
	
	@RequestMapping("/song_request_form")
	public String showSongRequestForm() {
		return "songRequestForm";
	}
	
	
	@RequestMapping(path="/songRequest", method=RequestMethod.POST)
	public String submitSongRequest(Song newRequest, RedirectAttributes flashScope) {
		String message = "Thank you for your request! ";
		
		if(songDao.createRequest(newRequest)) {
			message += " We would love to play " + newRequest.getTitle() + " by " + newRequest.getArtist() + "!";
		} else {
			message += " That song has already been requested... We're working on it!";
		}
		
		flashScope.addFlashAttribute("thanks", message);
		
		return "redirect:/songs_we_know";
	}
	
	@RequestMapping("/song_requests")
	public String showSongRequests(ModelMap m) {
		m.put("songs", songDao.getAllRequestedSongs());
		
		return "songs_requested";
	}

}
