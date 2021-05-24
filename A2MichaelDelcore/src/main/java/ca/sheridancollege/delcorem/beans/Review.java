package ca.sheridancollege.delcorem.beans;

import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Review {

	private Long movieId;
	private String movieName;
	private String movieReview;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate reviewDate = LocalDate.now();
	
	@DateTimeFormat(pattern = "HH:mm")
	private LocalTime reviewTime = LocalTime.now();
	
	
}
