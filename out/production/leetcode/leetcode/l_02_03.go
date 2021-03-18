package main

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

func (self *ListNode) show() {
	for self != nil {
		fmt.Println(self.Val)
		self = self.Next
	}
}

func main() {
	node := Create()
	//deleteNode(node)
	//fmt.Println(kthToLast(node, 2))
	//fmt.Println(hasCycle(node))
	m := -1
	n := -1
	fmt.Scanf("%d %d", &m, &n)
	between := reverseBetween(node, m, n)
	for between != nil {
		fmt.Printf("%d->", between.Val)
		between = between.Next
	}

}

func deleteNode(node *ListNode) {
	pre := node
	for node.Next != nil {
		//fmt.Println(node.Val)
		node.Val = node.Next.Val
		pre = node
		node = node.Next
	}
	//node.Val = node.Next.Val

	//node = nil
	pre.Next = nil
	//fmt.Println(pre)
}

func kthToLast(head *ListNode, k int) int {
	slow := head
	fast := head
	for k != 0 {
		fast = fast.Next
		k--
	}
	for fast != nil {
		slow = slow.Next
		fast = fast.Next
	}
	return slow.Val
}

func reverseList(head *ListNode) *ListNode {
	if head == nil || head.Next == nil {
		return head
	}
	reversed_head := reverseList(head.Next)
	head.Next.Next = head
	head.Next = nil
	return reversed_head
}

func hasCycle(head *ListNode) bool {
	slow := head
	fast := head
	for fast != nil && fast.Next != nil {
		slow = slow.Next
		fast = fast.Next.Next
		if fast == slow {
			return true
		}
	}
	return false
}

func reverseBetween(head *ListNode, m int, n int) *ListNode {
	tmp := head
	var p1 *ListNode = head
	var p11 *ListNode = head
	var p2 *ListNode = head
	var p22 *ListNode = head
	for i := 1; i < m; i++ {
		p1 = p2
		p2 = p2.Next
	}
	for i := 0; i < n; i++ {
		p22 = p11
		p11 = p11.Next
	}
	//fmt.Println(p1)
	//fmt.Println(p2)
	//fmt.Println(p22)
	//fmt.Println(p11)

	if p1 != tmp {
		p1.Next = nil
	}
	if p2.Next != nil {
		p22.Next = nil
	}
	reverse(p2)


	p1.Next = p22
	p2.Next = p11
	if p11 == nil ||p1 == p2{
		return p22
	}
	//从第一个节点开始倒转
	return tmp
}

func reverse(p2 *ListNode) {
	if p2 == nil || p2.Next == nil {
		return
	}
	reverse(p2.Next)
	p2.Next.Next = p2
}
