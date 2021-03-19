/**************************************************
 
���� Ŭ����

**************************************************/

package pokemon;

import java.util.InputMismatchException;

public class Market implements Runnable 
{
	String[] marketItem = new String[10];		// ���� ������ ���
	int[] familiarityPrice = new int[10];		// ģ�е� ������ ����
	int[] recoveryPrice = new int[10];			// ȸ�� ������ ����
	
	int[] familiaritySellPrice = new int[10];	// ģ�е� ������ �Ǹ� ����
	int[] recoverySellPrice = new int[10];		// ȸ�� ������ �Ǹ� ����
	
	public Market ()
	{
		
	}
	
	/**************************************************
	 
	setItemPrice
	
	�Է�: ������ ����
	���: ����� ������ ����
	
	ģ�е�, ȸ�� �������� ������ �����Ѵ�.
	�ǸŰ��� ���԰��� �����̴�.

	**************************************************/
	void setItemPrice ()
	{
		familiarityPrice[0] = 100;
		familiarityPrice[1] = 150;
		familiarityPrice[2] = 200;
		familiarityPrice[3] = 250;
		familiarityPrice[4] = 400;
		
		familiaritySellPrice[0] = (familiarityPrice[0] / 2);
		familiaritySellPrice[1] = (familiarityPrice[1] / 2);
		familiaritySellPrice[2] = (familiarityPrice[2] / 2);
		familiaritySellPrice[3] = (familiarityPrice[3] / 2);
		familiaritySellPrice[4] = (familiarityPrice[4] / 2);
		
		recoveryPrice[0] = 50;
		recoveryPrice[1] = 100;
		recoveryPrice[2] = 150;
		recoveryPrice[3] = 500;
		recoveryPrice[4] = 100;
		
		recoverySellPrice[0] = (recoveryPrice[0] / 2);
		recoverySellPrice[1] = (recoveryPrice[1] / 2);
		recoverySellPrice[2] = (recoveryPrice[2] / 2);
		recoverySellPrice[3] = (recoveryPrice[3] / 2);
		recoverySellPrice[4] = (recoveryPrice[4] / 2);
	}
	
	/**************************************************
	 
	showItemList
	
	�Է�: ������ ����
	���: ������ �̸�, ������ �ַܼ� ���
	
	������ �Ǹ��ϴ� �����۰� ������ ǥ���Ѵ�.

	**************************************************/
	void showItemList (Item item)
	{
		// ���� ������ �ҷ��´�.
		//this.SetItemPrice();
		
		System.out.printf("************************************************************\n");
		System.out.printf("ģ�е� ������\n");
		for (int itemIdx = 0; itemIdx < 5; itemIdx++)
		{
			System.out.printf("%d. %s    ����: %d\n", (itemIdx + 1), item.familiarityItemName[itemIdx], familiarityPrice[itemIdx]);
		}
		
		System.out.printf("\n************************************************************\n");
		System.out.printf("ȸ�� ������\n");
		for (int itemIdx = 0; itemIdx < 5; itemIdx++)
		{
			System.out.printf("%d. %s    ����: %d\n", (itemIdx + 1), item.recoveryItemName[itemIdx], recoveryPrice[itemIdx]);
		}
	}
	
