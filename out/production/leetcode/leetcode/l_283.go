package main

import "fmt"

func main() {
	nums := []int{0, 1, 0, 3, 12}
	moveZeroes(nums)
}
func moveZeroes(nums []int) {
	i := 0
	j := 0
	for j < len(nums) {
		if nums[j] == 0 {
			j++
		} else {
			nums[i] = nums[j]
			i++
			j++
		}
	}
	for i < j {
		nums[i] = 0
		i++
	}
	fmt.Println(nums)

}
