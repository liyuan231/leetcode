package main

import "fmt"

func main() {
	//fmt.Println(1)
	fmt.Println("res:", nthUglyNumber(10))
	//fmt.Println(isUgly_(11))
	//newUgly()
}

func newUgly() []int {
	i2 := 0
	i3 := 0
	i5 := 0
	var nums = make([]int, 20)
	nums[0] = 1
	for i := 1; i < len(nums); i++ {
		nums2 := 2 * nums[i2]
		nums3 := 3 * nums[i3]
		nums5 := 5 * nums[i5]
		ugly := Min(2*nums[i2], 3*nums[i3], 5*nums[i5])
		nums[i] = ugly
		if ugly == nums2 {
			i2++
		}
		if ugly == nums3 {
			i3++
		}
		if ugly == nums5 {
			i5++
		}
	}
	fmt.Println(nums)
	return nums
}

func Min(num1 int, num2 int, num3 int) int {
	return min(num1, min(num2, num3))
}

func min(num1 int, num2 int) int {
	if num1 > num2 {
		return num2
	}
	return num1
}

var ugly []int = newUgly()

func nthUglyNumber(n int) int {
	return ugly[n - 1]
}