	/**************************************************
	 
	completeBuyItem
	
	�Է�: ������ �Է��ϴ� ��ȣ, ������ ����, �÷��̾� ����, ������ Ÿ�� ��ȣ, �ƾ��� ��ȣ
	���: ������ ������ ��ȣ
	
	���� ���� ������ �Է��ϰ� �������� �����Ѵ�.

	**************************************************/
	boolean completeBuyItem (int itemType, int itemNumber)
	{
		int selectAmount = -1;				// ���� ���� ����
		int finalSelectDeal = -1;			// ���� ���� ����
		boolean completeDeal = false;		// ���� �ŷ� �Ϸ� Ȯ��
		boolean finalSelectBuy = false;		// ���� ���� ����
		
		// ���� ������ �Է��ϰ� Ȯ��
		FirstLoop: while (completeDeal == false)
		{
			System.out.printf("��� �����Ͻðڽ��ϱ�??\n");
			System.out.printf("������ ���� �Է�: \n");
			
			try // ���ڸ� �Է� �޴��� Ȯ��
			{
				selectAmount = ShareData.scanUserInput.nextInt();
			}
			catch (InputMismatchException ErrorInput) // ���ڰ� �ƴ� ���ڸ� �Է� �� ��� ���� �޽��� ���
			{
				System.out.printf("************************************************************\n");
				System.out.println("�߸��� ���� �Է��Դϴ�.\n�ٽ� �Է� ���ּ���.\n");
				System.out.printf("************************************************************\n");
				continue;
			}
			
			if ((selectAmount <= 0) || (selectAmount >= 1000))
			{
				System.out.printf("************************************************************\n");
				System.out.println("�߸��� ���� �Է��Դϴ�.\n�ٽ� �Է� ���ּ���.\n");
				System.out.printf("************************************************************\n");
				continue;
			}
			
			// ģ�е� ������
			if (itemType == 1)
			{
				System.out.printf("\n���� ��: %d �� ����: %d ������: %d\n", selectAmount, (familiarityPrice[itemNumber - 1] * selectAmount), Player.currentMoney);
				
				if ((familiarityPrice[itemNumber - 1] * selectAmount) > Player.currentMoney)
				{
					System.out.printf("���Ծ��� �������� �ʰ� �մϴ�. �ٽ� �Է� ���ּ���.\n");
					continue;
				}
			}
			else // ȸ�� ������
			{
				System.out.printf("\n���� ��: %d �� ����: %d ������: %d\n", selectAmount, (recoveryPrice[itemNumber - 1] * selectAmount), Player.currentMoney);
				
				if ((recoveryPrice[itemNumber - 1] * selectAmount) > Player.currentMoney)
				{
					System.out.printf("���Ծ��� �������� �ʰ� �մϴ�. �ٽ� �Է� ���ּ���.\n");
					continue;
				}
			}
			
			while (finalSelectBuy == false)
			{
				System.out.printf("���� �����Ͻðڽ���?\n");
				System.out.printf("1. �����Ѵ�.\n");
				System.out.printf("2. �ٽ� �����Ѵ�.\n");
				System.out.printf("��ȣ ����: ");
				try // ���ڸ� �Է� �޴��� Ȯ��
				{
					finalSelectDeal = ShareData.scanUserInput.nextInt();
					// �ٽ� �����Ѵ� ����
					if (finalSelectDeal == 2)
					{
						// ���� ���� ���� �ٽ� ����
						continue FirstLoop;
					}
				}
				catch (InputMismatchException ErrorInput) // ���ڰ� �ƴ� ���ڸ� �Է� �� ��� ���� �޽��� ���
				{
					System.out.printf("************************************************************\n");
					System.out.println("�߸��� ���� �Է��Դϴ�.\n�ٽ� �Է� ���ּ���.\n");
					System.out.printf("************************************************************\n");
					continue;
				}
				
				if ((finalSelectDeal <= 0) || (finalSelectDeal >= 3))
				{
					System.out.printf("************************************************************\n");
					System.out.println("�߸��� ���� �Է��Դϴ�.\n�ٽ� �Է� ���ּ���.\n");
					System.out.printf("************************************************************\n");
					continue;
				}
				
				// ���� ���� ����
				if (finalSelectDeal == 1)
				{
					System.out.printf("�����մϴ�. ���� ��ǰ�� �ֽ��ϴ�.\n");
					if (itemType == 1)
					{
						Player.item.storeItem(Player.item.familiarityItemName[itemNumber - 1], 0, selectAmount);
						Player.currentMoney -= (familiarityPrice[itemNumber - 1] * selectAmount);
					}
					else
					{
						Player.item.storeItem(Player.item.recoveryItemName[itemNumber - 1], 1, selectAmount);
						Player.currentMoney -= (recoveryPrice[itemNumber - 1] * selectAmount);
					}
					
					finalSelectBuy = true;
					completeDeal = true;
					
					System.out.printf("�������� �����ϰ� �������� %d�� �Ǿ����ϴ�.\n", Player.currentMoney);
					Player.displayItemInfo ();
				}
			}
		}
		
		return completeDeal;
	}
	
