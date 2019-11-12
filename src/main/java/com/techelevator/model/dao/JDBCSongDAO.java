package com.techelevator.model.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import com.techelevator.model.Song;
import com.techelevator.model.SongDAO;

@Component
public class JDBCSongDAO implements SongDAO {

	private JdbcTemplate dao;
	
	@Autowired
	public JDBCSongDAO(BasicDataSource dataSource) {
		dao = new JdbcTemplate(dataSource);
	}
	
	@Override
	public List<Song> getAllKnownSongs() {
		String sql = "SELECT artist, title, album FROM song WHERE known = true";
		SqlRowSet results = dao.queryForRowSet(sql);
		
		List<Song> output = new ArrayList<>();
		while(results.next()) {
			output.add(mapRowToSong(results));
		}
		
		return output;
	}

	@Override
	public List<Song> getAllRequestedSongs() {
		String sql = "SELECT artist, title, album FROM song WHERE known = false";
		SqlRowSet results = dao.queryForRowSet(sql);

		List<Song> output = new ArrayList<>();
		while(results.next()) {
			output.add(mapRowToSong(results));
		}
		
		return output;
	}

	@Override
	public boolean createRequest(Song newRequest) {
		try {
			String sql = "INSERT INTO song (id, artist, title, album, known) VALUES (DEFAULT, ?, ?, ?, false)";
			int rowsAffected = dao.update(sql, newRequest.getArtist(), newRequest.getTitle(), newRequest.getAlbum());
		} catch (Exception e) {
			return false;
		}

		return true;
	}

	@Override
	public boolean deleteRequest(Song goner) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean markRequestAsLearned(Song weNowKnowThisOne) {
		// TODO Auto-generated method stub
		return false;
	}
	
	private Song mapRowToSong(SqlRowSet result) {
		Song s = new Song();
		s.setArtist(result.getString("artist"));
		s.setTitle(result.getString("title"));
		s.setAlbum(result.getString("album"));
		
		return s;
	}

}
