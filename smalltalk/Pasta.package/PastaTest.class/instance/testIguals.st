as yet unclassified
testIguals
	self assert: eur5 = eur5 .
	self assert: eur5 = (Pasta new moneda: 'EUR'; quantitat: 5).
	self assert: eur5 ~= eur10.