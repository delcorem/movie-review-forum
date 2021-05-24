package ca.sheridancollege.delcorem.database;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import ca.sheridancollege.delcorem.beans.Review;

@Repository
public class DatabaseAccess {

	@Autowired
	protected NamedParameterJdbcTemplate jdbc;
	
//	public void insertStudent() {
//		MapSqlParameterSource namedParameters = new MapSqlParameterSource();
//		String query="INSERT INTO review(movieName) VALUES ('Ben10')";
//		int rowsAffected = jdbc.update(query, namedParameters);
//		if (rowsAffected > 0)
//			System.out.println("Inserted review into database.");
//	}
	
	public void insertReview(Review review) {
		MapSqlParameterSource namedParameters = new MapSqlParameterSource();
		String query="INSERT INTO review(moviename, moviereview, reviewdate, reviewtime) VALUES (:moviename, :moviereview, :reviewdate, :reviewtime)";
		namedParameters.addValue("moviename", review.getMovieName());
		namedParameters.addValue("moviereview", review.getMovieReview());
		namedParameters.addValue("reviewdate", review.getReviewDate());
		namedParameters.addValue("reviewtime", review.getReviewTime());
		int rowsAffected = jdbc.update(query, namedParameters);
		if (rowsAffected > 0)
			System.out.println("Inserted review into database.");
	}
	
	public List<Review> getReviewList() {
		MapSqlParameterSource namedParameters = new MapSqlParameterSource();
		
		String query = "SELECT * FROM review";
		return jdbc.query(query, namedParameters, new BeanPropertyRowMapper<Review>(Review.class));
	}
}