	/**************************************************
	 
	confirmBuyItem
	
	�Է�: ������ �Է��ϴ� ��ȣ, ������ ����, �÷��̾� ����, ������ Ÿ�� ��ȣ, �ƾ��� ��ȣ
	���: ������ ������ ��ȣ
	
	������ ������ ���Կ��θ� Ȯ���Ѵ�.

	**************************************************/
	boolean confirmBuyItem (Item item, int itemType, int itemNumber)
	{
		int confirmDeal = -1;			// ���� Ȯ�� ��ȣ
		boolean selectBuy = false;		// ������ ���� ���� Ȯ��
		
		// ������ ���� Ȯ��
		while (selectBuy == false)
		{
			// ģ�е� ������
			if (itemType == 1)
			{
				System.out.printf("%s�� �����Ͻðڽ��ϱ�? ������ %d�Դϴ�.\n", item.familiarityItemName[itemNumber - 1], familiarityPrice[itemNumber - 1]);
				System.out.printf("1. �����Ѵ�.\n");
				System.out.printf("2. �ٽ� �����Ѵ�.\n");
				System.out.printf("��ȣ ����: ");
				try // ���ڸ� �Է� �޴��� Ȯ��
				{
					confirmDeal = ShareData.scanUserInput.nextInt();
					// �ٽ� �����Ѵ� ����
					if (confirmDeal == 2)
					{
						break;
					}
				}
				catch (InputMismatchException ErrorInput) // ���ڰ� �ƴ� ���ڸ� �Է� �� ��� ���� �޽��� ���
				{
					System.out.printf("************************************************************\n");
					System.out.println("�߸��� ���� �Է��Դϴ�.\n�ٽ� �Է� ���ּ���.\n");
					System.out.printf("************************************************************\n");
					continue;
				}
				
				if ((confirmDeal <= 0) || (confirmDeal >= 3))
				{
					System.out.printf("************************************************************\n");
					System.out.println("�߸��� ���� �Է��Դϴ�.\n�ٽ� �Է� ���ּ���.\n");
					System.out.printf("************************************************************\n");
					continue;
				}
				
				//CompleteDeal = true;
			}
			else // ȸ�� ������
			{
				System.out.printf("%s�� �����Ͻðڽ��ϱ�? ������ %d�Դϴ�.\n", item.recoveryItemName[itemNumber - 1], recoveryPrice[itemNumber - 1]);
				System.out.printf("1. �����Ѵ�.\n");
				System.out.printf("2. �ٽ� �����Ѵ�.\n");
				System.out.printf("��ȣ ����: ");
				
				try // ���ڸ� �Է� �޴��� Ȯ��
				{
					confirmDeal = ShareData.scanUserInput.nextInt();
					// �ٽ� �����Ѵ� ����
					if (confirmDeal == 2)
					{
						break;
					}
				}
				catch (InputMismatchException ErrorInput) // ���ڰ� �ƴ� ���ڸ� �Է� �� ��� ���� �޽��� ���
				{
					System.out.printf("************************************************************\n");
					System.out.println("�߸��� ���� �Է��Դϴ�.\n�ٽ� �Է� ���ּ���.\n");
					System.out.printf("************************************************************\n");
					continue;
				}
				
				if ((confirmDeal <= 0) || (confirmDeal >= 3))
				{
					System.out.printf("************************************************************\n");
					System.out.println("�߸��� ���� �Է��Դϴ�.\n�ٽ� �Է� ���ּ���.\n");
					System.out.printf("************************************************************\n");
					continue;
				}
			}
			
			selectBuy = this.completeBuyItem (itemType, itemNumber);
		}
		
		return selectBuy;
	}
	
