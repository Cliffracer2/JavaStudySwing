/**************************************************
 
포켓몬 클래스
포켓몬의 정보를 담고 있다.

**************************************************/

package pokemon;

import java.util.InputMismatchException;

public class Pokemon 
{
	PokemonSkill pokemonSkill = new PokemonSkill();
	
	// 포켓몬 공통 정보
	int currnetExp = 0;		// 현재 경험치
	int levelUpExp = 0;		// 레벨업을 하기위한 경험치
	int pokemonLevel = 1;	// 포켓몬 레벨
	int pokemonType = -1;	// 포켓몬 타입(속성) 값
	String pokemonCondition = new String(); // 포켓몬 상태
	
	// 포켓몬 정보를 담는 변수
	// 기본 능력치 관련 변수
	// 0. 체력  1. 공격력  2. 방어력  3. 스피드
	// 4. 포켓몬의 속성 정보  5. 남은 체력
	int[] pokemonStatus = new int[6];
	// 포켓몬 이름
	String pokemonName = new String();
	
	/**************************************************
	
	displayPokemonStatus
	입력: 내 포켓몬 정보
	출력: 콘솔메시지

	현재 포켓몬의 능력치를 콘솔에 출력해준다.

	**************************************************/
	public void displayPokemonStatus ()
	{
		System.out.printf("************************************************************\n");
		System.out.printf("포켓몬의 능력치\n\n");
		System.out.printf("레벨: %d\n", ShareData.myPokemon.pokemonLevel);
		System.out.printf("친밀도: %d\n", ShareData.myPokemon.familiarity);
		System.out.printf("HP: %d\n", ShareData.myPokemon.pokemonStatus[0]);
		System.out.printf("공격력: %d\n", ShareData.myPokemon.pokemonStatus[1]);
		System.out.printf("방어력: %d\n", ShareData.myPokemon.pokemonStatus[2]);
		System.out.printf("스피드: %d\n\n", ShareData.myPokemon.pokemonStatus[3]);
		System.out.printf("포켓몬의 스킬\n\n");
		System.out.printf("1. %s\n위력: %d, 횟수: %d, 명중률: %d\n", 
				ShareData.myPokemon.pokemonSkill.skillName[0], 
				ShareData.myPokemon.pokemonSkill.skillDamage[0], 
				ShareData.myPokemon.pokemonSkill.skillCount[0], 
				ShareData.myPokemon.pokemonSkill.skillAccuracy[0]);
		System.out.printf("2. %s\n위력: %d, 횟수: %d, 명중률: %d\n", 
				ShareData.myPokemon.pokemonSkill.skillName[1], 
				ShareData.myPokemon.pokemonSkill.skillDamage[1], 
				ShareData.myPokemon.pokemonSkill.skillCount[1], 
				ShareData.myPokemon.pokemonSkill.skillAccuracy[1]);
		System.out.printf("3. %s\n위력: %d, 횟수: %d, 명중률: %d\n", 
				ShareData.myPokemon.pokemonSkill.skillName[2], 
				ShareData.myPokemon.pokemonSkill.skillDamage[2], 
				ShareData.myPokemon.pokemonSkill.skillCount[2], 
				ShareData.myPokemon.pokemonSkill.skillAccuracy[2]);
		System.out.printf("4. %s\n위력: %d, 횟수: %d, 명중률: %d\n", 
				ShareData.myPokemon.pokemonSkill.skillName[3], 
				ShareData.myPokemon.pokemonSkill.skillDamage[3], 
				ShareData.myPokemon.pokemonSkill.skillCount[3], 
				ShareData.myPokemon.pokemonSkill.skillAccuracy[3]);
		System.out.printf("************************************************************\n");
	}
	
