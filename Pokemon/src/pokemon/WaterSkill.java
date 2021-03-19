

package pokemon;

public class WaterSkill extends PokemonSkill
{
	/**************************************************
	
	setSkill
	입력: 
	출력: 스킬 정보 리스트 저장 값
	
	물속성 스킬 이름 저장

	**************************************************/
	public void setSkill ()
	{
		this.skillNameList.add("물대포");			// 0
		this.skillNameList.add("물의파동");		// 1
		this.skillNameList.add("아쿠아테일");		// 2
		this.skillNameList.add("파도타기");		// 3
		this.skillNameList.add("하이드로펌프");		// 4
		
		this.skillDamageList.add(40);			// 0
		this.skillDamageList.add(60);			// 1
		this.skillDamageList.add(90);			// 2
		this.skillDamageList.add(90);			// 3
		this.skillDamageList.add(110);			// 4
		
		this.skillCountList.add(25);			// 0
		this.skillCountList.add(20);			// 1
		this.skillCountList.add(10);			// 2
		this.skillCountList.add(15);			// 3
		this.skillCountList.add(5);				// 4
		
		this.skillAccuracyList.add(100);		// 0
		this.skillAccuracyList.add(100);		// 1
		this.skillAccuracyList.add(90);			// 2
		this.skillAccuracyList.add(100);		// 3
		this.skillAccuracyList.add(80);			// 4
	}
	
	/**************************************************
	
	setSkillName
	입력: 스킬 위치, 리스트의 스킬명 위치 값
	출력: 스킬 이름
	
	물속성 스킬 이름 저장

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
	
	물속성 스킬 위력 저장

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
	
	물속성 스킬 횟수 저장

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
	
	물속성 스킬 명중률 저장

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
	
	물속성 스킬 속성 저장

	**************************************************/
	void setSkillType (int[] skillType, int skillPosition)
	{
		// 물속성으로 저장
		skillType[skillPosition] = 3;
	}
}