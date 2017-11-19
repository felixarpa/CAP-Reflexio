as yet unclassified
haltIf: aSelector
	| context |
	context := thisContext.
	[context sender isNil]
		whileFalse:
			[context := context sender.
			(context selector = aSelector)
			ifTrue: [ Halt signal ] ].
