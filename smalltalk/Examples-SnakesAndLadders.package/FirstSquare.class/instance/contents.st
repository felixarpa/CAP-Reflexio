printing
contents
	^ players inject: '' into:
			[ :list :each | list , ' ', each asString ]