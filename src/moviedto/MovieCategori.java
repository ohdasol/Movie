package moviedto;

public class MovieCategori {
	
		private MovieDTO movieInfo = new MovieDTO();
		
		private ActorDTO actorInfo = new ActorDTO();
	
		private String movieTime;

		private int movieCost;

		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append("영화 정보 [ ");
			builder.append(movieInfo);
			builder.append(", 배우의 정보 : ");
			builder.append(actorInfo);
			builder.append(", 상영 시간 : ");
			builder.append(movieTime);
			builder.append(", 비용 : ");
			builder.append(movieCost);
			builder.append(" ] ");
			return builder.toString();
		}

		public MovieDTO getMovieInfo() {
			return movieInfo;
		}

		public void setMovieInfo(MovieDTO movieInfo) {
			this.movieInfo = movieInfo;
		}

		public ActorDTO getActorInfo() {
			return actorInfo;
		}

		public void setActorInfo(ActorDTO actorInfo) {
			this.actorInfo = actorInfo;
		}

		public String getMovieTime() {
			return movieTime;
		}

		public void setMovieTime(String movieTime) {
			this.movieTime = movieTime;
		}

		public int getMovieCost() {
			return movieCost;
		}

		public void setMovieCost(int movieCost) {
			this.movieCost = movieCost;
		}

		public MovieCategori() {
			super();
			// TODO Auto-generated constructor stub
		}

		public MovieCategori(MovieDTO movieInfo, ActorDTO actorInfo, String movieTime, int movieCost) {
			super();
			this.movieInfo = movieInfo;
			this.actorInfo = actorInfo;
			this.movieTime = movieTime;
			this.movieCost = movieCost;
		}
		
}
