printing
printOn: aStream
	aStream nextPutAll: '[', position printString, self contents, ']'.