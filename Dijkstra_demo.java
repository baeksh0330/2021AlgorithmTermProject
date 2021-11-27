package 어디가천;

import java.util.*;
import java.io.*;

public class Dijkstra_demo {

	/**
	 * 0=비전타워
	 * 1=법대건물(비타와 연결)
	 * 2=공과건물2
	 * 3=가천관
	 * 4=공과건물1
	 * 5=IT대학
	 * ==============
	 * 6=프리덤광장
	 * 7=비타-신호등 거리
	 * 8=신호등 앞 삼거리
	 * 9=가천관 왼쪽 길
	 * 10=가천관 오른쪽 길
	 * 11=웅지관 앞 직진 거리
	 * 12=비타 1층, 바나대 대학원 오른쪽 
	 * 13(=16)=바나대 대학원 앞 지나가는 거리
	 * 14=삼거리 가는쪽, 바나대 대학원 왼쪽에서 갈림길
	 * 15=프리덤광장 계단
	 */	

	
	
public static void main(String[] args){ 
	
		Scanner sc= new Scanner(System.in);
		String start, last;

	System.out.println("출발지와 목적지를 입력하시오. ");	
	System.out.println("\n비전타워\n법학대학\n공과대학1\n공과대학2\n가천관\nIT대학\n\n"); //문자열로 입력받아서 시작

	start=sc.nextLine();
	last=sc.nextLine();
	
	int startPosition=-1;
	int lastPosition=-1;

	if(start.compareTo("비전타워")==0) startPosition=0; //문자열로 입력받은 결과를 숫자(포인트)로 바꿔주기

	else if(start.compareTo("법학대학")==0) startPosition=1;

	else if(start.compareTo("공과대학1")==0) startPosition=4;

	else if(start.compareTo("공과대학2")==0) startPosition=2;

	else if(start.compareTo("가천관")==0) startPosition=3;

	else if(start.compareTo("IT대학")==0) startPosition=5;

	else {System.out.println("곧 업데이트 됩니다."); System.exit(1);}
	
	
	if(last.compareTo("비전타워")==0) lastPosition=0; //문자열로 입력받은 결과를 숫자(포인트)로 바꿔주기

	else if(last.compareTo("법학대학")==0) lastPosition=1;

	else if(last.compareTo("공과대학1")==0) lastPosition=4;

	else if(last.compareTo("공과대학2")==0) lastPosition=2;

	else if(last.compareTo("가천관")==0) lastPosition=3;

	else if(last.compareTo("IT대학")==0) lastPosition=5;

	else {System.out.println("곧 업데이트 됩니다."); System.exit(1);}
	
	
	Graph g = new Graph(17); // 위치 16개 : 0~6 : 건물 / 7~15 : 길
		// 노드 수 만큼 그래프 생성 
		// 시작, 끝, 간선 가중치 입력 
	
//	System.out.println("최단거리 = 1 / 최소로 걷는 거리 = 2");
//	int walk=sc.nextInt(); //최단 거리 =1 / 최소 걷는 거리(엘리베이터 적극이용) =2
	
	int walk=1;
		 g.input(0, 1, 90,walk);
		 g.input(0, 6, 20,walk);
		 g.input(0, 7, 70,walk);
	     g.input(0, 15, 22,walk);  
	     g.input(1, 2, 80,walk);
	     
		 g.input(1, 12, 40,walk); 
		 g.input(2, 11, 55,walk); 	 
		 g.input(3, 9, 45,walk);	
		 g.input(3, 10, 60,walk);	 
		 g.input(4, 5, 70,walk);
		 
		 g.input(4, 9, 150,walk);
		 g.input(5, 8, 53,walk);
		 g.input(6, 15, 35,walk);
		 g.input(12, 13, 50,walk); //13: 비전타워 계단 이용
		 g.input(12,16,50,walk);
		
		 g.input(6, 13, 127,walk); //계단으로 비전타워를 내려가는 경우  
		 g.input(13, 14, 63,walk);
		 g.input(14,16,63,walk); //16: 비전타워 엘리베이터
		 g.input(6,16,5,walk); //엘리베이터 타는 경우
		 g.input(7, 8, 50,walk);	 
		
		 g.input(8, 14, 55,walk);
		 g.input(9, 10, 85,walk);
		 g.input(10, 11, 95,walk);
		 g.input(10, 14, 142,walk);
		
		 g.dijkstra(startPosition ,lastPosition);

		}//main
	} //class dijkstra_demo
	

class Graph{ 
			
		private int n; // 노드들의 수 
		private int maps[][]; // 노드들간의 가중치 저장할 변수 
		private String[] navigation= new String[17];//가는길 표시
		private String[] road= {"비전타워","법학대학","공과대학2","가천관","공과대학1","IT대학",
								"프리덤 광장","비전타워<->신호등 삼거리 직선 경로","신호등 삼거리",
								"가천관 왼쪽","가천관 오른쪽","웅지관 앞 직선 경로","비전타워 1층, 신한은행 앞, 바나대 대학원 오른쪽",
								"바나대 대학원 앞 직선경로 : 계단","신호등 삼거리 가는쪽, 바나대 대학원 왼쪽에서 갈림길",
								"프리덤 광장 계단","바나대 대학원 앞 직선경로 : 엘리베이터" };	
		
