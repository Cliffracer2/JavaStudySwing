/**************************************************
 
적 포켓몬 클래스

**************************************************/

package pokemon;

import java.util.Random;

public class EnemyPokemon extends Pokemon
{	
	int giveExp; 					// 적 포켓몬이 지면 주는 경험치 량
	boolean rivalPokemon = false;	// 적 포켓몬이 라이벌 포켓몬인가
	
	/**************************************************
	 
	appearWildPokemon
	입력: 적 포켓몬의 정보, 나의 포켓몬 레벨
	출력: 적 야생 포켓몬의 정보
	
	야생 포켓몬의 출현을 알려준다.
	플레이어의 레벨에 따라서 출현하는 포켓몬 종류와 레벨이 달라진다.

	**************************************************/
	public void appearWildPokemon (EnemyPokemon enemyPokemon, int pokemonLevel)
	{
		// 적 포켓몬 클래스를 상속받은 야생 포켓몬 클래스
		WildPokemon wildPokemon = new WildPokemon();
		// 랜덤숫자를 얻기 위한 랜덤 클래스
		Random random = new Random();
		int randomNumber = -1;	// 스킬 번호 선택
		
		// 적 포켓몬을 랜덤으로 스폰하기 위한 번호 값
		randomNumber = random.nextInt(2);
		
		// 플레이어 포켓몬 레벨이 1 ~ 10이면 꼬렛, 구구가 출현
		if (pokemonLevel <= 10)
		{
			// 랜덤 값이 0이 나오면 꼬렛 출현
			if (randomNumber == 0)
			{
				wildPokemon.getRattataInfo (enemyPokemon, pokemonLevel);
			}
			else // 랜덤 값이 1이면 구구 출현
			{
				wildPokemon.getPidgeyInfo (enemyPokemon, pokemonLevel);
			}
		}
		// 플레이어 포켓몬 레벨이 10 ~ 20이면 이브이, 파오리 출현
		else if ((pokemonLevel >= 11) && (pokemonLevel <= 20))
		{
			// 랜덤 값이 0이 나오면 이브이 출현
			if (randomNumber == 0)
			{
				wildPokemon.getEeveeInfo (enemyPokemon, pokemonLevel);
			}
			else // 랜덤 값이 1이면 파오리 출현
			{
				wildPokemon.getFarfetchInfo (enemyPokemon, pokemonLevel);
			}
		}
		// 플레이어 포켓몬 레벨이 20 ~ 30이면 럭키, 레트라 출현
		else if ((pokemonLevel >= 21) && (pokemonLevel <= 30))
		{
			// 랜덤 값이 0이 나오면 럭키 출현
			if (randomNumber == 0)
			{
				wildPokemon.getChanseyInfo (enemyPokemon, pokemonLevel);
			}
			else // 랜덤 값이 1이면 레트라 출현
			{
				wildPokemon.getRaticateInfo (enemyPokemon, pokemonLevel);
			}
		}
		// 레벨 30이상이면 캥카, 잠만보 출현
		else
		{
			// 랜덤 값이 0이 나오면 캥카 출현
			if (randomNumber == 0)
			{
				wildPokemon.getSnorlaxInfo (enemyPokemon, pokemonLevel);
			}
			else // 랜덤 값이 1이면 잠만보 출현
			{
				wildPokemon.getKangaskhanInfo (enemyPokemon, pokemonLevel);
			}
		}
		
		System.out.printf("야생의 %s이(가) 나타났다!\n", enemyPokemon.pokemonName);
		
		// 현재 스킬 횟수 저장
		enemyPokemon.pokemonSkill.currentSkillCount[0] = enemyPokemon.pokemonSkill.skillCount[0];
		enemyPokemon.pokemonSkill.currentSkillCount[1] = enemyPokemon.pokemonSkill.skillCount[1];
		enemyPokemon.pokemonSkill.currentSkillCount[2] = enemyPokemon.pokemonSkill.skillCount[2];
		enemyPokemon.pokemonSkill.currentSkillCount[3] = enemyPokemon.pokemonSkill.skillCount[3];
		
		// 상태이상 정보
		enemyPokemon.pokemonCondition = "정상";
	}
	
