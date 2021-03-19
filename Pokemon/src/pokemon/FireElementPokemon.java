/**************************************************
 
불속성 포켓몬 클래스

**************************************************/

package pokemon;

import java.util.Random;

//import java.util.InputMismatchException;

// 불속성 포켓몬
// 불속성 포켓몬 클래스가 포켓몬 클래스에 상속을 요청
class FireElementPokemon extends Pokemon
{
	// 불속성 스킬 클래스
	FireSkill fireSkill = new FireSkill();
	// 불 속성 포켓몬은 화상을 입힐 수 있다.
	boolean burnStatus = false;
	
	/**************************************************
	 
	makeBurnStatus
	입력: 0 ~ 99 까지 랜덤 숫자
	출력: 화상 상태
	
	불속성 공격을 하면 20%의 확률로 화상이 걸린다.

	**************************************************/
	boolean makeBurnStatus ()
	{
		// 랜덤숫자를 얻기 위한 랜덤 클래스
		Random random = new Random();
		int randomNumber = -1;	// 랜덤 번호를 저장
		
		// 랜덤 번호를 얻어서 값이 20보다 작으면 화상 상태가 된다.
		randomNumber = random.nextInt(100);
		
		if (randomNumber >= 20)
		{
			burnStatus = false;
		}
		else
		{
			burnStatus = true;
		}
		
		return burnStatus;
	}
	
