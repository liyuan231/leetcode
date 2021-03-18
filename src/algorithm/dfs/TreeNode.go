package main

import (
	"fmt"
	"math"
)

type TreeNode struct {
	Left  *TreeNode
	Right *TreeNode
	Val   int
}

func create() *TreeNode {
	var num int
	_, _ = fmt.Scanf("%d", &num)
	if num == -1 {
		return nil
	}
	treeNode := TreeNode{nil, nil, num}
	treeNode.Left = create()
	treeNode.Right = create()
	return &treeNode
}

func dfs(node *TreeNode) {
	if node == nil {
		return
	}
	dfs(node.Left)
	fmt.Println(node.Val)
	dfs(node.Right)
}

func main() {
	node := create()
	//dfs(node)
	//maxDepth := maxDepth(node)
	//fmt.Println(maxDepth)
	//sum := maxPathSum(node)
	//fmt.Println(sum)
	//fmt.Println(max)
	fmt.Println(sumNumbers(node))
}

func maxDepth(root *TreeNode) int {
	return maxDepth_(root, 0)
}

func maxDepth_(node *TreeNode, currentDepth int) int {
	if node == nil {
		return currentDepth
	}
	return maxInts(maxDepth_(node.Left, currentDepth+1), maxDepth_(node.Right, currentDepth+1))
}

func maxInts(i1 int, i2 int) int {
	if i1 > i2 {
		return i1
	}
	return i2
}

var max int = math.MinInt32

func maxPathSum(node *TreeNode) int {
	if node == nil {
		return 0
	}
	left := maxPathSum(node.Left)
	right := maxPathSum(node.Right)
	if left < 0 {
		left = 0
	}
	if right < 0 {
		right = 0
	}
	max = maxInts(max, left+right+node.Val)
	return maxInts(left, right) + node.Val
}

func sumNumbers(root *TreeNode) int {
	num:=0
	sum := 0
	sumNum(root, num, &sum)
	return sum
}

func sumNum(node *TreeNode, num int, sum *int) {
	num= num*10 + node.Val
	if node.Left == nil && node.Right == nil {
		*sum += num
	}
	if node.Left != nil {
		sumNum(node.Left, num, sum)
	}
	if node.Right != nil {
		sumNum(node.Right, num, sum)
	}
}

func convert(bytes []byte) int {
	sum := 0
	for index := range bytes {
		sum = 10*sum + int(bytes[index])
	}
	return sum
}
