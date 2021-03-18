package main

import "fmt"

func main() {
	nums := []int{0, 0, 1, 1, 1, 1, 2, 3, 3}
	removeDuplicates3(nums)
}

//i指向下一个将要放置的下标
func removeDuplicates3(nums []int) int {
	i := 0
	j := 0
	for j < len(nums) {
		if i == 0 || i == 1 || (nums[j] != nums[i-2]) {
			nums[i] = nums[j]
			i++
			j++
		} else {
			j++
		}
	}
	fmt.Println(i, "->", nums)
	return i
}