	/**************************************************
	 
	bringRivalPokemon
	입력: 라이벌 포켓몬 정보, 적 포켓몬의 정보
	출력: 적 포켓몬의 정보에 담긴 라이벌 포켓몬 정보
	
	라이벌 포켓몬과 배틀을 하기 위해
	라이벌 포켓몬의 정보를 가져와서 적 포켓몬 정보에 저장한다.

	**************************************************/
	public void bringRivalPokemon (RivalPokemon rivalPokemon, EnemyPokemon enemyPokemon)
	{
		pokemonSkill.setSkill();
		
		enemyPokemon.rivalPokemon = true;
		enemyPokemon.pokemonLevel = rivalPokemon.pokemonLevel;
		enemyPokemon.pokemonName = rivalPokemon.pokemonName;
		enemyPokemon.pokemonCondition = rivalPokemon.pokemonCondition;
		
		enemyPokemon.pokemonStatus[0] = rivalPokemon.pokemonStatus[0];	// HealthPoint
		enemyPokemon.pokemonStatus[1] = rivalPokemon.pokemonStatus[1];	// Attack
		enemyPokemon.pokemonStatus[2] = rivalPokemon.pokemonStatus[2];	// Defense
		enemyPokemon.pokemonStatus[3] = rivalPokemon.pokemonStatus[3];	// Speed
		
		enemyPokemon.pokemonStatus[4] = rivalPokemon.pokemonStatus[4]; 	// 포켓몬 타입
		enemyPokemon.pokemonStatus[5] = rivalPokemon.pokemonStatus[5];	// 현재 HP
		
		enemyPokemon.giveExp = 100 + (rivalPokemon.pokemonLevel * 2);
		
		
		
		// 잠만보의 스킬 설정
		// 1. 메가톤펀치    2. 괴력   3. 누르기   4. 기가임팩트
		// 스킬명
		enemyPokemon.pokemonSkill.skillName[0] = rivalPokemon.pokemonSkill.skillName[0];
		enemyPokemon.pokemonSkill.skillName[1] = rivalPokemon.pokemonSkill.skillName[1];
		enemyPokemon.pokemonSkill.skillName[2] = rivalPokemon.pokemonSkill.skillName[2];
		enemyPokemon.pokemonSkill.skillName[3] = rivalPokemon.pokemonSkill.skillName[3];
		
		// 스킬 위력
		enemyPokemon.pokemonSkill.skillDamage[0] = rivalPokemon.pokemonSkill.skillDamage[0];
		enemyPokemon.pokemonSkill.skillDamage[1] = rivalPokemon.pokemonSkill.skillDamage[1];
		enemyPokemon.pokemonSkill.skillDamage[2] = rivalPokemon.pokemonSkill.skillDamage[2];
		enemyPokemon.pokemonSkill.skillDamage[3] = rivalPokemon.pokemonSkill.skillDamage[3];
		
		// 스킬 명중률
		enemyPokemon.pokemonSkill.skillAccuracy[0] = rivalPokemon.pokemonSkill.skillAccuracy[0];
		enemyPokemon.pokemonSkill.skillAccuracy[1] = rivalPokemon.pokemonSkill.skillAccuracy[1];
		enemyPokemon.pokemonSkill.skillAccuracy[2] = rivalPokemon.pokemonSkill.skillAccuracy[2];
		enemyPokemon.pokemonSkill.skillAccuracy[3] = rivalPokemon.pokemonSkill.skillAccuracy[3];
		
		// 스킬 횟수
		enemyPokemon.pokemonSkill.skillCount[0] = rivalPokemon.pokemonSkill.skillCount[0];
		enemyPokemon.pokemonSkill.skillCount[1] = rivalPokemon.pokemonSkill.skillCount[1];
		enemyPokemon.pokemonSkill.skillCount[2] = rivalPokemon.pokemonSkill.skillCount[2];
		enemyPokemon.pokemonSkill.skillCount[3] = rivalPokemon.pokemonSkill.skillCount[3];
		
		// 스킬 속성
		enemyPokemon.pokemonSkill.skillType[0] = rivalPokemon.pokemonSkill.skillType[0];
		enemyPokemon.pokemonSkill.skillType[1] = rivalPokemon.pokemonSkill.skillType[1];
		enemyPokemon.pokemonSkill.skillType[2] = rivalPokemon.pokemonSkill.skillType[2];
		enemyPokemon.pokemonSkill.skillType[3] = rivalPokemon.pokemonSkill.skillType[3];
	}
	
	/**************************************************
	 
	bringRivalPokemon
	입력: 라이벌 포켓몬 정보, 스레드에서 동작한 라이벌 상승 능력치
	출력: 적 포켓몬의 정보에 담긴 라이벌 포켓몬 정보
	
	라이벌 포켓몬과 배틀을 하기 위해
	라이벌 포켓몬의 정보를 가져와서 적 포켓몬 정보에 저장한다.

	**************************************************/
	public void bringRivalPokemon (RivalPokemon rivalPokemon)
	{
		pokemonSkill.setSkill();

		rivalPokemon.pokemonName = ShareData.pokemon.pokemonName;
		rivalPokemon.pokemonLevel = ShareData.pokemon.pokemonLevel;
		
		rivalPokemon.pokemonStatus[0] = ShareData.pokemon.pokemonStatus[0];	// HealthPoint
		rivalPokemon.pokemonStatus[1] = ShareData.pokemon.pokemonStatus[1];	// Attack
		rivalPokemon.pokemonStatus[2] = ShareData.pokemon.pokemonStatus[2];	// Defense
		rivalPokemon.pokemonStatus[3] = ShareData.pokemon.pokemonStatus[3];	// Speed
		
		rivalPokemon.pokemonStatus[4] = ShareData.pokemon.pokemonStatus[4]; 	// 포켓몬 타입
		rivalPokemon.pokemonStatus[5] = ShareData.pokemon.pokemonStatus[5];	// 현재 HP
		
		rivalPokemon.giveExp = 100 + (ShareData.pokemon.pokemonLevel * 2);
		
		
		
		// 잠만보의 스킬 설정
		// 1. 메가톤펀치    2. 괴력   3. 누르기   4. 기가임팩트
		// 스킬명
		rivalPokemon.pokemonSkill.skillName[0] = ShareData.pokemon.pokemonSkill.skillName[0];
		rivalPokemon.pokemonSkill.skillName[1] = ShareData.pokemon.pokemonSkill.skillName[1];
		rivalPokemon.pokemonSkill.skillName[2] = ShareData.pokemon.pokemonSkill.skillName[2];
		rivalPokemon.pokemonSkill.skillName[3] = ShareData.pokemon.pokemonSkill.skillName[3];
		
		// 스킬 위력
		rivalPokemon.pokemonSkill.skillDamage[0] = ShareData.pokemon.pokemonSkill.skillDamage[0];
		rivalPokemon.pokemonSkill.skillDamage[1] = ShareData.pokemon.pokemonSkill.skillDamage[1];
		rivalPokemon.pokemonSkill.skillDamage[2] = ShareData.pokemon.pokemonSkill.skillDamage[2];
		rivalPokemon.pokemonSkill.skillDamage[3] = ShareData.pokemon.pokemonSkill.skillDamage[3];
		
		// 스킬 명중률
		rivalPokemon.pokemonSkill.skillAccuracy[0] = ShareData.pokemon.pokemonSkill.skillAccuracy[0];
		rivalPokemon.pokemonSkill.skillAccuracy[1] = ShareData.pokemon.pokemonSkill.skillAccuracy[1];
		rivalPokemon.pokemonSkill.skillAccuracy[2] = ShareData.pokemon.pokemonSkill.skillAccuracy[2];
		rivalPokemon.pokemonSkill.skillAccuracy[3] = ShareData.pokemon.pokemonSkill.skillAccuracy[3];
		
		// 스킬 횟수
		rivalPokemon.pokemonSkill.skillCount[0] = ShareData.pokemon.pokemonSkill.skillCount[0];
		rivalPokemon.pokemonSkill.skillCount[1] = ShareData.pokemon.pokemonSkill.skillCount[1];
		rivalPokemon.pokemonSkill.skillCount[2] = ShareData.pokemon.pokemonSkill.skillCount[2];
		rivalPokemon.pokemonSkill.skillCount[3] = ShareData.pokemon.pokemonSkill.skillCount[3];
		
		rivalPokemon.pokemonSkill.currentSkillCount[0] = ShareData.pokemon.pokemonSkill.currentSkillCount[0];
		rivalPokemon.pokemonSkill.currentSkillCount[1] = ShareData.pokemon.pokemonSkill.currentSkillCount[1];
		rivalPokemon.pokemonSkill.currentSkillCount[2] = ShareData.pokemon.pokemonSkill.currentSkillCount[2];
		rivalPokemon.pokemonSkill.currentSkillCount[3] = ShareData.pokemon.pokemonSkill.currentSkillCount[3];
		
		// 스킬 속성
		rivalPokemon.pokemonSkill.skillType[0] = ShareData.pokemon.pokemonSkill.skillType[0];
		rivalPokemon.pokemonSkill.skillType[1] = ShareData.pokemon.pokemonSkill.skillType[1];
		rivalPokemon.pokemonSkill.skillType[2] = ShareData.pokemon.pokemonSkill.skillType[2];
		rivalPokemon.pokemonSkill.skillType[3] = ShareData.pokemon.pokemonSkill.skillType[3];
	}
	
}

