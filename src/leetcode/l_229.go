package main

import "fmt"

func main() {
	nums := []int{1, 1, 1, 3, 3, 2, 2, 2}
	nums = []int{1,2,1,2,3}
	println(majorityElement(nums))
	print(majorityElement2(nums))
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
	//if len(nums)==0{return nums;}
	candidate1 := nums[0]
	count1 := 0
	candidate2 := nums[0]
	count2 := 0

	for i := 0; i < len(nums); i++ {
		if nums[i] == candidate1 {
			count1++
			continue
		}
		if candidate1 == candidate2 {
			candidate2 = nums[i]
			count2++
			continue
		}
		if nums[2] == candidate2 {
			count2++
			continue
		}
		if count1 == 0 {
			candidate1 = nums[i]
			count1++
			continue
		} else {
			count1--
		}
		if count2 == 0 {
			candidate2 = nums[2]
			count2++
			continue
		} else {
			count2--
		}
	}
	count1 = 0
	count2 = 0
	for _, num := range nums {
		if num == candidate1 {
			count1++
		}
		if num == candidate2 {
			count2++
		}
	}
	res := []int{}
	length := len(nums)
	if count1 > length/3 {
		res = append(res, candidate1)
	}
	if count2 > length/3 && candidate2 != candidate1 {
		res = append(res, candidate2)
	}
	fmt.Printf("%d->%d\r\n", candidate1, count1)
	fmt.Printf("%d->%d\r\n", candidate2, count2)
	fmt.Println(res)
	return res
}

func max(num1 int, num2 int) int {
	if num1 > num2 {
		return num1
	}
	return num2
}