	/**************************************************
	 
	LearnNewSkill
	입력: 내 포켓몬 정보
	출력: 새로운 스킬을 익힌 내 포켓몬 정보
	
	일정 레벨이 되면  새로운 불속성 스킬을 익힌다.

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
			case 10: // 레벨 10
				// 불꽃엄니를 익힌다.
				if (isMyPokemon == true)
				{
					fireSkill.setSkillName (ShareData.myPokemon.pokemonSkill.skillName, 3, 1);
					fireSkill.setSkillDamage (ShareData.myPokemon.pokemonSkill.skillDamage, 3, 1);
					fireSkill.setSkillAccuracy (ShareData.myPokemon.pokemonSkill.skillAccuracy, 3, 1);
					fireSkill.setSkillCount (ShareData.myPokemon.pokemonSkill.skillCount, 3, 1);
					fireSkill.setSkillType (ShareData.myPokemon.pokemonSkill.skillType, 3);
					System.out.printf("새로운 스킬 %s을(를) 익혔다! \n\n", ShareData.myPokemon.pokemonSkill.skillName[3]);
				}
				else
				{
					fireSkill.setSkillName (ShareData.rivalPokemon.pokemonSkill.skillName, 3, 1);
					fireSkill.setSkillDamage (ShareData.rivalPokemon.pokemonSkill.skillDamage, 3, 1);
					fireSkill.setSkillAccuracy (ShareData.rivalPokemon.pokemonSkill.skillAccuracy, 3, 1);
					fireSkill.setSkillCount (ShareData.rivalPokemon.pokemonSkill.skillCount, 3, 1);
					fireSkill.setSkillType (ShareData.rivalPokemon.pokemonSkill.skillType, 0);
				}

				break;
			case 20: // 레벨 20
				// 화염방사를 익힌다.
				if (isMyPokemon == true)
				{
					fireSkill.setSkillName (ShareData.myPokemon.pokemonSkill.skillName, 1, 2);
					fireSkill.setSkillDamage (ShareData.myPokemon.pokemonSkill.skillDamage, 1, 2);
					fireSkill.setSkillAccuracy (ShareData.myPokemon.pokemonSkill.skillAccuracy, 1, 2);
					fireSkill.setSkillCount (ShareData.myPokemon.pokemonSkill.skillCount, 1, 2);
					fireSkill.setSkillType (ShareData.myPokemon.pokemonSkill.skillType, 1);
					System.out.printf("새로운 스킬 %s을(를) 익혔다! \n\n", ShareData.myPokemon.pokemonSkill.skillName[1]);
				}
				else
				{
					fireSkill.setSkillName (ShareData.rivalPokemon.pokemonSkill.skillName, 1, 2);
					fireSkill.setSkillDamage (ShareData.rivalPokemon.pokemonSkill.skillDamage, 1, 2);
					fireSkill.setSkillAccuracy (ShareData.rivalPokemon.pokemonSkill.skillAccuracy, 1, 2);
					fireSkill.setSkillCount (ShareData.rivalPokemon.pokemonSkill.skillCount, 1, 2);
					fireSkill.setSkillType (ShareData.rivalPokemon.pokemonSkill.skillType, 1);
				}

				break;
			case 30: // 레벨 30
				// 불대문자를 익힌다.
				if (isMyPokemon == true)
				{
					fireSkill.setSkillName (ShareData.myPokemon.pokemonSkill.skillName, 2, 3);
					fireSkill.setSkillDamage (ShareData.myPokemon.pokemonSkill.skillDamage, 2, 3);
					fireSkill.setSkillAccuracy (ShareData.myPokemon.pokemonSkill.skillAccuracy, 2, 3);
					fireSkill.setSkillCount (ShareData.myPokemon.pokemonSkill.skillCount, 2, 3);
					fireSkill.setSkillType (ShareData.myPokemon.pokemonSkill.skillType, 2);
					System.out.printf("새로운 스킬 %s을(를) 익혔다! \n\n", ShareData.myPokemon.pokemonSkill.skillName[2]);
				}
				else
				{
					fireSkill.setSkillName (ShareData.rivalPokemon.pokemonSkill.skillName, 2, 3);
					fireSkill.setSkillDamage (ShareData.rivalPokemon.pokemonSkill.skillDamage, 2, 3);
					fireSkill.setSkillAccuracy (ShareData.rivalPokemon.pokemonSkill.skillAccuracy, 2, 3);
					fireSkill.setSkillCount (ShareData.rivalPokemon.pokemonSkill.skillCount, 2, 3);
					fireSkill.setSkillType (ShareData.rivalPokemon.pokemonSkill.skillType, 2);
				}

				break;
			case 40: // 레벨 40
				// 플레어드라이브를 익힌다.
				if (isMyPokemon == true)
				{
					fireSkill.setSkillName (ShareData.myPokemon.pokemonSkill.skillName, 3, 4);
					fireSkill.setSkillDamage (ShareData.myPokemon.pokemonSkill.skillDamage, 3, 4);
					fireSkill.setSkillAccuracy (ShareData.myPokemon.pokemonSkill.skillAccuracy, 3, 4);
					fireSkill.setSkillCount (ShareData.myPokemon.pokemonSkill.skillCount, 3, 4);
					fireSkill.setSkillType (ShareData.myPokemon.pokemonSkill.skillType, 3);
					System.out.printf("새로운 스킬 %s을(를) 익혔다! \n\n", ShareData.myPokemon.pokemonSkill.skillName[3]);
				}
				else
				{
					fireSkill.setSkillName (ShareData.rivalPokemon.pokemonSkill.skillName, 3, 4);
					fireSkill.setSkillDamage (ShareData.rivalPokemon.pokemonSkill.skillDamage, 3, 4);
					fireSkill.setSkillAccuracy (ShareData.rivalPokemon.pokemonSkill.skillAccuracy, 3, 4);
					fireSkill.setSkillCount (ShareData.rivalPokemon.pokemonSkill.skillCount, 3, 4);
					fireSkill.setSkillType (ShareData.rivalPokemon.pokemonSkill.skillType, 3);
				}

				break;
			default:
				break;
		}
	}
}

//2차 상속을 받은 불속성 포켓몬인 파이리
//Charmander: 파이리의 영문명
class Charmander extends FireElementPokemon
{
	/**************************************************
	 
	setBasicPokemonStatus
	입력: 정보가 없는 내 포켓몬 정보
	출력: 파이리 정보를 저장한 내 포켓몬의 정보
	
	파이리를 선택하고 초기 능력치를 설정한다.

	**************************************************/
	void setBasicPokemonStatus (boolean isMyPokemon)
	{
		if (isMyPokemon == true)
		{
			// 레벨 1의 기본 능력치 설정
			ShareData.myPokemon.pokemonStatus[0] = 10;		// HealthPoint
			ShareData.myPokemon.pokemonStatus[1] = 6;		// Attack
			ShareData.myPokemon.pokemonStatus[2] = 5;		// Defense
			ShareData.myPokemon.pokemonStatus[3] = 6;		// Speed
			
			ShareData.myPokemon.pokemonStatus[4] = 1; 		// 포켓몬 타입(불속성)
			ShareData.myPokemon.pokemonStatus[5] = 10; 		// 포켓몬의 남은 체력
			
			// 파이리가 처음 익히고 있는 스킬 설정
			// 스킬명
			ShareData.myPokemon.pokemonSkill.setSkillName (ShareData.myPokemon.pokemonSkill.skillName, 0, 1);
			fireSkill.setSkillName (ShareData.myPokemon.pokemonSkill.skillName, 1, 0);
			ShareData.myPokemon.pokemonSkill.skillName[2] = "미습득";
			ShareData.myPokemon.pokemonSkill.skillName[3] = "미습득";
			
			// 스킬 위력
			ShareData.myPokemon.pokemonSkill.setSkillDamage (ShareData.myPokemon.pokemonSkill.skillDamage, 0, 1);
			fireSkill.setSkillDamage (ShareData.myPokemon.pokemonSkill.skillDamage, 1, 0);
			ShareData.myPokemon.pokemonSkill.skillDamage[2] = 0;
			ShareData.myPokemon.pokemonSkill.skillDamage[3] = 0;
			
			// 스킬 명중률
			ShareData.myPokemon.pokemonSkill.setSkillAccuracy (ShareData.myPokemon.pokemonSkill.skillAccuracy, 0, 0);
			fireSkill.setSkillAccuracy (ShareData.myPokemon.pokemonSkill.skillAccuracy, 1, 0);
			ShareData.myPokemon.pokemonSkill.skillAccuracy[2] = 0;
			ShareData.myPokemon.pokemonSkill.skillAccuracy[3] = 0;
			
			// 스킬 횟수
			ShareData.myPokemon.pokemonSkill.setSkillCount (ShareData.myPokemon.pokemonSkill.skillCount, 0, 0);
			fireSkill.setSkillCount (ShareData.myPokemon.pokemonSkill.skillCount, 1, 0);
			ShareData.myPokemon.pokemonSkill.skillCount[2] = 0;
			ShareData.myPokemon.pokemonSkill.skillCount[3] = 0;
			
			// 스킬 속성
			ShareData.myPokemon.pokemonSkill.setSkillType (ShareData.myPokemon.pokemonSkill.skillType, 0);
			fireSkill.setSkillType (ShareData.myPokemon.pokemonSkill.skillType, 1);
			ShareData.myPokemon.pokemonSkill.skillType[2] = 0;
			ShareData.myPokemon.pokemonSkill.skillType[3] = 0;
			
			// 스킬 사용 횟수 저장
			ShareData.myPokemon.pokemonSkill.currentSkillCount[0] = ShareData.myPokemon.pokemonSkill.skillCount[0];
			ShareData.myPokemon.pokemonSkill.currentSkillCount[1] = ShareData.myPokemon.pokemonSkill.skillCount[1];
			ShareData.myPokemon.pokemonSkill.currentSkillCount[2] = ShareData.myPokemon.pokemonSkill.skillCount[2];
			ShareData.myPokemon.pokemonSkill.currentSkillCount[3] = ShareData.myPokemon.pokemonSkill.skillCount[3];
		}
		else
		{
			// 레벨 1의 기본 능력치 설정
			ShareData.rivalPokemon.pokemonStatus[0] = 10;	// HealthPoint
			ShareData.rivalPokemon.pokemonStatus[1] = 6;		// Attack
			ShareData.rivalPokemon.pokemonStatus[2] = 5;		// Defense
			ShareData.rivalPokemon.pokemonStatus[3] = 6;		// Speed
			
			ShareData.rivalPokemon.pokemonStatus[4] = 1; 	// 포켓몬 타입(불속성)
			ShareData.rivalPokemon.pokemonStatus[5] = 10; 	// 포켓몬의 남은 체력
			
			// 파이리가 처음 익히고 있는 스킬 설정
			// 스킬명
			ShareData.rivalPokemon.pokemonSkill.setSkillName (ShareData.rivalPokemon.pokemonSkill.skillName, 0, 1);
			fireSkill.setSkillName (ShareData.rivalPokemon.pokemonSkill.skillName, 1, 0);
			ShareData.rivalPokemon.pokemonSkill.setSkillName (ShareData.rivalPokemon.pokemonSkill.skillName, 2, 1);
			fireSkill.setSkillName (ShareData.rivalPokemon.pokemonSkill.skillName, 3, 0);
			
			// 스킬 위력
			ShareData.rivalPokemon.pokemonSkill.setSkillDamage (ShareData.rivalPokemon.pokemonSkill.skillDamage, 0, 1);
			fireSkill.setSkillDamage (ShareData.rivalPokemon.pokemonSkill.skillDamage, 1, 0);
			ShareData.rivalPokemon.pokemonSkill.setSkillDamage (ShareData.rivalPokemon.pokemonSkill.skillDamage, 2, 1);
			fireSkill.setSkillDamage (ShareData.rivalPokemon.pokemonSkill.skillDamage, 3, 0);
			
			// 스킬 명중률
			ShareData.rivalPokemon.pokemonSkill.setSkillAccuracy (ShareData.rivalPokemon.pokemonSkill.skillAccuracy, 0, 1);
			fireSkill.setSkillAccuracy (ShareData.rivalPokemon.pokemonSkill.skillAccuracy, 1, 0);
			ShareData.rivalPokemon.pokemonSkill.setSkillAccuracy (ShareData.rivalPokemon.pokemonSkill.skillAccuracy, 2, 1);
			fireSkill.setSkillAccuracy (ShareData.rivalPokemon.pokemonSkill.skillAccuracy, 3, 0);
			
			// 스킬 횟수
			ShareData.rivalPokemon.pokemonSkill.setSkillCount (ShareData.rivalPokemon.pokemonSkill.skillCount, 0, 1);
			fireSkill.setSkillCount (ShareData.rivalPokemon.pokemonSkill.skillCount, 1, 0);
			ShareData.rivalPokemon.pokemonSkill.setSkillCount (ShareData.rivalPokemon.pokemonSkill.skillCount, 2, 1);
			fireSkill.setSkillCount (ShareData.rivalPokemon.pokemonSkill.skillCount, 3, 0);
			
			// 스킬 속성
			ShareData.rivalPokemon.pokemonSkill.setSkillType (ShareData.rivalPokemon.pokemonSkill.skillType, 0);
			fireSkill.setSkillType (ShareData.rivalPokemon.pokemonSkill.skillType, 1);
			ShareData.rivalPokemon.pokemonSkill.setSkillType (ShareData.rivalPokemon.pokemonSkill.skillType, 2);
			fireSkill.setSkillType (ShareData.rivalPokemon.pokemonSkill.skillType, 3);
			
			// 스킬 사용 횟수 저장
			ShareData.rivalPokemon.pokemonSkill.currentSkillCount[0] = ShareData.rivalPokemon.pokemonSkill.skillCount[0];
			ShareData.rivalPokemon.pokemonSkill.currentSkillCount[1] = ShareData.rivalPokemon.pokemonSkill.skillCount[1];
			ShareData.rivalPokemon.pokemonSkill.currentSkillCount[2] = ShareData.rivalPokemon.pokemonSkill.skillCount[2];
			ShareData.rivalPokemon.pokemonSkill.currentSkillCount[3] = ShareData.rivalPokemon.pokemonSkill.skillCount[3];
		}
	}
	
