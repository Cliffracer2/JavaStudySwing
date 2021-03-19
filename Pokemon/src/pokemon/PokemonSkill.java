/**************************************************
 
포켓몬 스킬 클래스

**************************************************/

package pokemon;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Random;

public class PokemonSkill 
{
	List<String> skillNameList = new ArrayList<String>();		// 스킬 명 리스트
	ArrayList<Integer> skillDamageList = new ArrayList<>();		// 스킬 위력 리스트
	ArrayList<Integer> skillCountList = new ArrayList<>();		// 스킬 횟수 리스트
	ArrayList<Integer> skillAccuracyList = new ArrayList<>();	// 스킬 명중률 리스트
	
	// 포켓몬의 스킬 4개를 저장할 자리
	// 스킬 1 ~ 4의 이름
	String[] skillName = new String[4];
	// 스킬 1 ~ 4의 위력 정보
	int[] skillDamage = new int[4];
	// 스킬 1 ~ 4의 명중률 정보
	int[] skillAccuracy = new int[4];
	// 스킬 1 ~ 4의 사용할 수 있는 횟수 정보
	int[] skillCount = new int[4];
	// 스킬 1 ~ 4의 현재 사용할 수 있는 횟수 정보
	int[] currentSkillCount = new int[4];
	// 스킬 속성 정보를 저장한다.
	// 0: 무속성, 1: 불속성, 2: 풀속성, 3: 물속성
	int[] skillType = new int[4];
		
	// 보통의 무속성 스킬(포켓몬이 공통으로 익힐 수 있는) 정보
	public void setSkill ()
	{
		skillNameList.add("몸통박치기");		// 0
		skillNameList.add("할퀴기");			// 1
		skillNameList.add("고속스핀");			// 2
		skillNameList.add("메가톤펀치");		// 3
		skillNameList.add("돌진");			// 4
		skillNameList.add("괴력");			// 5
		skillNameList.add("누르기");			// 6
		skillNameList.add("기가임팩트");		// 7
		skillNameList.add("이판사판태클");		// 8

		skillDamageList.add(40);			// 0
		skillDamageList.add(40);			// 1
		skillDamageList.add(50);			// 2
		skillDamageList.add(80);			// 3
		skillDamageList.add(90);			// 4
		skillDamageList.add(80);			// 5
		skillDamageList.add(85);			// 6
		skillDamageList.add(150);			// 7
		skillDamageList.add(120);			// 8
		
		skillCountList.add(35);				// 0
		skillCountList.add(35);				// 1
		skillCountList.add(40);				// 2
		skillCountList.add(20);				// 3
		skillCountList.add(20);				// 4
		skillCountList.add(15);				// 5
		skillCountList.add(15);				// 6
		skillCountList.add(5);				// 7
		skillCountList.add(15);				// 8
		
		skillAccuracyList.add(100);			// 0
		skillAccuracyList.add(100);			// 1
		skillAccuracyList.add(100);			// 2
		skillAccuracyList.add(85);			// 3
		skillAccuracyList.add(85);			// 4
		skillAccuracyList.add(100);			// 5
		skillAccuracyList.add(100);			// 6
		skillAccuracyList.add(90);			// 7
		skillAccuracyList.add(100);			// 8
	}
	
	/**************************************************
	
	setSkillName
	입력: 스킬 위치, 리스트의 스킬명 위치 값
	출력: 스킬 이름
	
	무속성 스킬 이름 저장

	**************************************************/
	void setSkillName (String[] skillName, int skillPosition, int skillIndex)
	{	
		// 포켓몬의 스킬 정보를 불러온다.
		setSkill();
		
		// SkillPosition 자리에  SkillIndex값의 스킬을 익힌다.
		skillName[skillPosition] = skillNameList.get(skillIndex);
	}
	
	/**************************************************
	
	setSkillDamage
	입력: 스킬 위치, 리스트의 스킬명 위치 값
	출력: 스킬 위력
	
	무속성 스킬 위력 저장

	**************************************************/
	void setSkillDamage (int[] skillDamage, int skillPosition, int skillIndex)
	{
		// 포켓몬의 스킬 정보를 불러온다.
		setSkill();
		
		// SkillPosition 자리에  SkillIndex값의 스킬을 익힌다.
		skillDamage[skillPosition] = skillDamageList.get(skillIndex);
	}
	
