playing
moveWith: aDie
	| roll destination |
	self assert: self invariant.
	roll := aDie roll.
	destination := square forwardBy: roll.
	self moveTo: destination.
	^ name, ' rolls ', roll asString, ' and lands at ', square asString