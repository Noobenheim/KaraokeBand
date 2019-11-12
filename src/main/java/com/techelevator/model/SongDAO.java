package com.techelevator.model;

import java.util.List;

public interface SongDAO {

	List<Song> getAllKnownSongs();
	List<Song> getAllRequestedSongs();
	
	boolean createRequest(Song newRequest);
	boolean deleteRequest(Song goner);

	boolean markRequestAsLearned(Song weNowKnowThisOne);
	
}
