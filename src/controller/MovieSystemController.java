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
	//����� ����.

	private static MovieSystemController instance = new MovieSystemController();

	private MovieModelService service = MovieModelService.getInstance();	//���񽺿� �ִ� getInstance�� �̿��Ͽ� ����� �� ����.

	private MovieSystemController() {}

	public static MovieSystemController getInstance() {
		return instance;
	}
	// hashMap
	// service.ActorMovieListAdd(aName) = ArrayList<String>

	public void ActorMovieListAdd(String aName) {	//�ֿ��
		try {
			HashMap<String, ArrayList<String>> aNameMovie = new HashMap<String, ArrayList<String>>();
			aNameMovie.put(aName, service.ActorMovieListAdd(aName));		//����� ����
			EndView.HashName(aNameMovie);
		} catch (ProjectNotFoundException e) {
			e.printStackTrace();
			EndFailView.failView("������ ����� �Է����ּ���.");
		}
	}
	
	public void MovieGenreListAdd(String aName) {
		try {
			HashMap<String, ArrayList<String>> genreMovie = new HashMap<String, ArrayList<String>>();
			genreMovie.put(aName, service.MovieGenreListAdd(aName));
			EndView.HashName(genreMovie);
		} catch (ProjectNotFoundException e) {
			e.printStackTrace();
			EndFailView.failView("������ ����� �Է����ּ���.");
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
			EndFailView.failView("������ �� �ִ� �����Ͱ� �������� �ʽ��ϴ�.");
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
			EndFailView.failView("������ ����� �Է����ּ���.");
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
				EndView.successView("�����Ǿ����ϴ�.");
			} catch (ProjectNotFoundException e) {
				e.printStackTrace();
				EndFailView.failView(e.getMessage());
			}
		} else {
			EndFailView.failView("�����ϱ����� ��ȭ�� �����ϴ�.");
		}

	}

} // Class End Point
