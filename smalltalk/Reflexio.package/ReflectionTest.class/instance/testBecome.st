running
testBecome
	| pt1 pt2 pt3 |
	pt1 := 0@0.
	pt2 := pt1.
	pt3 := 100@100.
	pt1 become: pt3.
	self assert: pt1 = (100@100).
	self assert: pt1 == pt2.
	self assert: pt3 = (0@0).