running
testCallCount
	"Transcript closeAllViews; open"
	| set minObject |
	"create subject and wrapper"
	set := Set new.	
	minObject := MinimalObject new.

	set add: 0.
	self assert: minObject MOcalls = 0.

	"swap the pointers"
	set become: minObject.
	set add: 1; add: 2.
	self assert: set MOcalls = 2.

	"swap the pointers"
	minObject become: set.
	set add: 3.
	self assert: minObject MOcalls = 2.
