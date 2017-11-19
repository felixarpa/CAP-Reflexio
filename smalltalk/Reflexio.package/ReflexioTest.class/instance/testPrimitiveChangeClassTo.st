running
testPrimitiveChangeClassTo
	| behavior browser |
	behavior := Behavior new.
	behavior superclass: Browser.
	behavior setFormat: Browser format.
	browser := Browser new.
	
	browser primitiveChangeClassTo: behavior new.
	behavior compile: 'thisIsATest ^ 2'.
	
	self assert: browser thisIsATest = 2.
	self should: [ Browser new thisIsATest ] raise: MessageNotUnderstood.