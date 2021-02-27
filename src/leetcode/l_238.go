package main

import "fmt"

func main() {
	nums := []int{1, 2, 3, 4}
	nums = []int{9, 0, -2}
	fmt.Println(productExceptSelf(nums))

}

func productExceptSelf(nums []int) []int {
	//可以先尝试预先构造出preMul
	length := len(nums)
	nums0 := make([]int, length)
	nums0[0] = 1
	nums1 := make([]int, length)
	nums1[length-1] = 1
	//不能包括本身
	for i := 1; i < length; i++ {
		nums0[i] = nums0[i-1] * nums[i-1]
	}
	for i := length - 2; i >= 0; i-- {
		nums1[i] = nums1[i+1] * nums[i+1]
	}
	fmt.Println(nums0)
	fmt.Println(nums1)
	res := make([]int, length)
	for i := 0; i < length; i++ {
		res[i] = nums0[i] * nums1[i]
	}
	return res
}
