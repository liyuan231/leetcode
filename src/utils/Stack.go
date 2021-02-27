package utils

type Stack struct {
	size int
	data []int
}

func NewStack() *Stack {
	return &Stack{data: make([]int, 10)}
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

func (self *Stack) Pop() int {
	tmp := self.data[self.size-1]
	self.size--
	return tmp
}
