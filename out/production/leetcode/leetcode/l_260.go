package main

import "fmt"

func main() {
	nums := []int{1, 1, 3, 3, 5, 5, 7, 66}
	nums = []int{1, 2, 1, 3, 2, 5}
	nums = []int{0, 1, 2, 2}
	fmt.Println(singleNumber(nums))

}

func singleNumber(nums []int) []int {
	mask := nums[0]
	ans := []int{}
	for i := 1; i < len(nums); i++ {
		mask ^= nums[i]
	}
	diff := mask & (-mask)
	x := 0
	for index := range nums {
		if nums[index]&diff != 0 {
			x ^= nums[index]
		}
	}
	fmt.Println(diff)
	ans = append(ans, x, mask^x)
	return ans
}
