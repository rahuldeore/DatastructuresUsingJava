import java.io.*;

class ArrayDemo
{
	static int arr[] = {9,4,3,7,2,5,8,6,1};
	public static void main(String args[])
	{
		/*arr = new int[10];
		
		System.out.println("Enter 10 elements of integer array");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try
		{
			for (int i=0; i<10; i++)
			{
				System.out.print("Enter element at index "+i+": ");
				arr[i] = Integer.parseInt(br.readLine());
			}
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}*/
		System.out.println("Input Complete\nNow printing array");
		
		printArray();
		
		//insertion sort
		
		System.out.println("Insertion Sorting the array");
		int j = 0, key = 0;
		for(int i=1; i<arr.length; i++)
		{
			key = arr[i];
			j = i-1;
			//System.out.println(i);
			while( j >= 0 && key < arr[j])
			{
				//System.out.println(j);
				arr[j+1] = arr[j];
				j--;
			}
			arr[j+1] = key;
		}
		
		System.out.println("Sorting Complete\nNow printing array");
		printArray();
	}
	public static void printArray()
	{
		for (int i=0; i<arr.length; i++)
		{
			System.out.print(arr[i]+"\t");
		}
		System.out.println("");
	}
}