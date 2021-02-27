package main

import "fmt"

func main() {
	//strings := []string{"at", "", "", "", "ball", "", "", "car", "", "", "dad", "", ""}
	s1 := "TA"
	s := "tA"
	fmt.Println(s1 < s)
	//strings = []string{"DirNnILhARNS hOYIFB", "SM ", "YSPBaovrZBS", "evMMBOf", "mCrS", "oRJfjw gwuo", "xOpSEXvfI"}
	//fmt.Println(findString(strings, s))
}

func findString(words []string, s string) int {
	lo := 0
	hi := len(words) - 1
	for lo <= hi {
		mid := lo + (hi-lo)/2
		i := mid
		for words[i] == "" && mid < hi {
			mid++
		}
		if s == words[mid] {
			return mid
		} else if s < words[mid] {
			hi = mid - 1
		} else {
			lo = i + 1
		}
	}
	return -1
}
