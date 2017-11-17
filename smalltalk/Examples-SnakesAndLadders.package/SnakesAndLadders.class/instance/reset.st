initialize-release
reset
	die := Die new.
	turn := 1.
	over := false.
	players do: [:each | each moveTo: self firstSquare ].
	self assert: self invariant.