	/**************************************************
	
	selectPokemon
	입력: 사용자로부터 입력받을 정보
	출력: 선택한 포켓몬의 이름
	
	포켓몬을 선택한다.
	1. 파이리.   2. 이상해씨.   3. 꼬부기.

	**************************************************/
	public String selectPokemon ()
	{
		String selectPokemonName = new String();
		// 포켓몬을 선택한다.
		int receiveNumber = -1;					// 사용자가 입력하는 수치
		boolean correctNumber = false;			// 올바른 숫자 입력을 판단하는 변수
		
		while (correctNumber == false)
		{
			// TODO: 실제로 입력을 확인 받고 승인을 받으면 루프를 종료한다.
			System.out.printf("************************************************************\n");
			System.out.printf("포켓몬 하나를 고르십시오.\n");
			System.out.printf("1. 파이리          2. 이상해씨          3. 꼬부기\n");
			System.out.printf("************************************************************\n");
			System.out.printf("내가 선택할 포켓몬: ");
			
			try // 숫자를 입력 받는지 확인
			{
				receiveNumber = ShareData.scanUserInput.nextInt();
			}
			catch (InputMismatchException ErrorInput) // 숫자가 아닌 문자를 입력 한 경우 에러 메시지 출력
			{
				System.out.printf("************************************************************\n");
				System.out.println("잘못된 문자 입력입니다.\n다시 입력 해주세요.\n");
				System.out.printf("************************************************************\n");
				continue;
			}
			
			if ((receiveNumber <= 0) || (receiveNumber >= 4))
			{
				System.out.printf("************************************************************\n");
				System.out.println("잘못된 숫자 입력입니다.\n다시 입력 해주세요.\n");
				System.out.printf("************************************************************\n");
				continue;
			}
			else
			{
				// 포켓몬 선택 완료
				correctNumber = true;
			}
		}
		
		switch (receiveNumber)
		{
			case 1: // 파이리
				System.out.printf("************************************************************\n");
				System.out.printf("파이리를 선택했습니다.\n");
				System.out.printf("************************************************************\n");
				selectPokemonName = "파이리";
				break;				
			case 2: // 이상해씨
				System.out.printf("************************************************************\n");
				System.out.printf("이상해씨를 선택했습니다.\n");
				System.out.printf("************************************************************\n");
				selectPokemonName = "이상해씨";
				break;		
			case 3: // 꼬부기
				System.out.printf("************************************************************\n");
				System.out.printf("꼬부기를 선택했습니다.\n");
				System.out.printf("************************************************************\n");
				selectPokemonName = "꼬부기";
				break;
			default:
				break;
		}
		
		// 포켓몬 선정
		return selectPokemonName;
	}
		
	/**************************************************
	 
	setBasicMyPokemonStatus
	입력: 내 포켓몬 정보, 적 포켓몬 정보
	출력: 내 포켓몬 정보, 라이벌 포켓몬 정보
	
	처음 포켓몬을 선택하고 내 포켓몬의 정보를 저장한다.

	**************************************************/
	public void setBasicMyPokemonStatus ()
	{
		Charmander myCharmander = new Charmander(); // 파이리
		Bulbasaur myBulbasaur = new Bulbasaur();	// 이상해씨
		Squirtle mySquirtle = new Squirtle();		// 꼬부기
		
		//MyPokemon.PokemonName = PokemonName;
		
		// 포켓몬 선정 후 기본 값 설정
		switch (ShareData.myPokemon.pokemonName)
		{
			case "파이리":
				// 파이리의 기본 능력치 설정
				myCharmander.setBasicPokemonStatus (true);
				// 파이리의 기초 능력치 출력
				myCharmander.displayPokemonStatus ();
				// 라이벌 꼬부기의 기본 능력치 설정
				ShareData.rivalPokemon.pokemonName = "꼬부기";
				mySquirtle.setBasicPokemonStatus (false);
				break;
			case "이상해씨":
				// 이상해씨의 기본 능력치 설정
				myBulbasaur.setBasicPokemonStatus (true);
				// 이상해씨의 기초 능력치 출력
				myBulbasaur.displayPokemonStatus ();
				// 라이벌 파이리의 기본 능력치 설정
				ShareData.rivalPokemon.pokemonName = "파이리";
				myCharmander.setBasicPokemonStatus (false);
				break;
			case "꼬부기":
				// 꼬부기의 기본 능력치 설정
				mySquirtle.setBasicPokemonStatus (true);
				// 꼬부기의 기초 능력치 출력
				mySquirtle.displayPokemonStatus ();
				// 이상해씨의 기본 능력치 설정
				ShareData.rivalPokemon.pokemonName = "이상해씨";
				myBulbasaur.setBasicPokemonStatus (false);
				break;
			default:
				break;
		}
		
		// 레벨 1의 필요 경험치량
		ShareData.myPokemon.levelUpExp = 10;
		// 상태이상 정보
		ShareData.myPokemon.pokemonCondition = "정상";
		ShareData.rivalPokemon.pokemonCondition = "정상";
	}
	
