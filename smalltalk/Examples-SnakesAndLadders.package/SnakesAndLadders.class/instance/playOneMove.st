playing
playOneMove
	| result |
	self assert: self invariant.
	^ self isOver 
		ifTrue: ['The game is over!']
		ifFalse: 
			[result := (self currentPlayer moveWith: die) , self checkResult.
			self upDateTurn.
			result]