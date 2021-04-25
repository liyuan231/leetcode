package yjy

var F_DELIMITER uint8 = 0x7E
var A_ uint8 = 0xFF

type PPP struct {
	Head head
	Data data
	Tail tail
}

type head struct {
	F uint8
	A uint8
	C uint8
}

type data struct {

}

type tail struct {
}
