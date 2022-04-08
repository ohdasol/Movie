package controller;

import java.util.ArrayList;
import java.util.HashMap;

import exception.ProjectNameDuplicationException;
import exception.ProjectNotFoundException;
import moviedto.MovieCategori;
import service.MovieModelService;
import view.EndFailView;
import view.EndView;

public class MovieSystemController {
	//명령을 전달.

	private static MovieSystemController instance = new MovieSystemController();

	private MovieModelService service = MovieModelService.getInstance();	//서비스에 있는 getInstance를 이용하여 사용할 수 있음.

	private MovieSystemController() {}

	public static MovieSystemController getInstance() {
		return instance;
	}
	// hashMap
	// service.ActorMovieListAdd(aName) = ArrayList<String>

	public void ActorMovieListAdd(String aName) {	//최우식
		try {
			HashMap<String, ArrayList<String>> aNameMovie = new HashMap<String, ArrayList<String>>();
			aNameMovie.put(aName, service.ActorMovieListAdd(aName));		//기생충 마녀
			EndView.HashName(aNameMovie);
		} catch (ProjectNotFoundException e) {
			e.printStackTrace();
			EndFailView.failView("정보를 제대로 입력해주세요.");
		}
	}
	
	public void MovieGenreListAdd(String aName) {
		try {
			HashMap<String, ArrayList<String>> genreMovie = new HashMap<String, ArrayList<String>>();
			genreMovie.put(aName, service.MovieGenreListAdd(aName));
			EndView.HashName(genreMovie);
		} catch (ProjectNotFoundException e) {
			e.printStackTrace();
			EndFailView.failView("정보를 제대로 입력해주세요.");
		}
	}

	public void getMovieProject(String projectName) {
		try {
			EndView.projectView(service.getMovieProject(projectName));
		} catch (ProjectNotFoundException e) {
			e.printStackTrace();
			EndFailView.failView(e.getMessage());
		}
	}

	public void getMovieProjectsList() {
		EndView.projectListView(service.getMovieProjectsList());
	}

	public void MovieListCreate(MovieCategori project) {

		if (project != null) {
			try {
				
				service.MovieListCreate(project);
				
			} catch (ProjectNameDuplicationException e) {
				
				e.printStackTrace();
				EndFailView.failView(e.getMessage());
				
			}
		} else {
			EndFailView.failView("저장할 수 있는 데이터가 존재하지 않습니다.");
		}
	}

	public void MovieListUpdata(String string, String replaceTime) {

		if (string != null && replaceTime != null) {
			try {
				service.MovieListUpdata(string, replaceTime);
				EndView.projectView(service.getMovieProject(string));
			} catch (ProjectNotFoundException e) {
				e.printStackTrace();
				EndFailView.failView(e.getMessage());
			}
		} else {
			EndFailView.failView("정보를 제대로 입력해주세요.");
		}

	}

	public void ActorInfoRead(String name) {
		try {
			EndView.moiveActorView(service.ActorInfoRead(name));
		} catch (ProjectNotFoundException e) {
			e.printStackTrace();
			EndFailView.failView(e.getMessage());
		}
	}

	public void MovieListDelete(String movieName) {

		if (movieName != null) {
			try {
				service.MovieListDelete(movieName);
				EndView.successView("삭제되었습니다.");
			} catch (ProjectNotFoundException e) {
				e.printStackTrace();
				EndFailView.failView(e.getMessage());
			}
		} else {
			EndFailView.failView("삭제하기위한 영화가 없습니다.");
		}

	}

} // Class End Point
