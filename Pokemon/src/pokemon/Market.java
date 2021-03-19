/**************************************************
 
상점 클래스

**************************************************/

package pokemon;

import java.util.InputMismatchException;

public class Market implements Runnable 
{
	String[] marketItem = new String[10];		// 상점 아이템 목록
	int[] familiarityPrice = new int[10];		// 친밀도 아이템 가격
	int[] recoveryPrice = new int[10];			// 회복 아이템 가격
	
	int[] familiaritySellPrice = new int[10];	// 친밀도 아이템 판매 가격
	int[] recoverySellPrice = new int[10];		// 회복 아이템 판매 가격
	
	public Market ()
	{
		
	}
	
	/**************************************************
	 
	setItemPrice
	
	입력: 아이템 가격
	출력: 저장된 아이템 가격
	
	친밀도, 회복 아이템의 가격을 설정한다.
	판매가는 구입가의 절반이다.

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
	
	입력: 아이템 정보
	출력: 아이템 이름, 가격을 콘솔로 출력
	
	상점에 판매하는 아이템과 가격을 표시한다.

	**************************************************/
	void showItemList (Item item)
	{
		// 가격 정보를 불러온다.
		//this.SetItemPrice();
		
		System.out.printf("************************************************************\n");
		System.out.printf("친밀도 아이템\n");
		for (int itemIdx = 0; itemIdx < 5; itemIdx++)
		{
			System.out.printf("%d. %s    가격: %d\n", (itemIdx + 1), item.familiarityItemName[itemIdx], familiarityPrice[itemIdx]);
		}
		
		System.out.printf("\n************************************************************\n");
		System.out.printf("회복 아이템\n");
		for (int itemIdx = 0; itemIdx < 5; itemIdx++)
		{
			System.out.printf("%d. %s    가격: %d\n", (itemIdx + 1), item.recoveryItemName[itemIdx], recoveryPrice[itemIdx]);
		}
	}
	
	/**************************************************
	 
	completeBuyItem
	
	입력: 유저가 입력하는 번호, 아이템 정보, 플레이어 정보, 아이템 타입 번호, 아아템 번호
	출력: 유저가 선택한 번호
	
	최종 구입 수량을 입력하고 아이템을 구입한다.

	**************************************************/
	boolean completeBuyItem (int itemType, int itemNumber)
	{
		int selectAmount = -1;				// 구입 수량 결정
		int finalSelectDeal = -1;			// 최종 구입 선택
		boolean completeDeal = false;		// 최종 거래 완료 확인
		boolean finalSelectBuy = false;		// 최종 구입 선택
		
		// 구입 수량을 입력하고 확인
		FirstLoop: while (completeDeal == false)
		{
			System.out.printf("몇개를 구입하시겠습니까??\n");
			System.out.printf("구입할 수량 입력: \n");
			
			try // 숫자를 입력 받는지 확인
			{
				selectAmount = ShareData.scanUserInput.nextInt();
			}
			catch (InputMismatchException ErrorInput) // 숫자가 아닌 문자를 입력 한 경우 에러 메시지 출력
			{
				System.out.printf("************************************************************\n");
				System.out.println("잘못된 문자 입력입니다.\n다시 입력 해주세요.\n");
				System.out.printf("************************************************************\n");
				continue;
			}
			
			if ((selectAmount <= 0) || (selectAmount >= 1000))
			{
				System.out.printf("************************************************************\n");
				System.out.println("잘못된 숫자 입력입니다.\n다시 입력 해주세요.\n");
				System.out.printf("************************************************************\n");
				continue;
			}
			
			// 친밀도 아이템
			if (itemType == 1)
			{
				System.out.printf("\n구입 수: %d 총 가격: %d 소지금: %d\n", selectAmount, (familiarityPrice[itemNumber - 1] * selectAmount), Player.currentMoney);
				
				if ((familiarityPrice[itemNumber - 1] * selectAmount) > Player.currentMoney)
				{
					System.out.printf("구입액이 소지금을 초과 합니다. 다시 입력 해주세요.\n");
					continue;
				}
			}
			else // 회복 아이템
			{
				System.out.printf("\n구입 수: %d 총 가격: %d 소지금: %d\n", selectAmount, (recoveryPrice[itemNumber - 1] * selectAmount), Player.currentMoney);
				
				if ((recoveryPrice[itemNumber - 1] * selectAmount) > Player.currentMoney)
				{
					System.out.printf("구입액이 소지금을 초과 합니다. 다시 입력 해주세요.\n");
					continue;
				}
			}
			
			while (finalSelectBuy == false)
			{
				System.out.printf("정말 구입하시겠습까?\n");
				System.out.printf("1. 구입한다.\n");
				System.out.printf("2. 다시 생각한다.\n");
				System.out.printf("번호 선택: ");
				try // 숫자를 입력 받는지 확인
				{
					finalSelectDeal = ShareData.scanUserInput.nextInt();
					// 다시 생각한다 선택
					if (finalSelectDeal == 2)
					{
						// 구입 수량 부터 다시 선택
						continue FirstLoop;
					}
				}
				catch (InputMismatchException ErrorInput) // 숫자가 아닌 문자를 입력 한 경우 에러 메시지 출력
				{
					System.out.printf("************************************************************\n");
					System.out.println("잘못된 문자 입력입니다.\n다시 입력 해주세요.\n");
					System.out.printf("************************************************************\n");
					continue;
				}
				
				if ((finalSelectDeal <= 0) || (finalSelectDeal >= 3))
				{
					System.out.printf("************************************************************\n");
					System.out.println("잘못된 숫자 입력입니다.\n다시 입력 해주세요.\n");
					System.out.printf("************************************************************\n");
					continue;
				}
				
				// 최종 구입 선택
				if (finalSelectDeal == 1)
				{
					System.out.printf("감사합니다. 여기 상품이 있습니다.\n");
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
					
					System.out.printf("아이템을 구입하고 소지금이 %d가 되었습니다.\n", Player.currentMoney);
					Player.displayItemInfo ();
				}
			}
		}
		
		return completeDeal;
	}
	
