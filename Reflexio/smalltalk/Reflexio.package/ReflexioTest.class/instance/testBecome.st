running
testBecome
	| punt1 punt2 punt3 |
	punt1 := 0@0.
	punt2 := punt1.
	punt3 := 100@100.
	punt1 become: punt3.
	self assert: punt1 = (100@100).
	self assert: punt1 == punt2.
	self assert: punt3 = (0@0).