running
testBecomeForward
	| pt1 pt2 pt3 |
	pt1 := 0@0.
	pt2 := pt1.
	pt3 := 100@100.
	pt1 becomeForward: pt3.
	self assert: pt1 = (100@100).
	self assert: pt1 == pt2.
	self assert: pt2 == pt3.