//야생 포켓몬 클래스
class WildPokemon extends EnemyPokemon
{
	// 랜덤 값을 얻기 위한 변수 선언
	Random randomLevel = new Random();
	int calculateLevel = 1;
	
	/**************************************************
	 
	getRattataInfo
	입력: 적 포켓몬 정보, 자신의 포켓몬 레벨
	출력: 꼬렛 정보가 저장된 적 포켓몬의 정보
	
	Rattata: 꼬렛의 영문명
	야생의 꼬렛의 정보를 얻는다.

	**************************************************/
	public void getRattataInfo (EnemyPokemon enemyPokemon, int level)
	{	
		pokemonSkill.setSkill();
		
		// 야생 포켓몬의 레벨을 계산
		calculateLevel = randomLevel.nextInt(level) + 1;
		enemyPokemon.pokemonLevel = calculateLevel;
		enemyPokemon.pokemonName = "꼬렛";
				
		// 1 ~ 5사이의 레벨
		if (level == 1)
		{
			// 레벨 1의 기본 능력치 설정
			enemyPokemon.pokemonStatus[0] = 7;	// HealthPoint
			enemyPokemon.pokemonStatus[1] = 4;	// Attack
			enemyPokemon.pokemonStatus[2] = 3;	// Defense
			enemyPokemon.pokemonStatus[3] = 4;	// Speed
			
			enemyPokemon.pokemonStatus[4] = 0; 	// 포켓몬 타입(무속성)
			enemyPokemon.pokemonStatus[5] = 7; 	// 포켓몬의 현재 체력
			
			enemyPokemon.giveExp = 6;
		}
		else
		{
			enemyPokemon.pokemonStatus[0] = 7 + calculateLevel;
			enemyPokemon.pokemonStatus[1] = 4 + calculateLevel;
			enemyPokemon.pokemonStatus[2] = 3 + calculateLevel;
			enemyPokemon.pokemonStatus[3] = 4 + calculateLevel;
			
			enemyPokemon.pokemonStatus[4] = 0; 	// 포켓몬 타입(무속성)
			enemyPokemon.pokemonStatus[5] = 7 + calculateLevel;
			
			enemyPokemon.giveExp = 6 + (calculateLevel * 2);
		}
		
		// 꼬렛의 스킬 설정
		// 스킬명
		enemyPokemon.pokemonSkill.skillName[0] = pokemonSkill.skillNameList.get(0);
		enemyPokemon.pokemonSkill.skillName[1] = pokemonSkill.skillNameList.get(1);
		enemyPokemon.pokemonSkill.skillName[2] = pokemonSkill.skillNameList.get(0);
		enemyPokemon.pokemonSkill.skillName[3] = pokemonSkill.skillNameList.get(1);
		
		// 스킬 위력
		enemyPokemon.pokemonSkill.skillDamage[0] = pokemonSkill.skillDamageList.get(0);
		enemyPokemon.pokemonSkill.skillDamage[1] = pokemonSkill.skillDamageList.get(1);
		enemyPokemon.pokemonSkill.skillDamage[2] = pokemonSkill.skillDamageList.get(0);
		enemyPokemon.pokemonSkill.skillDamage[3] = pokemonSkill.skillDamageList.get(1);
		
		// 스킬 명중률
		enemyPokemon.pokemonSkill.skillAccuracy[0] = pokemonSkill.skillAccuracyList.get(0);
		enemyPokemon.pokemonSkill.skillAccuracy[1] = pokemonSkill.skillAccuracyList.get(1);
		enemyPokemon.pokemonSkill.skillAccuracy[2] = pokemonSkill.skillAccuracyList.get(0);
		enemyPokemon.pokemonSkill.skillAccuracy[3] = pokemonSkill.skillAccuracyList.get(1);
		
		// 스킬 횟수
		enemyPokemon.pokemonSkill.skillCount[0] = pokemonSkill.skillCountList.get(0);
		enemyPokemon.pokemonSkill.skillCount[1] = pokemonSkill.skillCountList.get(1);
		enemyPokemon.pokemonSkill.skillCount[2] = pokemonSkill.skillCountList.get(0);
		enemyPokemon.pokemonSkill.skillCount[3] = pokemonSkill.skillCountList.get(1);
		
		// 스킬 속성
		enemyPokemon.pokemonSkill.skillType[0] = 0;
		enemyPokemon.pokemonSkill.skillType[1] = 0;
		enemyPokemon.pokemonSkill.skillType[2] = 0;
		enemyPokemon.pokemonSkill.skillType[3] = 0;
	}
	
