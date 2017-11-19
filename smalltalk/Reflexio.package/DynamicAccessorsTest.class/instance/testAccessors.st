running
testAccessors
	self deny: (DynamicAccessors methodDict keys includes: #x).
	self assert: DynamicAccessors new x = nil.
	self assert: (DynamicAccessors methodDict keys includes: #x).