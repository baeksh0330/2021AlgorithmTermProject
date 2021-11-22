package ���õ;

import java.util.Scanner;
public class Dijkstra_demo {

		public static void main(String[] args) 
		{ 
	
			Scanner sc= new Scanner(System.in);
			String start, last;
			
	System.out.println("������� �������� �Է��Ͻÿ�. ");	
	System.out.println("\n(���� swing���� ó���� �� ������ �Ұ�)\n����Ÿ��\n���� �ǹ�\n��������1\n��������2\n��õ��\nIT����\n\n"); //���ڿ��� �Է¹޾Ƽ� ����

	start=sc.nextLine();
	last=sc.nextLine();
	
	int startPosition=-1;
	int lastPosition=-1;
	

	if(start.compareTo("����Ÿ��")==0) startPosition=0; //���ڿ��� �Է¹��� ����� ����(����Ʈ)�� �ٲ��ֱ�

	else if(start.compareTo("���� �ǹ�")==0) startPosition=1;

	else if(start.compareTo("��������1")==0) startPosition=4;

	else if(start.compareTo("��������2")==0) startPosition=2;

	else if(start.compareTo("��õ��")==0) startPosition=3;

	else if(start.compareTo("IT����")==0) startPosition=5;

	else {System.out.println("�� ������Ʈ �˴ϴ�."); System.exit(1);}
	
	
	if(last.compareTo("����Ÿ��")==0) lastPosition=0; //���ڿ��� �Է¹��� ����� ����(����Ʈ)�� �ٲ��ֱ�

	else if(last.compareTo("���� �ǹ�")==0) lastPosition=1;

	else if(last.compareTo("��������1")==0) lastPosition=4;

	else if(last.compareTo("��������2")==0) lastPosition=2;

	else if(last.compareTo("��õ��")==0) lastPosition=3;

	else if(last.compareTo("IT����")==0) lastPosition=5;

	else {System.out.println("�� ������Ʈ �˴ϴ�."); System.exit(1);}
	
	
	Graph g = new Graph(17); // ��ġ 16�� : 0~6 : �ǹ� / 7~15 : ��
		// ��� �� ��ŭ �׷��� ���� 
		// ����, ��, ���� ����ġ �Է� 
	
//	int x= 10000; //���� ��Ȯ�ϰ� �Ÿ� ���� ���ϹǷ� x�� ó����
	
	//��ü ȭ��ǥ = 21��
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
		 g.input(6, 13, 127); //������� ����Ÿ���� �������� ���
		 
		 g.input(14,16,63); //16: ����Ÿ�� ����������
		 g.input(12,16,50);
		 g.input(6,16,5); //���������� Ÿ�� ���
		 
		 g.input(7, 8, 16);	 
		
		 g.input(8, 14, 17);
		 g.input(9, 10, 18);
		 g.input(10, 11, 18);
		 g.input(10, 14, 19);
		 g.input(12, 13, 20);
		 g.input(13, 14, 21);
		
		 
		int result = g.dijkstra(startPosition, lastPosition); //�����, ������
		g.printResult(start, last, result);
		} 
	} 
	

class Graph{ 
			
		private int n; // ������ �� 
		private int maps[][]; 
		// ���鰣�� ����ġ ������ ���� 
		
		public Graph(int n) {
			
			this.n = n;
			maps = new int[n][n]; 
			for(int i=0; i<n; ++i) { 
				for(int j=0; j<n; ++j) { 
					maps[i][j] = Integer.MAX_VALUE;  //��ü �迭 �ʱ�ȭ : ���Ѵ� 
				}//for
		 	} //for
		} //public Graph
		
		
		public void input(int i,int j,int w)
		{ 
			maps[i][j] = w; 
			maps[j][i] = w; 
		}//public void input
		 
		
		public void printResult(String start, String last, int distanceValue) {
			
			System.out.println("������ : "+start);
			System.out.println("������ : "+last);
			System.out.println("�ִ� �Ÿ� : "+distanceValue);
			
		}//public void printResult
		
		int dijkstra(int start ,int last) //���� �� -> �� ��
		{
			int distance[] = new int[n]; // �ִ� �Ÿ��� ������ ���� 
		    boolean[] check = new boolean[n]; // �ش� ��带 �湮�ߴ��� üũ�� ���� 
		// distance�� �ʱ�ȭ. ���Ѵ븦 int �ڷ����� �ִ밪���� ǥ���ߴ�. 
		
		    
		    for(int i=0; i<n; ++i){
		    	distance[i] = Integer.MAX_VALUE; 
		    }//for 

		  		 
		for(int i=0; i<n; ++i){
		 if(!check[i] && maps[start][i] != Integer.MAX_VALUE){ //�湮�ߴ� ���� �ƴϰ� start->i�� �̾��� ������
			 distance[i] = maps[start][i]; //���� �Ÿ� : start->i�߰�
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
		

		
		check[min_index] = true; //�� ��� �湮
		
		for(int i=0; i<n; ++i){ 
			if(!check[i] && maps[min_index][i] != Integer.MAX_VALUE){
				if(distance[min_index] + maps[min_index][i] < distance[i]){
					distance[i] = distance[min_index] + maps[min_index][i];
					}//if 
				}//if
			}//for

	
		}//for
				return distance[last]; //�ִܰŸ� ��ȯ
				
	} //int dijkstra

}//class graph


