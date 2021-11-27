package ���õ;

import java.util.*;
import java.io.*;

public class Dijkstra_demo {

	/**
	 * 0=����Ÿ��
	 * 1=����ǹ�(��Ÿ�� ����)
	 * 2=�����ǹ�2
	 * 3=��õ��
	 * 4=�����ǹ�1
	 * 5=IT����
	 * ==============
	 * 6=����������
	 * 7=��Ÿ-��ȣ�� �Ÿ�
	 * 8=��ȣ�� �� ��Ÿ�
	 * 9=��õ�� ���� ��
	 * 10=��õ�� ������ ��
	 * 11=������ �� ���� �Ÿ�
	 * 12=��Ÿ 1��, �ٳ��� ���п� ������ 
	 * 13(=16)=�ٳ��� ���п� �� �������� �Ÿ�
	 * 14=��Ÿ� ������, �ٳ��� ���п� ���ʿ��� ������
	 * 15=���������� ���
	 */	

	
	
public static void main(String[] args){ 
	
		Scanner sc= new Scanner(System.in);
		String start, last;

	System.out.println("������� �������� �Է��Ͻÿ�. ");	
	System.out.println("\n����Ÿ��\n���д���\n��������1\n��������2\n��õ��\nIT����\n\n"); //���ڿ��� �Է¹޾Ƽ� ����

	start=sc.nextLine();
	last=sc.nextLine();
	
	int startPosition=-1;
	int lastPosition=-1;

	if(start.compareTo("����Ÿ��")==0) startPosition=0; //���ڿ��� �Է¹��� ����� ����(����Ʈ)�� �ٲ��ֱ�

	else if(start.compareTo("���д���")==0) startPosition=1;

	else if(start.compareTo("��������1")==0) startPosition=4;

	else if(start.compareTo("��������2")==0) startPosition=2;

	else if(start.compareTo("��õ��")==0) startPosition=3;

	else if(start.compareTo("IT����")==0) startPosition=5;

	else {System.out.println("�� ������Ʈ �˴ϴ�."); System.exit(1);}
	
	
	if(last.compareTo("����Ÿ��")==0) lastPosition=0; //���ڿ��� �Է¹��� ����� ����(����Ʈ)�� �ٲ��ֱ�

	else if(last.compareTo("���д���")==0) lastPosition=1;

	else if(last.compareTo("��������1")==0) lastPosition=4;

	else if(last.compareTo("��������2")==0) lastPosition=2;

	else if(last.compareTo("��õ��")==0) lastPosition=3;

	else if(last.compareTo("IT����")==0) lastPosition=5;

	else {System.out.println("�� ������Ʈ �˴ϴ�."); System.exit(1);}
	
	
	Graph g = new Graph(17); // ��ġ 16�� : 0~6 : �ǹ� / 7~15 : ��
		// ��� �� ��ŭ �׷��� ���� 
		// ����, ��, ���� ����ġ �Է� 
	
//	System.out.println("�ִܰŸ� = 1 / �ּҷ� �ȴ� �Ÿ� = 2");
//	int walk=sc.nextInt(); //�ִ� �Ÿ� =1 / �ּ� �ȴ� �Ÿ�(���������� �����̿�) =2
	
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
		 g.input(12, 13, 50,walk); //13: ����Ÿ�� ��� �̿�
		 g.input(12,16,50,walk);
		
		 g.input(6, 13, 127,walk); //������� ����Ÿ���� �������� ���  
		 g.input(13, 14, 63,walk);
		 g.input(14,16,63,walk); //16: ����Ÿ�� ����������
		 g.input(6,16,5,walk); //���������� Ÿ�� ���
		 g.input(7, 8, 50,walk);	 
		
		 g.input(8, 14, 55,walk);
		 g.input(9, 10, 85,walk);
		 g.input(10, 11, 95,walk);
		 g.input(10, 14, 142,walk);
		
		 g.dijkstra(startPosition ,lastPosition);

		}//main
	} //class dijkstra_demo
	

class Graph{ 
			
		private int n; // ������ �� 
		private int maps[][]; // ���鰣�� ����ġ ������ ���� 
		private String[] navigation= new String[17];//���±� ǥ��
		private String[] road= {"����Ÿ��","���д���","��������2","��õ��","��������1","IT����",
								"������ ����","����Ÿ��<->��ȣ�� ��Ÿ� ���� ���","��ȣ�� ��Ÿ�",
								"��õ�� ����","��õ�� ������","������ �� ���� ���","����Ÿ�� 1��, �������� ��, �ٳ��� ���п� ������",
								"�ٳ��� ���п� �� ������� : ���","��ȣ�� ��Ÿ� ������, �ٳ��� ���п� ���ʿ��� ������",
								"������ ���� ���","�ٳ��� ���п� �� ������� : ����������" };	
		
	/*	
		public void Graph() {
			road[0]="����Ÿ��";
			road[1]="���д���";
			road[2]="��������2";
			road[3]="��õ��";
			road[4]="��������1";
			road[5]="IT����";
			road[6]="������ ����";
			road[7]="����Ÿ��<->��ȣ�� ��Ÿ� ���� ���";
			road[8]="��ȣ�� ��Ÿ�";
			road[9]="��õ�� ����";
			road[10]="��õ�� ������";
			road[11]="������ �� ���� ���";
			road[12]="����Ÿ�� 1��, �������� ��, �ٳ��� ���п� ������";
			road[13]="�ٳ��� ���п� �� ������� : ���";
			road[14]="��ȣ�� ��Ÿ� ������, �ٳ��� ���п� ���ʿ��� ������";
			road[15]="������ ���� ���";
			road[16]="�ٳ��� ���п� �� ������� : ����������";
		}
		*/
	
