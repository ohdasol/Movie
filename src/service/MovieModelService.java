package service;

import java.util.ArrayList;

import exception.ProjectNameDuplicationException;
import exception.ProjectNotFoundException;
import moviedto.ActorDTO;
import moviedto.MovieCategori;

public class MovieModelService {

	private ArrayList<MovieCategori> myMovie = new ArrayList<MovieCategori>(); // �������� ��� ������ ��� ����.
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
		throw new ProjectNotFoundException("��û�Ͻ� ������Ʈ�� �������� �ʽ��ϴ�.");
	}

	public void MovieListCreate(MovieCategori m) throws ProjectNameDuplicationException {

		for (MovieCategori e : myMovie) {
			if (e.getMovieInfo().getMovieName().equals(m.getMovieInfo().getMovieName())) { // ��
				throw new ProjectNameDuplicationException("�̹� �����ϴ� ��ȭ�Դϴ�.");
			}
		}
		myMovie.add(m);
	}

	public ArrayList<String> ActorMovieListAdd(String aName) throws ProjectNotFoundException { // hashMap �ߺ��Ǹ� �ϳ� ������.
		// �ֿ��

		ArrayList<String> actorMovieList = new ArrayList<String>(); // ��������: ���� �� �ʱ�ȭ [�����, ����]

		for (MovieCategori e : myMovie) {
			if (e.getMovieInfo().getMainActorName().equals(aName)) {
				actorMovieList.add(e.getMovieInfo().getMovieName());
			}
		}
		if (actorMovieList.isEmpty()) {
			throw new ProjectNotFoundException("�ش� ��ȭ �� ����");
		}

		return actorMovieList; // ArrayList<String> �����, ����
	}

	public ArrayList<String> MovieGenreListAdd(String aGenre) throws ProjectNotFoundException {

		ArrayList<String> genreMovieList = new ArrayList<String>();
		for (MovieCategori e : myMovie) {
			if (e.getMovieInfo().getMovieGenre().equals(aGenre)) {
				genreMovieList.add(e.getMovieInfo().getMovieName());
			}
		}
		if (genreMovieList.isEmpty()) {
			throw new ProjectNotFoundException("�ش� ��ȭ �� ����");
		}
		return genreMovieList;

	}

	// ArrayList<>
	// []
	// ActorDTO
	// public ��ȯ�Ϸ��� �������� �Լ��� �̸�(�Ű�����){
	// }

	public ActorDTO ActorInfoRead(String s) throws ProjectNotFoundException {
		int count = myMovie.size();
		for (int i = 0; i < count; i++) {
			if (myMovie.get(i).getActorInfo().getActorName().equals(s)) {
				return myMovie.get(i).getActorInfo();
			}
		}
		throw new ProjectNotFoundException("�̹� �����ϴ� ��ȭ�Դϴ�.");

	}

	public void MovieListUpdata(String s, String s1) throws ProjectNotFoundException {

		for (MovieCategori e : myMovie) {
			if (e.getMovieInfo().getMovieName().equals(s)) {
				e.setMovieTime(s1);
				return;
			}
		}
		throw new ProjectNotFoundException("�ش� ��ȭ �� ����");
	}

	public void MovieListDelete(String s) throws ProjectNotFoundException {

		for (int i = 0; i < myMovie.size(); i++) {
			if (myMovie.get(i).getMovieInfo().getMovieName().equals(s)) {
				myMovie.remove(i);
				return;
			}
		}
		throw new ProjectNotFoundException("�ش� ��ȭ �� ����");
	}

} // Class End Point
