running
testExample
	self assert: eg currentPlayer = jack.
	loadedDie roll: 1.
	eg playOneMove.
	self assert: jack position = 6.
	self assert: eg currentPlayer = jill.
	loadedDie roll: 5.
	eg playOneMove.
	self assert: jill position = 1.
	self assert: eg currentPlayer = jack.
	loadedDie roll: 5.
	eg playOneMove.
	self assert: jack position = 5.
	self assert: eg currentPlayer = jill.
	loadedDie roll: 4.
	eg playOneMove.
	self assert: jill position = 1.
	self assert: eg currentPlayer = jack.
	loadedDie roll: 6.
	eg playOneMove.
	self assert: jack position = 5.
	self assert: eg currentPlayer = jill.
	loadedDie roll: 6.
	eg playOneMove.
	self assert: jill position = 9.
	self assert: eg currentPlayer = jack.
	loadedDie roll: 5.
	eg playOneMove.
	self assert: jack position = 10.
	self assert: eg currentPlayer = jill.
	loadedDie roll: 5.
	eg playOneMove.
	self assert: jill position = 1.
	self assert: eg currentPlayer = jack.
	loadedDie roll: 2.
	eg playOneMove.
	self assert: jack position = 12.
	self assert: eg isOver