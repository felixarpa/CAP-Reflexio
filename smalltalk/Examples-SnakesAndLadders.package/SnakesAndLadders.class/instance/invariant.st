initialize-release
invariant
	"Should also check that snakes and ladders lead to ordinary squares, and do not bounce
	past the beginning or end of the board."
	^ squares size > 1
		and: [players size > 1
		and: [turn >= 1
		and: [turn <= players size]]]