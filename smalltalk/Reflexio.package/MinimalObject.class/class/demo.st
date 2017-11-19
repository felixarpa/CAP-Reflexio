as yet unclassified
demo
	"Transcript closeAllViews; open.
	MinimalObject demo"
	| set minObject |
	"create subject and wrapper"
	set := Set new.	
	minObject := MinimalObject new.

	set add: 0.

	"swap the pointers"
	set become: minObject.
	set add: 1; add: 2.

	"swap the pointers"
	minObject become: set.
	set add: 3.
	set inspect.
