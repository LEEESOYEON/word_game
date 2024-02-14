package game_1;

import java.util.Random;
import java.util.Scanner;

public class Game {

	//멤버변수(전역변수) 선언
		String[] word= {//랜덤으로 출력될 단어들
				"apple",
				"banana",
				"orange",
				"kiwi",
				"melon",
				"lemon",
				"tomato",
				"plum",
				"peach",
				"grape"
		};
		String[][] game_w=new String[4][3];//게임판
		int cnt=0;//블록 갯수 카운팅 할 변수
		Random r=new Random();
		Scanner s=new Scanner(System.in);
		long beforeTime;//시작 시간 기록 변수
		long afterTime;//종료 시간 기록 변수
		long diffTime;//시작과 종료 시간 차이 기록 변수
		
		//생성자
		public Game() {
			boolean flag=true;//while문 종료 시킬 변수
			beforeTime=System.currentTimeMillis();//시작 시간 기록
			System.out.println("게임시작");
			System.out.println("'q'를 입력하면 게임이 종료됩니다.");
			game_word();//단어 입력 메서드 호출
			while(flag) {//flag가 false가 될때까지 입력을 받는 while문
				System.out.println("단어를 입력해주세요.");
				String user=s.next();//키보드로 입력받은 값 저장 변수 선언
				if(user.equals("q")) {
					System.out.println("게임을 종료합니다.");
					//re_game_word();
					flag=false;//반복문을 종료 시키기 위한 값 입력
				}else {
					user_word(user);//게임하기 메서드 호출
					pang_colum();
				}
				re_game_word();//단어출력 메서드 호출
				if(cnt_word(cnt)==1) {
					break;
				}
			}
			afterTime=System.currentTimeMillis();//종료 시간 기록
			System.out.println("소요시간 : "+time(afterTime,beforeTime));
		}
		
		//정의
		//단어입력 메서드
		public void game_word() {//랜덤으로 입력받아 게임창을 만드는 기능의 메서드
			System.out.println("─────────────────────────");
			for(int i=0; i<game_w.length; i++) {
				System.out.print("|");
				for(int j=0; j<game_w[i].length; j++) {				
					game_w[i][j]=word[r.nextInt(word.length)];//랜덤한 수를 인덱스로 받아 입력
					System.out.print(game_w[i][j]+"\t|");
				}
				System.out.println();
				System.out.println("─────────────────────────");
			}
		}
		//게임하기 메서드
		public int user_word(String a) {//사용자가 입력하는 것을 받는 기능을 하는 메서드
			System.out.println("입력한 단어 : "+a);
			boolean b=true;//일치하지 않는 경우를 확인하기 위한 변수
			for(int i=0; i<game_w.length; i++) {
				for(int j=0; j<game_w[i].length; j++) {				
					if(a.equals(game_w[i][j])) {//생성자 영역에서 받은 값을 매개변수에 입력하여 비교
						game_w[i][j]="*";
						cnt++;
						b=false;
					}
				}
			}
			if(b) {//false로 바뀌지 못한 경우 if문 동작
				System.out.println("일치하는 단어가 없습니다.");
			}
			return cnt;
			
		}
		//단어출력 메서드
		public void re_game_word() {//게임이 진행되며 갱신된(“*”) 내용을 보여주는 기능을 가진 메서드
			System.out.println("─────────────────────────");
			for(int i=0; i<game_w.length; i++) {
				System.out.print("|");
				for(int j=0; j<game_w[i].length; j++) {
					System.out.print(game_w[i][j]+"\t|");
				}
				System.out.println();
				System.out.println("─────────────────────────");
				
			}
			System.out.println("지금까지 깨진 블록 수 : "+cnt);
		}
		//가로가 전부 *이 되면 터지는 기능의 메서드
		public void pang_colum() {//행은 같고 열은 다르다.
			int num=0;
			for(int i=0; i<game_w.length; i++) {
				num=0;
				for(int j=0; j<game_w[i].length; j++) {
					if(game_w[i][j].equals("*")) {
						num++;
					}
					if(num==3) {
						for(int k=0; k<game_w[i].length; k++) {
							game_w[i][k]="#";
							System.out.println("!pang!");
						}
					}
				}
			}		
		}
		//소요시간을 구해주는 메서드
		public long time(long a,long b) {
			return (a-b)/1000;
		}
		//블록갯수를 기준으로 게임을 종료시키는 메서드
		public int cnt_word(int a) {
			if(a==game_w.length*game_w[0].length) {
				System.out.println("블록이 다 깨져 게임을 종료합니다.");
				return 1;
			}else {
				return -1;
			}
		}
	
}
