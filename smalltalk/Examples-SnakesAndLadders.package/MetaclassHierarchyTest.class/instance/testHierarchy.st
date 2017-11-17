running
testHierarchy
	"The class hierarchy"
	self assert: SnakeSquare superclass = BoardSquare.
	self assert: BoardSquare superclass = Object.
	self assert: Object superclass superclass = nil.
	"The parallel metaclass hierarchy"
	self assert: SnakeSquare class name = 'SnakeSquare class'.
	self assert: SnakeSquare class superclass = BoardSquare class.
	self assert: BoardSquare class superclass = Object class.
	self assert: Object class superclass superclass = Class.
	self assert: Class superclass = ClassDescription.
	self assert: ClassDescription superclass = Behavior.
	self assert: Behavior superclass = Object.
	"The Metaclass hierarchy"
	self assert: SnakeSquare class class = Metaclass.
	self assert: BoardSquare class class = Metaclass.
	self assert: Object class class = Metaclass.
	self assert: Class class class = Metaclass.
	self assert: ClassDescription class class = Metaclass.
	self assert: Behavior class class = Metaclass.
	self assert: Metaclass superclass = ClassDescription.
	"The fixpoint"
	self assert: Metaclass class class = Metaclass