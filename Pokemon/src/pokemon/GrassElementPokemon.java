/**************************************************
 
풀속성 포켓몬 클래스

**************************************************/

package pokemon;

import java.util.Random;

//풀속성 포켓몬
//풀속성 포켓몬 클래스가 포켓몬 클래스에 상속을 요청
class GrassElementPokemon extends Pokemon
{
	// 풀속성 스킬 클래스
	GlassSkill glassSkill = new GlassSkill();
	// 풀속성 포켓몬은 마비를 걸 수 있다.
	boolean paralysisStatus = false;
	
	/**************************************************
	 
	makeParalysisStatus
	입력: 0 ~ 99 까지 랜덤 숫자
	출력: 마비 상태
	
	풀속성 공격을 하면 20%의 확률로 마비가 걸린다.

	**************************************************/
	boolean makeParalysisStatus ()
	{
		// 랜덤숫자를 얻기 위한 랜덤 클래스
		Random random = new Random();
		int randomNumber = -1; // 랜덤 번호를 저장
		
		// 랜덤 번호를 얻어서 값이 20보다 작으면 마비 상태가 된다.
		randomNumber = random.nextInt(100);
		
		if (randomNumber >= 20)
		{
			paralysisStatus = false;
		}
		else
		{
			paralysisStatus = true;
		}
		
		return paralysisStatus;
	}
	
