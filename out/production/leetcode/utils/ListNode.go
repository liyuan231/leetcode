package utils

import "fmt"

type ListNode struct {
	Val  int
	Next *ListNode
}

func NewListNode(val int) *ListNode {
	return &ListNode{Val: val, Next: nil}
}

func Create() *ListNode {
	val := -1
	head := NewListNode(-1)
	p := head
	for true {
		fmt.Scanf("%d", &val)
		if val == -1 {
			return head.Next
		}
		p.Next = NewListNode(val)
		p = p.Next
	}
	panic("ERROR CREATING LISTNODE!")
}

func (self *ListNode) Show() {
	for self != nil {
		fmt.Println(self.Val)
		self = self.Next
	}
}

