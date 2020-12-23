package main

func main() {
	println(addDigits(38))
}

func addDigits(num int) int {
	var num1 int = 0
	var res = 0
	for  {
		//fmt.Printf("num:%d  res:%d\r\n", num, res)
		num1 = num % 10
		res += num1
		num = num / 10
		if(num==0&&res<=9){
			return res;
		}
		if num == 0 {
			num = res
			res = 0
		}

	}
	return -1;
}
