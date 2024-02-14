package game_3;

import java.util.Random;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class Game_3 {

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
			"grape",
			"mango"
	};
	String[][] game_w=new String[4][3];//게임판
	int cnt=0;//블록 갯수
	Random r=new Random();
	Scanner s=new Scanner(System.in);
	long beforeTime;
	long afterTime;
	long diffTime;
	int total=0;
	Timer m=new Timer();
	TimerTask t=new TimerTask() {
		public void run() {
			System.out.println("강제종료");
		}
	};
	
	//메서드 호출
	public Game_3() {//생성자
		boolean flag=true;
		beforeTime=System.currentTimeMillis();
		System.out.println("게임시작");
		System.out.println("'q'를 입력하면 게임이 종료됩니다.");
		game_word();
		while(flag) {//flag가 false가 될때까지 입력을 받는 while문
			System.out.println("단어를 입력해주세요.");
			String user=s.next();
			if(user.equals("q")) {
				System.out.println("게임을 종료합니다.");
				re_game_word();
				flag=false;
			}else {
				//System.out.println("대기 5초 후 종료합니다.");
				user_word(user);
				//m.schedule(t, 5000);
			}
			if(cnt==game_w.length*game_w[0].length) {
				System.out.println("블록이 다 깨져 게임을 종료합니다.");
				System.out.println("획득점수 : "+total);
				break;
			}
			afterTime=System.currentTimeMillis();
			if((afterTime-beforeTime)/1000>5) {
				System.out.println("시간초과되어(30초 이상) 게임을 종료합니다.");
				System.out.println("현재 소요시간 : "+(afterTime-beforeTime)/1000);
				flag=false;
			}
		}
		afterTime=System.currentTimeMillis();
		diffTime=(afterTime-beforeTime)/1000;
		System.out.println("소요시간 : "+diffTime);
		//System.out.println("최종점수 : "+game_score(user_word(user)));
	}
	
	//정의
	//단어입력 메서드
	public void game_word() {//랜덤으로 입력받아 게임창을 만드는 기능의 메서드
		//String[][] game_w=new String[4][3];
		System.out.println("─────────────────────────");
		for(int i=0; i<game_w.length; i++) {
			System.out.print("|");
			for(int j=0; j<game_w[i].length; j++) {				
				game_w[i][j]=word[r.nextInt(word.length)];
				System.out.print(game_w[i][j]+"\t|");
			}
			System.out.println();
			System.out.println("─────────────────────────");
		}
	}
	//게임하기 메서드
	public void user_word(String a) {//사용자가 입력하는 것을 받는 기능을 하는 메서드
		System.out.println("입력한 단어 : "+a);
		int score=0;
		boolean b=true;
		for(int i=0; i<game_w.length; i++) {
			for(int j=0; j<game_w[i].length; j++) {				
				if(a.equals(game_w[i][j])) {
					game_w[i][j]="*";
					cnt++;
					score+=10;
					b=false;
				}
			}
		}
		System.out.println(score+" 점을 획득했습니다.");
		if(b) {
			System.out.println("일치하는 단어가 없습니다.");
		}
		re_game_word();
		System.out.println("현재점수 : "+game_score(score));
	}
	//단어출력 메서드
	public void re_game_word() {//게임이 진행되며 갱신되는 게임판
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
	public int game_score(int a) {//점수를 누적해서 저장하는 변수를 리턴하는 기능을 가진 메서드
		total+=a;
		return total;
	}
	
}
