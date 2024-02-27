# '단어 블록 깨기 게임' 프로젝트

### <프로젝트 목적>
**객체지향언어를 활용한 개발 경험**

- 객체지향언어 Java의 메서드 활용 능력 향상
- 반복문과 조건문 활용 능력 향상
- 전역변수와 매개변수 이해도 증진
 
### <개발 일정>
**2023.10.18 ~ 2023.10.20 (03일)**
### <개발 인원>
**1인**

- ### __*소개*__
  
CLI기반 게임을 통한 영어단어 암기 및 영타 실력 증진

- ### __*사용 방법 및 기능*__
  - 3*4 게임판에 랜덤으로 단어 출력
  - 입력된 단어와 게임판 일치 시 점수 부여<br>
ver1. 가로줄 기준 빙고 달성<br>
ver2. 새로운 랜덤 단어 출력<br>
ver3. 설정된 타이머 이내 게임 진행

- ### __*개발 환경*__
    - ##### IDE
      Eclipse
    - ##### 언어
      Java 8 version

- ### __*활용 기술*__
  **1. 단어 출력**<br>
  3*4 게임판에 단어를 출력하기 위해 이차배열로 게임판 생성<br>
  랜덤으로 단어가 출력되어야 하기 때문에 Random 객체 활용<br>
  출력될 단어들이 있는 배열에서 랜덤으로 인덱스 지정하여 게임판 형성
  
  **2. 점수 부여**<br>
  이중 for문을 활용하여 입력받은 단어와 일치 여부를 확인하여 점수 부여<br>
  누적 점수를 저장할 전역 변수와 실시간 획득 점수를 저장할 지역 변수 선언하여 점수 관리<br>

  **3. 단어 누적 출력**<br>
  입력한 단어가 일치시 상단에 단어가 한칸씩 내려오게 하기 위해 이중 for문의 인덱스 비교
  ```Java
  //게임하기 메서드
	public void user_word(String a) {//사용자가 입력하는 것을 받는 기능을 하는 메서드
		System.out.println("입력한 단어 : "+a);
		int score=0;//실시간 획득 점수 저장 변수
		boolean b=true;
		for(int i=0; i<game_w.length; i++) {
			for(int j=0; j<game_w[i].length; j++) {				
				if(a.equals(game_w[i][j])) {//같을 경우 새로운 문자가 자리를 채운다.
					cnt++;
					score+=10;
					total+=score;
					b=false;
					if(i-1<0) {//상단에 단어가 없을시 랜덤단어 생성
						game_w[i][j]=word[r.nextInt(word.length)];
					}else {//상단에 단어 존재시
						for(int k=0; i-k>=0; k++) {
							if(i-k==0) {
								game_w[i-k][j]=word[r.nextInt(word.length)];
							}else {//기존 상단 언어로 구성
								game_w[i-k][j]=game_w[i-k-1][j];
							}
						}
					}
				}
			}
		}

		if(b) {
			System.out.println("일치하는 단어가 없습니다.");
		}
		re_game_word();
		System.out.println(score+" 점수를 획득했습니다.");
	}
  ```
  
  
