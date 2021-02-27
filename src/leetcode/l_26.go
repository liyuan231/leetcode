package main

import "fmt"

func main() {
	fmt.Println(removeDuplicates([]int{0, 0, 1, 1, 1, 2, 2, 3, 3, 4}))

}

func removeDuplicates(nums []int) int {
	i := 0
	j := 0
	for j < len(nums) {
		if i == 0 || nums[j] != nums[i-1] {
			nums[i] = nums[j]
			j++
			i++
		} else {
			j++
		}
	}
	return i

}