	/**************************************************
	 
	getPidgeyInfo
	입력: 적 포켓몬 정보, 자신의 포켓몬 레벨
	출력: 구구 정보가 저장된 적 포켓몬의 정보
	
	Pidgey: 구구의 영문명
	야생의 구구의 정보를 얻는다.

	**************************************************/
	public void getPidgeyInfo (EnemyPokemon enemyPokemon, int level)
	{
		pokemonSkill.setSkill();
		
		// 야생 포켓몬의 레벨을 계산
		calculateLevel = randomLevel.nextInt(level) + 1;
		enemyPokemon.pokemonLevel = calculateLevel;
		enemyPokemon.pokemonName = "구구";
				
		// 1 ~ 5사이의 레벨
		if (level == 1)
		{
			// 레벨 1의 기본 능력치 설정
			enemyPokemon.pokemonStatus[0] = 7;	// HealthPoint
			enemyPokemon.pokemonStatus[1] = 3;	// Attack
			enemyPokemon.pokemonStatus[2] = 2;	// Defense
			enemyPokemon.pokemonStatus[3] = 7;	// Speed
			
			enemyPokemon.pokemonStatus[4] = 0; 	// 포켓몬 타입(무속성)
			enemyPokemon.pokemonStatus[5] = 7; 	// 포켓몬의 현재 체력
			
			enemyPokemon.giveExp = 5;
		}
		else
		{
			enemyPokemon.pokemonStatus[0] = 7 + calculateLevel;
			enemyPokemon.pokemonStatus[1] = 3 + calculateLevel;
			enemyPokemon.pokemonStatus[2] = 2 + calculateLevel;
			enemyPokemon.pokemonStatus[3] = 7 + calculateLevel;
			
			enemyPokemon.pokemonStatus[4] = 0; 	// 포켓몬 타입(무속성)
			enemyPokemon.pokemonStatus[5] = 7 + calculateLevel;
			
			enemyPokemon.giveExp = 5 + (calculateLevel * 2);
		}
		
		// 구구의 스킬 설정
		// 스킬명
		enemyPokemon.pokemonSkill.skillName[0] = pokemonSkill.skillNameList.get(0);
		enemyPokemon.pokemonSkill.skillName[1] = pokemonSkill.skillNameList.get(1);
		enemyPokemon.pokemonSkill.skillName[2] = pokemonSkill.skillNameList.get(0);
		enemyPokemon.pokemonSkill.skillName[3] = pokemonSkill.skillNameList.get(1);
		
		// 스킬 위력
		enemyPokemon.pokemonSkill.skillDamage[0] = pokemonSkill.skillDamageList.get(0);
		enemyPokemon.pokemonSkill.skillDamage[1] = pokemonSkill.skillDamageList.get(1);
		enemyPokemon.pokemonSkill.skillDamage[2] = pokemonSkill.skillDamageList.get(0);
		enemyPokemon.pokemonSkill.skillDamage[3] = pokemonSkill.skillDamageList.get(1);
		
		// 스킬 명중률
		enemyPokemon.pokemonSkill.skillAccuracy[0] = pokemonSkill.skillAccuracyList.get(0);
		enemyPokemon.pokemonSkill.skillAccuracy[1] = pokemonSkill.skillAccuracyList.get(1);
		enemyPokemon.pokemonSkill.skillAccuracy[2] = pokemonSkill.skillAccuracyList.get(0);
		enemyPokemon.pokemonSkill.skillAccuracy[3] = pokemonSkill.skillAccuracyList.get(1);
		
		// 스킬 횟수
		enemyPokemon.pokemonSkill.skillCount[0] = pokemonSkill.skillCountList.get(0);
		enemyPokemon.pokemonSkill.skillCount[1] = pokemonSkill.skillCountList.get(1);
		enemyPokemon.pokemonSkill.skillCount[2] = pokemonSkill.skillCountList.get(0);
		enemyPokemon.pokemonSkill.skillCount[3] = pokemonSkill.skillCountList.get(1);
		
		// 스킬 속성
		enemyPokemon.pokemonSkill.skillType[0] = 0;
		enemyPokemon.pokemonSkill.skillType[1] = 0;
		enemyPokemon.pokemonSkill.skillType[2] = 0;
		enemyPokemon.pokemonSkill.skillType[3] = 0;
	}
	