	/**************************************************
	 
	evolutionPokemon
	입력: 내 포켓몬의 정보
	출력: 내 포켓몬의 정보
	
	일정 레벨에 달성하면 진화한다.
	파이리 -> 리자드 -> 리자몽

	**************************************************/
	void evolutionPokemon (boolean isMyPokemon)
	{
		int level = 0;
		
		if (isMyPokemon == true)
		{
			level = ShareData.myPokemon.pokemonLevel;
		}
		else
		{
			level = ShareData.pokemon.pokemonLevel;
		}
		
		switch (level)
		{
			case 16: // 레벨이 16이 되면 리자드로 진화
				if (isMyPokemon == true)
				{
					ShareData.myPokemon.pokemonName = "리자드";
					// 진화로 인해 기본 능력치 상승
					ShareData.myPokemon.pokemonStatus[0] += 10;	// HealthPoint
					ShareData.myPokemon.pokemonStatus[1] += 6;	// Attack
					ShareData.myPokemon.pokemonStatus[2] += 5;	// Defense
					ShareData.myPokemon.pokemonStatus[3] += 6;	// Speed

					ShareData.myPokemon.pokemonStatus[5] += 10; 	// 포켓몬의 남은 체력
					
					System.out.printf("파이리가 리자드로 진화했다.!!\n\n");
				}
				else
				{
					ShareData.rivalPokemon.pokemonName = "리자드";
					// 진화로 인해 기본 능력치 상승
					ShareData.rivalPokemon.pokemonStatus[0] += 10;		// HealthPoint
					ShareData.rivalPokemon.pokemonStatus[1] += 6;		// Attack
					ShareData.rivalPokemon.pokemonStatus[2] += 5;		// Defense
					ShareData.rivalPokemon.pokemonStatus[3] += 6;		// Speed

					ShareData.rivalPokemon.pokemonStatus[5] += 10; 		// 포켓몬의 남은 체력
				}

				break;
			case 36: // 레벨이 36이 되면 리자몽으로 진화
				if (isMyPokemon == true)
				{
					ShareData.myPokemon.pokemonName = "리자몽";
					// 진화로 인해 기본 능력치 상승
					ShareData.myPokemon.pokemonStatus[0] += 12;	// HealthPoint
					ShareData.myPokemon.pokemonStatus[1] += 10;	// Attack
					ShareData.myPokemon.pokemonStatus[2] += 8;	// Defense
					ShareData.myPokemon.pokemonStatus[3] += 8;	// Speed

					ShareData.myPokemon.pokemonStatus[5] += 12; 	// 포켓몬의 남은 체력
					
					System.out.printf("리자드가 리자몽으로 진화했다.!!\n\n");
				}
				else
				{
					ShareData.rivalPokemon.pokemonName = "리자몽";
					// 진화로 인해 기본 능력치 상승
					ShareData.rivalPokemon.pokemonStatus[0] += 12;		// HealthPoint
					ShareData.rivalPokemon.pokemonStatus[1] += 10;		// Attack
					ShareData.rivalPokemon.pokemonStatus[2] += 8;		// Defense
					ShareData.rivalPokemon.pokemonStatus[3] += 8;		// Speed

					ShareData.rivalPokemon.pokemonStatus[5] += 12; 		// 포켓몬의 남은 체력
				}
				
				break;
			default:
				break;
		}
	}
}



//End of File
