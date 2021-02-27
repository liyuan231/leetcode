package main

import "fmt"

func main() {
	nums := []int{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}
	fmt.Println(trap(nums))
}
func trap(height []int) int {
	i := 0
	j := len(height) - 1
	res := 0
	left_max := 0
	right_max := 0
	for i < j {
		if height[i] >= height[j] {
			if right_max > height[j] {
				res += right_max - height[j]
			} else {
				right_max = height[j]
			}
			j--
		} else {
			if left_max > height[i] {
				res += left_max - height[i]
			} else {
				left_max = height[i]
			}
			i++
		}
	}
	return res
}
func max3(num1 int, num2 int) int {
	if num1 > num2 {
		return num1
	}
	return num2
}

func min3(num1 int, num2 int) int {
	if num1 > num2 {
		return num2
	}
	return num1
}
