package main

import "fmt"

type Stack struct {
	size int
	data []int
}

func NewStack() *Stack {
	return &Stack{data: make([]int, 1)}
}

func (self *Stack) Push(e int) {
	//扩容
	if self.size == len(self.data) {
		tmp := make([]int, 2*self.size)
		for i, e := range self.data {
			tmp[i] = e
		}
		self.data = tmp
	}
	self.data[self.size] = e
	self.size++
}
func (self *Stack) Empty() bool {
	return self.size == 0
}

func (self *Stack) Pop() int {
	if self.Empty() {
		panic("stack is null!")
	}
	tmp := self.data[self.size-1]
	self.size--
	return tmp
}

func (self *Stack) Peek() int {
	if self.Empty() {
		panic("stack is empty!")
	}
	return self.data[self.size-1]
}

func dailyTemperatures(nums []int) []int {
	stack := NewStack()
	res := make([]int, len(nums))
	for i := len(nums) - 1; i >= 0; i-- {
		if stack.Empty() {
			stack.Push(i)
			continue
		}
		for !stack.Empty() && nums[i] >= nums[stack.Peek()] {
			stack.Pop()
		}
		if stack.Empty() {
			res[i] = 0
		} else {
			res[i] = stack.Peek() - i
		}
		stack.Push(i)
	}
	return res
}

func asteroidCollision(asteroids []int) []int {
	stack := NewStack()
	for index, num := range asteroids {
		if num > 0 {
			stack.Push(index)
		} else {
			for !stack.Empty() && asteroids[stack.Peek()] > 0 && asteroids[stack.Peek()] < num*-1 {
				stack.Pop()
			}
			if !stack.Empty() && asteroids[stack.Peek()] == (num*-1) {
				stack.Pop()
			} else if stack.Empty() || asteroids[stack.Peek()] < 0 {
				stack.Push(index)
			}
		}
	}
	res := make([]int, stack.size)
	for i := 0; i < stack.size; i++ {
		res[i] = asteroids[stack.data[i]]
	}
	return res
}

func isValid(s string) bool {
	stack := NewStack()
	for _, c := range s {
		if c == '(' || c == '[' || c == '{' {
			stack.Push(int(c))
		} else {
			if stack.Empty() || (stack.Peek() != opposite(int(c))) {
				return false
			}
			stack.Pop()
		}
	}
	return stack.Empty()
}

func opposite(c int) int {
	switch c {
	case ')':
		{
			return '('
		}
	case ']':
		{
			return '['
		}
	case '}':
		{
			return '{'
		}
	}
	panic("invalid character")
}

func nextGreaterElement(nums1 []int, nums2 []int) []int {
	var m = make(map[int]int)
	stack := NewStack()
	for i := len(nums2) - 1; i >= 0; i-- {
		for !stack.Empty() && nums2[i] > nums2[stack.Peek()] {
			stack.Pop()
		}
		if !stack.Empty() {
			m[nums2[i]] = nums2[stack.Peek()]
		}
		stack.Push(i)
	}
	for i, num := range nums1 {
		tmp, state := m[num]
		if state {
			nums1[i] = tmp
		} else {
			nums1[i] = -1
		}
	}
	return nums1
}
func nextGreaterElements(nums []int) []int {
	stack := NewStack()
	res := make([]int, len(nums))
	length := len(nums)
	for i := 2*len(nums) - 1; i >= 0; i-- {
		t := i % length
		for !stack.Empty() && nums[t] >= nums[stack.Peek()] {
			stack.Pop()
		}
		if stack.Empty() {
			stack.Push(t)
			res[t] = -1
		} else {
			res[t] = stack.Peek()
			stack.Push(t)
		}
	}
	for index, _ := range res {
		if res[index] != -1 {
			res[index] = nums[res[index]]
		}
	}
	return res
}

func main() {

	//stack.Push(1)
	//stack.Push(2)
	//fmt.Println(stack.Pop())
	//fmt.Println(stack.Pop())
	//nums := []int{73, 74, 75, 71, 69, 72, 76, 73}
	//nums = []int{89, 62, 70, 58, 47, 47, 46, 76, 100, 70}
	//res := dailyTemperatures(nums)
	//fmt.Println(res)
	//nums := []int{5, 10, -5}
	//nums = []int{11, 8, 2, -5, -8, 3}
	//nums = []int{8, -8}
	//nums = []int{-2, -1, 1, 2}
	//res := asteroidCollision(nums)
	//fmt.Println(res)
	//fmt.Println(isValid("]"))
	//nums1 := []int{4, 1, 2}
	//nums2 := []int{1, 3, 4, 2}
	//nums1 = []int{2, 4}
	//nums2 = []int{1, 2, 3, 4}
	//fmt.Println(nextGreaterElement(nums1, nums2))
	nums := []int{3, 8, 4, 1, 2}
	nums = []int{1, 2, 1}
	fmt.Println(nextGreaterElements(nums))
}
