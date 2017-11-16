arithmetic
+ unaPasta
	^ self moneda = unaPasta moneda
		ifTrue: [ Pasta moneda: self moneda quantitat: ( self quantitat + unaPasta quantitat ) ]
		ifFalse: [ self error: 'No es poden usar monedes diferents' ]