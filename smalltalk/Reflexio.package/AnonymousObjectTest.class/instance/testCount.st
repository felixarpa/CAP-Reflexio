running
testCount
	"Transcript closeAllViews; open"
	| set anonClass |
	set := Set new.
	self assert: set size = 0.

	anonClass := Behavior new.
	anonClass superclass: Set;
		setFormat: Set format;
		methodDictionary: MethodDictionary new.
	
	"anonClass compile: 'class ^ super class superclass'. doesn't work since class is inlined"
	anonClass compile: 'add: anObject Transcript show: ''adding '', anObject printString; cr. ^ super add: anObject'.
	
	self assert: set class = Set.
	self assert: set size = 0.

	set add: 1.
	self assert: set size = 1.
	
	set primitiveChangeClassTo: anonClass new.
	
	self assert: set class ~= Set. 				":-(" 
	set add: 2.
	self assert: set size = 2.