	/**************************************************
	 
	increasePokemonStatus
	입력: 내 포켓몬의 정보, 레벨업 당시 오버된 경험치양
	출력: 내 포켓몬의 정보
	
	레벨업을 하면 능력치를 증가시켜주고 스킬을 익히고 진화 레벨이 되면 진화한다.

	**************************************************/
	public void increasePokemonStatus (int offsetExp)
	{
		FireElementPokemon fireElementPokemon = new FireElementPokemon();
		GrassElementPokemon grassElementPokemon = new GrassElementPokemon();
		WaterElementPokemon waterElementPokemon = new WaterElementPokemon();
		
		// 파이리, 이상해씨, 꼬부기 클래스
		Charmander charmander = new Charmander();
		Bulbasaur bulbasaur = new Bulbasaur();
		Squirtle squirtle = new Squirtle();
		
		if ((ShareData.myPokemon.pokemonName == "파이리") || 
				(ShareData.myPokemon.pokemonName == "리자드") || 
				(ShareData.myPokemon.pokemonName == "리자몽"))
		{
			System.out.printf("************************************************************\n");
			System.out.printf("%s의 능력치 상승 \n\n", ShareData.myPokemon.pokemonName);
			System.out.printf("레벨: %d -> %d\n", 
					(ShareData.myPokemon.pokemonLevel - 1), ShareData.myPokemon.pokemonLevel);
			System.out.printf("HP: %d + %d = %d\n", 
					ShareData.myPokemon.pokemonStatus[0], 2, (ShareData.myPokemon.pokemonStatus[0] + 2));
			System.out.printf("공격력: %d + %d = %d\n", 
					ShareData.myPokemon.pokemonStatus[1], 2, (ShareData.myPokemon.pokemonStatus[1] + 2));
			System.out.printf("방어력: %d + %d = %d\n", 
					ShareData.myPokemon.pokemonStatus[2], 1, (ShareData.myPokemon.pokemonStatus[2] + 1));
			System.out.printf("스피드: %d + %d = %d\n\n", 
					ShareData.myPokemon.pokemonStatus[5], 2, (ShareData.myPokemon.pokemonStatus[3] + 2));
			System.out.printf("************************************************************\n");
			ShareData.myPokemon.pokemonStatus[0] += 2;
			ShareData.myPokemon.pokemonStatus[1] += 2;
			ShareData.myPokemon.pokemonStatus[2] += 1;
			ShareData.myPokemon.pokemonStatus[3] += 2;
			ShareData.myPokemon.pokemonStatus[5] += 2;
			// 레벨업 후 스킬을 익힐레벨이 되면 무속성 스킬을 익힌다.
			ShareData.myPokemon.pokemonSkill.learnNewSkill (true);
			// 레벨업 후 스킬을 익힐레벨이 되면 불속성 스킬을 익힌다.
			fireElementPokemon.learnNewSkill (true);
			// 일정 레벨이 되면 진화한다.
			charmander.evolutionPokemon(true);
		}
		else if ((ShareData.myPokemon.pokemonName == "이상해씨") || 
				(ShareData.myPokemon.pokemonName == "이상해풀") || 
				(ShareData.myPokemon.pokemonName == "이상해꽃"))
		{
			System.out.printf("************************************************************\n");
			System.out.printf("%s의 능력치 상승 \n\n", ShareData.myPokemon.pokemonName);
			System.out.printf("레벨: %d -> %d\n", 
					(ShareData.myPokemon.pokemonLevel - 1), ShareData.myPokemon.pokemonLevel);
			System.out.printf("HP: %d + %d = %d\n",
					ShareData.myPokemon.pokemonStatus[0], 3, (ShareData.myPokemon.pokemonStatus[0] + 3));
			System.out.printf("공격력: %d + %d = %d\n", 
					ShareData.myPokemon.pokemonStatus[1], 1, (ShareData.myPokemon.pokemonStatus[1] + 1));
			System.out.printf("방어력: %d + %d = %d\n", 
					ShareData.myPokemon.pokemonStatus[2], 2, (ShareData.myPokemon.pokemonStatus[2] + 2));
			System.out.printf("스피드: %d + %d = %d\n\n", 
					ShareData.myPokemon.pokemonStatus[5], 1, (ShareData.myPokemon.pokemonStatus[3] + 1));
			System.out.printf("************************************************************\n");
			ShareData.myPokemon.pokemonStatus[0] += 3;
			ShareData.myPokemon.pokemonStatus[1] += 1;
			ShareData.myPokemon.pokemonStatus[2] += 2;
			ShareData.myPokemon.pokemonStatus[3] += 1;
			ShareData.myPokemon.pokemonStatus[5] += 3;
			// 레벨업 후 스킬을 익힐레벨이 되면 무속성 스킬을 익힌다.
			ShareData.myPokemon.pokemonSkill.learnNewSkill (true);
			// 레벨업 후 스킬을 익힐레벨이 되면 풀속성 스킬을 익힌다.
			grassElementPokemon.learnNewSkill (true);
			// 일정 레벨이 되면 진화한다.
			bulbasaur.evolutionPokemon(true);
		}
		else if ((ShareData.myPokemon.pokemonName == "꼬부기") || 
				(ShareData.myPokemon.pokemonName == "어니부기") || 
				(ShareData.myPokemon.pokemonName == "거북왕"))
		{
			System.out.printf("************************************************************\n");
			System.out.printf("%s의 능력치 상승 \n\n", ShareData.myPokemon.pokemonName);
			System.out.printf("레벨: %d -> %d\n", 
					(ShareData.myPokemon.pokemonLevel - 1), ShareData.myPokemon.pokemonLevel);
			System.out.printf("HP: %d + %d = %d\n", 
					ShareData.myPokemon.pokemonStatus[0], 2, (ShareData.myPokemon.pokemonStatus[0] + 2));
			System.out.printf("공격력: %d + %d = %d\n", 
					ShareData.myPokemon.pokemonStatus[1], 1, (ShareData.myPokemon.pokemonStatus[1] + 1));
			System.out.printf("방어력: %d + %d = %d\n", 
					ShareData.myPokemon.pokemonStatus[2], 1, (ShareData.myPokemon.pokemonStatus[2] + 1));
			System.out.printf("스피드: %d + %d = %d\n\n", 
					ShareData.myPokemon.pokemonStatus[5], 2, (ShareData.myPokemon.pokemonStatus[3] + 2));
			System.out.printf("************************************************************\n");
			ShareData.myPokemon.pokemonStatus[0] += 2;
			ShareData.myPokemon.pokemonStatus[1] += 1;
			ShareData.myPokemon.pokemonStatus[2] += 1;
			ShareData.myPokemon.pokemonStatus[3] += 2;
			ShareData.myPokemon.pokemonStatus[5] += 2;
			// 레벨업 후 스킬을 익힐레벨이 되면 무속성 스킬을 익힌다.
			ShareData.myPokemon.pokemonSkill.learnNewSkill (true);
			// 레벨업 후 스킬을 익힐레벨이 되면 물속성 스킬을 익힌다.
			waterElementPokemon.learnNewSkill (true);
			// 일정 레벨이 되면 진화한다.
			squirtle.evolutionPokemon(true);
		}
		else
		{
			// empty
		}
		
		ShareData.myPokemon.pokemonSkill.currentSkillCount[0] = ShareData.myPokemon.pokemonSkill.skillCount[0];
		ShareData.myPokemon.pokemonSkill.currentSkillCount[1] = ShareData.myPokemon.pokemonSkill.skillCount[1];
		ShareData.myPokemon.pokemonSkill.currentSkillCount[2] = ShareData.myPokemon.pokemonSkill.skillCount[2];
		ShareData.myPokemon.pokemonSkill.currentSkillCount[3] = ShareData.myPokemon.pokemonSkill.skillCount[3];
		
		// 레벨업 후 다음 경험치양에서 이전에 오버된 경험치양을 빼면서 현재 필요 경험치를 계산한다.
		ShareData.myPokemon.levelUpExp = (10 * ShareData.myPokemon.pokemonLevel) + offsetExp;
		// 레벨업 후 포켓몬 능력치를 콘솔에 출력한다.
		ShareData.myPokemon.displayPokemonStatus ();
	}
	