		public Graph(int n) {//��ü �迭 �ʱ�ȭ : ���Ѵ� 
			
			this.n = n;
			maps = new int[n][n]; 
			for(int i=0; i<n; ++i) { 
				for(int j=0; j<n; ++j) { 
					maps[i][j] = Integer.MAX_VALUE;  
				}//for
		 	} //for	
	     } //public Graph
	
		
		public int stringToInt(String s) {
			//���ڿ��� int������ �ٲ��ش�.
			int x = 0;
			for(int i=0; i<road.length; i++) {
				if(road[i]==s) x=i;
			}
			return x;
		}
	
		public void printResult(int start, int last, int distanceValue) {
			/*
			System.out.println("������ : "+start);
			System.out.println("������ : "+last);
			*/
			
			System.out.println("\n\n�ִ� �Ÿ� : "+distanceValue);
			System.out.println("��ġ Ȯ��=======\n�����: "+road[start]);
			System.out.println("������: "+road[last]);
			System.out.println("\n��� Ȯ��=======\n"+road[start]+"->"+road[last]);
			System.out.println("");
			
		}//public void printResult
		
		public void input(int i,int j,int w, int walkOrNot)
		{ 
			maps[i][j] = w; 
			maps[j][i] = w; 
		}//public void input
		 
		void dijkstra(int start ,int last) //���� �� -> �� �� : ���� �ڵ忡���� �������� string���� ����- �� ��쿡���� �װ� ������ ġȯ����
		{		
			int distance[] = new int[n]; // �ִ� �Ÿ��� ������ ���� 
		    boolean[] check = new boolean[n]; // �ش� ��带 �湮�ߴ��� üũ�� ���� 
		    // distance�� �ʱ�ȭ. ���Ѵ븦 int �ڷ����� �ִ밪���� ǥ���ߴ�. 
		  
		    for(int i=0; i<n; ++i){
		    	distance[i] = Integer.MAX_VALUE; 
		    }//for 
		    
		
		    int x= start; //����� �ʱ�ȭ����
		    distance[x]=0;
		    check[x]=true;
		    navigation[x]=road[x]; //�������� ��� ����
		    
		    
	/*
		System.out.println("==============================================================================================================================");
		for(int i=0; i<n; i++)System.out.print(i+"\t");
		System.out.println("\n===========================================================================================================================");
		
		    for(int i=0; i<n; ++i)////////////////////////////////////////////////////////////////////////////////////////////////////////////����ϴ� �κ�
		    {	if(distance[i] == 2147483647) 
					System.out.print("��"+"\t"); 
				else System.out.print(distance[i]+"\t"); 
		    }//for
					System.out.println(""); 
	*/	   
		    
		  		 
		for(int i=0; i<n; ++i){
			if(!check[i] && maps[start][i] != 0){ //�湮�ߴ� ���� �ƴϰ� start->i�� �̾��� ������
				distance[i] = maps[start][i]; //���� �Ÿ� : start->i�߰�
				navigation[i]=road[start];
			 }//if  				
		}//for
		
			 	
		for(int a=0; a<n-1; ++a){
			int min = Integer.MAX_VALUE; int min_index = -1; 
	// ��� �ּҰ� ã�� 
			for(int i=0; i<n; ++i){ 
				if(!check[i]){
					if(distance[i] < min) { 
					min = distance[i]; min_index = i; 
				}//if
			} //for
		} //for
	
			/*
		    for(int i=0; i<n; ++i)////////////////////////////////////////////////////////////////////////////////////////////////////////////����ϴ� �κ�
		    {	if(distance[i] == 2147483647) 
					System.out.print("��"+"\t"); 
				else System.out.print(distance[i]+"\t"); }
					System.out.println(""); 
		   */
	
	check[min_index] = true; //�� ��� �湮

	for(int i=0; i<n; ++i){ 
		if(!check[i] && maps[min_index][i] != Integer.MAX_VALUE){
			if(distance[min_index] + maps[min_index][i] < distance[i]){
				{	
					distance[i] = distance[min_index] + maps[min_index][i]; //�� �ִܰŸ� �����ϴ� ���==================================
					navigation[i]=road[min_index];

					}//if
				}//if 
			}//if
		}//for
	}//for
		
		
/*
		for(int i=0; i<n; ++i){  /////////////////////////////////////////////////////////////////////////////////////////////////����ϴ� �κ�
			if(distance[i] == 2147483647)
				System.out.print("��"+"\t"); // ����� ��� 
			else 
				System.out.print(distance[i]+"\t");
		 }//for

			System.out.println("\n\n");
*/
	

		
printResult(start, last, distance[last]); //print


	String route = "";
	System.out.println("���� ������ "+road[start]+"���� ������ "+road[last]+"������ ���");
	int index = last;
	while(true) {
		if(navigation[index] == road[index]) break; //���� �������� ��� break
		route += navigation[index]+ " <- " ;
		index = stringToInt(navigation[index]); //�������� ������ �� �������� int������ �ٲ㼭 index�� ���� 
	}
	StringBuilder sb = new StringBuilder(route);
	System.out.println("��� : "+road[last]+" < - "+sb.substring(0,sb.length()-4));
		
			
				
	} //void dijkstra

}//class graph
