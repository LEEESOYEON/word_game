package game_1;

import java.util.Scanner;

public class Main_1 {

	public static void main(String[] args) {
		
		Scanner s=new Scanner(System.in);
		System.out.println("단어블록 깨기 게임.");
		System.out.println("엔터를 입력히면 게임이 시작됩니다.");
		s.nextLine();
		new Game();

	}

}