	/**************************************************
	 
	getEeveeInfo
	입력: 적 포켓몬 정보, 자신의 포켓몬 레벨
	출력: 이브이 정보가 저장된 적 포켓몬의 정보
	
	Eevee: 이브이의 영문명
	야생의 이브이 정보를 얻는다.

	**************************************************/
	public void getEeveeInfo (EnemyPokemon enemyPokemon, int level)
	{
		pokemonSkill.setSkill();
		
		// 야생 포켓몬의 레벨을 계산
		calculateLevel = randomLevel.nextInt(level) + 1;
		
		// 레벨 최소치 보정
		if (calculateLevel < 10)
		{
			calculateLevel += 10;
		}
		
		enemyPokemon.pokemonLevel = calculateLevel;
		enemyPokemon.pokemonName = "이브이";
		
		enemyPokemon.pokemonStatus[0] = 10 + calculateLevel;	// HealthPoint
		enemyPokemon.pokemonStatus[1] = 7 + calculateLevel;		// Attack
		enemyPokemon.pokemonStatus[2] = 4 + calculateLevel;		// Defense
		enemyPokemon.pokemonStatus[3] = 7 + calculateLevel;		// Speed
		
		enemyPokemon.pokemonStatus[4] = 0; 	// 포켓몬 타입(무속성)
		enemyPokemon.pokemonStatus[5] = 10 + calculateLevel;	// 포켓몬의 현재 체력
		
		enemyPokemon.giveExp = 7 + (calculateLevel * 2);
		
		// 꼬렛의 스킬 설정
		// 스킬명
		enemyPokemon.pokemonSkill.skillName[0] = pokemonSkill.skillNameList.get(0);
		enemyPokemon.pokemonSkill.skillName[1] = pokemonSkill.skillNameList.get(1);
		enemyPokemon.pokemonSkill.skillName[2] = pokemonSkill.skillNameList.get(2);
		enemyPokemon.pokemonSkill.skillName[3] = pokemonSkill.skillNameList.get(3);
		
		// 스킬 위력
		enemyPokemon.pokemonSkill.skillDamage[0] = pokemonSkill.skillDamageList.get(0);
		enemyPokemon.pokemonSkill.skillDamage[1] = pokemonSkill.skillDamageList.get(1);
		enemyPokemon.pokemonSkill.skillDamage[2] = pokemonSkill.skillDamageList.get(2);
		enemyPokemon.pokemonSkill.skillDamage[3] = pokemonSkill.skillDamageList.get(3);
		
		// 스킬 명중률
		enemyPokemon.pokemonSkill.skillAccuracy[0] = pokemonSkill.skillAccuracyList.get(0);
		enemyPokemon.pokemonSkill.skillAccuracy[1] = pokemonSkill.skillAccuracyList.get(1);
		enemyPokemon.pokemonSkill.skillAccuracy[2] = pokemonSkill.skillAccuracyList.get(2);
		enemyPokemon.pokemonSkill.skillAccuracy[3] = pokemonSkill.skillAccuracyList.get(3);
		
		// 스킬 횟수
		enemyPokemon.pokemonSkill.skillCount[0] = pokemonSkill.skillCountList.get(0);
		enemyPokemon.pokemonSkill.skillCount[1] = pokemonSkill.skillCountList.get(1);
		enemyPokemon.pokemonSkill.skillCount[2] = pokemonSkill.skillCountList.get(2);
		enemyPokemon.pokemonSkill.skillCount[3] = pokemonSkill.skillCountList.get(3);
		
		// 스킬 속성
		enemyPokemon.pokemonSkill.skillType[0] = 0;
		enemyPokemon.pokemonSkill.skillType[1] = 0;
		enemyPokemon.pokemonSkill.skillType[2] = 0;
		enemyPokemon.pokemonSkill.skillType[3] = 0;
	}
	
	/**************************************************
	 
	getFarfetchInfo
	입력: 적 포켓몬 정보, 자신의 포켓몬 레벨
	출력: 파오리 정보가 저장된 적 포켓몬의 정보
	
	Farfetch'd: 파오리의 영문명
	야생의 파오리 정보를 얻는다.

	**************************************************/
	public void getFarfetchInfo (EnemyPokemon enemyPokemon, int level)
	{
		pokemonSkill.setSkill();
		
		// 야생 포켓몬의 레벨을 계산
		calculateLevel = randomLevel.nextInt(level) + 1;
		
		// 레벨 최소치 보정
		if (calculateLevel < 10)
		{
			calculateLevel += 10;
		}
		
		enemyPokemon.pokemonLevel = calculateLevel;
		enemyPokemon.pokemonName = "파오리";
		
		enemyPokemon.pokemonStatus[0] = 12 + calculateLevel;	// HealthPoint
		enemyPokemon.pokemonStatus[1] = 8 + calculateLevel;		// Attack
		enemyPokemon.pokemonStatus[2] = 5 + calculateLevel;		// Defense
		enemyPokemon.pokemonStatus[3] = 8 + calculateLevel;		// Speed
		
		enemyPokemon.pokemonStatus[4] = 0; 	// 포켓몬 타입(무속성)
		enemyPokemon.pokemonStatus[5] = 12 + calculateLevel;	// 포켓몬의 현재 체력
		
		enemyPokemon.giveExp = 8 + (calculateLevel * 2);
		
		// 꼬렛의 스킬 설정
		// 스킬명
		enemyPokemon.pokemonSkill.skillName[0] = pokemonSkill.skillNameList.get(0);
		enemyPokemon.pokemonSkill.skillName[1] = pokemonSkill.skillNameList.get(1);
		enemyPokemon.pokemonSkill.skillName[2] = pokemonSkill.skillNameList.get(2);
		enemyPokemon.pokemonSkill.skillName[3] = pokemonSkill.skillNameList.get(3);
		
		// 스킬 위력
		enemyPokemon.pokemonSkill.skillDamage[0] = pokemonSkill.skillDamageList.get(0);
		enemyPokemon.pokemonSkill.skillDamage[1] = pokemonSkill.skillDamageList.get(1);
		enemyPokemon.pokemonSkill.skillDamage[2] = pokemonSkill.skillDamageList.get(2);
		enemyPokemon.pokemonSkill.skillDamage[3] = pokemonSkill.skillDamageList.get(3);
		
		// 스킬 명중률
		enemyPokemon.pokemonSkill.skillAccuracy[0] = pokemonSkill.skillAccuracyList.get(0);
		enemyPokemon.pokemonSkill.skillAccuracy[1] = pokemonSkill.skillAccuracyList.get(1);
		enemyPokemon.pokemonSkill.skillAccuracy[2] = pokemonSkill.skillAccuracyList.get(2);
		enemyPokemon.pokemonSkill.skillAccuracy[3] = pokemonSkill.skillAccuracyList.get(3);
		
		// 스킬 횟수
		enemyPokemon.pokemonSkill.skillCount[0] = pokemonSkill.skillCountList.get(0);
		enemyPokemon.pokemonSkill.skillCount[1] = pokemonSkill.skillCountList.get(1);
		enemyPokemon.pokemonSkill.skillCount[2] = pokemonSkill.skillCountList.get(2);
		enemyPokemon.pokemonSkill.skillCount[3] = pokemonSkill.skillCountList.get(3);
		
		// 스킬 속성
		enemyPokemon.pokemonSkill.skillType[0] = 0;
		enemyPokemon.pokemonSkill.skillType[1] = 0;
		enemyPokemon.pokemonSkill.skillType[2] = 0;
		enemyPokemon.pokemonSkill.skillType[3] = 0;
	}
	
