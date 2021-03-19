/**************************************************
 
배틀 클래스

**************************************************/

package pokemon;

import java.util.InputMismatchException;
import java.util.Random;

public class Battle implements Runnable 
{
	int getExp = 0;			// 배틀 승리후 획득하는 경험치
	boolean isMyTurn;		// 플레이어 턴인지 판단
	int selectNumber;		// 배틀 메뉴에서 선택한 번호
	
	public Battle ()
	{
		
	}
	
	/**************************************************
	
	pokemonBattleMenu
	입력: 내 포켓몬 정보, 적 포켓몬 정보
	출력: 내포켓몬 정보, 적 포켓몬 정보
	
	포켓몬 배틀 메뉴를 표시하고 선택한다.
	1. 싸운다.   2. 회복한다.   3. 도망간다.

	**************************************************/
	public void pokemonBattleMenu (MyPokemon myPokemon, EnemyPokemon enemyPokemon)
	{		
		int receiveNumber = -1;			// 전투 선택지 번호
		boolean isBattleOver = false;	// 배틀 종료여부
		
		// 플레이어가 선공인지 아닌지 판단
		isMyTurn = this.checkPlayerFirstTurn (myPokemon.pokemonStatus[3], enemyPokemon.pokemonStatus[3]);
		
		// 배틀이 끝날때까지 반복
		while (isBattleOver == false)
		{
			// 나의 포켓몬과 상대방 포켓몬의 정보를 표시
			this.displayCurrentStatus (myPokemon, enemyPokemon);

			System.out.printf("************************************************************\n");
			System.out.printf("%s는 무엇을 할까?\n", myPokemon.pokemonName);
			System.out.printf("1. 싸운다.\n");
			System.out.printf("2. 회복한다.\n");
			System.out.printf("3. 도망간다.\n");
			System.out.printf("************************************************************\n");
			System.out.printf("번호 선택: ");
			try // 숫자를 입력 받는지 확인
			{
				receiveNumber = ShareData.battleInput.nextInt();
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
			
			switch (receiveNumber)
			{
				case 1: // 싸운다.
					// 턴제 게임 동작처럼 보이기 위한 조건
					// 내가 행동 하면 다음 행동은 무조건 상대방이 행동한다.
					if (isMyTurn == true)
					{
						isBattleOver = this.pokemonBattle (myPokemon, enemyPokemon, isMyTurn);
						// 배틀 종료 조건을 만족
						if (isBattleOver == true)
						{
							break;
						}
						else
						{
							isBattleOver = this.pokemonBattle (myPokemon, enemyPokemon, false);
							continue;
						}
					}
					else
					{
						isBattleOver = this.pokemonBattle (myPokemon, enemyPokemon, isMyTurn);
						// 배틀 종료 조건을 만족
						if (isBattleOver == true)
						{
							break;
						}
						else
						{
							isBattleOver = this.pokemonBattle (myPokemon, enemyPokemon, true);
							continue;
						}
					}
				case 2:	// 회복한다.
					// 인벤에 있는 아이템을 확인하여 사용한다.
					this.recoveryPokemon(myPokemon);
					// 회복하면 상대방이 공격하는 행동을 한다.
					isBattleOver = this.pokemonBattle (myPokemon, enemyPokemon, false);
					continue;
				case 3:	// 도망간다.
					// 배틀 종료
					System.out.printf("지금은 싸울때가 아닌것 같아 도망가자.\n\n");
					System.out.printf("************************************************************\n");
					isBattleOver = true;
					break;
				default:
					break;
			}
		}
	}
	
	/**************************************************
	 
	pokemonBattle
	입력: 내 포켓몬 정보, 적 포켓몬 정보, 턴 정보
	출력: 내 포켓몬 정보, 적 포켓몬 정보, 속성일치 정보, 배틀 종료
	
	포켓몬 배틀을 수행한다.
	선공을 누가할지 결정하고 스킬을 사용하여 상대방에게 피해를 입힌다.

	**************************************************/
	private boolean pokemonBattle (MyPokemon myPokemon, EnemyPokemon enemyPokemon, boolean myTurn)
	{
		// 포켓몬 클래스
		Pokemon pokemon = new Pokemon();
		PokemonSkill pokemonSkill = new PokemonSkill();

		int useSkillNumber = -1; 	// 선택한 스킬번호
		int damageValue = -1;		// 실제 피해량
		boolean battleOver = false;	// 배틀 종료여부
		boolean hitAttack = true;	// 공격 명중여부
		boolean canAttack = true;	// 포켓몬이 공격을 할 수 있는 상태인가
		
		// 플레이어의 턴
		if (myTurn == true)
		{
			// 상태이상 확인 
			canAttack = this.checkAbnormalCondition (myPokemon, enemyPokemon, true);
			// 공격을 할 수 있는 상태
			if (canAttack == true)
			{
				System.out.printf("************************************************************\n");
				System.out.printf("플레이어 공격\n");
				// 스킬 사용
				useSkillNumber = pokemonSkill.pokemonUsingSkill (myPokemon);
				// 피해량 계산
				damageValue = this.calculateRealDamage (myPokemon, enemyPokemon, useSkillNumber, true);
				// 명중여부 판단
				hitAttack = this.checkHittingAttack (myPokemon.pokemonSkill.skillAccuracy[useSkillNumber], myPokemon.familiarity);
				
				if (hitAttack == true)
				{
					System.out.printf("상대방에게 %d의 피해를 입힌다.\n", damageValue);
					System.out.printf("************************************************************\n\n");
					
					// 무속성을 제외한 속성공격을 하면 속성에 맞는 상태이상을 걸었는지 판단한다.
					this.checkAbnormalCondition(myPokemon, enemyPokemon, useSkillNumber, true);
					// 남은 체력 계산
					enemyPokemon.pokemonStatus[5] = enemyPokemon.pokemonStatus[5] - damageValue;
				}
				else
				{
					System.out.printf("공격을 명중시키지 못했다...\n");
					System.out.printf("************************************************************\n\n");
				}
				
				// 체력이 0이하로 떨어지면 배틀 종료
				if (enemyPokemon.pokemonStatus[5] <= 0)
				{
					enemyPokemon.pokemonStatus[5] = 0;
					System.out.printf("%s이(가) 쓰러졌다.\n\n", enemyPokemon.pokemonName);
					myPokemon.levelUpExp -= enemyPokemon.giveExp;
					
					// 레벨업 경험치 도달
					if (myPokemon.levelUpExp <= 0)
					{
						// 플레이어는 레벨 100까지 성장한다.
						if (myPokemon.pokemonLevel < 100)
						{
							myPokemon.pokemonLevel += 1;
							System.out.printf("레벨이 올랐다!\n");
							System.out.printf("레벨이 %d이 되었다!\n", myPokemon.pokemonLevel);
							pokemon.increasePokemonStatus(myPokemon.levelUpExp);
						}
						else
						{
							System.out.printf("경험치 %d을(를) 얻었다.\n", enemyPokemon.giveExp);
							System.out.printf("남은 경험치 %d\n", myPokemon.levelUpExp);
						}
					}
					else
					{
						System.out.printf("경험치 %d을(를) 얻었다.\n", enemyPokemon.giveExp);
						System.out.printf("남은 경험치 %d\n", myPokemon.levelUpExp);
					}
					
					// 배틀에 승리해서 소지금을 얻는다.
					Player.currentMoney += 200;
					System.out.printf("소지금 %d만큼 얻었다.\n", 200);
					System.out.printf("현재 소지금 %d\n", Player.currentMoney);
					
					// 배틀 승리시 친밀도 5 증가
					myPokemon.familiarity += 5;
					battleOver = true;
					
					// 승리한 포켓몬이 라이벌 포켓몬
					if (enemyPokemon.rivalPokemon == true)
					{
						Player.winToRival = true;
					}
				}
			}
			else // 마비때문에 행동을 하지 못한다.
			{
				System.out.printf("마비 때문에 움직일 수 없다!\n");
			}
		}
		else // 적의 턴
		{
			// 상태이상 확인 
			canAttack = this.checkAbnormalCondition (myPokemon, enemyPokemon, false);
			// 공격을 할 수 있는 상태
			if (canAttack == true)
			{
				System.out.printf("************************************************************\n");
				System.out.printf("적의 공격\n");
				// 스킬 사용
				useSkillNumber = pokemonSkill.pokemonUsingSkill (enemyPokemon);
				// 피해량 계산
				damageValue = this.calculateRealDamage (myPokemon, enemyPokemon, useSkillNumber, false);
				// 명중여부 판단
				hitAttack = this.checkHittingAttack (enemyPokemon.pokemonSkill.skillAccuracy[useSkillNumber], 0);
				
				if (hitAttack == true)
				{
					System.out.printf("상대가 %d의 피해를 주었다.\n", damageValue);
					System.out.printf("************************************************************\n\n");
					
					// 무속성을 제외한 속성공격을 하면 속성에 맞는 상태이상을 걸었는지 판단한다.
					this.checkAbnormalCondition(myPokemon, enemyPokemon, useSkillNumber, false);
					// 남은 체력 계산
					myPokemon.pokemonStatus[5] = myPokemon.pokemonStatus[5] - damageValue;
				}
				else
				{
					System.out.printf("상대의 공격을 피했다! 잘했어! %s\n", myPokemon.pokemonName);
					System.out.printf("************************************************************\n\n");
				}
				
				// 체력이 0이하로 떨어지면 배틀 종료
				if (myPokemon.pokemonStatus[5] <= 0)
				{
					myPokemon.pokemonStatus[5] = 0;
					System.out.printf("나의 포켓몬%s이(가) 쓰러졌다!!\n", myPokemon.pokemonName);
					System.out.printf("눈 앞이 깜깜해 졌다....\n");
					// 배틀에 패배해서 소지금을 잃는다.
					Player.currentMoney -= 100;
					System.out.printf("소지금 %d만큼 잃었다.\n", 100);
					System.out.printf("현재 소지금 %d\n", Player.currentMoney);
					
					// 배틀 패배시 친밀도 10감소
					myPokemon.familiarity -= 10;
					
					// 0보다 작은 값이면 0으로 초기화
					if (myPokemon.familiarity < 0)
					{
						myPokemon.familiarity = 0;
					}
					battleOver = true;
				}
			}
			else // 마비때문에 행동을 하지 못한다.
			{
				System.out.printf("상대가 마비 때문에 움직일 수 없다!\n");
			}

		}
		
		return battleOver;
	}
		
	/**************************************************
	 
	displayCurrentStatus
	입력: 나의 포켓몬 정보, 적 포켓몬의 정보
	출력: 콘솔 메시지
	
	자신의 포켓몬과 적 포켓몬의 상태 정보 표시

	**************************************************/
	private void displayCurrentStatus (MyPokemon myPokemon, EnemyPokemon enemyPokemon)
	{
		System.out.printf("내 포켓몬\n");
		System.out.printf("Lv: %d    상태: %s\n", myPokemon.pokemonLevel, myPokemon.pokemonCondition);
		System.out.printf("%s HP: %d / %d \n\n", 
				myPokemon.pokemonName, 
				myPokemon.pokemonStatus[5], myPokemon.pokemonStatus[0]);
		
		if (enemyPokemon.rivalPokemon == true)
		{
			System.out.printf("라이벌 포켓몬\n");
		}
		else
		{
			System.out.printf("야생 포켓몬\n");
		}
		
		System.out.printf("Lv: %d    상태: %s\n", enemyPokemon.pokemonLevel, enemyPokemon.pokemonCondition);
		System.out.printf("%s HP: %d / %d \n\n", 
				enemyPokemon.pokemonName, 
				enemyPokemon.pokemonStatus[5], enemyPokemon.pokemonStatus[0]);
	}
		
	/**************************************************
	 
	calculateRealDamage
	입력: 내 포켓몬 정보, 적 포켓몬 정보, 사용한 스킬 번호, 플레이어 공격인가
	출력: 실제 피해량
	
	포켓몬 공격시 실제 들어가는 대미지를 계산한다.
	상대방에게 입힐 피해를 계산하여 해당 수치만큼 체력을 감소 시킨다.

	**************************************************/
	private int calculateRealDamage (MyPokemon myPokemon, EnemyPokemon enemyPokemon, int skillNumber, boolean playerAttack)
	{	
		float applySynastry = -1;	// 상성 적용 치
		int calculateDamage = -1;	// 계산한 대미지 값
		boolean typeMatch;			// 포켓몬과 스킬의 속성 일치 여부
		
		// 살제 상대방에게 입힐 피해를 계산
		if (playerAttack == true)
		{
			// 포켓몬의 속성과 포켓몬 스킬 속성이 일치
			if (myPokemon.pokemonStatus[4] == myPokemon.pokemonSkill.skillType[skillNumber])
			{
				typeMatch = true;
			}
			else
			{
				typeMatch = false;
			}
			
			// 기본 피해량 계산
			calculateDamage = (myPokemon.pokemonStatus[1] + 
					(myPokemon.pokemonSkill.skillDamage[skillNumber] / 10)) - (enemyPokemon.pokemonStatus[2] + 1);
			
			// 타입 상성관계면 피해량 보정치가 적용된다.
			applySynastry = this.applySynastryValue(myPokemon.pokemonSkill.skillType[skillNumber], enemyPokemon.pokemonStatus[4]);
			// 상성치 적용
			calculateDamage = (int)(calculateDamage * applySynastry);
		}
		else
		{
			// 포켓몬의 속성과 포켓몬 스킬 속성이 일치
			if (enemyPokemon.pokemonStatus[4] == enemyPokemon.pokemonSkill.skillType[skillNumber])
			{
				typeMatch = true;
			}
			else
			{
				typeMatch = false;
			}
			
			// 기본 피해량 계산
			calculateDamage = (enemyPokemon.pokemonStatus[1] + 
					(enemyPokemon.pokemonSkill.skillDamage[skillNumber] / 10)) - (myPokemon.pokemonStatus[2] + 1);
			
			// 타입 상성관계면 피해량 보정치가 적용된다.
			applySynastry = this.applySynastryValue(enemyPokemon.pokemonSkill.skillType[skillNumber], myPokemon.pokemonStatus[4]);
			// 상성치 적용
			calculateDamage = (int)(calculateDamage * applySynastry);
		}
		
		// 상대의 방어력이 높아서 피해량이 -가 된경우, 최소 피해를 주도록 보정
		if (calculateDamage < 0)
		{
			calculateDamage = 1;
		}
		
		// 포켓몬 속성과 스킬의 속성이 같으면 위력이 증가한다.
		if (typeMatch == true)
		{
			calculateDamage = (int)(calculateDamage * 1.5f);
		}
		
		return calculateDamage;
	}
	
	/**************************************************
	 
	applySynastryValue
	입력: 공격 스킬 타입, 상대의 포켓몬 타입
	출력: 피해량 보정치
	
	타입 상성에 따라 피해량의 보정치를 적용한다.

	**************************************************/
	private float applySynastryValue (int skillType, int pokemonType)
	{
		float applySynastry = -1;
		
		// 자신의 상성이 이기는 경우들
		// 자신: 불, 상대: 풀
		if ((skillType == 1) && (pokemonType == 2))
		{
			applySynastry = 2;
		}
		// 자신: 풀, 상대: 물
		else if ((skillType == 2) && (pokemonType == 3))
		{
			applySynastry = 2;
		}
		// 자신: 물, 상대: 불
		else if ((skillType == 3) && (pokemonType == 1))
		{
			applySynastry = 2;
		}
		// 자신의 상성이 지는 경우들
		// 자신: 불, 상대: 물
		else if ((skillType == 1) && (pokemonType == 3))
		{
			applySynastry = 0.5f;
		}
		// 자신: 풀, 상대: 불
		else if ((skillType == 2) && (pokemonType == 1))
		{
			applySynastry = 0.5f;
		}
		// 자신: 물, 상대: 풀
		else if ((skillType == 3) && (pokemonType == 2))
		{
			applySynastry = 0.5f;
		}
		else
		{
			// 상성 미적용
			applySynastry = 1;
		}
		
		return applySynastry;
	}
	
	/**************************************************
	 
	checkHittingAttack
	입력: 명중률
	출력: 공격 명중 판정여부
	
	명중률을 입력받아서 공격이 명중했는지 안했는지 판단한다.

	**************************************************/
	private boolean checkHittingAttack (int accuracy, int familiarity)
	{
		// 랜덤숫자를 얻기 위한 랜덤 클래스
		Random random = new Random();
		int randomNumber = -1;		// 랜덤 숫자
		boolean hitAttack = true;	// 공격 명중여부

		// 0 ~ 99까지 숫자를 랜덤으로 생성해서 명중률 값 범위 안에 들어오면 명중 판정을 준다.
		randomNumber = random.nextInt(100);
		
		// 친밀도 수치에 따라서 명중률 보정 값이 적용 된다.
		if ((familiarity > 0) && (familiarity <= 50))
		{
			accuracy += 1;
		}
		else if ((familiarity > 51) && (familiarity <= 100))
		{
			accuracy += 2;
		}
		else if ((familiarity > 101) && (familiarity <= 150))
		{
			accuracy += 5;
		}
		else if ((familiarity > 151) && (familiarity <= 200))
		{
			accuracy += 8;
		}
		else if ((familiarity > 201) && (familiarity <= 254))
		{
			accuracy += 10;
		}
		else if (familiarity == 255) // 친밀도 최대치
		{
			accuracy += 20;
		}
		else
		{
			accuracy += 0;
		}
		
		// 명중률 100이상은 무조건 명중
		if (accuracy >= 100)
		{
			hitAttack = true;
		}
		else
		{
			// 랜덤으로 나온 숫자가 더 크면 공격이 빗나가는 판정
			// ex) 85 명중률이면 랜덤숫자가 86~100이 나오면 빗나가고 아래 숫자는 명중
			if (randomNumber > accuracy)
			{
				hitAttack = false;
			}
			else
			{
				hitAttack = true;
			}
		}

		return hitAttack;
	}
	
	/**************************************************
	 
	checkPlayerFirstTurn
	입력: 내 포켓몬 스피드, 적 포켓몬 스피드
	출력: 내 포켓몬이 선공을할 수 있다 or 없다
	
	포켓몬의 Speed 수치를 비교하여 선공 여부를 결정한다.

	**************************************************/
	private boolean checkPlayerFirstTurn (int myPokemonSpeed, int enemyPokemonSpeed)
	{
		boolean playerFirstTurn; // 플레이어 선공여부
		
		// 플레이어의 포켓몬이 더 속도가 빠른경우
		if (myPokemonSpeed > enemyPokemonSpeed)
		{
			// 플레이어 선공
			playerFirstTurn = true;
		}
		else
		{
			// 적 선공
			playerFirstTurn = false;
		}
		
		return playerFirstTurn;
	}
	
	/**************************************************
	 
	checkAbnormalCondition
	입력: 내 포켓몬 정보, 적 포켓몬 정보, 사용한 스킬 번호, 플레이어 공격인가
	출력: 포켓몬의 상태이상
	
	포켓몬 공격시 속성에 따라 일정 확률로 상태이상을 건다.

	**************************************************/
	private void checkAbnormalCondition (MyPokemon myPokemon, EnemyPokemon enemyPokemon, int skillNumber, boolean playerAttack)
	{
		FireElementPokemon fireElementPokemon = new FireElementPokemon();
		GrassElementPokemon grassElementPokemon = new GrassElementPokemon();
		WaterElementPokemon waterElementPokemon = new WaterElementPokemon();
		
		boolean abnormalCondition = false;
		int skilltype = 0;
		
		// 내 포켓몬의 스킬 타입 확인
		if (playerAttack == true)
		{
			skilltype = myPokemon.pokemonSkill.skillType[skillNumber];
		}
		else // 적 포켓몬의 스킬 타입
		{
			skilltype = enemyPokemon.pokemonSkill.skillType[skillNumber];
		}
		
		switch (skilltype)
		{
			case 1: // 불속성 스킬
				// 불속성 공격으로 화상 상태를 만드는지 확인
				abnormalCondition = fireElementPokemon.makeBurnStatus ();
				
				// 화상 상태가 확정
				if (abnormalCondition == true)
				{
					// 플레이어가 공격한 경우
					if (playerAttack == true)
					{
						System.out.printf("상대에게 화상을 입혔다.\n");
						enemyPokemon.pokemonCondition = "화상";
					}
					else
					{
						System.out.printf("화상을 입었다!\n");
						myPokemon.pokemonCondition = "화상";
					}
				}
				break;
			case 2: // 풀속성 스킬
				// 풀속성 공격으로 마비 상태를 만드는지 확인
				abnormalCondition = grassElementPokemon.makeParalysisStatus ();
				
				// 마비 상태가 확정
				if (abnormalCondition == true)
				{
					// 플레이어가 공격한 경우
					if (playerAttack == true)
					{
						System.out.printf("상대에게 마비를 걸었다.\n");
						enemyPokemon.pokemonCondition = "마비";
					}
					else
					{
						System.out.printf("마비에 걸렸다!\n");
						myPokemon.pokemonCondition = "마비";
					}
				}
				break;
			case 3: // 물속성 스킬
				// 물속성 공격으로 빙결 상태를 만드는지 확인
				abnormalCondition = waterElementPokemon.makeIceStatus ();
				
				// 빙결 상태가 확정
				if (abnormalCondition == true)
				{
					// 플레이어가 공격한 경우
					if (playerAttack == true)
					{
						System.out.printf("상대가 얼었다.\n");
						enemyPokemon.pokemonCondition = "빙결";
					}
					else
					{
						System.out.printf("빙결 상태가 되었다!\n");
						myPokemon.pokemonCondition = "빙결";
					}
				}
				break;
			default:
				break;
		}
	}
	
	/**************************************************
	 
	checkAbnormalCondition
	입력: 내 포켓몬 정보, 적 포켓몬 정보, 사용한 스킬 번호, 플레이어 공격인가
	출력: 포켓몬의 상태이상
	
	포켓몬 공격시 속성에 따라 일정 확률로 상태이상을 건다.

	**************************************************/
	private boolean checkAbnormalCondition (MyPokemon myPokemon, EnemyPokemon enemyPokemon, boolean playerAttack)
	{
		// 랜덤숫자를 얻기 위한 랜덤 클래스
		Random random = new Random();
		int randomNumber = -1;		// 랜덤 숫자
		boolean canFight = true;	// 마비상태에서 공격할 수 있는가
		
		randomNumber = random.nextInt(100);
		
		if (playerAttack == true)
		{
			switch (myPokemon.pokemonCondition)
			{
				case "화상":
					// 화상에 걸리면 매 턴마다 체력이 2 감속한다.
					myPokemon.pokemonStatus[5] -= 2;
					break;
				case "마비":
					// 마비에 걸리면 40% 확률로 행동을 할 수 없다.
					if (randomNumber >= 40)
					{
						canFight = true;
					}
					else
					{
						canFight = false;
					}
					break;
				case "빙결":
					// 빙결에 걸리면 매 턴마다 체력이 2 감속한다.
					myPokemon.pokemonStatus[5] -= 2;
					break;
				default:
					break;
			}
		}
		else
		{
			switch (enemyPokemon.pokemonCondition)
			{
				case "화상":
					// 화상에 걸리면 매 턴마다 체력이 2 감속한다.
					enemyPokemon.pokemonStatus[5] -= 2;
					break;
				case "마비":
					// 마비에 걸리면 40% 확률로 행동을 할 수 없다.
					if (randomNumber >= 40)
					{
						canFight = true;
					}
					else
					{
						canFight = false;
					}
					break;
				case "빙결":
					// 빙결에 걸리면 매 턴마다 체력이 2 감속한다.
					enemyPokemon.pokemonStatus[5] -= 2;
					break;
				default:
					break;
			}
		}
		
		return canFight;
	}
	
	/**************************************************
	 
	recoveryPokemon
	입력: 내 포켓몬 정보
	출력: 포켓몬의 상태
	
	배틀중에 포켓몬을 회복한다.

	**************************************************/
	private void recoveryPokemon (MyPokemon myPokemon)
	{
		boolean correctName = false;		// 올바른 이름 입력을 판단하는 변수
		String itemName = new String();		// 아이템 이름 입력받을 변수
		
		System.out.printf("\n내가 사용 할 수 있는 회복 아이템\n");
		
		for (int itemIdx = 0; itemIdx < 10; itemIdx++)
		{
			// 인벤에 소지수가 1개 이상인 것을 찾음
			if (Player.item.recoveryAmount[itemIdx] > 0)
			{
				System.out.printf("%s   소지수: %d\n", Player.item.recoveryItemName[itemIdx], Player.item.recoveryAmount[itemIdx]);
			}
		}
		
		while (correctName == false) // 올바른 이름을 입력 받으면 종료
		{
			
			System.out.printf("\n사용할 회복 아이템 이름을 입력하세요.\n");
			System.out.printf("아이템 이름: ");
			try
			{
				itemName = ShareData.scanUserInput.next();
				
				for (int itemIdx = 0; itemIdx < 10; itemIdx++)
				{
					// 인벤에 소지수가 1개 이상인 것을 찾음
					correctName = itemName.equals(Player.item.recoveryItemName[itemIdx]);
					if (correctName == true)
					{
						System.out.printf("%s를 내 포켓몬에게 사용했다.\n", Player.item.recoveryItemName[itemIdx]);
						System.out.printf("체력이 %d만큼 올랐다.\n", Player.item.recoveryValue[itemIdx]);
						Player.item.recoveryAmount[itemIdx]--;
						// 아이템 회복량 만큼 체력을 회복
						myPokemon.pokemonStatus[5] += Player.item.recoveryValue[itemIdx];
						// 체력 최대치를 넘으면 최대치로 고정
						if (myPokemon.pokemonStatus[5] > myPokemon.pokemonStatus[0])
						{
							myPokemon.pokemonStatus[5] = myPokemon.pokemonStatus[0];
						}
						// 상태이상이 걸려있는 상태에서 만병통치약을 사용하면 상태이상을 치료한다.
						if ((myPokemon.pokemonCondition != "정상") && (Player.item.recoveryItemName[itemIdx] == "만병통치약"))
						{
							myPokemon.pokemonCondition = "정상";
						}
						System.out.printf("************************************************************\n");
						break;
					}
				}
			}
			catch (InputMismatchException ErrorInput)
			{
				System.out.printf("************************************************************\n");
				System.out.println("잘못된 입력입니다.\n다시 입력 해주세요.\n");
				System.out.printf("************************************************************\n");
			}

			if (correctName == false)
			{
				System.out.printf("************************************************************\n");
				System.out.println("잘못된 입력입니다.\n다시 입력 해주세요.\n");
				System.out.printf("************************************************************\n");
				continue;
			}
		}
	}
	
	/**************************************************
	 
	run
	배틀 스레드의 기능을 수행하는 메소드

	**************************************************/
	public void run() 
	{
		boolean isPlayer = false;
		
    	for (int idx = 0; idx < ShareData.threadNames.size(); idx++)
    	{
    		System.out.printf("thread %s\n", ShareData.threadNames.get(idx));
    		if (ShareData.threadNames.get(idx) == "BattleThread")
    		{
    			System.out.printf("Is My battle thread %s\n", ShareData.threadNames.get(idx));
    			isPlayer = true;
    		}
    	}
    	
    	// 플레이어 배틀 thread
		if (isPlayer == true)
		{
			System.out.printf("player thread\n");
		}
		else
		{
			System.out.printf("enemy thread\n");
		}
		
		// 게임이 끝나기 전까지 스레드는 계속 동작한다. 게임이 클리어 조건이 되면 스레드가 종료된다.
		while (ShareData.isGameOver == false)
		{
	        // 사용자가 배틀을 선택해서 메틀 메뉴로 들어온다.
	        if (ShareData.enterBattleMenu == true)
	        {
	        	//ShareData.Threads.get(0)
	        	this.pokemonBattleMenu (ShareData.myPokemon, ShareData.enemyPokemon);
	        	ShareData.enterBattleMenu = false;
	        }
	        
	        // 데이터 변화를 인식하기 위해 잠시 동작을 멈춘다.
	        try 
	        {
	            Thread.sleep(10);
	        }
	        catch (Exception e) 
	        {
	        	
	        }
		}
	}
}

//End of File
