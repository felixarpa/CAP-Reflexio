printing
printOn: aStream
	aStream nextPutAll: '<-', back asString.
	super printOn: aStream.