	/**************************************************
	 
	getChanseyInfo
	입력: 적 포켓몬 정보, 자신의 포켓몬 레벨
	출력: 럭키 정보가 저장된 적 포켓몬의 정보
	
	Chansey: 럭키의 영문명
	야생의 럭키 정보를 얻는다.

	**************************************************/
	public void getChanseyInfo (EnemyPokemon enemyPokemon, int level)
	{
		pokemonSkill.setSkill();
		
		// 야생 포켓몬의 레벨을 계산
		calculateLevel = randomLevel.nextInt(level) + 1;
		
		// 레벨 최소치 보정
		if (calculateLevel < 20)
		{
			calculateLevel += 20;
		}
		
		enemyPokemon.pokemonLevel = calculateLevel;
		enemyPokemon.pokemonName = "럭키";
		
		enemyPokemon.pokemonStatus[0] = 16 + calculateLevel;	// HealthPoint
		enemyPokemon.pokemonStatus[1] = 8 + calculateLevel;		// Attack
		enemyPokemon.pokemonStatus[2] = 10 + calculateLevel;	// Defense
		enemyPokemon.pokemonStatus[3] = 7 + calculateLevel;		// Speed
		
		enemyPokemon.pokemonStatus[4] = 0; 	// 포켓몬 타입(무속성)
		enemyPokemon.pokemonStatus[5] = 16 + calculateLevel;	// 포켓몬의 현재 체력
		
		enemyPokemon.giveExp = 12 + (calculateLevel * 2);
		
		// 꼬렛의 스킬 설정
		// 스킬명
		enemyPokemon.pokemonSkill.skillName[0] = pokemonSkill.skillNameList.get(1);
		enemyPokemon.pokemonSkill.skillName[1] = pokemonSkill.skillNameList.get(2);
		enemyPokemon.pokemonSkill.skillName[2] = pokemonSkill.skillNameList.get(3);
		enemyPokemon.pokemonSkill.skillName[3] = pokemonSkill.skillNameList.get(4);
		
		// 스킬 위력
		enemyPokemon.pokemonSkill.skillDamage[0] = pokemonSkill.skillDamageList.get(1);
		enemyPokemon.pokemonSkill.skillDamage[1] = pokemonSkill.skillDamageList.get(2);
		enemyPokemon.pokemonSkill.skillDamage[2] = pokemonSkill.skillDamageList.get(3);
		enemyPokemon.pokemonSkill.skillDamage[3] = pokemonSkill.skillDamageList.get(4);
		
		// 스킬 명중률
		enemyPokemon.pokemonSkill.skillAccuracy[0] = pokemonSkill.skillAccuracyList.get(1);
		enemyPokemon.pokemonSkill.skillAccuracy[1] = pokemonSkill.skillAccuracyList.get(2);
		enemyPokemon.pokemonSkill.skillAccuracy[2] = pokemonSkill.skillAccuracyList.get(3);
		enemyPokemon.pokemonSkill.skillAccuracy[3] = pokemonSkill.skillAccuracyList.get(4);
		
		// 스킬 횟수
		enemyPokemon.pokemonSkill.skillCount[0] = pokemonSkill.skillCountList.get(1);
		enemyPokemon.pokemonSkill.skillCount[1] = pokemonSkill.skillCountList.get(2);
		enemyPokemon.pokemonSkill.skillCount[2] = pokemonSkill.skillCountList.get(3);
		enemyPokemon.pokemonSkill.skillCount[3] = pokemonSkill.skillCountList.get(4);
		
		// 스킬 속성
		enemyPokemon.pokemonSkill.skillType[0] = 0;
		enemyPokemon.pokemonSkill.skillType[1] = 0;
		enemyPokemon.pokemonSkill.skillType[2] = 0;
		enemyPokemon.pokemonSkill.skillType[3] = 0;
	}
	
