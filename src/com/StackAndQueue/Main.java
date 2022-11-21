package com.StackAndQueue;

import java.util.HashSet;
import java.util.Stack;

public class Main {

	// Chocolates
	public static int chocolates(int N, int M) {
		return N/(gcd (N,M));
	}

	public static int gcd(int a, int b) {
		if(a%b==0) {
			return b;
		}
		return gcd(b,a%b);
	}

	//Binary Gap -  Using the "concept of bit manipulation" and "& operation"
	public int LongestBinaryGap(int N) {
		int longestBinaryGap=0;
		boolean counting=false;
		int zeroCount=0;
		while(N!=0){
			if(!counting){
				if((N&1)==1){
					counting=true;
				}
			}
			else{
				if((N&1)==0) {
					zeroCount++;
				}
				else{
					if(zeroCount>0) {
						longestBinaryGap=Math.max(longestBinaryGap, zeroCount);
						zeroCount=0;
					}
				}
			}
			N=N>>1;
		}
		return longestBinaryGap;
	}

	//Frog Jump
	public int frogJump(int X, int Y, int D) {
		int steps=0;
		int difference=Y-X;
		if(difference%D>0) {
			steps=1;
		}
		steps+=difference/D;
		return steps;
	}

	//MissingElem in permutation
	public int permMissingElem(int[] A) {
		if(A.length==0){
			return 1;
		}

		if(A.length==0){
			return 0;
		}
		long missingElem=((2+A.length)*(A.length+1))/2;
		for(int i=0;i<A.length;i++){
			missingElem-=A[i];
		}
		return (int) missingElem;
	}

	//CountFactors
	public int countFactors(int N) {
		int totalFactors=0;
		int sqrt = (int)Math.sqrt(N);
		for(int i=1;i<=sqrt;i++) {
			if(N%i==0) {
				totalFactors++;
				if(i!=N/i) {
					totalFactors++;
				}
			}
		}
		return totalFactors;
	}

	//Minimum perimieter
	public int minPerimeter(int N) {
		int minPerimeter=2*(N+1);
		int sqrt = (int)Math.sqrt(N);
		int perimeter=0;
		for(int i=1;i<=sqrt;i++) {
			if(N%i==0) {
				int a = N/i;
				perimeter = 2*(a+i);
				minPerimeter=Math.min(perimeter, minPerimeter);
			}
		}
		return minPerimeter;
	}

	//Iterating Caterpillar
	public boolean iterateCaterpillar(int[]A,int sum) {
		int tail=0,head=0,total=0;
		for(tail=0;tail<A.length;tail++) {
			while(head<A.length && total+A[head]<=sum) {
				total+=A[head];
				head++;
			}
			if(total!=sum) {
				total-=A[tail];
			}
			else {
				return true;
			}
		}
		return false;
	}

	//Absolute distinct count
	public int absDistCount(int[] A) {
		int distinctCount=1;
		HashSet<Integer> set = new HashSet<Integer>();
		for(int i=0;i<A.length;i++) {
			set.add(Math.abs(A[i]));
		}
		distinctCount=set.size();
		return distinctCount;
	}

	//Distinct Slices
	public int distinctSlices(int M, int[] A) {
		boolean[] distinctElems = new boolean[M+1];
		int tail=0;
		int head=0;
		int distinctSlice =0;
		while(tail < A.length){
			if(head < A.length && distinctElems[A[head]]== false){
				distinctSlice+=head-tail+1;
				if(distinctSlice >= 1000000000)
					return 1_000_000_000;
				distinctElems[A[head]] = true;
				head++;
			}
			else{
				distinctElems[A[tail]]=false;
				tail++;
			}
		}
		return distinctSlice;
	}

	//MaxNonOverLappingSegments
	public int maxNonOverLappingSegments(int[] A, int[] B) {
		if(A.length==0) {
			return 0;
		}
		int maxNonOverLap=1;
		int rightEnd = B[0];
		for(int i=1;i<A.length;i++) {
			if(A[i]>rightEnd) {
				maxNonOverLap++;
				rightEnd=B[i];
			}
		}
		return maxNonOverLap;
	}

	//Tie ropes
	public int tieRopes(int K, int[]A) {
		int maxRopes=0;
		int ropeLength=0;
		for(int i=0;i<A.length;i++) {
			ropeLength+=A[i];
			if(ropeLength>=K) {
				maxRopes++;
				ropeLength=0;
			}
		}
		return maxRopes;
	}

	//CountDiv
	public int countDiv(int A, int B, int K) {
		int divCount=0;
		if(A%K==0) {
			divCount++;
		}
		divCount+=Math.floor(B/K)-Math.floor(A/K);
		return divCount;
	}

	public int solution(String S) {
		int possibleWays=0;
		String part1="", part2="";
		for(int i=1;i<S.length();i++) {
			if(S.charAt(i)=='a') {
				part1=S.substring(0,i);
			}
			part1=S.substring(0,i);
			part2=S.substring(i,S.length());
			if(checkCharA(part1) && checkCharA(part2)) {
				possibleWays++;
			}
		}
		return possibleWays;
	}

	private boolean checkCharA(String part) {
		int aCount=0;
		for(int i=0;i<part.length();i++) {
			if(part.charAt(i)=='a') {
				aCount++;
			}
		}
		if(aCount%2==0) {
			return true;
		}
		return false;
	}

