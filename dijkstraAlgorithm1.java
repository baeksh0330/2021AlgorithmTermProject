package ���õ;

import java.util.*;
public class dijkstraAlgorithm1 {

	public static void main(String[] args) {
		
		Scanner sc= new Scanner(System.in);
		int numOfNodes=sc.nextInt();
		Graph g= new Graph(numOfNodes);
		
		/*
		 * ��尣 �Ÿ� ���� ���Ƿ� ������ϴ� �κ� + ���� ��忡������ ���ͽ�Ʈ�� �˰��� ������
		 */
	}

}

class Graph{
	
	private int n;
	private int value[][];
	//private String nameOfBuilding[]; //: �ǹ� �̸�
	public Graph(int n) //����� ���� =n��
	{
		this.n=n;
		value=new int[n][n];
		
		for(int i=0; i<n; i++)
		{
			for(int j=0; j<n; j++)
			{
				value[i][j]=Integer.MAX_VALUE; //�ִ����� �ʱ�ȭ
			} //for
		}//for
		
	}//public Graph

	public void input(int i, int j ,int w) //�Ÿ� �� �ֱ�
	{
		value[i][j]=w;
		value[j][i]=w;	
	}//public void input
	
	public void dijkstra(int start, int alpha){ // alpha =������ �������� �ٲ��� ����ġ(+-) ,start=���۳��
		
		int shortest_walking[]=new int[n]; //�ִܰŸ� ����(�ɾ) : n=����� ����
	//	int shortest_option[]=new int[n]; //�ִܰŸ� ����(�ɼ��� �߰��Ǿ����� : alpha)
		boolean visited[]= new boolean[n]; //�湮�� ��� ���� üũ
	
		for(int i=0; i<n; i++)
			{
				shortest_walking[i]=Integer.MAX_VALUE; //�ִܰŸ� �ʱ�ȭ
			//	shortest_option[i]=Integer.MAX_VALUE; //�ִܰŸ� �ʱ�ȭ
			}//for

		
		
		
		for(int i=0; i<n; i++) //�ִܰŸ� ���
		{
			if(!visited[i] && value[start][i]!=Integer.MAX_VALUE)
				{	
					shortest_walking[i]=value[start][i];
				//�Ÿ� ���ַ� ���� ���� �� ������ �ǹ� �̸��� ���	
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
		
		
		
		
		//����� ����ϴ� �κ� 
		/*
		 * for(int i=0; i<n; i++){
		
			if(shortest_walking[i]==Integer.MAX_VALUE) System.out.println("��");
			else
				System.out.print(shortest_walking[i]+" ");	
		}//for
		System.out.println("");
		 */
		
		}//for	
	}//public void dijkstra
	
	
	
}//class Graph