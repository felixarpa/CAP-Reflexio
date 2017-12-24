printing
contents
	^ self isOccupied
		ifTrue: [ ' ', player asString ]
		ifFalse: [ '' ]