running
testPreOrder
	| t0 t1 t2 t3 t4 t5 t6 expected |
	t6 := BinaryTree new x: 6.
	t5 := BinaryTree new x: 5.
	t4 := BinaryTree new x: 4.
	t3 := BinaryTree new x: 3.

	t2 := BinaryTree new x: 2; left: t5; right: t6.
	t1 := BinaryTree new x: 1; left: t3; right: t4.

	t0 := BinaryTree new x: 0; left: t1; right: t2.

	expected := LinkedList new addAll: #(0 1 3 4 2 5 6).
	
	self assert: t0 preOrder = expected.