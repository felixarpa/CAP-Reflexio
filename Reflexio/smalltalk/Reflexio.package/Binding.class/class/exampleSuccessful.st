testing
exampleSuccessful
	"Binding exampleSuccessful"

	#testingDynamicBinding bindTo: 'This is a test' in: 
		[ Transcript show: (#testingDynamicBinding binding) asString; cr. ] .