running
testDelegation
	| point |
	point := 1@2.
	LoggingProxy new become: point.
	self assert: point invocationCount = 0.
	self assert: point + (3@4) = (4@6).
	self assert: point invocationCount = 1.