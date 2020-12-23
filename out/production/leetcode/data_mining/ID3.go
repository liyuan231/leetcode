package main

import (
	"fmt"
	"math"
)

func main() {
	strings := []string{"不买", "不买", "买", "买", "买", "不买", "买", "不买", "买", "买", "买", "买", "买", "不买"}
	count_buy := 0.0
	count_not_buy := 0.0
	for _, value := range strings {
		if value == "不买" {
			count_not_buy++
		} else {
			count_buy++
		}
	}
	p1 := count_buy / (count_buy + count_not_buy)
	fmt.Println(p1)
	p0 := count_not_buy / (count_buy + count_not_buy)
	fmt.Println(p0)
	i := -p1 * math.Log2(p1) + -p0 *math.Log2(p0)
	fmt.Printf("信息熵:%f",i)

}
