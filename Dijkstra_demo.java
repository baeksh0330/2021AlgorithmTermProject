package ���õ;

import java.util.Scanner;
public class Dijkstra_demo {

		public static void main(String[] args) 
		{ 
	
			Scanner sc= new Scanner(System.in);
			int start, last;
		
		Graph g = new Graph(6); 
		// ��� �� ��ŭ �׷��� ���� 
		// ����, ��, ���� ����ġ �Է� 
		g.input(0, 1, 10);
		 g.input(1, 2, 5);
		 g.input(2, 3, 8);
		 g.input(3, 4, 15);
		 g.input(0, 3, 20);
		 g.input(0, 5, 100);
		// g.input(3, 4, 6);
	//	 g.input(4, 5, 9); // ���۳�� ���� ���ͽ�Ʈ�� �˰��� ���� 
		g.dijkstra(0); 
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
		 
		public void dijkstra(int v)
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
		 if(!check[i] && maps[v][i] != Integer.MAX_VALUE)
		 { distance[i] = maps[v][i]; }  
		
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
		
		for(int i=0; i<n; ++i){ 
			if(distance[i] == 2147483647)
				System.out.print("�� "); // ����� ��� 
			else 
				System.out.print(distance[i]+" ");
		 }
		
	
		System.out.println(""); 
		} 
	} 

}


