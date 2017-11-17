playing
landHere: aPlayer
	^ self isOccupied
		ifTrue: [ board firstSquare landHere: aPlayer ]
		ifFalse: [ player := aPlayer. self ]