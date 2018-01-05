as yet unclassified
uniqueInstance
	"get the unique instance of this class"
	uniqueInstance isNil
		ifTrue: [ uniqueInstance := self basicNew initialize ].
	^ uniqueInstance