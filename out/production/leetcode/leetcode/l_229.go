package main

import "fmt"

func main() {
	nums := []int{1, 1, 1, 3, 3, 2, 2, 2}
	//nums = []int{1,2,1,2,3}
	nums = []int{1}
	fmt.Println(majorityElement(nums))
	fmt.Println(majorityElement2(nums))
}

//1.要明确最多仅有两个众数，因为出现次数要大于 3/n
func majorityElement(nums []int) []int {
	var m = map[int]int{}
	res := []int{}
	for _, num := range nums {
		m[num] = m[num] + 1
	}
	limit := len(nums) / 3
	for key, val := range m {
		if val > limit {
			res = append(res, key)
		}
	}
	//fmt.Println(res)
	return res
}
func majorityElement2(nums []int) []int {
	candidate0 := nums[0]
	count0 := 0
	candidate1 := nums[0]
	count1 := 0
	for _, num := range nums {
		if num == candidate1 {
			count1++
			continue
		}
		if num == candidate0 {
			count0++
			continue
		}
		if count0 == 0 {
			candidate0 = num
			count0++
			continue
		}
		if count1 == 0 {
			candidate1 = num
			count1++
			continue
		}
		count0--
		count1--
	}

	count0 = 0
	count1 = 0

	for _, num := range nums {
		if num == candidate1 {
			count1++
		}
		if num == candidate0 {
			count0++
		}
	}
	limit := len(nums) / 3
	res := []int{}
	if count0 > limit {
		res = append(res, candidate0)
	}
	if count1 > limit {
		res = append(res, candidate1)
	}
	return res
}

func max(num1 int, num2 int) int {
	if num1 > num2 {
		return num1
	}
	return num2
}
