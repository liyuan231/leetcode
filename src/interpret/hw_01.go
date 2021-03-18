package main

import (
	"fmt"
	"io/ioutil"
)

var table = [][]byte{
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
var code = []byte{'{', '}', 'a', 'c', '=', '+', '$', '*', ',', ';', '(', ')', '#'}

func init() {

}

type code_val struct {
	code byte   //单词种别
	val  []byte //单词值
}

func reverse(token []byte) byte {
	length := len(token)
l0:
	for index := range table {
		if len(table[index]) != length {
			continue
		}
		i := 0
		for i = range table[index] {
			if table[index][i] != token[i] {
				continue l0
			}
		}
		if i == length-1 {
			return code[index]
		}
	}
	return 'i'
}

func scanner(buf []byte, i *int) code_val {
	codeVal := code_val{}
	token := make([]byte, 0)
	length := len(buf)
	if buf[*i] >= 'a' && buf[*i] <= 'z' {
		for *i < length && (buf[*i] >= 'a' && buf[*i] <= 'z' || buf[*i] >= '0' && buf[*i] <= '9') {
			token = append(token, buf[*i])
			*i++
		}
		codeVal.code = reverse(token)
		//TODO 此处我先式注释掉
		if codeVal.code == 'i' {
			codeVal.val = token
		}
		return codeVal
		//处理数字 123
	} else if buf[*i] >= '0' && buf[*i] <= '9' {
		for buf[*i] >= 'a' && buf[*i] <= 'z' || buf[*i] >= '0' && buf[*i] <= '9' {
			token = append(token, buf[*i])
			*i++
		}
		//处理小数 0.3
		if buf[*i] == '.' {
			token = append(token, buf[*i])
			*i++
			for buf[*i] >= '0' && buf[*i] <= '9' {
				token = append(token, buf[*i])
				*i++
			}
			codeVal.code = 'y'
		} else {
			codeVal.code = 'x'
		}
		codeVal.val = token
		return codeVal
	}
	//实数   .123
	if buf[*i] == '.' {
		token = append(token, buf[*i])
		*i++
		if buf[*i] >= '0' && buf[*i] <= '9' {
			for buf[*i] >= '0' && buf[*i] <= '9' {
				token = append(token, buf[*i])
				*i++
			}
			codeVal.code = 'y'
			codeVal.val = token
			return codeVal
		}
		panic("Error Word " + string(token))
	}
	switch buf[*i] {
	case ',':
		codeVal.code = ','
		break
	case ';':
		codeVal.code = ';'
		break
	case '(':
		codeVal.code = '('
		break
	case ')':
		codeVal.code = ')'
		break
	case '=':
		codeVal.code = '='
		break
	case '+':
		if buf[*i+1] == '+' {
			codeVal.code = '$'
			*i++
		} else {
			codeVal.code = '+'
		}
		break
	case '*':
		codeVal.code = '*'
		break
	case '#':
		codeVal.code = '#'
		break
	default:
		panic("Error character: " + string(buf[*i]))
	}
	*i++
	return codeVal
}

//删除注释以及\n\r
func preConstruct(filePath string) []byte {
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

func main() {
	bytes := preConstruct("F:\\IdeaProjects\\leetcode\\src\\interpret\\test.txt")
	fmt.Println()
	fmt.Println(string(bytes))
	fmt.Println()
	doScan(bytes)
}

func doScan(buf []byte) {
	i := 0
	for true {
		for buf[i] == ' ' {
			i++
		}
		val := scanner(buf, &i)
		fmt.Println(string(val.code), string(val.val))
		if val.code == '#' {
			break
		}
	}
}
