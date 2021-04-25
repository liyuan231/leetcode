package main

import (
	"fmt"
	"io/ioutil"
)

var table1 = [][]byte{
	{'b', 'e', 'g', 'i', 'n'},
	{'e', 'n', 'd'},
	{'i', 'n', 't', 'e', 'g', 'e', 'r'},
	{'r', 'e', 'a', 'l'},
	{'='},
	{'+'},
	{'+', '+'},
	{'*'},
	{','},
	{';'},
	{'('},
	{')'},
	{'#'},
}
var code1 = []byte{'{', '}', 'a', 'c', '=', '+', '$', '*', ',', ';', '(', ')', '#'}

//状态转换矩阵
var M = [][]int{
	{1, 2, 3, 4, 5, 6, 7, 8, 9, 10},
	{11, 11, 0, 0, 0, 0, 0, 0, 0, 0},
	{0, 12, 0, 0, 0, 0, 0, 0, 0, 0},
	{0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
	{0, 0, 0, 13, 0, 0, 0, 0, 0, 0},
	{0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
	{0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
	{0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
	{0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
	{0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
	{0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
	{11, 11, 0, 0, 0, 0, 0, 0, 0, 0},
	{0, 12, 0, 0, 0, 0, 0, 0, 0, 0},
	{0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
}
var col_char = []byte{'a', '0', '=', '+', '*', ',', ';', '(', ')', '#', '\\', ' '}

type codeVal struct {
	code byte
	val  []byte
}

func searchTable(token []byte) byte {
	length := len(token)
l0:
	for index := range table1 {
		if len(table1[index]) != length {
			continue
		}
		i := 0
		for i = range table1[index] {
			if table1[index][i] != token[i] {
				continue l0
			}
		}
		if i == length-1 {
			return code1[index]
		}
	}
	return 255
}
func col(c byte, str []byte) int {
	if c >= 'a' && c <= 'z' {
		c = 'a'
	}
	if c >= '0' && c <= '9' {
		c = '0'
	}
	for i := 0; i < len(str); i++ {
		if c == str[i] {
			return i
		}
	}
	panic("Invalid character: " + string(c))
}
func scan(buf []byte, i *int) codeVal {
	//从i位置开始读取，依照状态转换图，状态转换矩阵进行映射查询
	cv := codeVal{}
	token := make([]byte, 0)
	s := 0
	//j := col(buf[*i], col_char) //字符转换成序列号
	j := -1
	for true {
		j = col(buf[*i], col_char)
		s = M[s][j]
		if s == 0 {
			break
		}
		token = append(token, buf[*i])
		*i++
		if *i == len(buf) || buf[*i] == '#' || buf[*i] == ' ' {
			break
		}
	}
	cv.code = searchTable(token)
	if cv.code == 255 {
		if token[0] >= 'a' && token[0] <= 'z' {
			cv.code = 'i'
		} else {
			cv.code = 'x'
		}
		cv.val = token
	}
	return cv
}
func preConstruct2(filePath string) []byte {
	bytes, err := ioutil.ReadFile("F:\\IdeaProjects\\leetcode\\src\\interpret\\test.txt")
	if err != nil {
		panic(err)
	}
	fmt.Println(string(bytes))
	stringFlag := false
	j := 0
	size := len(bytes)
	for i := 0; i < size; i++ {
		if i > 0 && bytes[i] == ' ' && bytes[i-1] == ' ' {
			continue
		}
		if bytes[i] == '"' {
			stringFlag = !stringFlag
		}
		if !stringFlag {
			//第一类注释 //xxxx\n 遇到换行符结束
			if i < size-1 && bytes[i] == '/' && bytes[i+1] == '/' {
				i++
				for bytes[i] != '\r' {
					i++
				}
				i++
			} else if i < size-3 && bytes[i+1] == '*' && bytes[i+2] == '*' && bytes[i] == '/' {
				//第三类注释 /**xxxx**/
				i = i + 3
				for bytes[i+2] != '/' && bytes[i+1] != '*' && bytes[i] != '*' {
					i++
				}
				i = i + 4
			} else if i < size-2 && bytes[i] == '/' && bytes[i+1] == '*' {
				//第二类注释，/*xxx*/
				i = i + 2
				for bytes[i] != '*' && bytes[i+1] != '/' {
					i++
				}
				i = i + 2
			}
		}
		bytes[j] = bytes[i]
		j++
	}
	for i := 0; i <= j; i++ {
		if bytes[i] == '\n' || bytes[i] == '\r' {
			bytes[i] = ' '
		}
	}
	k := 0
	for i := 0; i < j; i++ {
		if i > 0 && bytes[i] == ' ' && bytes[i-1] == ' ' {
			continue
		}
		bytes[k] = bytes[i]
		k++
	}
	bytes[k] = '#'
	if bytes[0] == ' ' {
		return bytes[1 : k+1]
	}
	return bytes[:k+1]
}
func doScan2(buf []byte) {
	i := 0
	for true {
		for buf[i] == ' ' {
			i++
		}
		val := scan(buf, &i)
		fmt.Println(string(val.code), string(val.val))
		if val.code == '#' {
			break
		}
	}
}

func main() {
	bytes := preConstruct2("F:\\IdeaProjects\\leetcode\\src\\interpret\\test.txt")
	fmt.Println()
	fmt.Println(string(bytes))
	fmt.Println()
	doScan2(bytes)
}