	/**************************************************
	 
	confirmBuyItem
	
	입력: 유저가 입력하는 번호, 아이템 정보, 플레이어 정보, 아이템 타입 번호, 아아템 번호
	출력: 유저가 선택한 번호
	
	선택한 아이템 구입여부를 확인한다.

	**************************************************/
	boolean confirmBuyItem (Item item, int itemType, int itemNumber)
	{
		int confirmDeal = -1;			// 구입 확인 번호
		boolean selectBuy = false;		// 아이템 구입 선택 확인
		
		// 아이템 구입 확인
		while (selectBuy == false)
		{
			// 친밀도 아이템
			if (itemType == 1)
			{
				System.out.printf("%s을 구입하시겠습니까? 가격은 %d입니다.\n", item.familiarityItemName[itemNumber - 1], familiarityPrice[itemNumber - 1]);
				System.out.printf("1. 구입한다.\n");
				System.out.printf("2. 다시 생각한다.\n");
				System.out.printf("번호 선택: ");
				try // 숫자를 입력 받는지 확인
				{
					confirmDeal = ShareData.scanUserInput.nextInt();
					// 다시 생각한다 선택
					if (confirmDeal == 2)
					{
						break;
					}
				}
				catch (InputMismatchException ErrorInput) // 숫자가 아닌 문자를 입력 한 경우 에러 메시지 출력
				{
					System.out.printf("************************************************************\n");
					System.out.println("잘못된 문자 입력입니다.\n다시 입력 해주세요.\n");
					System.out.printf("************************************************************\n");
					continue;
				}
				
				if ((confirmDeal <= 0) || (confirmDeal >= 3))
				{
					System.out.printf("************************************************************\n");
					System.out.println("잘못된 숫자 입력입니다.\n다시 입력 해주세요.\n");
					System.out.printf("************************************************************\n");
					continue;
				}
				
				//CompleteDeal = true;
			}
			else // 회복 아이템
			{
				System.out.printf("%s을 구입하시겠습니까? 가격은 %d입니다.\n", item.recoveryItemName[itemNumber - 1], recoveryPrice[itemNumber - 1]);
				System.out.printf("1. 구입한다.\n");
				System.out.printf("2. 다시 생각한다.\n");
				System.out.printf("번호 선택: ");
				
				try // 숫자를 입력 받는지 확인
				{
					confirmDeal = ShareData.scanUserInput.nextInt();
					// 다시 생각한다 선택
					if (confirmDeal == 2)
					{
						break;
					}
				}
				catch (InputMismatchException ErrorInput) // 숫자가 아닌 문자를 입력 한 경우 에러 메시지 출력
				{
					System.out.printf("************************************************************\n");
					System.out.println("잘못된 문자 입력입니다.\n다시 입력 해주세요.\n");
					System.out.printf("************************************************************\n");
					continue;
				}
				
				if ((confirmDeal <= 0) || (confirmDeal >= 3))
				{
					System.out.printf("************************************************************\n");
					System.out.println("잘못된 숫자 입력입니다.\n다시 입력 해주세요.\n");
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
	
	입력: 유저가 입력하는 번호, 아이템 정보, 플레이어 정보, 아이템 타입 번호
	출력: 유저가 선택한 번호
	
	친밀도 아이템과, 회복 아이템 중에서 구입할 아이템을 선택한다.

	**************************************************/
	boolean selectItemNumber (Item item, int itemType)
	{
		int itemNumber = -1;				// 구입할 아이템 번호
		boolean buyItemNumber = false;		// 아이템 구입 확인
		
		// 상점 아이템 표시
		//this.ShowItemList (Item);
		
		// 친밀도 아이템, 회복 아이템 중 선택하면 아이템을 구입한다.
		while (buyItemNumber == false)
		{
			// 친밀도 아이템
			if (itemType == 1)
			{
				System.out.printf("************************************************************\n");
				System.out.printf("친밀도 아이템\n");
				for (int ItemIdx = 0; ItemIdx < 5; ItemIdx++)
				{
					System.out.printf("%d. %s    가격: %d 친밀도 상승량: %d\n", (ItemIdx + 1), item.familiarityItemName[ItemIdx], familiarityPrice[ItemIdx], item.familiarityValue[ItemIdx]);
				}
			}
			else // 회복 아이템
			{
				System.out.printf("\n************************************************************\n");
				System.out.printf("회복 아이템\n");
				for (int itemIdx = 0; itemIdx < 5; itemIdx++)
				{
					if (item.recoveryItemName[itemIdx] == "만병통치약")
					{
						System.out.printf("%d. %s    가격: %d 회복량: %d + 상태이상 치료\n", (itemIdx + 1), item.recoveryItemName[itemIdx], recoveryPrice[itemIdx], item.recoveryValue[itemIdx]);
					}
					else
					{
						System.out.printf("%d. %s    가격: %d 회복량: %d\n", (itemIdx + 1), item.recoveryItemName[itemIdx], recoveryPrice[itemIdx], item.recoveryValue[itemIdx]);
					}
					
				}
			}
			
			System.out.printf("6. 돌아간다.\n");
			System.out.printf("************************************************************\n");
			System.out.printf("구입할 아이템 번호 입력: ");
			try // 숫자를 입력 받는지 확인
			{
				itemNumber = ShareData.scanUserInput.nextInt();
				// 돌아간다 선택. 다시 1번째 선택 메뉴로 돌아간다.
				if (itemNumber == 6)
				{
					break;
				}
			}
			catch (InputMismatchException ErrorInput) // 숫자가 아닌 문자를 입력 한 경우 에러 메시지 출력
			{
				System.out.printf("************************************************************\n");
				System.out.println("잘못된 문자 입력입니다.\n다시 입력 해주세요.\n");
				System.out.printf("************************************************************\n");
				continue;
			}
			
			if ((itemNumber <= 0) || (itemNumber >= 7))
			{
				System.out.printf("************************************************************\n");
				System.out.println("잘못된 숫자 입력입니다.\n다시 입력 해주세요.\n");
				System.out.printf("************************************************************\n");
				continue;
			}
			
			buyItemNumber = this.confirmBuyItem (item, itemType, itemNumber);
		}
		
		return buyItemNumber;
	}
	
	/**************************************************
	 
	buyItems
	
	입력: 유저가 입력하는 번호, 아이템 정보, 플레이어 정보
	출력: 아이템 정보
	
	상점에서 아이템을 구입하는 기능을 수행한다.

	**************************************************/
	void buyItems (Item item)
	{
		int receiveNumber = -1;			// 사용자가 입력하는 숫자
		boolean selectType = false;		// 아이템 타입 선택 확인
		
		// 친밀도 아이템, 회복 아이템 중 선택한다.
		while (selectType == false)
		{
			System.out.printf("************************************************************\n");
			System.out.printf("1. 친밀도 아이템 구입\n");
			System.out.printf("2. 회복 아이템 구입\n");
			System.out.printf("3. 그냥 돌아간다.\n\n");
			System.out.printf("구입할 아이템 타입 번호 입력: ");
			try // 숫자를 입력 받는지 확인
			{
				receiveNumber = ShareData.scanUserInput.nextInt();
				// 돌아간다 선택
				if (receiveNumber == 3)
				{
					break;
				}
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
			
			selectType = this.selectItemNumber (item, receiveNumber);
		}
	}
	
	/**************************************************
	 
	completeSellItem
	
	입력: 유저가 입력하는 번호, 플레이어 정보, 아이템 타입 번호, 아아템 번호
	출력: 유저가 선택한 번호
	
	최종 판매 수량을 입력하고 확인한하여 아이템을 판매한다.

	**************************************************/
	boolean completeSellItem (int itemType, int itemNumber)
	{
		int selectAmount = -1;				// 판매 수량 결정
		int finalSelectDeal = -1;			// 최종 판매 선택
		boolean completeDeal = false;		// 최종 거래 완료 확인
		boolean finalSelectSell = false;	// 최종 판매 선택 확인
		
		// 구입 수량을 입력하고 확인
		FirstLoop: while (completeDeal == false)
		{
			
			System.out.printf("몇개를 판매하시겠습니까??\n");
			System.out.printf("0. 다시 생각하기\n");
			// 친밀도 아이템
			if (itemType == 1)
			{
				System.out.printf("소지 수: %d\n", Player.item.familiarityAmount[itemNumber - 1]);
			}
			else // 회복 아이템
			{
				System.out.printf("소지 수: %d\n", Player.item.recoveryAmount[itemNumber - 1]);
			}
			System.out.printf("판매할 수량 입력: \n");
			
			try // 숫자를 입력 받는지 확인
			{
				selectAmount = ShareData.scanUserInput.nextInt();
				if (selectAmount <= 0)
				{
					// 이전 메뉴로 되돌아 간다.
					break;
				}
			}
			catch (InputMismatchException ErrorInput) // 숫자가 아닌 문자를 입력 한 경우 에러 메시지 출력
			{
				System.out.printf("************************************************************\n");
				System.out.println("잘못된 문자 입력입니다.\n다시 입력 해주세요.\n");
				System.out.printf("************************************************************\n");
				continue;
			}
			
			// 친밀도 아이템
			if (itemType == 1)
			{
				// 소지수보다 많은 값을 입력
				if (Player.item.familiarityAmount[itemNumber - 1] < selectAmount)
				{
					System.out.printf("************************************************************\n");
					System.out.println("잘못된 숫자 입력입니다.\n다시 입력 해주세요.\n");
					System.out.printf("************************************************************\n");
					continue;
				}
			}
			else // 회복 아이템
			{
				// 소지수보다 많은 값을 입력
				if (Player.item.recoveryAmount[itemNumber - 1] < selectAmount)
				{
					System.out.printf("************************************************************\n");
					System.out.println("잘못된 숫자 입력입니다.\n다시 입력 해주세요.\n");
					System.out.printf("************************************************************\n");
					continue;
				}
			}
			
			// 친밀도 아이템
			if (itemType == 1)
			{
				System.out.printf("\n판매 수: %d 총 가격: %d 소지금: %d\n", selectAmount, (familiaritySellPrice[itemNumber - 1] * selectAmount), Player.currentMoney);
			}
			else // 회복 아이템
			{
				System.out.printf("\n판매 수: %d 총 가격: %d 소지금: %d\n", selectAmount, (recoverySellPrice[itemNumber - 1] * selectAmount), Player.currentMoney);
			}
			
			while (finalSelectSell == false)
			{
				System.out.printf("정말 판매하시겠습까?\n");
				System.out.printf("1. 판매한다.\n");
				System.out.printf("2. 다시 생각한다.\n");
				System.out.printf("번호 선택: ");
				try // 숫자를 입력 받는지 확인
				{
					finalSelectDeal = ShareData.scanUserInput.nextInt();
					// 다시 생각한다 선택
					if (finalSelectDeal == 2)
					{
						// 구입 수량 부터 다시 선택
						continue FirstLoop;
					}
				}
				catch (InputMismatchException ErrorInput) // 숫자가 아닌 문자를 입력 한 경우 에러 메시지 출력
				{
					System.out.printf("************************************************************\n");
					System.out.println("잘못된 문자 입력입니다.\n다시 입력 해주세요.\n");
					System.out.printf("************************************************************\n");
					continue;
				}
				
				if ((finalSelectDeal <= 0) || (finalSelectDeal >= 3))
				{
					System.out.printf("************************************************************\n");
					System.out.println("잘못된 숫자 입력입니다.\n다시 입력 해주세요.\n");
					System.out.printf("************************************************************\n");
					continue;
				}
				
				// 최종 구입 선택
				if (finalSelectDeal == 1)
				{
					if (itemType == 1)
					{
						// 판매한 수 만큼 소지수 감소
						Player.item.familiarityAmount[itemNumber - 1] -= selectAmount;
						Player.currentMoney += (familiaritySellPrice[itemNumber - 1] * selectAmount);
						System.out.printf("감사합니다. 여기 판매 금액 %d 입니다.\n", (familiaritySellPrice[itemNumber - 1] * selectAmount));
					}
					else
					{
						// 판매한 수 만큼 소지수 감소
						Player.item.recoveryAmount[itemNumber - 1] -= selectAmount;
						Player.currentMoney += (recoverySellPrice[itemNumber - 1] * selectAmount);
						System.out.printf("감사합니다. 여기 판매 금액 %d 입니다.\n", (recoverySellPrice[itemNumber - 1] * selectAmount));
					}

					finalSelectSell = true;
					completeDeal = true;
					
					System.out.printf("아이템을 판매하고 소지금이 %d가 되었습니다.\n", Player.currentMoney);
					Player.displayItemInfo ();
				}
			}
		}
		
		return completeDeal;
	}
	
	/**************************************************
	 
	confirmSellItem
	
	입력: 유저가 입력하는 번호, 플레이어 정보, 아이템 타입 번호, 아아템 번호
	출력: 유저가 선택한 번호
	
	선택한 아이템 판매여부를 확인한다.

	**************************************************/
	boolean confirmSellItem (int itemType, int itemNumber)
	{
		int confirmDeal = -1;			// 구입 확인 번호
		boolean selectSell = false;		// 아이템 구입 선택 확인
		
		// 아이템 구입 확인
		while (selectSell == false)
		{
			// 친밀도 아이템
			if (itemType == 1)
			{
				System.out.printf("%s을 판매하시겠습니까? 가격은 %d입니다.\n", Player.item.familiarityItemName[itemNumber - 1], familiaritySellPrice[itemNumber - 1]);
				System.out.printf("1. 판매한다.\n");
				System.out.printf("2. 다시 생각한다.\n");
				System.out.printf("번호 선택: ");
				try // 숫자를 입력 받는지 확인
				{
					confirmDeal = ShareData.scanUserInput.nextInt();
					// 다시 생각한다 선택
					if (confirmDeal == 2)
					{
						break;
					}
				}
				catch (InputMismatchException ErrorInput) // 숫자가 아닌 문자를 입력 한 경우 에러 메시지 출력
				{
					System.out.printf("************************************************************\n");
					System.out.println("잘못된 문자 입력입니다.\n다시 입력 해주세요.\n");
					System.out.printf("************************************************************\n");
					continue;
				}
				
				if ((confirmDeal <= 0) || (confirmDeal >= 3))
				{
					System.out.printf("************************************************************\n");
					System.out.println("잘못된 숫자 입력입니다.\n다시 입력 해주세요.\n");
					System.out.printf("************************************************************\n");
					continue;
				}
				
				//CompleteDeal = true;
			}
			else // 회복 아이템
			{
				System.out.printf("%s을 판매하시겠습니까? 가격은 %d입니다.\n", Player.item.recoveryItemName[itemNumber - 1], recoverySellPrice[itemNumber - 1]);
				System.out.printf("1. 판매한다.\n");
				System.out.printf("2. 다시 생각한다.\n");
				System.out.printf("번호 선택: ");
				
				try // 숫자를 입력 받는지 확인
				{
					confirmDeal = ShareData.scanUserInput.nextInt();
					// 다시 생각한다 선택
					if (confirmDeal == 2)
					{
						break;
					}
				}
				catch (InputMismatchException ErrorInput) // 숫자가 아닌 문자를 입력 한 경우 에러 메시지 출력
				{
					System.out.printf("************************************************************\n");
					System.out.println("잘못된 문자 입력입니다.\n다시 입력 해주세요.\n");
					System.out.printf("************************************************************\n");
					continue;
				}
				
				if ((confirmDeal <= 0) || (confirmDeal >= 3))
				{
					System.out.printf("************************************************************\n");
					System.out.println("잘못된 숫자 입력입니다.\n다시 입력 해주세요.\n");
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
	
	입력: 유저가 입력하는 번호, 아이템 정보, 플레이어 정보, 아이템 타입 번호
	출력: 유저가 선택한 번호
	
	친밀도 아이템과, 회복 아이템 중에서 판매할 아이템을 선택한다.

	**************************************************/
	boolean selectItemNumber (int itemType)
	{
		int[] haveItemNumber = new int[10];	// 가지고 있는 아이템 번호 저장 
		int itemNumberIndex = 0;			// 아이템 번호 인덱스 값
		int itemNumber = -1;				// 판매할 아이템 번호
		boolean sellItemNumber = false;		// 아이템 판매 확인
		boolean correctNumber = false;		// 아이템 번호를 맞게 입력 했는지
		
		// 친밀도 아이템, 회복 아이템 중 선택하면 아이템을 구입한다.
		while (sellItemNumber == false)
		{
			// 친밀도 아이템
			if (itemType == 1)
			{
				System.out.printf("************************************************************\n");
				System.out.printf("친밀도 아이템\n");
				for (int itemIdx = 0; itemIdx < 5; itemIdx++)
				{
					if (Player.item.familiarityAmount[itemIdx] > 0)
					{
						haveItemNumber[itemNumberIndex] = itemIdx + 1;
						System.out.printf("%d. %s    판매가격: %d\n", (itemNumberIndex + 1), Player.item.familiarityItemName[itemIdx], familiaritySellPrice[itemIdx]);
						itemNumberIndex++;
					}
				}
			}
			else // 회복 아이템
			{
				System.out.printf("\n************************************************************\n");
				System.out.printf("회복 아이템\n");
				for (int itemIdx = 0; itemIdx < 5; itemIdx++)
				{
					if (Player.item.recoveryAmount[itemIdx] > 0)
					{
						haveItemNumber[itemNumberIndex] = itemIdx + 1;
						System.out.printf("%d. %s    판매가격: %d\n", (itemNumberIndex + 1), Player.item.recoveryItemName[itemIdx], recoverySellPrice[itemIdx]);
						itemNumberIndex++;
					}
				}
			}
			
			System.out.printf("6. 돌아간다.\n");
			System.out.printf("************************************************************\n");
			System.out.printf("판매할 아이템 번호 입력: ");
			try // 숫자를 입력 받는지 확인
			{
				itemNumber = ShareData.scanUserInput.nextInt();
				// 돌아간다 선택. 다시 1번째 선택 메뉴로 돌아간다.
				if (itemNumber == 6)
				{
					break;
				}
			}
			catch (InputMismatchException ErrorInput) // 숫자가 아닌 문자를 입력 한 경우 에러 메시지 출력
			{
				System.out.printf("************************************************************\n");
				System.out.println("잘못된 문자 입력입니다.\n다시 입력 해주세요.\n");
				System.out.printf("************************************************************\n");
				continue;
			}
			
			if ((itemNumber <= 0) || (itemNumber >= 7))
			{
				System.out.printf("************************************************************\n");
				System.out.println("잘못된 숫자 입력입니다.\n다시 입력 해주세요.\n");
				System.out.printf("************************************************************\n");
				continue;
			}

			// 플레이어 아이템 리스트에 내가 선택한 아이템이 포함되었는지 확인
			// 친밀도 아이템
			if (itemType == 1)
			{
				if (Player.item.familiarityAmount[(haveItemNumber[itemNumber - 1] - 1)] > 0)
				{
					// 아이템이 있으면 조건 성립
					correctNumber = true;
				}
			}
			else
			{
				if (Player.item.recoveryAmount[(haveItemNumber[itemNumber - 1] - 1)] > 0)
				{
					// 아이템이 있으면 조건 성립
					correctNumber = true;
				}
			}

			
			// 아이템 판매 절차 진행
			if (correctNumber == true)
			{
				sellItemNumber = this.confirmSellItem (itemType, haveItemNumber[itemNumber - 1]);
			}
			else // 다시 입력
			{
				correctNumber = false;
				System.out.printf("************************************************************\n");
				System.out.println("잘못된 숫자 입력입니다.\n다시 입력 해주세요.\n");
				System.out.printf("************************************************************\n");
				continue;
			}
		}
		
		return sellItemNumber;
	}
	
	/**************************************************
	 
	sellItems
	
	입력: 유저가 입력하는 번호, 플레이어 정보
	출력: 아이템 정보
	
	상점에서 아이템을 판매하는 기능을 수행한다.

	**************************************************/
	void sellItems ()
	{
		int receiveNumber = -1;			// 사용자가 입력하는 숫자
		boolean selectType = false;		// 아이템 타입 선택 확인
		
		// 플레이어 아이템 표시
		//this.ShowItemList (Item);
		Player.displayItemInfo();
		
		// 친밀도 아이템, 회복 아이템 중 선택한다.
		while (selectType == false)
		{
			System.out.printf("************************************************************\n");
			System.out.printf("1. 친밀도 아이템 판매\n");
			System.out.printf("2. 회복 아이템 판매\n");
			System.out.printf("3. 그냥 돌아간다.\n\n");
			System.out.printf("판매할 아이템 타입 번호 입력: ");
			try // 숫자를 입력 받는지 확인
			{
				receiveNumber = ShareData.scanUserInput.nextInt();
				// 돌아간다 선택
				if (receiveNumber == 3)
				{
					break;
				}
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
			
			selectType = this.selectItemNumber (receiveNumber);
		}
	}
	
	/**************************************************
	 
	marketMainMenu
	
	입력: 유저가 입력하는 번호, 아이템 정보, 플레이어 정보
	출력: 플레이어 소지금 정보, 아이템 정보
	
	상점의 메인 메뉴 표시. 구입하거나 판매를 선택할 수 있다.

	**************************************************/
	void marketMainMenu (Item item)
	{
		int receiveNumber = -1;			// 사용자가 입력하는 숫자
		boolean selectType = false;		// 아이템 타입 선택 확인
		
		System.out.printf("************************************************************\n");
		System.out.printf("어서 오세요 포켓몬 상점 입니다.\n");
		System.out.printf("마음껏 둘러 보세요.\n");
		
		// 가격 정보를 불러온다.
		this.setItemPrice();
		// 아이템 정보를 불러온다.
		item.initalizeItemList();

		// 친밀도 아이템, 회복 아이템 중 선택한다.
		while (selectType == false)
		{
			System.out.printf("************************************************************\n");
			System.out.printf("나는 여기서 무엇을 할까?\n");
			System.out.printf("1. 아이템을 구입한다.\n");
			System.out.printf("2. 아이템을 판매한다.\n");
			System.out.printf("3. 그냥 돌아간다.\n\n");
			System.out.printf("번호 입력: ");
			try // 숫자를 입력 받는지 확인
			{
				receiveNumber = ShareData.scanUserInput.nextInt();
				// 돌아간다 선택
				if (receiveNumber == 3)
				{
					break;
				}
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
			
			// 아이템을 구입한다.
			if (receiveNumber == 1)
			{
				this.buyItems (item);
			}
			else // 아이템을 판매한다.
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
