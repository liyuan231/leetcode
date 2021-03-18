package main

import "fmt"

func main() {
	fmt.Print(isUgly(0))
	//fmt.Println(isUgly_(0))
}

func isUgly(num int) bool {
	if num == 0 {
		return false
	}
	nums := []int{2, 3, 5}
	for num != 1 {
		i := 0
		for ; i < len(nums); i++ {
			if num%nums[i] == 0 {
				num = num / nums[i]
				break
			}
		}
		if i == len(nums) {
			return false
		}
	}
	return true
}
