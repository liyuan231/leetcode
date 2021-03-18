package main

import "fmt"

func main() {
	nums := []int{0, 2, 1, 0}
	nums = []int{0, 1, 0}
	fmt.Println(peakIndexInMountainArray(nums))
}

func peakIndexInMountainArray(arr []int) int {
	lo := 0
	hi := len(arr) - 1

	for lo < hi {
		mid := (lo-hi)/2 + hi
		num := arr[mid]
		if num > arr[mid-1] {
			lo = mid
		} else {
			hi = mid - 1
		}
	}
	fmt.Println(lo)
	fmt.Println(hi)
	return lo
}
