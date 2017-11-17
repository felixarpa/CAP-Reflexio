playing
nextSquare
	self assert: self isLastSquare not.
	^ board at: position + 1