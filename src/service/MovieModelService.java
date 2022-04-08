package service;

import java.util.ArrayList;

import exception.ProjectNameDuplicationException;
import exception.ProjectNotFoundException;
import moviedto.ActorDTO;
import moviedto.MovieCategori;

public class MovieModelService {

	private ArrayList<MovieCategori> myMovie = new ArrayList<MovieCategori>(); // 전역변수 모든 곳에서 사용 가능.
//	ArrayList<String> actorMovieList = new ArrayList<String>();

	private static MovieModelService instance = new MovieModelService();

	public static MovieModelService getInstance() {
		return instance;
	}

	public ArrayList<MovieCategori> getMovieProjectsList() {
		return myMovie;
	}

	public MovieCategori getMovieProject(String movieName) throws ProjectNotFoundException {
		for (int i = 0; i < myMovie.size(); i++) {
			if (myMovie.get(i).getMovieInfo().getMovieName().equals(movieName)) {
				return myMovie.get(i);
			}

		}
		throw new ProjectNotFoundException("요청하신 프로젝트는 존재하지 않습니다.");
	}

	public void MovieListCreate(MovieCategori m) throws ProjectNameDuplicationException {

		for (MovieCategori e : myMovie) {
			if (e.getMovieInfo().getMovieName().equals(m.getMovieInfo().getMovieName())) { // 비교
				throw new ProjectNameDuplicationException("이미 존재하는 영화입니다.");
			}
		}
		myMovie.add(m);
	}

	public ArrayList<String> ActorMovieListAdd(String aName) throws ProjectNotFoundException { // hashMap 중복되면 하나 없어짐.
		// 최우식

		ArrayList<String> actorMovieList = new ArrayList<String>(); // 지역변수: 생성 시 초기화 [기생충, 마녀]

		for (MovieCategori e : myMovie) {
			if (e.getMovieInfo().getMainActorName().equals(aName)) {
				actorMovieList.add(e.getMovieInfo().getMovieName());
			}
		}
		if (actorMovieList.isEmpty()) {
			throw new ProjectNotFoundException("해당 영화 미 존재");
		}

		return actorMovieList; // ArrayList<String> 기생충, 마녀
	}

	public ArrayList<String> MovieGenreListAdd(String aGenre) throws ProjectNotFoundException {

		ArrayList<String> genreMovieList = new ArrayList<String>();
		for (MovieCategori e : myMovie) {
			if (e.getMovieInfo().getMovieGenre().equals(aGenre)) {
				genreMovieList.add(e.getMovieInfo().getMovieName());
			}
		}
		if (genreMovieList.isEmpty()) {
			throw new ProjectNotFoundException("해당 영화 미 존재");
		}
		return genreMovieList;

	}

	// ArrayList<>
	// []
	// ActorDTO
	// public 반환하려는 변수형태 함수의 이름(매개변수){
	// }

	public ActorDTO ActorInfoRead(String s) throws ProjectNotFoundException {
		int count = myMovie.size();
		for (int i = 0; i < count; i++) {
			if (myMovie.get(i).getActorInfo().getActorName().equals(s)) {
				return myMovie.get(i).getActorInfo();
			}
		}
		throw new ProjectNotFoundException("이미 존재하는 영화입니다.");

	}

	public void MovieListUpdata(String s, String s1) throws ProjectNotFoundException {

		for (MovieCategori e : myMovie) {
			if (e.getMovieInfo().getMovieName().equals(s)) {
				e.setMovieTime(s1);
				return;
			}
		}
		throw new ProjectNotFoundException("해당 영화 미 존재");
	}

	public void MovieListDelete(String s) throws ProjectNotFoundException {

		for (int i = 0; i < myMovie.size(); i++) {
			if (myMovie.get(i).getMovieInfo().getMovieName().equals(s)) {
				myMovie.remove(i);
				return;
			}
		}
		throw new ProjectNotFoundException("해당 영화 미 존재");
	}

} // Class End Point
