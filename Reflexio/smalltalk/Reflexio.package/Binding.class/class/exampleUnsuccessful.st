testing
exampleUnsuccessful
	"Binding exampleUnsuccessful"

	#testingDynamicBinding bindTo: 'This is a test' in: 
	[ Transcript show: (#testingDynamikBinding binding) asString; cr. ] .