	/**************************************************
	 
	selectItemNumber
	
	�Է�: ������ �Է��ϴ� ��ȣ, ������ ����, �÷��̾� ����, ������ Ÿ�� ��ȣ
	���: ������ ������ ��ȣ
	
	ģ�е� �����۰�, ȸ�� ������ �߿��� ������ �������� �����Ѵ�.

	**************************************************/
	boolean selectItemNumber (Item item, int itemType)
	{
		int itemNumber = -1;				// ������ ������ ��ȣ
		boolean buyItemNumber = false;		// ������ ���� Ȯ��
		
		// ���� ������ ǥ��
		//this.ShowItemList (Item);
		
		// ģ�е� ������, ȸ�� ������ �� �����ϸ� �������� �����Ѵ�.
		while (buyItemNumber == false)
		{
			// ģ�е� ������
			if (itemType == 1)
			{
				System.out.printf("************************************************************\n");
				System.out.printf("ģ�е� ������\n");
				for (int ItemIdx = 0; ItemIdx < 5; ItemIdx++)
				{
					System.out.printf("%d. %s    ����: %d ģ�е� ��·�: %d\n", (ItemIdx + 1), item.familiarityItemName[ItemIdx], familiarityPrice[ItemIdx], item.familiarityValue[ItemIdx]);
				}
			}
			else // ȸ�� ������
			{
				System.out.printf("\n************************************************************\n");
				System.out.printf("ȸ�� ������\n");
				for (int itemIdx = 0; itemIdx < 5; itemIdx++)
				{
					if (item.recoveryItemName[itemIdx] == "������ġ��")
					{
						System.out.printf("%d. %s    ����: %d ȸ����: %d + �����̻� ġ��\n", (itemIdx + 1), item.recoveryItemName[itemIdx], recoveryPrice[itemIdx], item.recoveryValue[itemIdx]);
					}
					else
					{
						System.out.printf("%d. %s    ����: %d ȸ����: %d\n", (itemIdx + 1), item.recoveryItemName[itemIdx], recoveryPrice[itemIdx], item.recoveryValue[itemIdx]);
					}
					
				}
			}
			
			System.out.printf("6. ���ư���.\n");
			System.out.printf("************************************************************\n");
			System.out.printf("������ ������ ��ȣ �Է�: ");
			try // ���ڸ� �Է� �޴��� Ȯ��
			{
				itemNumber = ShareData.scanUserInput.nextInt();
				// ���ư��� ����. �ٽ� 1��° ���� �޴��� ���ư���.
				if (itemNumber == 6)
				{
					break;
				}
			}
			catch (InputMismatchException ErrorInput) // ���ڰ� �ƴ� ���ڸ� �Է� �� ��� ���� �޽��� ���
			{
				System.out.printf("************************************************************\n");
				System.out.println("�߸��� ���� �Է��Դϴ�.\n�ٽ� �Է� ���ּ���.\n");
				System.out.printf("************************************************************\n");
				continue;
			}
			
			if ((itemNumber <= 0) || (itemNumber >= 7))
			{
				System.out.printf("************************************************************\n");
				System.out.println("�߸��� ���� �Է��Դϴ�.\n�ٽ� �Է� ���ּ���.\n");
				System.out.printf("************************************************************\n");
				continue;
			}
			
			buyItemNumber = this.confirmBuyItem (item, itemType, itemNumber);
		}
		
		return buyItemNumber;
	}
	
	/**************************************************
	 
	buyItems
	
	�Է�: ������ �Է��ϴ� ��ȣ, ������ ����, �÷��̾� ����
	���: ������ ����
	
	�������� �������� �����ϴ� ����� �����Ѵ�.

	**************************************************/
	void buyItems (Item item)
	{
		int receiveNumber = -1;			// ����ڰ� �Է��ϴ� ����
		boolean selectType = false;		// ������ Ÿ�� ���� Ȯ��
		
		// ģ�е� ������, ȸ�� ������ �� �����Ѵ�.
		while (selectType == false)
		{
			System.out.printf("************************************************************\n");
			System.out.printf("1. ģ�е� ������ ����\n");
			System.out.printf("2. ȸ�� ������ ����\n");
			System.out.printf("3. �׳� ���ư���.\n\n");
			System.out.printf("������ ������ Ÿ�� ��ȣ �Է�: ");
			try // ���ڸ� �Է� �޴��� Ȯ��
			{
				receiveNumber = ShareData.scanUserInput.nextInt();
				// ���ư��� ����
				if (receiveNumber == 3)
				{
					break;
				}
			}
			catch (InputMismatchException ErrorInput) // ���ڰ� �ƴ� ���ڸ� �Է� �� ��� ���� �޽��� ���
			{
				System.out.printf("************************************************************\n");
				System.out.println("�߸��� ���� �Է��Դϴ�.\n�ٽ� �Է� ���ּ���.\n");
				System.out.printf("************************************************************\n");
				continue;
			}
			
			if ((receiveNumber <= 0) || (receiveNumber >= 4))
			{
				System.out.printf("************************************************************\n");
				System.out.println("�߸��� ���� �Է��Դϴ�.\n�ٽ� �Է� ���ּ���.\n");
				System.out.printf("************************************************************\n");
				continue;
			}
			
			selectType = this.selectItemNumber (item, receiveNumber);
		}
	}
	
