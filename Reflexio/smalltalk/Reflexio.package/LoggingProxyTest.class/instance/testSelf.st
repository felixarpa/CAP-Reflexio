running
testSelf
	| point |
	point := 1@2.
	LoggingProxy new become: point.
	self assert: point invocationCount = 0.
	self assert: (point rect: (3@4)) area = 4.
	"rect: does two self-sends"
	"oops -- self sends are not intercepted"
	self deny: point invocationCount = 4.
