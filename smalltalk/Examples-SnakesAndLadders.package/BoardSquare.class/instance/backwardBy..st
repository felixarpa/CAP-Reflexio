playing
backwardBy: squares 
	^ squares = 0 
		ifTrue: [self destination]
		ifFalse: 
			[self isFirstSquare 
				ifTrue: [self nextSquare forwardBy: squares - 1]
				ifFalse: [self previousSquare backwardBy: squares - 1]]