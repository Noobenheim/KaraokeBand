package com.techelevator;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
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
	public String showSongRequestForm(ModelMap m) {
		if( !m.containsAttribute("song") ) {
			m.addAttribute("song", new Song());
		}
		return "songRequestForm";
	}
	
	
	@RequestMapping(path="/songRequest", method=RequestMethod.POST)
	public String submitSongRequest(@Valid @ModelAttribute("song") Song newRequest,
									BindingResult result,
									RedirectAttributes flashScope) {
		if( result.hasErrors() ) {
			flashScope.addFlashAttribute("song", newRequest);
			flashScope.addFlashAttribute(BindingResult.MODEL_KEY_PREFIX+"song", result);
			return "redirect:/song_request_form";
		}
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
