as yet unclassified
testAnswer42
	| demoClass |
	Object subclass: #Demo
		instanceVariableNames: ''
		classVariableNames: ''
		poolDictionaries: ''
		category: 'Demo'.

	demoClass := Smalltalk at: #Demo.

	self should: [demoClass new answer42] raise: MessageNotUnderstood.

	demoClass methodDict at: #answer42 put: ObjectsAsMethodsExample new.

	self assert: demoClass new answer42 = 42.

	demoClass removeFromSystem 