	/**************************************************
	 
	getRaticateInfo
	입력: 적 포켓몬 정보, 자신의 포켓몬 레벨
	출력: 레트라 정보가 저장된 적 포켓몬의 정보
	
	Raticate: 레트라의 영문명
	야생의 레트라 정보를 얻는다.

	**************************************************/
	public void getRaticateInfo (EnemyPokemon enemyPokemon, int level)
	{
		pokemonSkill.setSkill();
		
		// 야생 포켓몬의 레벨을 계산
		calculateLevel = randomLevel.nextInt(level) + 1;
		
		// 레벨 최소치 보정
		if (calculateLevel < 20)
		{
			calculateLevel += 20;
		}
		
		enemyPokemon.pokemonLevel = calculateLevel;
		enemyPokemon.pokemonName = "레트라";
		
		enemyPokemon.pokemonStatus[0] = 14 + calculateLevel;	// HealthPoint
		enemyPokemon.pokemonStatus[1] = 10 + calculateLevel;	// Attack
		enemyPokemon.pokemonStatus[2] = 7 + calculateLevel;		// Defense
		enemyPokemon.pokemonStatus[3] = 10 + calculateLevel;	// Speed
		
		enemyPokemon.pokemonStatus[4] = 0; 	// 포켓몬 타입(무속성)
		enemyPokemon.pokemonStatus[5] = 14 + calculateLevel;	// 포켓몬의 현재 체력
		
		enemyPokemon.giveExp = 10 + (calculateLevel * 2);
		
		// 레트라의 스킬 설정
		// 스킬명
		enemyPokemon.pokemonSkill.skillName[0] = pokemonSkill.skillNameList.get(1);
		enemyPokemon.pokemonSkill.skillName[1] = pokemonSkill.skillNameList.get(2);
		enemyPokemon.pokemonSkill.skillName[2] = pokemonSkill.skillNameList.get(3);
		enemyPokemon.pokemonSkill.skillName[3] = pokemonSkill.skillNameList.get(4);
		
		// 스킬 위력
		enemyPokemon.pokemonSkill.skillDamage[0] = pokemonSkill.skillDamageList.get(1);
		enemyPokemon.pokemonSkill.skillDamage[1] = pokemonSkill.skillDamageList.get(2);
		enemyPokemon.pokemonSkill.skillDamage[2] = pokemonSkill.skillDamageList.get(3);
		enemyPokemon.pokemonSkill.skillDamage[3] = pokemonSkill.skillDamageList.get(4);
		
		// 스킬 명중률
		enemyPokemon.pokemonSkill.skillAccuracy[0] = pokemonSkill.skillAccuracyList.get(1);
		enemyPokemon.pokemonSkill.skillAccuracy[1] = pokemonSkill.skillAccuracyList.get(2);
		enemyPokemon.pokemonSkill.skillAccuracy[2] = pokemonSkill.skillAccuracyList.get(3);
		enemyPokemon.pokemonSkill.skillAccuracy[3] = pokemonSkill.skillAccuracyList.get(4);
		
		// 스킬 횟수
		enemyPokemon.pokemonSkill.skillCount[0] = pokemonSkill.skillCountList.get(1);
		enemyPokemon.pokemonSkill.skillCount[1] = pokemonSkill.skillCountList.get(2);
		enemyPokemon.pokemonSkill.skillCount[2] = pokemonSkill.skillCountList.get(3);
		enemyPokemon.pokemonSkill.skillCount[3] = pokemonSkill.skillCountList.get(4);
		
		// 스킬 속성
		enemyPokemon.pokemonSkill.skillType[0] = 0;
		enemyPokemon.pokemonSkill.skillType[1] = 0;
		enemyPokemon.pokemonSkill.skillType[2] = 0;
		enemyPokemon.pokemonSkill.skillType[3] = 0;
	}
	
	/**************************************************
	 
	getSnorlaxInfo
	입력: 적 포켓몬 정보, 자신의 포켓몬 레벨
	출력: 잠만보 정보가 저장된 적 포켓몬의 정보
	
	Snorlax: 잠만보의 영문명
	야생의 잠만보 정보를 얻는다.

	**************************************************/
	public void getSnorlaxInfo (EnemyPokemon enemyPokemon, int level)
	{
		pokemonSkill.setSkill();
		
		// 야생 포켓몬의 레벨을 계산
		calculateLevel = randomLevel.nextInt(level) + 1;
		
		// 레벨 최소치 보정
		if (calculateLevel < 30)
		{
			calculateLevel += 30;
		}
		
		enemyPokemon.pokemonLevel = calculateLevel;
		enemyPokemon.pokemonName = "잠만보";
		
		enemyPokemon.pokemonStatus[0] = 22 + calculateLevel;	// HealthPoint
		enemyPokemon.pokemonStatus[1] = 12 + calculateLevel;	// Attack
		enemyPokemon.pokemonStatus[2] = 20 + calculateLevel;	// Defense
		enemyPokemon.pokemonStatus[3] = 10 + calculateLevel;	// Speed
		
		enemyPokemon.pokemonStatus[4] = 0; 	// 포켓몬 타입(무속성)
		enemyPokemon.pokemonStatus[5] = 22 + calculateLevel;	// 포켓몬의 현재 체력
		
		enemyPokemon.giveExp = 20 + (calculateLevel * 2);
		
		// 잠만보의 스킬 설정
		// 1. 메가톤펀치    2. 괴력   3. 누르기   4. 기가임팩트
		// 스킬명
		enemyPokemon.pokemonSkill.skillName[0] = pokemonSkill.skillNameList.get(3);
		enemyPokemon.pokemonSkill.skillName[1] = pokemonSkill.skillNameList.get(5);
		enemyPokemon.pokemonSkill.skillName[2] = pokemonSkill.skillNameList.get(6);
		enemyPokemon.pokemonSkill.skillName[3] = pokemonSkill.skillNameList.get(7);
		
		// 스킬 위력
		enemyPokemon.pokemonSkill.skillDamage[0] = pokemonSkill.skillDamageList.get(3);
		enemyPokemon.pokemonSkill.skillDamage[1] = pokemonSkill.skillDamageList.get(5);
		enemyPokemon.pokemonSkill.skillDamage[2] = pokemonSkill.skillDamageList.get(6);
		enemyPokemon.pokemonSkill.skillDamage[3] = pokemonSkill.skillDamageList.get(7);
		
		// 스킬 명중률
		enemyPokemon.pokemonSkill.skillAccuracy[0] = pokemonSkill.skillAccuracyList.get(3);
		enemyPokemon.pokemonSkill.skillAccuracy[1] = pokemonSkill.skillAccuracyList.get(5);
		enemyPokemon.pokemonSkill.skillAccuracy[2] = pokemonSkill.skillAccuracyList.get(6);
		enemyPokemon.pokemonSkill.skillAccuracy[3] = pokemonSkill.skillAccuracyList.get(7);
		
		// 스킬 횟수
		enemyPokemon.pokemonSkill.skillCount[0] = pokemonSkill.skillCountList.get(3);
		enemyPokemon.pokemonSkill.skillCount[1] = pokemonSkill.skillCountList.get(5);
		enemyPokemon.pokemonSkill.skillCount[2] = pokemonSkill.skillCountList.get(6);
		enemyPokemon.pokemonSkill.skillCount[3] = pokemonSkill.skillCountList.get(7);
		
		// 스킬 속성
		enemyPokemon.pokemonSkill.skillType[0] = 0;
		enemyPokemon.pokemonSkill.skillType[1] = 0;
		enemyPokemon.pokemonSkill.skillType[2] = 0;
		enemyPokemon.pokemonSkill.skillType[3] = 0;
	}
	
