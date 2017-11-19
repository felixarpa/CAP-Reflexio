initialize-release
initializeOn: aCompiledMethod
	method := aCompiledMethod.
	reference := aCompiledMethod methodReference.
	invocationCount := 0