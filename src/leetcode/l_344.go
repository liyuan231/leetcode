package main

import "fmt"

func main() {
	//fmt.Println(11)
	reverseString([]byte("liyuan"))
}

func reverseString(s []byte) {
	fmt.Println(s)
	var tmp byte = 0
	length := len(s)
	i := 0
	j := length - 1
	for  i < j {
		tmp = s[i]
		s[i] = s[j]
		s[j] = tmp
		i++;j--;
	}
	fmt.Println(s)
}
