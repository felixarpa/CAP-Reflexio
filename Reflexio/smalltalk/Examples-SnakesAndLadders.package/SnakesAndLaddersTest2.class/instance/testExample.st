running
testExample
	self assert: jack name = 'Jack'.
	self assert: jill name = 'Jill'.
	self assert: jack position = 1.
	self assert: jill position = 1.
	self assert: eg currentPlayer = jack.
	loadedDie roll: 1.
	eg playOneMove.
	self assert: jack position = 2.
	self assert: eg currentPlayer = jill.
	loadedDie roll: 2.
	eg playOneMove.
	self assert: jill position = 7.
	self assert: eg currentPlayer = jack.
	loadedDie roll: 3.
	eg playOneMove.
	self assert: jack position = 5.
	self assert: eg currentPlayer = jill.
	loadedDie roll: 1.
	eg playOneMove.
	self assert: jill position = 7.
	self assert: eg currentPlayer = jack.
	loadedDie roll: 2.
	eg playOneMove.
	self assert: jack position = 1.
	self assert: eg currentPlayer = jill.
	loadedDie roll: 5.
	eg playOneMove.
	self assert: jill position = 12.
	self assert: eg currentPlayer = jack.
	loadedDie roll: 6.
	eg playOneMove.
	self assert: jack position = 7.
	self assert: eg currentPlayer = jill.
	loadedDie roll: 1.
	eg playOneMove.
	self assert: jill position = 13.
	self assert: eg isOver