	/**************************************************
	 
	completeSellItem
	
	�Է�: ������ �Է��ϴ� ��ȣ, �÷��̾� ����, ������ Ÿ�� ��ȣ, �ƾ��� ��ȣ
	���: ������ ������ ��ȣ
	
	���� �Ǹ� ������ �Է��ϰ� Ȯ�����Ͽ� �������� �Ǹ��Ѵ�.

	**************************************************/
	boolean completeSellItem (int itemType, int itemNumber)
	{
		int selectAmount = -1;				// �Ǹ� ���� ����
		int finalSelectDeal = -1;			// ���� �Ǹ� ����
		boolean completeDeal = false;		// ���� �ŷ� �Ϸ� Ȯ��
		boolean finalSelectSell = false;	// ���� �Ǹ� ���� Ȯ��
		
		// ���� ������ �Է��ϰ� Ȯ��
		FirstLoop: while (completeDeal == false)
		{
			
			System.out.printf("��� �Ǹ��Ͻðڽ��ϱ�??\n");
			System.out.printf("0. �ٽ� �����ϱ�\n");
			// ģ�е� ������
			if (itemType == 1)
			{
				System.out.printf("���� ��: %d\n", Player.item.familiarityAmount[itemNumber - 1]);
			}
			else // ȸ�� ������
			{
				System.out.printf("���� ��: %d\n", Player.item.recoveryAmount[itemNumber - 1]);
			}
			System.out.printf("�Ǹ��� ���� �Է�: \n");
			
			try // ���ڸ� �Է� �޴��� Ȯ��
			{
				selectAmount = ShareData.scanUserInput.nextInt();
				if (selectAmount <= 0)
				{
					// ���� �޴��� �ǵ��� ����.
					break;
				}
			}
			catch (InputMismatchException ErrorInput) // ���ڰ� �ƴ� ���ڸ� �Է� �� ��� ���� �޽��� ���
			{
				System.out.printf("************************************************************\n");
				System.out.println("�߸��� ���� �Է��Դϴ�.\n�ٽ� �Է� ���ּ���.\n");
				System.out.printf("************************************************************\n");
				continue;
			}
			
			// ģ�е� ������
			if (itemType == 1)
			{
				// ���������� ���� ���� �Է�
				if (Player.item.familiarityAmount[itemNumber - 1] < selectAmount)
				{
					System.out.printf("************************************************************\n");
					System.out.println("�߸��� ���� �Է��Դϴ�.\n�ٽ� �Է� ���ּ���.\n");
					System.out.printf("************************************************************\n");
					continue;
				}
			}
			else // ȸ�� ������
			{
				// ���������� ���� ���� �Է�
				if (Player.item.recoveryAmount[itemNumber - 1] < selectAmount)
				{
					System.out.printf("************************************************************\n");
					System.out.println("�߸��� ���� �Է��Դϴ�.\n�ٽ� �Է� ���ּ���.\n");
					System.out.printf("************************************************************\n");
					continue;
				}
			}
			
			// ģ�е� ������
			if (itemType == 1)
			{
				System.out.printf("\n�Ǹ� ��: %d �� ����: %d ������: %d\n", selectAmount, (familiaritySellPrice[itemNumber - 1] * selectAmount), Player.currentMoney);
			}
			else // ȸ�� ������
			{
				System.out.printf("\n�Ǹ� ��: %d �� ����: %d ������: %d\n", selectAmount, (recoverySellPrice[itemNumber - 1] * selectAmount), Player.currentMoney);
			}
			
			while (finalSelectSell == false)
			{
				System.out.printf("���� �Ǹ��Ͻðڽ���?\n");
				System.out.printf("1. �Ǹ��Ѵ�.\n");
				System.out.printf("2. �ٽ� �����Ѵ�.\n");
				System.out.printf("��ȣ ����: ");
				try // ���ڸ� �Է� �޴��� Ȯ��
				{
					finalSelectDeal = ShareData.scanUserInput.nextInt();
					// �ٽ� �����Ѵ� ����
					if (finalSelectDeal == 2)
					{
						// ���� ���� ���� �ٽ� ����
						continue FirstLoop;
					}
				}
				catch (InputMismatchException ErrorInput) // ���ڰ� �ƴ� ���ڸ� �Է� �� ��� ���� �޽��� ���
				{
					System.out.printf("************************************************************\n");
					System.out.println("�߸��� ���� �Է��Դϴ�.\n�ٽ� �Է� ���ּ���.\n");
					System.out.printf("************************************************************\n");
					continue;
				}
				
				if ((finalSelectDeal <= 0) || (finalSelectDeal >= 3))
				{
					System.out.printf("************************************************************\n");
					System.out.println("�߸��� ���� �Է��Դϴ�.\n�ٽ� �Է� ���ּ���.\n");
					System.out.printf("************************************************************\n");
					continue;
				}
				
				// ���� ���� ����
				if (finalSelectDeal == 1)
				{
					if (itemType == 1)
					{
						// �Ǹ��� �� ��ŭ ������ ����
						Player.item.familiarityAmount[itemNumber - 1] -= selectAmount;
						Player.currentMoney += (familiaritySellPrice[itemNumber - 1] * selectAmount);
						System.out.printf("�����մϴ�. ���� �Ǹ� �ݾ� %d �Դϴ�.\n", (familiaritySellPrice[itemNumber - 1] * selectAmount));
					}
					else
					{
						// �Ǹ��� �� ��ŭ ������ ����
						Player.item.recoveryAmount[itemNumber - 1] -= selectAmount;
						Player.currentMoney += (recoverySellPrice[itemNumber - 1] * selectAmount);
						System.out.printf("�����մϴ�. ���� �Ǹ� �ݾ� %d �Դϴ�.\n", (recoverySellPrice[itemNumber - 1] * selectAmount));
					}

					finalSelectSell = true;
					completeDeal = true;
					
					System.out.printf("�������� �Ǹ��ϰ� �������� %d�� �Ǿ����ϴ�.\n", Player.currentMoney);
					Player.displayItemInfo ();
				}
			}
		}
		
		return completeDeal;
	}
	
