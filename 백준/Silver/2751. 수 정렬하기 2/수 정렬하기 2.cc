#include <iostream>
using namespace std;

int brr[1000001];

void MergeSort(int arr[], int left, int right) {
	if (left < right) {
		int mid = (left + right) / 2;
		MergeSort(arr, left, mid);
		MergeSort(arr, mid + 1, right);
		//합병
		int i = left;
		int	j = mid + 1;
		int k = left;
		while(i <= mid && j <= right) {
			if (arr[i] < arr[j]) {
				brr[k] = arr[i];
				i++, k++;
			}
			else if (arr[i] > arr[j]) {
				brr[k] = arr[j];
				j++, k++;
			}
		}
		int temp = i > mid ? j : i; // 덜찬거
		while (k <= right) brr[k++] = arr[temp++];
		//if (i < mid + 1) {
		//	for (int a = i; a < mid + 1; a++, k++) {
		//		brr[k] = arr[a];
		//	}
		//}
		//else if (j < right + 1) {
		//	for (int a = j; a < right + 1; a++, k++) {
		//		brr[k] = arr[a];
		//	}
		//}
		for (int a = left; a <= right; a++) {
			arr[a] = brr[a];
		}
	}
}

int main() {
	int n;
	scanf("%d", &n);
	int* arr = new int[n];
	for (int i = 0; i < n; i++) {
		scanf("%d", &arr[i]);
	}
	MergeSort(arr,0,n-1);
	
	for (int i = 0; i < n; i++) {
		printf("%d\n", arr[i]);
	}
	return 0;
}