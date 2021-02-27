package main

import (
	"fmt"
	"strconv"
)

type treeNode struct {
	left  *treeNode
	right *treeNode
	val   int
}

func create() *treeNode {
	num := -1
	fmt.Scanf("%d", &num)
	if num == -1 {
		return nil
	}
	node := treeNode{}
	node.val = num
	node.left = create()
	node.right = create()
	return &node
}

var res []string = []string{}

var tmp string = ""

func travsel(node *treeNode) []string {
	if node == nil {
		return res
	}
	//list = append(list, node.Val)
	tmp += strconv.Itoa(node.val) + "->"
	if node.left == nil && node.right == nil {
		rs := []rune(tmp)
		temp := make([]rune, len(rs)-2)
		s := string(temp)
		//tmp = tmp[0 : len(tmp)-2]
		fmt.Println(s)
		res = append(res, s)
	}
	travsel(node.left)
	travsel(node.right)
	if len(tmp) > 3 {
		tmp = tmp[0 : len(tmp)-3]
	}
	return res
}

func main() {
	root := create()
	fmt.Println(root)
	strings := travsel(root)
	fmt.Println(strings)
}