	/**************************************************
	
	setSkillCount
	입력: 스킬 위치, 리스트의 스킬명 위치 값
	출력: 스킬 횟수
	
	무속성 스킬 횟수 저장

	**************************************************/
	void setSkillCount (int[] skillCount, int skillPosition, int skillIndex)
	{
		// 포켓몬의 스킬 정보를 불러온다.
		setSkill();
		
		// SkillPosition 자리에  SkillIndex값의 스킬을 익힌다.
		skillCount[skillPosition] = skillCountList.get(skillIndex);
	}
	
	/**************************************************
	
	setSkillAccuracy
	입력: 스킬 위치, 리스트의 스킬명 위치 값
	출력: 스킬 횟수
	
	무속성 스킬 명중률 저장

	**************************************************/
	void setSkillAccuracy (int[] skillAccuracy, int skillPosition, int skillIndex)
	{
		// 포켓몬의 스킬 정보를 불러온다.
		setSkill();
		
		// SkillPosition 자리에  SkillIndex값의 스킬을 익힌다.
		skillAccuracy[skillPosition] = skillAccuracyList.get(skillIndex);
	}
	
	/**************************************************
	
	setSkillType
	입력: 스킬 위치
	출력: 스킬 속성
	
	무속성 스킬 속성 저장

	**************************************************/
	void setSkillType (int[] skillType, int skillPosition)
	{
		// 무속성으로 저장
		skillType[skillPosition] = 0;
	}
	
	/**************************************************
	
	pokemonUsingSkill
	입력: 사용자로부터 입력받을 정보, 내 포켓몬 정보
	출력: 플레이어가 사용할 스킬 번호
	
	플레이어 포켓몬의 스킬 사용
	1 ~ 4번의 스킬중 하나를 입력하여 사용하고 입력한 번호 값을 리턴한다.

	**************************************************/
	public int pokemonUsingSkill (MyPokemon myPokemon)
	{
		// 전투에 사용할 스킬 선택
		int receiveNumber = -1;				// 사용자가 입력하는 사이즈 수치
		boolean correctNumber = false;		// 올바른 숫자 입력을 판단하는 변수
		
		// 맞는 숫자를 입력할 때까지 반복
		while (correctNumber == false)
		{
			// 4개의 스킬은 스킬명, 위력, (현재 횟수 / 최대 횟수) 순으로 출력
			System.out.printf("************************************************************\n");
			System.out.printf("스킬을 선택 하세요.\n");
			System.out.printf("1. %s\n위력: %d, 횟수: (%d / %d), 명중률: %d\n", 
					myPokemon.pokemonSkill.skillName[0], 
					myPokemon.pokemonSkill.skillDamage[0], 
					myPokemon.pokemonSkill.currentSkillCount[0], myPokemon.pokemonSkill.skillCount[0], 
					myPokemon.pokemonSkill.skillAccuracy[0]);
			System.out.printf("2. %s\n위력: %d, 횟수: (%d / %d), 명중률: %d\n", 
					myPokemon.pokemonSkill.skillName[1], 
					myPokemon.pokemonSkill.skillDamage[1], 
					myPokemon.pokemonSkill.currentSkillCount[1], myPokemon.pokemonSkill.skillCount[1], 
					myPokemon.pokemonSkill.skillAccuracy[1]);
			System.out.printf("3. %s\n위력: %d, 횟수: (%d / %d), 명중률: %d\n", 
					myPokemon.pokemonSkill.skillName[2], 
					myPokemon.pokemonSkill.skillDamage[2], 
					myPokemon.pokemonSkill.currentSkillCount[2], myPokemon.pokemonSkill.skillCount[2], 
					myPokemon.pokemonSkill.skillAccuracy[2]);
			System.out.printf("4. %s\n위력: %d, 횟수: (%d / %d), 명중률: %d\n", 
					myPokemon.pokemonSkill.skillName[3], 
					myPokemon.pokemonSkill.skillDamage[3], 
					myPokemon.pokemonSkill.currentSkillCount[3], myPokemon.pokemonSkill.skillCount[3], 
					myPokemon.pokemonSkill.skillAccuracy[3]);
			System.out.printf("************************************************************\n");
			System.out.printf("내가 선택할 스킬번호: ");
			
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
			
			if ((receiveNumber <= 0) || (receiveNumber >= 5))
			{
				System.out.printf("************************************************************\n");
				System.out.println("잘못된 숫자 입력입니다.\n다시 입력 해주세요.\n");
				System.out.printf("************************************************************\n");
				continue;
			}
			else
			{
				// 사용한 스킬의 횟수가 0이면
				if (myPokemon.pokemonSkill.currentSkillCount[receiveNumber - 1] == 0)
				{
					System.out.printf("\n\n");
					System.out.printf("그 기술은 더이상 사용하지 못해! 다른 스킬을 써야해!\n");
					continue;
				}
				else
				{
					// 숫자를 맞게 입력함
					correctNumber = true;
				}
			}
		}
		
		// 스킬 사용시 메시지 출력
		System.out.printf("\n\n");
		
		switch (receiveNumber)
		{
			case 1: // 1번째 스킬 사용
				System.out.printf("%s! %s!\n", 
						myPokemon.pokemonName, myPokemon.pokemonSkill.skillName[0]);
				break;
			case 2: // 2번째 스킬 사용
				System.out.printf("%s! %s!\n", 
						myPokemon.pokemonName, myPokemon.pokemonSkill.skillName[1]);
				break;
			case 3: // 3번째 스킬 사용
				System.out.printf("%s! %s!\n", 
						myPokemon.pokemonName, myPokemon.pokemonSkill.skillName[2]);
				break;
			case 4: // 4번째 스킬 사용
				System.out.printf("%s! %s!\n", 
						myPokemon.pokemonName, myPokemon.pokemonSkill.skillName[3]);
				break;
			default:
				break;
		}
		
		// 스킬을 사용하고나서 스킬 카운트를 1 감소 시킨다.
		if (myPokemon.pokemonSkill.currentSkillCount[receiveNumber - 1] > 0)
		{
			myPokemon.pokemonSkill.currentSkillCount[receiveNumber - 1]--;
		}
		
		// 배열에 저장한 위치를 맞추기 위해 1을 감소시킴
		return (receiveNumber - 1);
	}
	
