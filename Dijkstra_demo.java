package ���õ;

import java.util.Scanner;
public class Dijkstra_demo {

		public static void main(String[] args) 
		{ 
	
			Scanner sc= new Scanner(System.in);
			String start, last;
			
	System.out.println("�������� �������� �Է��Ͻÿ�. ");	
	System.out.println("����Ÿ��\n���� �ǹ�\n��������1\n��������2\n��õ��\nIT����"); //���ڿ��� �Է¹޾Ƽ� ����

	start=sc.next();
	last=sc.next();
	
	int startPosition=-1;
	int lastPosition=-1;
	
	if(start.compareTo("����Ÿ��")==1) startPosition=0; //���ڿ��� �Է¹��� ����� ����(����Ʈ)�� �ٲ��ֱ�

	else if(start.compareTo("���� �ǹ�")==1) startPosition=1;

	else if(start.compareTo("��������1")==1) startPosition=4;

	else if(start.compareTo("��������2")==1) startPosition=2;

	else if(start.compareTo("��õ��")==1) startPosition=3;

	else if(start.compareTo("IT����")==1) startPosition=5;

	else {System.out.println("�� ������Ʈ �˴ϴ�."); System.exit(1);}
		
	
	Graph g = new Graph(16); // 0~6 : �ǹ� / 7~15 : ��
		// ��� �� ��ŭ �׷��� ���� 
		// ����, ��, ���� ����ġ �Է� 
	
	int x= 10000; //���� ��Ȯ�ϰ� �Ÿ� ���� ���ϹǷ� x�� ó����
	
	//��ü ȭ��ǥ = 21��
		 g.input(0, 1, x);
		 g.input(0, 6, x);
		 g.input(0, 7, x);
	     g.input(0, 15, x);  
	     g.input(1, 2, x);
	     
		 g.input(1, 12, x); 
		 g.input(2, 11, x); 	 
		 g.input(3, 9, x);	
		 g.input(3, 10, x);	 
		 g.input(4, 5, x);
		 
		 g.input(4, 9, x);
		 g.input(5, 8, x);
		 g.input(6, 15, x);
		 g.input(6, 13, x);
		 g.input(7, 8, x);	 
		
		 g.input(8, 14, x);
		 g.input(9, 10, x);
		 g.input(10, 11, x);
		 g.input(10, 14, x);
		 g.input(12, 13, x);
		 g.input(13, 14, x);
		
		 
		int result = g.dijkstra(startPosition, lastPosition); //���۳��
		
		} 
	} 
	

class Graph{ 
			
		private int n; // ������ �� 
		private int maps[][]; 
		// ���鰣�� ����ġ ������ ���� 
		
		public Graph(int n) {
			
			this.n = n; maps = new int[n][n]; 
		// ������� ��� �� ���Ѵ�� �ʱ�ȭ 
		for(int i=0; i<n; ++i) { 
			for(int j=0; j<n; ++j) { 
				maps[i][j] = Integer.MAX_VALUE; 
				}
		 	} 
		} 
		
		
		public void input(int i,int j,int w)
		{ 
			maps[i][j] = w; 
			maps[j][i] = w; 
		}
		 
		
		public void printResult(String start, String last, int distanceValue) {
			System.out.println("������ : "+start);
			System.out.println("������ : "+last);
			System.out.println("�ִ� �Ÿ� : "+distanceValue);
			
		}
		
		int dijkstra(int start ,int last)
		{
			int distance[] = new int[n]; // �ִ� �Ÿ��� ������ ���� 
		    boolean[] check = new boolean[n]; // �ش� ��带 �湮�ߴ��� üũ�� ���� 
		// distance�� �ʱ�ȭ. ���Ѵ븦 int �ڷ����� �ִ밪���� ǥ���ߴ�. 
		
		    for(int i=0; i<n; ++i){ distance[i] = Integer.MAX_VALUE; 
		// ���۳�尪 �ʱ�ȭ. distance[v] = 0; check[v] = true;
		 // ����� ��� for(int i=0; i<n; ++i){ 
		
		    if(distance[i] == 2147483647) System.out.print("�� "); 
		    else System.out.print(distance[i]+" "); 
		    } //  void dijkstra
		 
		System.out.println(""); // ������ distance���� 
		
		for(int i=0; i<n; ++i){
		 if(!check[i] && maps[start][i] != Integer.MAX_VALUE)
		 { distance[i] = maps[start][i]; }  
		
		// ����� ��� for(int i=0; i<n; ++i)
		if(distance[i] == 2147483647) 
			System.out.print("�� "); 
		else System.out.print(distance[i]+" "); }
			System.out.println(""); 
		
			for(int a=0; a<n-1; ++a){ // ������ ��� ��尡 true�ɶ����� �ε� 
		// ��尡 n�� ���� �� ���ͽ�Ʈ�� ���ؼ� �ݺ����� n-1���̸� �ȴ�. 
		// ������ ������ ������ ��尡 ��� true���� Ȯ���ϴ� ������ �����ص� �ȴ�. 
		int min = Integer.MAX_VALUE; int min_index = -1; 
		// ��� �ּҰ� ã�� 
		for(int i=0; i<n; ++i)
		{ 
			if(!check[i]){
				if(distance[i] < min)
					{ min = distance[i]; min_index = i; }
				} 
			} 
		
			// �ٸ� ��带 ���ļ� ���� ���� �� ����� ������ Ȯ���Ѵ�. 
		
		check[min_index] = true; 
		
		for(int i=0; i<n; ++i){ 
			if(!check[i] && maps[min_index][i] != Integer.MAX_VALUE){
				if(distance[min_index] + maps[min_index][i] < distance[i]){
					distance[i] = distance[min_index] + maps[min_index][i]; } 
				}
		}
	
		/* ����� ����ϴ� �κ�
		for(int i=0; i<n; ++i){ 
			if(distance[i] == 2147483647)
				System.out.print("�� "); // ����� ��� 
			else 
				System.out.print(distance[i]+" ");
		 }
		*/
	
		}
				return distance[last]; //�ִܰŸ� ��ȯ
				
	} 

}