	/**************************************************
	 
	increasePokemonStatus
	입력: 라이벌 포켓몬의 정보
	출력: 라이벌 포켓몬의 정보
	
	레벨업을 하면 능력치를 증가시켜주고 스킬을 익히고 진화 레벨이 되면 진화한다.

	**************************************************/
	public void increasePokemonStatus ()
	{
		FireElementPokemon fireElementPokemon = new FireElementPokemon();
		GrassElementPokemon grassElementPokemon = new GrassElementPokemon();
		WaterElementPokemon waterElementPokemon = new WaterElementPokemon();
		
		// 파이리, 이상해씨, 꼬부기 클래스
		Charmander charmander = new Charmander();
		Bulbasaur bulbasaur = new Bulbasaur();
		Squirtle squirtle = new Squirtle();
		
		ShareData.rivalPokemon.pokemonLevel += 1;
		
		if ((ShareData.rivalPokemon.pokemonName == "파이리") || 
				(ShareData.rivalPokemon.pokemonName == "리자드") || 
				(ShareData.rivalPokemon.pokemonName == "리자몽"))
		{
			ShareData.rivalPokemon.pokemonStatus[0] += 2;
			ShareData.rivalPokemon.pokemonStatus[1] += 2;
			ShareData.rivalPokemon.pokemonStatus[2] += 1;
			ShareData.rivalPokemon.pokemonStatus[3] += 2;
			ShareData.rivalPokemon.pokemonStatus[5] += 2;
			// 레벨업 후 스킬을 익힐레벨이 되면 무속성 스킬을 익힌다.
			ShareData.rivalPokemon.pokemonSkill.learnNewSkill (false);
			// 레벨업 후 스킬을 익힐레벨이 되면 불속성 스킬을 익힌다.
			fireElementPokemon.learnNewSkill (false);
			// 일정 레벨이 되면 진화한다.
			charmander.evolutionPokemon(false);
		}
		else if ((ShareData.rivalPokemon.pokemonName == "이상해씨") || 
				(ShareData.rivalPokemon.pokemonName == "이상해풀") || 
				(ShareData.rivalPokemon.pokemonName == "이상해꽃"))
		{
			ShareData.rivalPokemon.pokemonStatus[0] += 3;
			ShareData.rivalPokemon.pokemonStatus[1] += 1;
			ShareData.rivalPokemon.pokemonStatus[2] += 2;
			ShareData.rivalPokemon.pokemonStatus[3] += 1;
			ShareData.rivalPokemon.pokemonStatus[5] += 3;
			// 레벨업 후 스킬을 익힐레벨이 되면 무속성 스킬을 익힌다.
			ShareData.rivalPokemon.pokemonSkill.learnNewSkill (false);
			// 레벨업 후 스킬을 익힐레벨이 되면 풀속성 스킬을 익힌다.
			grassElementPokemon.learnNewSkill (false);
			// 일정 레벨이 되면 진화한다.
			bulbasaur.evolutionPokemon(false);
		}
		else if ((ShareData.rivalPokemon.pokemonName == "꼬부기") || 
				(ShareData.rivalPokemon.pokemonName == "어니부기") || 
				(ShareData.rivalPokemon.pokemonName == "거북왕"))
		{
			ShareData.rivalPokemon.pokemonStatus[0] += 2;
			ShareData.rivalPokemon.pokemonStatus[1] += 2;
			ShareData.rivalPokemon.pokemonStatus[2] += 1;
			ShareData.rivalPokemon.pokemonStatus[3] += 2;
			ShareData.rivalPokemon.pokemonStatus[5] += 2;
			// 레벨업 후 스킬을 익힐레벨이 되면 무속성 스킬을 익힌다.
			ShareData.rivalPokemon.pokemonSkill.learnNewSkill (false);
			// 레벨업 후 스킬을 익힐레벨이 되면 물속성 스킬을 익힌다.
			waterElementPokemon.learnNewSkill (false);
			// 일정 레벨이 되면 진화한다.
			squirtle.evolutionPokemon(false);
		}
		else
		{
			// empty
		}
		
		ShareData.pokemon.pokemonSkill.currentSkillCount[0] = ShareData.pokemon.pokemonSkill.skillCount[0];
		ShareData.pokemon.pokemonSkill.currentSkillCount[1] = ShareData.pokemon.pokemonSkill.skillCount[1];
		ShareData.pokemon.pokemonSkill.currentSkillCount[2] = ShareData.pokemon.pokemonSkill.skillCount[2];
		ShareData.pokemon.pokemonSkill.currentSkillCount[3] = ShareData.pokemon.pokemonSkill.skillCount[3];
	}
}

// End of File
