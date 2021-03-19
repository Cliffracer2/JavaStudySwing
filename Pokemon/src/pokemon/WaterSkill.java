

package pokemon;

public class WaterSkill extends PokemonSkill
{
	/**************************************************
	
	setSkill
	�Է�: 
	���: ��ų ���� ����Ʈ ���� ��
	
	���Ӽ� ��ų �̸� ����

	**************************************************/
	public void setSkill ()
	{
		this.skillNameList.add("������");			// 0
		this.skillNameList.add("�����ĵ�");		// 1
		this.skillNameList.add("���������");		// 2
		this.skillNameList.add("�ĵ�Ÿ��");		// 3
		this.skillNameList.add("���̵������");		// 4
		
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
	�Է�: ��ų ��ġ, ����Ʈ�� ��ų�� ��ġ ��
	���: ��ų �̸�
	
	���Ӽ� ��ų �̸� ����

	**************************************************/
	void setSkillName (String[] skillName, int skillPosition, int skillIndex)
	{	
		// ���ϸ��� ��ų ������ �ҷ��´�.
		setSkill();
		
		// SkillPosition �ڸ���  SkillIndex���� ��ų�� ������.
		skillName[skillPosition] = skillNameList.get(skillIndex);
	}
	
	/**************************************************
	
	setSkillDamage
	�Է�: ��ų ��ġ, ����Ʈ�� ��ų�� ��ġ ��
	���: ��ų ����
	
	���Ӽ� ��ų ���� ����

	**************************************************/
	void setSkillDamage (int[] skillDamage, int skillPosition, int skillIndex)
	{
		// ���ϸ��� ��ų ������ �ҷ��´�.
		setSkill();
		
		// SkillPosition �ڸ���  SkillIndex���� ��ų�� ������.
		skillDamage[skillPosition] = skillDamageList.get(skillIndex);
	}
	
	/**************************************************
	
	setSkillCount
	�Է�: ��ų ��ġ, ����Ʈ�� ��ų�� ��ġ ��
	���: ��ų Ƚ��
	
	���Ӽ� ��ų Ƚ�� ����

	**************************************************/
	void setSkillCount (int[] skillCount, int skillPosition, int skillIndex)
	{
		// ���ϸ��� ��ų ������ �ҷ��´�.
		setSkill();
		
		// SkillPosition �ڸ���  SkillIndex���� ��ų�� ������.
		skillCount[skillPosition] = skillCountList.get(skillIndex);
	}
	
	/**************************************************
	
	setSkillAccuracy
	�Է�: ��ų ��ġ, ����Ʈ�� ��ų�� ��ġ ��
	���: ��ų Ƚ��
	
	���Ӽ� ��ų ���߷� ����

	**************************************************/
	void setSkillAccuracy (int[] skillAccuracy, int skillPosition, int skillIndex)
	{
		// ���ϸ��� ��ų ������ �ҷ��´�.
		setSkill();
		
		// SkillPosition �ڸ���  SkillIndex���� ��ų�� ������.
		skillAccuracy[skillPosition] = skillAccuracyList.get(skillIndex);
	}
	
	/**************************************************
	
	setSkillType
	�Է�: ��ų ��ġ
	���: ��ų �Ӽ�
	
	���Ӽ� ��ų �Ӽ� ����

	**************************************************/
	void setSkillType (int[] skillType, int skillPosition)
	{
		// ���Ӽ����� ����
		skillType[skillPosition] = 3;
	}
}