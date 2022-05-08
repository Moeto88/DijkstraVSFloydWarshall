// @ author: Moeto Sonoda
public class SortSpeeds {

	int[] mergeSortIterative(int[] speeds) {
		int n = speeds.length;
		int arr[] = new int[n];

		for(int i = 1; i < n; i = i * 2)
		{
			for(int lo = 0; lo < n - i; lo = lo + i * 2)
			{
				merge(speeds, arr, lo, lo + i - 1, Math.min(lo + i * 2 - 1, n - 1));
			}
		}

		return speeds;
	}

	void merge(int[] speeds, int[] arr, int lo, int mid, int hi) {
		for(int k = lo; k <= hi; k++)
		{
			arr[k] = speeds[k];
		}
		int i = lo; //0
		int j = mid + 1; //1
		for(int k = lo; k <= hi; k++)
		{
			if(i > mid)
			{
				speeds[k] = arr[j++];
			}
			else if(j > hi)
			{
				speeds[k] = arr[i++];
			}
			else if(arr[j] < arr[i])
			{
				speeds[k] = arr[j++];
			}
			else
			{
				speeds[k] = arr[i++];
			}
		}
	}
}
