package main

import "fmt"

func main() {
	nums := []int{1, 7, 3, 6, 5, 6}
	//nums = []int{1, 2, 3}
	//nums = []int{-1, -1, -1, -1, -1, 0}
	fmt.Println(pivotIndex(nums))
}

func pivotIndex(nums []int) int {
	length := len(nums)
	sum := 0
	for i := 0; i < length; i++ {
		sum += nums[i]
	}
	sumLeft := 0
	for i := 0; i < length; i++ {
		if sumLeft*2+nums[i] == sum {
			return i
		}
		sumLeft += nums[i]
	}
	return -1
}
