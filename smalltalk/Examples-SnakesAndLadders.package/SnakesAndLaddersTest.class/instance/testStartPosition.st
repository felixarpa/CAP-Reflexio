running
testStartPosition
	self assert: eg lastPosition = 12.
	self assert: eg isNotOver.
	self assert: eg currentPlayer = jack.
	self assert: eg firstSquare isFirstSquare.
	self assert: eg firstSquare isLastSquare not.
	self assert: eg firstSquare position = 1.
	self assert: eg firstSquare isOccupied.
	self assert: (eg at: eg lastPosition) isFirstSquare not.
	self assert: (eg at: eg lastPosition) isLastSquare.
	self assert: (eg at: eg lastPosition) position = 12.
	self assert: (eg at: eg lastPosition) isOccupied not.
	self assert: jack name = 'Jack'.
	self assert: jill name = 'Jill'.
	self assert: jack position = 1.
	self assert: jill position = 1