	/**************************************************
	
	pokemonUsingSkill
	입력: 적 포켓몬 정보
	출력: 적이 사용하는 스킬 번호
	
	적 포켓몬의 스킬 사용
	1 ~ 4번의 스킬중 하나를 입력하여 사용하고 입력한 번호 값을 리턴한다.

	**************************************************/
	public int pokemonUsingSkill (EnemyPokemon enemyPokemon)
	{
		// 랜덤숫자를 얻기 위한 랜덤 클래스
		Random randomSkillUse = new Random();
		int useSkillNumber = -1;	// 스킬 번호 선택
		
		// 적 포켓몬은 랜덤으로 나온 스킬 번호를 입력 받아 스킬을 사용한다.
		useSkillNumber = randomSkillUse.nextInt(4) + 1;
		
		// 스킬 사용시 메시지 출력
		System.out.printf("\n\n");
		
		switch (useSkillNumber)
		{
			case 1: // 1번째 스킬 사용
				System.out.printf("%s의 %s!\n", 
						enemyPokemon.pokemonName, enemyPokemon.pokemonSkill.skillName[0]);
				break;
			case 2: // 2번째 스킬 사용
				System.out.printf("%s의 %s!\n", 
						enemyPokemon.pokemonName, enemyPokemon.pokemonSkill.skillName[1]);
				break;
			case 3: // 3번째 스킬 사용
				System.out.printf("%s의 %s!\n", 
						enemyPokemon.pokemonName, enemyPokemon.pokemonSkill.skillName[2]);
				break;
			case 4: // 4번째 스킬 사용
				System.out.printf("%s의 %s!\n", 
						enemyPokemon.pokemonName, enemyPokemon.pokemonSkill.skillName[3]);
				break;
			default:
				break;
		}
		
		// 스킬을 사용하고나서 스킬 카운트를 1 감소 시킨다.
		if (enemyPokemon.pokemonSkill.currentSkillCount[useSkillNumber - 1] > 0)
		{
			enemyPokemon.pokemonSkill.currentSkillCount[useSkillNumber - 1]--;
		}
		
		// 배열에 저장한 위치를 맞추기 위해 1을 감소시킴
		return (useSkillNumber - 1);
	}
	
