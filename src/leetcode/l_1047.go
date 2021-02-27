package main

import "fmt"

func main() {
	s:="abbaca"
	fmt.Println(removeDuplicates2(s));
}
func removeDuplicates2(S string) string {
	bytes := []byte(S)
	i := 0
	j := 0
	for j < len(bytes) {
		if i == 0 || bytes[i-1] != bytes[j] {
			bytes[i] = bytes[j]
			i++
			j++
		} else {
			i--
			j++
		}
	}
	return string(bytes[0:i])
}
