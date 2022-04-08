package view;

import moviedto.ActorDTO;
import moviedto.MovieCategori;
import moviedto.MovieDTO;

import java.util.Scanner;

import controller.MovieSystemController;

public class StartView {
	
	public static void main(String args[]) {

		Scanner sc = new Scanner(System.in);
		Scanner sc1 = new Scanner(System.in);

		MovieDTO md1 = new MovieDTO("기생충", "최우식", 131, "드라마");
		MovieDTO md2 = new MovieDTO("마녀", "최우식", 125, "스릴러");
		MovieDTO md3 = new MovieDTO("사냥의시간", "이재훈", 134, "스릴러");
		MovieDTO md4 = new MovieDTO("괴물", "송강호", 119, "모험");
		MovieDTO md5 = new MovieDTO("택시운전사", "송강호", 137, "드라마");
		MovieDTO md6 = new MovieDTO("코리아", "배두나", 127, "드라마");

		ActorDTO ac1 = new ActorDTO("최우식", 30, 181);
		ActorDTO ac2 = new ActorDTO("송강호", 56, 180);
		ActorDTO ac3 = new ActorDTO("이재훈", 38, 176);
		ActorDTO ac4 = new ActorDTO("배두나", 43, 170);

		MovieCategori mc1 = new MovieCategori(md1, ac1, "일요일 14시", 10000);
		MovieCategori mc2 = new MovieCategori(md2, ac1, "토요일 14시", 12000);
		MovieCategori mc3 = new MovieCategori(md3, ac3, "일요일 17시", 14000);
		MovieCategori mc4 = new MovieCategori(md4, ac2, "일요일 12시", 10000);
		MovieCategori mc5 = new MovieCategori(md5, ac2, "토요일 10시", 9000);
		MovieCategori mc6 = new MovieCategori(md6, ac4, "토요일 18시", 12000);
		
//==========================================================================================================================

		MovieSystemController movieModelService = MovieSystemController.getInstance();
		
		movieModelService.MovieListCreate(mc1);
		movieModelService.MovieListCreate(mc2);
		movieModelService.MovieListCreate(mc3);
		movieModelService.MovieListCreate(mc4);
		movieModelService.MovieListCreate(mc5);
		movieModelService.MovieListCreate(mc6);
		System.out.println(
				" ***영화 정보 검색도우미입니다.*** \n 1. 모든 영화 검색 \n 2. 영화 선택 검색 \n 3. 선택 영화 상영시간 변경 "
				+ "\n 4. 배우 정보 검색 \n 5. 배우 출연작 검색 \n 6. 영화 장르 검색 \n 7. 영화 상영 삭제\n 0번은 나가기");
		
		int i = sc.nextInt();
		
		while (i != 0) {
			
			if (i == 1) {
				
				System.out.println("\n*** 01. 모든 영화 검색 ***");
				movieModelService.getMovieProjectsList();
			} else if (i == 2) {
				
				System.out.println(" *** 영화이름을 입력해주세요. ***");
				String mName = sc1.nextLine();
				System.out.println("\n*** 02. " + mName + " 영화 검색 ***");
				movieModelService.getMovieProject(mName);
			} else if (i == 3) {
				
				System.out.println(" *** 영화이름을 입력해주세요. ***");
				String mName = sc1.nextLine();
				System.out.println("\n*** 03. " + mName + "영화 상영시간 변경 ***\n 변경하고자 하는 시간을 'x요일 xx시' 로 표현해주세요.");
				String mTime = sc1.nextLine();
				movieModelService.MovieListUpdata(mName, mTime);
			} else if (i == 4) {
				
				System.out.println(" *** 배우이름을 입력해주세요. ***");
				String mName = sc1.nextLine();
				System.out.println("\n*** 04. " + mName + " Actor 검색 ***");
				movieModelService.ActorInfoRead(mName);
			} else if (i == 5) {
				
				System.out.println(" *** 배우 이름을 입력해주세요 ***");
				String mName = sc1.nextLine();
				System.out.println("\n*** 05. " + mName + " 출연 영화 검색 ***");
				movieModelService.ActorMovieListAdd(mName);
			} else if (i == 6) {
				
				System.out.println(" *** 원하는 장르를 입력해주세요 ***");
				String mName = sc1.nextLine();
				
				System.out.println("\n*** 06. " + mName + " 장르 영화 검색 ***");
				movieModelService.MovieGenreListAdd(mName);
			} else if (i == 7) {
				
				System.out.println(" ***삭제하고자 하는 영화이름을 입력해주세요. ***");
				
				String mName = sc1.nextLine();
				System.out.println("\n*** 07. " + mName + " 영화 삭제 후 삭제한 영화 검색 ***");
				
				movieModelService.MovieListDelete(mName);
				movieModelService.getMovieProjectsList();
			}
			System.out.println(
					"\n ***영화 정보 검색도우미입니다.*** \n 1. 모든 영화 검색 \n 2. 영화 선택 검색 \n 3. 선택 영화 상영시간 변경 "
					+ "\n 4. 배우 정보 검색 \n 5. 배우 출연작 검색 \n 6. 영화 장르 검색 \n 7. 영화 상영 삭제\n 0번은 나가기");
			i = sc.nextInt();

		}	// While End Point
		
		System.out.println(" ***도우미가 종료되었습니다.***");
	}	// Main End Point
	
}	// Class End Point
