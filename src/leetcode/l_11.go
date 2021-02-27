package main

import "fmt"

func main() {
	var nums []int = []int{1, 1}
	nums = []int{4, 3, 2, 1, 4}
	fmt.Print(maxArea(nums))
}
func maxArea(height []int) int {
	i := 0
	j := len(height) - 1
	res := 0
	for i < j {
		res = max1(res, min1(height[i], height[j])*(j-i))
		if height[i] > height[j] {
			j--
		} else {
			i++
		}
	}
	return res
}

func min1(num1 int, num2 int) int {
	if num1 > num2 {
		return num2
	}
	return num1
}
func max1(num1 int, num2 int) int {
	if num1 > num2 {
		return num1
	}
	return num2
}
