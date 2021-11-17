package 어디가천;

import java.util.Scanner;
public class Dijkstra_demo {

		public static void main(String[] args) 
		{ 
	
			Scanner sc= new Scanner(System.in);
			String start, last;
			
	System.out.println("시작점과 목적지를 입력하시오. ");	
	System.out.println("비전타워\n법대 건물\n공과대학1\n공과대학2\n가천관\nIT대학"); //문자열로 입력받아서 시작

	start=sc.next();
	last=sc.next();
	
	int startPosition=-1;
	int lastPosition=-1;
	
	if(start.compareTo("비전타워")==1) startPosition=0; //문자열로 입력받은 결과를 숫자(포인트)로 바꿔주기

	else if(start.compareTo("법대 건물")==1) startPosition=1;

	else if(start.compareTo("공과대학1")==1) startPosition=4;

	else if(start.compareTo("공과대학2")==1) startPosition=2;

	else if(start.compareTo("가천관")==1) startPosition=3;

	else if(start.compareTo("IT대학")==1) startPosition=5;

	else {System.out.println("곧 업데이트 됩니다."); System.exit(1);}
		
	
	Graph g = new Graph(16); // 0~6 : 건물 / 7~15 : 길
		// 노드 수 만큼 그래프 생성 
		// 시작, 끝, 간선 가중치 입력 
	
	int x= 10000; //아직 정확하게 거리 알지 못하므로 x로 처리함
	
	//전체 화살표 = 21개
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
		
		 
		int result = g.dijkstra(startPosition, lastPosition); //시작노드
		
		} 
	} 
	

class Graph{ 
			
		private int n; // 노드들의 수 
		private int maps[][]; 
		// 노드들간의 가중치 저장할 변수 
		
		public Graph(int n) {
			
			this.n = n; maps = new int[n][n]; 
		// 인접행렬 모든 값 무한대로 초기화 
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
			System.out.println("시작점 : "+start);
			System.out.println("도착점 : "+last);
			System.out.println("최단 거리 : "+distanceValue);
			
		}
		
		int dijkstra(int start ,int last)
		{
			int distance[] = new int[n]; // 최단 거리를 저장할 변수 
		    boolean[] check = new boolean[n]; // 해당 노드를 방문했는지 체크할 변수 
		// distance값 초기화. 무한대를 int 자료형의 최대값으로 표현했다. 
		
		    for(int i=0; i<n; ++i){ distance[i] = Integer.MAX_VALUE; 
		// 시작노드값 초기화. distance[v] = 0; check[v] = true;
		 // 결과값 출력 for(int i=0; i<n; ++i){ 
		
		    if(distance[i] == 2147483647) System.out.print("∞ "); 
		    else System.out.print(distance[i]+" "); 
		    } //  void dijkstra
		 
		System.out.println(""); // 연결노드 distance갱신 
		
		for(int i=0; i<n; ++i){
		 if(!check[i] && maps[start][i] != Integer.MAX_VALUE)
		 { distance[i] = maps[start][i]; }  
		
		// 결과값 출력 for(int i=0; i<n; ++i)
		if(distance[i] == 2147483647) 
			System.out.print("∞ "); 
		else System.out.print(distance[i]+" "); }
			System.out.println(""); 
		
			for(int a=0; a<n-1; ++a){ // 원래는 모든 노드가 true될때까지 인데 
		// 노드가 n개 있을 때 다익스트라를 위해서 반복수는 n-1번이면 된다. 
		// 원하지 않으면 각각의 노드가 모두 true인지 확인하는 식으로 구현해도 된다. 
		int min = Integer.MAX_VALUE; int min_index = -1; 
		// 노드 최소값 찾기 
		for(int i=0; i<n; ++i)
		{ 
			if(!check[i]){
				if(distance[i] < min)
					{ min = distance[i]; min_index = i; }
				} 
			} 
		
			// 다른 노드를 거쳐서 가는 것이 더 비용이 적은지 확인한다. 
		
		check[min_index] = true; 
		
		for(int i=0; i<n; ++i){ 
			if(!check[i] && maps[min_index][i] != Integer.MAX_VALUE){
				if(distance[min_index] + maps[min_index][i] < distance[i]){
					distance[i] = distance[min_index] + maps[min_index][i]; } 
				}
		}
	
		/* 결과값 출력하는 부분
		for(int i=0; i<n; ++i){ 
			if(distance[i] == 2147483647)
				System.out.print("∞ "); // 결과값 출력 
			else 
				System.out.print(distance[i]+" ");
		 }
		*/
	
		}
				return distance[last]; //최단거리 반환
				
	} 

}