	public static void main(String[] args) throws StackOutOfBoundException  {

		StackAndQueue sq = new StackAndQueue();

		//Proper nesting of parentheses, braces	, and brackets
		//		System.out.println(sq.solution(")("));

		//		int[]A= {4,5,3,1,4,2,6};
		//		int[]B= {0,1,1,0,0,1,0};
		//		System.out.println(sq.solution(A, B));

		//		System.out.println("No of eaten chocolates: "+solution(7,3));

		Main main = new Main();
		//		int[] A= {4,2,1,5};
		//		System.out.println(main.solution(A));

		//		int[]H= {8,8,5,7,9,8,7,4,8};
		//		sq.stoneWall(H);

		//Factors
		//		System.out.println("Total Factors: "+main.countFactors(2147483647));

		//Min Perimeter
		//		System.out.println("Minimum perimeter of the rectangle: "+main.minPerimeter(30));

		//Caterpillar
		//		int[]A= {6,2,7,4,1,3,6};
		//		System.out.println(main.iterateCaterpillar(A,9));

		//Absolute distinct count
		//		int[]A= {-5,-3,-1,0,3,6,5};
		//		System.out.println("Absolute Distinct Count: "+main.absDistCount(A));

		//Distinct Slices
		//		int[]A= {1000000000, 1000000000};
		//		System.out.println("Number of Distinct Slices: "+main.distinctSlices(1000000000, A));

		//MaxNonOverLappingSegments
		//		int[]A= {1,3,7,9,9};
		//		int[]B= {5,6,8,9,10};
		//		System.out.println("Max Non-overlapping segments: "+main.maxNonOverLappingSegments(A, B));

		//Tie Ropes
		//		int[]A= {1,2,3,4,1,1,3};
		//		System.out.println("Maximum Rope count "+main.tieRopes(4, A));

		//countDiv
		//		System.out.println("Count of divisibles "+main.countDiv(6, 11, 2));

		//infix to prefix
		//		System.out.println("Infix to prefix: "+sq.infixToPrefix("(A+B*c-d*E"));

		//Stack of Plates
		//		SetOfStacks stacksSet = new SetOfStacks();
		//		for(int i=1;i<=35;i++) {
		//			stacksSet.push(i);
		//		}
		//		for(int i=1;i<=9;i++) {
		//			stacksSet.pop();
		//		}
		//		stacksSet.popAt(0);
		//		stacksSet.printStackList();

		//Queue via Stacks
		//		MyQueue myQueue = new MyQueue();
		//		for(int i=1;i<=6;i++) {
		//			myQueue.add(i);
		//		}
		//		System.out.println(myQueue.remove());
		//		System.out.println(myQueue.remove());
		//		System.out.println(myQueue.peek());
		//		myQueue.add(7);
		//		System.out.println(myQueue.remove());
		//		System.out.println(myQueue.peek());

		//Sorting Stacks
		Stack<Integer> st = new Stack<Integer>();
		st.push(8);
		st.push(1);
		st.push(5);
		st.push(3);
		st.push(4);
		st.push(7);
		st.push(12);
		sq.sortStack(st);

		//Animal Shelter
		//		AnimalQueue animalQueue = new AnimalQueue();
		//		animalQueue.eneque(new Dog("Tommy"));
		//		animalQueue.eneque(new Cat("Jingles"));
		//		animalQueue.eneque(new Dog("Rocky"));
		//		animalQueue.eneque(new Dog("Tuffy"));
		//		animalQueue.eneque(new Cat("Maria"));
		//		animalQueue.printAnimalQueue();
		//		System.out.println("____");
		//		animalQueue.printCatQueue();
		//		System.out.println("____");
		//		animalQueue.printDogQueue();
		//		System.out.println("____");
		//		System.out.println(animalQueue.dequeAny().name);
		//		System.out.println("____");
		//		animalQueue.printDogQueue();
		//		System.out.println("____");
		//		System.out.println(animalQueue.dequeAny().name);
		//		System.out.println("____");
		//		System.out.println(animalQueue.dequeCat().name);
		//		System.out.println("____");
		//		animalQueue.printCatQueue();
		//		System.out.println("____");
		//		animalQueue.printAnimalQueue();
		//		System.out.println("____");
		//		System.out.println(animalQueue.dequeDog().name);
		//		System.out.println("____");
		//		animalQueue.printDogQueue();
		//		System.out.println("____");
		//		animalQueue.printAnimalQueue();

		//Equal Stacks
		//		List<Integer> h1 = new ArrayList<Integer>();
		//		h1.add(3);
		//		h1.add(2);
		//		h1.add(1);
		//		h1.add(1);
		//		h1.add(1);
		//		List<Integer> h2 = new ArrayList<Integer>();
		//		h2.add(4);
		//		h2.add(3);
		//		h2.add(2);
		//		List<Integer> h3 = new ArrayList<Integer>();
		//		h3.add(1);
		//		h3.add(1);
		//		h3.add(4);
		//		h3.add(1);
		//		System.out.println("Sum at equal stack: "+sq.equalStacks(h1, h2, h3));

		//Towers of Hanoi
		//		Stack<Integer> source = new Stack<Integer>();
		//		source.push(5);
		//		source.push(4);
		//		source.push(3);
		//		source.push(2);
		//		source.push(1);
		//		Stack<Integer> buffer = new Stack<Integer>();
		//		Stack<Integer> destination = new Stack<Integer>();
		//		sq.moveStacks(5, source, buffer, destination);
		return;
	}

}