	/**************************************************
	 
	confirmSellItem
	
	�Է�: ������ �Է��ϴ� ��ȣ, �÷��̾� ����, ������ Ÿ�� ��ȣ, �ƾ��� ��ȣ
	���: ������ ������ ��ȣ
	
	������ ������ �Ǹſ��θ� Ȯ���Ѵ�.

	**************************************************/
	boolean confirmSellItem (int itemType, int itemNumber)
	{
		int confirmDeal = -1;			// ���� Ȯ�� ��ȣ
		boolean selectSell = false;		// ������ ���� ���� Ȯ��
		
		// ������ ���� Ȯ��
		while (selectSell == false)
		{
			// ģ�е� ������
			if (itemType == 1)
			{
				System.out.printf("%s�� �Ǹ��Ͻðڽ��ϱ�? ������ %d�Դϴ�.\n", Player.item.familiarityItemName[itemNumber - 1], familiaritySellPrice[itemNumber - 1]);
				System.out.printf("1. �Ǹ��Ѵ�.\n");
				System.out.printf("2. �ٽ� �����Ѵ�.\n");
				System.out.printf("��ȣ ����: ");
				try // ���ڸ� �Է� �޴��� Ȯ��
				{
					confirmDeal = ShareData.scanUserInput.nextInt();
					// �ٽ� �����Ѵ� ����
					if (confirmDeal == 2)
					{
						break;
					}
				}
				catch (InputMismatchException ErrorInput) // ���ڰ� �ƴ� ���ڸ� �Է� �� ��� ���� �޽��� ���
				{
					System.out.printf("************************************************************\n");
					System.out.println("�߸��� ���� �Է��Դϴ�.\n�ٽ� �Է� ���ּ���.\n");
					System.out.printf("************************************************************\n");
					continue;
				}
				
				if ((confirmDeal <= 0) || (confirmDeal >= 3))
				{
					System.out.printf("************************************************************\n");
					System.out.println("�߸��� ���� �Է��Դϴ�.\n�ٽ� �Է� ���ּ���.\n");
					System.out.printf("************************************************************\n");
					continue;
				}
				
				//CompleteDeal = true;
			}
			else // ȸ�� ������
			{
				System.out.printf("%s�� �Ǹ��Ͻðڽ��ϱ�? ������ %d�Դϴ�.\n", Player.item.recoveryItemName[itemNumber - 1], recoverySellPrice[itemNumber - 1]);
				System.out.printf("1. �Ǹ��Ѵ�.\n");
				System.out.printf("2. �ٽ� �����Ѵ�.\n");
				System.out.printf("��ȣ ����: ");
				
				try // ���ڸ� �Է� �޴��� Ȯ��
				{
					confirmDeal = ShareData.scanUserInput.nextInt();
					// �ٽ� �����Ѵ� ����
					if (confirmDeal == 2)
					{
						break;
					}
				}
				catch (InputMismatchException ErrorInput) // ���ڰ� �ƴ� ���ڸ� �Է� �� ��� ���� �޽��� ���
				{
					System.out.printf("************************************************************\n");
					System.out.println("�߸��� ���� �Է��Դϴ�.\n�ٽ� �Է� ���ּ���.\n");
					System.out.printf("************************************************************\n");
					continue;
				}
				
				if ((confirmDeal <= 0) || (confirmDeal >= 3))
				{
					System.out.printf("************************************************************\n");
					System.out.println("�߸��� ���� �Է��Դϴ�.\n�ٽ� �Է� ���ּ���.\n");
					System.out.printf("************************************************************\n");
					continue;
				}
			}
			
			selectSell = this.completeSellItem (itemType, itemNumber);
		}
		
		return selectSell;
	}
	
