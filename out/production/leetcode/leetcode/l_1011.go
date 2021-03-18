package main

import "fmt"

func main() {
	nums := []int{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}
	num := 5
	fmt.Println(shipWithinDays(nums, num))
}
func shipWithinDays(weights []int, D int) int {
	lo := min5(weights)
	hi := max5(weights)
	for lo < hi {
		mid := lo + (hi-lo)/2
		if canFinish(mid, weights, D) {
			hi = mid
		} else {
			lo = mid + 1
		}
	}
	fmt.Println(lo)
	fmt.Println(hi)
	return lo

}

func canFinish(targetWeight int, weights []int, d int) bool {
	countDays := 0
	currentWeight := 0
	for _, num := range weights {
		if currentWeight+num <= targetWeight {
			currentWeight += num
		} else {
			currentWeight = num;
			countDays++
		}
	}
	if currentWeight != 0 {
		countDays++
	}
	fmt.Println(countDays)
	return countDays <= d
}

func max5(weights []int) int {
	max := 0
	for _, num := range weights {
		max += num
	}
	return max
}

func min5(weights []int) int {
	min := weights[0]
	for _, num := range weights {
		if num > min {
			min = num
		}
	}
	return min
}
