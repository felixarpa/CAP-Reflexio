error-handling
doesNotUnderstand: aMessage 
	| messageName |
	messageName := aMessage selector asString.
	(self class instVarNames includes: messageName)
		ifTrue: [self class compile: messageName , String cr , ' ^ ' , messageName.
			^ aMessage sendTo: self].
	super doesNotUnderstand: aMessage