	/**************************************************
	 
	learnNewSkill
	입력: 내 포켓몬 정보
	출력: 새로운 스킬을 익힌 내 포켓몬 정보
	
	일정 레벨이 되면 새로운 무속성 스킬을 익힌다.

	**************************************************/
	void learnNewSkill (boolean isMyPokemon)
	{
		int level = 0;
		
		if (isMyPokemon == true)
		{
			level = ShareData.myPokemon.pokemonLevel;
		}
		else
		{
			level = ShareData.rivalPokemon.pokemonLevel;
		}
		
		switch (level)
		{
			case 5: // 레벨 5
				// 고속스핀을 익힌다.
				if (isMyPokemon == true)
				{
					ShareData.myPokemon.pokemonSkill.setSkillName (ShareData.myPokemon.pokemonSkill.skillName, 2, 2);
					ShareData.myPokemon.pokemonSkill.setSkillDamage (ShareData.myPokemon.pokemonSkill.skillDamage, 2, 2);
					ShareData.myPokemon.pokemonSkill.setSkillAccuracy (ShareData.myPokemon.pokemonSkill.skillAccuracy, 2, 2);
					ShareData.myPokemon.pokemonSkill.setSkillCount (ShareData.myPokemon.pokemonSkill.skillCount, 2, 2);
					ShareData.myPokemon.pokemonSkill.setSkillType (ShareData.myPokemon.pokemonSkill.skillType, 2);
					System.out.printf("새로운 스킬 %s을(를) 익혔다! \n\n", ShareData.myPokemon.pokemonSkill.skillName[2]);
				}
				else
				{
					ShareData.rivalPokemon.pokemonSkill.setSkillName (ShareData.rivalPokemon.pokemonSkill.skillName, 2, 2);
					ShareData.rivalPokemon.pokemonSkill.setSkillDamage (ShareData.rivalPokemon.pokemonSkill.skillDamage, 2, 2);
					ShareData.rivalPokemon.pokemonSkill.setSkillAccuracy (ShareData.rivalPokemon.pokemonSkill.skillAccuracy, 2, 2);
					ShareData.rivalPokemon.pokemonSkill.setSkillCount (ShareData.rivalPokemon.pokemonSkill.skillCount, 2, 2);
					ShareData.rivalPokemon.pokemonSkill.setSkillType (ShareData.rivalPokemon.pokemonSkill.skillType, 2);
				}

				break;
			case 15: // 레벨 15
				// 메가톤펀치를 익힌다.
				if (isMyPokemon == true)
				{
					ShareData.myPokemon.pokemonSkill.setSkillName (ShareData.myPokemon.pokemonSkill.skillName, 3, 3);
					ShareData.myPokemon.pokemonSkill.setSkillDamage (ShareData.myPokemon.pokemonSkill.skillDamage, 3, 3);
					ShareData.myPokemon.pokemonSkill.setSkillAccuracy (ShareData.myPokemon.pokemonSkill.skillAccuracy, 3, 3);
					ShareData.myPokemon.pokemonSkill.setSkillCount (ShareData.myPokemon.pokemonSkill.skillCount, 3, 3);
					ShareData.myPokemon.pokemonSkill.setSkillType (ShareData.myPokemon.pokemonSkill.skillType, 3);
					System.out.printf("새로운 스킬 %s을(를) 익혔다! \n\n", ShareData.myPokemon.pokemonSkill.skillName[3]);
				}
				else
				{
					ShareData.rivalPokemon.pokemonSkill.setSkillName (ShareData.rivalPokemon.pokemonSkill.skillName, 3, 3);
					ShareData.rivalPokemon.pokemonSkill.setSkillDamage (ShareData.rivalPokemon.pokemonSkill.skillDamage, 3, 3);
					ShareData.rivalPokemon.pokemonSkill.setSkillAccuracy (ShareData.rivalPokemon.pokemonSkill.skillAccuracy, 3, 3);
					ShareData.rivalPokemon.pokemonSkill.setSkillCount (ShareData.rivalPokemon.pokemonSkill.skillCount, 3, 3);
					ShareData.rivalPokemon.pokemonSkill.setSkillType (ShareData.rivalPokemon.pokemonSkill.skillType, 3);
				}

				break;
			case 25: // 레벨 25
				// 돌진을 익힌다.
				if (isMyPokemon == true)
				{
					ShareData.myPokemon.pokemonSkill.setSkillName (ShareData.myPokemon.pokemonSkill.skillName, 0, 4);
					ShareData.myPokemon.pokemonSkill.setSkillDamage (ShareData.myPokemon.pokemonSkill.skillDamage, 0, 4);
					ShareData.myPokemon.pokemonSkill.setSkillAccuracy (ShareData.myPokemon.pokemonSkill.skillAccuracy, 0, 4);
					ShareData.myPokemon.pokemonSkill.setSkillCount (ShareData.myPokemon.pokemonSkill.skillCount, 0, 4);
					ShareData.myPokemon.pokemonSkill.setSkillType (ShareData.myPokemon.pokemonSkill.skillType, 0);
					System.out.printf("새로운 스킬 %s을(를) 익혔다! \n\n", ShareData.myPokemon.pokemonSkill.skillName[0]);
				}
				else
				{
					ShareData.rivalPokemon.pokemonSkill.setSkillDamage (ShareData.rivalPokemon.pokemonSkill.skillDamage, 0, 4);
					ShareData.rivalPokemon.pokemonSkill.setSkillAccuracy (ShareData.rivalPokemon.pokemonSkill.skillAccuracy, 0, 4);
					ShareData.rivalPokemon.pokemonSkill.setSkillCount (ShareData.rivalPokemon.pokemonSkill.skillCount, 0, 4);
					ShareData.rivalPokemon.pokemonSkill.setSkillType (ShareData.rivalPokemon.pokemonSkill.skillType, 0);
				}

				break;
			case 35: // 레벨 35
				// 괴력을 익힌다.
				if (isMyPokemon == true)
				{
					ShareData.myPokemon.pokemonSkill.setSkillName (ShareData.myPokemon.pokemonSkill.skillName, 1, 5);
					ShareData.myPokemon.pokemonSkill.setSkillDamage (ShareData.myPokemon.pokemonSkill.skillDamage, 1, 5);
					ShareData.myPokemon.pokemonSkill.setSkillAccuracy (ShareData.myPokemon.pokemonSkill.skillAccuracy, 1, 5);
					ShareData.myPokemon.pokemonSkill.setSkillCount (ShareData.myPokemon.pokemonSkill.skillCount, 1, 5);
					ShareData.myPokemon.pokemonSkill.setSkillType (ShareData.myPokemon.pokemonSkill.skillType, 1);
					System.out.printf("새로운 스킬 %s을(를) 익혔다! \n\n", ShareData.myPokemon.pokemonSkill.skillName[1]);
				}
				else
				{
					ShareData.rivalPokemon.pokemonSkill.setSkillName (ShareData.rivalPokemon.pokemonSkill.skillName, 1, 5);
					ShareData.rivalPokemon.pokemonSkill.setSkillDamage (ShareData.rivalPokemon.pokemonSkill.skillDamage, 1, 5);
					ShareData.rivalPokemon.pokemonSkill.setSkillAccuracy (ShareData.rivalPokemon.pokemonSkill.skillAccuracy, 1, 5);
					ShareData.rivalPokemon.pokemonSkill.setSkillCount (ShareData.rivalPokemon.pokemonSkill.skillCount, 1, 5);
					ShareData.rivalPokemon.pokemonSkill.setSkillType (ShareData.rivalPokemon.pokemonSkill.skillType, 0);
				}

				break;
			default:
				break;
		}
	}
}

//End of File
