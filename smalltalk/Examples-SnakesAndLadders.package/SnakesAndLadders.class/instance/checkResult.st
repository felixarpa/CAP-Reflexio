playing
checkResult
	^ self currentPlayer position = self lastPosition
		ifTrue: [
			over := true.
			' -- ', self currentPlayer asString, ' wins!'
			]
		ifFalse: [ '' ]