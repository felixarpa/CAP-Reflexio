examples
example
	| logger |
	logger := LoggingMethodWrapper on: Integer>>#factorial.

	logger invocationCount.
	5 factorial.
	logger invocationCount.

	logger install.
	[ 5 factorial ] ensure: [logger uninstall].
	logger invocationCount.

	10 factorial.
	logger invocationCount. 	