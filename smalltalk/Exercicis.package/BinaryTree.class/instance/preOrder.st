accessing
preOrder
	| result |
	result := LinkedList new.
	result add: x.
	self left isNil ifFalse: [ result addAll: self left preOrder].
	self right isNil ifFalse: [ result addAll: self right preOrder].
	^ result.