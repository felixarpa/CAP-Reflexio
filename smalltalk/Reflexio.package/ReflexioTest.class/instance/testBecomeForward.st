running
testBecomeForward
	| punt1 punt2 punt3 |
	punt1 := 0@0.
	punt2 := punt1.
	punt3 := 100@100.
	punt1 becomeForward: punt3.
	self assert: punt1 = (100@100).
	self assert: punt1 == punt2.
	self assert: punt2 == punt3.