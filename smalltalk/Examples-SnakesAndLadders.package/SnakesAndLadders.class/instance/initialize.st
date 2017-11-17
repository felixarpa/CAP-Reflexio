initialize-release
initialize
	super initialize.
	die := Die new.
	squares := OrderedCollection new.
	players := OrderedCollection new.
	turn := 1.
	over := false.