	/**************************************************
	 
	selectItemNumber
	
	�Է�: ������ �Է��ϴ� ��ȣ, ������ ����, �÷��̾� ����, ������ Ÿ�� ��ȣ
	���: ������ ������ ��ȣ
	
	ģ�е� �����۰�, ȸ�� ������ �߿��� �Ǹ��� �������� �����Ѵ�.

	**************************************************/
	boolean selectItemNumber (int itemType)
	{
		int[] haveItemNumber = new int[10];	// ������ �ִ� ������ ��ȣ ���� 
		int itemNumberIndex = 0;			// ������ ��ȣ �ε��� ��
		int itemNumber = -1;				// �Ǹ��� ������ ��ȣ
		boolean sellItemNumber = false;		// ������ �Ǹ� Ȯ��
		boolean correctNumber = false;		// ������ ��ȣ�� �°� �Է� �ߴ���
		
		// ģ�е� ������, ȸ�� ������ �� �����ϸ� �������� �����Ѵ�.
		while (sellItemNumber == false)
		{
			// ģ�е� ������
			if (itemType == 1)
			{
				System.out.printf("************************************************************\n");
				System.out.printf("ģ�е� ������\n");
				for (int itemIdx = 0; itemIdx < 5; itemIdx++)
				{
					if (Player.item.familiarityAmount[itemIdx] > 0)
					{
						haveItemNumber[itemNumberIndex] = itemIdx + 1;
						System.out.printf("%d. %s    �ǸŰ���: %d\n", (itemNumberIndex + 1), Player.item.familiarityItemName[itemIdx], familiaritySellPrice[itemIdx]);
						itemNumberIndex++;
					}
				}
			}
			else // ȸ�� ������
			{
				System.out.printf("\n************************************************************\n");
				System.out.printf("ȸ�� ������\n");
				for (int itemIdx = 0; itemIdx < 5; itemIdx++)
				{
					if (Player.item.recoveryAmount[itemIdx] > 0)
					{
						haveItemNumber[itemNumberIndex] = itemIdx + 1;
						System.out.printf("%d. %s    �ǸŰ���: %d\n", (itemNumberIndex + 1), Player.item.recoveryItemName[itemIdx], recoverySellPrice[itemIdx]);
						itemNumberIndex++;
					}
				}
			}
			
			System.out.printf("6. ���ư���.\n");
			System.out.printf("************************************************************\n");
			System.out.printf("�Ǹ��� ������ ��ȣ �Է�: ");
			try // ���ڸ� �Է� �޴��� Ȯ��
			{
				itemNumber = ShareData.scanUserInput.nextInt();
				// ���ư��� ����. �ٽ� 1��° ���� �޴��� ���ư���.
				if (itemNumber == 6)
				{
					break;
				}
			}
			catch (InputMismatchException ErrorInput) // ���ڰ� �ƴ� ���ڸ� �Է� �� ��� ���� �޽��� ���
			{
				System.out.printf("************************************************************\n");
				System.out.println("�߸��� ���� �Է��Դϴ�.\n�ٽ� �Է� ���ּ���.\n");
				System.out.printf("************************************************************\n");
				continue;
			}
			
			if ((itemNumber <= 0) || (itemNumber >= 7))
			{
				System.out.printf("************************************************************\n");
				System.out.println("�߸��� ���� �Է��Դϴ�.\n�ٽ� �Է� ���ּ���.\n");
				System.out.printf("************************************************************\n");
				continue;
			}

			// �÷��̾� ������ ����Ʈ�� ���� ������ �������� ���ԵǾ����� Ȯ��
			// ģ�е� ������
			if (itemType == 1)
			{
				if (Player.item.familiarityAmount[(haveItemNumber[itemNumber - 1] - 1)] > 0)
				{
					// �������� ������ ���� ����
					correctNumber = true;
				}
			}
			else
			{
				if (Player.item.recoveryAmount[(haveItemNumber[itemNumber - 1] - 1)] > 0)
				{
					// �������� ������ ���� ����
					correctNumber = true;
				}
			}

			
			// ������ �Ǹ� ���� ����
			if (correctNumber == true)
			{
				sellItemNumber = this.confirmSellItem (itemType, haveItemNumber[itemNumber - 1]);
			}
			else // �ٽ� �Է�
			{
				correctNumber = false;
				System.out.printf("************************************************************\n");
				System.out.println("�߸��� ���� �Է��Դϴ�.\n�ٽ� �Է� ���ּ���.\n");
				System.out.printf("************************************************************\n");
				continue;
			}
		}
		
		return sellItemNumber;
	}
	