	/*	
		public void Graph() {
			road[0]="비전타워";
			road[1]="법학대학";
			road[2]="공과대학2";
			road[3]="가천관";
			road[4]="공과대학1";
			road[5]="IT대학";
			road[6]="프리덤 광장";
			road[7]="비전타워<->신호등 삼거리 직선 경로";
			road[8]="신호등 삼거리";
			road[9]="가천관 왼쪽";
			road[10]="가천관 오른쪽";
			road[11]="웅지관 앞 직선 경로";
			road[12]="비전타워 1층, 신한은행 앞, 바나대 대학원 오른쪽";
			road[13]="바나대 대학원 앞 직선경로 : 계단";
			road[14]="신호등 삼거리 가는쪽, 바나대 대학원 왼쪽에서 갈림길";
			road[15]="프리덤 광장 계단";
			road[16]="바나대 대학원 앞 직선경로 : 엘리베이터";
		}
		*/
	
		public Graph(int n) {//전체 배열 초기화 : 무한대 
			
			this.n = n;
			maps = new int[n][n]; 
			for(int i=0; i<n; ++i) { 
				for(int j=0; j<n; ++j) { 
					maps[i][j] = Integer.MAX_VALUE;  
				}//for
		 	} //for	
	     } //public Graph
	
		
		public int stringToInt(String s) {
			//문자열을 int형으로 바꿔준다.
			int x = 0;
			for(int i=0; i<road.length; i++) {
				if(road[i]==s) x=i;
			}
			return x;
		}
	
		public void printResult(int start, int last, int distanceValue) {
			/*
			System.out.println("시작점 : "+start);
			System.out.println("도착점 : "+last);
			*/
			
			System.out.println("\n\n최단 거리 : "+distanceValue);
			System.out.println("위치 확인=======\n출발지: "+road[start]);
			System.out.println("목적지: "+road[last]);
			System.out.println("\n경로 확인=======\n"+road[start]+"->"+road[last]);
			System.out.println("");
			
		}//public void printResult
		
		public void input(int i,int j,int w, int walkOrNot)
		{ 
			maps[i][j] = w; 
			maps[j][i] = w; 
		}//public void input
		 
		void dijkstra(int start ,int last) //시작 점 -> 끝 점 : 예제 코드에서는 시작점을 string으로 받음- 내 경우에서는 그걸 정수로 치환했음
		{		
			int distance[] = new int[n]; // 최단 거리를 저장할 변수 
		    boolean[] check = new boolean[n]; // 해당 노드를 방문했는지 체크할 변수 
		    // distance값 초기화. 무한대를 int 자료형의 최대값으로 표현했다. 
		  
		    for(int i=0; i<n; ++i){
		    	distance[i] = Integer.MAX_VALUE; 
		    }//for 
		    
		
		    int x= start; //출발지 초기화과정
		    distance[x]=0;
		    check[x]=true;
		    navigation[x]=road[x]; //시작점의 경로 저장
		    
		    
	/*
		System.out.println("==============================================================================================================================");
		for(int i=0; i<n; i++)System.out.print(i+"\t");
		System.out.println("\n===========================================================================================================================");
		
		    for(int i=0; i<n; ++i)////////////////////////////////////////////////////////////////////////////////////////////////////////////출력하는 부분
		    {	if(distance[i] == 2147483647) 
					System.out.print("∞"+"\t"); 
				else System.out.print(distance[i]+"\t"); 
		    }//for
					System.out.println(""); 
	*/	   
		    
		  		 
		for(int i=0; i<n; ++i){
			if(!check[i] && maps[start][i] != 0){ //방문했던 곳이 아니고 start->i가 이어져 있을때
				distance[i] = maps[start][i]; //누적 거리 : start->i추가
				navigation[i]=road[start];
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
	
			/*
		    for(int i=0; i<n; ++i)////////////////////////////////////////////////////////////////////////////////////////////////////////////출력하는 부분
		    {	if(distance[i] == 2147483647) 
					System.out.print("∞"+"\t"); 
				else System.out.print(distance[i]+"\t"); }
					System.out.println(""); 
		   */
	
	check[min_index] = true; //현 노드 방문

	for(int i=0; i<n; ++i){ 
		if(!check[i] && maps[min_index][i] != Integer.MAX_VALUE){
			if(distance[min_index] + maps[min_index][i] < distance[i]){
				{	
					distance[i] = distance[min_index] + maps[min_index][i]; //새 최단거리 갱신하는 경우==================================
					navigation[i]=road[min_index];

					}//if
				}//if 
			}//if
		}//for
	}//for
		
		
/*
		for(int i=0; i<n; ++i){  /////////////////////////////////////////////////////////////////////////////////////////////////출력하는 부분
			if(distance[i] == 2147483647)
				System.out.print("∞"+"\t"); // 결과값 출력 
			else 
				System.out.print(distance[i]+"\t");
		 }//for

			System.out.println("\n\n");
*/
	

		
printResult(start, last, distance[last]); //print


	String route = "";
	System.out.println("시작 꼭지점 "+road[start]+"부터 꼭지점 "+road[last]+"까지의 경로");
	int index = last;
	while(true) {
		if(navigation[index] == road[index]) break; //시작 꼭지점일 경우 break
		route += navigation[index]+ " <- " ;
		index = stringToInt(navigation[index]); //결정적인 역할을 한 꼭지점을 int형으로 바꿔서 index에 저장 
	}
	StringBuilder sb = new StringBuilder(route);
	System.out.println("경로 : "+road[last]+" < - "+sb.substring(0,sb.length()-4));
		
			
				
	} //void dijkstra

}//class graph