	/**************************************************
	 
	getKangaskhanInfo
	입력: 적 포켓몬 정보, 자신의 포켓몬 레벨
	출력: 캥카 정보가 저장된 적 포켓몬의 정보
	
	Kangaskhan: 캥카의 영문명
	야생의 캥카 정보를 얻는다.

	**************************************************/
	public void getKangaskhanInfo (EnemyPokemon enemyPokemon, int level)
	{
		pokemonSkill.setSkill();
		
		// 야생 포켓몬의 레벨을 계산
		calculateLevel = randomLevel.nextInt(level) + 1;
		
		// 레벨 최소치 보정
		if (calculateLevel < 30)
		{
			calculateLevel += 30;
		}
		
		enemyPokemon.pokemonLevel = calculateLevel;
		enemyPokemon.pokemonName = "캥카";
		
		enemyPokemon.pokemonStatus[0] = 20 + calculateLevel;	// HealthPoint
		enemyPokemon.pokemonStatus[1] = 15 + calculateLevel;	// Attack
		enemyPokemon.pokemonStatus[2] = 12 + calculateLevel;	// Defense
		enemyPokemon.pokemonStatus[3] = 15 + calculateLevel;	// Speed
		
		enemyPokemon.pokemonStatus[4] = 0; 	// 포켓몬 타입(무속성)
		enemyPokemon.pokemonStatus[5] = 20 + calculateLevel;	// 포켓몬의 현재 체력
		
		enemyPokemon.giveExp = 15 + (calculateLevel * 2);
		
		// 캥카의 스킬 설정
		// 1. 몸통박치기    2. 돌진   3. 괴력   4. 이판사판태클
		// 스킬명
		enemyPokemon.pokemonSkill.skillName[0] = pokemonSkill.skillNameList.get(0);
		enemyPokemon.pokemonSkill.skillName[1] = pokemonSkill.skillNameList.get(4);
		enemyPokemon.pokemonSkill.skillName[2] = pokemonSkill.skillNameList.get(5);
		enemyPokemon.pokemonSkill.skillName[3] = pokemonSkill.skillNameList.get(8);
		
		// 스킬 위력
		enemyPokemon.pokemonSkill.skillDamage[0] = pokemonSkill.skillDamageList.get(0);
		enemyPokemon.pokemonSkill.skillDamage[1] = pokemonSkill.skillDamageList.get(4);
		enemyPokemon.pokemonSkill.skillDamage[2] = pokemonSkill.skillDamageList.get(5);
		enemyPokemon.pokemonSkill.skillDamage[3] = pokemonSkill.skillDamageList.get(8);
		
		// 스킬 명중률
		enemyPokemon.pokemonSkill.skillAccuracy[0] = pokemonSkill.skillAccuracyList.get(0);
		enemyPokemon.pokemonSkill.skillAccuracy[1] = pokemonSkill.skillAccuracyList.get(4);
		enemyPokemon.pokemonSkill.skillAccuracy[2] = pokemonSkill.skillAccuracyList.get(5);
		enemyPokemon.pokemonSkill.skillAccuracy[3] = pokemonSkill.skillAccuracyList.get(8);
		
		// 스킬 횟수
		enemyPokemon.pokemonSkill.skillCount[0] = pokemonSkill.skillCountList.get(0);
		enemyPokemon.pokemonSkill.skillCount[1] = pokemonSkill.skillCountList.get(4);
		enemyPokemon.pokemonSkill.skillCount[2] = pokemonSkill.skillCountList.get(5);
		enemyPokemon.pokemonSkill.skillCount[3] = pokemonSkill.skillCountList.get(8);
		
		// 스킬 속성
		enemyPokemon.pokemonSkill.skillType[0] = 0;
		enemyPokemon.pokemonSkill.skillType[1] = 0;
		enemyPokemon.pokemonSkill.skillType[2] = 0;
		enemyPokemon.pokemonSkill.skillType[3] = 0;
	}
}

// End of File