	/**************************************************
	 
	learnNewSkill
	입력: 내 포켓몬 정보
	출력: 새로운 스킬을 익힌 내 포켓몬 정보
	
	일정 레벨이 되면  새로운 풀속성 스킬을 익힌다.

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
				// 잎날가르기를 익힌다.
				if (isMyPokemon == true)
				{
					glassSkill.setSkillName (ShareData.myPokemon.pokemonSkill.skillName, 2, 1);
					glassSkill.setSkillDamage (ShareData.myPokemon.pokemonSkill.skillDamage, 2, 1);
					glassSkill.setSkillAccuracy (ShareData.myPokemon.pokemonSkill.skillAccuracy, 2, 1);
					glassSkill.setSkillCount (ShareData.myPokemon.pokemonSkill.skillCount, 2, 1);
					glassSkill.setSkillType (ShareData.myPokemon.pokemonSkill.skillType, 2);
					System.out.printf("새로운 스킬 %s을(를) 익혔다! \n\n", ShareData.myPokemon.pokemonSkill.skillName[2]);
				}
				else
				{
					glassSkill.setSkillName (ShareData.rivalPokemon.pokemonSkill.skillName, 3, 1);
					glassSkill.setSkillDamage (ShareData.rivalPokemon.pokemonSkill.skillDamage, 3, 1);
					glassSkill.setSkillAccuracy (ShareData.rivalPokemon.pokemonSkill.skillAccuracy, 3, 1);
					glassSkill.setSkillCount (ShareData.rivalPokemon.pokemonSkill.skillCount, 3, 1);
					glassSkill.setSkillType (ShareData.rivalPokemon.pokemonSkill.skillType, 3);
				}

				break;
			case 20: // 레벨 20
				// 씨폭탄을 익힌다.
				if (isMyPokemon == true)
				{
					glassSkill.setSkillName (ShareData.myPokemon.pokemonSkill.skillName, 3, 2);
					glassSkill.setSkillDamage (ShareData.myPokemon.pokemonSkill.skillDamage, 3, 2);
					glassSkill.setSkillAccuracy (ShareData.myPokemon.pokemonSkill.skillAccuracy, 3, 2);
					glassSkill.setSkillCount (ShareData.myPokemon.pokemonSkill.skillCount, 3, 2);
					glassSkill.setSkillType (ShareData.myPokemon.pokemonSkill.skillType, 3);
					System.out.printf("새로운 스킬 %s을(를) 익혔다! \n\n", ShareData.myPokemon.pokemonSkill.skillName[3]);
				}
				else
				{
					glassSkill.setSkillName (ShareData.rivalPokemon.pokemonSkill.skillName, 1, 2);
					glassSkill.setSkillDamage (ShareData.rivalPokemon.pokemonSkill.skillDamage, 1, 2);
					glassSkill.setSkillAccuracy (ShareData.rivalPokemon.pokemonSkill.skillAccuracy, 1, 2);
					glassSkill.setSkillCount (ShareData.rivalPokemon.pokemonSkill.skillCount, 1, 2);
					glassSkill.setSkillType (ShareData.rivalPokemon.pokemonSkill.skillType, 1);
				}

				break;
			case 30: // 레벨 30
				// 리프스톰을 익힌다.
				if (isMyPokemon == true)
				{
					glassSkill.setSkillName (ShareData.myPokemon.pokemonSkill.skillName, 2, 3);
					glassSkill.setSkillDamage (ShareData.myPokemon.pokemonSkill.skillDamage, 2, 3);
					glassSkill.setSkillAccuracy (ShareData.myPokemon.pokemonSkill.skillAccuracy, 2, 3);
					glassSkill.setSkillCount (ShareData.myPokemon.pokemonSkill.skillCount, 2, 3);
					glassSkill.setSkillType (ShareData.myPokemon.pokemonSkill.skillType, 2);
					System.out.printf("새로운 스킬 %s을(를) 익혔다! \n\n", ShareData.myPokemon.pokemonSkill.skillName[2]);
				}
				else
				{
					glassSkill.setSkillName (ShareData.rivalPokemon.pokemonSkill.skillName, 2, 3);
					glassSkill.setSkillDamage (ShareData.rivalPokemon.pokemonSkill.skillDamage, 2, 3);
					glassSkill.setSkillAccuracy (ShareData.rivalPokemon.pokemonSkill.skillAccuracy, 2, 3);
					glassSkill.setSkillCount (ShareData.rivalPokemon.pokemonSkill.skillCount, 2, 3);
					glassSkill.setSkillType (ShareData.rivalPokemon.pokemonSkill.skillType, 2);
				}

				break;
			case 40: // 레벨 40
				// 솔라빔을 익힌다.
				if (isMyPokemon == true)
				{
					glassSkill.setSkillName (ShareData.myPokemon.pokemonSkill.skillName, 3, 4);
					glassSkill.setSkillDamage (ShareData.myPokemon.pokemonSkill.skillDamage, 3, 4);
					glassSkill.setSkillAccuracy (ShareData.myPokemon.pokemonSkill.skillAccuracy, 3, 4);
					glassSkill.setSkillCount (ShareData.myPokemon.pokemonSkill.skillCount, 3, 4);
					glassSkill.setSkillType (ShareData.myPokemon.pokemonSkill.skillType, 3);
					System.out.printf("새로운 스킬 %s을(를) 익혔다! \n\n", ShareData.myPokemon.pokemonSkill.skillName[3]);
				}
				else
				{
					glassSkill.setSkillName (ShareData.rivalPokemon.pokemonSkill.skillName, 3, 4);
					glassSkill.setSkillDamage (ShareData.rivalPokemon.pokemonSkill.skillDamage, 3, 4);
					glassSkill.setSkillAccuracy (ShareData.rivalPokemon.pokemonSkill.skillAccuracy, 3, 4);
					glassSkill.setSkillCount (ShareData.rivalPokemon.pokemonSkill.skillCount, 3, 4);
					glassSkill.setSkillType (ShareData.rivalPokemon.pokemonSkill.skillType, 3);
				}

				break;
			default:
				break;
		}
	}
}

//2차 상속을 받은 풀속성 포켓몬인 이상해씨
//Bulbasaur: 이상해씨의 영문명
class Bulbasaur extends GrassElementPokemon
{
	/**************************************************
	 
	setBasicPokemonStatus
	입력: 정보가 없는 내 포켓몬 정보
	출력: 이상해씨 정보를 저장한 내 포켓몬의 정보
	
	이상해씨를 선택하고 초기 능력치를 설정한다.

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
			
			ShareData.myPokemon.pokemonStatus[4] = 2; 		// 포켓몬 타입(풀속성)
			ShareData.myPokemon.pokemonStatus[5] = 10; 		// 포켓몬의 남은 체력
			
			// 파이리가 처음 익히고 있는 스킬 설정
			// 스킬명
			ShareData.myPokemon.pokemonSkill.setSkillName (ShareData.myPokemon.pokemonSkill.skillName, 0, 1);
			glassSkill.setSkillName (ShareData.myPokemon.pokemonSkill.skillName, 1, 0);
			ShareData.myPokemon.pokemonSkill.skillName[2] = "미습득";
			ShareData.myPokemon.pokemonSkill.skillName[3] = "미습득";
			
			// 스킬 위력
			ShareData.myPokemon.pokemonSkill.setSkillDamage (ShareData.myPokemon.pokemonSkill.skillDamage, 0, 1);
			glassSkill.setSkillDamage (ShareData.myPokemon.pokemonSkill.skillDamage, 1, 0);
			ShareData.myPokemon.pokemonSkill.skillDamage[2] = 0;
			ShareData.myPokemon.pokemonSkill.skillDamage[3] = 0;
			
			// 스킬 명중률
			ShareData.myPokemon.pokemonSkill.setSkillAccuracy (ShareData.myPokemon.pokemonSkill.skillAccuracy, 0, 0);
			glassSkill.setSkillAccuracy (ShareData.myPokemon.pokemonSkill.skillAccuracy, 1, 0);
			ShareData.myPokemon.pokemonSkill.skillAccuracy[2] = 0;
			ShareData.myPokemon.pokemonSkill.skillAccuracy[3] = 0;
			
			// 스킬 횟수
			ShareData.myPokemon.pokemonSkill.setSkillCount (ShareData.myPokemon.pokemonSkill.skillCount, 0, 0);
			glassSkill.setSkillCount (ShareData.myPokemon.pokemonSkill.skillCount, 1, 0);
			ShareData.myPokemon.pokemonSkill.skillCount[2] = 0;
			ShareData.myPokemon.pokemonSkill.skillCount[3] = 0;
			
			// 스킬 속성
			ShareData.myPokemon.pokemonSkill.setSkillType (ShareData.myPokemon.pokemonSkill.skillType, 0);
			glassSkill.setSkillType (ShareData.myPokemon.pokemonSkill.skillType, 1);
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
			
			ShareData.rivalPokemon.pokemonStatus[4] = 2; 	// 포켓몬 타입(풀속성)
			ShareData.rivalPokemon.pokemonStatus[5] = 10; 	// 포켓몬의 남은 체력
			
			// 파이리가 처음 익히고 있는 스킬 설정
			// 스킬명
			ShareData.rivalPokemon.pokemonSkill.setSkillName (ShareData.rivalPokemon.pokemonSkill.skillName, 0, 1);
			glassSkill.setSkillName (ShareData.rivalPokemon.pokemonSkill.skillName, 1, 0);
			ShareData.rivalPokemon.pokemonSkill.setSkillName (ShareData.rivalPokemon.pokemonSkill.skillName, 2, 1);
			glassSkill.setSkillName (ShareData.rivalPokemon.pokemonSkill.skillName, 3, 0);
			
			// 스킬 위력
			ShareData.rivalPokemon.pokemonSkill.setSkillDamage (ShareData.rivalPokemon.pokemonSkill.skillDamage, 0, 1);
			glassSkill.setSkillDamage (ShareData.rivalPokemon.pokemonSkill.skillDamage, 1, 0);
			ShareData.rivalPokemon.pokemonSkill.setSkillDamage (ShareData.rivalPokemon.pokemonSkill.skillDamage, 2, 1);
			glassSkill.setSkillDamage (ShareData.rivalPokemon.pokemonSkill.skillDamage, 3, 0);
			
			// 스킬 명중률
			ShareData.rivalPokemon.pokemonSkill.setSkillAccuracy (ShareData.rivalPokemon.pokemonSkill.skillAccuracy, 0, 1);
			glassSkill.setSkillAccuracy (ShareData.rivalPokemon.pokemonSkill.skillAccuracy, 1, 0);
			ShareData.rivalPokemon.pokemonSkill.setSkillAccuracy (ShareData.rivalPokemon.pokemonSkill.skillAccuracy, 2, 1);
			glassSkill.setSkillAccuracy (ShareData.rivalPokemon.pokemonSkill.skillAccuracy, 3, 0);
			
			// 스킬 횟수
			ShareData.rivalPokemon.pokemonSkill.setSkillCount (ShareData.rivalPokemon.pokemonSkill.skillCount, 0, 1);
			glassSkill.setSkillCount (ShareData.rivalPokemon.pokemonSkill.skillCount, 1, 0);
			ShareData.rivalPokemon.pokemonSkill.setSkillCount (ShareData.rivalPokemon.pokemonSkill.skillCount, 2, 1);
			glassSkill.setSkillCount (ShareData.rivalPokemon.pokemonSkill.skillCount, 3, 0);
			
			// 스킬 속성
			ShareData.rivalPokemon.pokemonSkill.setSkillType (ShareData.rivalPokemon.pokemonSkill.skillType, 0);
			glassSkill.setSkillType (ShareData.rivalPokemon.pokemonSkill.skillType, 1);
			ShareData.rivalPokemon.pokemonSkill.setSkillType (ShareData.rivalPokemon.pokemonSkill.skillType, 2);
			glassSkill.setSkillType (ShareData.rivalPokemon.pokemonSkill.skillType, 3);
			
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
	이상해씨 -> 이상해풀 -> 이상해꽃

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
			level = ShareData.rivalPokemon.pokemonLevel;
		}
		
		switch (level)
		{
			case 16: // 레벨이 16이 되면 이상해풀로 진화
				if (isMyPokemon == true)
				{
					ShareData.myPokemon.pokemonName = "이상해풀";
					// 진화로 인해 기본 능력치 상승
					ShareData.myPokemon.pokemonStatus[0] += 11;	// HealthPoint
					ShareData.myPokemon.pokemonStatus[1] += 5;	// Attack
					ShareData.myPokemon.pokemonStatus[2] += 6;	// Defense
					ShareData.myPokemon.pokemonStatus[3] += 5;	// Speed

					ShareData.myPokemon.pokemonStatus[5] += 11; 	// 포켓몬의 남은 체력
					
					System.out.printf("이상해씨가 이상해풀로 진화했다.!!\n\n");
				}
				else
				{
					ShareData.rivalPokemon.pokemonName = "이상해풀";
					// 진화로 인해 기본 능력치 상승
					ShareData.rivalPokemon.pokemonStatus[0] += 11;	// HealthPoint
					ShareData.rivalPokemon.pokemonStatus[1] += 5;		// Attack
					ShareData.rivalPokemon.pokemonStatus[2] += 6;		// Defense
					ShareData.rivalPokemon.pokemonStatus[3] += 5;		// Speed

					ShareData.rivalPokemon.pokemonStatus[5] += 12; 	// 포켓몬의 남은 체력
				}

				break;
			case 36: // 레벨이 36이 되면 이상해꽃으로 진화
				if (isMyPokemon == true)
				{
					ShareData.myPokemon.pokemonName = "이상해꽃";
					// 진화로 인해 기본 능력치 상승
					ShareData.myPokemon.pokemonStatus[0] += 15;	// HealthPoint
					ShareData.myPokemon.pokemonStatus[1] += 7;	// Attack
					ShareData.myPokemon.pokemonStatus[2] += 10;	// Defense
					ShareData.myPokemon.pokemonStatus[3] += 6;	// Speed

					ShareData.myPokemon.pokemonStatus[5] += 15; 	// 포켓몬의 남은 체력
					
					System.out.printf("이상해풀이 이상해꽃으로 진화했다.!!\n\n");
				}
				else
				{
					ShareData.rivalPokemon.pokemonName = "이상해꽃";
					// 진화로 인해 기본 능력치 상승
					ShareData.rivalPokemon.pokemonStatus[0] += 15;	// HealthPoint
					ShareData.rivalPokemon.pokemonStatus[1] += 7;		// Attack
					ShareData.rivalPokemon.pokemonStatus[2] += 10;	// Defense
					ShareData.rivalPokemon.pokemonStatus[3] += 6;		// Speed

					ShareData.rivalPokemon.pokemonStatus[5] += 15; 	// 포켓몬의 남은 체력
				}

				break;
			default:
				break;
		}
	}
}

//End of File
