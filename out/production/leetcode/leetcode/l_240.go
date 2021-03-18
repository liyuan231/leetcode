package main

import "fmt"

func main() {
	nums := [][]int{
		{1, 4, 7, 11, 15},
		{2, 5, 8, 12, 19},
		{3, 6, 9, 16, 22},
		{10, 13, 14, 17, 24},
		{18, 21, 23, 26, 30},
	}
	target := 8
	//fmt.Println(searchMatrix(nums, target))
	fmt.Println(searchMatrix2(nums, target))
}

func searchMatrix2(matrix [][]int, target int) bool {
	i := len(matrix) -1
	j := 0
	for i >= 0 && j < len(matrix[0]) {
		if matrix[i][j] == target {
			return true
		}
		if matrix[i][j] < target {
			j++;
			continue;
		}
		if matrix[i][j] > target {
			i--;
		}
	}
	return false

}
func searchMatrix(matrix [][]int, target int) bool {
	for i := 0; i < len(matrix); i++ {
		if binarySearch(matrix[i], target) != -1 {
			return true
		}
	}
	return false
}

func binarySearch(nums []int, target int) int {
	l := 0
	r := len(nums) - 1
	for l <= r {
		mid := l + (r-l)/2
		if nums[mid] == target {
			return mid
		}
		if nums[mid] < target {
			l = mid + 1
		}
		if nums[mid] > target {
			r = mid - 1
		}
	}
	return -1
}
