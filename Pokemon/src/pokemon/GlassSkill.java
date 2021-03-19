

package pokemon;

public class GlassSkill extends PokemonSkill
{
	/**************************************************
	
	setSkill
	�Է�: 
	���: ��ų ���� ����Ʈ ���� ��
	
	Ǯ�Ӽ� ��ų �̸� ����

	**************************************************/
	public void setSkill ()
	{
		this.skillNameList.add("����ä��");		// 0
		this.skillNameList.add("�ٳ�������");		// 1
		this.skillNameList.add("����ź");			// 2
		this.skillNameList.add("��������");		// 3
		this.skillNameList.add("�ֶ��");			// 4
		
		this.skillDamageList.add(45);			// 0
		this.skillDamageList.add(55);			// 1
		this.skillDamageList.add(80);			// 2
		this.skillDamageList.add(130);			// 3
		this.skillDamageList.add(120);			// 4
		
		this.skillCountList.add(25);			// 0
		this.skillCountList.add(25);			// 1
		this.skillCountList.add(15);			// 2
		this.skillCountList.add(5);				// 3
		this.skillCountList.add(10);			// 4
		
		this.skillAccuracyList.add(100);		// 0
		this.skillAccuracyList.add(95);			// 1
		this.skillAccuracyList.add(100);		// 2
		this.skillAccuracyList.add(90);			// 3
		this.skillAccuracyList.add(100);		// 4
	}
	
	/**************************************************
	
	setSkillName
	�Է�: ��ų ��ġ, ����Ʈ�� ��ų�� ��ġ ��
	���: ��ų �̸�
	
	Ǯ�Ӽ� ��ų �̸� ����

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
	
	Ǯ�Ӽ� ��ų ���� ����

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
	
	Ǯ�Ӽ� ��ų Ƚ�� ����

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
	
	Ǯ�Ӽ� ��ų ���߷� ����

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
	
	Ǯ�Ӽ� ��ų �Ӽ� ����

	**************************************************/
	void setSkillType (int[] skillType, int skillPosition)
	{
		// Ǯ�Ӽ����� ����
		skillType[skillPosition] = 2;
	}
}