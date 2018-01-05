*Reflexio
mentreCert: aBlock
	"versió de whileTrue: implementada amb callcc:"
	| cont |
	cont := Continuation callcc: [ :cc | cc ].			
	self value 	ifTrue: [ 	aBlock value. 
						      	cont value: cont]
		 	    		ifFalse: [^ nil].
	