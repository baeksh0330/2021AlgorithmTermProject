package 어디가천;

import java.util.Scanner;
public class Dijkstra_demo {

		public static void main(String[] args) 
		{ 
	
			Scanner sc= new Scanner(System.in);
			String start, last;
			
	System.out.println("출발지와 목적지를 입력하시오. ");	
	System.out.println("\n(여기 swing으로 처리할 수 있으면 할것)\n비전타워\n법대 건물\n공과대학1\n공과대학2\n가천관\nIT대학\n\n"); //문자열로 입력받아서 시작

	start=sc.nextLine();
	last=sc.nextLine();
	
	int startPosition=-1;
	int lastPosition=-1;
	

	if(start.compareTo("비전타워")==0) startPosition=0; //문자열로 입력받은 결과를 숫자(포인트)로 바꿔주기

	else if(start.compareTo("법대 건물")==0) startPosition=1;

	else if(start.compareTo("공과대학1")==0) startPosition=4;

	else if(start.compareTo("공과대학2")==0) startPosition=2;

	else if(start.compareTo("가천관")==0) startPosition=3;

	else if(start.compareTo("IT대학")==0) startPosition=5;

	else {System.out.println("곧 업데이트 됩니다."); System.exit(1);}
	
	
	if(last.compareTo("비전타워")==0) lastPosition=0; //문자열로 입력받은 결과를 숫자(포인트)로 바꿔주기

	else if(last.compareTo("법대 건물")==0) lastPosition=1;

	else if(last.compareTo("공과대학1")==0) lastPosition=4;

	else if(last.compareTo("공과대학2")==0) lastPosition=2;

	else if(last.compareTo("가천관")==0) lastPosition=3;

	else if(last.compareTo("IT대학")==0) lastPosition=5;

	else {System.out.println("곧 업데이트 됩니다."); System.exit(1);}
	
	
	Graph g = new Graph(17); // 위치 16개 : 0~6 : 건물 / 7~15 : 길
		// 노드 수 만큼 그래프 생성 
		// 시작, 끝, 간선 가중치 입력 
	
//	int x= 10000; //아직 정확하게 거리 알지 못하므로 x로 처리함
	
	//전체 화살표 = 21개
		 g.input(0, 1, 90);
		 g.input(0, 6, 20);
		 g.input(0, 7, 70);
	     g.input(0, 15, 22);  
	     g.input(1, 2, 80);
	     
		 g.input(1, 12, 40); 
		 g.input(2, 11, 55); 	 
		 g.input(3, 9, 45);	
		 g.input(3, 10, 60);	 
		 g.input(4, 5, 70);
		 
		 g.input(4, 9, 150);
		 g.input(5, 8, 53);
		 g.input(6, 15, 35);
		 g.input(6, 13, 127); //계단으로 비전타워를 내려가는 경우
		 
		 g.input(14,16,63); //16: 비전타워 엘리베이터
		 g.input(12,16,50);
		 g.input(6,16,5); //엘리베이터 타는 경우
		 
		 g.input(7, 8, 16);	 
		
		 g.input(8, 14, 17);
		 g.input(9, 10, 18);
		 g.input(10, 11, 18);
		 g.input(10, 14, 19);
		 g.input(12, 13, 20);
		 g.input(13, 14, 21);
		
		 
		int result = g.dijkstra(startPosition, lastPosition); //출발지, 목적지
		g.printResult(start, last, result);
		} 
	} 
	

class Graph{ 
			
		private int n; // 노드들의 수 
		private int maps[][]; 
		// 노드들간의 가중치 저장할 변수 
		
		public Graph(int n) {
			
			this.n = n;
			maps = new int[n][n]; 
			for(int i=0; i<n; ++i) { 
				for(int j=0; j<n; ++j) { 
					maps[i][j] = Integer.MAX_VALUE;  //전체 배열 초기화 : 무한대 
				}//for
		 	} //for
		} //public Graph
		
		
		public void input(int i,int j,int w)
		{ 
			maps[i][j] = w; 
			maps[j][i] = w; 
		}//public void input
		 
		
		public void printResult(String start, String last, int distanceValue) {
			
			System.out.println("시작점 : "+start);
			System.out.println("도착점 : "+last);
			System.out.println("최단 거리 : "+distanceValue);
			
		}//public void printResult
		
		int dijkstra(int start ,int last) //시작 점 -> 끝 점
		{
			int distance[] = new int[n]; // 최단 거리를 저장할 변수 
		    boolean[] check = new boolean[n]; // 해당 노드를 방문했는지 체크할 변수 
		// distance값 초기화. 무한대를 int 자료형의 최대값으로 표현했다. 
		
		    
		    for(int i=0; i<n; ++i){
		    	distance[i] = Integer.MAX_VALUE; 
		    }//for 

		  		 
		for(int i=0; i<n; ++i){
		 if(!check[i] && maps[start][i] != Integer.MAX_VALUE){ //방문했던 곳이 아니고 start->i가 이어져 있을때
			 distance[i] = maps[start][i]; //누적 거리 : start->i추가
			 }//if  				
		}//for
			 
			for(int a=0; a<n-1; ++a){
				int min = Integer.MAX_VALUE; int min_index = -1; 
		// 노드 최소값 찾기 
				for(int i=0; i<n; ++i){ 
					if(!check[i]){
						if(distance[i] < min) { 
						min = distance[i]; min_index = i; 
					}//if
				} //for
			} //for
		

		
		check[min_index] = true; //현 노드 방문
		
		for(int i=0; i<n; ++i){ 
			if(!check[i] && maps[min_index][i] != Integer.MAX_VALUE){
				if(distance[min_index] + maps[min_index][i] < distance[i]){
					distance[i] = distance[min_index] + maps[min_index][i];
					}//if 
				}//if
			}//for

	
		}//for
				return distance[last]; //최단거리 반환
				
	} //int dijkstra

}//class graph


