playing
previousSquare
	self assert: self isFirstSquare not.
	^ board at: position - 1