	/**************************************************
	 
	sellItems
	
	�Է�: ������ �Է��ϴ� ��ȣ, �÷��̾� ����
	���: ������ ����
	
	�������� �������� �Ǹ��ϴ� ����� �����Ѵ�.

	**************************************************/
	void sellItems ()
	{
		int receiveNumber = -1;			// ����ڰ� �Է��ϴ� ����
		boolean selectType = false;		// ������ Ÿ�� ���� Ȯ��
		
		// �÷��̾� ������ ǥ��
		//this.ShowItemList (Item);
		Player.displayItemInfo();
		
		// ģ�е� ������, ȸ�� ������ �� �����Ѵ�.
		while (selectType == false)
		{
			System.out.printf("************************************************************\n");
			System.out.printf("1. ģ�е� ������ �Ǹ�\n");
			System.out.printf("2. ȸ�� ������ �Ǹ�\n");
			System.out.printf("3. �׳� ���ư���.\n\n");
			System.out.printf("�Ǹ��� ������ Ÿ�� ��ȣ �Է�: ");
			try // ���ڸ� �Է� �޴��� Ȯ��
			{
				receiveNumber = ShareData.scanUserInput.nextInt();
				// ���ư��� ����
				if (receiveNumber == 3)
				{
					break;
				}
			}
			catch (InputMismatchException ErrorInput) // ���ڰ� �ƴ� ���ڸ� �Է� �� ��� ���� �޽��� ���
			{
				System.out.printf("************************************************************\n");
				System.out.println("�߸��� ���� �Է��Դϴ�.\n�ٽ� �Է� ���ּ���.\n");
				System.out.printf("************************************************************\n");
				continue;
			}
			
			if ((receiveNumber <= 0) || (receiveNumber >= 4))
			{
				System.out.printf("************************************************************\n");
				System.out.println("�߸��� ���� �Է��Դϴ�.\n�ٽ� �Է� ���ּ���.\n");
				System.out.printf("************************************************************\n");
				continue;
			}
			
			selectType = this.selectItemNumber (receiveNumber);
		}
	}
	
	/**************************************************
	 
	marketMainMenu
	
	�Է�: ������ �Է��ϴ� ��ȣ, ������ ����, �÷��̾� ����
	���: �÷��̾� ������ ����, ������ ����
	
	������ ���� �޴� ǥ��. �����ϰų� �ǸŸ� ������ �� �ִ�.

	**************************************************/
	void marketMainMenu (Item item)
	{
		int receiveNumber = -1;			// ����ڰ� �Է��ϴ� ����
		boolean selectType = false;		// ������ Ÿ�� ���� Ȯ��
		
		System.out.printf("************************************************************\n");
		System.out.printf("� ������ ���ϸ� ���� �Դϴ�.\n");
		System.out.printf("������ �ѷ� ������.\n");
		
		// ���� ������ �ҷ��´�.
		this.setItemPrice();
		// ������ ������ �ҷ��´�.
		item.initalizeItemList();

		// ģ�е� ������, ȸ�� ������ �� �����Ѵ�.
		while (selectType == false)
		{
			System.out.printf("************************************************************\n");
			System.out.printf("���� ���⼭ ������ �ұ�?\n");
			System.out.printf("1. �������� �����Ѵ�.\n");
			System.out.printf("2. �������� �Ǹ��Ѵ�.\n");
			System.out.printf("3. �׳� ���ư���.\n\n");
			System.out.printf("��ȣ �Է�: ");
			try // ���ڸ� �Է� �޴��� Ȯ��
			{
				receiveNumber = ShareData.scanUserInput.nextInt();
				// ���ư��� ����
				if (receiveNumber == 3)
				{
					break;
				}
			}
			catch (InputMismatchException ErrorInput) // ���ڰ� �ƴ� ���ڸ� �Է� �� ��� ���� �޽��� ���
			{
				System.out.printf("************************************************************\n");
				System.out.println("�߸��� ���� �Է��Դϴ�.\n�ٽ� �Է� ���ּ���.\n");
				System.out.printf("************************************************************\n");
				continue;
			}
			
			if ((receiveNumber <= 0) || (receiveNumber >= 4))
			{
				System.out.printf("************************************************************\n");
				System.out.println("�߸��� ���� �Է��Դϴ�.\n�ٽ� �Է� ���ּ���.\n");
				System.out.printf("************************************************************\n");
				continue;
			}
			
			// �������� �����Ѵ�.
			if (receiveNumber == 1)
			{
				this.buyItems (item);
			}
			else // �������� �Ǹ��Ѵ�.
			{
				this.sellItems ();
			}
		}
	}
	
	public void run() 
	{
		
	}
}

//End of File
