/**************************************************
 
나의 포켓몬 클래스

**************************************************/

package pokemon;

import java.util.InputMismatchException;

class MyPokemon extends Pokemon
{
	int familiarity = 0;	// 친밀도
	
	/**************************************************
	 
	goToPokemonCenter
	입력: 유저가 입력하는 수치
	출력: 포켓몬 상태
	
	야생 포켓몬의 출현을 알려준다.
	플레이어의 레벨에 따라서 출현하는 포켓몬 종류와 레벨이 달라진다.

	**************************************************/
	void goToPokemonCenter ()
	{
		int receiveNumber = -1;			// 사용자가 입력하는 수치
		boolean correctNumber = false;	// 올바른 숫자 입력을 판단하는 변수
		
		while (correctNumber == false)
		{
			System.out.printf("************************************************************\n");
			System.out.printf("%s와 포켓몬 센터에 왔다.\n", pokemonName);
			System.out.printf("1. 회복한다.\n");
			System.out.printf("2. 그냥 나간다.\n");
			System.out.printf("************************************************************\n");
			System.out.printf("번호 선택: ");
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
			
			if ((receiveNumber <= 0) || (receiveNumber >= 3))
			{
				System.out.printf("************************************************************\n");
				System.out.println("잘못된 숫자 입력입니다.\n다시 입력 해주세요.\n");
				System.out.printf("************************************************************\n");
				continue;
			}
			
			if (receiveNumber == 1)
			{
				System.out.printf("포켓몬 센터에서 회복하기로 했다.\n\n");
				// 포켓몬을 회복한다.
				// HP 회복
				pokemonStatus[5] = pokemonStatus[0];
				System.out.printf("%s의 HP: %d / %d\n", pokemonName, pokemonStatus[5], pokemonStatus[0]);
				// 스킬 사용횟수 회복
				for (int skillIdx = 0; skillIdx < 4; skillIdx++)
				{
					pokemonSkill.currentSkillCount[skillIdx] = pokemonSkill.skillCount[skillIdx];
				}
				System.out.printf("1. %s\n위력: %d, 횟수: (%d / %d), 명중률: %d\n", 
						pokemonSkill.skillName[0], 
						pokemonSkill.skillDamage[0], 
						pokemonSkill.currentSkillCount[0], pokemonSkill.skillCount[0], 
						pokemonSkill.skillAccuracy[0]);
				System.out.printf("2. %s\n위력: %d, 횟수: (%d / %d), 명중률: %d\n", 
						pokemonSkill.skillName[1], 
						pokemonSkill.skillDamage[1], 
						pokemonSkill.currentSkillCount[1], pokemonSkill.skillCount[1], 
						pokemonSkill.skillAccuracy[1]);
				System.out.printf("3. %s\n위력: %d, 횟수: (%d / %d), 명중률: %d\n", 
						pokemonSkill.skillName[2], 
						pokemonSkill.skillDamage[2], 
						pokemonSkill.currentSkillCount[2], pokemonSkill.skillCount[2], 
						pokemonSkill.skillAccuracy[2]);
				System.out.printf("4. %s\n위력: %d, 횟수: (%d / %d), 명중률: %d\n", 
						pokemonSkill.skillName[3], 
						pokemonSkill.skillDamage[3], 
						pokemonSkill.currentSkillCount[3], pokemonSkill.skillCount[3], 
						pokemonSkill.skillAccuracy[3]);
				System.out.printf("************************************************************\n\n");
				System.out.printf("포켓몬이 건강해졌다!\n\n");
				System.out.printf("************************************************************\n\n");
			}
			else
			{
				System.out.printf("아무것도 안하고 그냥 갔다.\n");
				System.out.printf("************************************************************\n");
			}
			
			correctNumber = true;
		}
	}
}