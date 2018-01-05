playing
forwardBy: squares
	self assert: self invariant.
	^ squares = 0 
		ifTrue: [self destination]
		ifFalse: 
			[self isLastSquare 
				ifFalse: [self nextSquare forwardBy: squares - 1]
				ifTrue: [self previousSquare backwardBy: squares - 1]]