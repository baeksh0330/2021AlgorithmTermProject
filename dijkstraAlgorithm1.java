package 어디가천;

import java.util.*;
public class dijkstraAlgorithm1 {

	public static void main(String[] args) {
		
		Scanner sc= new Scanner(System.in);
		int numOfNodes=sc.nextInt();
		Graph g= new Graph(numOfNodes);
		
		/*
		 * 노드간 거리 설정 임의로 해줘야하는 부분 + 시작 노드에서부터 다익스트라 알고리즘 돌리기
		 */
	}

}

class Graph{
	
	private int n;
	private int value[][];
	//private String nameOfBuilding[]; //: 건물 이름
	public Graph(int n) //노드의 개수 =n개
	{
		this.n=n;
		value=new int[n][n];
		
		for(int i=0; i<n; i++)
		{
			for(int j=0; j<n; j++)
			{
				value[i][j]=Integer.MAX_VALUE; //최댓값으로 초기화
			} //for
		}//for
		
	}//public Graph

	public void input(int i, int j ,int w) //거리 값 넣기
	{
		value[i][j]=w;
		value[j][i]=w;	
	}//public void input
	
	public void dijkstra(int start, int alpha){ // alpha =조건이 들어왔을때 바꿔줄 가중치(+-) ,start=시작노드
		
		int shortest_walking[]=new int[n]; //최단거리 선언(걸어서) : n=노드의 개수
	//	int shortest_option[]=new int[n]; //최단거리 선언(옵션이 추가되었을때 : alpha)
		boolean visited[]= new boolean[n]; //방문한 노드 개수 체크
	
		for(int i=0; i<n; i++)
			{
				shortest_walking[i]=Integer.MAX_VALUE; //최단거리 초기화
			//	shortest_option[i]=Integer.MAX_VALUE; //최단거리 초기화
			}//for

		
		
		
		for(int i=0; i<n; i++) //최단거리 찍기
		{
			if(!visited[i] && value[start][i]!=Integer.MAX_VALUE)
				{	
					shortest_walking[i]=value[start][i];
				//거리 위주로 먼저 구현 후 지나간 건물 이름도 출력	
				}
				
		}//for
		

		for(int i=0; i<n-1; ++i)
		{
			int min=Integer.MAX_VALUE;
			int min_ind=-1;
			
			
			for(int a=0; a<n; ++a)
			{
				if(!visited[a])
				{
					if(shortest_walking[a]<min)
					{
						min=shortest_walking[a];
						min_ind=a;
					} //if
				}//if
			}//for		
		
		
		
		
		//결과값 출력하는 부분 
		/*
		 * for(int i=0; i<n; i++){
		
			if(shortest_walking[i]==Integer.MAX_VALUE) System.out.println("∞");
			else
				System.out.print(shortest_walking[i]+" ");	
		}//for
		System.out.println("");
		 */
		
		}//for	
	}//public void dijkstra
	
	
	
}//class Graph