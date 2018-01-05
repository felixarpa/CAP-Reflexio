printing
printOn: aStream
	squares do: [:each | each printOn: aStream].